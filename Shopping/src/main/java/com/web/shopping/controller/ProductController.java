package com.web.shopping.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.shopping.domain.BuyerVO;
import com.web.shopping.domain.CartVO;
import com.web.shopping.domain.CategoryVO;
import com.web.shopping.domain.ProductVO;
import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.pageutil.PageMaker;
import com.web.shopping.service.BuyerService;
import com.web.shopping.service.ProductService;
import com.web.shopping.service.SellerService;
import com.web.shopping.util.MediaUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping(value = "/")
public class ProductController {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	@Autowired
	private SellerService sellerService;
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	// 제품등록 
	@GetMapping("seller/product_register")
	public void registerGet(Model model) throws Exception {
		LOGGER.info("product registerGet() 호출");
		LOGGER.info("uploadGet() 호출 : " + uploadPath);
		
		List<CategoryVO> category = null; 
		category = productService.category(); // sellerService 로 해야 하나 ?? 
		model.addAttribute("category", JSONArray.fromObject(category));

	}
	
	@PostMapping("seller/product_register")
	public String registerPOST(ProductVO vo, MultipartFile[] files, RedirectAttributes reAttr, HttpServletRequest req) throws Exception {
		// RedirectAttributes : 재경로 위치에 속성값을 전송하는 객체
		LOGGER.info("product registerPOST() 호출");
		LOGGER.info(vo.toString());
		HttpSession session = req.getSession();
		SellerVO svo = (SellerVO) session.getAttribute("seller");
		String sID = svo.getsID();
		
		for (int i = 0; i < files.length; i++) {

			files[i].getOriginalFilename();
			if (i == 0) {
				String saveName = sID + "_product_img1_" + files[0].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("상품 메인사진 저장 성공");

				} catch (IOException e) {
					LOGGER.error("상품 메인사진 저장 실패");
				}
				vo.setpIMG1(saveName);
			}
			
			

			if (i == 1) {
				String saveName = sID + "_product_img2_" + files[1].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("상품 사진1 저장 성공");

				} catch (IOException e) {
					LOGGER.error("상품 사진1 저장 실패");
				}
				vo.setpIMG2(saveName);
			}
			
			if (i == 2) {
				String saveName = sID + "_product_img3_" + files[2].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("상품 사진2 저장 성공");

				} catch (IOException e) {
					LOGGER.error("상품 사진2 저장 실패");
				}
				vo.setpIMG3(saveName);
			}
			
			if (i == 3) {
				String saveName = sID + "_product_detail_" + files[3].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("상품상세 저장 성공");

				} catch (IOException e) {
					LOGGER.error("상품상세 저장 실패");
				}
				vo.setpDETAIL(saveName);
			}
			
		}
		
		int result = productService.create(vo);
		
		if (result == 1) { // DB insert 성공
			return "redirect:/seller/product_list?sID=" + sID;
		} else { // DB insert 실패
			return "redirect:/seller/product/register";
		}
	}
	
	// --------------------------------------------------------------------------------------
	
	// seller 제품 리스트 
	@GetMapping(value={"seller/product_list"})
	public void myProductList(@RequestParam("sID") String sID, Model model, Integer page, Integer perPage,  HttpServletRequest req ) {
		
		LOGGER.info("seller product list 호출");
		LOGGER.info("page = " + page + ", perpage = " + perPage);
		LOGGER.info("@RequestParam(\"sID\") String sID : " + sID);
		
		// paging 처리  
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) { 
			criteria.setNumsPerPage(perPage);
		}
		
		List<ProductVO> list = productService.read(criteria);
		List<ProductVO> mylist = productService.productread(sID);
		model.addAttribute("sellerProductList", mylist);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(productService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
	}
	
	// --------------------------------------------------------------------------------------------
	
	// seller 제품 디테일  
	@GetMapping(value={"seller/product_detail", "admin/product_detail"})
	public void productDetailGET(String pID, Model model, @ModelAttribute("page") int page ) {
		LOGGER.info("product detail() 호출 : pID = " + pID);
		ProductVO vo = productService.read(pID);
		model.addAttribute("ProductVO", vo);
		
	}
	
	// --------------------------------------------------------------------------------------------
	
	@GetMapping("seller/product_update")
	public void updateGET(String pID, Model model, @ModelAttribute("page") int page) {
		LOGGER.info("product update() 호출 : pID = " + pID);
		ProductVO vo = productService.read(pID);
		model.addAttribute("productVO", vo);
	}
	
	@PostMapping("seller/product_update")
	public String updatePOST(String pID, ProductVO vo, int page, MultipartFile[] files, HttpServletRequest req) {
		LOGGER.info("product updatePOST() 호출 : pID = " + vo.getpID());
		ProductVO pvo = productService.read(pID);
		HttpSession session = req.getSession();
		SellerVO svo = (SellerVO) session.getAttribute("seller");
		String sID = svo.getsID();
		
		for (int i = 0; i < files.length; i++) {

			files[i].getOriginalFilename();
			if (i == 0) {
				if (files[0].getOriginalFilename() != "") {
				String saveName = vo.getpID() + "_product_img1_" + files[0].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("상품 메인사진 저장 성공");

				} catch (IOException e) {
					LOGGER.error("상품 메인사진 저장 실패");
				}
				vo.setpIMG1(saveName);
			} else { 
				String saveName = pvo.getpIMG1();
				vo.setpIMG1(saveName);
			}
			}
			

			if (i == 1) {
				if (files[1].getOriginalFilename() != "") {
				String saveName = vo.getpID() + "_product_img2_" + files[1].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("상품 사진1 저장 성공");

				} catch (IOException e) {
					LOGGER.error("상품 사진1 저장 실패");
				}
				vo.setpIMG2(saveName);
			}
			} else {
				String saveName = pvo.getpIMG2();
				vo.setpIMG2(saveName);
			}
			
			if (i == 2) {
				if (files[2].getOriginalFilename() != "") {
				String saveName = vo.getpID() + "_product_img3_" + files[2].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("상품 사진2 저장 성공");

				} catch (IOException e) {
					LOGGER.error("상품 사진2 저장 실패");
				}
				vo.setpIMG3(saveName);
			}
			} else {
				String saveName = pvo.getpIMG3();
				vo.setpIMG3(saveName);
			}
			
			if (i == 3) {
				if (files[3].getOriginalFilename() != "") {
				String saveName = vo.getpID() + "_product_detail_" + files[3].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("상품상세 저장 성공");

				} catch (IOException e) {
					LOGGER.error("상품상세 저장 실패");
				}
				vo.setpDETAIL(saveName);
			}
			} else {
				String saveName = pvo.getpDETAIL();
				vo.setpDETAIL(saveName);
			}
			
		}
		
		int result = productService.update(vo);
		if (result == 1) {
			return "redirect:/seller/product_list?sID=" + sID + "&page=" + page;
		} else {
			return "redirect:/seller/product_update?pID=" + pID + "&page=" + page;
		}
		
	}
	
	// ------------------------------------------------------------------------------------------
	
	// 등록 제품 삭제 
	@GetMapping("seller/product_delete")
	public String delete(String pID, int page, HttpServletRequest req) {
		
		
		LOGGER.info("product delete() 호출 : pID = " + pID);
		HttpSession session = req.getSession();
		SellerVO svo = (SellerVO) session.getAttribute("seller");
		String sID = svo.getsID();
		LOGGER.info("delete() 호출 : sID = " + sID);
		
		int result = productService.delete(pID);
		if(result == 1) {
			return "redirect:/seller/product_list?sID=" + sID;
		} else {
			return "redirect:/seller/product_update?pID=" + pID + "&page=" + page;
		}
	}
	
	// ------------------------------------------------------------------------------------------
	
	// buyer product list  
	@GetMapping(value = {"buyer/product_list"})
	public void buyerproductlist(Model model, Integer page, Integer perPage, HttpServletRequest req) {
		LOGGER.info("buyer product list 호출");
		LOGGER.info("page = " + page + ", perPage = " + perPage);
		
		// Paging 처리
				PageCriteria criteria = new PageCriteria();
				if (page != null) {
					criteria.setPage(page);
				}
				if (perPage != null) {
					criteria.setNumsPerPage(perPage);
				}
				
				List<ProductVO> list = productService.read(criteria);
				model.addAttribute("buyerProductList", list);
				
				PageMaker maker = new PageMaker();
				maker.setCriteria(criteria);
				maker.setTotalCount(productService.getTotalNumsOfRecords());
				maker.setPageData();
				model.addAttribute("pageMaker", maker);
				
	}
	
	// -----------------------------------------------------------------------------------------
	
	// 이미지 출력
		@GetMapping("display")
		public ResponseEntity<byte[]> display(String fileName) throws IOException {
			LOGGER.info("display() 호출");

			ResponseEntity<byte[]> entity = null;
			InputStream in = null;

			String filePath = uploadPath + fileName;
			in = new FileInputStream(filePath);

			// 파일 확장자
			String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
			LOGGER.info(extension);
			// 응답 헤더(response header)에 Content-Type 설정
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaUtil.geMediaType(extension));

			// 데이터 전송
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), // 파일에서 읽은 데이터
					httpHeaders, // 응답 헤더
					HttpStatus.OK);
			return entity;
		}
		
		// ------------------------------------------------------------------------------
		
		// 제품 디테일 
		@GetMapping(value = { "seller/product_detail", "buyer/product_detail"})
		public void detailGet(String pID, Model model, @ModelAttribute("page") int page, HttpSession session) { 
			LOGGER.info("product detail() 호출 : pID = " + pID);
			ProductVO vo = productService.read(pID);
			BuyerVO bvo = (BuyerVO) session.getAttribute("buyer");
			
			LOGGER.info("ProductVO : " + vo.toString());
			
			model.addAttribute("productVO", vo);
			model.addAttribute("buyerVO", bvo);
		}
		
	// --------------------------------------------------------------------------------
		
		@GetMapping(value="buyer/cartAdd")
		public void addCartGET() {
			LOGGER.info("addCartGET() 호출");
		}
		
		// 카드 담기  
		@PostMapping(value="buyer/cartAdd")
		public String addCartPOST(CartVO vo, HttpSession session, RedirectAttributes reAttr) throws Exception {
			LOGGER.info("addCartPOST() 호출");
			LOGGER.info("받아욘 CartVO : " + vo.toString());
			
			BuyerVO bvo = (BuyerVO) session.getAttribute("buyer");
			LOGGER.info(bvo.toString());
			String bID = bvo.getbID();
			LOGGER.info("bID = " + bID);

			
			int result = productService.create(vo);
			if (result == 1) {
				reAttr.addFlashAttribute("insert_result", "success");
				return "redirect:/buyer/cartAdd?bID=" + vo.getbID(); 
			} else {
				reAttr.addFlashAttribute("insert_result", "fail");
				return "redirect:/buyer/cartAdd?bID=" + vo.getbID(); 
			}
			
		}
		
   // --------------------------------------------------------------------------------------
		
		// 카트 리스트 
		@GetMapping(value = {"buyer/cartList"})
		public void cartList(@RequestParam("cID") String cID, Model model, HttpServletRequest req, Integer page, Integer perPage) {
			LOGGER.info("cart list 호출");
			LOGGER.info("String cID : " + cID);
			
			
			
		}
		
} // end productController 

package Word;

public class WordVO {
	
		
		// 멤버 변수(필드, 프로퍼티) 
		private int no;
		private String word; 
		private String mean; 


		
		// 기본 생성자  
		
		public WordVO() {} 
		
		public WordVO(int no, String word, String mean) {
			this.no = no;
			this.word = word;
			this.mean = mean;
		}
		
		
		// getter/ setter 메소드 
		public int getNo() {
			return no;
		}


		public void setNo(int no) {
			this.no = no;
		}
		
		
		public String getWord() {
			return word;
		}


		public void setWord(String word) {
			this.word = word;
		}


		public String getMean() {
			return mean;
		}


		public void setMean(String mean) {
			this.mean = mean;
		}

		

		@Override
		public String toString() { 
			String str = "번호 : " + no + "\n"
					+ "단어 : " + word + "\n"
					+ "뜻 : " + mean + "\n\n";
			return str;
		}

	} // END ---------------------------------



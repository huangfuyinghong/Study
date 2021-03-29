package Word;

public class WordVO {
	
		
		// ��� ����(�ʵ�, ������Ƽ) 
		private int no;
		private String word; 
		private String mean; 


		
		// �⺻ ������  
		
		public WordVO() {} 
		
		public WordVO(int no, String word, String mean) {
			this.no = no;
			this.word = word;
			this.mean = mean;
		}
		
		
		// getter/ setter �޼ҵ� 
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
			String str = "��ȣ : " + no + "\n"
					+ "�ܾ� : " + word + "\n"
					+ "�� : " + mean + "\n\n";
			return str;
		}

	} // END ---------------------------------



package kr.co.dto;

public class DictionaryDTO {
	private int dicNo;
	private String word;
	private String emotion;
	private int point;
	private int RNUM;
	
	
	public int getDicNo() {
		return dicNo;
	}
	public void setDicNo(int dicNo) {
		this.dicNo = dicNo;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getRNUM() {
		return RNUM;
	}
	public void setRNUM(int rNUM) {
		RNUM = rNUM;
	}
	@Override
	public String toString() {
		return "DictionaryDTO [dicNo=" + dicNo + ", word=" + word + ", emotion=" + emotion + ", point=" + point
				+ ", RNUM=" + RNUM + "]";
	}
	
	
	
	
	
}

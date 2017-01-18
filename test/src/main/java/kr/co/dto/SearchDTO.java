package kr.co.dto;

public class SearchDTO {
	private String word;
	private String searchCondition;
	
	public String getWord(){
		return word;
	}
	public void setWord(String word){
		this.word = word;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
}

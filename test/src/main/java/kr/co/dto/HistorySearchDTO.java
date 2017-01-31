package kr.co.dto;

public class HistorySearchDTO {


	private String time;
	private String emotion;
	private int value;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public int getValue() {
		return value; 
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "HistorySearchDTO [time=" + time + ", emotion=" + emotion + ", value=" + value + "]";
	}

	
}


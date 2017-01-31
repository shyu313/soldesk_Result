package kr.co.dto;

public class MediaDTO {
	
	private int lyricsNo;				// 가사 번호 
	private String title;					// 가사 제목
	private String singer;				// 가수
	private String url;					// 유투브 주소
	private String bpm;					// 진동수
	private int playCnt;					// 플레이 횟수
	private int recCnt;					// 추천 횟수
	private String lyrics;				// 가사
	private int happy;					// 기쁨
	private int sad;						// 슬픔
	private int disgust;					// 혐오
	private int interest;					// 흥미
	private int pain;						// 고통
	private int fear;						// 무서움
	private int rage; 					// 분노 
	private int RNUM;				// 조회 결과 순서
	private String emotion;		// 대표 감정
	
	public MediaDTO() {
	}
	public int getLyricsNo() {
		return lyricsNo;
	}
	public void setLyricsNo(int lyricsNo) {
		this.lyricsNo = lyricsNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBpm() {
		return bpm;
	}
	public void setBpm(String bpm) {
		this.bpm = bpm;
	}
	public int getPlayCnt() {
		return playCnt;
	}
	public void setPlayCnt(int playCnt) {
		this.playCnt = playCnt;
	}
	public int getRecCnt() {
		return recCnt;
	}
	public void setRecCnt(int recCnt) {
		this.recCnt = recCnt;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public int getHappy() {
		return happy;
	}
	public void setHappy(int happy) {
		this.happy = happy;
	}
	public int getSad() {
		return sad;
	}
	public void setSad(int sad) {
		this.sad = sad;
	}
	public int getDisgust() {
		return disgust;
	}
	public void setDisgust(int disgust) {
		this.disgust = disgust;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public int getPain() {
		return pain;
	}
	public void setPain(int pain) {
		this.pain = pain;
	}
	public int getFear() {
		return fear;
	}
	public void setFear(int fear) {
		this.fear = fear;
	}
	public int getRage() {
		return rage;
	}
	public void setRage(int rage) {
		this.rage = rage;
	}
	public int getRNUM() {
		return RNUM;
	}
	public void setRNUM(int RNUM) {
		this.RNUM = RNUM;
	}
	
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	@Override
	public String toString() {
		return "MediaDTO [lyricsNo=" + lyricsNo + ", title=" + title + ", singer=" + singer + ", url=" + url + ", bpm="
				+ bpm + ", playCnt=" + playCnt + ", recCnt=" + recCnt + ", lyrics=" + lyrics + ", happy=" + happy
				+ ", sad=" + sad + ", disgust=" + disgust + ", interest=" + interest + ", pain=" + pain + ", fear="
				+ fear + ", rage=" + rage + ", RNUM=" + RNUM + ", emotion=" + emotion + "]";
	}

	
}

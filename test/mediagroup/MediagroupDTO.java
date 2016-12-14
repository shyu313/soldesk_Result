package kr.co.mymelon.mediagroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class MediagroupDTO {

	@Autowired
	private DBOpen dbopen;
	@Autowired
	private DBClose dbclose;
	
	  //@Autowired  : @Component肺 积己等 按眉甫 急攫且锭
	
	public MediagroupDTO() {
		System.out.println("---MediagroupDTO按眉 积己凳");
	}

}

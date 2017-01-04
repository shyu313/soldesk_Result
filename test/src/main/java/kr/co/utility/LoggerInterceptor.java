package kr.co.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;	

/*
 * Interceptor 를 사용하는 이유
<<<<<<< HEAD
 	1) 운영시에 불필요한 로그가 계속 출력된다. 	
 		- 시스템을 개발하고 운영할 때, System.out.println()을 모두 찾아서 지워준다면 몰라도, 거의 대부분은 그냥 한다....ㅡ_ㅡ; 그러면 쓸모없는 로그로 아까운 리소스가 낭비된다.
	2) 모든 로그를 지워버리면, 에러가 났을경우, 그 에러 원인을 찾기가 어려울 수도 있다. 
		- 예를 들어, 시스템에 중대한 에러가 날 경우, 로그를 출력해놓도록 해놨는데, 위에서 System.out.println을 모두 지워버렸다면, 로그가 안남을 수도 있다.
	3) 성능에 큰 영향을 미친다. 
		- 사실 가장 중요한 문제다. 우리가 프로그램을 실행하다가 System.out.println() 을 굉장히 많이 호출하면 프로그램의 전체적인 성능이 떨어지는것을 확인할 수 있다. 예를 들어 1부터 100까지를 모두 더하는 프로그램을 만들었을때, 로그를 하나도 안찍으면 정말 0.01초도 안걸려서 끝나지만, 그 계산과정을 모두 System.out.println()으로 화면에 찍어보면....한참 걸린다... 특히 다중사용자를 처리해야 하는 웹에서 System.out.println()은 정말 큰 문제를 만들어버린다. 
 
 *
 * 상속 클래스 : HandlerInterceptorAdapter - 전처리기와 후처리기 기능을 제공 
 *   client -> controller 로 요청할 때, 그 요청을 처리할 메서드 하나(전처리기)
 *   controller -> client 로 응답할 때, 그 요청을 처리할 메서드 하나(후처리기)
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	// log4.j  를 사용하는 방법
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);		// Log 객체를 log 이름으로 생성(생성자에 현재 클래스 입력)
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
	       if (log.isDebugEnabled()) {
	            log.debug("======================================          START         ======================================");
	            log.debug(" Request URI \t:  " + request.getRequestURI());
	        }
		return super.preHandle(request, response, handler);
	}
	
	 @Override
	 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        if (log.isDebugEnabled()) {
	            log.debug("======================================           END          ======================================\n");
	        }
	  }
	
}


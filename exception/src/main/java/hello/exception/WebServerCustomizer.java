package hello.exception;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {

        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-page/404");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");
        ErrorPage errorPageEx = new ErrorPage(RuntimeException.class, "/error-page/500");

        //등록
        factory.addErrorPages(errorPage404, errorPage500, errorPageEx);
    }
}

/** 스프링 부트 기본 오류 처리
 * 1. WebServerCustomizer 클래스 스프링 빈에 등록되지 않게 @Component 주석처리 해주고 실행해주면 끝
 * 2. 스프링 부트가 제공하는 BasicErrorController 에 오류 처리 메서드가 구현되어 있음
 */
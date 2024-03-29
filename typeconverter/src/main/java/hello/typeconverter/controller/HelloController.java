package hello.typeconverter.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //자바 기본 타입 변환
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); //문자 타입 조회(문자타입으로만 가능)
        Integer intValue = Integer.valueOf(data); // 숫자 타입 변환
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam(name = "data") Integer data) { //스프링이 Integer 타입으로 자동으로 변환해줌
        System.out.println("data = " + data);
        return "ok";
    }
}

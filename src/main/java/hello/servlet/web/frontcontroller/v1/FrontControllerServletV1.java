package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")    // v1 하위에 어떤 것이 들어와도 호출
public class FrontControllerServletV1 extends HttpServlet {

    // key: url, 어떤 url이 호출되면 ControllerV1을 꺼내서 호출
    private Map<String, ControllerV1> controllerV1Map = new HashMap<>();

    // 서블릿이 생성될 때 값 넣는 곳
    public FrontControllerServletV1() {
        controllerV1Map.put("/front-controller/v1/members/new-form", new MemberFormControllerV1()); // uri 호출되면 객체 인스턴스 반환
        controllerV1Map.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerV1Map.put("/front-controller/v1/members", new MemberListControllerV1());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        // /front-controller/v1/members
        String requestURI = request.getRequestURI();// uri 얻어냄

        ControllerV1 controller = controllerV1Map.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);   // 404
            return;
        }

        controller.process(request, response);  // 인터페이스 호출
    }

}
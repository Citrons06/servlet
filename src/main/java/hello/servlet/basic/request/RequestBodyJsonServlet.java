package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.util.StreamUtils;

import hello.servlet.basic.HelloData;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		System.out.println("messageBody = " + messageBody);
		
		// helloData로 변환
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		
		System.out.println("helloData.username = " + helloData.getUsername());
		System.out.println("helloData.age = " + helloData.getAge());
	}
		
}

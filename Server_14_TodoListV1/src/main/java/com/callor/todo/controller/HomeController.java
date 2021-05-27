package com.callor.todo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.command.ReqController;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.TodoServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet{
	
	protected TodoService tdService;
	
	public HomeController() {
		
		tdService = new TodoServiceImplV1();
		
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Map<String, Object>> tdList = tdService.selectAll();
		
		req.setAttribute("TDLIST", tdList);
		
		ReqController.forward(req, resp, "home");
		
		
	}

	
	
}

package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import com.entities.*;
import com.model.*;

/**
 * Servlet implementation class ShoppingCartController
 */
@WebServlet("/ShoppingCartController")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		ProductModel pm = new ProductModel();
		HttpSession session = request.getSession();
		
		if(action.equals("ordernow")){
			
			if(session.getAttribute("cart") == null){
				List<Item> cart = new ArrayList<Item>();
				cart.add(new Item(pm.find(Integer.parseInt(request.getParameter("id"))),1 ));
				session.setAttribute("cart", cart);
			}else{
				List<Item> cart = (List<Item>) session.getAttribute("cart");
				
				int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
				if(index == -1){
					cart.add(new Item(pm.find(Integer.parseInt(request.getParameter("id"))),1 ));
				}
				else{
					int quantity = cart.get(index).getQuantity() + 1;
					cart.get(index).setQuantity(quantity);
				}
				
				session.setAttribute("cart", cart);
				
			}
			request.getRequestDispatcher("/WEB-INF/view/cart.jsp").forward(request, response);
		}
		else if(action.equals("delete"))
		{
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			
			int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
			cart.remove(index);
			session.setAttribute("cart", cart);
			request.getRequestDispatcher("/WEB-INF/view/cart.jsp").forward(request, response);

		}
	}

	private int isExisting(int id,List<Item> cart){
		for(int i = 0;i<cart.size();i++)
			if(cart.get(i).getProduct().getId() == id)
				return i ;
			
		return -1;
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

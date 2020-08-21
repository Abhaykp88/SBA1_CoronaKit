package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.coronokit.dao.KitDao;
import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.CoronaKit;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KitDao kitDAO;
	private ProductMasterDao productMasterDao;
	String jdbcURL;
	String jdbcUsername;
	String jdbcPassword;

	public void setKitDAO(KitDao kitDAO) {
		this.kitDAO = kitDAO;
	}

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {
		 jdbcURL = config.getServletContext().getInitParameter("jdbcURL");
		 jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		 jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		

		this.kitDAO = new KitDao(jdbcURL, jdbcUsername, jdbcPassword);
		this.productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String action = request.getParameter("action");
	    System.out.println(action);
		String personName = request.getParameter("personName");
		String email = request.getParameter("email");
		String contactNumber = request.getParameter("contactNumber");
		System.out.println("personName: " + personName);
		String viewName = "";
		try {
			switch (action) {
			case "newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "insertuser":
				viewName = insertNewUser(request, response);
				break;
			case "showproducts":
				viewName = showAllProducts(request, response);
				break;
			case "addnewitem":
				viewName = addNewItemToKit(request, response);
				break;
			case "deleteitem":
				viewName = deleteItemFromKit(request, response);
				break;
			case "showkit":
				viewName = showKitDetails(request, response);
				break;
			case "placeorder":
				System.out.println("Inside place");
				viewName = showPlaceOrderForm(request, response);
				break;
			case "saveorder":
				viewName = saveOrderForDelivery(request, response);
				break;
			case "ordersummary":
				viewName = showOrderSummary(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);

	}

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("ordersummary.jsp");
		try {
			requestdispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private String saveOrderForDelivery(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside function");
		String amount = request.getParameter("price");
		request.setAttribute("amount", amount);
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("placeorder.jsp");
		try {
			requestdispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String insertNewUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coronakitdb", "root", "root");

			//Connection con = product.getConnection();			
			// Create a SQL query to insert data into demo table
			// demo table consists of two columns, so two '?' is used
			PreparedStatement st = jdbcConnection.prepareStatement("insert into test values(?, ?, ?)");

			st.setString(1,request.getParameter("personName"));
			st.setString(2,request.getParameter("email"));
			st.setString(3,request.getParameter("contactNumber"));
			st.executeUpdate(); 
			st.close();
			jdbcConnection.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("showproductstoadd.jsp");
		try {
			requestdispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) {

		return "";
	}
}
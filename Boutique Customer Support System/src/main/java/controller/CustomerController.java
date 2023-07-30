package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CustomerDAO dao;
       String action="";
       String forward="";
       RequestDispatcher view;
       HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("addCustomer")) {
			forward ="newCustomer.jsp";
			request.setAttribute("customers", CustomerDAO.getAllCustomers());
		}
		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer cus = new Customer();
		
		cus.setU_email(request.getParameter("u_email"));
		cus.setU_name(request.getParameter("u_name"));
		
		dao.newCustomer(cus);
		
		request.setAttribute("customer", CustomerDAO.getAllCustomers());
		view = request.getRequestDispatcher("addReport.jsp");
		view.forward(request, response);
		
		
		
	}

}

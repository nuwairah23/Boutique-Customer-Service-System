package controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.ReportDAO;
import model.Report;

/**
 * Servlet implementation class AddComplaintController
 */
@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReportDAO dao;
    String action="";
    String forward="";
    RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
        dao = new ReportDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("viewComplaint")) {
			forward ="ViewReport.jsp";
			int report_id = Integer.parseInt(request.getParameter("report_id"));
			request.setAttribute("report", ReportDAO.getReportById(report_id));
		}
		if(action.equalsIgnoreCase("listComplaint")) {
			forward ="ListReport.jsp";
			request.setAttribute("reports", ReportDAO.getAllReports());
		}
		if(action.equalsIgnoreCase("deleteComplaint")) {
			forward ="ListReport.jsp";
			int report_id = Integer.parseInt(request.getParameter("report_id"));
			dao.deleteComplaint(report_id);
			request.setAttribute("reports", ReportDAO.getAllReports());
		}
		if(action.equalsIgnoreCase("updateComplaint")) {
			forward ="UpdateReport.jsp";
			int report_id = Integer.parseInt(request.getParameter("report_id"));
			request.setAttribute("report", ReportDAO.getReportById(report_id));
		}
		if(action.equalsIgnoreCase("addComplaint")) {
			forward ="addReport.jsp";
			request.setAttribute("reports", ReportDAO.getAllReports());
		}
		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Report report = new Report();
		
		report.setCustomer(CustomerDAO.getCustomerByName(request.getParameter("name")));
		report.setT_order_id(Integer.parseInt(request.getParameter("orderid")));
		report.setT_date(Date.valueOf(request.getParameter("date")));
		report.setT_type(request.getParameter("report"));
		report.setT_refund_amount(Double.parseDouble(request.getParameter("refundamount")));
		report.setT_subject(request.getParameter("subject"));
		report.setT_description(request.getParameter("description"));
		report.setU_email(request.getParameter("email"));
		
		//String u_email = request.getParameter("email");
		String report_id = request.getParameter("report_id");
		System.out.println(report_id);
		
		if(report_id == null || report_id.isEmpty()) {
			dao.addComplaint(report);
			
		}
		else {
			report.setReport_id(Integer.parseInt(report_id));
			dao.updateComplaint(report);
		}
		request.setAttribute("reports", ReportDAO.getAllReports());
		view = request.getRequestDispatcher("ListReport.jsp");
		view.forward(request, response);
		
	}

}

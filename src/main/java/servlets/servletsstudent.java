package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnections.studentdb;
import models.student;
import services.studentservices;

public class servletsstudent extends HttpServlet{
	 
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
    int stu_id=Integer.parseInt(req.getParameter("stu_id"));
    String stu_name=req.getParameter("stu_name");
    String stu_email=req.getParameter("stu_email");
    long stu_phn=Integer.parseInt(req.getParameter("stu_name"));
    String stu_branch = req.getParameter("stu_branch");
    student st = new student(stu_id,stu_name,stu_email,stu_phn,stu_branch);
    studentservices services = new studentservices(studentdb.getConnection());
    HttpSession ht = req.getSession();
    boolean f = services.addstudent(st);
    if (f) {
		System.out.println("successfully inserted");
	}
    else {
    	System.out.println("error");
    }
		super.doPost(req, resp);
	}

}

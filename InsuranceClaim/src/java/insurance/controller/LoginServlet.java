/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.controller;

import insurance.model.Patient;
import insurance.pojo.PatientPojo;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String email=request.getParameter("email");
            int pin=Integer.parseInt(request.getParameter("pin"));
            boolean result=Patient.patientVerified(email, pin);
            if(result==true)
            {
                Patient.getPatientDetailsById(email);
                RequestDispatcher rd=request.getRequestDispatcher("userProfile.jsp");
//                request.setAttribute("patientDetail", p);
                rd.forward(request, response);
            }
            else
                response.sendRedirect("Login.jsp");
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Enter the data properly");
            nfe.printStackTrace();
        }
        
        catch(SQLException sqle)
        {
            System.out.println("Invalid Input");
            sqle.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

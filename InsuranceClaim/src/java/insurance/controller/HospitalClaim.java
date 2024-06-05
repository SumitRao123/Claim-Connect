/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.controller;

import insurance.model.Hospital;
import insurance.pojo.ClaimDetailsPojo;
import insurance.pojo.PatientPojo;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Dell
 */
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
@WebServlet(name = "HospitalClaim", urlPatterns = {"/HospitalClaim"})
public class HospitalClaim extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           String hosp=request.getParameter("hosp");
           String insComp=request.getParameter("ins");
           System.out.println(insComp);
            String claim=request.getParameter("claimname");
            String desc=request.getParameter("claimdes");
            String name=request.getParameter("name");
            long amt=Long.parseLong(request.getParameter("currency-field"));
            Part filePart = request.getPart("bill");
            String fileName = filePart.getSubmittedFileName();
            System.out.println(fileName);
            String savePath="E://Adv Java Batch//InsuranceClaim//web//Bill//"+fileName;
            File saveDir= new File(savePath);
            filePart.write(savePath+File.separator);
            
            ClaimDetailsPojo c=new ClaimDetailsPojo();
            String claimid=Hospital.nextClaimId();
            c.setClaimId(claimid);
            c.setClaimHeading(claim);
            c.setTreatmentDesc(desc);
            c.setClaimAmount(amt);
            c.setUserName(name);
            c.setImgName(fileName);
            c.setImgLoaction(savePath);
            c.setInsCompany(insComp);
            c.setHospitalName(hosp);
            c.setStatus("y");
            boolean res=Hospital.insertClaim(c);
            if(res==true)
            {
               int id=Integer.parseInt(request.getParameter("id"));
               PatientPojo p=Hospital.getPatientDetailById(id);
               RequestDispatcher rd=request.getRequestDispatcher("hospitalPatient.jsp");
               request.setAttribute("claimDetails", c);
               request.setAttribute("patientDetail", p);
               rd.include(request, response);
            }
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Error in Claiming Hospital ");
            nfe.printStackTrace();
        }
       
       catch(SQLException sqle)
        {
            System.out.println("Error in DB ");
            sqle.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

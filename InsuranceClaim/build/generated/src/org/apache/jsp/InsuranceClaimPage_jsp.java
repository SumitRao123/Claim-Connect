package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import insurance.pojo.*;
import java.util.*;

public final class InsuranceClaimPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


              ArrayList<ClaimDetailsPojo> cdp;
              
          
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <link\n");
      out.write("      href=\"https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("    />\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css\"\n");
      out.write("    />\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\" />\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin />\n");
      out.write("    <link\n");
      out.write("      href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("    />\n");
      out.write("    <link rel=\"stylesheet\" href=\"./stylesheets/InsuranceHome.css\" />\n");
      out.write("    <link rel=\"icon\" href=\"../src/imges/长.png\" style=\"width: 30px\" />\n");
      out.write("  </head>\n");
      out.write("  <body onkeyup=\"load()\">\n");
      out.write("      ");

                request.setAttribute("Id",UserProfile.getUniqueId());
                request.setAttribute("Name",UserProfile.getName());
                request.setAttribute("Gender",UserProfile.getGender());
                request.setAttribute("Age",UserProfile.getAge());
                request.setAttribute("Email",UserProfile.getEmail());
                request.setAttribute("InsComp",UserProfile.getCompName());
                if(UserProfile.getCurrentStatus().equalsIgnoreCase("active"))
                {
                    request.setAttribute("icon","ri-check-line");
                    request.setAttribute("i","status");
                    request.setAttribute("text","Active");
                }
                else
                {
                    request.setAttribute("icon","ri-close-fill");
                    request.setAttribute("i","wrong");
                    request.setAttribute("text","Not Active");
                }
                request.setAttribute("claimAmt",UserProfile.getMaxLimit());
                request.setAttribute("AadharNo",UserProfile.getAadharNo());
      
      out.write("\n");
      out.write("    <div id=\"maindiv\">\n");
      out.write("      <div id=\"sidenav\">\n");
      out.write("        <h3>Star Health Inc.</h3>\n");
      out.write("        <div id=\"dashboard\">\n");
      out.write("          <p id=\"head\">DASHBOARD</p>\n");
      out.write("          <a href=\"/index.html\">\n");
      out.write("            <div class=\"dashboarditems\" id=\"home\">\n");
      out.write("              <i class=\"ri-home-5-line icons\"></i>\n");
      out.write("              <p class=\"entries\">Home</p>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"#\">\n");
      out.write("            <div class=\"dashboarditems active\" id=\"app\">\n");
      out.write("              <i class=\"ri-health-book-line\"></i>\n");
      out.write("              <p class=\"entries\">Claim Request</p>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"#\">\n");
      out.write("            <div class=\"dashboarditems\" id=\"pat\">\n");
      out.write("              <i class=\"ri-empathize-line\"></i>\n");
      out.write("              <p class=\"entries\">Clients</p>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"#\">\n");
      out.write("            <div class=\"dashboarditems\" id=\"pr\">\n");
      out.write("              <i class=\"ri-exchange-funds-line\"></i>\n");
      out.write("              <p class=\"entries\">Request History</p>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("          <!-- <div id=\"banner\"> -->\n");
      out.write("          <!-- <div id=\"text\">\n");
      out.write("                <p>Let's upgrade your plan</p>\n");
      out.write("                <i class=\"ri-arrow-right-s-line\"></i>\n");
      out.write("            </div>\n");
      out.write("            <img src=\"/3.png\" alt=\"\"> -->\n");
      out.write("          <a class=\"card1\" href=\"#\">\n");
      out.write("            <p>Let's upgrade your plan</p>\n");
      out.write("            <img src=\"./images/12083074_Wavy_Bus-03_Single-06.png\" alt=\"\" />\n");
      out.write("            <div class=\"go-corner\" href=\"#\">\n");
      out.write("              <div class=\"go-arrow\"><i class=\"ri-arrow-right-s-line\"></i></div>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("          <!-- </div> -->\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"midsection\">\n");
      out.write("        <div id=\"roomnav\">\n");
      out.write("          <div id=\"left\">\n");
      out.write("            <h3>Recent Claim Requests</h3>\n");
      out.write("            <p>sorted in order of arrival</p>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"mid\">\n");
      out.write("            <!-- <p>Search By</p> -->\n");
      out.write("            <input type=\"search\" placeholder=\"medical IDs, or number\" />\n");
      out.write("            <i class=\"ri-search-line\"></i>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("          ");
      out.write("\n");
      out.write("          ");

              String url="InsuranceClaim";
              cdp=(ArrayList<ClaimDetailsPojo>)request.getAttribute("claimDetails");
              if(cdp!=null)
              {
                  request.setAttribute("disp","display");
              }
              else
              {
                  request.setAttribute("disp","display-none");
              }
              
          
      out.write("\n");
      out.write("          <div id=\"notifdiv\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${disp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("          <div id=\"upper\">\n");
      out.write("            <i class=\"ri-hospital-line\"></i>\n");
      out.write("            <h3>Multi Speciality Hospital</h3>\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          ");

                cdp=(ArrayList<ClaimDetailsPojo>)request.getAttribute("claimDetails");
                long count=0;
              if(cdp!=null)
              {
//                      out.println("<div id='claimhead'>");
//                      out.println("<h3>Claim Id</h3>");
//                      out.println("<span>"+cdp.get(0).getClaimId()+"</span>");
//                  for(ClaimDetailsPojo p:cdp)
//                  {
//                      count+=p.getClaimAmount();
//                      out.println("<p>"+p.getTreatmentDesc()+"<p/>");
//                  }
//                  out.println(" </div>");
                    out.println("<div id='claimhead'");
                    out.println("<h3>Claim Id</h3>");
                    out.println("<span>"+cdp.get(0).getClaimId()+"</span>");
                    out.println("</div>");
                    out.println("<div id='detailsection'>");
                    
                     for(ClaimDetailsPojo p:cdp)
                    {
                        count+=p.getClaimAmount();
                        out.println("<div class='claimdiv'>");
                        out.println("<div class='claim '>");
                        out.println(" <img");
                        out.println("  src='https://static.vecteezy.com/system/resources/previews/002/641/198/original/invoice-icon-vector.jpg'/>");
                        out.println("<div class='claimhead'>");
                        out.println("<h3>"+p.getClaimHeading()+"</h3>");
                        out.println("<p class='grey towrap'>"+p.getTreatmentDesc()+"</p>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("<div class='claimdetails'>");
                        out.println("<div class='amount'>");
                        out.println("<p class='grey'> Sum </p>");
                        out.println("<h4>Rs."+p.getClaimAmount()+" </h4>");
                        out.println("</div>");
                        out.println(" <div class='docs'>");
                        out.println("<p class='grey'>Doc.</p>");
                        out.println(" <h4><i class='ri-download-line'></i></h4>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                    }

                    out.println("</div>");
                  request.setAttribute("value", count);
              }
          
      out.write(" \n");
      out.write("<!--          \n");
      out.write("            <h3>Claim Id</h3>\n");
      out.write("            <span>319384</span>-->\n");
      out.write("         \n");
      out.write("<!--          <div id=\"claimdes\">\n");
      out.write("            <p>\n");
      out.write("              _ClaimDes Lorem, ipsum dolor sit amet consectetur adipisicing\n");
      out.write("              elit. Accusamus aperiam expedita reprehenderit.\n");
      out.write("            </p>\n");
      out.write("          </div>-->\n");
      out.write("          <div id=\"claimamt\">\n");
      out.write("            <h4 id=\"blck\">Total Expenses</h4>\n");
      out.write("            <div id=\"amt\">\n");
      out.write("              <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("              <span>Rs. /-</span>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"inwords\"></div>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"bottom\">\n");
      out.write("<!--            <button class=\"button-57\" role=\"button\" id=\"cancel\">\n");
      out.write("              <span class=\"text\"><i class=\"ri-close-line\"></i></span>\n");
      out.write("              <span\n");
      out.write("                >Cancel Claim <br />\n");
      out.write("                Req.</span\n");
      out.write("              >\n");
      out.write("            </button>-->\n");
      out.write("            <a href=\"InsuranceRevertReq?user=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&status='Unsuccessfull'\">\n");
      out.write("            <button class=\"button-57\" role=\"button\" id=\"revert\">\n");
      out.write("              <span class=\"text\"><i class=\"ri-arrow-go-forward-line\"></i></span>\n");
      out.write("              <span\n");
      out.write("                >Revert Claim <br />\n");
      out.write("                Req.</span\n");
      out.write("              >\n");
      out.write("            </button>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"InsuranceRevertReq?user=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&status='Successfull'\">\n");
      out.write("            <button class=\"button-57\" role=\"button\" id=\"accept\">\n");
      out.write("              <span class=\"text\"><i class=\"ri-check-line\"></i></span>\n");
      out.write("              <span\n");
      out.write("                >Proceed Claim <br />\n");
      out.write("                Req.</span\n");
      out.write("              >\n");
      out.write("            </button>\n");
      out.write("            </a>\n");
      out.write("            <!-- <button class=\"button-86\" role=\"button\">Cancel</button> -->\n");
      out.write("            <!-- <button id=\"cncl\">Cancel</button> -->\n");
      out.write("            <!-- <button class=\"button-86\" role=\"button\">Revert</button> -->\n");
      out.write("            <!-- <button id=\"rvrt\">Revert</button> -->\n");
      out.write("            <!-- <button class=\"button-86\" role=\"button\">Approve</button> -->\n");
      out.write("            <!-- <button id=\"aprv\">Approve</button> -->\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"profilesection\">\n");
      out.write("        <div class=\"showdiv\">\n");
      out.write("          <p>Patient</p>\n");
      out.write("          <i class=\"ri-arrow-right-s-line blue\"></i>\n");
      out.write("          <p class=\"blue\">Patient Profile</p>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"card\">\n");
      out.write("          <p class=\"grey\">YOUR INSURANCE CLIENT</p>\n");
      out.write("          <img\n");
      out.write("            src=\"https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436188.jpg?w=740&t=st=1680213087~exp=1680213687~hmac=895ba1207267b51fd1e7fe150f44d77fab0d736f3028d783a40edc6059711da1\"\n");
      out.write("            alt=\"\"\n");
      out.write("          />\n");
      out.write("          <div id=\"det\">\n");
      out.write("            <div id=\"prf\">\n");
      out.write("              <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("              <p class=\"grey\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Age}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" years old, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Gender}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("              <p class=\"grey\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("            <div class=\"mini\">\n");
      out.write("              <p>Status:</p>\n");
      out.write("              <span><i class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${icon}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${text}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mini\">\n");
      out.write("              <p>Policy:</p>\n");
      out.write("              <span id=\"orng\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${claimAmt}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" / year</span>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("            <script >\n");
      out.write("                function load()\n");
      out.write("                {\n");
      out.write("                    console.log(\"Peek\");\n");
      out.write("                    location.href= \"");
      out.print(url);
      out.write("\";\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

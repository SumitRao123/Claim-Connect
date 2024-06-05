package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hospitalHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("    <link rel=\"stylesheet\" href=\"./stylesheets/hospitalHome.css\" />\n");
      out.write("    <link rel=\"icon\" href=\"../src/imges/长.png\" style=\"width: 30px\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("    <div id=\"maindiv\">\n");
      out.write("      <div id=\"sidenav\">\n");
      out.write("        <h3>Multi Speciality Hospital</h3>\n");
      out.write("        <div id=\"dashboard\">\n");
      out.write("          <p>DASHBOARD</p>\n");
      out.write("          <a href=\"hospitalHome.jsp\">\n");
      out.write("            <div class=\"dashboarditems active\" id=\"home\">\n");
      out.write("              <i class=\"ri-home-5-line icons\"></i>\n");
      out.write("              <p class=\"entries\">Home</p>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"hospitalAppointment.jsp\">\n");
      out.write("            <div class=\"dashboarditems\" id=\"app\">\n");
      out.write("              <i class=\"ri-calendar-2-line icons\"></i>\n");
      out.write("              <p class=\"entries\">Appointments</p>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"hospitalPatient.jsp\">\n");
      out.write("            <div class=\"dashboarditems\" id=\"pat\">\n");
      out.write("              <i class=\"ri-user-add-line icons\"></i>\n");
      out.write("              <p class=\"entries\">Patients</p>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"hospitalPendingReq.jsp\">\n");
      out.write("            <div class=\"dashboarditems\" id=\"pr\">\n");
      out.write("              <i class=\"ri-book-read-line icons\"></i>\n");
      out.write("              <p class=\"entries\">Pending Request</p>\n");
      out.write("            </div>\n");
      out.write("          </a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"./Js/hospitalHome.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

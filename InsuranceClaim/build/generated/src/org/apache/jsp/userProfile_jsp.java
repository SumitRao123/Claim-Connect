package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import insurance.pojo.*;
import java.util.*;

public final class userProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


              ArrayList<ClaimDetailsPojo> cdp;
              String amount="";
          
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
      out.write("    <link rel=\"stylesheet\" href=\"./stylesheets/userProfile.css\" />\n");
      out.write("    \n");
      out.write("    <link rel=\"icon\" href=\"../src/imges/长.png\" style=\"width: 30px\" />\n");
      out.write("  </head>\n");
      out.write("  <body onkeyup=\"reload()\">\n");
      out.write("\n");
      out.write("       ");

//            UserProfile p=(UserProfile)request.getAttribute("patientDetail");
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
      out.write("    <div id=\"main\">\n");
      out.write("      <div id=\"roomnav\">\n");
      out.write("        <div id=\"left\">\n");
      out.write("          <h2>DashBoard , ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"mid\">\n");
      out.write("          <input type=\"search\" placeholder=\"find policies by name/provider\" />\n");
      out.write("          <i class=\"ri-search-line\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"right\">\n");
      out.write("          <i class=\"ri-home-fill\" onclick=\"toggle(document.getElementById('revertdiv').id)\"></i>\n");
      out.write("          <i class=\"ri-bookmark-3-fill\"></i>\n");
      out.write("          ");
      out.write("\n");
      out.write("          ");

             String url="ClaimTransferServlet?name="+UserProfile.getName(); 
             cdp=(ArrayList<ClaimDetailsPojo>)request.getAttribute("claimDetails");
//             out.println("cdp"+cdp);
             if(cdp==null)
             {
//                 out.println("ERROR");
                 request.setAttribute("notify","ri-notification-off-fill");
                 request.setAttribute("disp","display-none");
             }
             else
             {
                 request.setAttribute("notify","ri-notification-4-fill");
                 request.setAttribute("hospName",cdp.get(0).getHospitalName());
                 request.setAttribute("insComp",cdp.get(0).getInsCompany());
                 request.setAttribute("disp","display");
             }



          
      out.write("\n");
      out.write("          <i class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" onclick=\"toggle(document.getElementById('notifdiv').id)\"><button ></button></i>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div id=\"mainDash\">\n");
      out.write("        <div id=\"back\">\n");
      out.write("          <i class=\"ri-arrow-left-line\"></i>\n");
      out.write("          <p>Back to home page</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"heading\">\n");
      out.write("          <h3>Policy Name 01</h3>\n");
      out.write("          <div id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            <i class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${icon}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></i>\n");
      out.write("            <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${text}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"slidemenu\">\n");
      out.write("          <div id=\"info\">\n");
      out.write("            <p>Information</p>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"logs\">\n");
      out.write("            <p>Recent Logs</p>\n");
      out.write("            <div id=\"notif\">\n");
      out.write("              <p>8</p>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"boderdiv\">\n");
      out.write("          <div id=\"cover\"></div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapse\">\n");
      out.write("          <div id=\"infodiv\">\n");
      out.write("            <div class=\"det\">\n");
      out.write("              <p>ID</p>\n");
      out.write("              <p>Policy Holder</p>\n");
      out.write("              <p>Policy Provider</p>\n");
      out.write("              <p>Email Id</p>\n");
      out.write("              <p>Age</p>\n");
      out.write("              <p>Gender</p>\n");
      out.write("              <p>Max Claim per year</p>\n");
      out.write("              <p>Aadhar No.</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"entries\">\n");
      out.write("              <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("              <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("              <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${InsComp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("              <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("              <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Age}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("              <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Gender}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("              <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${claimAmt}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("              <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${AadharNo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"logdiv\">\n");
      out.write("            <div id=\"timeline\"></div>\n");
      out.write("            <ul>\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"notifdiv\">\n");
      out.write("      <div id=\"upper\">\n");
      out.write("        <i class=\"ri-notification-3-fill\"></i>\n");
      out.write("        <h3>New Notification</h3>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"details\">\n");
      out.write("        <div id=\"from\">\n");
      out.write("          <p>From:</p>\n");
      out.write("          <div class=\"det\">\n");
      out.write("            <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${hospName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"to\">\n");
      out.write("          <p>To:</p>\n");
      out.write("          <div class=\"det\">\n");
      out.write("            <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${insComp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"claimhead\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${disp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("          <h3>\n");
      out.write("              ");

                  cdp=(ArrayList<ClaimDetailsPojo>)request.getAttribute("claimDetails");
                  long count=0;
                  if(cdp!=null)
                  {
                      for(ClaimDetailsPojo p:cdp)
                        {
                            count=p.getClaimAmount()+count;
                            out.println("<p>"+p.getClaimHeading()+"</p>");
                        }
                        amount=String.valueOf(count);
                        request.setAttribute("value",count);
                  }
               
      out.write("\n");
      out.write("          </h3>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"claimamt\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${disp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        <h4 id=\"blck\">Total Expenses</h4>\n");
      out.write("        <div id=\"amt\">\n");
      out.write("          <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("          <span>Rs. /-</span>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"inwords\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"bottom\">\n");
      out.write("        <button class=\"button-57\" role=\"button\" id=\"cancel\">\n");
      out.write("          <span class=\"text\"><i class=\"ri-close-line\"></i></span>\n");
      out.write("          <span>Cancel Claim <br />\n");
      out.write("            Req.\n");
      out.write("          </span>\n");
      out.write("        </button>\n");
      out.write("          <a href=\"RevertRequestServlet?user=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&status='Unsuccessfull'\">\n");
      out.write("          <button class=\"button-57\" role=\"button\" id=\"revert\" type=\"submit\">\n");
      out.write("          <span class=\"text\"><i class=\"ri-arrow-go-forward-line\"></i></span>\n");
      out.write("          <span>Revert Claim <br />\n");
      out.write("            Req.\n");
      out.write("          </span>\n");
      out.write("        </button>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"RevertRequestServlet?user=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&status='Successfull'\">\n");
      out.write("        <button class=\"button-57\" role=\"button\" id=\"accept\">\n");
      out.write("          <span class=\"text\"><i class=\"ri-check-line\"></i></span>\n");
      out.write("          <span\n");
      out.write("            >Proceed Claim <br />\n");
      out.write("            Req.</span\n");
      out.write("          >\n");
      out.write("        </button>\n");
      out.write("          </a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("        ");

            String revertURL="UserRevertReq?name="+UserProfile.getName();
            ArrayList<ClaimDetailsPojo> cp=(ArrayList<ClaimDetailsPojo>)request.getAttribute("faultyList");
            if(cp==null)
            {
                request.setAttribute("disp","display-none");
                System.out.println("User Data not recieved");
            }
            else
            {
                request.setAttribute("disp","display");
                System.out.println("User Data recieved");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"revertdiv\">\n");
      out.write("      <div id=\"upper\">\n");
      out.write("        <i class=\"ri-emotion-unhappy-line\" id=\"ex\"></i>\n");
      out.write("        <!-- <ion-icon id=\"ex\" name=\"alert-circle-outline\"></ion-icon> -->\n");
      out.write("        <h3>Reverted Cla<span>!</span>m Req.</h3>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"details\">\n");
      out.write("        <div id=\"from\">\n");
      out.write("          <p>From:</p>\n");
      out.write("          <div class=\"det\">\n");
      out.write("            <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${InsComp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"to\">\n");
      out.write("          <p>To:</p>\n");
      out.write("          <div class=\"det\">\n");
      out.write("            <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${hospName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"claimhead\" class='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${disp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("' >\n");
      out.write("          ");

              ArrayList<ClaimDetailsPojo> list=(ArrayList<ClaimDetailsPojo>)request.getAttribute("faultyList");
              if(list!=null)
              {
                  long sum=0;
                  out.println("<h3>"+list.get(0).getClaimHeading()+"</h3");
                  out.println("<p>(treated on 28 March 2023)</p>");
                  for(ClaimDetailsPojo c1:list)
                  {
                      sum+=c1.getClaimAmount();
                      
                  }
                  request.setAttribute("sum",sum);
              }
          
      out.write("\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <div id=\"claimdes\" class='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${disp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'>\n");
      out.write("        <h3>Cause:</h3>\n");
      out.write("        <p>\n");
      out.write("          The requested services or treatment\n");
      out.write("          are not covered by the policy or Insufficient \n");
      out.write("          or inaccurate information has been provided.\n");
      out.write("        </p>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"claimamt\" class='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${disp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'>\n");
      out.write("        <h4 id=\"blck\">Total Expenses</h4>\n");
      out.write("        <div id=\"amt\">\n");
      out.write("          <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sum}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("          <span>Rs. /-</span>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"inwords\"></div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"processing\" class='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${disp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'>\n");
      out.write("        <img src=\"./images/40d8473e8faebf9ec7bc878f8969af0d.gif\" alt=\"\" />\n");
      out.write("        <h4>Your hospital is processing this request. </h4> \n");
      out.write("      </div>\n");
      out.write("      <div id=\"bottom\" >\n");
      out.write("<!--         <button class=\"button-57\" role=\"button\" id=\"cancel\">\n");
      out.write("          <span class=\"text\"><i class=\"ri-close-line\"></i></span>\n");
      out.write("          <span\n");
      out.write("            >Cancel Claim <br />\n");
      out.write("            Req.</span\n");
      out.write("          >\n");
      out.write("        </button>\n");
      out.write("        <button class=\"button-57\" role=\"button\" id=\"revert\">\n");
      out.write("          <span class=\"text\"><i class=\"ri-arrow-go-forward-line\"></i></span>\n");
      out.write("          <span\n");
      out.write("            >Revert Claim <br />\n");
      out.write("            Req.</span\n");
      out.write("          > \n");
      out.write("        </button>-->\n");
      out.write("        <button class=\"button-57 okay\" role=\"button\" id=\"accept\">\n");
      out.write("          <span class=\"text\"><i class=\"ri-check-line\"></i></span>\n");
      out.write("          <span\n");
      out.write("            >Okay   </span\n");
      out.write("          >\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("        <script>\n");
      out.write("      var info = document.querySelector(\"#info\");\n");
      out.write("      var logs = document.querySelector(\"#logs\");\n");
      out.write("      var cover = document.querySelector(\"#cover\");\n");
      out.write("      var infodiv = document.querySelector(\"#infodiv\");\n");
      out.write("      var logdiv = document.querySelector(\"#logdiv\");\n");
      out.write("      var det = document.querySelector(\".det\");\n");
      out.write("      var entries = document.querySelector(\".entries\");\n");
      out.write("      var notify = document.querySelector(\"#notify\");\n");
      out.write("      var notifdiv = document.querySelector(\"#notifdiv\");\n");
      out.write("\n");
      out.write("      logs.addEventListener(\"click\", () => {\n");
      out.write("        cover.style.left = \"51%\";\n");
      out.write("        // det.style.display = \"none\";\n");
      out.write("        // entries.style.display = \"none\";\n");
      out.write("        infodiv.style.height = \"0%\";\n");
      out.write("        logdiv.style.height = \"100%\";\n");
      out.write("      });\n");
      out.write("      info.addEventListener(\"click\", () => {\n");
      out.write("        cover.style.left = \"7%\";\n");
      out.write("        infodiv.style.height = \"100%\";\n");
      out.write("        logdiv.style.height = \"0%\";\n");
      out.write("      });\n");
      out.write("      \n");
      out.write("      function reload()\n");
      out.write("      {\n");
      out.write("          location.href=\"");
      out.print( url);
      out.write("\";\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      // let flag = false;\n");
      out.write("      // const information = () => {};\n");
      out.write("\n");
      out.write("      // const recentLogs = () => {};\n");
      out.write("\n");
      out.write("      function toggle(param) {\n");
      out.write("        var main = document.querySelector(\"#main\");\n");
      out.write("        main.classList.toggle(\"active\");\n");
      out.write("\n");
      out.write("        var id = document.getElementById(param);\n");
      out.write("        // var notifdiv = document.getElementById(\"notifdiv\");\n");
      out.write("        id.classList.toggle(\"active\");\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      var cancel = document.querySelector(\"#cancel\");\n");
      out.write("      cancel.addEventListener(\"click\", () => {\n");
      out.write("        location.reload();\n");
      out.write("      });\n");
      out.write("\n");
      out.write("      var okay = document.querySelector(\".okay\");\n");
      out.write("      okay.addEventListener(\"click\", () => {\n");
      out.write("        location.reload();\n");
      out.write("      });\n");
      out.write("\n");
      out.write("      inwords();\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("      function inwords() {\n");
      out.write("        // const num = document.getElementById(\"num\");\n");
      out.write("        const inwords = document.getElementById(\"inwords\");\n");
      out.write("        const num = '");
      out.print(amount);
      out.write("';\n");
      out.write("        console.log('");
      out.print(amount);
      out.write("');\n");
      out.write("        const ones = {\n");
      out.write("          0: \"Zero\",\n");
      out.write("          1: \"One\",\n");
      out.write("          2: \"Two\",\n");
      out.write("          3: \"Three\",\n");
      out.write("          4: \"Four\",\n");
      out.write("          5: \"Five\",\n");
      out.write("          6: \"Six\",\n");
      out.write("          7: \"Seven\",\n");
      out.write("          8: \"Eight\",\n");
      out.write("          9: \"Nine\",\n");
      out.write("          10: \"Ten\",\n");
      out.write("          11: \"Eleven\",\n");
      out.write("          12: \"Twelve\",\n");
      out.write("          13: \"Thirteen\",\n");
      out.write("          14: \"Fourteen\",\n");
      out.write("          15: \"Fifteen\",\n");
      out.write("          16: \"Sixteen\",\n");
      out.write("          17: \"Seventeen\",\n");
      out.write("          18: \"Eighteen\",\n");
      out.write("          19: \"Nineteen\",\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        const prefixes = {\n");
      out.write("          2: \"Twenty\",\n");
      out.write("          3: \"Thirty\",\n");
      out.write("          4: \"Fourty\",\n");
      out.write("          5: \"Fifty\",\n");
      out.write("          6: \"Sixty\",\n");
      out.write("          7: \"Seventy\",\n");
      out.write("          8: \"Eighty\",\n");
      out.write("          9: \"Ninety\",\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        // event.preventDefault();\n");
      out.write("\n");
      out.write("        if (+num in ones) {\n");
      out.write("          inwords.innerHTML = ones[+num] + \" Rs. /-\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        const numArray = num.split(\"\");\n");
      out.write("        if (numArray.length === 2 && +num > 19) {\n");
      out.write("          inwords.innerHTML = prefixes[numArray[0]] + \" \" + ones[numArray[1]] + \" Rs. /-\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        if (numArray.length === 3) {\n");
      out.write("          if (+numArray[1] === 0) {\n");
      out.write("            inwords.innerHTML =\n");
      out.write("              ones[numArray[0]] + \" hundred \" + \" \" + ones[numArray[2]] + \" Rs. /-\";\n");
      out.write("          } else if (+numArray[1] < 2) {\n");
      out.write("            inwords.innerHTML =\n");
      out.write("              ones[numArray[0]] +\n");
      out.write("              \" hundred \" +\n");
      out.write("              \" \" +\n");
      out.write("              ones[+[numArray[1], numArray[2]].join(\"\")] + \" Rs. /-\";\n");
      out.write("          } else {\n");
      out.write("            inwords.innerHTML =\n");
      out.write("              ones[numArray[0]] +\n");
      out.write("              \" hundred \" +\n");
      out.write("              prefixes[numArray[1]] +\n");
      out.write("              \" \" +\n");
      out.write("              ones[numArray[2]] + \" Rs. /-\";\n");
      out.write("          }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        if (numArray.length === 4) {\n");
      out.write("          if (+numArray[1] === 0) {\n");
      out.write("            inwords.innerHTML =\n");
      out.write("              ones[numArray[0]] +\n");
      out.write("              \" thousand \" +\n");
      out.write("              \" \" +\n");
      out.write("              ones[+[numArray[2], numArray[3]].join(\"\")] + \" Rs. /-\";\n");
      out.write("          } else if (+numArray[1] < 2) {\n");
      out.write("            inwords.innerHTML =\n");
      out.write("              ones[numArray[0]] +\n");
      out.write("              \" thousand \" +\n");
      out.write("              ones[numArray[1]] +\n");
      out.write("              \" hundred \" +\n");
      out.write("              \" \" +\n");
      out.write("              ones[+[numArray[2], numArray[3]].join(\"\")] + \" Rs. /-\";\n");
      out.write("          } else {\n");
      out.write("            inwords.innerHTML =\n");
      out.write("              ones[numArray[0]] +\n");
      out.write("              \" thousand \" +\n");
      out.write("              ones[numArray[1]] +\n");
      out.write("              \" hundred \" +\n");
      out.write("              prefixes[numArray[2]] +\n");
      out.write("              \" \" +\n");
      out.write("              ones[numArray[3]] + \" Rs. /-\";\n");
      out.write("          }\n");
      out.write("        }\n");
      out.write("      } \n");
      out.write("        </script> \n");
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

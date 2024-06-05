<%-- 
    Document   : InsuranceClaimPage
    Created on : 31 Mar, 2023, 12:47:33 PM
    Author     : Dell
--%>

<%@page import ="insurance.pojo.* , java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="./stylesheets/InsuranceHome.css" />
    <link rel="icon" href="../src/imges/长.png" style="width: 30px" />
  </head>
  <body onkeyup="load()">
      <%
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
      %>
    <div id="maindiv">
      <div id="sidenav">
        <h3>Star Health Inc.</h3>
        <div id="dashboard">
          <p id="head">DASHBOARD</p>
          <a href="/index.html">
            <div class="dashboarditems" id="home">
              <i class="ri-home-5-line icons"></i>
              <p class="entries">Home</p>
            </div>
          </a>
          <a href="#">
            <div class="dashboarditems active" id="app">
              <i class="ri-health-book-line"></i>
              <p class="entries">Claim Request</p>
            </div>
          </a>
          <a href="#">
            <div class="dashboarditems" id="pat">
              <i class="ri-empathize-line"></i>
              <p class="entries">Clients</p>
            </div>
          </a>
          <a href="#">
            <div class="dashboarditems" id="pr">
              <i class="ri-exchange-funds-line"></i>
              <p class="entries">Request History</p>
            </div>
          </a>
          <!-- <div id="banner"> -->
          <!-- <div id="text">
                <p>Let's upgrade your plan</p>
                <i class="ri-arrow-right-s-line"></i>
            </div>
            <img src="/3.png" alt=""> -->
          <a class="card1" href="#">
            <p>Let's upgrade your plan</p>
            <img src="./images/12083074_Wavy_Bus-03_Single-06.png" alt="" />
            <div class="go-corner" href="#">
              <div class="go-arrow"><i class="ri-arrow-right-s-line"></i></div>
            </div>
          </a>
          <!-- </div> -->
        </div>
      </div>
      <div id="midsection">
        <div id="roomnav">
          <div id="left">
            <h3>Recent Claim Requests</h3>
            <p>sorted in order of arrival</p>
          </div>
          <div id="mid">
            <!-- <p>Search By</p> -->
            <input type="search" placeholder="medical IDs, or number" />
            <i class="ri-search-line"></i>
          </div>
        </div>
          <%!
              ArrayList<ClaimDetailsPojo> cdp;
              
          %>
          <%
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
              
          %>
          <div id="notifdiv" class="${disp}">
          <div id="upper">
            <i class="ri-hospital-line"></i>
            <h3>Multi Speciality Hospital</h3>
          </div>
          
          <%
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
          %> 
<!--          
            <h3>Claim Id</h3>
            <span>319384</span>-->
         
<!--          <div id="claimdes">
            <p>
              _ClaimDes Lorem, ipsum dolor sit amet consectetur adipisicing
              elit. Accusamus aperiam expedita reprehenderit.
            </p>
          </div>-->
          <div id="claimamt">
            <h4 id="blck">Total Expenses</h4>
            <div id="amt">
              <h4>${value}</h4>
              <span>Rs. /-</span>
            </div>
            <div id="inwords"></div>
          </div>
          <div id="bottom">
<!--            <button class="button-57" role="button" id="cancel">
              <span class="text"><i class="ri-close-line"></i></span>
              <span
                >Cancel Claim <br />
                Req.</span
              >
            </button>-->
            <a href="InsuranceRevertReq?user=${Name}&status='Unsuccessfull'">
            <button class="button-57" role="button" id="revert">
              <span class="text"><i class="ri-arrow-go-forward-line"></i></span>
              <span
                >Revert Claim <br />
                Req.</span
              >
            </button>
            </a>
            <a href="InsuranceRevertReq?user=${Name}&status='Successfull'">
            <button class="button-57" role="button" id="accept">
              <span class="text"><i class="ri-check-line"></i></span>
              <span
                >Proceed Claim <br />
                Req.</span
              >
            </button>
            </a>
            <!-- <button class="button-86" role="button">Cancel</button> -->
            <!-- <button id="cncl">Cancel</button> -->
            <!-- <button class="button-86" role="button">Revert</button> -->
            <!-- <button id="rvrt">Revert</button> -->
            <!-- <button class="button-86" role="button">Approve</button> -->
            <!-- <button id="aprv">Approve</button> -->
          </div>
        </div>
      </div>
      <div id="profilesection">
        <div class="showdiv">
          <p>Patient</p>
          <i class="ri-arrow-right-s-line blue"></i>
          <p class="blue">Patient Profile</p>
        </div>
        <div id="card">
          <p class="grey">YOUR INSURANCE CLIENT</p>
          <img
            src="https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436188.jpg?w=740&t=st=1680213087~exp=1680213687~hmac=895ba1207267b51fd1e7fe150f44d77fab0d736f3028d783a40edc6059711da1"
            alt=""
          />
          <div id="det">
            <div id="prf">
              <h3>${Name}</h3>
              <p class="grey">${Age} years old, ${Gender}</p>
              <p class="grey">${Email}</p>
            </div>
            <h4>${Id}</h4>
            <div class="mini">
              <p>Status:</p>
              <span><i class="${icon}"></i>${text}</span>
            </div>
            <div class="mini">
              <p>Policy:</p>
              <span id="orng">${claimAmt} / year</span>
            </div>
          </div>
        </div>
      </div>
    </div>
            <script >
                function load()
                {
                    console.log("Peek");
                    location.href= "<%=url%>";
                }
            </script>
  </body>
</html>

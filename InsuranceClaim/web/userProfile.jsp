
<%@page import="insurance.pojo.* , java.util.*" contentType="text/html" pageEncoding="UTF-8"  %>
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
    <link rel="stylesheet" href="./stylesheets/userProfile.css" />
    
    <link rel="icon" href="../src/imges/长.png" style="width: 30px" />
  </head>
  <body onkeyup="reload()">

       <%
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
        %>
    <div id="main">
      <div id="roomnav">
        <div id="left">
          <h2>DashBoard , ${Name}</h2>
        </div>
        <div id="mid">
          <input type="search" placeholder="find policies by name/provider" />
          <i class="ri-search-line"></i>
        </div>
        <div id="right">
          <i class="ri-home-fill" onclick="toggle(document.getElementById('revertdiv').id)"></i>
          <i class="ri-bookmark-3-fill"></i>
          <%!
              ArrayList<ClaimDetailsPojo> cdp;
              String amount="";
          %>
          <%
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



          %>
          <i class="${notify}" onclick="toggle(document.getElementById('notifdiv').id)"><button ></button></i>
        </div>
      </div>

      <div id="mainDash">
        <div id="back">
          <i class="ri-arrow-left-line"></i>
          <p>Back to home page</p>
        </div>

        <div id="heading">
          <h3>Policy Name 01</h3>
          <div id="${i}">
            <i class="${icon}"></i>
            <h4>${text}</h4>
          </div>
        </div>
        <div id="slidemenu">
          <div id="info">
            <p>Information</p>
          </div>
          <div id="logs">
            <p>Recent Logs</p>
            <div id="notif">
              <p>8</p>
            </div>
          </div>
        </div>
        <div id="boderdiv">
          <div id="cover"></div>
        </div>
        <div id="collapse">
          <div id="infodiv">
            <div class="det">
              <p>ID</p>
              <p>Policy Holder</p>
              <p>Policy Provider</p>
              <p>Email Id</p>
              <p>Age</p>
              <p>Gender</p>
              <p>Max Claim per year</p>
              <p>Aadhar No.</p>
            </div>
            <div class="entries">
              <p>${Id}</p>
              <p>${Name}</p>
              <p>${InsComp}</p>
              <p>${Email}</p>
              <p>${Age}</p>
              <p>${Gender}</p>
              <p>${claimAmt}</p>
              <p>${AadharNo}</p>
            </div>
          </div>
          <div id="logdiv">
            <div id="timeline"></div>
            <ul>
              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>
              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>
              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>
              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>
              <li>Lorem ipsum dolor sit amet consectetur adipisicing elit.</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div id="notifdiv">
      <div id="upper">
        <i class="ri-notification-3-fill"></i>
        <h3>New Notification</h3>
      </div>
      <div id="details">
        <div id="from">
          <p>From:</p>
          <div class="det">
            <h4>${hospName}</h4>
          </div>
        </div>
        <div id="to">
          <p>To:</p>
          <div class="det">
            <h4>${insComp}</h4>
          </div>
        </div>
      </div>
      <div id="claimhead" class="${disp}">
          <h3>
              <%
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
               %>
          </h3>
      </div>
      <div id="claimamt" class="${disp}">
        <h4 id="blck">Total Expenses</h4>
        <div id="amt">
          <h4>${value}</h4>
          <span>Rs. /-</span>
        </div>
        <div id="inwords">
        </div>
      </div>
      <div id="bottom">
        <button class="button-57" role="button" id="cancel">
          <span class="text"><i class="ri-close-line"></i></span>
          <span>Cancel Claim <br />
            Req.
          </span>
        </button>
          <a href="RevertRequestServlet?user=${Name}&status='Unsuccessfull'">
          <button class="button-57" role="button" id="revert" type="submit">
          <span class="text"><i class="ri-arrow-go-forward-line"></i></span>
          <span>Revert Claim <br />
            Req.
          </span>
        </button>
          </a>
          <a href="RevertRequestServlet?user=${Name}&status='Successfull'">
        <button class="button-57" role="button" id="accept">
          <span class="text"><i class="ri-check-line"></i></span>
          <span
            >Proceed Claim <br />
            Req.</span
          >
        </button>
          </a>
      </div>
    </div>
        <%
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
        %>
        
        <div id="revertdiv">
      <div id="upper">
        <i class="ri-emotion-unhappy-line" id="ex"></i>
        <!-- <ion-icon id="ex" name="alert-circle-outline"></ion-icon> -->
        <h3>Reverted Cla<span>!</span>m Req.</h3>
      </div>
      <div id="details">
        <div id="from">
          <p>From:</p>
          <div class="det">
            <h4>${InsComp}</h4>
          </div>
        </div>
        <div id="to">
          <p>To:</p>
          <div class="det">
            <h4>${hospName}</h4>
          </div>
        </div>
      </div>
      <div id="claimhead" class='${disp}' >
          <%
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
          %>

      </div>
      <div id="claimdes" class='${disp}'>
        <h3>Cause:</h3>
        <p>
          The requested services or treatment
          are not covered by the policy or Insufficient 
          or inaccurate information has been provided.
        </p>
      </div>
      <div id="claimamt" class='${disp}'>
        <h4 id="blck">Total Expenses</h4>
        <div id="amt">
          <h4>${sum}</h4>
          <span>Rs. /-</span>
        </div>
        <div id="inwords"></div>
      </div>
      <div id="processing" class='${disp}'>
        <img src="./images/40d8473e8faebf9ec7bc878f8969af0d.gif" alt="" />
        <h4>Your hospital is processing this request. </h4> 
      </div>
      <div id="bottom" >
<!--         <button class="button-57" role="button" id="cancel">
          <span class="text"><i class="ri-close-line"></i></span>
          <span
            >Cancel Claim <br />
            Req.</span
          >
        </button>
        <button class="button-57" role="button" id="revert">
          <span class="text"><i class="ri-arrow-go-forward-line"></i></span>
          <span
            >Revert Claim <br />
            Req.</span
          > 
        </button>-->
        <button class="button-57 okay" role="button" id="accept">
          <span class="text"><i class="ri-check-line"></i></span>
          <span
            >Okay   </span
          >
        </button>
      </div>
    </div>
        <script>
      var info = document.querySelector("#info");
      var logs = document.querySelector("#logs");
      var cover = document.querySelector("#cover");
      var infodiv = document.querySelector("#infodiv");
      var logdiv = document.querySelector("#logdiv");
      var det = document.querySelector(".det");
      var entries = document.querySelector(".entries");
      var notify = document.querySelector("#notify");
      var notifdiv = document.querySelector("#notifdiv");

      logs.addEventListener("click", () => {
        cover.style.left = "51%";
        // det.style.display = "none";
        // entries.style.display = "none";
        infodiv.style.height = "0%";
        logdiv.style.height = "100%";
      });
      info.addEventListener("click", () => {
        cover.style.left = "7%";
        infodiv.style.height = "100%";
        logdiv.style.height = "0%";
      });
      
      function reload()
      {
          location.href="<%= url%>";
      }
      
      // let flag = false;
      // const information = () => {};

      // const recentLogs = () => {};

      function toggle(param) {
        var main = document.querySelector("#main");
        main.classList.toggle("active");

        var id = document.getElementById(param);
        // var notifdiv = document.getElementById("notifdiv");
        id.classList.toggle("active");
      }

      var cancel = document.querySelector("#cancel");
      cancel.addEventListener("click", () => {
        location.reload();
      });

      var okay = document.querySelector(".okay");
      okay.addEventListener("click", () => {
        location.reload();
      });

      inwords();
      
      
      
      function inwords() {
        // const num = document.getElementById("num");
        const inwords = document.getElementById("inwords");
        const num = '<%=amount%>';
        console.log('<%=amount%>');
        const ones = {
          0: "Zero",
          1: "One",
          2: "Two",
          3: "Three",
          4: "Four",
          5: "Five",
          6: "Six",
          7: "Seven",
          8: "Eight",
          9: "Nine",
          10: "Ten",
          11: "Eleven",
          12: "Twelve",
          13: "Thirteen",
          14: "Fourteen",
          15: "Fifteen",
          16: "Sixteen",
          17: "Seventeen",
          18: "Eighteen",
          19: "Nineteen",
        };

        const prefixes = {
          2: "Twenty",
          3: "Thirty",
          4: "Fourty",
          5: "Fifty",
          6: "Sixty",
          7: "Seventy",
          8: "Eighty",
          9: "Ninety",
        };

        // event.preventDefault();

        if (+num in ones) {
          inwords.innerHTML = ones[+num] + " Rs. /-";
        }

        const numArray = num.split("");
        if (numArray.length === 2 && +num > 19) {
          inwords.innerHTML = prefixes[numArray[0]] + " " + ones[numArray[1]] + " Rs. /-";
        }

        if (numArray.length === 3) {
          if (+numArray[1] === 0) {
            inwords.innerHTML =
              ones[numArray[0]] + " hundred " + " " + ones[numArray[2]] + " Rs. /-";
          } else if (+numArray[1] < 2) {
            inwords.innerHTML =
              ones[numArray[0]] +
              " hundred " +
              " " +
              ones[+[numArray[1], numArray[2]].join("")] + " Rs. /-";
          } else {
            inwords.innerHTML =
              ones[numArray[0]] +
              " hundred " +
              prefixes[numArray[1]] +
              " " +
              ones[numArray[2]] + " Rs. /-";
          }
        }

        if (numArray.length === 4) {
          if (+numArray[1] === 0) {
            inwords.innerHTML =
              ones[numArray[0]] +
              " thousand " +
              " " +
              ones[+[numArray[2], numArray[3]].join("")] + " Rs. /-";
          } else if (+numArray[1] < 2) {
            inwords.innerHTML =
              ones[numArray[0]] +
              " thousand " +
              ones[numArray[1]] +
              " hundred " +
              " " +
              ones[+[numArray[2], numArray[3]].join("")] + " Rs. /-";
          } else {
            inwords.innerHTML =
              ones[numArray[0]] +
              " thousand " +
              ones[numArray[1]] +
              " hundred " +
              prefixes[numArray[2]] +
              " " +
              ones[numArray[3]] + " Rs. /-";
          }
        }
      } 
        </script> 
  </body>
</html>

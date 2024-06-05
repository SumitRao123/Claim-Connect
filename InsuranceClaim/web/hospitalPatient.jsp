<%@page import="insurance.pojo.*, insurance.controller.*" contentType="text/html" pageEncoding="UTF-8"%>
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
    <link
      rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
    <link rel="stylesheet" href="./stylesheets/hospitalHome.css" />
    <link rel="icon" href="../src/imges/长.png" style="width: 30px" />
  </head>
<body onload="StartGame()">
    <%!
          String ImgName="";
          String heading="",desc="";
          long amt=0l;
      %>
<%
          
          PatientPojo p=(PatientPojo)request.getAttribute("patientDetail");
          request.setAttribute("cl", "display-none");
          if(p!=null)
          {
            request.setAttribute("Id",p.getUniqueId());
            request.setAttribute("Name",p.getName());
            request.setAttribute("Gender",p.getGender());
            request.setAttribute("Age",p.getAge());
            request.setAttribute("Email",p.getEmail());
            request.setAttribute("Status",p.getCurrentStatus());
            request.setAttribute("InsComp",p.getCompName());
            request.setAttribute("claimAmt",p.getMaxLimit());
            request.setAttribute("AadharNo",p.getAadharNo());
            request.setAttribute("CurrentLimit",p.getCurrentAmount());
            request.setAttribute("cl", "display");
          }
          
          ClaimDetailsPojo cdp=(ClaimDetailsPojo)request.getAttribute("claimDetails");
          if(cdp!=null)
          {
              ImgName=cdp.getImgName();
              System.out.println("Bill//"+ImgName);
              request.setAttribute("claimHeading",cdp.getClaimHeading());
              request.setAttribute("claimDesc",cdp.getTreatmentDesc());
              request.setAttribute("claimAmount",cdp.getClaimAmount());
              request.setAttribute("billName",cdp.getImgName());
              request.setAttribute("claimUserName",cdp.getUserName());
              request.setAttribute("claimId",cdp.getClaimId());
              heading=cdp.getClaimHeading();
              amt=cdp.getClaimAmount();
              desc=cdp.getTreatmentDesc();
          }
      %>
      
  <div id="maindiv">
    <div id="sidenav">
      <h3>Multi Speciality Hospital</h3>
      <div id="dashboard">
        <p>DASHBOARD</p>
        <a href="hospitalHome.jsp" >
          <div class="dashboarditems" id="home">
            <i class="ri-home-5-line icons"></i>
            <p class="entries">Home</p>
          </div>
        </a>
        <a href="hospitalAppointment.jsp">
          <div class="dashboarditems" id="app">
            <i class="ri-calendar-2-line icons"></i>
            <p class="entries">Appointments</p>
          </div>
        </a>
        <a href="hospitalPatient.jsp" >
          <div class="dashboarditems active" id="pat">
            <i class="ri-user-add-line icons"></i>
            <p class="entries">Patients</p>
          </div>
        </a>
        <a href="hospitalPendingReq.jsp">
          <div class="dashboarditems" id="pr">
            <i class="ri-book-read-line icons"></i>
            <p class="entries">Pending Request</p>
          </div>
        </a>
      </div>
    </div>
    <div id="profilesection">
      <div id="roomnav">
        <div id="mid">
          <i class="ri-search-line"></i>
          <p>Search By</p>
          <form action="SearchPatient" method="Post">
                <input type="search" placeholder="medical IDs, or number"  name="id"/>
            </form>
        </div>
        <div id="right">
          <a href=""><i class="ri-home-fill"></i></a>
          <a href=""><i class="ri-bookmark-3-fill"></i></a>
          <a href=""><i class="ri-map-pin-fill"></i></a>
        </div>
      </div>
        <div class="${cl}"> 
      <div class="showdiv">
        <p>Patient</p>
        <i class="ri-arrow-right-s-line blue"></i>
        <p class="blue">Patient Profile</p>
      </div>
      <div id="profilediv">
        <div id="profile">
          <img
            src="https://img.freepik.com/premium-vector/anonymous-user-circle-icon-vector-illustration-flat-style-with-long-shadow_520826-1931.jpg"
            alt="" />
          <div id="name">
             <h3>${Name}</h3>
              <p class="grey">${Age} Years Old, ${Gender}</p>
          </div>
        </div>
        <div id="details">
          <div id="company">
            <p class="grey">Insurance Provider</p>
            <h4>${InsComp}</h4>
          </div>
          <div id="credit">
            <p class="grey">Credit Left</p>
           <h4>${CurrentLimit}</h4>
          </div>
        </div>
        <div id="initiate">
          <button id="claim" onclick="toggle()">new claim</button>
          <button id="calluser"><i class="ri-phone-line"></i></button>
        </div>
      </div>
      <div id="infodiv">
        <div class="det">
          <p>ID</p>
          <p>Current Status</p>
          <p>Email Id</p>
          <p>Max Claim per year</p>
          <p>Aadhar No.</p>
        </div>
        <div class="entries">
            <p>${Id}</p>
            <p>${Status}</p>
            <p>${Email}</p>
            <p>${claimAmt}</p>
            <p>${AadharNo}</p>
        </div>
      </div>
      <div class="showdiv newshowdiv" class="${cl}">
        <p>Claims</p>
        <i class="ri-arrow-right-s-line blue"></i>
        <p class="blue">Claims List</p>
      </div>

      <div id="detailsection" >
        <div class="forwardBtn">
            <button id="sendreq" ><i class="ri-send-plane-fill"></i></button>
        </div>
      </div>
    </div>
    </div>
  </div>
  <div class="container">
    <header>Signup Form</header>
    <div class="progress-bar">
      <div class="step">
        <p>Claim</p>
        <div class="bullet">
          <span>1</span>
        </div>
        <div class="check fas fa-check"></div>
      </div>
      <div class="step">
        <p>Treament</p>
        <div class="bullet">
          <span>2</span>
        </div>
        <div class="check fas fa-check"></div>
      </div>
      <div class="step">
        <p>Amount</p>
        <div class="bullet">
          <span>3</span>
        </div>
        <div class="check fas fa-check"></div>
      </div>
      <div class="step">
        <p>Bills</p>
        <div class="bullet">
          <span>4</span>
        </div>
        <div class="check fas fa-check"></div>
      </div>
    </div>
    <div class="form-outer">
      <form action="HospitalClaim?name=${Name}&id=${Id}&ins=${InsComp}&hosp='Multi Speciality Hospital' " method="post" enctype="multipart/form-data" id="claimform">
        <div class="page slide-page">
          <div class="title">What is this claim about ?</div>
          <div class="field">
            <!-- <div class="label">
                      First Name
                   </div> -->
            <input id="claimname" type="text"  name="claimname" placeholder="enter treatment name" />
          </div>
          <!-- <div class="field">
                   <div class="label">
                      Last Name
                   </div>
                   <input type="text">
                </div> -->
          <div class="field">
            <button class="firstNext next">Next</button>
          </div>
        </div>
        <div class="page">
          <div class="title">Synopsis Details</div>
          <div class="field">
            <!-- <div class="label">
                      Email Address
                   </div> -->
            <input id="claimdes" type="text" name="claimdes" placeholder="enter abour medication" />
          </div>
          <!-- <div class="field">
                   <div class="label">
                      Phone Number
                   </div>
                   <input type="Number">
                </div> -->
          <div class="field btns">
            <button class="prev-1 prev">Previous</button>
            <button class="next-1 next">Next</button>
          </div>
        </div>
        <div class="page">
          <div class="title">Amount spent on this treatment</div>
          <div class="field">
            <!-- <div class="label">Date</div> -->
            <!--<input type="text"> -->
            <!-- <label for="currency-field">Enter Amount</label> -->
            <input type="text" name="currency-field" id="currency-field"  placeholder="enter amount to be claimed" />
          </div>
          <!-- <div class="field">
              <div class="label">Gender</div>
              <select>
                <option>Male</option>
                <option>Female</option>
                <option>Other</option>
              </select>
            </div> -->
          <div class="field btns">
            <button class="prev-2 prev">Previous</button>
            <button class="next-2 next">Next</button>
          </div>
        </div>
        <div class="page">
          <div class="title">Bills of expenditure</div>
          <div class="field">
            <!-- <div class="label">Username</div> -->
            <input type="file" name="bill" />
          </div>
          <!-- <div class="field">
              <div class="label">Password</div>
              <input type="password" />
            </div> -->
          <div class="field btns">
            <button class="prev-3 prev">Previous</button>
            <button class="submit" onclick="toggle()">Submit</button>
          </div>
        </div>
      </form>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
  <script>
      
function toggle() {
  var maindiv = document.querySelector("#maindiv");
  maindiv.classList.toggle("active");
  var container = document.querySelector(".container");
  container.classList.toggle("active");
}

/* Form Validation Code */
const slidePage = document.querySelector(".slide-page");
const nextBtnFirst = document.querySelector(".firstNext");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".next-1");
const prevBtnThird = document.querySelector(".prev-2");
const nextBtnThird = document.querySelector(".next-2");
const prevBtnFourth = document.querySelector(".prev-3");
const submitBtn = document.querySelector(".submit");
const progressText = document.querySelectorAll(".step p");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");
let current = 1;
nextBtnFirst.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "-25%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
nextBtnSec.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "-50%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
nextBtnThird.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "-75%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
submitBtn.addEventListener("click", function () {
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
  setTimeout(function () {
    alert("Your Form Successfully Signed up");
    location.reload();
  }, 800);
});
prevBtnSec.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "0%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});
prevBtnThird.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "-25%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});
prevBtnFourth.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "-50%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});

/* Input Type Currency */

$("input[data-type='currency']").on({
  keyup: function () {
    formatCurrency($(this));
  },
  blur: function () {
    formatCurrency($(this), "blur");
  },
});

function formatNumber(n) {
  // format number 1000000 to 1,234,567
  return n.replace(/\D/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function formatCurrency(input, blur) {
  // appends $ to value, validates decimal side
  // and puts cursor back in right position.

  // get input value
  var input_val = input.val();

  // don't validate empty input
  if (input_val === "") {
    return;
  }

  // original length
  var original_len = input_val.length;

  // initial caret position
  var caret_pos = input.prop("selectionStart");

  // check for decimal
  if (input_val.indexOf(".") >= 0) {
    // get position of first decimal
    // this prevents multiple decimals from
    // being entered
    var decimal_pos = input_val.indexOf(".");

    // split number by decimal point
    var left_side = input_val.substring(0, decimal_pos);
    var right_side = input_val.substring(decimal_pos);

    // add commas to left side of number
    left_side = formatNumber(left_side);

    // validate right side
    right_side = formatNumber(right_side);

    // On blur make sure 2 numbers after decimal
    if (blur === "blur") {
      right_side += "00";
    }

    // Limit decimal to only 2 digits
    right_side = right_side.substring(0, 2);

    // join number by .
    input_val = "$" + left_side + "." + right_side;
  } else {
    // no decimal entered
    // add commas to number
    // remove all non-digits
    input_val = formatNumber(input_val);
    input_val = "$" + input_val;

    // final formatting
    if (blur === "blur") {
      input_val += ".00";
    }
  }

  // send updated string to input
  input.val(input_val);

  // put caret back in the right position
  var updated_len = input_val.length;
  caret_pos = updated_len - original_len + caret_pos;
  input[0].setSelectionRange(caret_pos, caret_pos);
}

// submit.addEventListener("click", function () {
//   var div = document.createElement("div");
//   div.classList.add("claimdet");
//   div.innerHTML = `<div id="profilediv">
//               <div id="profile">
//                 <img
//                   src="https://img.freepik.com/premium-vector/anonymous-user-circle-icon-vector-illustration-flat-style-with-long-shadow_520826-1931.jpg"
//                   alt=""
//                 />
//                 <div id="name">
//                   <h3>_Sahil Saxena</h3>
//                   <p class="grey">_21 Years Old, _Male</p>
//                 </div>
//               </div>
//               <div id="details">
//                 <div id="company">
//                   <p class="grey">Insurance Provider</p>
//                   <h4>_Birla Insurance</h4>
//                 </div>
//                 <div id="credit">
//                   <p class="grey">Credit Left</p>
//                   <h4>_2.3 Lacs</h4>
//                 </div>
//               </div>
//               <div id="initiate">
//                 <button id="claim" onclick="toggle()">new claim</button>
//                 <button id="calluser"><i class="ri-phone-line"></i></button>
//               </div>
//             </div>`;
//   detailsection.appendChild(div);
// });

// var arr = [];

// form
var claimform = document.querySelector("#claimform");

// imput fields
var claimname = document.querySelector("#claimname");
var claimdes = document.querySelector("#claimdes");
var currencyfield = document.querySelector("#currency-field");

claimform.addEventListener("submit", () => {
  var ip1 = claimname.value;
  var ip2 = claimdes.value;
  var ip3 = currencyfield.value;

  var obj = {
    ip1: ip1,
    ip2: ip2,
    ip3: ip3,
  };
  // arr.push(obj);
  localStorage.setItem(++localStorage.length, JSON.stringify(obj));
  // let stored = JSON.parse(localStorage.getItem(`data${i}`));
});
// console.log(i);

var submit = document.querySelector(".submit");
var detailsection = document.querySelector("#detailsection");

function StartGame() {
  var i = localStorage.length;
  for (var x = 0; x < i; x++) {
    var temp = x + 1;
    let ip1 = JSON.parse(localStorage.getItem(temp+"")).ip1;
    let ip2 = JSON.parse(localStorage.getItem(temp+"")).ip2;
    let ip3 = JSON.parse(localStorage.getItem(temp+"")).ip3;
    var temp=10;
    console.log(ip1+" "+ip2+" "+ip3);
    var div = document.createElement("div");
    div.classList.add("claimdet");
            div.innerHTML = "<div class='claimdiv'>"+
            "<div class='claim'>"+
              "<img src= 'https://static.vecteezy.com/system/resources/previews/002/641/198/original/invoice-icon-vector.jpg'/>"+
              "<div class='claimhead'><h3>"+ip1+"</h3><p class='grey towrap'>"+ip2+"</p></div></div>"+
            "<div class='claimdetails'>"+
              "<div class='amount'>"+
                "<p class='grey'>Sum</p>"+
                "<h4>Rs."+ip3+" </h4>"+
              "</div>"+
              "<div class='docs'>"+
                "<p class='grey'>Doc.</p>"+
                "<h4><i class='ri-download-line'></i></h4>"+
              "</div>"+
            "</div>"+
          "</div>";
    detailsection.appendChild(div);
  }
}

if(localStorage.length > 0){
  document.querySelector("#sendreq").style.display = "initial";
  document.querySelector(".newshowdiv").style.display = "flex";
}

  </script>
</body>
</html>

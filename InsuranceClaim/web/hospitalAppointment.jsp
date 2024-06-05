<%-- 
    Document   : hospitalAppointment
    Created on : 30 Mar, 2023, 4:43:19 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="./stylesheets/hospitalHome.css" />
    <link rel="icon" href="../src/imges/长.png" style="width: 30px" />
  </head>
  <body>

    <div id="maindiv">
      <div id="sidenav">
        <h3>Multi Speciality Hospital</h3>
        <div id="dashboard">
          <p>DASHBOARD</p>
          <a href="hospitalHome.jsp">
            <div class="dashboarditems " id="home">
              <i class="ri-home-5-line icons"></i>
              <p class="entries">Home</p>
            </div>
          </a>
          <a href="hospitalAppointment.jsp">
            <div class="dashboarditems active" id="app">
              <i class="ri-calendar-2-line icons"></i>
              <p class="entries">Appointments</p>
            </div>
          </a>
          <a href="hospitalPatient.jsp">
            <div class="dashboarditems " id="pat">
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
    </div>
    <script src="./Js/hospitalHome.js"></script>
  </body>
</html>


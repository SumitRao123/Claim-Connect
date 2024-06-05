
<%@page import="insurance.dbutil.* , insurance.controller.* , insurance.pojo.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Claim Details</title>
    </head>
    <body>
        <%
            ClaimDetailsPojo c=(ClaimDetailsPojo)request.getAttribute("claimDetails");
            request.setAttribute("Id",c.getClaimId());
            request.setAttribute("Name",c.getUserName());
            request.setAttribute("Heading",c.getClaimHeading());
            request.setAttribute("Desc",c.getTreatmentDesc());
            request.setAttribute("Amount",c.getClaimAmount());
            request.setAttribute("Img",c.getImgLoaction());
            request.setAttribute("ImgName",c.getImgName());
        %>
        <h1>Hello ${Name}</h1>
        <p>Claim id ${Id}</p>
        <p>Claim Heading : ${Heading}</p>
        <p>Description : ${Desc}</p>
        <p>Amount : ${Amount}</p>
        <img src="Bill//insatgram.jpeg" width="250px" height="250px"/>
    </body>
</html>

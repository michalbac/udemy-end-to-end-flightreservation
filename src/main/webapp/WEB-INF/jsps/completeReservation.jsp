<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Complete Reservation</title>
</head>
<body>
<h2>Complete reservation</h2>
Airline: ${flight.operatingAirlines}<br>
From: ${flight.departureCity}<br>
To: ${flight.arrivalCity}<br>

<form action="completeReservation" method="post">
    <pre>
    <h2>Passenger Details:</h2>
    First name:<input type="text" name="passengerFirstName">
    Last name:<input type="text" name="passengerLastName">
    Email:<input type="text" name="passengerEmail">
    Phone:<input type="text" name="passengerPhone">
<h2>Card details:</h2>
    Name on the card:<input type="text" name="nameOnTheCard">
    Card no:<input type="text" name="cardNumber">
    Expire Date:<input type="text" name="expireDate">
    Security code:<input type="text" name="securityCode">
        <input type="hidden" name="flightId" value="${flight.id}">
    <input type="submit" value="confirm">
         </pre>
</form>
</body>
</html>
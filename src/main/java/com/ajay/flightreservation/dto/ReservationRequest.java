package com.ajay.flightreservation.dto;

public class ReservationRequest {
private Long flightId;
private String passengerFirstName ;
private String passengerLastName ;
private String passengerEmail ;
private String passengerPhone ;
private String nameOncard ;
private String cardNumber ;
private String expirationDate ;
private String securityCode ;
public Long getFlightId() {
	return flightId;
}
public String getPassengerFirstName() {
	return passengerFirstName;
}
public String getPassengerLastName() {
	return passengerLastName;
}
public String getPassengerEmail() {
	return passengerEmail;
}
public String getPassengerPhone() {
	return passengerPhone;
}
public String getNameOncard() {
	return nameOncard;
}
public String getCardNumber() {
	return cardNumber;
}
public String getExpirationDate() {
	return expirationDate;
}
public String getSecurityCode() {
	return securityCode;
}
public void setFlightId(Long flightId) {
	this.flightId = flightId;
}
public void setPassengerFirstName(String passengerFirstName) {
	this.passengerFirstName = passengerFirstName;
}
public void setPassengerLastName(String passengerLastName) {
	this.passengerLastName = passengerLastName;
}
public void setPassengerEmail(String passengerEmail) {
	this.passengerEmail = passengerEmail;
}
public void setPassengerPhone(String passengerPhone) {
	this.passengerPhone = passengerPhone;
}
public void setNameOncard(String nameOncard) {
	this.nameOncard = nameOncard;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public void setExpirationDate(String expirationDate) {
	this.expirationDate = expirationDate;
}
public void setSecurityCode(String securityCode) {
	this.securityCode = securityCode;
}
@Override
public String toString() {
	return "ReservationRequest [flightId=" + flightId + ", passengerFirstName=" + passengerFirstName
			+ ", passengerLastName=" + passengerLastName + ", passengerEmail=" + passengerEmail + ", passengerPhone="
			+ passengerPhone + ", nameOncard=" + nameOncard + ", cardNumber=" + cardNumber + ", expirationDate="
			+ expirationDate + ", securityCode=" + securityCode + "]";
}

	
}

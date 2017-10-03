/**************************************************************************
program Name: Validation file 
Description : validation for 
				1:User Full Name
				2:User Name
				3:Password
				4:Contact Number
				5:Email Id
				6:Card -16 digit input 
				7:Visa Card Number
				8:Master Card Number
Version:1
Date: 29/09/2017
Author:Nisha Bagal
**************************************************************************/


/*------------------- User Full Name-------------------*/
/************************************************************
First and Last Name
************************************************************/
function validateName()
{
	var name = document.getElementById("uname").value;
	var regex = /^(?:[A-Z][a-z]*\s{1}(?:[A-Z][a-z]*))$/;
	
	if(name.length==0)
	{
		producePrompt("Enter first and last name","namePrompt","red");
		return false;
	}
	if((name.length > 0) && (!name.match(regex)))
	{
		producePrompt(" First letter uppercase ","namePrompt","Blue");
			return false;
	}
	if(!name.match(regex))
		{
			producePrompt(" First and Last Name required ","namePrompt","Blue");
			return false; 
		}
		producePrompt(" Welcome " + name,"namePrompt","green");
		return true;
}

/*------------------- User Name-------------------*/
/************************************************************
User Name should start with characters and it can take numeric digit 
************************************************************/
function validateUserName()
{
	var phone=document.getElementById("username").value;
	var regex = /^(?:[A-Za-z]\w{5,8})$/;
	if((phone.length < 5) || (phone.length > 8))
	{
		producePrompt("min 5 and max 8 characters required","usernamePrompt","red");
		return false;
	}
	if(phone.length==0)
	{
		producePrompt("username is required","usernamePrompt","red");
		return false;
		
	}
	if(!phone.match(regex))
		{
			producePrompt("enter a valid username","usernamePrompt","red");
			return false;
			
		}
		producePrompt("valid username","usernamePrompt","green");
		return true;
}


/*------------------- Password-------------------*/
/************************************************************
Password should consist of one uppercase,one lowercase letter, one numeric digit
************************************************************/
function validatePassword()
{
	var Pass=document.getElementById("upassword").value;
	if(Pass.length==0)
	{
		producePrompt("at least one numeric digit, one uppercase, and one lowercase letter and between 6-8","passwordPrompt","red");
		return false;
		
	}
	if(!Pass.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,8}$/))
		{
			producePrompt("error","passwordPrompt","red");
			return false;
			
		}
		producePrompt("correct","passwordPrompt","green");
		return true;
}


/*------------------- Contact Number-------------------*/
/************************************************************
10 digit number 
************************************************************/

function validatePhone()
{
	var phone=document.getElementById("uphone").value;
	if(phone.length==0)
	{
		producePrompt("phone number is required","phonePrompt","red");
		return false;
		
	}
	if(!phone.match(/^[0-9]{10}$/))
		{
			producePrompt("please only include digits","phonePrompt","red");
			return false;
			
		}
		producePrompt("valid number","phonePrompt","green");
		return true;
}


/*------------------- Email-------------------*/
function validateEmail()
{
	var Email = document.getElementById("uemail").value;
	if(Email.length==0)
	{
		producePrompt("email is Required","emailPrompt","red");
		return false;
	}
	if(!Email.match(/^[a-z\._\-0-9]*[@][A-Za-z]*[\.][a-z]{2,3}$/))
		{
			producePrompt(" enter valid email ","emailPrompt","Blue");
			return false; 
		}
		producePrompt(" valid email" ,"emailPrompt","green");
		return true;
}

/*------------------- Card Number-------------------*/
/************************************************************
 16 digit number 
************************************************************/

function validateCardNumber()
{
	var Card=document.getElementById("ucardnumber").value;
	if(Card.length==0)
	{
		producePrompt("Enter 16 digit card number","cardnumberPrompt","red");
		return false;
		
	}
	if(!Card.match(/^[0-9]{16}$/))
		{
			producePrompt("please enter 16 digits","cardnumberPrompt","red");
			return false;
			
		}
		producePrompt("valid number","cardnumberPrompt","green");
		return true;
}

/*------------------- Visa Card Number-------------------*/
/************************************************************
Visa Card number's first digit should be 4
************************************************************/
function validateVisaCreditCardNumber()
{
	var Card=document.getElementById("uvisacardnumber").value;
	var regex = /^(?:4[0-9]{15})$/;
	if(Card.length==0)
	{
		producePrompt("Enter 16 digit visa credit card number","visacardnumberPrompt","red");
		return false;
		
	}
	if(!Card.match(regex))
		{
			producePrompt("please enter 16 digits","visacardnumberPrompt","red");
			return false;
			
		}
		producePrompt("valid number","visacardnumberPrompt","green");
		return true;
}

/*------------------- Master Card Number-------------------*/
/************************************************************
Master Card number's first two digit should be between 51-55
************************************************************/

function validateMasterCardNumber()
{
	var Card=document.getElementById("umastercardnumber").value;
	var regex = /^(?:5[1-5][0-9]{14})$/;
	if(Card.length==0)
	{
		producePrompt("Enter 16 digit card number","mastercardnumberPrompt","red");
		return false;
		
	}
	if(!Card.match(regex))
		{
			producePrompt("please enter 16 digits","mastercardnumberPrompt","red");
			return false;
			
		}
		producePrompt("valid number","mastercardnumberPrompt","green");
		return true;
}



function hide(id)
{
	document.getElementById(id).style.display = "none";
}
function show(id)
{
	document.getElementById(id).style.display="block";
}
function producePrompt(message,promptLocation,color)
{
	document.getElementById(promptLocation).innerHTML=message;
	document.getElementById(promptLocation).style.color=color;
}
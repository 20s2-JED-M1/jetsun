<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>SaveMore IT Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/validation.js" type="text/javascript"></script>
    </head>
    <body>

        <form name="register" action="validate" method="post" onsubmit="return matchPassword()">

            NRIC No: <input type="text" name="nric" required/><br/>
            Title : <select name="title" id="title">
                <option value="Mr">Mr</option>
                <option value="Mrs">Mrs</option>
                <option value="Ms">Ms</option>
            
            </select><br/>
            Name : <input type="text" name="name" required/><br/>
            Email : <input type="email" name="email" /><br/>
            Home Address <input type="text" name="address"/><br/>
            Passport Number : <input type="number" name="passportno"  required/><br/>
            Passport Expiry Date: <input type="date" name="expirydate" required/><br/>
            Mobile Number: <input type="number" name="mobileno" required/><br/>
            Password: <input type="password" name="password" id="pass1" required/><br/>
            Reconfirm Password: <input type="cfmpassword" name="cfmpassword" id="pass2" required/><br/>


            Profession: <input type="text" name="profession"/><br/>
            Date Of Birth: <input type="date" name="dob"/><br/>
            Office Phone Number: <input type="number" name="officeno"/><br/>
            Home Phone Number: <input type="number" name="homeno"/><br/>
            KrisFlyer Membership Number <input type="number" name="memberno"/><br/>
            Biling Address: <input type="text" name="billingaddress"/><br/>

            <input type="submit" value="Register"/> <br/>
        </form>
        <br/>
        <a href="index.jsp">Already have an account?</a>
    </body>
</html>

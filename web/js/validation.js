function matchPassword() {
    
    var pw1 = document.getElementById("pass1").value;
    var pw2 = document.getElementById("pass2").value;
    if(pw1 != pw2){
        alert("Password did not match");
        return false;
    }else {
        return true;
    }
}
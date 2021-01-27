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


//function validate(nric){
//    var nric = new Array[9]; // total in IC
//    
//    for(var i = 0; i < 9; i++){
//        nric[i] == nric.charAt(i);
//        // meaning eg if T1234567
//    // icArray[3] = ic.charAt(3)
//    }
//    
//    // multiply
//    nric[1] *=2;
//    nric[2] *=7;
//    nric[3] *=6;
//    nric[4] *=5;
//    nric[5] *=4;
//    nric[6] *=3;
//    nric[7] *=2;
//    
//    var weight = 0;
//    for(var i =1; i < 8; i++){
//        weight += parseInt(nric[i]); // plus all digits tgt
//    }
//    
//    // checking whether first letter = T / G
//    var offset = (nric[0] == "T" || nric[0] == "G") ? 4 : 0;
//    // if first letter G / T, return 4 else return 0
//    var temp = (offset + weight) % 11;
//    
//    // if first letter = S / T
//    var st = Array("J", "Z", "I", "H", "G", "F", "E", "D", "C", "B", "A");
//    // if first letter = F / G
//    var fg = Array("X", "W", "U", "T", "R", "Q", "P", "N", "M", "L", "K");
//    
//    var done;
//    if (nric[0] == "S" || nric[0] == "T") {
//    done = st[temp]; // will get the last letter
//  } else if (nric[0] == "F" || nric[0] == "G") {
//    done = fg[temp]; // will get last letter
//  }
//  
//  if(nric[8] == done){
//      return (nric[8] == done);
//  }else{
//      alert("Please enter valid NRIC number");
//  }
//  
//}
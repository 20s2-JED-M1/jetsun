function matchPassword() {
    alert("matchpassword2");
    var pw1 = document.getElementById("pass1").value;
    var pw2 = document.getElementById("pass2").value;
    var nric = document.getElementById("nric").value;
    if (pw1 === pw2) {
//        alert("Same password");
        var nricArray = new Array(9); // total in IC
//        alert("Array created");
        for (var i = 0; i < 9; i++) {
            nricArray[i] = nric.charAt(i);
        }
//        alert("IC stored in array");
        // multiply
        nricArray[1] *= 2;
        nricArray[2] *= 7;
        nricArray[3] *= 6;
        nricArray[4] *= 5;
        nricArray[5] *= 4;
        nricArray[6] *= 3;
        nricArray[7] *= 2;

        var weight = 0;
        for (var i = 1; i < 8; i++) {
            weight += parseInt(nricArray[i]); // plus all digits tgt
        }

        // checking whether first letter = T / G
        var offset = (nricArray[0] === "T" || nricArray[0] === "G") ? 4 : 0;
        // if first letter G / T, return 4 else return 0
        var temp = (offset + weight) % 11;

        // if first letter = S / T
        var st = Array("J", "Z", "I", "H", "G", "F", "E", "D", "C", "B", "A");
        // if first letter = F / G
        var fg = Array("X", "W", "U", "T", "R", "Q", "P", "N", "M", "L", "K");

        var done;
        if (nricArray[0] === "S" || nricArray[0] === "T") {
            done = st[temp]; // will get the last letter
        } else if (nricArray[0] === "F" || nricArray[0] === "G") {
            done = fg[temp]; // will get last letter
        }

        if (nricArray[8] === done) {
            return true;
        } else {
            alert("Please enter valid NRIC number");
            return false;
        }

    }
    else {
        alert("Different Password");
        alert("Please enter same password   ");
        return false;
        //   validate();
    }

}

//function validate(){
//    var nric = document.getElementById("nric").value;
//    nric = new Array[9]; // total in IC
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
//    var offset = (nric[0] === "T" || nric[0] === "G") ? 4 : 0;
//    // if first letter G / T, return 4 else return 0
//    var temp = (offset + weight) % 11;
//    
//    // if first letter = S / T
//    var st = Array("J", "Z", "I", "H", "G", "F", "E", "D", "C", "B", "A");
//    // if first letter = F / G
//    var fg = Array("X", "W", "U", "T", "R", "Q", "P", "N", "M", "L", "K");
//    
//    var done;
//    if (nric[0] === "S" || nric[0] === "T") {
//    done = st[temp]; // will get the last letter
//  } else if (nric[0] === "F" || nric[0] === "G") {
//    done = fg[temp]; // will get last letter
//  }
//  
//  if(nric[8] === done){
////      return (nric[8] == done);
//      return true;
//  }else{
//      alert("Please enter valid NRIC number");
//      return false;
//  }
//  
//}
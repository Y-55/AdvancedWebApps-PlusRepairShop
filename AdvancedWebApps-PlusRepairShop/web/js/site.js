/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//this function Add New Repair Request
function validateAddNewRepairRequest() {
    var valid = true;

    //----------------------------------Computer_Owner validate-------------------------------------------------
    if (
            document
            .getElementById("Computer_Owner")
            .value.search(/^[A-Za-z ]{1,30}$/) >= 0
            ) {
        document.getElementById("errComputer_Owner").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errComputer_Owner").style.visibility = "visible";
    }
    //--------------------------------Computer_Serial_Number validate----------------------------------------------
    if (
            document
            .getElementById("Computer_Serial_Number")
            .value.search(/^[A-Za-z0-9_-]{1,30}$/) >= 0
            ) {
        document.getElementById("errComputer_Serial_Number").style.visibility =
                "hidden";
    } else {
        valid = false;
        document.getElementById("errComputer_Serial_Number").style.visibility =
                "visible";
    }
    //--------------------------------Type validate----------------------------------------------
    if (document.getElementById("Type").value != "Select the device type") {
        document.getElementById("errType").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errType").style.visibility = "visible";
    }
    //--------------------------------Model hours menu validate----------------------------------------------
    if (
            document.getElementById("Model").value.search(/^[A-Za-z0-9]{1,20}$/) >= 0
            ) {
        document.getElementById("errModel").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errModel").style.visibility = "visible";
    }
    //--------------------------------Memory_GB validate----------------------------------------------
    if (
            document.getElementById("Memory_GB").value.search(/^[0-9\s]{1,10}$/) >= 0
            ) {
        document.getElementById("errMemory_GB").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errMemory_GB").style.visibility = "visible";
    }
    //--------------------------------HardDisk_GB course validate----------------------------------------------
    if (
            document.getElementById("HardDisk_GB").value.search(/^[0-9\s]{1,10}$/) >= 0
            ) {
        document.getElementById("errHardDisk_GB").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errHardDisk_GB").style.visibility = "visible";
    }
    //--------------------------------Problems course validate----------------------------------------------
    if (
            document
            .getElementById("Problems")
            .value.search(/^[a-zA-Z0-9\s]{1,200}$/) >= 0
            ) {
        document.getElementById("errProblems").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errProblems").style.visibility = "visible";
    }

    return valid;
}

//this function Add Feedback
function validateAddFeedBack() {
    var valid = true;
    //----------------------------------Name validate-------------------------------------------------
    if (
            document
            .getElementById("name")
            .value.search(/^[A-Za-z ]{1,30}$/) >= 0
            ) {
        document.getElementById("errName").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errName").style.visibility = "visible";
    }
    //----------------------------------Country validate-------------------------------------------------
    if (
            document
            .getElementById("country")
            .value.search(/^[A-Za-z ]{1,30}$/) >= 0
            ) {
        document.getElementById("errCountry").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errCountry").style.visibility = "visible";
    }
    //----------------------------------Phone validate-------------------------------------------------
    if (
            document
            .getElementById("phone")
            .value.search(/^(05\d{8}|9665\d{8})$/) != 0
            ) {
        valid = false;
        document.getElementById("errPhone").style.visibility = "visible";
    } else {
        document.getElementById("errPhone").style.visibility = "hidden";

    }
    //----------------------------------Email validate-------------------------------------------------
    if (
            document
            .getElementById("email")
            .value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0
            ) {
        valid = false;
        document.getElementById("errEmail").style.visibility = "visible";

    } else {
        document.getElementById("errEmail").style.visibility = "hidden";
    }
    //----------------------------------Subject validate-------------------------------------------------
    if (
            document
            .getElementById("subject")
            .value.search(/^[A-Za-z ]{1,30}$/) >= 0
            ) {
        document.getElementById("errSubject").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errSubject").style.visibility = "visible";
    }
    //----------------------------------Type validate-------------------------------------------------
    if (
            document
            .getElementById("type")
            .value.search(/^[A-Za-z ]{1,30}$/) >= 0
            ) {
        document.getElementById("errType").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errType").style.visibility = "visible";
    }
    //----------------------------------Message_Owner validate-------------------------------------------------
    if (
            document
            .getElementById("message")
            .value.search(/^[A-Za-z ]{1,30}$/) >= 0
            ) {
        document.getElementById("errMessage").style.visibility = "hidden";
    } else {
        valid = false;
        document.getElementById("errMessage").style.visibility = "visible";
    }






    return valid;
}

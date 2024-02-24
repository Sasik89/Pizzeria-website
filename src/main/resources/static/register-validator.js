function validate(){

var name=document.getElementById("name");
var surname = document.getElementById("surname");
var login = document.getElementById("login");
var street = document.getElementById("street");
var numberOfHouse = document.getElementById("numberOfHouse");
var zipCode = document.getElementById("zipCode");
var city = document.getElementById("city");
var password = document.getElementById("password");
var password2 = document.getElementById("password2");
var info = document.getElementById("info");

var loginRegex = /^.{5,}$/;
var nameRegex = /^[A-Z][a-z]+$/;
var surnameRegex = /^[A-Z][a-z]+([ -][A-Z][a-z]+)?$/;
var passwordRegex = /^.{5,}$/;
var streetRegex = /^[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ\d\s./\\-]+$/;
var numberOfHouseRegex = /^\d+[A-Za-z]?(\/\d+)?[A-Za-z]?$/;
var zipCodeRegex = /^\d{2}-\d{3}$/;
var cityRegex = /^[A-Za-z]+(?:[\s-][A-Za-z]+)*$/;

    var result = true;
    var infoText = "";


    if(!nameRegex.test(name.value)){
        name.style.background = "#fac0c0";
        infoText = infoText + "Niepoprawny imie<br>";
        result = false;
    }else {
             name.style.background = null;
    }

    if(!surnameRegex.test(surname.value)){
        infoText = infoText + "Niepoprawne nazwisko<br>";
        surname.style.background = "#fac0c0";
        result = false;
    } else {
        surname.style.background = null;
    }

    if(!streetRegex.test(street.value)){
        infoText = infoText + "Niepoprawna ulica<br>";
        street.style.background = "#fac0c0";
        result = false;
    } else {
        street.style.background = null;
    }

    if(!numberOfHouseRegex.test(numberOfHouse.value)){
        infoText = infoText + "Niepoprawny numer domu<br>";
        numberOfHouse.style.background = "#fac0c0";
        result = false;
        } else {
             numberOfHouse.style.background = null;
        }

    if(!zipCodeRegex.test(zipCode.value)){
        infoText = infoText + "Niepoprawny kod pocztowy<br>";
        zipCode.style.background = "#fac0c0";
        result = false;
        } else {
            zipCode.style.background = null;
        }

   if(!cityRegex.test(city.value)){
        infoText = infoText + "Niepoprawna nazwa miasta<br>";
        city.style.background = "#fac0c0";
        result = false;
    } else {
        city.style.background = null;
    }


    if(!loginRegex.test(login.value)){
        login.style.background = "#fac0c0";
        infoText = infoText + "Niepoprawny nick<br>";
        result = false;
    } else {
        login.style.background = null;
    }

    if(!passwordRegex.test(password.value)){
        infoText = infoText + "Niepoprawne hasło<br>";
        password.style.background = "#fac0c0";
        result=false;
    } else {
        password.style.background = null;
    }

/*    if(password.value != password2.value){
        infoText = infoText + "Niepoprawne powtórzone hasło<br>";
        password.style.background = "#fac0c0";
        result = false;
    } else {
             password2.style.background = null;
    }*/

    info.innerHTML = infoText;
    return result;

    }

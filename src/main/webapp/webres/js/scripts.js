
function check() {
    var fav =[];
    var id = document.getElementById('addToFav').dataset.id;
    var login = $(this).attr('data-login');
    fav.push(id);
    console.log(id +"--"+login);
    localStorage.setItem('fav', JSON.stringify(fav));

}

function redirectTimeOut(url) {
    var timeLeft = 3,
        cinterval;

    var timeDec = function () {
        timeLeft--;
        document.getElementById('countdown').innerHTML = timeLeft;
        if (timeLeft === 0) {
            clearInterval(cinterval);
            window.location.href = url;
        }
    };
    cinterval = setInterval(timeDec, 1000);
}

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode != 43 && charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function validateForm() {
    var login = document.getElementsByName("login")[0].value;
    var pass = document.getElementsByName("pass")[0].value;
    if (login == null || login == "", pass == null || pass == "") {
        alert("Please Fill All Required Field");
        return false;
    }
}


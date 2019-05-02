
function check() {
    var fav =[];
    var id = document.getElementById('addToFav').dataset.id;
    var login = $(this).attr('data-login');
    fav.push(id);
    console.log(id +"--"+login);
    localStorage.setItem('fav', JSON.stringify(fav));

}


function addFavorites(id) {

    var request = "id=-" + id;
    console.log(request);
    fetch('${pageContext.request.contextPath}/item', {
        method: 'POST',
        headers: {
            'Accept': 'application/json, application/xml, text/plain, text/html,',
            'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
        },
        body: request
    }).catch(alert);
}

function addToFav() {
    var id = document.getElementById('addToFav').dataset.id;
    $.ajax({
        type: "GET",
        url: "/userAccount",
        data: {text: id},
        success: function (response) {
            console.log(response);
            alert("Added to Favorites");
        }, error: function (result) {
            alert(result.value + "  45454");
        }
    });
}

function redirectTimeOut(url) {
    var timeLeft = 5,
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
    var phone = document.getElementsByName("phone")[0].value;
    if (login == null || login == "", pass == null || pass == "", phone == null || phone == "") {
        alert("Please Fill All Required Field");
        return false;
    }
}


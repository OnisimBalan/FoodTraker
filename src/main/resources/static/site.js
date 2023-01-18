async function postData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: JSON.stringify(data) // body data type must match "Content-Type" header
    });
    return response.json(); // parses JSON response into native JavaScript objects
}
async function getData(url = '') {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'GET', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    });
    return response.json(); // parses JSON response into native JavaScript objects
}
//Globals
var MainMenu = [];
var Count = 0;


//ADDUSERS
$("#AddUser").click(function () {
 const name =  $("#EmailIn").val();
 const password =  $("#PasswordIn").val();
 user = {
  name: name,
  password: password
  };

postData("/addUser", user)
        .then((data) => {
        console.log(data);
            if(data == 1){
             location.href = "http://localhost:8080/templates/menu.html";
            }
            else{
            alert("Invalid user!");
            }
        });
  });



//ADDFOOD
$("#AddMenu").click(function () {
    var file = document.getElementById("IncImg").files[0];
    data= {
    name="",
    Description="",
    PictureUrl = file
    }
    postData("/restaurant/createMenuItem", data)
            .then((data) => {
            return data;
        });

  });


//ADDRESTAURANTS
$("#AddRest").click(function () {
    const Name =  $("#RestaurantName").val();
    const Address =  $("#RestaurantAdress").val();
    const Description =   $("#DescribeRestaurant").val();

    const data = {
         Name:Name,
         Address:Address,
         Description:Description,
    }

    console.log(data);
    postData("/restaurant/createRestaurant", data)
            .then((response) => {
                console.log(response);
                return response;
            });

    $("#RestaurantName").val("");
    $("#RestaurantAdress").val("");
    $("#DescribeRestaurant").val("");
});


//submit
$("#SubmitUser").click(function () {
  const num =  $("#UserName").val();
  const ema =   $("#Email").val();
  const pass =   $("#Password").val();
  const ad =   $("#Adresa").val();
  const tel =   $("#Telefon").val();
      const newUser = {
          nume:num,
          email:ema,
          parola:pass,
          adresa:ad,
          telefon:tel
      }
postData("/newUser", newUser)
        .then((data) => {
            alert(data);
            return data;
        });

    $("#UserName").val("");
    $("#Email").val("");
    $("#Password").val("")
    $("#Adresa").val("");
    $("#Telefon").val("");
 });

//viewrestaurants
function load(){
getData("/restaurant/getRestaurants")
        .then((data) => {
        showRestaurants(data);
     return data;
    });
}

function showRestaurants(data) {
     $('#Restaurants').val("");
    let output = '<div class="container">';
      data.forEach((item) => {
         output += `
               <div>${item.Id}</div>
               <div>${item.Name}</div>
               <div>${item.Address}</div>
               <div>${item.Description}</div>
         `;
        });

    $('#Restaurants').append = output;
}

//takeMenus
$("#menus").click(function () {
getData("/takeRestaurants")
        .then((data) => {
 var table = $("#UserName");
    table.html("");
    data.forEach((item) => {
        var tr = $(`
            <tr class="tr-table">
                <td>${item.id}</td>
                <td>-</td>
                <td>${item}</td>
            </tr>`);
        var linksTd = $(`<td class="td-elements"></td>`);
        tr.append(linksTd);

        if (item.links && item.links.length) {
            item.links.forEach(t => {
                linksTd.append(`<a class="link-result" href="${t}">${t}</a>`)
            })
        }

        table.append(tr);
    });
            return data;
        });
});

$("#asd").click(function () {
location.href = "http://localhost:8080/templates/menu.html";
 const parola =  $("#PasswordIn").val();
 const email =   $("#EmailIn").val();

 const loginUser = {
          email:email,
          parola:parola,
 }

postData("/getUser", loginUser)
        .then((data) => {
        if(data == 1){
            location.href = "http://localhost:8080/templates/menu.html";
        }
    });
});



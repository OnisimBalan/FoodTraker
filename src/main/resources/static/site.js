async function postData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
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

//make me a post request with fetch postData function



//ADDRESTAURANTS
$("#AddRest").click(function () {
    const Name =  $("#RestaurantName").val();
    const Address =  $("#RestaurantAdress").val();
    const Description =   $("#DescribeRestaurant").val();
    const Image = $("#imgName").val();

    const data = {
         Name:Name,
         Address:Address,
         Description:Description,
         Image:Image
    }

    console.log(data);
    postData("/createRestaurant", data)
            .then((response) => {
                console.log(response);
                return response;
            });

    $("#RestaurantName").val("");
    $("#RestaurantAdress").val("");
    $("#DescribeRestaurant").val("");
    $("#imgName").val("");
});

//submit
$("#SubmitUser").click(function () {
  const FirstName =  $("#FirstName").val();
  const LastName =  $("#LastName").val();
  const Email =   $("#Email").val();
  const Password =   $("#Password").val();
  const Address =   $("#Adresa").val();
  const PhoneNumber =   $("#Telefon").val();
      const newUser = {
      FirstName:FirstName,
          FirstName:FirstName,
           LastName:LastName,
          Email:Email,
          Password:Password,
          Address:Address,
          PhoneNumber:PhoneNumber
      }
postData("/newUser", newUser)
        .then((data) => {
            return data;
        });

    $("#FirstName").val("");
    $("#LastName").val("");
    $("#Email").val("");
    $("#Password").val("")
    $("#Adresa").val("");
    $("#Telefon").val("");
 });


$("#ShowRestaurants").click(function () {
getData("/getRestaurants")
        .then((data) => {
         var table = $('#Restaurants');
          table.html("");
         var output = '<div class="container1 container">';
            data.forEach((item) => {
               output += `
                     <div>${item.Name}</div>
                     <div>Address: ${item.Address}</div>
                     <div>Description:${item.Description}</div>
                     <img class="mt-5 mb-5" src="../img/${item.Image}">
                     <input type="text" id="form12" class="form-control mt-5" placeholder="Type your favorite dish"/>
                     <button class="btn btn-primary mt-5" id="AddDish">Command</button>
                     <div class="mt-5 mb-5 border"></div>
               `;
              });

         table.append(output);
     return data;
    })
});

$("#AddDish").click(function () {
const text =  $("#form12").val();
if(text=="" || text==null){
alert("Please type your favorite dish!");
}
else{
    alert("Success!");
}
});


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



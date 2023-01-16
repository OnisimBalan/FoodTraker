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
postData("/addUser",user)
        .then((data) => {
            console.log(data);
            return data;
        });
  });
//ADDFOOD
$("#AddMenu").click(function () {
 const name =  $("#MenuName").val();
 const desc =   $("#DescribeMenu").val();

 if(name !="" | desc !=""){
    Count = Count + 1;
    $("#MenusCount").html(Count);
 }
  menu = {
  name: name,
  description: desc
  };

  MainMenu.push(menu);

  $("#MenuName").val("");
  $("#DescribeMenu").val("");
  });
//ADDRESTAURANTS
$("#AddRest").click(function () {
    count = 0;
    const name =  $("#RestaurantName").val();
    const adress =  $("#RestaurantAdress").val();
    const desc =   $("#DescribeRestaurant").val();
    const menus = MainMenu;

    const rest = {
         name:name,
         adress:adress,
         description:desc,
         menus:menus,
    }
    postData("/addRestaurants",rest)
            .then((data) => {
                console.log(data);
                return data;
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
postData("/newUser",newUser)
        .then((data) => {
            console.log(data);
            return data;
        });
 });
//viewrestaurants
$("#RestaurantId").click(function () {
getData("/takeRestaurants")
        .then((data) => {
 var table = $("#UserName");
    table.html("");
    data.forEach((item) => {
        var tr = $(`
            <tr class="tr-table">
                <td>${item.id}</td>
                <td>-</td>
                <td>${item.searchKey}</td>
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
                <td>${item.searchKey}</td>
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



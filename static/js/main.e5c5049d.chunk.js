(this.webpackJsonpfrontend=this.webpackJsonpfrontend||[]).push([[0],{45:function(e,t,n){e.exports=n(68)},50:function(e,t,n){},55:function(e,t,n){},68:function(e,t,n){"use strict";n.r(t);var a=n(0),l=n.n(a),r=n(13),c=n.n(r),o=(n(50),n(5)),u="https://maltemagnussen.com/testexamMomondo";function m(e){return e.ok?e.json():Promise.reject({status:e.status,fullError:e.json()})}var s=function(){function e(e,n,a){var l={method:e,headers:{"Content-type":"application/json",Accept:"application/json"}};return n&&null!=t()&&(l.headers["x-access-token"]=t()),a&&(l.body=JSON.stringify(a)),l}function t(){return localStorage.getItem("jwtToken")}return{login:function(t,n,a){var l=e("POST",!0,{username:t,password:n});return fetch(u+"/api/login",l).then(m).then((function(e){var t;t=e.token,localStorage.setItem("jwtToken",t),a(function(){var e=localStorage.getItem("jwtToken").split(".")[1],t=window.atob(e);return JSON.parse(t).roles}())}))},logout:function(){localStorage.removeItem("jwtToken")},fetchGetData:function(t,n){var a=e("GET",!0);return fetch(u+"/api/".concat(t,"/").concat(n),a).then(m)}}}(),i=(n(21),n(18)),E=n(22),d=n(9),g=function(e){var t=e.login,n=e.message,r=Object(a.useState)({username:"",password:""}),c=Object(o.a)(r,2),u=c[0],m=c[1];var s=function(e){m(Object(E.a)({},u,Object(i.a)({},e.target.id,e.target.value)))};return l.a.createElement("div",null,l.a.createElement("h2",null,"Login"),l.a.createElement("form",{onSubmit:function(e){e.preventDefault(),t(u.username,u.password)}},l.a.createElement("input",{placeholder:"User Name",id:"username",onChange:s})," ",l.a.createElement("input",{placeholder:"Password",id:"password",type:"password",onChange:s})," ",l.a.createElement("button",{className:"btn btn-primary"},"Login"),l.a.createElement("br",null),l.a.createElement("p",null,n)))},h=function(){return l.a.createElement(l.a.Fragment,null,l.a.createElement("h2",null,"You are now logged in"),l.a.createElement(d.b,{to:"/search"},"Searching tool"),l.a.createElement("br",null),l.a.createElement("br",null))},b=(n(55),function(){return l.a.createElement(l.a.Fragment,null,l.a.createElement("h1",null,"Welcome Page"),l.a.createElement("h6",null,l.a.createElement("ins",null,"After")," having set up the backend:"),l.a.createElement("ol",null,l.a.createElement("li",null,l.a.createElement("code",null,"npm install")),l.a.createElement("li",null,l.a.createElement("code",null,"npm start"))),l.a.createElement("h6",null,"Common issues:"),l.a.createElement("ul",null,l.a.createElement("li",null,l.a.createElement("code",null,"npm audit fix --force"))),l.a.createElement("h6",null,"File overview"),l.a.createElement("label",null,l.a.createElement("i",null,"src/components")),l.a.createElement("br",null),l.a.createElement("ul",{className:"border border-secondary customBorder"},l.a.createElement("li",null,l.a.createElement("code",null,"Welcome.jsx")," - Where you are"),l.a.createElement("li",null,l.a.createElement("code",null,"Swapi.jsx")," - Handles fetch call to the backend (Using",l.a.createElement("a",{target:"_blank",rel:"noopener noreferrer",href:"https://swapi.co/"}," ","https://swapi.co/"),")"),l.a.createElement("li",null,l.a.createElement("code",null,"Login.jsx")," - Handles login")),l.a.createElement("br",null),l.a.createElement("label",null,l.a.createElement("i",null,"src/")),l.a.createElement("br",null),l.a.createElement("ul",{className:"border border-secondary customBorder"},l.a.createElement("li",null,l.a.createElement("code",null,"apiFacade.jsx")," - Utility to help with fetching, login/logout"),l.a.createElement("li",null,l.a.createElement("code",null,"App.js")," - Main component, handles routes &"," ",l.a.createElement("code",null,"loggedIn")),l.a.createElement("li",null,l.a.createElement("code",null,"index.js")," - Render component"),l.a.createElement("li",null,l.a.createElement("code",null,"settings.js")," - Holds global settings, such as fetch URLs"),l.a.createElement("span",null,l.a.createElement("i",null,"CSS files"))),l.a.createElement("p",null,l.a.createElement(d.b,{to:"#/login"},"Login")," using the credentials you set in the backend ",l.a.createElement("code",null,"utils\\SetupTestUsers.java")))}),f=function(){var e=Object(a.useState)(),t=Object(o.a)(e,2),n=t[0],r=t[1],c=Object(a.useState)(),u=Object(o.a)(c,2),m=(u[0],u[1],Object(a.useState)()),i=Object(o.a)(m,2),E=i[0],d=i[1],g=Object(a.useState)(0),h=Object(o.a)(g,2),b=h[0],f=h[1];return l.a.createElement(l.a.Fragment,null,l.a.createElement("h4",null,E),l.a.createElement("h1",null,"Search for people and hobbies"),l.a.createElement("input",{id:"personID",value:b,type:"number",onChange:function(e){f(e.target.value)}}),l.a.createElement("button",{type:"button",onClick:function(){var e,t;e="id",t=b,s.fetchGetData("krak/"+e,t).then((function(e){console.log(e),r(e),d("")})).catch((function(e){e.status?e.fullError.then((function(e){d(e.message),console.log(e.code,e.message)})):console.log("Network error")})),f(0)}},"Get by ID"),n&&l.a.createElement(p,{members:Array.isArray(n)?n:[n]}))};function p(e){var t=e.members.map((function(e){return l.a.createElement(v,{key:e.id,fName:e.fName,id:e.id,hobbylist:e.hobbylist,lName:e.lName,mail:e.mail,residence:e.residence,telephone:e.telephone})}));return l.a.createElement("table",{className:"table"},l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("th",null,"First Name"),l.a.createElement("th",null,"Hobbies"),l.a.createElement("th",null,"ID"),l.a.createElement("th",null,"Last Name"),l.a.createElement("th",null,"Email"),l.a.createElement("th",null,"Address"),l.a.createElement("th",null,"City"),l.a.createElement("th",null,"Phone"))),l.a.createElement("tbody",null,t))}function v(e){return console.log(e.hobbylist),l.a.createElement("tr",null,l.a.createElement("td",null,e.fName),l.a.createElement("td",null,e.hobbylist.map((function(e,t){return l.a.createElement("li",{key:t},e.hobbyName)}))),l.a.createElement("td",null,e.id),l.a.createElement("td",null,e.lName),l.a.createElement("td",null,e.mail),l.a.createElement("td",null,e.residence.road),l.a.createElement("td",null,e.residence.town),l.a.createElement("td",null,e.telephone))}var y=function(e){return e.permission?l.a.createElement(l.a.Fragment,null,l.a.createElement(f,null)):l.a.createElement(l.a.Fragment,null,l.a.createElement("p",null,"You are not logged in"))},j=n(71),k=n(42),O=["career","celebrity","dev","explicit","fashion","food","history","money","movie","music","political","science","sport","travel"],S=function(){var e=Object(a.useState)(),t=Object(o.a)(e,2),n=t[0],r=t[1],c=Object(a.useState)(),u=Object(o.a)(c,2),m=u[0],i=u[1];return l.a.createElement(l.a.Fragment,null,l.a.createElement("br",null),l.a.createElement(j.a,null,l.a.createElement(j.a.Toggle,{variant:"success",id:"dropdown-basic"},"Select Category."),l.a.createElement(j.a.Menu,null,O.map((function(e,t){return l.a.createElement(j.a.Item,{value:e,key:t,onClick:function(){return r(e)}},e)})))),l.a.createElement("br",null),"Click submit to get count of requests made in that category ",l.a.createElement("br",null),l.a.createElement(k.a,{type:"button",className:"btn-primary",onClick:function(){s.fetchGetData("categoryCount",n).then((function(e){i(e),console.log(e)})).catch((function(e){e.status?e.fullError.then((function(e){console.log(e.code,e.message)})):console.log("Network error")}))}},"Submit"),l.a.createElement("br",null),"Amount of requests made for ",n," is:"," ",m&&m.count&&m.count,".")},w=function(e){var t=e.loggedIn,n=e.roles;return t&&n.includes("admin")?l.a.createElement(l.a.Fragment,null,l.a.createElement(S,null)):l.a.createElement(l.a.Fragment,null,l.a.createElement("p",null,"You are not logged in as admin"))},N=n(16),C=function(e){var t=e.roles;return t=t.replace(/\[|\]|\"/g,"").replace(","," & ").toUpperCase(),l.a.createElement("p",null,"Permission: ",t)},I=n(70),x={career:!1,celebrity:!1,dev:!1,explicit:!1,fashion:!1,food:!1,history:!1,money:!1,movie:!1,music:!1,political:!1,science:!1,sport:!1,travel:!1},F=function(e){var t=e.loggedIn,n=Object(a.useState)(x),r=Object(o.a)(n,2),c=r[0],u=r[1],m=Object(a.useState)({}),d=Object(o.a)(m,2),g=d[0],h=d[1],b=function(e){var t=e.target.value;u(Object(E.a)({},c,Object(i.a)({},t,!c[t])))};return l.a.createElement(l.a.Fragment,null,l.a.createElement("br",null),l.a.createElement("div",null,l.a.createElement("h3",null," Select jokes "),l.a.createElement("h5",null," ",!t&&"You may only select 4 categories."," "),l.a.createElement("form",null,Object.keys(c).map((function(e,t){return l.a.createElement("div",{key:t},l.a.createElement("input",{type:"checkbox",value:e,onChange:b}),e)})),l.a.createElement(k.a,{type:"button",className:"btn-primary",onClick:function(e){e.preventDefault();var n=[];if(Object.keys(c).forEach((function(e){1==c[e]&&n.push(e)})),t||!(n.length>4)){var a=n.map((function(e,t){return e}));s.fetchGetData(function(e){return e?"jokeByCategoryV2":"jokeByCategory"}(t),a).then((function(e){h(e),console.log(e)})).catch((function(e){e.status?e.fullError.then((function(e){console.log(e.code,e.message)})):console.log("Network error")}))}}},"Submit"))),l.a.createElement("div",null,l.a.createElement("br",null),l.a.createElement(I.a,null,l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("th",null,"Category"),l.a.createElement("th",null,"Joke"))),l.a.createElement("tbody",null,g&&g.jokes&&g.jokes.map((function(e,t){return l.a.createElement("tr",{key:t},l.a.createElement("td",null,e.category),l.a.createElement("td",null,e.joke))}))))))},L=function(){return l.a.createElement("div",null,"You're trying to access a resource that doesn't exist.")},D=function(e){var t=e.loggedIn,n=e.setLoggedIn,a=e.roles,r=e.setRoles;return l.a.createElement("ul",{className:"header"},l.a.createElement("li",null,l.a.createElement(d.c,{exact:!0,activeClassName:"active",to:"/"},"Home")),t?l.a.createElement("li",null,l.a.createElement(d.c,{onClick:function(){n(!1),s.logout(),r([])},to:"/login"},"Log out")):l.a.createElement("li",null,l.a.createElement(d.c,{activeClassName:"active",to:"/login"},"Login")),l.a.createElement("li",null,l.a.createElement(d.c,{to:"/Jokes"},"Jokes")),t&&l.a.createElement("li",null,l.a.createElement(d.c,{to:"/search"},"Search")),t&&a.includes("admin")&&l.a.createElement("li",null,l.a.createElement(d.c,{to:"/admin"},"Admin panel")))},A=function(e){var t=e.loggedIn,n=e.setLoggedIn,r=e.roles,c=e.setRoles,u=Object(a.useState)(""),m=Object(o.a)(u,2),i=m[0],E=m[1];return l.a.createElement("div",null,t?l.a.createElement("div",null,r.length&&l.a.createElement(l.a.Fragment,null,l.a.createElement(C,{roles:r}),l.a.createElement(h,null))):l.a.createElement(g,{login:function(e,t){s.login(e,t,c).then((function(e){E(""),n(!0)})).catch((function(e){e.status?(E("Failed to log in, check your information"),e.fullError.then((function(e){return console.log(e.code,e.message)}))):console.log("Network error")}))},message:i}),l.a.createElement("br",null),l.a.createElement(d.b,{to:"/"},"Back to WelcomePage"))},J=function(){var e=Object(a.useState)(!1),t=Object(o.a)(e,2),n=t[0],r=t[1],c=Object(a.useState)([]),u=Object(o.a)(c,2),m=u[0],s=u[1];return l.a.createElement(l.a.Fragment,null,l.a.createElement(d.a,null,l.a.createElement(D,{loggedIn:n,setLoggedIn:r,roles:m,setRoles:s}),l.a.createElement("div",{className:"container"},l.a.createElement(N.c,null,l.a.createElement(N.a,{exact:!0,path:"/",component:b}),l.a.createElement(N.a,{path:"/login",render:function(){return l.a.createElement(A,{loggedIn:n,setLoggedIn:r,roles:m,setRoles:s})}}),l.a.createElement(N.a,{path:"/search"},l.a.createElement(y,{permission:n})),l.a.createElement(N.a,{path:"/admin"},l.a.createElement(w,{loggedIn:n,roles:m})),l.a.createElement(N.a,{path:"/Jokes"},l.a.createElement(F,{loggedIn:n})),l.a.createElement(N.a,{component:L})))))};c.a.render(l.a.createElement(J,null),document.getElementById("root"))}},[[45,1,2]]]);
//# sourceMappingURL=main.e5c5049d.chunk.js.map
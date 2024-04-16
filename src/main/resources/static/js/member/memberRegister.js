console.log("register js")
let userid = document.getElementById("userId");
let errId = document.getElementById("errId");

userid.addEventListener("focusout", ()=>{
	errId.innerText = "errrr";
	
});


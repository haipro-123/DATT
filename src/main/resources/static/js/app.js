const inputs = document.querySelectorAll(".input");


function addcl(){
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl(){
	let parent = this.parentNode.parentNode;
	if(this.value == ""){
		parent.classList.remove("focus");
	}
}


inputs.forEach(input => {
	input.addEventListener("focus", addcl);
	input.addEventListener("blur", remcl);
});
$(document).ready(function(){
	$(".btnLike").each(function (i,btn){
		btn.addEventListener("click",function (e){
			e.preventDefault();
			let idPost = btn.getAttribute("id");
			let idUser = localStorage.getItem("idUser");
			$.ajax({
				type:"POST",
				url:"/like",
				processData: false,
				data:JSON.stringify({
					idPost : idPost,
					idUser : idUser
				}),
				contentType: "application/json",
				dataType: "json",
				success:function (data){
					if(data){
						Swal.fire({
							position: "top-end",
							icon: "success",
							title: "Like thành công",
							showConfirmButton: false,
							timer: 1500
						});
					}else {
						Swal.fire({
							icon: "error",
							title: "Oops...",
							text: "Bạn đã like rồi!",
						});
					}
				},
				error:function (e){
					console.log(e);
				}
			})
		})

	});
});
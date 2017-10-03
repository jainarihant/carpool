function edit_profile(){
					document.getElementById("name").readOnly = false;
					document.getElementById("address").readOnly = false;
					document.getElementById("email").readOnly = false;
					document.getElementById("contact").readOnly = false;
					document.getElementById("gender").readOnly = false;
					document.getElementById("update_profile").disabled = false;
			}
			
	function close_profile(){
					document.getElementById("name").readOnly = true;
					document.getElementById("address").readOnly = true;
					document.getElementById("email").readOnly = true;
					document.getElementById("contact").readOnly = true;
					document.getElementById("gender").readOnly = true;
					document.getElementById("update_profile").disabled = true;
			}
			
	

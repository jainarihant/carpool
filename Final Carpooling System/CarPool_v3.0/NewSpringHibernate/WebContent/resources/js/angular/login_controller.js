app.controller("loginController",['$scope',function($scope){
			var self=this;
			self.user={username:'',password:'',email:''};
			self.users=[];
			$scope.re_email=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;			
			
			
			self.submit=function(){
				console.log("submit method called");
				console.log(self.user);
				//code to go to spring
			};
			
		}]);
		

app.controller("regController",['$scope',function($scope){
			var self=this;
			self.user={fname:'',lname:'',email:''};
			self.users=[];
			
			$scope.re_text=/^[a-zA-Z]+$/;
			$scope.re_username=/^[a-zA-Z]+[a-zA-Z0-9_]*$/;
			$scope.re_password=/(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z])(?=.*[!@#$%^&*])/   
			$scope.re_email=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;			
			$scope.re_mobile=/^[0-9]{10,10}$/;
			
			self.submit=function(){
				console.log("submit method called");
				console.log(self.user);
				//code to go to spring
			};
			
			$scope.passValidation=false;
			$scope.changepassword=function () {
				var regexp=/^[a-z]$/;								/*change self.*/
				if(regexp.regController($scope.password)==false)
				{
					$scope.passValidation=false;
				}
				else{
					$scope.passValidation=true;
				}
			};	
			
		}]);	


app.controller("test",function($scope)
	{
	$scope.password="";
	$scope.cpassword="";
	$scope.passvalidation=false;
	$scope.changepassword=function()
	{
		var regexp=/(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z])(?=.*[!@#$%^&*])/;
		if(regexp.test($scope.password)==false)
		{
			$scope.passvalidation=false;
		}
		else
		{
			$scope.passvalidation=true;
		}
		console.log("Password: " , $scope.password , " is valid: ", $scope.passvalidation);
	};
	$scope.confirmPassword = function(){
		if($scope.password==$scope.cpassword){
			$scope.confirmPasswordMatches = true;
		} else 
		$scope.confirmPasswordMatches = false;
	}
	});
	
	
	
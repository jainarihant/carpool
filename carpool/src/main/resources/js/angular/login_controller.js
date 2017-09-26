app.controller("loginController",['$scope',function($scope){
			var self=this;
			self.user={username:'',password:''};
			self.users=[];
			
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
			$scope.re_password=/^[a-zA-Z]+[a-zA-Z0-9_]*$/;     // /^[a-zA-Z]\w{7,14}$/;		letters, numbers and the underscore 
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

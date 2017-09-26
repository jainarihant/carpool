App.controller('UserController',['$scope',function($scope){
	var self=this;
	self.user={username:'',address:'',email:''};
	self.users=[];
	
	self.submit=function()
	{
		console.log("submit method called");
		console.log(self.user)
	};
	self.reset=function()
	{
			self.user={username:'',address:'',email:''};

			$scope.myForm.$setPristine();
	};
}]);
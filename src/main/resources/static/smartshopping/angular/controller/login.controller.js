
shSmartShoppingApp.controller('LoginController', ['$http', '$scope', '$rootScope', '$controller', function LoginController($http, $scope, $rootScope, $controller) {
    $controller('CoreController', {
        $scope: $scope
    });
   
    var controller = {};
    return controller;
}]); 


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
shSmartShoppingApp.controller('ItemController', ['$http', '$scope', '$rootScope', '$controller', function LoginController($http, $scope, $rootScope, $controller) {
        $controller('CoreController', {
            $scope: $scope
        });

        $scope.fetchItems = function (page, pageSize) {
            var getImgUrl = "rest/item/all?page=" + page+"&pageSize="+pageSize;
            $http.get(getImgUrl).success(function (data, status, headers) {
                $scope.items = data.content;
            }).error(function (data, status, headers) {

            })
        };

        var controller = {};
        return controller;
    }]);


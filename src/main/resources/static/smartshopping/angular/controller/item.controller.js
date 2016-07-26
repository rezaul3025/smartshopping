/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
shSmartShoppingApp.controller('ItemController', ['$http', '$scope', '$rootScope', '$controller', function LoginController($http, $scope, $rootScope, $controller) {
        $controller('CoreController', {
            $scope: $scope
        });
        
        $scope.init = function (itemId) {
            $scope.itemId = itemId;
            
           var url = "/rest/item/"+itemId;
            $http.get(url).success(function (data, status, headers) {
                $scope.item = data;
            }).error(function (data, status, headers) {

            })
        }
        
        $scope.getItemImageCarouselClass = function(item,index){
            if(index == 0){
                return "next left";
            }
            else if(item.itemImageMeta.length-1 == index){
                return "active left";
            }
            
            return "";
        };

        $scope.fetchItems = function (page, pageSize) {
            var getImgUrl = "rest/item/all?page=" + page+"&pageSize="+pageSize;
            $http.get(getImgUrl).success(function (data, status, headers) {
                $scope.items = data;
            }).error(function (data, status, headers) {

            })
        };

        var controller = {};
        return controller;
    }]);

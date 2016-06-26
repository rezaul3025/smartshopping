shSmartShoppingApp.controller('BusinessSignupController', ['$http', '$scope', '$rootScope', '$controller', function LoginController($http, $scope, $rootScope, $controller) {
        $controller('CoreController', {
            $scope: $scope
        });

        $scope.businessSignUp = function (business) {

            var url = "rest/signup/business";

            $http({
                method: 'POST',
                url: url,
                data: business
                        /*transformRequest: angular.identity,
                         headers: {'Content-Type': undefined, 'Content-Transfer-Encoding': 'utf-8'}*/
            }).
                    success(function (data, status, headers, config) {

                        if (data != null && typeof data != 'undefined') {
                            var businessId = data;
                            var imgUpUrl = 'rest/signup/business/image/' + data;
                            var formData = new FormData();
                            for (var i = 0; i < business.bLogoUpload.length; i++) {
                                formData.append('file_logo' + i, business.bLogoUpload[i]);
                            }
                            for (var j = 0; j < business.bBannerUpload.length; j++) {
                                formData.append('file_banner' + j, business.bBannerUpload[j]);
                            }

                            $http({
                                method: 'POST',
                                url: imgUpUrl,
                                data: formData,
                                transformRequest: angular.identity,
                                headers: {'Content-Type': undefined, 'Content-Transfer-Encoding': 'utf-8'}
                            }).
                                    success(function (data, status, headers, config) {
                                        $scope.getBusinessImage(businessId);
                                    })
                                    .error(function (data, status, headers, config) {

                                    })
                        }

                    })
                    .error(function (data, status, headers, config) {

                    })

        };

        $scope.getBusinessImage = function (id) {
            var getImgUrl = "rest/business/image/" + id
            $http.get(getImgUrl).success(function (data, status, headers) {
                $scope.businessImage = data;
            }).error(function (data, status, headers) {

            })
        };

        $scope.getAllBusiness = function () {
            var getImgUrl = "/rest/business/all"
            $http.get(getImgUrl).success(function (data, status, headers) {
                $scope.businessAll = data;
            }).error(function (data, status, headers) {

            })
        }

        var controller = {};
        return controller;
    }]);

shSmartShoppingApp.controller('ShopItemController', ['$http', '$scope', '$rootScope', '$controller', function ShopItemController($http, $scope, $rootScope, $controller) {
        $controller('CoreController', {
            $scope: $scope
        });

        $scope.init = function (businessId) {
            $scope.businessId = businessId;
            
            var getGategoryUrl = "/rest/business/item/category";
            $http.get(getGategoryUrl).success(function (data, status, headers) {
                $scope.categories = data;
                $scope.item.category = $scope.categories[0];
            }).error(function (data, status, headers) {

            })
        }

        //Model init value
        $scope.item = {title: '',
            description: '',
            offer: false,
            price: 0.00,
            offerPrice: 0.00,
            quantity: 0
        }

        $scope.addItem = function (item) {

            var url = "/rest/business/item/" + $scope.businessId;

            $http({
                method: 'POST',
                url: url,
                data: item
                        /*transformRequest: angular.identity,
                         headers: {'Content-Type': undefined, 'Content-Transfer-Encoding': 'utf-8'}*/
            }).
                    success(function (data, status, headers, config) {

                        if (data != null && typeof data != 'undefined') {
                            var itemId = data.id;
                            var imgUpUrl = '/rest/business/item/image/' + itemId;
                            var formData = new FormData();
                            for (var i = 0; i < item.images.length; i++) {
                                formData.append('item_image' + i, item.images[i]);
                            }
                            $http({
                                method: 'POST',
                                url: imgUpUrl,
                                data: formData,
                                transformRequest: angular.identity,
                                headers: {'Content-Type': undefined, 'Content-Transfer-Encoding': 'utf-8'}
                            }).
                                    success(function (data, status, headers, config) {
                                        // $scope.getBusinessImage(businessId);
                                    })
                                    .error(function (data, status, headers, config) {

                                    })
                        }

                    })
                    .error(function (data, status, headers, config) {

                    })

        };

        var controller = {};
        return controller;
    }]);
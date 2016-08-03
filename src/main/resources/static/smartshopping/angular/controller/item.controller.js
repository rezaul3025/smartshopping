/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
shSmartShoppingApp.controller('ItemController', ['$http', '$scope', '$rootScope', '$controller','$sce', function LoginController($http, $scope, $rootScope, $controller, $sce) {
        $controller('CoreController', {
            $scope: $scope
        });
        
        $scope.init = function (itemId) {
            $scope.itemId = itemId;
            
            $scope.itemImageMeta = [];
            
           var url = "/rest/item/"+itemId;
            $http.get(url).success(function (data, status, headers) {
                $scope.item = data;
                if($scope.item.itemImageMeta.length > 4){
	                for(imageMeta in $scope.item.itemImageMeta){
	                	 if(imageMeta < 4){
	                		 $scope.itemImageMeta.push($scope.item.itemImageMeta[imageMeta]);
	                	 }
	                }
                }
                else{
                	$scope.itemImageMeta = $scope.item.itemImageMeta;
                }
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
        
        $scope.imageGlow =0;
        $scope.imageGhigh = 3;
        
        $scope.handleItemGalaryNext = function(){
        	
        	if($scope.imageGhigh < $scope.item.itemImageMeta.length-1){
        		$scope.itemImageMeta = [];
        		$scope.imageFullView = "";
        		$scope.deActivePre = false;
        		$scope.imageGlow++;
        		$scope.imageGhigh++;
        		for( var i = $scope.imageGlow;i<=$scope.imageGhigh;i++){
        			$scope.itemImageMeta.push($scope.item.itemImageMeta[i]);
        		}
        		if($scope.imageGhigh >= $scope.item.itemImageMeta.length-1){
        			$scope.deActiveNext = true;
        		}
        	}
        	
        }
        
        $scope.handleItemGalaryPre = function(){
        	if($scope.imageGlow > 0){
        		$scope.itemImageMeta = [];
        		$scope.imageFullView = "";
        		$scope.deActiveNext = false;
        		$scope.imageGlow--;
        		$scope.imageGhigh--;
        		for( var i = $scope.imageGlow;i<=$scope.imageGhigh;i++){
        			$scope.itemImageMeta.push($scope.item.itemImageMeta[i]);
        			setTimeout($scope.handleItemGalaryPre, 2000);
        		}
        		
        		if($scope.imageGlow==0){
            		$scope.deActivePre = true;
            	}
        	}
        	
        };
        
        $scope.showFullImage = function(imagePath){
        	$scope.imageFullView = imagePath;
        };
        
        $scope.getTrustAsHtml = function(text){
        	
        	if(text != null && typeof text != 'undefined'){
        		return $sce.trustAsHtml(text);
        	}
        	
        	return text;
        };

        var controller = {};
        return controller;
    }]);

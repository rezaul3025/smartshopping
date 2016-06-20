var shSmartShoppingApp = angular.module("SmartShoppingApp",['ngMessages']);

shSmartShoppingApp.factory('shUtilsService', [function () {
    return new UtilsService();
}]);

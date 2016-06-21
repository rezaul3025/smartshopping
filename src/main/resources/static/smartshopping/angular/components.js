
shSmartShoppingApp.directive('shUserNameField', function () {
    return {
        restrict: 'E',
        replace: true,
        template: function (element, attrs) {
            var form = sh.getProperty(attrs, "shForm", "loginForm");
            var field = sh.getProperty(attrs, "shField", "userName");

            var errors = sh.getProperty(attrs, "shErrorMessages", "userNameMessages");

            return shDirective.inputFieldTemplate(form, field, errors, "sh-user-name=''", "User name", element);
        }
    };
});
shSmartShoppingApp.directive('shUserName', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$validators.mandatory = function (value) {
                return value != "" && value != undefined && value != null;
            };
        }
    };
});

shSmartShoppingApp.directive('shTextField', function () {
    return {
        restrict: 'E',
        replace: true,
        template: function (element, attrs) {
            var form = sh.getProperty(attrs, "shForm", "textFieldForm");
            var field = sh.getProperty(attrs, "shField", "textField");
            var errors = sh.getProperty(attrs, "shErrorMessages", "textFieldMessages");
            var placeHolder = sh.getProperty(attrs, "shPlaceholder", "textFieldPlaceholder");
            var required = sh.getProperty(attrs, "shRequired", false);
            return shDirective.inputFieldTemplate(form, field, errors, "sh-text=''", placeHolder, element);
        }
    };
});
shSmartShoppingApp.directive('shText', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$validators.mandatory = function (value) {
                if (!attrs.shRequired) {
                    return true;
                }
                return value != "" && value != undefined && value != null;
            };
            
            ngModel.$validators.pattern = function (value) {
                if (!attrs.pattern == 'undefined') {
                    return true;
                }
                var test = attrs.pattern.test(value);
                return attrs.pattern.test(value);
            };
        }
    };
});
shSmartShoppingApp.directive('shTextAreaFileld', function () {
    return {
        restrict: 'E',
        replace: true,
        template: function (element, attrs) {
            var form = sh.getProperty(attrs, "shForm", "textAreaFieldForm");
            var field = sh.getProperty(attrs, "shField", "textField");
            var errors = sh.getProperty(attrs, "shErrorMessages", "textAreaFieldMessages");
            var placeHolder = sh.getProperty(attrs, "shPlaceholder", "textAreaFieldPlaceholder");
            return shDirective.inputAreaFieldTemplate(form, field, errors, "sh-text-area=''", placeHolder, element);
        }
    };
});
shSmartShoppingApp.directive('shTextArea', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$validators.mandatory = function (value) {
                if (!attrs.shRequired) {
                    return true;
                }

                return value != "" && value != undefined && value != null;
            };
        }
    };
});

shSmartShoppingApp.directive('shSearchField', function () {
    return {
        restrict: 'E',
        replace: true,
        template: function (element, attrs) {
            var form = sh.getProperty(attrs, "shForm", "textSearchForm");
            var field = sh.getProperty(attrs, "shField", "searchField");
            var errors = sh.getProperty(attrs, "shErrorMessages", "searchFieldMessages");
            var placeHolder = sh.getProperty(attrs, "shPlaceholder", "searchFieldPlaceholder");
            return shDirective.selectFieldTemplate(form, field, errors, "sh-search=''", placeHolder, element);
        }
    };
});
shSmartShoppingApp.directive('shSearch', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            /*ngModel.$validators.mandatory = function(value){
             if(!attrs.shRequired){
             return true;
             }
             
             return value != "" && value != undefined && value != null;
             };*/
            //var params = {"page":0,"term":element.val()};
            return shDirective.selectBox({}, element, "/rest/business/name");
        }
    };
});



shSmartShoppingApp.directive('shItemThumDiv', [function () {
        return {
            restrict: 'E',
            replace: true,
            template: function (element, attrs) {
                var form = sh.getProperty(attrs, "shForm", "itemThumForm");
                var field = sh.getProperty(attrs, "shField", "itemThum");
                var errors = sh.getProperty(attrs, "shErrorMessages", "itemThumMessages");
                var title = sh.getProperty(attrs, "shTitle", "Deafult title");
                var description = sh.getProperty(attrs, "shDesc", "Deafult description");
                var imageurl = sh.getProperty(attrs, "shUrl", "#");
                return shDirective.itemThumTemplate(form, field, errors, title, description, imageurl, element);
            }
        };
    }]);


shSmartShoppingApp.directive('shFileUploadField', [function () {
        return {
            restrict: 'E',
            replace: true,
            template: function (element, attrs) {
                var form = sh.getProperty(attrs, "shForm", "fileUploadForm");
                var field = sh.getProperty(attrs, "shField", attrs.id);
                var errors = sh.getProperty(attrs, "shErrorMessages", "logoUploadMessages");
                return shDirective.inputFieldTemplate(form, field, errors, "sh-file-upload=''", "Select file", element);
            }
        };
    }]);

shSmartShoppingApp.directive('shFileUpload', ['shUtilsService', '$parse', function (shUtilsService, $parse) {
        return {
            restrict: 'A',
            require: 'ngModel',
            link: function (scope, element, attrs, ngModel) {

                /*
                 * ngModel.$render = function () {
                 * ngModel.$setViewValue(element.val()); };
                 */
                /*el.bind('change', function (event) {
                 var files = event.target.files;
                 //iterate files since 'multiple' may be specified on the element
                 for (var i = 0;i<files.length;i++) {
                 //emit event upward
                 scope.$emit("fileSelected", { file: files[i] });
                 }                                       
                 });*/


                element.bind('change', function () {
                    /*
                     * scope.$apply(function () {
                     * ngModel.$render();
                     * });
                     */
                    var values = [];
                    angular.forEach(element[0].files, function (item) {
                        /*var value1 = {
                         // File Name 
                         name: item.name,
                         //File Size 
                         size: item.size,
                         //File URL to view 
                         url: URL.createObjectURL(item),
                         // File Input Value 
                         _file: item
                         };*/
                        values.push(item);
                    });

                    var model = $parse(attrs.ngModel);
                    var modelSetter = model.assign;

                    scope.$apply(function () {
                        //for (var i = 0; i < element[0].files.length; ++i) {
                        modelSetter(scope, values);
                        //}
                    });

                });

                ngModel.$validators.validFileCheck = function (values) {
                    if (typeof values == 'undefined') {
                        return true;
                    }
                    for (var value in values) {
                        if (!shUtilsService.isValidFileFormat(attrs.formats, values[value].name)) {
                            return false;
                        }
                    }

                    return true;
                };

                ngModel.$validators.validFileNameCheck = function (values) {
                    if (typeof values == 'undefined') {
                        return true;
                    }
                    for (var value in values) {
                        if (values[value].name.split(".").length > 2) {
                            return false;
                        }
                    }
                    return true;
                };

                ngModel.$validators.fileSizeCheck = function (values) {
                    var maxDocSize = parseInt(attrs.docmaxsize);
                    if (typeof values == 'undefined') {
                        return true;
                    }
                    for (var value in values) {
                        if (Math.round(values[value].size / 1024) > maxDocSize) {
                            return false;
                        }
                    }
                    return true;

                };
            }
        };
    }]);

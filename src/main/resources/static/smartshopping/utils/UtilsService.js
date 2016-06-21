// <![CDATA[
var UtilsService = (function () {
    function UtilsService() {
        var _this = this;
        this.isValidFileFormat = function (fileTypes, checkFileType) {
            var fileTypeArr = fileTypes.split(",");
            for (var i in fileTypeArr) {
                if (checkFileType.indexOf(fileTypeArr[i]) != -1) {
                    return true;
                }
            }
            return false;
        };
    }
    return UtilsService;
})();
//]]> 
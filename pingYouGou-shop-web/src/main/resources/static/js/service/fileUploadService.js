app.service("fileUploadService", function ($http, pingYouGouServer) {
    this.uploadFile = function (imgData) {
        let file = imgData.get("file");
        return $http({
            url: `${pingYouGouServer}/goodsFile/file.do`,
            method: "POST",
            data: imgData,
            headers: {
                'Content-Type': undefined
            },
            transformRequest: angular.identity
        })
    }
})
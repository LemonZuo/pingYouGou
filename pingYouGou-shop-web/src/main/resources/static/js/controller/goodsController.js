app.controller('goodsController', function ($scope, $controller, goodsService, fileUploadService) {
    $controller('baseController', {$scope: $scope});

    $scope.addGoods = function () {
        // 商品简介
        $scope.data.goodsDesc.introduction = editor.html();
        goodsService.addGoods($scope.data).success(
            function (response) {
                if (response.responseStatus) {
                    // 清空页面数据
                    $scope.data = {};
                    editor.html("");
                    alert(response.responseMessageInfo);
                } else {
                    alert(response.responseMessageInfo)
                }
            }
        );
    }

    $scope.uploadFile = function () {
        let form = new FormData();
        form.append("file", file.files[0]);
        fileUploadService.uploadFile(form).success(
            function (response) {
                if (response.responseStatus) {
                    $scope.imgData = {};
                    $scope.imgData.imgUrl = response.responseMessageInfo
                } else {
                    // 上传失败
                    alert("上传失败")
                }
            }
        );
    }


})
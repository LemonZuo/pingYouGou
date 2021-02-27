app.controller('registerController', function ($scope, $controller, registerService, pingYouGouServer) {
    $controller('baseController', {$scope: $scope});
    /**
     * 申请入驻
     */
    $scope.applyForEntry = function () {
        console.log(typeof($scope.data));
        // let jsonStr = JSON.stringify($scope.data);
        // console.log(jsonStr);
        let messageType = undefined;
        registerService.applyForEntry($scope.data).success(
            function (response) {
                if (response.responseStatus) {
                    // 申请入驻成功
                    messageType = 'success';
                    // 跳转登录页
                    window.location.href = `${pingYouGouServer}/shoplogin.html`;
                } else {
                    // 入驻失败
                    messageType = 'info';
                }
                $.message({
                    type: `${messageType}`,
                    message: response.responseMessageInfo,
                    time: 2500
                })
            }
        )
    }
})
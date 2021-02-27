// 定义Controller
app.controller("indexController", function ($scope, $controller, indexService) {
    $controller('baseController', {$scope: $scope});
    // 显示登录用户名
    $scope.showName = function () {
        indexService.showName().success(
            function (response) {
                $scope.loginUserName = JSON.parse(response);
            }
        );
    }
})
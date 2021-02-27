// 定义 Controller
app.controller("sellerController", function ($scope, $controller, sellerService) {

    $controller('baseController',{$scope:$scope});

    /**
     * 获取分页数据
     * @param page 当前页
     * @param size 每页数据
     * @param name 品牌名
     * @param firstChar 首字母
     */
    $scope.findPage = function (page, size) {
        sellerService.findPage(page, size).success(
            function (response) {
                $scope.sellerList = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    $scope.findSellerDetialInfo = function (sellerId) {
        sellerService.findSellerDetialInfo(sellerId).success(
            function (response) {
                $scope.sellerDetailInfo = response;
            }
        );
    }

    /**
     * 核验商户
     */
    $scope.checkSeller = function (sellerId, preStatus) {
        sellerService.checkSeller(sellerId, preStatus).success(
            function (response) {
                if(response.responseStatus) {
                    $scope.reloadList();
                }
            }
        );
    }
})
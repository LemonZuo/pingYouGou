// 定义 Controller
app.controller("brandController", function ($scope, $controller, brandService) {

    $controller('baseController',{$scope:$scope});

    /**
     * 获取分页数据
     * @param page 当前页
     * @param size 每页数据
     * @param name 品牌名
     * @param firstChar 首字母
     */
    $scope.findPage = function (page, size, name, firstChar) {
        brandService.findPage(page, size, name, firstChar).success(
            function (response) {
                $scope.brandList = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    // 检测输入的品牌是否已经添加
    $scope.checkBrand = function () {
        if ($scope.action == "add") {
            $scope.brandCheckResult = {};
            if ($scope.brandName) {
                brandService.checkBrand($scope.brandName).success(function (response) {
                    $scope.brandCheckResult = response;
                });
            } else {
                $scope.brandCheckResult.responseStatus = true;
                $scope.brandCheckResult.responseMessageInfo = "品牌名不能为空";
            }
        }
    }

    // 修改操作标志
    $scope.changeAction = function (action) {
        $scope.action = action;
    }

    // 清空添加窗口数据
    $scope.clearBrandData = function () {
        $scope.brandId = '';
        $scope.brandName = '';
        $scope.brandFirstChar = '';
    }

    // 保存品牌
    $scope.saveBrand = function () {
        if ($scope.action == "add") {
            // 新增品牌
            brandService.addBrand($scope.brandName, $scope.brandFirstChar).success(function (data) {
                // 新增成功
                if (data.responseStatus) {
                    $scope.reloadList();
                }
            })
        } else if ($scope.action == "delete") {
            // 删除品牌
            brandService.deleteBrand(selectIds).success(function (data) {
                if (data.responseStatus) {
                    $scope.reloadList();
                }
            });
        } else if ($scope.action == "modify") {
            // 修改品牌信息
            brandService.modifyBrand($scope.brandId, $scope.brandName, $scope.brandFirstChar).success(function (data) {
                if (data.responseStatus) {
                    $scope.reloadList();
                }
            });
        } else {
        }
    }

    // 修改窗口数据显示
    $scope.showUpdate = function (brand) {
        $scope.brandId = brand.id;
        $scope.brandName = brand.name;
        $scope.brandFirstChar = brand.firstChar;
    }

    /**
     * 品牌搜索
     */
    /* $scope.searchBrand = function () {
         $scope.searchType = "search";
         $scope.reload = false;
         $scope.findPage(1, $scope.paginationConf.itemsPerPage, $scope.searchBrandName, $scope.searchBrandFirstChar);
     }*/
})
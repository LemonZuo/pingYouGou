// 定义 Controller
app.controller("specificationController", function ($scope, $controller, specificationService) {

    $controller('baseController', {$scope: $scope});

    /**
     * 获取分页数据
     * @param page 当前页
     * @param size 每页数据
     * @param name 品牌名
     * @param firstChar 首字母
     */
    $scope.findPage = function (page, size, name) {
        specificationService.findPage(page, size, name).success(
            function (response) {
                $scope.specificationList = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    // 检测输入的品牌是否已经添加
    $scope.checkSpecification = function () {
        if ($scope.action == "add") {
            $scope.specificationCheckResult = {};
            if ($scope.specificationName) {
                specificationService.checkSpecification($scope.specificationName).success(function (response) {
                    $scope.specificationCheckResult = response;
                });
            } else {
                $scope.specificationCheckResult.responseStatus = true;
                $scope.specificationCheckResult.responseMessageInfo = "品牌名不能为空";
            }
        }
    }

    // 修改操作标志
    $scope.changeAction = function (action) {
        $scope.action = action;
    }

    // 清空添加窗口数据
    $scope.clearSpecificationData = function () {
        $scope.specificationId = '';
        $scope.specificationName = '';
    }

    // 保存品牌
    $scope.saveSpecification = function () {
        if ($scope.action == "add") {
            // 新增品牌
            specificationService.addSpecification($scope.data).success(function (data) {
                // 新增成功
                if (data.responseStatus) {
                    $scope.reloadList();
                }
            })
        } else if ($scope.action == "delete") {
            // 删除品牌
            specificationService.deleteSpecification($scope.deleteId).success(function (data) {
                if (data.responseStatus) {
                    $scope.reloadList();
                }
            });
        } else if ($scope.action == "modify") {
            // 修改分类信息
            specificationService.modifySpecification($scope.data).success(function (data) {
                if (data.responseStatus) {
                    $scope.reloadList();
                }
            });
        } else {
        }
    }

    // 修改窗口数据显示
    $scope.showUpdate = function (specification) {
        $scope.specificationId = specification.id;
        $scope.specificationName = specification.name;
    }
    // 初始化面板
    $scope.showTable = function () {
        $scope.data = {specification: {}, specificationOptions: []};
    }
    // 增加行
    $scope.addRows = function () {
        $scope.data.specificationOptions.push({});
    }
    // 删除行
    $scope.remove = function (index) {
        $scope.data.specificationOptions.splice(index, 1);
    }

    // 查询本分类的所有信息
    $scope.findAllInfo = function (id) {
        specificationService.findAllInfo(id).success(
            function (response) {
                $scope.data = {};
                $scope.data.specification = {};
                $scope.data.specification.id = response.id;
                $scope.data.specification.specName = response.specName;
                $scope.data.specificationOptions = response.options;
            }
        );
    }
    // 修改待删除的ID
    $scope.changeDeleteId = function (id) {
        $scope.deleteId = id;
    }

})

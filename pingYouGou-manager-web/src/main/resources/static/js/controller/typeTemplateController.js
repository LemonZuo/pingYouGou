// 定义 Controller
app.controller("typeTemplateController", function ($scope, $controller, typeTemplateService, brandService, specificationService) {

    $controller('baseController', {$scope: $scope});

    /**
     * 获取分页数据
     * @param page 当前页
     * @param size 每页数据
     * @param name 品牌名
     * @param firstChar 首字母
     */
    $scope.findPage = function (page, size) {
        typeTemplateService.findPage(page, size).success(
            function (response) {
                $scope.typeTemplateList = response.rows;
                // 更新记录条数
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }
    // 品牌列表数据
    $scope.brandList = {data: []}
    $scope.findIdAndName = function () {
        brandService.findIdAndName().success(
            function (response) {
                $scope.brandList = {data: response};
            }
        );
    }

    // 规格列表数据
    $scope.specificationList = {data: []};
    $scope.findSpecificationIdAndName = function () {
        specificationService.findSpecificationIdAndName().success(
            function (response) {
                $scope.specificationList = {data: response};
            }
        )
    }
    // 增加扩展属性行
    $scope.addRows = function () {
        $scope.data.customAttributeItems.push({});
    }

    // 删除扩展属性行
    $scope.removeRows = function (index) {
        $scope.data.customAttributeItems.splice(index, 1);
    }

    // 保存数据
    $scope.addTypeTemplate = function () {
        typeTemplateService.addTypeTemplate($scope.data).success(
            function (response) {
                if (response.responseStatus) {
                    $scope.reloadList();
                }
            }
        )
    }

    // 查询单条模板信息
    $scope.findAllTypeTemplateInfoById = function (id) {
        typeTemplateService.findAllTypeTemplateInfoById(id).success(
            function (response) {
                $scope.data = {};
                $scope.data.name = response.name;
                $scope.data.specIds = JSON.parse(response.specIds);
                $scope.data.brandIds = JSON.parse(response.brandIds);
                $scope.data.customAttributeItems = JSON.parse(response.customAttributeItems);
            }
        )
    }

    // 删除模板
    $scope.deleteTemplateById = function (id) {
        typeTemplateService.deleteTemplateById(id).success(
            function (response) {
                if (response.responseStatus) {
                    $scope.reloadList();
                }
            }
        )
    }

    // 修改模板
    $scope.modifyTypeTemplate = function () {
        $scope.data.id = $scope.modifyId;
        typeTemplateService.modifyTypeTemplate($scope.data).success(
            function (response) {
                if (response.responseStatus) {
                    $scope.reloadList();
                }
            }
        )
    }

    $scope.changeAction = function (action) {
        $scope.action = action;
    }

    // 保存模板
    $scope.saveTemplate = function () {
        if ('modify' == $scope.action) {
            $scope.modifyTypeTemplate();
        } else if ('add' == $scope.action) {
            $scope.addTypeTemplate();
        }
    }

    $scope.changeModifyId = function (id) {
        $scope.modifyId = id;
    }
})

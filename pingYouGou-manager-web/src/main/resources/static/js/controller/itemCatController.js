// 定义 Controller
app.controller("itemCatController", function ($scope, $controller, itemCatService, typeTemplateService) {

    $controller('baseController', {$scope: $scope});

    // 上级ID
    $scope.parentId = 0;
    /**
     * 查询分类数据
     * @param parentId
     */
    $scope.findItemCat = function (parentId) {
        $scope.parentId = parentId;
        itemCatService.findItemCat(parentId).success(
            function (response) {
                $scope.itemCats = response;
            }
        );
    }

    /**
     * 改变面层级
     * @type {number}
     */
    $scope.grade = 1;
    $scope.changeGrade = function (value) {
        if (value < 1) {
            $scope.grade = 1;
        } else if (value > 3) {
            $scope.grade = 3;
        } else {
            $scope.grade = value;
        }
    }

    /**
     * 查询下级分类信息
     * @param itemCat
     */
    $scope.findSubordinate = function (itemCat) {
        if ($scope.grade == 2) {
            $scope.secondItemCat = itemCat;
        } else if ($scope.grade == 3) {
            $scope.thirdItemCat = itemCat;
        }
        $scope.findItemCat(itemCat.itemCatId)
    }


    $scope.findIdAndName = function () {
        typeTemplateService.findIdAndName().success(
            function (response) {
                $scope.typeTemplateList = response;
            }
        )
    }

    /**
     * 操作标志
     * @param action
     */
    $scope.changeAction = function (action) {
        $scope.action = action;
    }

    // 删除
    $scope.deleteItemCat = function (itemCatId) {
        itemCatService.deleteItemCat(itemCatId).success(
            function (response) {
                if(response.responseStatus) {
                    $scope.findItemCat($scope.parentId);
                }
            }
        )
    };

    // 保存数据
    $scope.save = function () {
        if ($scope.action == 'add') {
            $scope.item.parentId = $scope.parentId;
            $scope.item.typeId = $scope.typeId;
            itemCatService.addItemCat($scope.item).success(
                function (response) {
                    if(response.responseStatus) {
                        $scope.findItemCat($scope.parentId);
                    }
                }
            );
        } else if ($scope.action == 'modify') {
            // 保存修改数据
            itemCatService.modifyItemCat($scope.item).success(
                function (response) {
                    if(response.responseStatus) {
                        $scope.findItemCat($scope.parentId);
                    }
                }
            );
        }
    }

    /**
     * 初始化数据面板
     */
    $scope.init = function () {
        $scope.item = null;
    }

    /**
     * 获取修改数据
     * @param itemCatId
     */
    $scope.modifyItemCat = function (itemCatId) {
        itemCatService.findItemCatByItemCatId(itemCatId).success(
            function (response) {
                $scope.item = response;
            }
        );
    }
})
app.controller("baseController", function ($scope) {
    // 分页组件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 15, 20, 25],
        onChange: function () {
            $scope.reloadList();
        }
    };

    //重新加载列表 数据
    $scope.reloadList = function () {
        //切换页码
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, null, null);
    };

    $scope.selectIds = [];
    // 更新所选择的ID
    $scope.updateSelectId = function ($event, id) {
        let isSelected = $event.target.checked;
        if (isSelected) {
            // 追加
            $scope.selectIds.push(id);
        } else {
            // 移除
            let index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
    }

    /**
     * 提取Json关键数据
     * @param jsonString
     * @param key
     */
    $scope.jsonToString = function (jsonString, key) {
        let json = JSON.parse(jsonString);
        let len = json.length;
        let value = "";
        for (let i = 0; i < len; i++) {
            if( i > 0) {
                value += ",";
            }
            value += json[i][key];
        }
        return value;
    }
})
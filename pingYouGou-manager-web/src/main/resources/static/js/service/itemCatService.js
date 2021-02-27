// 定义 Service
app.service("itemCatService", function ($http, pingYouGouServer) {

    /**
     * 查询分类
     * @param parentId
     * @returns {*}
     */
    this.findItemCat = function (parentId) {
        let url = `${pingYouGouServer}/itemCat/itemCatInfo.do/${parentId}`;
        return $http.get(url);
    }

    this.addItemCat = function (itemCat) {
        let url = `${pingYouGouServer}/itemCat/item.do`;
        return $http.post(url, itemCat);
    }

    this.deleteItemCat = function (itemCatId) {
        let url = `${pingYouGouServer}/itemCat/item.do/${itemCatId}`;
        return $http.delete(url);
    }

    this.findItemCatByItemCatId = function (itemCatId) {
        let url = `${pingYouGouServer}/itemCat/item.do/${itemCatId}`;
        return $http.get(url);
    }

    // 修改数据
    this.modifyItemCat = function (itemCat) {
        let url = `${pingYouGouServer}/itemCat/item.do`;
        return $http.put(url, itemCat);
    }
})
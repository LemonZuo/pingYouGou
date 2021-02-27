app.service("goodsService", function ($http, pingYouGouServer) {
    let url = `${pingYouGouServer}/shopGoods/goods.do`;

    /**
     * 新增商品
     * @param data
     */
    this.addGoods = function (data) {
        return $http.post(url, data);
    }
})
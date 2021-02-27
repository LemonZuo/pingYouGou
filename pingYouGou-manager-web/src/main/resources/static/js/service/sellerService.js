// 定义 Service
app.service("sellerService", function ($http, pingYouGouServer) {
    /**
     * 获取分页数据
     * @param page 当前页
     * @param size 每页数据
     */
    this.findPage = function (page, size) {
        let url = `${pingYouGouServer}/seller/findPage.do?pageNum=${page}&pageSize=${size}`;
        return $http.get(url, {
            pageNum: page,
            pageSize: size
        });
    }

    this.findSellerDetialInfo = function (sellerId) {
        let url = `${pingYouGouServer}/seller/findSellerDetialInfo.do?sellerId=${sellerId}`;
        return $http.get(url);
    }

    /**
     * 商户审核
     * @param sellerId
     * @param preStatus
     */
    this.checkSeller = function (sellerId, preStatus) {
        let status = undefined;
        if ("pass" == preStatus) {
            // 通过
            status = 1;
        } else if ("reject" == preStatus) {
            // 驳回
            status = 2;
        } else if ("close" == preStatus) {
            // 关闭
            status = 3;
        }
        let url = `${pingYouGouServer}/seller/sellerInfo.do/sellerId/${sellerId}/status/${status}`;
        return $http.put(url);

    }

})
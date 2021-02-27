app.service("registerService", function ($http, pingYouGouServer) {
    /**
     * 申请入驻
     * @param data
     * @returns {*}
     */
    this.applyForEntry = function (data) {
        let url = `${pingYouGouServer}/seller/addSeller.do`;
        return $http.post(url, data);
        // return $http({
        //     url: url,
        //     method: 'POST',
        //     data: {
        //         seller: data
        //     }
        // })
    }
})
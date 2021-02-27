// 定义Service
app.service("indexService", function ($http, pingYouGouServer) {
    this.showName = function () {
        return $http({
            url: `${pingYouGouServer}/admin/showLoginName.do`,
            method: "GET"
        });
    }
})
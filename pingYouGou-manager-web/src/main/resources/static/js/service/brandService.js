// 定义 Service
app.service("brandService", function ($http, pingYouGouServer) {
    /**
     * 获取分页数据
     * @param page 当前页
     * @param size 每页数据
     * @param name 品牌名
     * @param firstChar 首字母
     */
    this.findPage = function (page, size, name, firstChar) {
        let url;
        if (name == null && firstChar == null) {
            url = `${pingYouGouServer}/brand/findBrandPage.do?pageNum=${page}&pageSize=${size}`;
        } else if (name != null && firstChar == null) {
            url = `${pingYouGouServer}/brand/findBrandPage.do?pageNum=${page}&pageSize=${size}&name=${name}`;
        } else if (name == null && firstChar != null) {
            url = `${pingYouGouServer}/brand/findBrandPage.do?pageNum=${page}&pageSize=${size}&firstChar=${firstChar}`;
        } else {
            url = `${pingYouGouServer}/brand/findBrandPage.do?pageNum=${page}&pageSize=${size}&name=${name}&firstChar=${firstChar}`;
        }
        return $http({
            url: url,
            method: 'GET'
        });
    }

    // 检测输入的品牌是否已经添加
    this.checkBrand = function (brandName) {
        return $http.get(
            `${pingYouGouServer}/brand/checkBrand.do?brandName=${brandName}`
        );
    }

    // 新增品牌
    this.addBrand = function (brandName, brandFirstChar) {
        return $http({
            url: `${pingYouGouServer}/brand/addBrand.do`,
            method: "POST",
            data: {
                name: brandName,
                firstChar: brandFirstChar
            }
        });
    }

    // 删除品牌
    this.deleteBrand = function (selectIds) {
        return $http({
            url: `${pingYouGouServer}/brand/deleteBrand.do?selectIds=${selectIds}`,
            method: "GET"
        });
    }

    // 修改品牌
    this.modifyBrand = function (brandId, brandName, brandFirstChar) {
        return $http({
            url: `${pingYouGouServer}/brand/updateBrand.do`,
            method: "POST",
            data: {
                id: brandId,
                name: brandName,
                firstChar: brandFirstChar
            }
        });
    }

    this.findIdAndName = function () {
        let url = `${pingYouGouServer}/brand/findIdAndName.do`
        return $http({
            url: url,
            method: 'GET'
        })
    }

})
// 服务层
app.service("typeTemplateService", function ($http, pingYouGouServer) {
    /**
     * 获取分页数据
     * @param page 当前页
     * @param size 每页数据
     * @param name 品牌名
     * @param firstChar 首字母
     */
    this.findPage = function (page, size) {
        let url = `${pingYouGouServer}/typeTemplate/typeTemplateInfo.do?pageNum=${page}&pageSize=${size}`;
        return $http({
            url: url,
            method: 'GET'
        });
    }

    this.findIdAndName = function () {
        let url = `${pingYouGouServer}/typeTemplate/findIdAndName.do`;
        return $http.get(url);
    }

    /**
     * 新增模板
     * @param data
     * @returns {*}
     */
    this.addTypeTemplate = function (data) {
        let url = `${pingYouGouServer}/typeTemplate/addTypeTemplate.do`
        return $http({
            url: url,
            method: 'POST',
            data: {
                name: data.name,
                specIds: data.specIds,
                brandIds: data.brandIds,
                customAttributeItems: data.customAttributeItems
            }
        })
    }

    /**
     * 查询单条模板信息
     * @param id
     * @returns {*}
     */
    this.findAllTypeTemplateInfoById = function (id) {
        let url = `${pingYouGouServer}/typeTemplate/findAllTypeTemplateInfoById.do?id=${id}`;
        return $http({
            url: url,
            method: 'GET'
        })
    }

    /**
     * 删除模板
     * @param id
     * @returns {*}
     */
    this.deleteTemplateById = function (id) {
        let url = `${pingYouGouServer}/typeTemplate/deleteTemplateById.do?id=${id}`;
        return $http({
            url: url,
            method: 'GET'
        })
    }

    this.modifyTypeTemplate = function (data) {
        let url = `${pingYouGouServer}/typeTemplate/modifyTypeTemplate.do`;
        return $http({
            url: url,
            method: 'POST',
            data: {
                id: data.id,
                name: data.name,
                specIds: data.specIds,
                brandIds: data.brandIds,
                customAttributeItems: data.customAttributeItems
            }
        })
    }
})

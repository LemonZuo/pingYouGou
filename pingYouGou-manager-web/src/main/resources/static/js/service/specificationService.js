// 服务层
app.service("specificationService", function ($http, pingYouGouServer) {
    /**
     * 获取分页数据
     * @param page 当前页
     * @param size 每页数据
     * @param name 品牌名
     * @param firstChar 首字母
     */
    this.findPage = function (page, size, specName) {
        let url;
        if (specName == null) {
            url = `${pingYouGouServer}/specification/findSpecificationPage.do?pageNum=${page}&pageSize=${size}`;
        } else if (specName != null) {
            url = `${pingYouGouServer}/specification/findSpecificationPage.do?pageNum=${page}&pageSize=${size}&specName=${specName}`;
        }
        return $http({
            url: url,
            method: 'GET'
        });
    }

    // 检测输入的品牌是否已经添加
    this.checkSpecification = function (specName) {
        return $http.get(
            `${pingYouGouServer}/specification/checkSpecification.do?specName=${specName}`
        );
    }

    // 新增品牌
    this.addSpecification = function (specificationGroup) {
        return $http({
            url: `${pingYouGouServer}/specification/addSpecification.do`,
            method: "POST",
            data: {
                specification: specificationGroup.specification,
                specificationOptionList: specificationGroup.specificationOptions
            }
        });
    }

    // 删除品牌
    this.deleteSpecification = function (selectIds) {
        return $http({
            url: `${pingYouGouServer}/specification/deleteSpecification.do?selectIds=${selectIds}`,
            method: "GET"
        });
    }

    // 修改品牌
    this.modifySpecification = function (specificationId, specificationName) {
        return $http({
            url: `${pingYouGouServer}/specification/updateSpecification.do`,
            method: "POST",
            data: {
                id: specificationId,
                specName: specificationName
            }
        });
    }

    this.findAllInfo = function (specificationId) {
        return $http({
            url : `${pingYouGouServer}/specification/findAllInfo.do?id=${specificationId}`,
            method: "GET"
        });
    }

    /**
     * 查询分类JSON数据
     * @returns {*}
     */
    this.findSpecificationIdAndName = function () {
        return $http({
            url: `${pingYouGouServer}/specification/findSpecificationIdAndName.do`,
            method: "GET"
        })
    }

})

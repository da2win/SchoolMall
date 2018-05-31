/**
 *
 * Created by Darwin on 2018/5/31.
 */
$(function () {
    var listUrl = '/scmall/shopadmin/getproductcategorylist';
    var addUrl = '/scmall/shopadmin/addproductcategory';
    var delUrl = '/scmall/shopadmin/delproductcategory';
    getList();
    function getList() {
        $.getJSON(
            listUrl,
            function (data) {
                if (data.success) {
                    var dataList = data.data;
                    $('.category-wrap').html('');
                    var tempHtml = '';
                    dataList.map(function (item) {
                        tempHtml += ''
                            + '<div class="row row-product-category now">'
                            + '<div class="col-33 product-category-name">'
                            + item.productCategoryName
                            + '</div>'
                            + '<div class="col-33">'
                            + item.priority
                            + '</div>'
                            + '<div class="col-33">'
                                + '<a href="#" class="button delete" data-id="'
                            + item.productCategoryId
                            +'">删除</a>'
                            + '</div></div>'
                    });
                    $('.category-wrap').append(tempHtml);
                }
            }
        )

    }
});

/**
 *
 * Created by Darwin on 2018/5/31.
 */
$(function () {
    var listUrl = '/scmall/shopadmin/getproductcategorylist';
    var addUrl = '/scmall/shopadmin/addproductcategory';
    var delUrl = '/scmall/shopadmin/removeproductcategory';
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
                            + '">删除</a>'
                            + '</div></div>'
                    });
                    $('.category-wrap').append(tempHtml);
                }
            }
        )

    }

    $("#new").click(function () {
        var tmpHtml = '';
        tmpHtml += '<div class="row row-product-category temp">'
            + '<div class="col-33"><input type="text" class="category-input category" placeholder="商品类别"></div>'
            + '<div class="col-33"><input type="text" class="category-input priority" placeholder="优先级"></div>'
            + '<div class="col-33"><a href="#" class="button delete">删除</a></div>'
            + '</div>'
        $(".category-wrap").append(tmpHtml);
    });

    $("#submit").click(function () {
        var tempArr = $(".temp");
        var productCategoryList = [];
        tempArr.map(function (index, item) {
            var obj = {
                productCategoryName: $(item).find('.category').val(),
                priority: $(item).find('.priority').val()
            };
            if (!!obj.productCategoryName && !!obj.priority) {
                productCategoryList.push(obj);
            }
        });
        $.ajax({
            url: addUrl,
            contentType: 'application/json;charset=UTF-8',
            type: 'POST',
            data: JSON.stringify(productCategoryList),
            success: function (data) {
                if (data.success) {
                    $.toast("提交成功");
                    getList();
                } else {
                    $.toast("提交失败");
                }
            }
        });
    });

    $('.category-wrap').on('click', '.row-product-category.temp .delete', function (e) {
        console.log($(this).parent().parent());
        $(this).parent().parent().remove();
    });

    $('.category-wrap').on('click', '.row-product-category.now .delete',
        function (e) {
            var target = e.currentTarget;
            $.confirm("确定删除?", function () {
                $.ajax({
                    url: delUrl,
                    type: 'POST',
                    data: {
                        productCategoryId: target.dataset.id,
                    },
                    dataType: 'json',
                    success: function (data) {
                        if (data.success) {
                            $.toast('删除成功');
                            getList();
                        } else {
                            $.toast(data.errMsg);
                        }
                    }
                })
            })
        })
});

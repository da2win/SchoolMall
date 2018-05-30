/**
 *
 * Created by Darwin on 2018/5/30.
 */

$(function () {

    getlist();
    function getlist(e) {
        $.ajax({
            url: '/scmall/shopadmin/getshoplist',
            type: 'get',
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    handleList(data.shopList);
                    handleUser(data.user);
                } else {
                    $.toast(data.errMsg);
                }
            }
        });
    }

    function handleUser(data) {
        $("#user-name").text(data.name);
    }

    function handleList(data) {
        var html = [];
        data.map(function (item) {
            html.push('<div class="row row-shop">');
            html.push('<div class="col-40">');
            html.push(item.shopName);
            html.push('</div>');
            html.push('<div class="col-40">');
            html.push(shopStatus(item.enableStatus));
            html.push('</div>');
            html.push('<div class="col-20">');
            html.push(goShop(item.enableStatus, item.shopId));
            html.push('</div></div>');
        });
        $('.shop-wrap').html(html.join(''));
    }

    function shopStatus(status) {
        var rs;
        if (status == -1) {
            rs = "店铺非法";
        } else if (status == 0) {
            rs = "审核中";
        } else if (status == 1) {
            rs = "审核通过";
        }

        return rs;
    }

    function goShop(status, shopId) {
        if (status == 1) {
            return '<a href="/scmall/shopadmin/shopmanagement?shopId=' +shopId + '">进入</a>'
        }
        return '';
    }
});

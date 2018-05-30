/**
 * Created by Darwin on 2018/5/30.
 */
$(function() {
    var shopId = getQueryString('shopId');
    var shopInfoUrl = '/scmall/shopadmin/getshopmanagementinfo?shopId=' + shopId;
    $.getJSON(shopInfoUrl, function (data) {
       if (data.redirect) {
           window.location.href = data.url;
       } else {
           if (!!data.shopId) {
               shopId = data.shopId;
           }
           $("#shopInfo").attr('href', '/scmall/shopadmin/shopoperation?shopId='+shopId);
       }
    });
})
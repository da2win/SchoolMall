/**
 * Created by Darwin on 2018/5/25.
 */
function changeVerifyCode(img) {
    img.src="../Kaptcha?" + Math.floor(Math.random() * 100);
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)")
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURIComponent(r[2]);
    }
    return '';
}
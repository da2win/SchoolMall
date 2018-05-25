/**
 * Created by Darwin on 2018/5/25.
 */
function changeVerifyCode(img) {
    img.src="../Kaptcha?" + Math.floor(Math.random() * 100);
}
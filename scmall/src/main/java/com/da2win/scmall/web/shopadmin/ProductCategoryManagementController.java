package com.da2win.scmall.web.shopadmin;

import com.da2win.scmall.dto.Result;
import com.da2win.scmall.entity.ProductCategory;
import com.da2win.scmall.entity.Shop;
import com.da2win.scmall.enums.ProductCategoryStateEnum;
import com.da2win.scmall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/31
 */
@RequestMapping("/shopadmin")
@Controller
public class ProductCategoryManagementController {

    @Autowired
    private ProductCategoryService  productCategoryService;

    @RequestMapping(value = "/getproductcategorylist", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {
        // To be removed.
        Shop shop = new Shop();
        shop.setShopId(1L);
        request.getSession().setAttribute("currentShop", shop);

        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        List<ProductCategory> list;
        if (currentShop != null && currentShop.getShopId() > 0) {
            list = productCategoryService.queryProductCategoryList(currentShop.getShopId());
            return new Result<>(true, list);
        }
        ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
        return new Result<>(false, ps.getState(), ps.getStateInfo());
    }
}

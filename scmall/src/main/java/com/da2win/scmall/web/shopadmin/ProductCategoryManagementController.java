package com.da2win.scmall.web.shopadmin;

import com.da2win.scmall.dto.ProductCategoryExecution;
import com.da2win.scmall.dto.Result;
import com.da2win.scmall.entity.ProductCategory;
import com.da2win.scmall.entity.Shop;
import com.da2win.scmall.enums.ProductCategoryStateEnum;
import com.da2win.scmall.exception.ProductCategoryOperationException;
import com.da2win.scmall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Darwin
 * @date 2018/5/31
 */
@RequestMapping("/shopadmin")
@Controller
public class ProductCategoryManagementController {

    @Autowired
    private ProductCategoryService productCategoryService;

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

    @RequestMapping(value = "/addproductcategory", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addProductCategories(@RequestBody List<ProductCategory> categories, HttpServletRequest request) {

        Map<String, Object> modelMap = new HashMap();
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        for (ProductCategory category : categories) {
            category.setShopId(currentShop.getShopId());
        }
        if (categories != null && categories.size() > 0) {
            try {
                ProductCategoryExecution execution = productCategoryService.batchAdddProductCategory(categories);
                if (execution.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", execution.getStateInfo());
                }
            } catch (Exception e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请至少输入一个商品类别!");
        }
        return modelMap;
    }

    @RequestMapping(value = "/removeproductcategory", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> removeProductCategory(Long productCategoryId, HttpServletRequest request) {

        Map<String, Object> modelMap = new HashMap();
        if (productCategoryId != null && productCategoryId > 0) {
            Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
            ProductCategoryExecution execution = productCategoryService.delteProductCategory(productCategoryId, currentShop.getShopId());
            try {
                if (execution.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", execution.getStateInfo());
                }
            } catch (ProductCategoryOperationException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        }  else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请至少选择一个商品类别!");
        }
        return modelMap;
    }
}

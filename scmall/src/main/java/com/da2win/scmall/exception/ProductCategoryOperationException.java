package com.da2win.scmall.exception;

/**
 *
 * @author Darwin
 * @date 2018/6/1
 */
public class ProductCategoryOperationException extends RuntimeException{

    private static final long serialVersionUID = 8326129852354939655L;

    public ProductCategoryOperationException(String message) {
        super(message);
    }
}

package com.pramati.module

import geb.Module

/**
 * Created by harikrishnab on 20-10-2015.
 */
class ShoppingBagModule extends Module{
    static content = {
        productTitle{$(".item-brief.text-capitalize")}
        productSize {$(".items-stock.off-edit-hide .size")}
        productPrice {$(".price>.standard-price")}
        totalAmount {$(".total-amt>div")}
        placeOrderButton{$(".cart-summery.clearfix .btn.btn-primary")}
        quantityEditLink{$(".items-stock.off-edit-hide .edit")}
        selectQuantityDropDown{$(".select-box.jabong-dropdown.select-quantity .form-control")}
        saveButton{$(".btn.btn-primary.save-btn")}
        }
}

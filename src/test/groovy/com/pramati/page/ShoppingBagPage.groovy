package com.pramati.page

import com.pramati.module.ShoppingBagModule
import geb.Page

/**
 * Created by harikrishnab on 20-10-2015.
 */
class ShoppingBagPage extends Page {

    static at = { title.startsWith("Cart") }

    static content = {
        shoppingBagPageObjetcs { module(ShoppingBagModule) }
    }

    def "verifyProductDetailsInShoppingBag"(String productName, String price, String size){
        shoppingBagPageObjetcs.productTitle == productName
       // shoppingBagPageObjetcs.productPrice == price
        shoppingBagPageObjetcs.productSize == size
        shoppingBagPageObjetcs.totalAmount.contains(price)
        shoppingBagPageObjetcs.placeOrderButton.displayed
    }

    def "changingQuantityOfProductsWith"(String quantity){
        shoppingBagPageObjetcs.quantityEditLink.click()
        shoppingBagPageObjetcs.selectQuantityDropDown == quantity
        Thread.sleep(1000L)
        shoppingBagPageObjetcs.saveButton.click()
    }

    def "verifyPriceValueAfterAddingQuantity"(String price, int quantity){
        int totalPrice = Integer.parseInt(price)*quantity
        shoppingBagPageObjetcs.productPrice == totalPrice.toString()
        shoppingBagPageObjetcs.totalAmount == totalPrice.toString()
    }

    def "clickOnPlaceOrderButton"(){
        shoppingBagPageObjetcs.placeOrderButton.click()

    }
}

package com.pramati.module

import geb.Module

/**
 * Created by harikrishnab on 16-10-2015.
 */
class ClothingPageModule extends Module {

    static content = {
        sortDropDown {$("select[name='sort']")}
        newBox {$("#catalog-product span[class*='offer']")*.text() }
        pricTags {$("#catalog-product span[class*='standard-price']")*.text() }
        discountTags{$("#catalog-product>.row.search-product.animate-products span[class*='discount']")*.text() }
        menClothing {$("#categories>.options.tree-view .cursor-default")}
        polosAndTees {$("#categories>.options.tree-view a[href*='polos-tshirts']")}
        formalShirts {$("#categories>.options.tree-view a[href*='formal-shirts']")}

        productInfoTitle {$("#catalog-product>.row.search-product.animate-products .h4>span")*.text() }
        firstProductTitle  {$("#catalog-product>.row.search-product.animate-products a[data-pos='1'] .h4>span")}
        firstProductBrandName  {$("#catalog-product>.row.search-product.animate-products a[data-pos='1'] .h4")}
        // firstProductTitle  { $(".product-info .h4")}
        firstProductLink  {$("#catalog-product>.row.search-product.animate-products a[data-pos='1'] img")}
        productTitleInInfoPage {$(".product-title")}
        productBrandNameInInfoPage {$(".brand")}
        productPriceValueInInfoPage {$(".actual-price")}
        addToBag {$("#add-to-cart")}
        firstProductPreviousPriceTag {$("#catalog-product>.row.search-product.animate-products a[data-pos='1'] .prev-price")}
        firstProductPriceTagValue {$("#catalog-product>.row.search-product.animate-products a[data-pos='1'] .price>.standard-price")}
        firstProductDiscountPrice {$("#catalog-product>.row.search-product.animate-products a[data-pos='1'] .price>.discount")}
        sizeError {$("#pdp-size-error")}
        firstSize{$(".size-desktop>ul>li>a>span")[0]}
        secondSize{$(".size-desktop>ul>li>a>span")[1]}
        shoppingBagIcon{$("#header-bag-sec a")}
        productTitleInBagView {$(".text-lowercase.product-name")}
        sizeInBagView{$(".select-size .clr-black")}
        quantityInBagView{$(".qty-block .clr-black") }
        extraCharges{$(".discount.final-price.text-left.text-uppercase .total-charges>span")}
        finalPriceInBagView{$(".discount.final-price.text-left.text-uppercase .text-capitalize>strong")}
        viewBagButton {$(".btn.btn-filled.text-uppercase.view-bag")}
    }
}

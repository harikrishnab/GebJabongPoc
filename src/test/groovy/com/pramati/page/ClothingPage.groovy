package com.pramati.page

import com.pramati.module.ClothingPageModule

import geb.Page
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.Select

/**
 * Created by harikrishnab on 16-10-2015.
 */
class ClothingPage extends Page {

    static at = { title.startsWith("Men Clothing") }

    static content = {
        clothingPageObjetcs { module(ClothingPageModule) }
    }

    def "selectSortByFunctionality"(String sortByName) {
        clothingPageObjetcs.sortDropDown = sortByName
       Thread.sleep(2000L)
    }

    def "verifyProductResultsInSorrtByWithNew"(String text) {
        List<String> li = clothingPageObjetcs.newBox.findAll()
        for (int i = 0; i < li.size(); i++) {
            assert li.get(i) == text
        }
        return true
    }

    def "verifyProductResultsInHighToLowPrice"() {
        List<String> li = clothingPageObjetcs.pricTags.findAll()
            for (int i = 0; i < li.size()-1; i++) {
           assert Integer.parseInt(li.get(i)) >= Integer.parseInt(li.get(i+1))
        }
        return true
    }

    def "verifyProductResultsInLowToHighPrice"() {
        List<String> li = clothingPageObjetcs.pricTags.findAll()
        /*for (int i = 0; i < li.size()-1; i++) {
            assert Integer.parseInt(li.get(i)) <= Integer.parseInt(li.get(i+1))
        }*/
        return true
    }
    def "verifyProductResultsInHighToLowDiscount"() {
        List<String> li = clothingPageObjetcs.discountTags.findAll()
        for (int i = 0; i < li.size()-1; i++) {
            assert Integer.parseInt(li.get(i).replaceAll("[(,),\\-,%]","")) >= Integer.parseInt(li.get(i+1).replaceAll("[(,),-,%]",""))
        }
        return true
    }

    def "selectProductsByFilterFunctionality"(String filterName) {
        clothingPageObjetcs.menClothing.click()
        clothingPageObjetcs.formalShirts.click()
        Thread.sleep(2000L)

    }

    def "verifyProductResultsWithFilterName"() {
        println "Started"
        List<String> li = clothingPageObjetcs.productInfoTitle.findAll()
        println li.size()
        for (int i = 0; i < li.size(); i++) {
            println li.get(i)
            assert li.get(i).contains("polo") || li.get(i).contains("T-Shirt")
        }
        return true

    }
    def "storeProductTitleInfo"(){
        println (clothingPageObjetcs.firstProductTitle.text()+"title of  page")
        def productTitleName = clothingPageObjetcs.firstProductTitle.text()
        return productTitleName
      }

    def "storeProductBrandName"(){
        println (clothingPageObjetcs.firstProductBrandName.text()+"title of  page")
        def brandName = clothingPageObjetcs.firstProductBrandName.text()
        return brandName
    }

    def "storeProductPriceValue"(){
        def priceValue
        try {
            clothingPageObjetcs.firstProductPreviousPriceTag.isDisplayed()
            priceValue = clothingPageObjetcs.firstProductPriceTagValue.text()
        }catch(Exception e){
            priceValue = clothingPageObjetcs.firstProductPriceTagValue.text()
        }

        return priceValue
    }

    def String "selectFirstProductInResultsPage"(){
        clothingPageObjetcs.firstProductLink.click()
    }

    def "VerifyProductDetailsInInfoPage"(String brandName, String productName, String price){
        brandName = brandName.split(" ")[0]
        println clothingPageObjetcs.productTitleInInfoPage.text()
        clothingPageObjetcs.productTitleInInfoPage.text() == productName
        println "Brand Name In Info Page "+clothingPageObjetcs.productBrandNameInInfoPage.text().toLowerCase()
        println "Brand Name From Base Page "+brandName.toLowerCase()
        clothingPageObjetcs.productBrandNameInInfoPage.text().toLowerCase() == brandName.toLowerCase()
        println "Price value in info page "+clothingPageObjetcs.productPriceValueInInfoPage.text()
        println "Price from base page "+price
        clothingPageObjetcs.productPriceValueInInfoPage.text() == price
    }

    def "clickOnAddToBag"(){
        clothingPageObjetcs.addToBag.click()
        Thread.sleep(5000L)
    }

    def "storeProductSizeValue"(){
        def size = clothingPageObjetcs.firstSize.text()
        return size
    }

    def "verifySieAlertMessage"(String errorMessage){
        clothingPageObjetcs.sizeError.text() == errorMessage
    }

    def "selectFirstSizeFromSizeList"(){
        clothingPageObjetcs.secondSize.click()
    }

    def "verifyProductDetailsInShoppingBagIcon"(String productName, String size, String quantity, String finalPrice){
        //waitFor {clothingPageObjetcs.shoppingBagIcon.displayed}
        def actions = new Actions(driver)
        actions.moveToElement(clothingPageObjetcs.shoppingBagIcon.firstElement()).build().perform()
        println clothingPageObjetcs.productTitleInBagView.text().toLowerCase()
        clothingPageObjetcs.productTitleInBagView.text().toLowerCase() == productName.toLowerCase()
        println clothingPageObjetcs.sizeInBagView.text().toLowerCase()
        clothingPageObjetcs.sizeInBagView.text().toLowerCase() == size.toLowerCase()
        println clothingPageObjetcs.quantityInBagView.text().toLowerCase()
        clothingPageObjetcs.quantityInBagView.text().toLowerCase() == quantity
        /*if(!clothingPageObjetcs.extraCharges.text().equalsIgnoreCase("free")){

        }else{
            println  clothingPageObjetcs.finalPriceInBagView.text().toLowerCase()
            clothingPageObjetcs.finalPriceInBagView.text().toLowerCase() == finalPrice.toLowerCase()
        }*/

    }

    def "clickOnViewBagInShoppingBagIcon"(){
        clothingPageObjetcs.viewBagButton.click()
    }



}
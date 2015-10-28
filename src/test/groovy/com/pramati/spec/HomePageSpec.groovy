package com.pramati.spec

import com.pramati.page.CheckoutPage
import com.pramati.page.ClothingPage
import com.pramati.page.HomePage
import com.pramati.page.ShoppingBagPage
import com.pramati.page.SignInPage
import geb.spock.GebReportingSpec
import spock.lang.Shared
import spock.lang.Stepwise


/**
 * Created by harikrishnab on 15-10-2015.
 */

@Stepwise
class HomePageSpec extends GebReportingSpec{
    @Shared def brand
    @Shared def price
    @Shared def productName
    @Shared def size
    @Shared def userName
    @Shared def password


     def "Login Application with valid credentials"(){

         setup: "Go To Application home page ans set required information"
         to HomePage
         userName = "bollahari@gmail.com"
         password = "Hari@123"

         when: "Click on Sign In button"
         clickOnSignInButton()

         then: "Navigate to Sign in page"
         at SignInPage

         when: "Entering login credentials in SignIn fields"
         enterLoginDetails(userName,password)

         then: "Navigated to Home page after successful login"
         at HomePage
         verifyLoginSuccessfully()
     }

//    @Ignore
    def "Verifying SortBy functionality of a result page"(){

        when: "Mouseover to one of main category and clicking on oe sub category"
        mouseOverOnMenCatagoryAndClickOnClothing()

        then: "Navigated to Clothing page"
        at ClothingPage

        when: "Select products sort by Whats new key"
        selectSortByFunctionality("What's new")

        then: "Verifying product results with New tag"
        verifyProductResultsInSorrtByWithNew("NEW")

        when: "Select products sort by Price: High to Low key"
        selectSortByFunctionality("Price: High to Low")

        then: "Verifying product results based on price values"
        verifyProductResultsInHighToLowPrice()

        when: "Select products sort by Discount: High to Low key"
        selectSortByFunctionality("Discount: High to Low")

        then: "Verifying product results based on discount values"
        verifyProductResultsInHighToLowDiscount()

        when: "Select products sort by Price: Low to High key"
        selectSortByFunctionality("Price: Low to High")

        then: "Verifying product results based on price values"
        verifyProductResultsInLowToHighPrice()
    }

    def "Verifying filter functionality of a result page and select first product"(){

        when: "Selecting products by one of filter"
        selectProductsByFilterFunctionality("Formal Shirts")

        then: "Verifying product results with filter name"
        true
        //verifyProductResultsWithFilterName()

        when: "Saving first product details and clicking on it"
        brand = storeProductBrandName()
        productName = storeProductTitleInfo()
        price = storeProductPriceValue()
        selectFirstProductInResultsPage()

        then: "Verifying product details in product info page"
        VerifyProductDetailsInInfoPage(brand, productName, price)

    }

    def "Selected product adding to Shopping Bag without Selecting Size"(){

        when: "Adding product to shopping bag"
        clickOnAddToBag()

        then: "Verifying alert message when adding product to bag without selecting size"
        verifySieAlertMessage("please select size")
    }

    def "Selected product adding to Shopping Bag by Selecting Size"(){
        when: " Saving size info and adding product to Shopping Bag"
        size = storeProductSizeValue()
        selectFirstSizeFromSizeList()
        clickOnAddToBag()

        then: "Verifying product details in Shopping  bag page"
        verifyProductDetailsInShoppingBagIcon(productName, size, "1", price)

        when: "Clicking on View bag button in Shopping bag icon"
        clickOnViewBagInShoppingBagIcon()

        then: "Navigated to Shopping bag page and verifying product details in shopping bag page"
        at ShoppingBagPage
        verifyProductDetailsInShoppingBag(productName, price, size)

    }

    def "place the order with increasing of product quantity"(){

        when:  "Increasing quantity of products"
        changingQuantityOfProductsWith("1")

        then: "Verifying price value after changing the product quantity"
        true
       // verifyPriceValueAfterAddingQuantity(price,2)

        when: "Click on place order button"
        clickOnPlaceOrderButton()

        then: "Navigated to checkout page and verify checkout steps status"
        at CheckoutPage
        verifyCheckoutStepsStatusByDefault(userName)
    }

    def "Checkout the product"(){
        when: "Adding my address details in Address information"
        fillTheAddressInformation()

        then: "Verifying Step2 status and Review information on active state"
        verifyCheckoutStep2Status()
        verifyProduuctDetailsInReviewInformaation(productName, size, "1", price)

        when: "Clicking on proceed  to pay button"
        clickOnProceedToPayButton()

        then: "Verifying make my payment field on active state"
        verifyCheckoutStep3Status()

    }



}

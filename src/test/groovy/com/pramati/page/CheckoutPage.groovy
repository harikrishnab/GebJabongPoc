package com.pramati.page

import com.pramati.module.CheckoutPageModule
import geb.Page

/**
 * Created by harikrishnab on 20-10-2015.
 */
class CheckoutPage extends Page{

    static at ={ title.startsWith("Checkout")}

    static content = {
        checkoutPageObjects{ module(CheckoutPageModule)}
    }

    def "verifyCheckoutStepsStatusByDefault"(String userName){
        checkoutPageObjects.checkOutStep1Completed.displayed
        checkoutPageObjects.checkOutStep2Pending.displayed
        checkoutPageObjects.checkOutStep3Pending.displayed
        checkoutPageObjects.checkOutStep4Pending.displayed
        checkoutPageObjects.emailVerification.text() == userName

    }

    def "fillTheAddressInformation"(){
        /*checkoutPageObjects.pincode.value("500082")
        checkoutPageObjects.firstName.value("Hari Krishna")
        checkoutPageObjects.address1.value("D-No:1-82, Madhapur, Hyderabad")
        waitFor {checkoutPageObjects.locality.displayed}
        checkoutPageObjects.locality = "Panjagutta"
        checkoutPageObjects.phone.value("9160838285")
        checkoutPageObjects.alternatePhone.value("9052364141")*/
        checkoutPageObjects.deliverToTheAddressButtonNew.click()
    }

    def "verifyCheckoutStep2Status"(){
        checkoutPageObjects.checkOutStep2Completed.displayed
        checkoutPageObjects.checkOut3StepStatusActive.displayed
    }

    def "verifyProduuctDetailsInReviewInformaation"(String productName, String size, String quantity, String price){
        checkoutPageObjects.productTitleName.text().equalsIgnoreCase(productName)
        checkoutPageObjects.productSize.text().equalsIgnoreCase(size)
        checkoutPageObjects.productQuantity.text().equalsIgnoreCase(quantity)
        checkoutPageObjects.productPrice.text().equalsIgnoreCase(price)
    }

    def "clickOnProceedToPayButton"(){
        checkoutPageObjects.proceedToPay.click()

    }

    def "verifyCheckoutStep3Status"(){
        checkoutPageObjects.checkOutStep3Completed.displayed
        checkoutPageObjects.checkOutStep1ChangeButton.displayed
        checkoutPageObjects.checkOutStep2ChangeButton.displayed
     }

}

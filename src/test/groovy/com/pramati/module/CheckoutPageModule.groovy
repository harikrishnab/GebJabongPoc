package com.pramati.module

import geb.Module

/**
 * Created by harikrishnab on 20-10-2015.
 */
class CheckoutPageModule extends Module{

    static content = {
        checkOutStep1Completed {$("#checkout-step1 .checkout-step-head.accordion-head.step_completed")}
        checkOutStep2Completed {$("#checkout-step2 .checkout-step-head.accordion-head.step_completed")}
        checkOutStep3Completed {$("#checkout-step3 .checkout-step-head.accordion-head.step_completed")}
        checkOutStep4Completed {$("#checkout-step4 .checkout-step-head.accordion-head.step_completed")}
        checkOutStep2Pending {$("#checkout-step2 .checkout-step-head.accordion-head.step_pending")}
        checkOutStep3Pending {$("#checkout-step3 .checkout-step-head.accordion-head.step_pending")}
        checkOutStep4Pending {$("#checkout-step4 .checkout-step-head.accordion-head.step_pending")}
        checkOut3StepStatusActive{$(".checkout-step-container.checkout-step-3.step3.col-sm-12.accordion.active")}
        emailVerification {$(".review-state .fill-details")}
        pincode{$("#postcode")}
        firstName{$("#first_name")}
        address1{$("#address1")}
        phone{$("#phone")}
        alternatePhone{$("#alternate_phone")}
        locality{$("#locality")}
        deliverToTheAddressButton {$("btn btn-payment add-to-cart")}
        productTitleName{$(".item-brief")}
        productSize{$(".size")}
        productQuantity{$(".qty")}
        productPrice{$(".price>.standard-price")}
        proceedToPay{$("#proceed_to_pay")}
        checkOutStep1ChangeButton{$("#checkout-step1 .btn.btn-small.btn-default")}
        checkOutStep2ChangeButton{$("#checkout-step2 .btn.btn-small.btn-default")}
        deliverToTheAddressButtonNew{$(".btn.btn-payment.add-to-cart.address-set.change-address")}
//

    }
}

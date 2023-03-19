var paymentMethod;
var language;
$(".input-radio-payment").click(function () {
    if ($("#payment-1").is(':checked')) {
        $("#vnpay-choose-language").hide();
        paymentMethod = "Cash";
    }
    if ($("#payment-2").is(':checked')) {
        $("#vnpay-choose-language").show();
        paymentMethod = "VNPay";
        language = $('input[name="language"]:checked').val();
    }
    if ($("#payment-3").is(':checked')) {
        $("#vnpay-choose-language").hide();
        paymentMethod = "Paypal"
    }
})
$(document).ready(function () {
    $(".primary-btn.order-submit").click(function () {
        let address = $("#address").val();
        let phone = $("#telephone").val();
        if ($("#address-diff").val() !== '' ){
            address = $("#address-diff").val();
        }

        switch (paymentMethod) {
            case "Cash":
                let a = document.createElement("a");
                a.href = "/Payment?" + "address="+address;
                a.click();
                break;
            case "VNPay":
                // var amount = $(".order-total").attr("class").split(" ")[1];
                var postData = "language=" + language +"&address=" +address;
                var submitUrl = "/paymentVNPay";
                $.ajax({
                    type: "POST",
                    url: submitUrl,
                    data: postData,
                    dataType: 'JSON',
                    success: function (x) {
                        console.log(x.data);
                        if (x.code === '00') {
                            if (window.vnpay) {
                                vnpay.open({width: 768, height: 600, url: x.data});
                            } else {
                                location.href = x.data;
                            }
                            return false;
                        } else {
                            alert(x.Message);
                        }
                    }
                });
                break;

        }

        return false;
    })
});

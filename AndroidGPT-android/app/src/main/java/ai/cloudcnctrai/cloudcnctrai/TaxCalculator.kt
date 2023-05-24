package ai.cloudcnctrai.cloudcnctrai

class TaxCalculator {

    companion object {
        val salesTaxPercentage = ""

        fun getTaxAmountForOrderItems(orderItemList: List<OrderItem>): Double {
            //
            var taxAmount = 0.0
            for (orderItem in orderItemList) {
                taxAmount += orderItem.price * 0.15
            }
            print ("Tax Amount is $taxAmount")
            return taxAmount
        }



    }
}
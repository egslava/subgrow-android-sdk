package jp.subgrow.android.demo.platform.utils.entities

import OfferDescription
import com.android.billingclient.api.ProductDetails
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSource.Companion.sortedByPrice

object Converter {
    fun product_details_to_offers(
        products: List<ProductDetails>,
    ): List<OfferDescription> {
        return products
            .map(Converter::_product_details_to_offers)
            .flatMap { it }
            .sortedBy { it.order }
    }

    private fun _product_details_to_offers(
        product: ProductDetails,
    ): List<OfferDescription> {
        val offers = product.subscriptionOfferDetails!!
            .sortedByPrice()
            .slice(0..0)
            .map { offer ->
                val _offer =
                    OffersPlaceholder.OFFERS.find { placeholder ->
//                        placeholder.tag in offer.offerTags
                        placeholder.productId == product.productId
                    }

                _offer!!.token = offer.offerToken
                _offer.buttonText = offer
                    .pricingPhases
                    .pricingPhaseList[0]
                    .formattedPrice
                _offer.productDetails = product

                _offer
            }.sortedBy { it.order }
        return offers
    }
}

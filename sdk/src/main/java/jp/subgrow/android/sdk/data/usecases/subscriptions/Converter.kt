package jp.subgrow.android.sdk.data.usecases.subscriptions

import com.android.billingclient.api.ProductDetails
import jp.subgrow.android.sdk.data.entities.Offer
import jp.subgrow.android.sdk.data.placeholder.OffersPlaceholder

object Converter {
    fun product_details_to_offers(
        products: List<ProductDetails>,
    ): List<Offer> {
        return products
            .map(::_product_details_to_offers)
            .flatMap { it }
            .sortedBy { it.order }
    }

    private fun _product_details_to_offers(
        product: ProductDetails,
    ): List<Offer> {
        val offers = product.subscriptionOfferDetails!!
            .map { offer ->
                val _offer =
                    OffersPlaceholder.OFFERS.find { placeholder ->
                        placeholder.tag in offer.offerTags
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

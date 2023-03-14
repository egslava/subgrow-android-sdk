package jp.subgrow.android.demo.platform.ui.subscriptions

import OfferDescription
import jp.subgrow.android.demo.platform.utils.entities.OffersPlaceholder.OFFERS
import jp.subgrow.android.sdk.data.repository.Offer
import jp.subgrow.android.sdk.platform.Logger
import java.lang.NullPointerException

object Converter {
    /** "00:09" until offer's expiration */
    fun OfferDescription?.expires_in_mmss(
        now: Long = System.currentTimeMillis(),
    ): String? {
        val offer = this ?: return null

        val seconds_till = (
            offer.purchase_time + offer.duration_millis
                - now) / 1000

        if (seconds_till <= 0)
            return null

        val mm = seconds_till / 60
        val ss = seconds_till % 60

        return "%02d:%02d".format(mm, ss)
    }

    fun List<Offer>.toOfferDescriptions(
    ) = map { offer ->
        OFFERS
            .find { offer.productId == it.productId }
            .also {
                if (it == null) {
                    Logger.error(
                        "ERROR",
                        "cannot find offer with productId: ${offer.productId}"
                    )
                }
            }
            ?.copy(
                purchase_time = offer.purchase_time?:0,
                token = offer.token,
            )
    }.filterNotNull()

    fun List<OfferDescription>.toSubscriptionItems(): List<SubscriptionItem> {
        val subscriptions = this

        val last = subscriptions.firstOrNull {
            it.purchase_time != 0L
        }

        val time_title = last.expires_in_mmss()

        return subscriptions.map {
            it.toSubscriptionItem(time_title)
        }
    }
}

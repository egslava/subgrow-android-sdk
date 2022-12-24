package jp.subgrow.android.demo.platform.utils.entities

import OfferDescription

object OffersPlaceholder {
    const val MINUTES = 60_000L

    fun product_id_to_tag(product_id: String): String {
        // "productId":
            //  "com.subgrow.subscription.oneMonth",
        return product_id.split('.').last().lowercase()
    }

    val OFFERS = mutableListOf(
//        oneweek, onemonth, threemonth, sixmonth,
//        oneyear
        OfferDescription(
            1,
            "One week",
            "Will last 5 mins",
            5 * MINUTES,
            "Start",
            "oneweek",
        ),
        OfferDescription(
            2,
            "One month",
            "Will last 5 mins",
            5 * MINUTES,
            "Start",
            "onemonth"
        ),
        OfferDescription(
            3,
            "3 months",
            "10 mins",
            10 * MINUTES,
            "300円",
            "threemonth"
        ),
        OfferDescription(4,
            "6 months",
            "15 mins",
            15 * MINUTES,
            "600円",
            "sixmonth"
        ),
        OfferDescription(5,
            "One year",
            "30 mins",
            30 * MINUTES,
            "1000円",
            "oneyear"
        ),
    )
}


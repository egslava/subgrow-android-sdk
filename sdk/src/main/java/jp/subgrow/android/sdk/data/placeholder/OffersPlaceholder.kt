package jp.subgrow.android.sdk.data.placeholder

import jp.subgrow.android.sdk.data.entities.Offer

object OffersPlaceholder {
    const val MINUTES = 60_000L

    fun product_id_to_tag(product_id: String): String {
        // "productId":
            //  "com.b2s.subscription.oneMonth",
        return product_id.split('.').last().lowercase()
    }

    val OFFERS = mutableListOf(
//        oneweek, onemonth, threemonth, sixmonth,
//        oneyear
        Offer(
            1,
            "One week",
            "Will last 5 mins",
            5 * MINUTES,
            "Start",
            "oneweek",
        ),
        Offer(
            2,
            "One month",
            "Will last 5 mins",
            5 * MINUTES,
            "Start",
            "onemonth"
        ),
        Offer(
            3,
            "3 months",
            "10 mins",
            10 * MINUTES,
            "300円",
            "threemonth"
        ),
        Offer(4,
            "6 months",
            "15 mins",
            15 * MINUTES,
            "600円",
            "sixmonth"
        ),
        Offer(5,
            "One year",
            "30 mins",
            30 * MINUTES,
            "1000円",
            "oneyear"
        ),
    )
}


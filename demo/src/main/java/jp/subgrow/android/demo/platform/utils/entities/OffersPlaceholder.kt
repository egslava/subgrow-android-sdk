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

//    5mins:　5分間継続
//    15 mins.:
//    30 mins.: 30分間継続
//    1 hour: 　1時間継続
        OfferDescription(
            1,
            "One week",
            "5分間継続",
            5 * MINUTES,
            "Start",
            "oneweek",
        ),
        OfferDescription(
            2,
            "1ヶ月プラン",
            "5分間継続",
            5 * MINUTES,
            "100円",
            "onemonth"
        ),
        OfferDescription(
            3,
            "３ヶ月プラン",
            "10分間継続",
            10 * MINUTES,
            "300円",
            "threemonth"
        ),
        OfferDescription(4,
            "６ヶ月プラン",
            "10分間継続",
            15 * MINUTES,
            "600円",
            "sixmonth"
        ),
        OfferDescription(5,
            "1年プラン",
            "30分間継続",
            30 * MINUTES,
            "1000円",
            "oneyear"
        ),


        // synonyms, often used within refactor:
        OfferDescription(
            1,
            "試用期間",
            "5分間継続",
            5 * MINUTES,
            "Start",
            "com.subgrow.subscription.freemonth",
        ),
        OfferDescription(
            2,
            "1ヶ月プラン",
            "5分間継続",
            5 * MINUTES,
            "100円",
            "com.subgrow.subscription.onemonth",
        ),
        OfferDescription(
            3,
            "３ヶ月プラン",
            "10分間継続",
            10 * MINUTES,
            "300円",
            "com.subgrow.subscription.threemonth",
        ),
        OfferDescription(4,
            "６ヶ月プラン",
            "10分間継続",
            15 * MINUTES,
            "600円",
            "com.subgrow.subscription.sixmonth"
        ),
        OfferDescription(5,
            "1年プラン",
            "30分間継続",
            30 * MINUTES,
            "1000円",
            "com.subgrow.subscription.oneyear",
        ),


        // synonyms, often used within refactor:
        OfferDescription(
            1,
            "試用期間",
            "5分間継続",
            5 * MINUTES,
            "Start",
            "com.b2s.subscription.freemonth",
        ),
        OfferDescription(
            2,
            "1ヶ月プラン",
            "5分間継続",
            5 * MINUTES,
            "100円",
            "com.b2s.subscription.oneMonth"
        ),

        OfferDescription(
            20,
            "hidden",  // filtered out by title
            "5分間継続",
            5 * MINUTES,
            "50円",
            "com.subgrow.subscription.onemonth.50off"
        ),
        OfferDescription(
            21,
            "hidden",  // filtered out by title
            "5分間継続",
            5 * MINUTES,
            "50円",
            "com.b2s.subscription.sixmonth.25off"
        ),
        OfferDescription(
            3,
            "３ヶ月プラン",
            "10分間継続",
            10 * MINUTES,
            "300円",
            "com.b2s.subscription.threemonth"
        ),
        OfferDescription(
            3,
            "３ヶ月プラン",
            "10分間継続",
            10 * MINUTES,
            "300円",
            "com.b2s.subscription.threemonth3"
        ),
        OfferDescription(4,
            "６ヶ月プラン",
            "15分間継続",
            15 * MINUTES,
            "600円",
            "com.b2s.subscription.sixmonth"
        ),
        OfferDescription(5,
            "1年プラン",
            "30分間継続",
            30 * MINUTES,
            "1000円",
            "com.b2s.subscription.oneYear"
        ),
//        OfferDescription(
//            1,
//            "One week",
//            "Will last 5 mins",
//            5 * MINUTES,
//            "Start",
//            "oneweek",
//        ),
//        OfferDescription(
//            2,
//            "One month",
//            "Will last 5 mins",
//            5 * MINUTES,
//            "Start",
//            "onemonth"
//        ),
//        OfferDescription(
//            3,
//            "3 months",
//            "10 mins",
//            10 * MINUTES,
//            "300円",
//            "threemonth"
//        ),
//        OfferDescription(4,
//            "6 months",
//            "15 mins",
//            15 * MINUTES,
//            "600円",
//            "sixmonth"
//        ),
//        OfferDescription(5,
//            "One year",
//            "30 mins",
//            30 * MINUTES,
//            "1000円",
//            "oneyear"
//        ),
//
//
//        // synonyms, often used within refactor:
//        OfferDescription(
//            1,
//            "Free month",
//            "Will last 5 mins",
//            5 * MINUTES,
//            "Start",
//            "com.subgrow.subscription.freemonth",
//        ),
//        OfferDescription(
//            2,
//            "One month",
//            "Will last 5 mins",
//            5 * MINUTES,
//            "Start",
//            "com.subgrow.subscription.onemonth",
//        ),
//        OfferDescription(
//            3,
//            "3 months",
//            "10 mins",
//            10 * MINUTES,
//            "300円",
//            "com.subgrow.subscription.threemonth",
//        ),
//        OfferDescription(4,
//            "6 months",
//            "15 mins",
//            15 * MINUTES,
//            "600円",
//            "com.subgrow.subscription.sixmonth"
//        ),
//        OfferDescription(5,
//            "One year",
//            "30 mins",
//            30 * MINUTES,
//            "1000円",
//            "com.subgrow.subscription.oneyear",
//        ),
//
//
//        // synonyms, often used within refactor:
//        OfferDescription(
//            1,
//            "Free month",
//            "Will last 5 mins",
//            5 * MINUTES,
//            "Start",
//            "com.b2s.subscription.freemonth",
//        ),
//        OfferDescription(
//            2,
//            "One month",
//            "Will last 5 mins",
//            5 * MINUTES,
//            "Start",
//            "com.b2s.subscription.oneMonth"
//        ),
//        OfferDescription(
//            3,
//            "3 months",
//            "10 mins",
//            10 * MINUTES,
//            "300円",
//            "com.b2s.subscription.threemonth"
//        ),
//        OfferDescription(
//            3,
//            "3 months",
//            "10 mins",
//            10 * MINUTES,
//            "300円",
//            "com.b2s.subscription.threemonth3"
//        ),
//        OfferDescription(4,
//            "6 months",
//            "15 mins",
//            15 * MINUTES,
//            "600円",
//            "com.b2s.subscription.sixmonth"
//        ),
//        OfferDescription(5,
//            "One year",
//            "30 mins",
//            30 * MINUTES,
//            "1000円",
//            "com.b2s.subscription.oneYear"
//        ),
    )
}


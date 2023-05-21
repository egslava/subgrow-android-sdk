package jp.subgrow.android.sdk.data.placeholder

import android.graphics.Color
import jp.subgrow.android.debug_ui.platform.ui.placeholder.data.JSONS
import jp.subgrow.android.sdk.data.repository.Token2Parser
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams

val product_id = "12345"
val promotion_offer_id =
    "An offer id, should be set in app store connect. It's sent to iOS within payment. Afterwords it goes to the bill and being sent to us."
val pushNotificationText = "You've got a personal offer!"
val bg_color = "#111111"
val bg_img_url = "https://static.vecteezy.com/system/resources/previews/002/402/683/original/night-starry-sky-and-pink-clouds-sunrise-free-vector.jpg"
val bg_image_base64_preview =
    "several-pixels wide image preview. Being shown while the main image from the url has not been loaded"

val img_url = "https://static.vecteezy.com/system/resources/previews/001/189/136/original/christmas-decoration-star-png.png"
val img_base64_preview = "image preview, " +
    "several-pixels wide image preview. Being shown while the main image from the url has not been loaded"


val title = "Get 100% off"
val title_color = "#ffffff"
val subtitle = "and one more free month."
val subtitle_color = "#fffffe"
val offer = "1 month for free. Then ¥10/month"

val offer_color = "#fffffd"
val btn_text = "Resubscribe"
val btn_text_color = "#fffffc"
val btn_color = "#ff0000"
fun footer(color: String) = """
            <center style='color: $color;'>
                <a
                    href='http://google.com'
                    style='color: $color; text-decoration: none;'>
                    Privacy policy
                </a>
                •
                <a
                    href='http://google.com'
                    style='color: $color; text-decoration: none;'
                    >
                    Terms of Service
                </a>
            </center>""".trimIndent()



object Token2 {

    val JSON = """
    {
          "productId": "$product_id",
          "promotionOfferId": "$promotion_offer_id",
          "pushNotificationText": "$pushNotificationText",
          "screen": {
            "backgroundColor": "$bg_color",
            "backgroundImage": {
              "url": "$bg_img_url",
              "base64": "$bg_image_base64_preview"
            },
            "image": {
              "url": "$img_url",
              "base64": "$img_base64_preview"
            },
            "title": {
              "text": "$title",
              "color": "$title_color"
            },
            "subtitle": {
              "text": "$subtitle",
              "color": "$subtitle_color"
            },
            "offer": {
              "text": "$offer",
              "color": "$offer_color"
            },
            "promotion_button": {
              "text": "$btn_text",
              "text_color": "$btn_text_color",
              "background_color": "$btn_color"
            },
            "lang": "en",
            "footer": footer("white")
          }
        }
    """

    val PARSED =  OfferParams(
        productId = product_id,
        promotionOfferId = promotion_offer_id,
        push_notification_text = pushNotificationText,
        background_color = Color.parseColor(bg_color),
        background_image = bg_img_url,
        background_image_preview = bg_image_base64_preview,
        img = img_url,
        img_preview = img_base64_preview,
        title = title,
        title_color = Color.parseColor(title_color),
        subtitle = subtitle,
        subtitle_color = Color.parseColor(
            subtitle_color),
        pricing_text = offer,
        pricing_text_color = Color.parseColor(
            offer_color),
        button_text = btn_text,
        button_text_color = Color.parseColor(
            btn_text_color),
        button_color = Color.parseColor(btn_color),
        footer = footer("white"),
    )

    val JSONs: List<OfferParams?> = Token2Parser.parseAll(JSONS)
}

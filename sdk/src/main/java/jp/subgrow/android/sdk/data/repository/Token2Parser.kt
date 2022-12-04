package jp.subgrow.android.sdk.data.repository

import android.graphics.Color
import org.json.JSONObject
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams

object Token2Parser {
    fun parse(token2: String): OfferParams? {
        val json = JSONObject(token2)

        if (json.optString("errors").isNotBlank() ||
            json.optString("error").isNotBlank()
        )
            return null

        val productId = json.optString("productId")
        val promotionOfferId =
            json.optString("promotionOfferId")
        val pushNotificationText =
            json.optString("pushNotificationText")

        val screen = json.optJSONObject("screen")
        val bg_color =
            screen?.optString("backgroundColor")

        val bg_img =
            screen?.optJSONObject("backgroundImage")
        val bg_img_url = bg_img?.optString("url")
        val bg_img_base64 = bg_img?.optString("base64")

        val img = screen?.optJSONObject("image")
        val img_url = img?.optString("url")
        val img_base64 = img?.optString("base64")

        val _title = screen?.optJSONObject("title")
        val title = _title?.optString("text")
        val title_color = _title?.optString("color")

        val _subtitle = screen
            ?.optJSONObject("subtitle")
        val subtitle = _subtitle?.optString("text")
        val subtitle_color = _subtitle
            ?.optString("color")


        val _offer = screen?.optJSONObject("offer")
        val offer = _offer?.optString("text")
        val offer_color = _offer?.optString("color")


//        button, footer, img, pricing,

        val _btn =
            screen?.optJSONObject("promotion_button")
        val btn_text = _btn?.optString("text")
        val btn_text_color =
            _btn?.optString("text_color")
        val btn_color = _btn
            ?.optString("background_color")

        val footer = screen?.optString("footer")

        return OfferParams(
            productId = productId,
            promotionOfferId = promotionOfferId,
            img = img_url ?: "",
            img_preview = img_base64 ?: "",
            title = title ?: "",
            title_color = title_color
                ?.let(Color::parseColor)
                ?: Color.WHITE,
            subtitle = subtitle ?: "",
            subtitle_color = subtitle_color
                ?.let(Color::parseColor)
                ?: Color.WHITE,
            pricing_text = offer ?: "",
            pricing_text_color = offer_color
                ?.let(Color::parseColor)
                ?: Color.WHITE,

            button_text = btn_text ?: "",
            button_text_color = btn_text_color
                ?.let(Color::parseColor)
                ?: Color.WHITE,

            button_color = btn_color
                ?.let(Color::parseColor)
                ?: Color.WHITE,

            background_color = bg_color
                ?.let(Color::parseColor)
                ?: Color.WHITE,
            background_image = bg_img_url ?: "",
            background_image_preview = bg_img_base64 ?: "",

            push_notification_text = pushNotificationText ?: "",
            footer = footer ?: "",
//        val text_color: Int = Color.RED,
//        val background_color: Int = Color.WHITE,
//        val background_image: String = "",
//        val background_image_preview: String = "",
//        val tos_link: String = "",
//        val privacy_link: String = "",
//        val push_notification_text: String = "",
//        val footer: String = "",
        )
    }
}

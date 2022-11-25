package jp.subgrow.android.sdk.platform.ui.offer

import android.graphics.Color
import android.graphics.Color.BLUE
import android.graphics.Color.RED
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class OfferParams(
    val productId: String = "",
    val promotionOfferId: String = "",
    val img: String = "",
    val img_preview: String = "",
    val title: String = "",
    val title_color: Int = Color.WHITE,
    val subtitle: String = "",
    val subtitle_color: Int = Color.WHITE,
    val pricing_text: String = "",
    val pricing_text_color: Int = Color.WHITE,
    val button_text: String = "",
    val button_color: Int = BLUE,
    val button_text_color: Int = Color.WHITE,
    val background_color: Int = Color.WHITE,
    val background_image: String = "",
    val background_image_preview: String = "",
    val push_notification_text: String = "",
    val footer: String = "",
): Parcelable

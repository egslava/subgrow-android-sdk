package jp.subgrow.android.sdk.data.placeholder

import android.graphics.Color
import jp.subgrow.android.sdk.data.repository.Token2Parser
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams

val product_id = "12345"
val promotion_offer_id =
    "id оффера, задается в app store connect. В iOS передается при оплате. Потом записывается в чеке и попадает к нам."
val pushNotificationText = "You've got a personal offer!"
val bg_color = "#111111"
val bg_img_url = "https://static.vecteezy.com/system/resources/previews/002/402/683/original/night-starry-sky-and-pink-clouds-sunrise-free-vector.jpg"
val bg_image_base64_preview =
    "превью, шириной в несколько пикселей. Показывается пока полноразмерное изображение из url не загрузилось"

val img_url = "https://static.vecteezy.com/system/resources/previews/001/189/136/original/christmas-decoration-star-png.png"
val img_base64_preview = "превью изображения, " +
    "шириной в несколько пикселей. Показывается пока полноразмерное изображение из url не загрузилось"

val title = "Get 100% off"
val title_color = "#ffffff"
val subtitle = "and one more free month."
val subtitle_color = "#fffffe"
val offer = "1 month for free. Then ¥10/month"

val offer_color = "#fffffd"
val btn_text = "Resubscribe"
val btn_text_color = "#fffffc"
val btn_color = "#ff0000"
val footer = """
    <center style='color: white;'>
        <a
            href='http://google.com'
            style='color: white; 
            text-decoration: none;'>
            Privacy policy
        </a>
        •
        <a
            href='http://google.com'
            style='color: white; 
            text-decoration: none;'
            >
            Terms of Service
        </a>
    </center>"""

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
            "footer": "$footer"
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
        footer = footer,
    )

    val JSONs: List<OfferParams?> = listOf(
            """
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#d5d9e1",
                        "backgroundImage": {
                            "base64": "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",
                            "url": "https://app.subgrow.net/test_images/Custom_offer_9.png"
                        },
                        "image": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAC4jAAAuIwF4pT92AAAE1ElEQVQ4jWWUe2xTVRjAv7sqJBgTQ4LEDdQIxohi0OAjY21vWycBDGEJM0MeKjgSBAcTZWMbjGzTDdjAAEOxvbUgr2UygWywsfbcrt0Gg7mHD0AMcbvdYA96elvKkLY7n957yyv88eXcc5Pvd37nfOd8AADAEwomkaojT2gCL9KE+PcjYW4YgsyMI48VJOZD/tSiGQVTS8zZkAN7+x2wubhUgxkJhTlNaoJOTdTgiTyh6Tyhm3lCt/OEbuEJ/VBfe/2FDwo9cHrh7nEbJhV2Zk3LySjdv+uTkrIds8ut+0CFGVwUTIqZZjGFJ9TBEyrzhKJJDNwPQjHVHfiXPxe2rppYIG56vqih9fKvy4tzy6uLKypKvtn5bTLoXf4HYYt5QsO8SJEnKiRmEgNRI6GRFBeNml3+2KskiHNLzuLhzMMoXwsNybdCmM3n4UrD2trt1sp1YPQEdfpzt4B3+VfcNeIJjZjEADMQykwiZanuAFvXGWJ6p5+NO+Bj5K9AFBFjiIi3R+7ENlq24JKXVl6scHyXC4aWm2BoDSerMC1iZg3M5nkC7KO2IG7oDGF+VxDT20LsyIDCQtZ3eRBPF9aNbpuxFdck5QytX5q/p6xyVyHkwRKw1F5v4d0y8k1y1OyR0eQNslfqhlnWBRnXtAdxZ08EjwcRJZ+Mf9ZfxJ+WH8LC5wrZqjd2jGZsJDi3duCPXG/T5K1FxVNB3xV7L/N9Gy5dKMT45hBLrpLYgop2lnP5Nv44zNATZHjpt2tYl3cS675uQO8uN66eVoYvb2zBSTWDbHKDHH2t/ga+fSawKK26A8DQHKpcPduKa8d+Gl00axvu3tPC+gbDGBkOYZfjLB5J+wFzkzZhXTnBcF8Ay9LsOL6oA6FqmIG1F2FfTxRsEo5xSDVwQAYwtN/2pH/RiAWJG2KukhPsak0HHss+hnmG3Zhp3IupGdVY7+lVzg23LxDwqa9aEY4Ooc7agwl2iXF2X4yz+xAE6RJYe8fCO6LcnX5mEGtO/x3L/76DzV/vRMuOTpx9vA+nN/px8z9qEbBy2UEcv74ZoWoIExQzuw85QQFKowqQE6R+EKSJsLA50FV+ZQTnt4VjM4nMjOdH0NIWxpnum7iiWy0oHsz6Gcdne5Vtou4+TAWCoAFBkHwgSBNgnifgtIgUUxr9MQuhzOIcxlnuEUx3SkhdAp78bC9OWNcS3+ZDMOQEH+MEKQaC+q97jO0SBykuWmokFM1iIGomftSLIWY6cQV/z5qO9W++hc987nkYFgeCZoec3RcFuzp3gCCB8uxmmkTlIlPGu/wspe0O8zYeZq2LP8akL88jVN1Ana0HVYsHYJzdpwCZUhQVLEhz7wKVN1xtFikmO2lk56mr2FTawF7M62RwaAB1tl4VBo/ClAUicZgX7D6AugvxXnhm+FmjW/annhrAZcVNEX15O+oO9SNn61WqqES8opqVBpOi8WJEObv0OtgkAEFK0HqgS7WcZSR0RN8aRsPZcOSJ/b5R5cIqEBUmaFZxw0j83JRYwCl2gqRTofG2pTVWQmfwTn/3u4TihKPXEKxqspaoWKqG8bkgXeUEyaiemwLTRgCLKINJDNyDPl3V//gcr7x2yi+DvfcM7co27xkOgCBt0tmlJzl7HObwAafY/R//AeO0262LK5dMAAAAAElFTkSuQmCC",
                            "url": "https://app.subgrow.net/test_images/airplane.png"
                        },
                        "title": {
                            "text": "本日限り！翌月に通常価格の半額でサービスをお使いいただけるチャンスです。",
                            "color": "#000000"
                        },
                        "subtitle": {
                            "text": "",
                            "color": "#000000"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#000000"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<style> p {text-align: center;} a {color: rgb(251, 161, 43); text-decoration: none;}</style><body><p><a href='https://backtosub.jp/tos_ja/' target='_blank''>利用規約</a> · <a href='https://backtosub.jp/privacy_ja/' target='_blank''>プライバシーに関する方針</a></p></body>"
                    }
                }
    
                """.trimIndent(),
            """
    
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#d5d9e1",
                        "backgroundImage": {
                            "base64": "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",
                            "url": "https://app.subgrow.net/test_images/Custom_offer_9.png"
                        },
                        "image": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAC4jAAAuIwF4pT92AAAE1ElEQVQ4jWWUe2xTVRjAv7sqJBgTQ4LEDdQIxohi0OAjY21vWycBDGEJM0MeKjgSBAcTZWMbjGzTDdjAAEOxvbUgr2UygWywsfbcrt0Gg7mHD0AMcbvdYA96elvKkLY7n957yyv88eXcc5Pvd37nfOd8AADAEwomkaojT2gCL9KE+PcjYW4YgsyMI48VJOZD/tSiGQVTS8zZkAN7+x2wubhUgxkJhTlNaoJOTdTgiTyh6Tyhm3lCt/OEbuEJ/VBfe/2FDwo9cHrh7nEbJhV2Zk3LySjdv+uTkrIds8ut+0CFGVwUTIqZZjGFJ9TBEyrzhKJJDNwPQjHVHfiXPxe2rppYIG56vqih9fKvy4tzy6uLKypKvtn5bTLoXf4HYYt5QsO8SJEnKiRmEgNRI6GRFBeNml3+2KskiHNLzuLhzMMoXwsNybdCmM3n4UrD2trt1sp1YPQEdfpzt4B3+VfcNeIJjZjEADMQykwiZanuAFvXGWJ6p5+NO+Bj5K9AFBFjiIi3R+7ENlq24JKXVl6scHyXC4aWm2BoDSerMC1iZg3M5nkC7KO2IG7oDGF+VxDT20LsyIDCQtZ3eRBPF9aNbpuxFdck5QytX5q/p6xyVyHkwRKw1F5v4d0y8k1y1OyR0eQNslfqhlnWBRnXtAdxZ08EjwcRJZ+Mf9ZfxJ+WH8LC5wrZqjd2jGZsJDi3duCPXG/T5K1FxVNB3xV7L/N9Gy5dKMT45hBLrpLYgop2lnP5Nv44zNATZHjpt2tYl3cS675uQO8uN66eVoYvb2zBSTWDbHKDHH2t/ga+fSawKK26A8DQHKpcPduKa8d+Gl00axvu3tPC+gbDGBkOYZfjLB5J+wFzkzZhXTnBcF8Ay9LsOL6oA6FqmIG1F2FfTxRsEo5xSDVwQAYwtN/2pH/RiAWJG2KukhPsak0HHss+hnmG3Zhp3IupGdVY7+lVzg23LxDwqa9aEY4Ooc7agwl2iXF2X4yz+xAE6RJYe8fCO6LcnX5mEGtO/x3L/76DzV/vRMuOTpx9vA+nN/px8z9qEbBy2UEcv74ZoWoIExQzuw85QQFKowqQE6R+EKSJsLA50FV+ZQTnt4VjM4nMjOdH0NIWxpnum7iiWy0oHsz6Gcdne5Vtou4+TAWCoAFBkHwgSBNgnifgtIgUUxr9MQuhzOIcxlnuEUx3SkhdAp78bC9OWNcS3+ZDMOQEH+MEKQaC+q97jO0SBykuWmokFM1iIGomftSLIWY6cQV/z5qO9W++hc987nkYFgeCZoec3RcFuzp3gCCB8uxmmkTlIlPGu/wspe0O8zYeZq2LP8akL88jVN1Ana0HVYsHYJzdpwCZUhQVLEhz7wKVN1xtFikmO2lk56mr2FTawF7M62RwaAB1tl4VBo/ClAUicZgX7D6AugvxXnhm+FmjW/annhrAZcVNEX15O+oO9SNn61WqqES8opqVBpOi8WJEObv0OtgkAEFK0HqgS7WcZSR0RN8aRsPZcOSJ/b5R5cIqEBUmaFZxw0j83JRYwCl2gqRTofG2pTVWQmfwTn/3u4TihKPXEKxqspaoWKqG8bkgXeUEyaiemwLTRgCLKINJDNyDPl3V//gcr7x2yi+DvfcM7co27xkOgCBt0tmlJzl7HObwAafY/R//AeO0262LK5dMAAAAAElFTkSuQmCC",
                            "url": "https://app.subgrow.net/test_images/airplane.png"
                        },
                        "title": {
                            "text": "本日限り！翌月に通常価格の半額でサービスをお使いいただけるチャンスです。",
                            "color": "#000000"
                        },
                        "subtitle": {
                            "text": "Limited time only!!",
                            "color": "#000000"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#000000"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<style> p {text-align: center;} a {color: rgb(251, 161, 43); text-decoration: none;}</style><body><p><a href='https://backtosub.jp/tos_ja/' target='_blank''>利用規約</a> · <a href='https://backtosub.jp/privacy_ja/' target='_blank''>プライバシーに関する方針</a></p></body>"
                    }
                }
    
                """.trimIndent(),
            """
    
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#d5d9e1",
                        "backgroundImage": {
                            "base64": "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",
                            "url": "https://app.subgrow.net/test_images/Custom_offer_9.png"
                        },
                        "image": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAC4jAAAuIwF4pT92AAAE1ElEQVQ4jWWUe2xTVRjAv7sqJBgTQ4LEDdQIxohi0OAjY21vWycBDGEJM0MeKjgSBAcTZWMbjGzTDdjAAEOxvbUgr2UygWywsfbcrt0Gg7mHD0AMcbvdYA96elvKkLY7n957yyv88eXcc5Pvd37nfOd8AADAEwomkaojT2gCL9KE+PcjYW4YgsyMI48VJOZD/tSiGQVTS8zZkAN7+x2wubhUgxkJhTlNaoJOTdTgiTyh6Tyhm3lCt/OEbuEJ/VBfe/2FDwo9cHrh7nEbJhV2Zk3LySjdv+uTkrIds8ut+0CFGVwUTIqZZjGFJ9TBEyrzhKJJDNwPQjHVHfiXPxe2rppYIG56vqih9fKvy4tzy6uLKypKvtn5bTLoXf4HYYt5QsO8SJEnKiRmEgNRI6GRFBeNml3+2KskiHNLzuLhzMMoXwsNybdCmM3n4UrD2trt1sp1YPQEdfpzt4B3+VfcNeIJjZjEADMQykwiZanuAFvXGWJ6p5+NO+Bj5K9AFBFjiIi3R+7ENlq24JKXVl6scHyXC4aWm2BoDSerMC1iZg3M5nkC7KO2IG7oDGF+VxDT20LsyIDCQtZ3eRBPF9aNbpuxFdck5QytX5q/p6xyVyHkwRKw1F5v4d0y8k1y1OyR0eQNslfqhlnWBRnXtAdxZ08EjwcRJZ+Mf9ZfxJ+WH8LC5wrZqjd2jGZsJDi3duCPXG/T5K1FxVNB3xV7L/N9Gy5dKMT45hBLrpLYgop2lnP5Nv44zNATZHjpt2tYl3cS675uQO8uN66eVoYvb2zBSTWDbHKDHH2t/ga+fSawKK26A8DQHKpcPduKa8d+Gl00axvu3tPC+gbDGBkOYZfjLB5J+wFzkzZhXTnBcF8Ay9LsOL6oA6FqmIG1F2FfTxRsEo5xSDVwQAYwtN/2pH/RiAWJG2KukhPsak0HHss+hnmG3Zhp3IupGdVY7+lVzg23LxDwqa9aEY4Ooc7agwl2iXF2X4yz+xAE6RJYe8fCO6LcnX5mEGtO/x3L/76DzV/vRMuOTpx9vA+nN/px8z9qEbBy2UEcv74ZoWoIExQzuw85QQFKowqQE6R+EKSJsLA50FV+ZQTnt4VjM4nMjOdH0NIWxpnum7iiWy0oHsz6Gcdne5Vtou4+TAWCoAFBkHwgSBNgnifgtIgUUxr9MQuhzOIcxlnuEUx3SkhdAp78bC9OWNcS3+ZDMOQEH+MEKQaC+q97jO0SBykuWmokFM1iIGomftSLIWY6cQV/z5qO9W++hc987nkYFgeCZoec3RcFuzp3gCCB8uxmmkTlIlPGu/wspe0O8zYeZq2LP8akL88jVN1Ana0HVYsHYJzdpwCZUhQVLEhz7wKVN1xtFikmO2lk56mr2FTawF7M62RwaAB1tl4VBo/ClAUicZgX7D6AugvxXnhm+FmjW/annhrAZcVNEX15O+oO9SNn61WqqES8opqVBpOi8WJEObv0OtgkAEFK0HqgS7WcZSR0RN8aRsPZcOSJ/b5R5cIqEBUmaFZxw0j83JRYwCl2gqRTofG2pTVWQmfwTn/3u4TihKPXEKxqspaoWKqG8bkgXeUEyaiemwLTRgCLKINJDNyDPl3V//gcr7x2yi+DvfcM7co27xkOgCBt0tmlJzl7HObwAafY/R//AeO0262LK5dMAAAAAElFTkSuQmCC",
                            "url": "https://app.subgrow.net/test_images/airplane.png"
                        },
                        "title": {
                            "text": "",
                            "color": "#000000"
                        },
                        "subtitle": {
                            "text": "Limited time only!!",
                            "color": "#000000"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#000000"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<style> p {text-align: center;} a {color: rgb(251, 161, 43); text-decoration: none;}</style><body><p><a href='https://backtosub.jp/tos_ja/' target='_blank''>利用規約</a> · <a href='https://backtosub.jp/privacy_ja/' target='_blank''>プライバシーに関する方針</a></p></body>"
                    }
                }
    
                """.trimIndent(),
            """
    
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#000000",
                        "backgroundImage": null,
                        "image": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAC4jAAAuIwF4pT92AAAE1ElEQVQ4jWWUe2xTVRjAv7sqJBgTQ4LEDdQIxohi0OAjY21vWycBDGEJM0MeKjgSBAcTZWMbjGzTDdjAAEOxvbUgr2UygWywsfbcrt0Gg7mHD0AMcbvdYA96elvKkLY7n957yyv88eXcc5Pvd37nfOd8AADAEwomkaojT2gCL9KE+PcjYW4YgsyMI48VJOZD/tSiGQVTS8zZkAN7+x2wubhUgxkJhTlNaoJOTdTgiTyh6Tyhm3lCt/OEbuEJ/VBfe/2FDwo9cHrh7nEbJhV2Zk3LySjdv+uTkrIds8ut+0CFGVwUTIqZZjGFJ9TBEyrzhKJJDNwPQjHVHfiXPxe2rppYIG56vqih9fKvy4tzy6uLKypKvtn5bTLoXf4HYYt5QsO8SJEnKiRmEgNRI6GRFBeNml3+2KskiHNLzuLhzMMoXwsNybdCmM3n4UrD2trt1sp1YPQEdfpzt4B3+VfcNeIJjZjEADMQykwiZanuAFvXGWJ6p5+NO+Bj5K9AFBFjiIi3R+7ENlq24JKXVl6scHyXC4aWm2BoDSerMC1iZg3M5nkC7KO2IG7oDGF+VxDT20LsyIDCQtZ3eRBPF9aNbpuxFdck5QytX5q/p6xyVyHkwRKw1F5v4d0y8k1y1OyR0eQNslfqhlnWBRnXtAdxZ08EjwcRJZ+Mf9ZfxJ+WH8LC5wrZqjd2jGZsJDi3duCPXG/T5K1FxVNB3xV7L/N9Gy5dKMT45hBLrpLYgop2lnP5Nv44zNATZHjpt2tYl3cS675uQO8uN66eVoYvb2zBSTWDbHKDHH2t/ga+fSawKK26A8DQHKpcPduKa8d+Gl00axvu3tPC+gbDGBkOYZfjLB5J+wFzkzZhXTnBcF8Ay9LsOL6oA6FqmIG1F2FfTxRsEo5xSDVwQAYwtN/2pH/RiAWJG2KukhPsak0HHss+hnmG3Zhp3IupGdVY7+lVzg23LxDwqa9aEY4Ooc7agwl2iXF2X4yz+xAE6RJYe8fCO6LcnX5mEGtO/x3L/76DzV/vRMuOTpx9vA+nN/px8z9qEbBy2UEcv74ZoWoIExQzuw85QQFKowqQE6R+EKSJsLA50FV+ZQTnt4VjM4nMjOdH0NIWxpnum7iiWy0oHsz6Gcdne5Vtou4+TAWCoAFBkHwgSBNgnifgtIgUUxr9MQuhzOIcxlnuEUx3SkhdAp78bC9OWNcS3+ZDMOQEH+MEKQaC+q97jO0SBykuWmokFM1iIGomftSLIWY6cQV/z5qO9W++hc987nkYFgeCZoec3RcFuzp3gCCB8uxmmkTlIlPGu/wspe0O8zYeZq2LP8akL88jVN1Ana0HVYsHYJzdpwCZUhQVLEhz7wKVN1xtFikmO2lk56mr2FTawF7M62RwaAB1tl4VBo/ClAUicZgX7D6AugvxXnhm+FmjW/annhrAZcVNEX15O+oO9SNn61WqqES8opqVBpOi8WJEObv0OtgkAEFK0HqgS7WcZSR0RN8aRsPZcOSJ/b5R5cIqEBUmaFZxw0j83JRYwCl2gqRTofG2pTVWQmfwTn/3u4TihKPXEKxqspaoWKqG8bkgXeUEyaiemwLTRgCLKINJDNyDPl3V//gcr7x2yi+DvfcM7co27xkOgCBt0tmlJzl7HObwAafY/R//AeO0262LK5dMAAAAAElFTkSuQmCC",
                            "url": "https://app.subgrow.net/test_images/airplane.png"
                        },
                        "title": {
                            "text": "Save 0.99${'$'} per month!",
                            "color": "#58a4eb"
                        },
                        "subtitle": {
                            "text": "Limited time only!!",
                            "color": "#58a4eb"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#58a4eb"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<style> p {text-align: center;} a {color: rgb(251, 161, 43); text-decoration: none;}</style><body><p><a href='https://backtosub.jp/tos_ja/' target='_blank'>利用規約</a></p></body>"
                    }
                }
    
                """.trimIndent(),
            """
    
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#000000",
                        "backgroundImage": null,
                        "image": null,
                        "title": {
                            "text": "Save 0.99${'$'} per month!",
                            "color": "#58a4eb"
                        },
                        "subtitle": {
                            "text": "Limited time only!!",
                            "color": "#58a4eb"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#58a4eb"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<body></body>"
                    }
                }
    
                """.trimIndent(),
            """
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#000000",
                        "backgroundImage": null,
                        "image": null,
                        "title": {
                            "text": "",
                            "color": "#58a4eb"
                        },
                        "subtitle": {
                            "text": "",
                            "color": "#58a4eb"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#58a4eb"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<body></body>"
                    }
                }
    
                """.trimIndent(),
            """
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#000000",
                        "backgroundImage": {
                            "base64": "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",
                            "url": "https://app.subgrow.net/test_images/5df963573949e25119a3ba011840654d.jpg"
                        },
                        "image": null,
                        "title": {
                            "text": "This is definitely the most beautiful offer screen out there. Period.",
                            "color": "#ff0000"
                        },
                        "subtitle": {
                            "text": "It's the best color matching we could find! And the text is short and brief. And definitely makes total sense. Why would it be here, anyway? It's not like we're trying to test how long text would look like on a real device. Why would anyone even think about it?",
                            "color": "#ff0000"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#ff0000"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#000000",
                            "background_color": "#ffed00"
                        },
                        "lang": "ja",
                        "footer": "<body></body>"
                    }
                }
                """.trimIndent(),
            """ {
                    "error": "no-screens"
                }
            """.trimIndent(),
            """
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#d5d9e1",
                        "backgroundImage": {
                            "base64": "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",
                            "url": "https://app.subgrow.net/api/offer/background_image/4590eb55-2ee0-49fc-a947-4869af383b5a"
                        },
                        "image": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAC4jAAAuIwF4pT92AAAE1ElEQVQ4jWWUe2xTVRjAv7sqJBgTQ4LEDdQIxohi0OAjY21vWycBDGEJM0MeKjgSBAcTZWMbjGzTDdjAAEOxvbUgr2UygWywsfbcrt0Gg7mHD0AMcbvdYA96elvKkLY7n957yyv88eXcc5Pvd37nfOd8AADAEwomkaojT2gCL9KE+PcjYW4YgsyMI48VJOZD/tSiGQVTS8zZkAN7+x2wubhUgxkJhTlNaoJOTdTgiTyh6Tyhm3lCt/OEbuEJ/VBfe/2FDwo9cHrh7nEbJhV2Zk3LySjdv+uTkrIds8ut+0CFGVwUTIqZZjGFJ9TBEyrzhKJJDNwPQjHVHfiXPxe2rppYIG56vqih9fKvy4tzy6uLKypKvtn5bTLoXf4HYYt5QsO8SJEnKiRmEgNRI6GRFBeNml3+2KskiHNLzuLhzMMoXwsNybdCmM3n4UrD2trt1sp1YPQEdfpzt4B3+VfcNeIJjZjEADMQykwiZanuAFvXGWJ6p5+NO+Bj5K9AFBFjiIi3R+7ENlq24JKXVl6scHyXC4aWm2BoDSerMC1iZg3M5nkC7KO2IG7oDGF+VxDT20LsyIDCQtZ3eRBPF9aNbpuxFdck5QytX5q/p6xyVyHkwRKw1F5v4d0y8k1y1OyR0eQNslfqhlnWBRnXtAdxZ08EjwcRJZ+Mf9ZfxJ+WH8LC5wrZqjd2jGZsJDi3duCPXG/T5K1FxVNB3xV7L/N9Gy5dKMT45hBLrpLYgop2lnP5Nv44zNATZHjpt2tYl3cS675uQO8uN66eVoYvb2zBSTWDbHKDHH2t/ga+fSawKK26A8DQHKpcPduKa8d+Gl00axvu3tPC+gbDGBkOYZfjLB5J+wFzkzZhXTnBcF8Ay9LsOL6oA6FqmIG1F2FfTxRsEo5xSDVwQAYwtN/2pH/RiAWJG2KukhPsak0HHss+hnmG3Zhp3IupGdVY7+lVzg23LxDwqa9aEY4Ooc7agwl2iXF2X4yz+xAE6RJYe8fCO6LcnX5mEGtO/x3L/76DzV/vRMuOTpx9vA+nN/px8z9qEbBy2UEcv74ZoWoIExQzuw85QQFKowqQE6R+EKSJsLA50FV+ZQTnt4VjM4nMjOdH0NIWxpnum7iiWy0oHsz6Gcdne5Vtou4+TAWCoAFBkHwgSBNgnifgtIgUUxr9MQuhzOIcxlnuEUx3SkhdAp78bC9OWNcS3+ZDMOQEH+MEKQaC+q97jO0SBykuWmokFM1iIGomftSLIWY6cQV/z5qO9W++hc987nkYFgeCZoec3RcFuzp3gCCB8uxmmkTlIlPGu/wspe0O8zYeZq2LP8akL88jVN1Ana0HVYsHYJzdpwCZUhQVLEhz7wKVN1xtFikmO2lk56mr2FTawF7M62RwaAB1tl4VBo/ClAUicZgX7D6AugvxXnhm+FmjW/annhrAZcVNEX15O+oO9SNn61WqqES8opqVBpOi8WJEObv0OtgkAEFK0HqgS7WcZSR0RN8aRsPZcOSJ/b5R5cIqEBUmaFZxw0j83JRYwCl2gqRTofG2pTVWQmfwTn/3u4TihKPXEKxqspaoWKqG8bkgXeUEyaiemwLTRgCLKINJDNyDPl3V//gcr7x2yi+DvfcM7co27xkOgCBt0tmlJzl7HObwAafY/R//AeO0262LK5dMAAAAAElFTkSuQmCC",
                            "url": "https://app.subgrow.net/api/offer/image/4590eb55-2ee0-49fc-a947-4869af383b5a"
                        },
                        "title": {
                            "text": "本日限り！翌月に通常価格の半額でサービスをお使いいただけるチャンスです。",
                            "color": "#000000"
                        },
                        "subtitle": {
                            "text": "",
                            "color": "#000000"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#000000"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<style> p {text-align: center;} a {color: rgb(251, 161, 43); text-decoration: none;}</style><body><p><a href='https://backtosub.jp/tos_ja/' target='_blank''>利用規約</a> · <a href='https://backtosub.jp/privacy_ja/' target='_blank''>プライバシーに関する方針</a></p></body>"
                    }
                }
            """.trimIndent(),
            """ {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#d5d9e1",
                        "backgroundImage": {
                            "base64": "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",
                            "url": "https://app.subgrow.net/api/offer/background_image/ccd7f5a6-bce0-4ae9-8eae-c1b8ad16b474"
                        },
                        "image": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAC4jAAAuIwF4pT92AAAE1ElEQVQ4jWWUe2xTVRjAv7sqJBgTQ4LEDdQIxohi0OAjY21vWycBDGEJM0MeKjgSBAcTZWMbjGzTDdjAAEOxvbUgr2UygWywsfbcrt0Gg7mHD0AMcbvdYA96elvKkLY7n957yyv88eXcc5Pvd37nfOd8AADAEwomkaojT2gCL9KE+PcjYW4YgsyMI48VJOZD/tSiGQVTS8zZkAN7+x2wubhUgxkJhTlNaoJOTdTgiTyh6Tyhm3lCt/OEbuEJ/VBfe/2FDwo9cHrh7nEbJhV2Zk3LySjdv+uTkrIds8ut+0CFGVwUTIqZZjGFJ9TBEyrzhKJJDNwPQjHVHfiXPxe2rppYIG56vqih9fKvy4tzy6uLKypKvtn5bTLoXf4HYYt5QsO8SJEnKiRmEgNRI6GRFBeNml3+2KskiHNLzuLhzMMoXwsNybdCmM3n4UrD2trt1sp1YPQEdfpzt4B3+VfcNeIJjZjEADMQykwiZanuAFvXGWJ6p5+NO+Bj5K9AFBFjiIi3R+7ENlq24JKXVl6scHyXC4aWm2BoDSerMC1iZg3M5nkC7KO2IG7oDGF+VxDT20LsyIDCQtZ3eRBPF9aNbpuxFdck5QytX5q/p6xyVyHkwRKw1F5v4d0y8k1y1OyR0eQNslfqhlnWBRnXtAdxZ08EjwcRJZ+Mf9ZfxJ+WH8LC5wrZqjd2jGZsJDi3duCPXG/T5K1FxVNB3xV7L/N9Gy5dKMT45hBLrpLYgop2lnP5Nv44zNATZHjpt2tYl3cS675uQO8uN66eVoYvb2zBSTWDbHKDHH2t/ga+fSawKK26A8DQHKpcPduKa8d+Gl00axvu3tPC+gbDGBkOYZfjLB5J+wFzkzZhXTnBcF8Ay9LsOL6oA6FqmIG1F2FfTxRsEo5xSDVwQAYwtN/2pH/RiAWJG2KukhPsak0HHss+hnmG3Zhp3IupGdVY7+lVzg23LxDwqa9aEY4Ooc7agwl2iXF2X4yz+xAE6RJYe8fCO6LcnX5mEGtO/x3L/76DzV/vRMuOTpx9vA+nN/px8z9qEbBy2UEcv74ZoWoIExQzuw85QQFKowqQE6R+EKSJsLA50FV+ZQTnt4VjM4nMjOdH0NIWxpnum7iiWy0oHsz6Gcdne5Vtou4+TAWCoAFBkHwgSBNgnifgtIgUUxr9MQuhzOIcxlnuEUx3SkhdAp78bC9OWNcS3+ZDMOQEH+MEKQaC+q97jO0SBykuWmokFM1iIGomftSLIWY6cQV/z5qO9W++hc987nkYFgeCZoec3RcFuzp3gCCB8uxmmkTlIlPGu/wspe0O8zYeZq2LP8akL88jVN1Ana0HVYsHYJzdpwCZUhQVLEhz7wKVN1xtFikmO2lk56mr2FTawF7M62RwaAB1tl4VBo/ClAUicZgX7D6AugvxXnhm+FmjW/annhrAZcVNEX15O+oO9SNn61WqqES8opqVBpOi8WJEObv0OtgkAEFK0HqgS7WcZSR0RN8aRsPZcOSJ/b5R5cIqEBUmaFZxw0j83JRYwCl2gqRTofG2pTVWQmfwTn/3u4TihKPXEKxqspaoWKqG8bkgXeUEyaiemwLTRgCLKINJDNyDPl3V//gcr7x2yi+DvfcM7co27xkOgCBt0tmlJzl7HObwAafY/R//AeO0262LK5dMAAAAAElFTkSuQmCC",
                            "url": "https://app.subgrow.net/api/offer/image/ccd7f5a6-bce0-4ae9-8eae-c1b8ad16b474"
                        },
                        "title": {
                            "text": "本日限り！翌月に通常価格の半額でサービスをお使いいただけるチャンスです。",
                            "color": "#000000"
                        },
                        "subtitle": {
                            "text": "Limited time only!!",
                            "color": "#000000"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#000000"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<style> p {text-align: center;} a {color: rgb(251, 161, 43); text-decoration: none;}</style><body><p><a href='https://backtosub.jp/tos_ja/' target='_blank''>利用規約</a> · <a href='https://backtosub.jp/privacy_ja/' target='_blank''>プライバシーに関する方針</a></p></body>"
                    }
            }""".trimIndent(),
            """{
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#d5d9e1",
                        "backgroundImage": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAACgAAABWCAYAAAC91tTcAAAACXBIWXMAABYlAAAWJQFJUiTwAAAI+ElEQVRogd2ZDVRVVRbHd5bamprSdKk5CWKFCoOuMj/LAa0eohgIQmXapImoRbpysrGWlZZmjuVHRuakmYpZmY1SWk72paMVE4qgICJgZKkoDx5fj3fvu79Z9973eI8PDV3NrDv91zrrnnvfPmf/z3+fs8+59wkWh2BxCBaHYHEIFodgcQgWh2BxCBaHYHEIFodgcQgWh2BxCBaHYHEIFodgcQgWh2BxCBaHYHEIFodgcQgWh2BxCBaHYHEIFofw/0hQ0zSj+Ncbl+ba6DB+d7vR3Krn2riYz+ttm+nrggQbOFJV33O9Y7/f/B1oXuctcNicnxYTbOzYqOul2tHExiTtbnjvqasn8lHyMlGL81BLjqP+VIz6wzHUwiMoud/jPlXSInJNCDYm5/r+S6oWJOOYMpyaNQvQFJfXyFBX87RRz5xELT5q1ouPUh4fgj3yD9hHBlAecxP2Ud2x33Mj9uggyoZ3pGJKBFp15aUpqIdSR83ahZQn9kE5lo3z082UDboS5440005RzOuxLKofH82P4wdyJioQZe/HKAU5lA29huoVf8W5fR2O6TajnSNlJDVrX8T5wWrKE8NwnzlZH4VLIlg1/2Fj1HpY6j7fiv2uzjjT3/ZIplKVe5Di+wdQcMf1fDasD4VD2uNYPMNQsCy8Ha7MPYbCNW++YA543UvGYPXpUvHgwEsj6C+5VltNTepcKmcn4Jh2N9VLZtbbqEcPUjkqiFJbAAXjgqlafC0Vi9rj2L8Hd9ERQ8GKCQOoGN8f+92djfZ22/WUjw01Ql4eG4y7/KzH30Uq6H/1dqCPUinIRvmx0HhWeSST7Q/HUrqwI3zYBvVdgW+jTXvVRW3aUux3d6Fq/mSqlz1B1fNJVL/yuBH2mtefoe6r7ZeYZhrkP5OYPxSXuUhm7C9C5u5ibXoC6ORWC+r28PpFoxz+jtr3X7+gY39fLSfYhGTD5Kx6+lty4AQybS2L1k3ElT2T/L3P4Tq+0dempsrXV4OErZqrXy+Xkgd/iayqKOiaamcryHrJxuE3rmZW2hKe3bYC9ehqM2d6/PknbqMPz1Vx6wPVcDcq3ucet/V+xddjY+Xc5rN6rr6Rug/uh1Wh8JFQtasvfB4ABXMM8njb+fXREqV8mmhNFTQ6qzdQfCvLc3V75uLG9D1ETZjGj+n9KEwfRM77d5G/PZp+Y2awastej61XMe9+q4fWzJulTpXZh0qZebCURXllPJV91ijzj5xjYsZp3i0xk7euaBMFNbcLTa0x63qpLDauLs/C+FfmEaRHJNIpmlGjgnHuCqaqsoyzH4VwTa/bkK6R7MnINmxdimL24Sg27k16tbxRcA7ZkEebDwqYm3OWSRmnmZ55xqjLe8fokl6Ew+URxZ+gUVUq0LIeQcucCvZv0A5MR/thQ73Uc15+G7lpJNfdlogEjWXbok5Q8RrfvfVHrr0lDrk5mqdfWe+LTdE6tKwZULYPV0YS5M0gNf8UsjGfoB1FDPm8hLBdJ+i76wSDd/+AvHWYrumFVDQhWD/nTO3c+5NR0wS+CED5og8ZWYfJyivikedSCYyYSLeh45FuY5hwf184EMisKSF0GDKV7hF/JmX+Kg7mFpF5KBvX7p5o6cG4/t4K9fvHDGfldSp3flmCbMojcd9JJmecIimzlCdyK0g+UsnmkzUXDrHxY04qrmWCukVgh7BpVRLS8z469E8k2JZM7xHJSMBoBtoiKN3ciuv6DOeG8Cn0Hf0o7fuNRXqNY+uaJGMBKesF5zzBlbfaE2aVlUVVrPnZc+gwIuciP+84n3zyNeWl55osFDPE/iu45hTu/FfRsh/FkfkkybOfQtqHI53CuSw4moDwh5CgGILvuIukh25FAmLpNPA+ruo7Fuk4FOk4nJQ5c6g8MBstOwXl0Cp97zFnoUvh38dK2P3FNzyzPI3Iyc9xQ/gk2obFI9cO4ZlXN5mc/fJks1udd6Hos2HfgWPMX5nGhL8sZt6KDfQaMRXpMZK2oTG0DolFgqLoFZnMwtc38cCsv/H8a++wP+s4+pHDq1PaR3tJeOxFQqOm0+6WBCTQhlw/HAmwITeO9PQzgq279pk6+x2Upfkju2KGXDMD449bYlKQHiNoExpL29BYpLuN28b4DhK+EZr0nNVV/C4sDukyzCCjR0F6xSOh8UZ7vZ9WPUfTrt+9FJacMqeZ3xZ73gOrt+h5ray0hNO571C89yk6DBiHdI+nVe84Lu8dh3SPo9Pg8ZzOXIKz5Ctqa+socypkORT+kfcTKalbaRNmkjEG1GsM9w0I597+4UjPWK7UnwXaGJQwq4H/8xJsrGi1003Jx3dSkyZUbBAeSLiJ0NsH8vvQYVwdMozuA25n2v1d2bn0MqI2LmXw3p/pvL2YVluOI89+iEQ8wuU9R9O6d4xBKCgsCuK6sfhP/ZGecVytqxtoMzKAd/7548IEPTnSca6Y0tz1nP72SexfJ3Dyk0i+Wj+Kz9bFULhzDDUZk9i9cxVdU9YjCz9FXt5Nm4iptA6Lp83QyVwRHE3rkBhahcTSIeweJgweRkDfaOTm0UbY5bo7eHfHnnqCLVLQIGkyrb/XZ6RL05NFQxunx0R12Fnw2mauSl6OPL6e1onP0nbgg7QNieUKXUGdTEAk0sWGdIuk3a2J9I6aRtLTr2KvaLrNtVjB+v1UXzR+hwG3d8/VVNyqb0Hl5xYQP28NMuttJGQs0jmcy3vHEBgxCdvEucxbvoFt/9xPftHJZt8KWxTixo3O9wKvNToFKYpP3y3bdjPrxTd5871P+eZgHnaH55zYCKrqe31t9jTza0DzI6o7dJ/ndKWnED3P6XNNr//SV4tf9duM1viAq/rIeFVqTvX/+ccjrZlp0XgAv+2vW1aCYHEIFodgcQgWh2BxCBaHYHEIFodgcQgWh2BxCBaHYHEIFodgcQgWh2BxCBaHYHEIFofwWyGo+b3b6l8ELqVoF/mnzkURvNiOz4f/2ou7t+O6ujpycnI4dOgQ2dnZLSq6rd6mtrb2okleNMHKykpSU1NZtmwZK1asYPny5Rcsuo1uu3LlSs6da/o3wy8R/A8owvy0irhCHwAAAABJRU5ErkJggg==",
                            "url": "https://app.subgrow.net/api/offer/background_image/82fb3638-f4b2-4230-883c-e9509ba3cfed"
                        },
                        "image": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAC4jAAAuIwF4pT92AAAE1ElEQVQ4jWWUe2xTVRjAv7sqJBgTQ4LEDdQIxohi0OAjY21vWycBDGEJM0MeKjgSBAcTZWMbjGzTDdjAAEOxvbUgr2UygWywsfbcrt0Gg7mHD0AMcbvdYA96elvKkLY7n957yyv88eXcc5Pvd37nfOd8AADAEwomkaojT2gCL9KE+PcjYW4YgsyMI48VJOZD/tSiGQVTS8zZkAN7+x2wubhUgxkJhTlNaoJOTdTgiTyh6Tyhm3lCt/OEbuEJ/VBfe/2FDwo9cHrh7nEbJhV2Zk3LySjdv+uTkrIds8ut+0CFGVwUTIqZZjGFJ9TBEyrzhKJJDNwPQjHVHfiXPxe2rppYIG56vqih9fKvy4tzy6uLKypKvtn5bTLoXf4HYYt5QsO8SJEnKiRmEgNRI6GRFBeNml3+2KskiHNLzuLhzMMoXwsNybdCmM3n4UrD2trt1sp1YPQEdfpzt4B3+VfcNeIJjZjEADMQykwiZanuAFvXGWJ6p5+NO+Bj5K9AFBFjiIi3R+7ENlq24JKXVl6scHyXC4aWm2BoDSerMC1iZg3M5nkC7KO2IG7oDGF+VxDT20LsyIDCQtZ3eRBPF9aNbpuxFdck5QytX5q/p6xyVyHkwRKw1F5v4d0y8k1y1OyR0eQNslfqhlnWBRnXtAdxZ08EjwcRJZ+Mf9ZfxJ+WH8LC5wrZqjd2jGZsJDi3duCPXG/T5K1FxVNB3xV7L/N9Gy5dKMT45hBLrpLYgop2lnP5Nv44zNATZHjpt2tYl3cS675uQO8uN66eVoYvb2zBSTWDbHKDHH2t/ga+fSawKK26A8DQHKpcPduKa8d+Gl00axvu3tPC+gbDGBkOYZfjLB5J+wFzkzZhXTnBcF8Ay9LsOL6oA6FqmIG1F2FfTxRsEo5xSDVwQAYwtN/2pH/RiAWJG2KukhPsak0HHss+hnmG3Zhp3IupGdVY7+lVzg23LxDwqa9aEY4Ooc7agwl2iXF2X4yz+xAE6RJYe8fCO6LcnX5mEGtO/x3L/76DzV/vRMuOTpx9vA+nN/px8z9qEbBy2UEcv74ZoWoIExQzuw85QQFKowqQE6R+EKSJsLA50FV+ZQTnt4VjM4nMjOdH0NIWxpnum7iiWy0oHsz6Gcdne5Vtou4+TAWCoAFBkHwgSBNgnifgtIgUUxr9MQuhzOIcxlnuEUx3SkhdAp78bC9OWNcS3+ZDMOQEH+MEKQaC+q97jO0SBykuWmokFM1iIGomftSLIWY6cQV/z5qO9W++hc987nkYFgeCZoec3RcFuzp3gCCB8uxmmkTlIlPGu/wspe0O8zYeZq2LP8akL88jVN1Ana0HVYsHYJzdpwCZUhQVLEhz7wKVN1xtFikmO2lk56mr2FTawF7M62RwaAB1tl4VBo/ClAUicZgX7D6AugvxXnhm+FmjW/annhrAZcVNEX15O+oO9SNn61WqqES8opqVBpOi8WJEObv0OtgkAEFK0HqgS7WcZSR0RN8aRsPZcOSJ/b5R5cIqEBUmaFZxw0j83JRYwCl2gqRTofG2pTVWQmfwTn/3u4TihKPXEKxqspaoWKqG8bkgXeUEyaiemwLTRgCLKINJDNyDPl3V//gcr7x2yi+DvfcM7co27xkOgCBt0tmlJzl7HObwAafY/R//AeO0262LK5dMAAAAAElFTkSuQmCC",
                            "url": "https://app.subgrow.net/api/offer/image/82fb3638-f4b2-4230-883c-e9509ba3cfed"
                        },
                        "title": {
                            "text": "",
                            "color": "#000000"
                        },
                        "subtitle": {
                            "text": "Limited time only!!",
                            "color": "#000000"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#000000"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<style> p {text-align: center;} a {color: rgb(251, 161, 43); text-decoration: none;}</style><body><p><a href='https://backtosub.jp/tos_ja/' target='_blank''>利用規約</a> · <a href='https://backtosub.jp/privacy_ja/' target='_blank''>プライバシーに関する方針</a></p></body>"
                    }
            }""".trimIndent(),
            """{
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#000000",
                        "backgroundImage": null,
                        "image": {
                            "base64": "iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAC4jAAAuIwF4pT92AAAE1ElEQVQ4jWWUe2xTVRjAv7sqJBgTQ4LEDdQIxohi0OAjY21vWycBDGEJM0MeKjgSBAcTZWMbjGzTDdjAAEOxvbUgr2UygWywsfbcrt0Gg7mHD0AMcbvdYA96elvKkLY7n957yyv88eXcc5Pvd37nfOd8AADAEwomkaojT2gCL9KE+PcjYW4YgsyMI48VJOZD/tSiGQVTS8zZkAN7+x2wubhUgxkJhTlNaoJOTdTgiTyh6Tyhm3lCt/OEbuEJ/VBfe/2FDwo9cHrh7nEbJhV2Zk3LySjdv+uTkrIds8ut+0CFGVwUTIqZZjGFJ9TBEyrzhKJJDNwPQjHVHfiXPxe2rppYIG56vqih9fKvy4tzy6uLKypKvtn5bTLoXf4HYYt5QsO8SJEnKiRmEgNRI6GRFBeNml3+2KskiHNLzuLhzMMoXwsNybdCmM3n4UrD2trt1sp1YPQEdfpzt4B3+VfcNeIJjZjEADMQykwiZanuAFvXGWJ6p5+NO+Bj5K9AFBFjiIi3R+7ENlq24JKXVl6scHyXC4aWm2BoDSerMC1iZg3M5nkC7KO2IG7oDGF+VxDT20LsyIDCQtZ3eRBPF9aNbpuxFdck5QytX5q/p6xyVyHkwRKw1F5v4d0y8k1y1OyR0eQNslfqhlnWBRnXtAdxZ08EjwcRJZ+Mf9ZfxJ+WH8LC5wrZqjd2jGZsJDi3duCPXG/T5K1FxVNB3xV7L/N9Gy5dKMT45hBLrpLYgop2lnP5Nv44zNATZHjpt2tYl3cS675uQO8uN66eVoYvb2zBSTWDbHKDHH2t/ga+fSawKK26A8DQHKpcPduKa8d+Gl00axvu3tPC+gbDGBkOYZfjLB5J+wFzkzZhXTnBcF8Ay9LsOL6oA6FqmIG1F2FfTxRsEo5xSDVwQAYwtN/2pH/RiAWJG2KukhPsak0HHss+hnmG3Zhp3IupGdVY7+lVzg23LxDwqa9aEY4Ooc7agwl2iXF2X4yz+xAE6RJYe8fCO6LcnX5mEGtO/x3L/76DzV/vRMuOTpx9vA+nN/px8z9qEbBy2UEcv74ZoWoIExQzuw85QQFKowqQE6R+EKSJsLA50FV+ZQTnt4VjM4nMjOdH0NIWxpnum7iiWy0oHsz6Gcdne5Vtou4+TAWCoAFBkHwgSBNgnifgtIgUUxr9MQuhzOIcxlnuEUx3SkhdAp78bC9OWNcS3+ZDMOQEH+MEKQaC+q97jO0SBykuWmokFM1iIGomftSLIWY6cQV/z5qO9W++hc987nkYFgeCZoec3RcFuzp3gCCB8uxmmkTlIlPGu/wspe0O8zYeZq2LP8akL88jVN1Ana0HVYsHYJzdpwCZUhQVLEhz7wKVN1xtFikmO2lk56mr2FTawF7M62RwaAB1tl4VBo/ClAUicZgX7D6AugvxXnhm+FmjW/annhrAZcVNEX15O+oO9SNn61WqqES8opqVBpOi8WJEObv0OtgkAEFK0HqgS7WcZSR0RN8aRsPZcOSJ/b5R5cIqEBUmaFZxw0j83JRYwCl2gqRTofG2pTVWQmfwTn/3u4TihKPXEKxqspaoWKqG8bkgXeUEyaiemwLTRgCLKINJDNyDPl3V//gcr7x2yi+DvfcM7co27xkOgCBt0tmlJzl7HObwAafY/R//AeO0262LK5dMAAAAAElFTkSuQmCC",
                            "url": "https://app.subgrow.net/api/offer/image/aa82f52d-b159-46c5-9896-9afe0512f4b9"
                        },
                        "title": {
                            "text": "Save 0.99${'$'} per month!",
                            "color": "#58a4eb"
                        },
                        "subtitle": {
                            "text": "Limited time only!!",
                            "color": "#58a4eb"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#58a4eb"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<style> p {text-align: center;} a {color: rgb(251, 161, 43); text-decoration: none;}</style><body><p><a href='https://backtosub.jp/tos_ja/' target='_blank'>利用規約</a></p></body>"
                    }
                }
            """.trimIndent(),
            """{
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#000000",
                        "backgroundImage": null,
                        "image": null,
                        "title": {
                            "text": "Save 0.99${'$'} per month!",
                            "color": "#58a4eb"
                        },
                        "subtitle": {
                            "text": "Limited time only!!",
                            "color": "#58a4eb"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#58a4eb"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<body></body>"
                    }
            }""".trimIndent(),
            """{
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#000000",
                        "backgroundImage": null,
                        "image": null,
                        "title": {
                            "text": "",
                            "color": "#58a4eb"
                        },
                        "subtitle": {
                            "text": "",
                            "color": "#58a4eb"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#58a4eb"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#ffffff",
                            "background_color": "#3f51b5"
                        },
                        "lang": "ja",
                        "footer": "<body></body>"
                    }
            }""".trimIndent(),
            """
                {
                    "productId": "com.b2s.subscription.oneMonth",
                    "promotionOfferId": "com.b2s.subscription.onemonth.50off",
                    "pushNotificationText": "あなただけの特別割引です！期間限定でサブスクリプション価格がお安くなります。",
                    "screen": {
                        "backgroundColor": "#000000",
                        "backgroundImage": {
                            "base64": "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",
                            "url": "https://app.subgrow.net/api/offer/background_image/15c57289-1aaf-4ee0-a85e-56e98337c62c"
                        },
                        "image": null,
                        "title": {
                            "text": "This is definitely most beautiful offer screen out there. Period.",
                            "color": "#ff0000"
                        },
                        "subtitle": {
                            "text": "It's the best color matching we could find! And the text is short and brief. And definitely makes total sense. Why would it be here, anyway? It's not like we're trying to test how long text would look like on a real device. Why would anyone even think about it?",
                            "color": "#ff0000"
                        },
                        "offer": {
                            "text": "次の 1 か月の月額 ¥50（50％を節約）。次に、¥100 /月。",
                            "color": "#ff0000"
                        },
                        "promotion_button": {
                            "text": "再購読",
                            "text_color": "#000000",
                            "background_color": "#ffed00"
                        },
                        "lang": "ja",
                        "footer": "<body></body>"
                    }
                }
            """.trimIndent(),
            """     {
                        "error": "no-screens"
                    }
                """.trimIndent(),
    ).map { Token2Parser.parse(it) }
}

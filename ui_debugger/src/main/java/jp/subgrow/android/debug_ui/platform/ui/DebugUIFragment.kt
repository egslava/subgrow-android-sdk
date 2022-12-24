package jp.subgrow.android.debug_ui.platform.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import jp.subgrow.android.sdk.data.placeholder.Token2
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams
import jp.subgrow.ui_debugger.R
import jp.subgrow.ui_debugger.databinding.FragmentDebuguiBinding

class DebugUIFragment : Fragment() {

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

    private var _binding: FragmentDebuguiBinding? =
        null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val debugUiViewModel = ViewModelProvider(this)
            .get(DebugUIViewModel::class.java)

        _binding = FragmentDebuguiBinding
            .inflate(inflater, container, false)

        val root: View = binding.root


        val offer_params_1 = OfferParams(
            img = "https://static.vecteezy.com/system/resources/previews/001/189/136/original/christmas-decoration-star-png.png",
            title = "Get 100% off",
            subtitle = "and one more free month.",
            pricing_text =
            "1 month for free. Then ¥10/month",
            title_color = Color.WHITE,
            subtitle_color = Color.WHITE,
            pricing_text_color = Color.WHITE,
            button_color = Color.RED,
            button_text_color = Color.WHITE,
            background_color = Color.BLACK,
            background_image = "https://static.vecteezy.com/system/resources/previews/002/402/683/original/night-starry-sky-and-pink-clouds-sunrise-free-vector.jpg",
            push_notification_text = "You've got a " +
                "personal offer!",
            footer = footer("#ffffff"),
        )

        binding.btnNavToOffer1.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_debug_ui_to_navigation_offer,
                bundleOf("offer_arg_1" to
                    offer_params_1)
            )
        }


        val offer_params_2 = OfferParams(
            img = "https://creazilla-store.fra1" +
                ".digitaloceanspaces.com/cliparts/35397/baby-boy-clipart-md.png",
            title = "Important! Get 100% off for our" +
                " premium functions on next month.",
            subtitle = "Thank you for using our " +
                "service, we want to offer you one " +
                "more free month.",
            pricing_text =
            "1 month for free. Then ¥20/month",
            title_color = Color.parseColor("#FC4D22"),
            subtitle_color = Color.parseColor("#FC4D22"),
            button_color = Color.parseColor("#4054B2"),
            background_color = Color.parseColor("#FFFFFF"),
            background_image = "",
            push_notification_text = "You've got a " +
                "personal offer!",
            footer = footer("#000000")
        )
        binding.btnNavToOffer2.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_debug_ui_to_navigation_offer,
                bundleOf("offer_arg_1" to offer_params_2)
            )
        }

        var i = 0
        for (offer in Token2.JSONs) {
            i += 1
            val _offer = offer ?: continue

            val btn = Button(context)
            btn.text = "Test offer $i: ${_offer.title}"
            btn.setOnClickListener {
                findNavController().navigate(
                    R.id.action_navigation_debug_ui_to_navigation_offer,
                    bundleOf("offer_arg_1" to _offer)
                )
            }
            binding.linearJsonOffers.addView(btn)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

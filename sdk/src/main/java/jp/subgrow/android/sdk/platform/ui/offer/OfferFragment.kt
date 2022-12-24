package jp.subgrow.android.sdk.platform.ui.offer

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import jp.subgrow.android.databinding.FragmentOfferBinding

class OfferFragment : Fragment() {

    private var _binding: FragmentOfferBinding? =
        null

    private val binding get() = _binding!!
    val vm by viewModels<OfferViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentOfferBinding.inflate(
            inflater, container, false)

        val root: View = binding.root

        val offer = arguments
            ?.getParcelable<OfferParams>("offer_arg_1")
            ?: OfferParams()
        _show_offer(offer)
        vm.set_offer(offer)
        vm.offer_params
            .observe(viewLifecycleOwner) { offer ->
                if (offer == null)
                    return@observe
                _show_offer(offer)
            }

        vm.should_close.observe(viewLifecycleOwner) {
            if (it) findNavController().popBackStack()
        }
        return root
    }

    private fun _show_offer(offer: OfferParams) {
        if (offer.background_image.isNotBlank()) {
            binding.fragmentOfferBgImg.load(
                offer.background_image
            )
        }

        if (offer.background_color != null) {
            binding
                .fragmentOfferBgColor
                .setBackgroundColor(offer.background_color)
        }

        _img(binding.fragmentOfferImg, offer.img)
        _txt(binding.fragmentOfferTitle, offer.title)
        _txt(binding.fragmentOfferText,
            offer.subtitle)
        _txt(binding.fragmentOfferPricing,
            offer.pricing_text)

        binding.fragmentOfferTitle
            .setTextColor(offer.title_color)
        binding.fragmentOfferText
            .setTextColor(offer.subtitle_color)
        binding.fragmentOfferPricing
            .setTextColor(offer.pricing_text_color)


        binding
            .fragmentOfferResubscribeBtn
            .setBackgroundColor(offer.button_color)
        binding.fragmentOfferResubscribeBtn
            .setTextColor(offer.button_text_color)
        binding.fragmentOfferResubscribeBtn.text =
            offer.button_text

        binding
            .fragmentOfferBgColor
            .setBackgroundColor(
                offer.background_color
            )

        _img(binding.fragmentOfferBgImg,
            offer.background_image)


        binding.fragmentOfferWebBottom.also {
            it.loadDataWithBaseURL(
                null,
                offer.footer,
                "text/html",
                "utf-8",
                null,
            )
            it.setBackgroundColor(Color.TRANSPARENT)
        }

        binding.fragmentOfferResubscribeBtn
            .setOnClickListener {
                vm.on_user_clicked_accept_offer(
                        requireActivity()
                    )
            }

    }

    private fun _img(img: ImageView, url: String) {
        if (url.isNotBlank()) {
            img.isVisible = true
            img.load(url)
        } else {
            img.isGone = true
        }
    }

    private fun _txt(view: TextView, text: String) {
        if (text.isNotBlank()) {
            view.isVisible = true
            view.text = text
        } else {
            view.isGone = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

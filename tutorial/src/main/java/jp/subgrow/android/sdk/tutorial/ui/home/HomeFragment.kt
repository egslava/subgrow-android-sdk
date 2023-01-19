package jp.subgrow.android.sdk.tutorial.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.fragment.app.ListFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import jp.subgrow.android.sdk.Subgrow
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubscriptionsEffect
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubscriptionsEffect.GoToOffer
import jp.subgrow.android.sdk.tutorial.R

class HomeFragment : ListFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.playSubscriptions.observe(viewLifecycleOwner) {
            Log.d("Subscriptions", "have been loaded")
            listAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it.map { it.productId }
            )
        }

        listView.setOnItemClickListener { _, _, index, l ->
            val subs = homeViewModel.playSubscriptions.value ?: return@setOnItemClickListener
            Subgrow.buy(requireActivity(), subs[index].token)
        }

        homeViewModel.offers.observe(viewLifecycleOwner) {
            when(it) {
                is GoToOffer -> findNavController().navigate(
                    R.id.action_navigation_home_to_navigation_offer,
                    bundleOf("offer_arg_1" to it.offer)
                )
            }
        }
    }
}

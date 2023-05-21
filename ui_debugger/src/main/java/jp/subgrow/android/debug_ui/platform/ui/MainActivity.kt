package jp.subgrow.android.debug_ui.platform.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import jp.subgrow.android.sdk.Subgrow
import jp.subgrow.ui_debugger.R
import jp.subgrow.ui_debugger.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Subgrow.gotPushViaIntent(this)
        firebaseAnalytics = Firebase.analytics

        binding =
            ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.navView

        val navController = findNavController(
            R.id.nav_host_fragment_activity_main,
        )

        navView.setupWithNavController(navController)
    }
}

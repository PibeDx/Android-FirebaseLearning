package com.example.firebaselearning.presentation.feature.menu.view.ui.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firebaselearning.databinding.FragmentNotificationsBinding
import com.example.firebaselearning.presentation.core.util.NotificationCenter
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    private var countNotifications = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNotifications.text = it
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Firebase.analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "NotificationsFragment")
        }

        NotificationCenter.addObserver(
            requireContext(),
            NotificationCenter.NotificationType.Default,
            broadcastReceiver
        )
    }

    override fun onDestroy() {
        NotificationCenter.removeObserver(requireContext(), broadcastReceiver)
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            countNotifications++
            binding.textCount.text = countNotifications.toString()

            val message = intent?.getStringExtra("message")
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
}
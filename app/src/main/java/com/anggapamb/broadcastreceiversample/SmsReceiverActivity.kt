package com.anggapamb.broadcastreceiversample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anggapamb.broadcastreceiversample.databinding.ActivitySmsReceiverBinding

class SmsReceiverActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySmsReceiverBinding

    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = getString(R.string.incoming_message)

        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)
        binding.tvFrom.text = getString(R.string.from, senderNo)
        binding.tvMessage.text = senderMessage

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}
package no.nordicsemi.android.uart.repository

import android.bluetooth.BluetoothDevice
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import no.nordicsemi.android.service.DEVICE_DATA
import no.nordicsemi.android.service.NotificationService
import no.nordicsemi.android.uart.data.UARTRepository
import javax.inject.Inject

@AndroidEntryPoint
internal class UARTService : NotificationService() {

    @Inject
    lateinit var repository: UARTRepository

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        val device = intent!!.getParcelableExtra<BluetoothDevice>(DEVICE_DATA)!!

        repository.start(device, lifecycleScope)

        return START_REDELIVER_INTENT
    }
}

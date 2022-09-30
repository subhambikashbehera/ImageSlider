package com.matm.imageslider

import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

object SocketCalling {

    lateinit var mSocket: Socket

    @Synchronized
    fun setSocket() {
        try {
            mSocket = IO.socket("http://34.93.165.232:8089")
            Log.d("checkDataNew", "setSocket: $mSocket")
        } catch (e: URISyntaxException) {
            Log.d("checkDataNew2", "setSocket: ${e.printStackTrace()}")
            e.printStackTrace()
        }
    }

    @Synchronized
    fun getSocket(): Socket {
        return mSocket
    }

    @Synchronized
    fun establishConnection() {
        val connect = mSocket.connect()
    }

    @Synchronized
    fun closeConnection() {

        mSocket.disconnect()

    }


}
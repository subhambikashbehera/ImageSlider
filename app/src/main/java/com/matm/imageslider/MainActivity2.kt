package com.matm.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.Socket

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


       SocketCalling.setSocket()
       SocketCalling.establishConnection()
       val socket =SocketCalling.getSocket()

        Log.d("checkSocketData", "onCreate: $socket")
        Log.d("checkSocketData", "onCreate: ${socket.isActive}")

        socket.on("xyz"){

            //


        }



    }
}
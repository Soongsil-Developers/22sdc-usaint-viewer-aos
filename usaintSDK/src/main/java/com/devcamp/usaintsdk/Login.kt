package com.devcamp.usaintsdk

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class Login {
    fun loginRequest(id: String, pwd:String) : Int{
        val githubEndpoint = URL("http://15.165.194.15:8080/login/?id=$id&pwd=$pwd")
        val myConnection: HttpsURLConnection = githubEndpoint.openConnection() as HttpsURLConnection

        if (myConnection.responseCode == 200) {//연결 성공
            var str: String = ""
            val tmp: InputStreamReader = InputStreamReader(myConnection.inputStream, "UTF-8")
            val reader: BufferedReader = BufferedReader(tmp)
            val buffer: StringBuffer = StringBuffer()
            while (str != null) {
                str = reader.readLine()
                buffer.append(str)

                val receiveMsg = buffer.toString();
                Log.i("receiveMsg : ", receiveMsg);

                reader.close();
            }

            



        }else{ //연결 실패
            return 400//연결오류
        }

        myConnection.disconnect();
        return 200//로그인 성공
    }


}
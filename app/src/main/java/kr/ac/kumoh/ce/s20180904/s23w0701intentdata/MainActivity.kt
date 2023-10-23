package kr.ac.kumoh.ce.s20180904.s23w0701intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kr.ac.kumoh.ce.s20180904.s23w0701intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object{
        const val KEY_NAME = "animal"
        const val FOX = "fox"
        const val RACCON = "raccon"
    }
    private lateinit var main : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main=ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnA.setOnClickListener(this)
        main.btnB.setOnClickListener(this)
    }

    override fun onClick(v: View?) {    //v : 버튼 머가 눌렸는지.
        var intent=Intent(this, ImageActivity::class.java)
        val value=when(v?.id){
            main.btnA.id -> {
                Toast.makeText(this, "여우", Toast.LENGTH_SHORT).show()
                FOX
            }
            main.btnB.id -> {
                Toast.makeText(this, "너구리", Toast.LENGTH_SHORT).show()
                RACCON
            }
            else -> return
        }
        intent.putExtra(KEY_NAME, value)
        startActivity(intent)

    }

}
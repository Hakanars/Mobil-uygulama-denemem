package com.example.deneme3;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class ArayuzActivity extends AppCompatActivity {
Button duyurbtn,etkinbtn;
Button yemekbtn;
Button hesapbtn,gpsbtn,oyunbtn;
ImageView imageView;
private int[] images = {R.drawable.resim1, R.drawable.resim2, R.drawable.resim3};
private int currentIndex = 0;
private Handler handler;
private Runnable imageSwitcher;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_arayuz);
        etkinbtn=(Button)findViewById(R.id.butto);
        hesapbtn=(Button)findViewById(R.id.button6);
        yemekbtn=(Button)findViewById(R.id.button4);
        oyunbtn=(Button)findViewById(R.id.button5);
        duyurbtn=(Button) findViewById(R.id.imageButton2);
        gpsbtn=(Button)findViewById(R.id.button3);
        oyunbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ArayuzActivity.this,OyunActivity.class);
                startActivity(intent);}});
        gpsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ArayuzActivity.this,GPSActivity.class);
                startActivity(intent);}});
        duyurbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ArayuzActivity.this,DuyuruFragment.class);
                startActivity(intent);}});
        yemekbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ArayuzActivity.this,YemekActivity.class);
                startActivity(intent);}});
        hesapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ArayuzActivity.this,HesapActivity.class);
                startActivity(intent);}});
        etkinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ArayuzActivity.this,EtkinlikActivity.class);
                startActivity(intent);}});
        imageView = findViewById(R.id.imageView);
        handler = new Handler();
        imageSwitcher = new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(images[currentIndex]);
                currentIndex++;
                if (currentIndex >= images.length) {
                    currentIndex = 0;}
                handler.postDelayed(this, 2000);}};//2 saniyeee
        handler.post(imageSwitcher);}
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && imageSwitcher != null) {
            handler.removeCallbacks(imageSwitcher);}}}
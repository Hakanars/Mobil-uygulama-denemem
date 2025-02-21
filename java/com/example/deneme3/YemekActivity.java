package com.example.deneme3;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class YemekActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_yemek);
        listView =(ListView)findViewById(R.id.listView);
        String[] items = {"01.01.2025        Hindi tandır           Revani"
        ,"02.01.2025        Etli Patates           Pilav"
        ,"03.01.2025        Tavuk Sote           Bulgur"
        ,"04.01.2025        Fasulye           Bulgur"
        ,"05.01.2025        Tavuk rosto          Baklava"
        ,"06.01.2025        Karniyarik          Revani"
        ,"07.01.2025        Köfte           Yogurt"
        ,"08.01.2025        Pide           puding"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items);
        listView.setAdapter(adapter);}}
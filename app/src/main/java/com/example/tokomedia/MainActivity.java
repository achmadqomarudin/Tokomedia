package com.example.tokomedia;

import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int total_quantity = 1;
    int total_harga = 1750000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //perintah untuk menambah nilai
    public void increment(View view){
        if(quantity==10){
            Toast.makeText(this,"Maksimal pesan 10 item",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1 ;
        total_quantity = quantity * total_harga;

        display(quantity);
        displayHarga(total_quantity);
    }

    //menampilkan nilai
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }

    //menampilkan harga
    private void displayHarga(int number) {
        TextView quantityTextView = findViewById(R.id.total_harga);
        quantityTextView.setText("Rp." + number);
    }

    //perintah untuk mengurangi nilai
    public void decrement(View view){
        if (quantity <= 1){
            Toast.makeText(this,"Minimal pesan 1 item",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        total_quantity = quantity * total_harga;

        display(quantity);
        displayHarga(total_quantity);
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
            .setMessage("Apakah anda yakin ingin keluar?")
            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //untuk keluar aplikasi
                    finishAffinity();
                }
            })
            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //untuk menghilangkan dialog
                    dialog.dismiss();
                }
            })
            .show();
    }
}

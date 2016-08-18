package com.sutureexpress.dc.supplymanagement;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class SupplyHome extends AppCompatActivity {


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supply_home);

        toolbar = (Toolbar) findViewById(R.id.app_bar_home);
        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_supply_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this,"Sorry, but [" +item.getTitle() +"] isn't yet configured.",Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.app_info) {
            Toast.makeText(this,item.getTitle() + ": v 1.0.1",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void openBoxCount(View view) {
        Intent intent = new Intent(SupplyHome.this, BoxCount.class);
        startActivity(intent);
        finish();
    }

    public void openReceiveSupplies(View view) {
        Intent intent = new Intent(SupplyHome.this, ReceiveSupplies.class);
        startActivity(intent);
        finish();
    }

    public void openSamsClub(View view) {
        Intent intent = new Intent(SupplyHome.this, SamsClub.class);
        startActivity(intent);
        finish();
    }

    public void openDbTest(View view) {
        Intent intent = new Intent(SupplyHome.this, DbTest.class);
        startActivity(intent);
        finish();
    }

    public void openGoogleLogIn(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    public void openFireBox(View view) {
        Intent intent = new Intent(this, FireBox.class);
        startActivity(intent);
        finish();
    }


}

package com.sutureexpress.dc.supplymanagement;

import android.app.Activity;
import android.os.Bundle;

public class DbTest extends Activity {

    BoxDataHelper boxDataHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);
        boxDataHelper = new BoxDataHelper(this);
    }
}

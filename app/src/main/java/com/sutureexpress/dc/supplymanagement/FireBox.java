package com.sutureexpress.dc.supplymanagement;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

public class FireBox extends AppCompatActivity {

    private Toolbar toolbar;

    TextView mBox1_fb_count;
    TextView mBox2_fb_count;
    TextView mBox3_fb_count;
    TextView mBox4_fb_count;
    TextView mBox5_fb_count;
    TextView mBox6_fb_count;
    TextView mBox7_fb_count;
    TextView mBox8_fb_count;
    TextView mBox9_fb_count;
    TextView mBox10_fb_count;
    TextView mBox11_fb_count;
    TextView mBox12_fb_count;
    TextView mBox13_fb_count;
    TextView mBox14_fb_count;
    TextView mBox15_fb_count;
    TextView mBox16_fb_count;
    TextView mBag1_fb_count;
    TextView mBag2_fb_count;
    TextView mBag3_fb_count;
    TextView mFedex_med_fb_count;
    TextView mFedex_lg_fb_count;
    TextView mAir_pillow_fb_count;
    TextView mTape_fb_count;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mBox1Ref = mRootRef.child("box_master/box1/box1_count");
    DatabaseReference mBox2Ref = mRootRef.child("box_master/box2/box2_count");
    DatabaseReference mBox3Ref = mRootRef.child("box_master/box3/box3_count");
    DatabaseReference mBox4Ref = mRootRef.child("box_master/box4/box4_count");
    DatabaseReference mBox5Ref = mRootRef.child("box_master/box5/box5_count");
    DatabaseReference mBox6Ref = mRootRef.child("box_master/box6/box6_count");
    DatabaseReference mBox7Ref = mRootRef.child("box_master/box7/box7_count");
    DatabaseReference mBox8Ref = mRootRef.child("box_master/box8/box8_count");
    DatabaseReference mBox9Ref = mRootRef.child("box_master/box9/box9_count");
    DatabaseReference mBox10Ref = mRootRef.child("box_master/box10/box10_count");
    DatabaseReference mBox11Ref = mRootRef.child("box_master/box11/box11_count");
    DatabaseReference mBox12Ref = mRootRef.child("box_master/box12/box12_count");
    DatabaseReference mBox13Ref = mRootRef.child("box_master/box13/box13_count");
    DatabaseReference mBox14Ref = mRootRef.child("box_master/box14/box14_count");
    DatabaseReference mBox15Ref = mRootRef.child("box_master/box15/box15_count");
    DatabaseReference mBox16Ref = mRootRef.child("box_master/box16/box16_count");
    DatabaseReference mBag1Ref = mRootRef.child("box_master/bag1/bag1_count");
    DatabaseReference mBag2Ref = mRootRef.child("box_master/bag2/bag2_count");
    DatabaseReference mBag3Ref = mRootRef.child("box_master/bag3/bag3_count");
    DatabaseReference mfedExMedRef = mRootRef.child("box_master/fedEx_med/fedEx_med_count");
    DatabaseReference mfedExLgRef = mRootRef.child("box_master/fedEx_lg/fedEx_lg_count");
    DatabaseReference mAirPillowRef = mRootRef.child("box_master/air_pillow/air_pillow_count");
    DatabaseReference mTapeRef = mRootRef.child("box_master/tape/tape_count");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_box);
        toolbar = (Toolbar) findViewById(R.id.fireBox_appBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getTimeDate();

        //   Get UI elements
        mBox1_fb_count = (TextView) findViewById(R.id.box1_fb_count);
        mBox2_fb_count = (TextView) findViewById(R.id.box2_fb_count);
        mBox3_fb_count = (TextView) findViewById(R.id.box3_fb_count);
        mBox4_fb_count = (TextView) findViewById(R.id.box4_fb_count);
        mBox5_fb_count = (TextView) findViewById(R.id.box5_fb_count);
        mBox6_fb_count = (TextView) findViewById(R.id.box6_fb_count);
        mBox7_fb_count = (TextView) findViewById(R.id.box7_fb_count);
        mBox8_fb_count = (TextView) findViewById(R.id.box8_fb_count);
        mBox9_fb_count = (TextView) findViewById(R.id.box9_fb_count);
        mBox10_fb_count = (TextView) findViewById(R.id.box10_fb_count);
        mBox11_fb_count = (TextView) findViewById(R.id.box11_fb_count);
        mBox12_fb_count = (TextView) findViewById(R.id.box12_fb_count);
        mBox13_fb_count = (TextView) findViewById(R.id.box13_fb_count);
        mBox14_fb_count = (TextView) findViewById(R.id.box14_fb_count);
        mBox15_fb_count = (TextView) findViewById(R.id.box15_fb_count);
        mBox16_fb_count = (TextView) findViewById(R.id.box16_fb_count);
        mBag1_fb_count = (TextView) findViewById(R.id.bag1_fb_count);
        mBag2_fb_count = (TextView) findViewById(R.id.bag2_fb_count);
        mBag3_fb_count = (TextView) findViewById(R.id.bag3_fb_count);
        mFedex_med_fb_count = (TextView) findViewById(R.id.fedex_med_fb_count);
        mFedex_lg_fb_count = (TextView) findViewById(R.id.fedex_lg_fb_count);
        mAir_pillow_fb_count = (TextView) findViewById(R.id.air_pillow_fb_count);
        mTape_fb_count = (TextView) findViewById(R.id.tape_fb_count);
    }

    public void getTimeDate() {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        TextView inventoryDate = (TextView) findViewById(R.id.inventoryDate);
// textView is the TextView view that should display it
        inventoryDate.setText(currentDateTimeString);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mBox1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox1Count = dataSnapshot.getValue(String.class);
                mBox1_fb_count.setText(fbBox1Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox2Count = dataSnapshot.getValue(String.class);
                mBox2_fb_count.setText(fbBox2Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox3Count = dataSnapshot.getValue(String.class);
                mBox3_fb_count.setText(fbBox3Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox4Count = dataSnapshot.getValue(String.class);
                mBox4_fb_count.setText(fbBox4Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox5Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox5Count = dataSnapshot.getValue(String.class);
                mBox5_fb_count.setText(fbBox5Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox6Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox6Count = dataSnapshot.getValue(String.class);
                mBox6_fb_count.setText(fbBox6Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox7Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox7Count = dataSnapshot.getValue(String.class);
                mBox7_fb_count.setText(fbBox7Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox8Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox8Count = dataSnapshot.getValue(String.class);
                mBox8_fb_count.setText(fbBox8Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox9Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox9Count = dataSnapshot.getValue(String.class);
                mBox9_fb_count.setText(fbBox9Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox10Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox10Count = dataSnapshot.getValue(String.class);
                mBox10_fb_count.setText(fbBox10Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox11Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox11Count = dataSnapshot.getValue(String.class);
                mBox11_fb_count.setText(fbBox11Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox12Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox12Count = dataSnapshot.getValue(String.class);
                mBox12_fb_count.setText(fbBox12Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox13Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox13Count = dataSnapshot.getValue(String.class);
                mBox13_fb_count.setText(fbBox13Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox14Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox14Count = dataSnapshot.getValue(String.class);
                mBox14_fb_count.setText(fbBox14Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox15Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox15Count = dataSnapshot.getValue(String.class);
                mBox15_fb_count.setText(fbBox15Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox16Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox16Count = dataSnapshot.getValue(String.class);
                mBox16_fb_count.setText(fbBox16Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBag1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBag1Count = dataSnapshot.getValue(String.class);
                mBag1_fb_count.setText(fbBag1Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBag2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBag2Count = dataSnapshot.getValue(String.class);
                mBag2_fb_count.setText(fbBag2Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBag3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBag3Count = dataSnapshot.getValue(String.class);
                mBag3_fb_count.setText(fbBag3Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mfedExMedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbFedExMedCount = dataSnapshot.getValue(String.class);
                mFedex_med_fb_count.setText(fbFedExMedCount);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mfedExLgRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbFedExLgCount = dataSnapshot.getValue(String.class);
                mFedex_lg_fb_count.setText(fbFedExLgCount);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAirPillowRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbAirPillowCount = dataSnapshot.getValue(String.class);
                mAir_pillow_fb_count.setText(fbAirPillowCount);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mTapeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbTapeCount = dataSnapshot.getValue(String.class);
                mTape_fb_count.setText(fbTapeCount);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fire_box, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this,"Sorry, but [" +item.getTitle() +"] isn't yet configured.",Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.app_info) {
            Toast.makeText(this,"This Box Inventory Count provided by Firebase Realtime Database " +
                    "v9.2.1 and the Android SDK. Don't forget to thank your developer!",Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == android.R.id.home) {
            Intent upIntent = NavUtils.getParentActivityIntent(this);
            if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                // This activity is NOT part of this app's task, so create a new task
                // when navigating up, with a synthesized back stack.
                TaskStackBuilder.create(this)
                        // Add all of this activity's parents to the back stack
                        .addNextIntentWithParentStack(upIntent)
                        // Navigate up to the closest parent
                        .startActivities();
            } else {
                // This activity is part of this app's task, so simply
                // navigate up to the logical parent activity.
                NavUtils.navigateUpTo(this, upIntent);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void previewBoxCountEmail(View view) {
        Intent intent = new Intent(FireBox.this, CurrentBoxCount.class);
        startActivity(intent);
        finish();
    }
}

package com.sutureexpress.dc.supplymanagement;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class BoxCount extends AppCompatActivity {

    private Toolbar toolbar;
    EditText mBox1_count;
    EditText mBox2_count;
    EditText mBox3_count;
    EditText mBox4_count;
    EditText mBox5_count;
    EditText mBox6_count;
    EditText mBox7_count;
    EditText mBox8_count;
    EditText mBox9_count;
    EditText mBox10_count;
    EditText mBox11_count;
    EditText mBox12_count;
    EditText mBox13_count;
    EditText mBox14_count;
    EditText mBox15_count;
    EditText mBox16_count;
    EditText mBag1_count;
    EditText mBag2_count;
    EditText mBag3_count;
    EditText mFedex_med_count;
    EditText mFedex_lg_count;
    EditText mAir_pillow_count;
    EditText mTape_count;
    Button mBoxSave;

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
        setContentView(R.layout.activity_box_count);
        toolbar = (Toolbar) findViewById(R.id.app_bar_box_count);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getTimeDate();

        //   Get UI elements
        mBox1_count = (EditText) findViewById(R.id.box1_count);
        mBox2_count = (EditText) findViewById(R.id.box2_count);
        mBox3_count = (EditText) findViewById(R.id.box3_count);
        mBox4_count = (EditText) findViewById(R.id.box4_count);
        mBox5_count = (EditText) findViewById(R.id.box5_count);
        mBox6_count = (EditText) findViewById(R.id.box6_count);
        mBox7_count = (EditText) findViewById(R.id.box7_count);
        mBox8_count = (EditText) findViewById(R.id.box8_count);
        mBox9_count = (EditText) findViewById(R.id.box9_count);
        mBox10_count = (EditText) findViewById(R.id.box10_count);
        mBox11_count = (EditText) findViewById(R.id.box11_count);
        mBox12_count = (EditText) findViewById(R.id.box12_count);
        mBox13_count = (EditText) findViewById(R.id.box13_count);
        mBox14_count = (EditText) findViewById(R.id.box14_count);
        mBox15_count = (EditText) findViewById(R.id.box15_count);
        mBox16_count = (EditText) findViewById(R.id.box16_count);
        mBag1_count = (EditText) findViewById(R.id.bag1_count);
        mBag2_count = (EditText) findViewById(R.id.bag2_count);
        mBag3_count = (EditText) findViewById(R.id.bag3_count);
        mFedex_med_count = (EditText) findViewById(R.id.fedex_med_count);
        mFedex_lg_count = (EditText) findViewById(R.id.fedex_lg_count);
        mAir_pillow_count = (EditText) findViewById(R.id.air_pillow_count);
        mTape_count = (EditText) findViewById(R.id.tape_count);
        mBoxSave = (Button) findViewById(R.id.boxCount_save_button);

    }

    public void getTimeDate() {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        TextView countDate = (TextView) findViewById(R.id.countDate);
// textView is the TextView view that should display it
        countDate.setText(currentDateTimeString);
    }

    @Override
    protected void onStart() {
        super.onStart();

       /* mBox1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fbBox1Count = dataSnapshot.getValue(String.class);
                //mBox1_count.setText(fbBox1Count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBox1_count.set(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBox1Ref.setValue(mBox1_count.getText());
            }
        });
        */
        mBox1_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox1Ref.setValue(mBox1_count.getText().toString());
            }
        });

        mBox2_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox2Ref.setValue(mBox2_count.getText().toString());
            }
        });

        mBox3_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox3Ref.setValue(mBox3_count.getText().toString());
            }
        });

        mBox4_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox4Ref.setValue(mBox4_count.getText().toString());
            }
        });

        mBox5_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox5Ref.setValue(mBox5_count.getText().toString());
            }
        });

        mBox6_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox6Ref.setValue(mBox6_count.getText().toString());
            }
        });

        mBox7_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox7Ref.setValue(mBox7_count.getText().toString());
            }
        });

        mBox8_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox8Ref.setValue(mBox8_count.getText().toString());
            }
        });

        mBox9_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox9Ref.setValue(mBox9_count.getText().toString());
            }
        });

        mBox10_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox10Ref.setValue(mBox10_count.getText().toString());
            }
        });

        mBox11_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox11Ref.setValue(mBox11_count.getText().toString());
            }
        });

        mBox12_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox12Ref.setValue(mBox12_count.getText().toString());
            }
        });

        mBox13_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox13Ref.setValue(mBox13_count.getText().toString());
            }
        });

        mBox14_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox14Ref.setValue(mBox14_count.getText().toString());
            }
        });

        mBox15_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox15Ref.setValue(mBox15_count.getText().toString());
            }
        });

        mBox16_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBox16Ref.setValue(mBox16_count.getText().toString());
            }
        });

        mBag1_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBag1Ref.setValue(mBag1_count.getText().toString());
            }
        });

        mBag2_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBag2Ref.setValue(mBag2_count.getText().toString());
            }
        });

        mBag3_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mBag3Ref.setValue(mBag3_count.getText().toString());
            }
        });

        mFedex_med_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mfedExMedRef.setValue(mFedex_med_count.getText().toString());
            }
        });

        mFedex_lg_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mfedExLgRef.setValue(mFedex_lg_count.getText().toString());
            }
        });

        mAir_pillow_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mAirPillowRef.setValue(mAir_pillow_count.getText().toString());
            }
        });

        mTape_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    mTapeRef.setValue(mTape_count.getText().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_box_count, menu);
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
            Toast.makeText(this,"Please click in any count field other than Tape Count when finished," +
                    "otherwise your tape count will NOT update the Firebase database!",Toast.LENGTH_LONG).show();
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


    public void previewBoxCount(View view) {
        Intent intent = new Intent(BoxCount.this, FireBox.class);
        startActivity(intent);
        finish();
    }

}

package com.sutureexpress.dc.supplymanagement;

import com.sutureexpress.dc.supplymanagement.BoxCount;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;
import android.view.View;
import android.widget.Toast;

public class CurrentBoxCount extends AppCompatActivity {

private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_box_count);
        toolbar = (Toolbar) findViewById(R.id.fireBox_appBar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String currentDateString = DateFormat.getDateInstance().format(new Date());
        TextView previewDate = (TextView) findViewById(R.id.subject);
// textView is the TextView view that should display it
        Resources res = getResources();
        String subjectPrefix = (res.getString(R.string.subject_constant));
        String newSubject = (subjectPrefix + " " + currentDateString);
        previewDate.setText(newSubject);
        TextView emailBody = (TextView) findViewById(R.id.email_body_layout);

        String bodyPreview =
                ("Kerry," + "\r\n\r\n" + "Here is the box count for " +
                        (currentDateString) + " : " + "\r\n" + "http://taylor.verderbergroup.org/boxCountFirebaseWebView/current_box_count.php" +
                        "\r\n" + "Brought to you by : " +
                        "\r\n" + "Your SE DC Android Developer");
        emailBody.setText(bodyPreview);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_current_box_count, menu);
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
            Toast.makeText(this,"Please click on Gmail button to send email to management...",Toast.LENGTH_LONG).show();
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

    public void sendBoxCountEmail(String address, String newSubject, String bccAddress,
                                  String bodyPreview, String subjectPrefix, String ccAddress ) {
        Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
        shareIntent.setData(Uri.parse("mailto:"));
        String currentDateString = DateFormat.getDateInstance().format(new Date());
        Resources res = getResources();
        subjectPrefix = (res.getString(R.string.subject_constant));
        newSubject = (subjectPrefix + " " + currentDateString);
        bodyPreview =
                ("Kerry," + "\r\n\r\n" + "Here is the box count for : " +
                        (currentDateString) + "\r\n" + "<a href=\"http://" +
                "taylor.verderbergroup.org/boxCountFirebaseWebView/current_box_count.php\">Latest Firebase Box Inventory</a>" +
                        "/r/n" + "Brought to you by : " +
                        "\r\n" + "Your SE DC Android Developer");
        address = (res.getString(R.string.taylor_gmail_primary));
        ccAddress = (res.getString(R.string.dclead_email));
        bccAddress = (res.getString(R.string.taylor_gmail_dmb));
        shareIntent.putExtra(Intent.EXTRA_EMAIL, address);
        //shareIntent.putExtra(Intent.EXTRA_CC, ccAddress);
        shareIntent.putExtra(Intent.EXTRA_BCC, bccAddress);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, newSubject);
        shareIntent.putExtra(Intent.EXTRA_TEXT, bodyPreview);
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
        }
    }

}

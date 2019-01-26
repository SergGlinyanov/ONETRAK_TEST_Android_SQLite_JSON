package com.example.android.onetrak_test;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static com.example.android.onetrak_test.Api.data;
import static com.example.android.onetrak_test.DBHelper.targetBase;

public class MainActivity extends AppCompatActivity {

    TextView date1, rate1, bar1, bar2, bar3, walk, aerobic, run;
    TextView date1q, rate1q, bar1q, bar2q, bar3q, walkq, aerobicq, runq;
    TextView date1q1, rate1q1, bar1q1, bar2q1, bar3q1, walkq1, aerobicq1, runq1;
    TextView date1qz, rate1qz, bar1qz, bar2qz, bar3qz, walkqz, aerobicqz, runqz;
    TextView date1qa, rate1qa, bar1qa, bar2qa, bar3qa, walkqa, aerobicqa, runqa;
    LinearLayout line4, line4q, line4q1, line4qz, line4qa, block1, block2, block3, block4, block5;
    //    int targetBase=4000;
    int targetComplit;
    Long q1;
    Integer q2, q3, q4;
    String s1, s2, s3, s4;
    DBHelper dbHelper;
    Context context = MainActivity.this;
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    String w = "";
    int w1, w2, w3, mas1, mas2, mas3;
    String reportDate = "";
    Date date;
    LinearLayout.LayoutParams params1, params2, params3, params1q, params2q, params3q;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        date1 = (TextView) this.findViewById(R.id.date1);
        rate1 = (TextView) this.findViewById(R.id.rate1);
        bar1 = (TextView) this.findViewById(R.id.bar1);
        bar2 = (TextView) this.findViewById(R.id.bar2);
        bar3 = (TextView) this.findViewById(R.id.bar3);
        walk = (TextView) this.findViewById(R.id.walk);
        aerobic = (TextView) this.findViewById(R.id.aerobic);
        run = (TextView) this.findViewById(R.id.run);
        line4 = (LinearLayout) this.findViewById(R.id.line4);

        date1q = (TextView) this.findViewById(R.id.date1q);
        rate1q = (TextView) this.findViewById(R.id.rate1q);
        bar1q = (TextView) this.findViewById(R.id.bar1q);
        bar2q = (TextView) this.findViewById(R.id.bar2q);
        bar3q = (TextView) this.findViewById(R.id.bar3q);
        walkq = (TextView) this.findViewById(R.id.walkq);
        aerobicq = (TextView) this.findViewById(R.id.aerobicq);
        runq = (TextView) this.findViewById(R.id.runq);
        line4q = (LinearLayout) this.findViewById(R.id.line4q);

        date1q1 = (TextView) this.findViewById(R.id.date1q1);
        rate1q1 = (TextView) this.findViewById(R.id.rate1q1);
        bar1q1 = (TextView) this.findViewById(R.id.bar1q1);
        bar2q1 = (TextView) this.findViewById(R.id.bar2q1);
        bar3q1 = (TextView) this.findViewById(R.id.bar3q1);
        walkq1 = (TextView) this.findViewById(R.id.walkq1);
        aerobicq1 = (TextView) this.findViewById(R.id.aerobicq1);
        runq1 = (TextView) this.findViewById(R.id.runq1);
        line4q1 = (LinearLayout) this.findViewById(R.id.line4q1);

        date1qz = (TextView) this.findViewById(R.id.date1qz);
        rate1qz = (TextView) this.findViewById(R.id.rate1qz);
        bar1qz = (TextView) this.findViewById(R.id.bar1qz);
        bar2qz = (TextView) this.findViewById(R.id.bar2qz);
        bar3qz = (TextView) this.findViewById(R.id.bar3qz);
        walkqz = (TextView) this.findViewById(R.id.walkqz);
        aerobicqz = (TextView) this.findViewById(R.id.aerobicqz);
        runqz = (TextView) this.findViewById(R.id.runqz);
        line4qz = (LinearLayout) this.findViewById(R.id.line4qz);

        date1qa = (TextView) this.findViewById(R.id.date1qa);
        rate1qa = (TextView) this.findViewById(R.id.rate1qa);
        bar1qa = (TextView) this.findViewById(R.id.bar1qa);
        bar2qa = (TextView) this.findViewById(R.id.bar2qa);
        bar3qa = (TextView) this.findViewById(R.id.bar3qa);
        walkqa = (TextView) this.findViewById(R.id.walkqa);
        aerobicqa = (TextView) this.findViewById(R.id.aerobicqa);
        runqa = (TextView) this.findViewById(R.id.runqa);
        line4qa = (LinearLayout) this.findViewById(R.id.line4qa);
        block1 = (LinearLayout) this.findViewById(R.id.block1);
        block2 = (LinearLayout) this.findViewById(R.id.block2);
        block3 = (LinearLayout) this.findViewById(R.id.block3);
        block4 = (LinearLayout) this.findViewById(R.id.block4);
        block5 = (LinearLayout) this.findViewById(R.id.block5);


        dbHelper = new DBHelper(this);

        try {
            JSONArray JA = new JSONArray(data);


            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);

                q1 = (Long) JO.get("date");
                q2 = (Integer) JO.get("aerobic");
                q3 = (Integer) JO.get("run");
                q4 = (Integer) JO.get("walk");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    s1 = Objects.toString(q1, null);
                    s2 = Objects.toString(q2, null);
                    s3 = Objects.toString(q3, null);
                    s4 = Objects.toString(q4, null);
                }

                SQLiteDatabase database = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBHelper.KEY_DATE, s1);
                contentValues.put(DBHelper.KEY_AEROBIC, s2);
                contentValues.put(DBHelper.KEY_RUN, s3);
                contentValues.put(DBHelper.KEY_WALK, s4);
                database.insert(DBHelper.TABLE_DATA, null, contentValues);
                dbHelper.close();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SQLiteDatabase database = dbHelper.getWritableDatabase();


        Cursor cursor = database.query(DBHelper.TABLE_DATA,
                null, null, null, null, null, null);
        if (cursor != null) {

            cursor.moveToPosition(0);
            w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_DATE));
            w1 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_AEROBIC));
            w2 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_RUN));
            w3 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_WALK));

            date = new Date(Long.parseLong(w));
            reportDate = df.format(date);
            targetComplit = w1 + w2 + w3;
            mas1 = w3 * 100 / targetComplit / 10;
            mas2 = w1 * 100 / targetComplit / 10;
            mas3 = w2 * 100 / targetComplit / 10;
            if (mas1 == 0) {
                mas1 = 1;
            }
            if (mas2 == 0) {
                mas2 = 1;
            }
            if (mas3 == 0) {
                mas3 = 1;
            }
            if (mas2 < 2) {
                mas2 = 2;
            }

            date1.setText(reportDate);
            rate1.setText("" + targetComplit + " / " + targetBase + "  steps");
            params1 = (LinearLayout.LayoutParams) bar1.getLayoutParams();
            params1.weight = w3;
            bar1.setLayoutParams(params1);
            params2 = (LinearLayout.LayoutParams) bar2.getLayoutParams();
            params2.weight = w1;
            bar2.setLayoutParams(params2);
            params3 = (LinearLayout.LayoutParams) bar3.getLayoutParams();
            params3.weight = w2;
            bar3.setLayoutParams(params3);
            walk.setText("" + w3 + "\n" + "walk");
            aerobic.setText("" + w1 + "\n" + "aerobic");
            run.setText("" + w2 + "\n" + "run");
            params1q = (LinearLayout.LayoutParams) walk.getLayoutParams();
            params1q.weight = mas1;
            walk.setLayoutParams(params1q);
            params2q = (LinearLayout.LayoutParams) aerobic.getLayoutParams();
            params2q.weight = mas2;
            aerobic.setLayoutParams(params2q);
            params3q = (LinearLayout.LayoutParams) run.getLayoutParams();
            params3q.weight = mas3;
            run.setLayoutParams(params3q);

            if (targetComplit >= targetBase) {
                line4.setVisibility(View.VISIBLE);
            }
            if (w1 > 40000 || w2 > 40000 || w3 > 40000) {
                block1.setVisibility(View.GONE);
            }
///////////////////////////////////////////////////////////////
            cursor.moveToPosition(1);
            w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_DATE));
            w1 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_AEROBIC));
            w2 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_RUN));
            w3 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_WALK));

            date = new Date(Long.parseLong(w));
            reportDate = df.format(date);
            targetComplit = w1 + w2 + w3;
            mas1 = w3 * 100 / targetComplit / 10;
            mas2 = w1 * 100 / targetComplit / 10;
            mas3 = w2 * 100 / targetComplit / 10;
            if (mas1 == 0) {
                mas1 = 1;
            }
            if (mas2 == 0) {
                mas2 = 1;
            }
            if (mas3 == 0) {
                mas3 = 1;
            }
            if (mas2 < 2) {
                mas2 = 2;
            }


            date1q.setText(reportDate);
            rate1q.setText("" + targetComplit + " / " + targetBase + "  steps");

            params1 = (LinearLayout.LayoutParams) bar1q.getLayoutParams();
            params1.weight = w3;
            bar1q.setLayoutParams(params1);

            params2 = (LinearLayout.LayoutParams) bar2q.getLayoutParams();
            params2.weight = w1;
            bar2q.setLayoutParams(params2);

            params3 = (LinearLayout.LayoutParams) bar3q.getLayoutParams();
            params3.weight = w2;
            bar3q.setLayoutParams(params3);

            walkq.setText("" + w3 + "\n" + "walk" + mas1);
            aerobicq.setText("" + w1 + "\n" + "aerobic" + mas2);
            runq.setText("" + w2 + "\n" + "run" + mas3);

            params1q = (LinearLayout.LayoutParams) walkq.getLayoutParams();
            params1q.weight = mas1;
            walkq.setLayoutParams(params1q);

            params2q = (LinearLayout.LayoutParams) aerobicq.getLayoutParams();
            params2q.weight = mas2;
            aerobicq.setLayoutParams(params2q);

            params3q = (LinearLayout.LayoutParams) runq.getLayoutParams();
            params3q.weight = mas3;
            runq.setLayoutParams(params3q);

            if (targetComplit >= targetBase) {
                line4q.setVisibility(View.VISIBLE);
            }
            if (w1 > 40000 || w2 > 40000 || w3 > 40000) {
                block2.setVisibility(View.GONE);
            }
//////////////////////////////////////////////////////////////
            cursor.moveToPosition(2);
            w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_DATE));
            w1 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_AEROBIC));
            w2 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_RUN));
            w3 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_WALK));

            date = new Date(Long.parseLong(w));
            reportDate = df.format(date);
            targetComplit = w1 + w2 + w3;

            mas1 = w3 * 100 / targetComplit / 10;
            mas2 = w1 * 100 / targetComplit / 10;
            mas3 = w2 * 100 / targetComplit / 10;
            if (mas1 == 0) {
                mas1 = 1;
            }
            if (mas2 == 0) {
                mas2 = 1;
            }
            if (mas3 == 0) {
                mas3 = 1;
            }
            if (mas2 < 2) {
                mas2 = 2;
            }

            date1q1.setText(reportDate);
            rate1q1.setText("" + targetComplit + " / " + targetBase + "  steps");

            params1 = (LinearLayout.LayoutParams) bar1q1.getLayoutParams();
            params1.weight = w3;
            bar1q1.setLayoutParams(params1);

            params2 = (LinearLayout.LayoutParams) bar2q1.getLayoutParams();
            params2.weight = w1;
            bar2q1.setLayoutParams(params2);

            params3 = (LinearLayout.LayoutParams) bar3q1.getLayoutParams();
            params3.weight = w2;
            bar3q1.setLayoutParams(params3);

            walkq1.setText("" + w3 + "\n" + "walk");
            aerobicq1.setText("" + w1 + "\n" + "aerobic");
            runq1.setText("" + w2 + "\n" + "run");

            params1q = (LinearLayout.LayoutParams) walkq1.getLayoutParams();
            params1q.weight = mas1;
            walkq1.setLayoutParams(params1q);

            params2q = (LinearLayout.LayoutParams) aerobicq1.getLayoutParams();
            params2q.weight = mas2;
            aerobicq1.setLayoutParams(params2q);

            params3q = (LinearLayout.LayoutParams) runq1.getLayoutParams();
            params3q.weight = mas3;
            runq1.setLayoutParams(params3q);

            if (targetComplit >= targetBase) {
                line4q1.setVisibility(View.VISIBLE);
            }
            if (w1 > 40000 || w2 > 40000 || w3 > 40000) {
                block3.setVisibility(View.GONE);
            }
/////////////////////////////////////////////////////
            cursor.moveToPosition(3);
            w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_DATE));
            w1 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_AEROBIC));
            w2 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_RUN));
            w3 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_WALK));

            date = new Date(Long.parseLong(w));
            reportDate = df.format(date);
            targetComplit = w1 + w2 + w3;
            mas1 = w3 * 100 / targetComplit / 10;
            mas2 = w1 * 100 / targetComplit / 10;
            mas3 = w2 * 100 / targetComplit / 10;
            if (mas1 == 0) {
                mas1 = 1;
            }
            if (mas2 == 0) {
                mas2 = 1;
            }
            if (mas3 == 0) {
                mas3 = 1;
            }
            if (mas2 < 2) {
                mas2 = 2;
            }

            date1qz.setText(reportDate);
            rate1qz.setText("" + targetComplit + " / " + targetBase + "  steps");

            params1 = (LinearLayout.LayoutParams) bar1qz.getLayoutParams();
            params1.weight = w3;
            bar1qz.setLayoutParams(params1);

            params2 = (LinearLayout.LayoutParams) bar2qz.getLayoutParams();
            params2.weight = w1;
            bar2qz.setLayoutParams(params2);

            params3 = (LinearLayout.LayoutParams) bar3qz.getLayoutParams();
            params3.weight = w2;
            bar3qz.setLayoutParams(params3);

            walkqz.setText("" + w3 + "\n" + "walk");
            aerobicqz.setText("" + w1 + "\n" + "aerobic");
            runqz.setText("" + w2 + "\n" + "run" + mas1 + mas2 + mas3);

            params1q = (LinearLayout.LayoutParams) walkqz.getLayoutParams();
            params1q.weight = mas1;
            walkqz.setLayoutParams(params1q);

            params2q = (LinearLayout.LayoutParams) aerobicqz.getLayoutParams();
            params2q.weight = mas2;
            aerobicqz.setLayoutParams(params2q);

            params3q = (LinearLayout.LayoutParams) runqz.getLayoutParams();
            params3q.weight = mas3;
            runqz.setLayoutParams(params3q);

            if (targetComplit >= targetBase) {
                line4qz.setVisibility(View.VISIBLE);
            }
            if (w1 > 40000 || w2 > 40000 || w3 > 40000) {
                block4.setVisibility(View.GONE);
            }
///////////////////////////////////////////////////////////////////////////
            cursor.moveToPosition(4);
            w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_DATE));
            w1 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_AEROBIC));
            w2 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_RUN));
            w3 = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_WALK));

            date = new Date(Long.parseLong(w));
            reportDate = df.format(date);
            targetComplit = w1 + w2 + w3;
            mas1 = w3 * 100 / targetComplit / 10;
            mas2 = w1 * 100 / targetComplit / 10;
            mas3 = w2 * 100 / targetComplit / 10;
            if (mas1 == 0) {
                mas1 = 1;
            }
            if (mas2 == 0) {
                mas2 = 1;
            }
            if (mas3 == 0) {
                mas3 = 1;
            }
            if (mas2 < 2) {
                mas2 = 2;
            }

            date1qa.setText(reportDate);
            rate1qa.setText("" + targetComplit + " / " + targetBase + "  steps");

            params1 = (LinearLayout.LayoutParams) bar1qa.getLayoutParams();
            params1.weight = w3;
            bar1qa.setLayoutParams(params1);

            params2 = (LinearLayout.LayoutParams) bar2qa.getLayoutParams();
            params2.weight = w1;
            bar2qa.setLayoutParams(params2);

            params3 = (LinearLayout.LayoutParams) bar3qa.getLayoutParams();
            params3.weight = w2;
            bar3qa.setLayoutParams(params3);

            walkqa.setText("" + w3 + "\n" + "walk");
            aerobicqa.setText("" + w1 + "\n" + "aerobic");
            runqa.setText("" + w2 + "\n" + "run");

            params1q = (LinearLayout.LayoutParams) walkqa.getLayoutParams();
            params1q.weight = mas1;
            walkqa.setLayoutParams(params1q);

            params2q = (LinearLayout.LayoutParams) aerobicqa.getLayoutParams();
            params2q.weight = mas1;
            aerobicqa.setLayoutParams(params2q);

            params3q = (LinearLayout.LayoutParams) runqa.getLayoutParams();
            params3q.weight = mas1;
            runqa.setLayoutParams(params3q);

            if (targetComplit >= targetBase) {
                line4qa.setVisibility(View.VISIBLE);
            }
            if (w1 > 40000 || w2 > 4000 || w3 > 40000) {
                block5.setVisibility(View.GONE);
            }

            cursor.close();
        }
        dbHelper.close();
    }


    int test1;

    public void target(View view) {

        final EditText input = new EditText(context);
        final AlertDialog dlg = new AlertDialog.Builder(this).
                setTitle("Set goals.").
                setView(input).
                setCancelable(false).
                setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        if (input.getText().toString().equalsIgnoreCase("")) {
                            dialog.dismiss();
                        } else {
                            test1 = Integer.parseInt(input.getText().toString());
                            targetBase = test1;
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }

                    }
                }).
                setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        /* Handle cancel clicked */
                        dialog.dismiss();
                    }
                }).create();
        dlg.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialog) {
                input.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                input.requestFocus();
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(input, 0);
            }
        });
        dlg.show();


    }


}

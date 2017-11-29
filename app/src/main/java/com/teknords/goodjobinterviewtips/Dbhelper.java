package com.teknords.goodjobinterviewtips;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;

public class Dbhelper extends SQLiteOpenHelper {

    private static final String DATABASE_PATH = "/data/data/com.teknords.goodjobinterviewtips/databases/";
    private static final String DATABASE_NAME = "job.sqlite";
    private static final int SCHEMA_VERSION = 1;

    // wrapperClass wp=new wrapperClass();
	/*
	 * private static final String TABLE_NAME="Topics";private static final
	 * String COLUMN_ID="chapID";
	 */

    public SQLiteDatabase dbSqlite;
    private final Context myContext;

    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
        this.myContext = context;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub

    }

    public void createDatabse() {
        creatDB();

    }

    private void creatDB() {
        boolean dbExist = DBExists();
        if (!dbExist) {
            this.getReadableDatabase();
            copyDBFromResource();
        }

    }

    private boolean DBExists() {
        SQLiteDatabase db = null;
        try {
            String databasePath = DATABASE_PATH + DATABASE_NAME;
            db = SQLiteDatabase.openDatabase(databasePath, null,
                    SQLiteDatabase.OPEN_READWRITE);
            db.setLocale(Locale.getDefault());
            db.setLockingEnabled(true);
            db.setVersion(1);
        } catch (SQLiteException e) {
            Log.e("SqlHelper", "database not found");
        }
        if (db != null) {
            db.close();
        }
        return db != null ? true : false;
    }

    private void copyDBFromResource() {
        InputStream inputStream = null;
        OutputStream outStream = null;
        String dbFilePath = DATABASE_PATH + DATABASE_NAME;
        try {
            inputStream = myContext.getAssets().open(DATABASE_NAME);
            outStream = new FileOutputStream(dbFilePath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);

            }
            outStream.flush();
            outStream.close();
            inputStream.close();

        } catch (IOException e) {
            throw new Error("Error copying database from resource");

        }
    }

    public ArrayList<String> getTotalSign(int nu) {

        String col_data_pic="";
        String col_data_title="";
        String col_data_detail="";
        String col_limite="";
        String tab_name="";


        switch(nu) {
            case 0:

                 col_data_pic="Images";
                 col_data_title="Headings";
                 col_data_detail="Descriptions";
                 col_limite="5";
                 tab_name="AnswerHumanResourceInterview";
                break;
            case 1:

                 col_data_pic="Images";
                 col_data_title="Headings";
                 col_data_detail="Descriptions";
                col_limite="10";
                 tab_name="CommunicateEffectivelyJobInterview";
                break;
            case 2:

                col_data_pic="Images";
                 col_data_title="Headings";
                 col_data_detail="Descriptions";
               col_limite="45";
               tab_name="GoToInterview";

            case 3:

                col_data_pic="Images";
                 col_data_title="Headings";
                 col_data_detail="Descriptions";
                 col_limite="12";
                 tab_name="GoodJobInterview";
                break;

            case 4:
                 col_data_pic="Images";
                 col_data_title="Headings";
                col_data_detail="Descriptions";
                 col_limite="11";
                 tab_name="InterviewSomeone";
                break;

            case 5:
                 col_data_pic="Images";
                 col_data_title="Headings";
                 col_data_detail="Descriptions";
                col_limite="22";
                 tab_name="PassJobInterview";
                break;
            case 6:

                 col_data_pic="Images";
                 col_data_title="Headings";
                 col_data_detail="Descriptions";
                 col_limite="15";
                tab_name="PerformWellGroupInterview";
                break;

            case 7:

                 col_data_pic="Images";
                 col_data_title="Headings";
                 col_data_detail="Descriptions";
                 col_limite="14";
                tab_name="PrepareForJobInterview";
                break;
            case 8:

                 col_data_pic="Images";
                 col_data_title="Headings";
                 col_data_detail="Descripitons";
                 col_limite="11";
                 tab_name="PrepareForPhoneInterview";
                break;
            case 9:

                col_data_pic="Images";
                 col_data_title="Headings";
                col_data_detail="Descriptions";
                 col_limite="12";
               tab_name="PrepareInterviewQuestionsThoroughly";
                break;
            case 10:

               col_data_pic="Images";
                col_data_title="Headings";
               col_data_detail="Descriptions";
                 col_limite="23";
               tab_name="WriteInterviewQuestions";
                break;


        }

        ArrayList<String> array_list1 = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT "+col_data_pic+" from "+tab_name+" limit "+col_limite+"", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            array_list1.add(res.getString(res.getColumnIndex(col_data_pic)));
            res.moveToNext();

        }

        return array_list1;

    }














    public ArrayList<String> engText(int nu) {


        String col_data_pic="";
        String col_data_title="";
        String col_data_detail="";
        String col_limite="";
        String tab_name="";


        switch(nu) {
            case 0:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="5";
                tab_name="AnswerHumanResourceInterview";
                break;
            case 1:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="10";
                tab_name="CommunicateEffectivelyJobInterview";
                break;
            case 2:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="45";
                tab_name="GoToInterview";

            case 3:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="12";
                tab_name="GoodJobInterview";
                break;

            case 4:
                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="11";
                tab_name="InterviewSomeone";
                break;

            case 5:
                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="22";
                tab_name="PassJobInterview";
                break;
            case 6:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="15";
                tab_name="PerformWellGroupInterview";
                break;

            case 7:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="14";
                tab_name="PrepareForJobInterview";
                break;
            case 8:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descripitons";
                col_limite="11";
                tab_name="PrepareForPhoneInterview";
                break;
            case 9:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="12";
                tab_name="PrepareInterviewQuestionsThoroughly";
                break;
            case 10:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="23";
                tab_name="WriteInterviewQuestions";
                break;

        }

        ArrayList<String> array_list1 = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT "+col_data_detail+" from "+tab_name+" limit "+col_limite+"", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            array_list1.add(res.getString(res.getColumnIndex(col_data_detail)));
            res.moveToNext();

        }

        return array_list1;

    }




    public ArrayList<String> arbText(int nu) {

        String col_data_pic="";
        String col_data_title="";
        String col_data_detail="";
        String col_limite="";
        String tab_name="";

        switch(nu) {
            case 0:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="5";
                tab_name="AnswerHumanResourceInterview";
                break;
            case 1:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="10";
                tab_name="CommunicateEffectivelyJobInterview";
                break;
            case 2:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="45";
                tab_name="GoToInterview";

            case 3:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="12";
                tab_name="GoodJobInterview";
                break;

            case 4:
                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="11";
                tab_name="InterviewSomeone";
                break;

            case 5:
                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="22";
                tab_name="PassJobInterview";
                break;
            case 6:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="15";
                tab_name="PerformWellGroupInterview";
                break;

            case 7:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="14";
                tab_name="PrepareForJobInterview";
                break;
            case 8:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descripitons";
                col_limite="11";
                tab_name="PrepareForPhoneInterview";
                break;
            case 9:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="12";
                tab_name="PrepareInterviewQuestionsThoroughly";
                break;
            case 10:

                col_data_pic="Images";
                col_data_title="Headings";
                col_data_detail="Descriptions";
                col_limite="23";
                tab_name="WriteInterviewQuestions";
                break;

        }

        ArrayList<String> array_list1 = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT "+col_data_title+" from "+tab_name+" limit "+col_limite+"", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            array_list1.add(res.getString(res.getColumnIndex(col_data_title)));
            res.moveToNext();

        }

        return array_list1;

    }











    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}
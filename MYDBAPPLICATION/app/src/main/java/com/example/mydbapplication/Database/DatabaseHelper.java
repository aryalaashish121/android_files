package com.example.mydbapplication.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mydbapplication.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="student";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

       // String std_query ="CREATE TABLE STUDENT(ID INTEGER PRIMARY KEY AUTOINCREMENT, STUDENT_NAME TEXT, STUDENT_PHONE TEXT, STUDENT_EMAIL TEXT, STUDENT_IMAGE TEXT)";
        db.execSQL(Student.std_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS STUDENT";
        db.execSQL(query);
        onCreate(db);
    }


    public Long AddStudentInfo(Student student){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("STUDENT_NAME",student.getName());
        contentValues.put("STUDENT_PHONE",student.getPhone());
        contentValues.put("STUDENT_EMAIL",student.getEmail());
        contentValues.put("STUDENT_IMAGE",student.getImage());

        long id = sqLiteDatabase.insert(Student.TBL_NAME,null,contentValues);
        return id;
    }

    public List<Student> GetStudents(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        List<Student> students = new ArrayList<>();
        String qry = "SELeCT * FROM "+Student.TBL_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(qry,null);
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                students.add(new Student(cursor.getInt(0),
                        cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4)));
            }
        }
        return students;
    }

    public int upgradeDetails(Student student){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("STUDENT_NAME",student.getName());
        contentValues.put("STUDENT_PHONE",student.getPhone());
        contentValues.put("STUDENT_EMAIL",student.getEmail());
        contentValues.put("STUDENT_IMAGE",student.getImage());

        return sqLiteDatabase.update(Student.TBL_NAME,contentValues,"id=?",new String[]{String.valueOf(student.getId())});

    }


    public void deleteStudents(Student student){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Student.TBL_NAME,"id=?",new String[]{
                String.valueOf(student.getId())
        });
        db.close();
    }
}

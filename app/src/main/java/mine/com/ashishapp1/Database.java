package mine.com.ashishapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper
{
 public static final String database_name="ashishapp1data.db";



    public Database(Context context) {
        super(context, database_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table contact_table (name text,phone integer primary key) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists contact_table");
        onCreate(db);

    }
    public boolean insertdata(String name_pass,String phone_pass)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        //ContentValues content_value=new ContentValues();
       // content_value.put(col1,name_pass);
       // content_value.put(col2,phone_pass);
       // long result=db.insert(table_name,null,content_value);
        try {


            db.execSQL("insert into contact_table(name,phone) values ('" + name_pass + "','" + phone_pass + "')");
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    public Cursor getalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from contact_table",null);
        return res;
    }
}

package foply.ph52222.huanph52222.lab1_adr2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper {
    // tao csdl
    public database( Context context) {
        super(context, "DB", null  , 1);
    }

    // tao bang
    @Override
    public void onCreate(SQLiteDatabase db) {
        // CAU LENH tao bang du lieu
        String CREATE_TABLE = "create Table model(\n" +
                "  id integer primary key,\n" +
                "  tile text,\n" +
                "  dis text\n" +
                ");";
        // thuc thi
        db.execSQL(CREATE_TABLE);


    }
// nang cap
    // update bang du lieu
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS model");
    }
    public void them(model d){
        SQLiteDatabase db = this.getWritableDatabase();// cho pheps ghi du lieu vao database
        ContentValues values = new ContentValues();
        // chuan bi du liue de insert
        values.put("tile",d.getTilte());
        values.put("dis",d.getDes());
        // insert
        db.insert("model",null,values);
        // dong ket noi
        db.close();
    }
    public List<model> getAll(){
        List<model> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String select = "select * from model";
        //con tro
        Cursor cursor = db.rawQuery(select,null);
        if(cursor.moveToFirst()){
            // di chuyen co tron ve ban ghi dau tien
            do{
               model model = new model();
               model.setTilte(cursor.getString(1));
               model.setDes(cursor.getString(2));
               list.add(model);// them vao danh sach
            }while (cursor.moveToNext());// di chuyen den ban ghi tiep theo
        }
        cursor.close();
        db.close();
        return list;
}
}


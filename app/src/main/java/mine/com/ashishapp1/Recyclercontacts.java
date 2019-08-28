/*-----------------------main activity connected with recycler view activity---------------------*/

package mine.com.ashishapp1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Recyclercontacts extends AppCompatActivity {
    List<Listitem> listitems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclercontacts);
        Database mydb;
        Cursor res;
        mydb= new Database(this);
        res=mydb.getalldata();
        RecyclerView post_list=(RecyclerView)findViewById(R.id.postview);
        post_list.setHasFixedSize(true);
        post_list.setLayoutManager(new LinearLayoutManager(this));




        while(res.moveToNext())
        {
            Listitem listitem=new Listitem(res.getString(0),res.getString(1));
            listitems.add(listitem);

           }
        post_list.setAdapter(new Adapter(listitems,this));
    }
}

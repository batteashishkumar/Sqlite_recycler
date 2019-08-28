package mine.com.ashishapp1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Database mydb;
    TextView textview_id;
    EditText firstname_id, phone_id;
    String firstname_str, phone_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview_id = (TextView) findViewById(R.id.textview_xid);
        firstname_id = (EditText) findViewById(R.id.firstname_xid);
        phone_id = (EditText) findViewById(R.id.phone_xid);
        mydb = new Database(this);


    }

    public void add_contact(View view) {


        firstname_str = firstname_id.getText().toString();
        phone_str = phone_id.getText().toString();
        boolean exc = mydb.insertdata(firstname_str, phone_str);
        if (exc == true) {
            Toast.makeText(this, "data inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "data not inserted", Toast.LENGTH_LONG).show();
        }
        textview_id.setTextSize(25);
        textview_id.setText("contact Added successfully \n Add more contacts:");
        firstname_id.setText("");
        phone_id.setText("");
    }

    public void view_contact(View view) {
        startActivity(new Intent(this, Recyclercontacts.class));
    }


}









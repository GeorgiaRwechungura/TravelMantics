package georgia.com.travelmantics;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  InsertActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    protected DatabaseReference mDatabaseReference;
    EditText txtTitle;
    EditText txtdescription;
    EditText txtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("traveldeals");

        txtTitle=findViewById(R.id.txtTitle);
        txtPrice=findViewById(R.id.txtPrice);
        txtdescription=findViewById(R.id.txtDescription);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

         switch (item.getItemId()){
             case R.id.save_menu:
                 saveDeal();
                 Toast.makeText(getApplicationContext(),"Deal Saved",Toast.LENGTH_LONG).show();
                 clean();
                 return  true;

                 default:
                     return super.onOptionsItemSelected(item);

         }

    }

    private void clean() {
        txtTitle.setText("");
        txtPrice.setText("");
        txtdescription.setText("");
        txtTitle.requestFocus();
    }

    private void saveDeal() {

        String tille= txtTitle.getText().toString();
        String description=txtdescription.getText().toString();
        String price=txtPrice.getText().toString();

        TravelDeals travelDeals=new TravelDeals(tille,description,price, "");
        mDatabaseReference.push().setValue(travelDeals);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.save_menu,menu);
        return true;
    }
}

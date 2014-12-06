
/*
    - Listener for views on a fragment.
    Which class catches the clicks on buttons if the button is in a fragment? The mainActivity class
    or the fragment class?
 */


package com.example.matrix.fragments_1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity implements FragmentOne.Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        FragmentOne fragOne = new FragmentOne();
        FragmentTwo fragTwo = new FragmentTwo();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.my_activity,fragOne);
        transaction.add(R.id.my_activity,fragTwo);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void funcFromFragToActivity(String data){
        Toast.makeText(this, "Incoming data: " + data, Toast.LENGTH_SHORT).show();

        TextView tv = (TextView)findViewById(R.id.mainActTextView);
        tv.setText(data);

        FragmentOne fragTwoComm = (FragmentOne)getFragmentManager().findFragmentById(R.id.frag1);
        if(fragTwoComm == null){
            Log.d("Communication","NULL fragTwoComm");
            Toast.makeText(this,"fragTwoComm = NULL", Toast.LENGTH_LONG).show();
        }
        //fragTwoComm.funcFromActivityToFrag();

    }

}

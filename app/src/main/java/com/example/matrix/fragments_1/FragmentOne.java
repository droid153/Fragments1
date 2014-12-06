package com.example.matrix.fragments_1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by matrix on 10/2/2014.
 */
public class FragmentOne extends Fragment implements View.OnClickListener{

    Activity mActivity;
    TextView text;
    Button butClickMe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        butClickMe = (Button)getActivity().findViewById(R.id.buttonFragOne);
        butClickMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        text = (TextView)getActivity().findViewById(R.id.textViewFragOne);
        text.setText("Voila!!!");

        ( (Communicator)mActivity ).funcFromFragToActivity("From Fragment to Activity");
    }

    public void funcFromActivityToFrag(){
        Toast.makeText(mActivity, "Message from Activity to Fragment one delivered", Toast.LENGTH_LONG).show();
        //text.setText("Changed from Activity");
    }

    // Interface used for communication from Fragment to Activity
    // The fragment captures the interface implementation during its onAttach() method and can then
    // call the funcFromFragToActivity() interface method to communicate with activity
    public interface Communicator{
        public void funcFromFragToActivity(String input);

    }
}

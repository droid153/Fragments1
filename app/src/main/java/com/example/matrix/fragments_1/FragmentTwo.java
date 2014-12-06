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
public class FragmentTwo extends Fragment implements View.OnClickListener{

    View view;
    Activity mActivity;
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_2, container, false);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;

        //Toast.makeText(mActivity, "Toast successful", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button butClickMe = (Button)getActivity().findViewById(R.id.buttonFragTwo);
        butClickMe.setOnClickListener(this);
    }

    public void onClick(View v){
        text = (TextView)getActivity().findViewById(R.id.textViewFragTwo);
        text.setText("Hey There!!!");
    }

    public void changeText(String data) {
        view.findViewById(R.id.textViewFragTwo);
    }

    public void funcFromActivityToFrag(){

        Toast.makeText(mActivity, "Message from Activity to Fragment2 delivered", Toast.LENGTH_LONG).show();
        text = (TextView)getActivity().findViewById(R.id.textViewFragTwo);
        text.setText("Changed from Activity");
    }

}

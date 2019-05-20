package appmoviles.com.fragmentsolution;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class FragmentB extends Fragment {
    private EditText txt_apellido;
    private OnFragmentInteractionListener listener;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_b, container, false);
        txt_apellido = v.findViewById(R.id.txt_apellido);
        v.findViewById(R.id.ok_apellido).setOnClickListener((view)->{
            if(listener!=null){
                MainActivity activity = (MainActivity) getActivity();
                activity.llamarFragmentMain();
                listener.onAction(FragmentB.this, txt_apellido.getText().toString());
            }
        });
        return v;
    }

    public void setInteractionListener(OnFragmentInteractionListener listener){
        this.listener = listener;
    }
}

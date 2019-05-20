package appmoviles.com.fragmentsolution;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class FragmentA extends Fragment {

    private EditText txt_nombre;
    private OnFragmentInteractionListener listener;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_a, container, false);
        txt_nombre = v.findViewById(R.id.txt_nombre);
        v.findViewById(R.id.ok_nombre).setOnClickListener((view)->{
            if(listener!=null){
                MainActivity activity = (MainActivity) getActivity();
                activity.llamarFragmentMain();
                listener.onAction(FragmentA.this, txt_nombre.getText().toString());
            }
        });
        return v;
    }

    public void setInteractionListener(OnFragmentInteractionListener listener){
        this.listener = listener;
    }
}

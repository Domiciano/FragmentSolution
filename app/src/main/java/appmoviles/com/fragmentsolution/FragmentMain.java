package appmoviles.com.fragmentsolution;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentMain extends Fragment implements OnFragmentInteractionListener{

    private TextView result_nombre, result_apellido;
    private String nombre = "", apellido = "";
    private OnFragmentInteractionListener listener;

    public FragmentMain() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragement_main, container, false);
        result_nombre = v.findViewById(R.id.result_nombre);
        result_apellido = v.findViewById(R.id.result_apellido);

        result_nombre.setText(nombre);
        result_apellido.setText(apellido);

        v.findViewById(R.id.choose_nombre).setOnClickListener((view)->{
            MainActivity activity = (MainActivity) getActivity();
            activity.llamarFragmentA();
        });
        v.findViewById(R.id.choose_apellido).setOnClickListener((view)->{
            MainActivity activity = (MainActivity) getActivity();
            activity.llamarFragmentB();
        });
        return v;
    }

    public void setInteractionListener(OnFragmentInteractionListener listener){
        this.listener = listener;
    }

    @Override
    public void onAction(Object origin, Object message) {
        if(origin instanceof FragmentA){
            nombre = (String) message;
        }else if(origin instanceof FragmentB){
            apellido = (String) message;
        }

    }
}

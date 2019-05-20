package appmoviles.com.fragmentsolution;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    private FragmentMain fragmentMain;
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciar los fragments
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentMain = new FragmentMain();

        //Definir las conexiones entre las interfaces
        fragmentA.setInteractionListener(fragmentMain);
        fragmentB.setInteractionListener(fragmentMain);

        //Poner el fragment principal
        manager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.root, fragmentMain);
        fragmentTransaction.commit();

    }

    public void llamarFragmentA(){
        manager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.root, fragmentA);
        fragmentTransaction.commit();
    }

    public void llamarFragmentB(){
        manager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.root, fragmentB);
        fragmentTransaction.commit();
    }

    public void llamarFragmentMain() {
        manager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.root, fragmentMain);
        fragmentTransaction.commit();
    }
}

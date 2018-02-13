package eus.mainu.mainu;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class Bocadillos extends AppCompatActivity {

    private TextView mTextMessage;
    private ListView listaBocadillos;
    String[] bocadillos;
    String[] descripcion;
    String[] precios;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bocadillos);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Recogemos las referencias del listView
        Resources res = getResources();
        listaBocadillos = findViewById(R.id.listaBocadillos);
        bocadillos = res.getStringArray(R.array.listaBocadillos);
        descripcion = res.getStringArray(R.array.descripcionBocadillos);
        precios = res.getStringArray(R.array.preciosBocadillos);

        //Adaptamos el formato del listView en funcion del layout que hemos creado
        AdaptadorDeObjetos adaptadorDeObjetos = new AdaptadorDeObjetos(this, bocadillos, descripcion, precios);
        listaBocadillos.setAdapter(adaptadorDeObjetos);

    }

}

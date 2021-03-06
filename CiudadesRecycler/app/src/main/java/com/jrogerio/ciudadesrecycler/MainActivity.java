package com.jrogerio.ciudadesrecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // Usamos este fragment para cargar otro fragment distinto cuando pulsamos
            // en cualquier botón de la navegación
            Fragment f = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // Este sería el nuevo fragment que cargamos en caso de seleccionar
                    // el icono de home en la navegación
                    f = new CiudadItemFragment();
                    /*
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenedor, new HomeFragment())
                            .commit();
                            */
                    return true;
                case R.id.navigation_dashboard:
                    f = new EjemploFragment();
                    /*
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenedor, new DashboardFragment())
                            .commit();
                            */
                    return true;
                case R.id.navigation_notifications:
                    //f = new notificationFragment();
                    /*getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenedor, new NotificationsFragment())
                            .commit();*/
                    return true;
            }

            if (f != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contenedor, f)
                        .commit();
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Cargamos el Fragment por defectoooo !!!
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new CiudadItemFragment())
                .commit();
    }


    /*
    @Override
    public void onRestaurantClick(Restaurant restaurant) {
        Intent i = new Intent(this, DetalleRestauranteActivity.class);
        i.putExtra("nombre", restaurant.getName());
        startActivity(i);
    }
    */


}

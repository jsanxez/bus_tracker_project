package com.fragmental7.busappadmin;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class TrackActivity extends AppCompatActivity {
    EditText editDni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        // Toolbar:
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        editDni = findViewById(R.id.edit_dni_target);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_add_user) {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void startTracking(View view) {
        String dni = editDni.getText().toString();

        if (!dni.equals("")) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("dniTarget", dni);
            startActivity(intent);

        } else
            Toast.makeText(this, "DNI requerido", Toast.LENGTH_SHORT).show();
    }
}

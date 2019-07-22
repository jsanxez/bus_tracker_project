package com.fragmental7.busappadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference();
    private EditText etextDni;
    private EditText etextDestination;
    private EditText etextName;
    private EditText etextLastname;
    private EditText etextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        // Toolbar:
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etextDni = findViewById(R.id.etext_dni);
        etextDestination = findViewById(R.id.etext_destination);
        etextName = findViewById(R.id.etext_name);
        etextLastname = findViewById(R.id.etext_lastname);
        etextPhone = findViewById(R.id.etext_phone);

    }

    public void addUser(View view) {
        String dni = etextDni.getText().toString();

        if (!dni.equals("")) {
            int phone = Integer.parseInt(etextPhone.getText().toString());

            ref.child("usuarios").child(dni).setValue(new User(etextDestination.getText().toString(),etextName.getText().toString(),
                    etextLastname.getText().toString(), phone));

            Intent intent = new Intent(this, TrackActivity.class);
            startActivity(intent);

        } else
            Toast.makeText(this, "Todos los campos requeridos", Toast.LENGTH_SHORT).show();
    }

    /*public void updateUser() {
        String dni = etextDni.getText().toString();

        Map<String, Object> map = new HashMap<>();
        map.put("latitude", 27);
        map.put("longitude", 40);
        ref.child("usuarios").child(dni).updateChildren(map);
    }*/

    public void startTracking(View view) {
        String dni = etextDni.getText().toString();
        String name = etextName.getText().toString();
        String lastname = etextLastname.getText().toString();
        String phone = etextPhone.getText().toString();
        Intent intent = new Intent(this, TrackActivity.class);

        if (!dni.equals("")) {
            intent.putExtra("dni", dni);
            intent.putExtra("name", name);
            intent.putExtra("lastname", lastname);
            intent.putExtra("phone", phone);
            startActivity(intent);

        } else {
            /*String manufacturer = Build.MANUFACTURER;
            String model = Build.MODEL;
            String serial = Build.
            Toast.makeText(this, "Llene todos los campos: ", Toast.LENGTH_SHORT).show();*/
        }

    }
}

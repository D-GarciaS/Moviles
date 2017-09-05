package com.example.damiangarcia.tarea1;

import android.content.res.Resources;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.damiangarcia.tarea1.Beans.Alumno;

public class ActivityMain extends AppCompatActivity {

    Alumno alumno;

    Button btn_limpiar;

    EditText edit_Nombre;
    EditText edit_Telefono;
    Spinner spn_Escolaridad;

    RadioGroup rdg_Genero;
    RadioButton rd_Femenino;
    RadioButton rd_Masculino;
    AutoCompleteTextView actv_Libro;
    CheckBox chb_Deporte;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.savemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Menu_Guardar:
                updateAlumno();
                Toast t = Toast.makeText(getApplicationContext(), alumno.toString(),Toast.LENGTH_SHORT);
                t.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateAlumno(){
        alumno.setNombre(edit_Nombre.getText().toString());
        alumno.setTelefono(edit_Telefono.getText().toString());
        alumno.setEscolaridad(spn_Escolaridad.getSelectedItem().toString());
        alumno.setGenero(rd_Femenino.isChecked()? "Femenino" : "Masculino");
        alumno.setLibroFavorito(actv_Libro.getText().toString());
        alumno.setPracticaDeporte(chb_Deporte.isChecked());
        Log.d("ASD",alumno.toString());
    }

    private void updateForm(){
        edit_Nombre.setText(alumno.getNombre());
        edit_Telefono.setText(alumno.getTelefono());
        spn_Escolaridad.setSelection(spn_Escolaridad.getSelectedItemPosition());
        rd_Femenino.setChecked(true);
        rd_Masculino.setChecked(false);
        actv_Libro.setText("");
        chb_Deporte.setChecked(false);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString("Nombre",btn_limpiar.getText().toString());
        savedInstanceState.putString("Telefono",edit_Telefono.getText().toString());
        savedInstanceState.putInt("Escolaridad",spn_Escolaridad.getSelectedItemPosition());
        savedInstanceState.putBoolean("Femenino",rd_Femenino.isChecked());
        savedInstanceState.putBoolean("Masculino",rd_Masculino.isChecked());
        savedInstanceState.putString("Libro",actv_Libro.getText().toString());
        savedInstanceState.putBoolean("Deporte",chb_Deporte.isChecked());

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        btn_limpiar.setText(savedInstanceState.getString("Nombre"));
        edit_Telefono.setText(savedInstanceState.getString("Telefono"));
        spn_Escolaridad.setSelection(savedInstanceState.getInt("Escolaridad"));
        rd_Femenino.setChecked(savedInstanceState.getBoolean("Femenino"));
        rd_Masculino.setChecked(savedInstanceState.getBoolean("Masculino"));
        actv_Libro.setText(savedInstanceState.getString("Libro"));
        chb_Deporte.setChecked(savedInstanceState.getBoolean("Deporte"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        alumno = new Alumno();

        btn_limpiar = (Button) findViewById(R.id.ActivityMain_Limpiar);
        edit_Nombre = (EditText) findViewById(R.id.ActivityMain_Nombre);
        edit_Telefono = (EditText) findViewById(R.id.ActivityMain_Telefono);
        spn_Escolaridad = (Spinner) findViewById(R.id.ActivityMain_Escolaridad);
        rdg_Genero = (RadioGroup) findViewById(R.id.ActivityMain_Radio);
        rd_Femenino = (RadioButton) findViewById(R.id.ActivityMain_Femenino);
        rd_Masculino = (RadioButton) findViewById(R.id.ActivityMain_Masculino);
        actv_Libro = (AutoCompleteTextView) findViewById(R.id.ActivityMain_Libro);
        chb_Deporte = (CheckBox) findViewById(R.id.ActivityMain_Deporte);

        Resources res = getResources();
        String []libros= res.getStringArray(R.array.bookItems);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_dropdown_item_1line,libros);
        actv_Libro.setAdapter(adapter);
        actv_Libro.setThreshold(1);


        btn_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_Nombre.setText("");
                edit_Telefono.setText("");
                spn_Escolaridad.setSelection(0);
                rd_Femenino.setChecked(true);
                rd_Masculino.setChecked(false);
                actv_Libro.setText("");
                chb_Deporte.setChecked(false);
            }
        });
    }
}

***************Main Java*******************
package com.example.fragmentos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       boton=findViewById(R.id.boton);
       boton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               abrirFragmento();
           }
       });
    }

    private void abrirFragmento()
    {
        Longitud fragmento = new Longitud();//constructor del fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.marco,fragmento)
                .commit();

    }
}

****************Longitud Java**********************************

package com.example.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Longitud extends Fragment {

EditText et;
Spinner spinner;
TextView cm, mts, inch;
ArrayAdapter adapter;
String tvout, sel="cm";
Double cmf, mtsf, inchf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view= inflater.inflate(R.layout.fragment_longitud, container, false);
        //codigo de conversion
        et=view.findViewById(R.id.unidades);
        cm=view.findViewById(R.id.cm);
        mts=view.findViewById(R.id.mts);
        inch=view.findViewById(R.id.inch);
        spinner=view.findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this.getActivity(),
                R.array.unidades,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

}

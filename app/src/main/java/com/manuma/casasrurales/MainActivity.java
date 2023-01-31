package com.manuma.casasrurales;

import static java.time.LocalDate.now;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinnerA;
    Spinner spinnerAdultos;
    Spinner spinnerNinios;
    ImageButton botondesde;
    ImageButton botonHasta;
    ImageButton envio;
    TextView desde;
    TextView hasta;
    static int diaDesde;
    static int mesDesde;
    static int anioDesde;
    static int diaHasta;
    static int mesHasta;
    static int anioHasta;

    Reserva miReserva = new Reserva();

    Toast toast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botondesde = (ImageButton) findViewById(R.id.botonDesde);
        botonHasta = (ImageButton) findViewById(R.id.botonHasta);
        envio = (ImageButton) findViewById(R.id.botonEnvio);
        desde = (TextView) findViewById(R.id.vistaDesde);
        hasta = (TextView) findViewById(R.id.vistaHasta);


        spinnerA = (Spinner) findViewById(R.id.tipalojamiento);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipos_alojamientos, android.R.layout.simple_spinner_item);
        spinnerA.setAdapter(adapter);

        spinnerAdultos = (Spinner) findViewById(R.id.spinnerAdultos);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.num_adultos, android.R.layout.simple_spinner_item);
        spinnerAdultos.setAdapter(adapter1);

        spinnerNinios = (Spinner) findViewById(R.id.spinnerNinios);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.num_ninios, android.R.layout.simple_spinner_item);
        spinnerNinios.setAdapter(adapter2);
        botondesde.setOnClickListener((View.OnClickListener) this);
        botonHasta.setOnClickListener((View.OnClickListener) this);
        //   ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,)
        int diaDesde= 0;
        int mesDesde=0;
        int anioDesde=0;
        int diaHasta=0;
        int mesHasta=0;
        int anioHasta=0;
        miReserva.setFechaHasta(null);
        miReserva.setFechaDesde(null);
        miReserva.setNumNinios(null);
        miReserva.setNumAdultos(null);
        miReserva.setTipoAlojamiento(null);

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if (view == botonHasta) {
            final Calendar c = Calendar.getInstance();
            diaHasta = c.get(Calendar.DAY_OF_MONTH);
            mesHasta = c.get(Calendar.MONTH);
            anioHasta = c.get(Calendar.YEAR);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int Year, int monthOfYear, int dayOfMonth) {


                    hasta.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+Year);
                    diaHasta=dayOfMonth;
                    mesHasta=(monthOfYear+1);
                    anioHasta=Year;


                }
            }
                    ,anioHasta,mesHasta,diaHasta);
            datePickerDialog.show();
        }
        if (view == botondesde) {
            final Calendar c = Calendar.getInstance();
            diaDesde= c.get(Calendar.DAY_OF_MONTH);
            mesDesde= c.get(Calendar.MONTH);
            anioDesde = c.get(Calendar.YEAR);

            Calendar hoy=Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int Year, int monthOfYear, int dayOfMonth) {

                    if(Year<hoy.get(Calendar.YEAR)){
                        Context context = getApplicationContext();
                        CharSequence text = "Elige una fecha como minimo al dia de hoy";
                        int duration = Toast.LENGTH_SHORT;
                        toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }else if(Year==hoy.get(Calendar.YEAR)){
                        if(monthOfYear < hoy.get(Calendar.MONTH)){
                            Context context = getApplicationContext();
                            CharSequence text = "Elige una fecha como minimo al dia de hoy";
                            int duration = Toast.LENGTH_SHORT;
                            toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                        else if(monthOfYear == hoy.get(Calendar.MONTH)){
                            if(dayOfMonth<hoy.get(Calendar.DAY_OF_MONTH)){

                                Context context = getApplicationContext();
                                CharSequence text = "Elige una fecha como minimo al dia de hoy";
                                int duration = Toast.LENGTH_SHORT;
                                toast = Toast.makeText(context, text, duration);
                                toast.show();

                            }
                            else{
                                desde.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+Year);
                                diaDesde=dayOfMonth;
                                mesDesde=(monthOfYear+1);
                                anioDesde=Year;
                            }

                        }
                        else {
                            desde.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+Year);
                            diaDesde=dayOfMonth;
                            mesDesde=(monthOfYear+1);
                            anioDesde=Year;

                        }

                    }
                    else{
                        desde.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+Year);
                        diaDesde=dayOfMonth;
                        mesDesde=(monthOfYear+1);
                        anioDesde=Year;
                    }




                }
            }
                    ,anioDesde,mesDesde,diaDesde);
            datePickerDialog.show();
        }

        if (view == envio) {

            if (spinnerA.getSelectedItem().toString().equals("Alojamientos")) {
                Context context = getApplicationContext();
                CharSequence text = "Elige un tipo de alojamiento";
                int duration = Toast.LENGTH_SHORT;
                toast = Toast.makeText(context, text, duration);
                toast.show();

            } else {
                miReserva.setTipoAlojamiento(spinnerA.getSelectedItem().toString());

                if (spinnerAdultos.getSelectedItem().toString().equals("Adultos")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Minimo tiene que haber un adulto";
                    int duration = Toast.LENGTH_SHORT;
                    toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    miReserva.setNumAdultos(spinnerAdultos.getSelectedItem().toString());

                    if (spinnerNinios.getSelectedItem().toString().equals("num_ninios")) {
                        Context context = getApplicationContext();
                        CharSequence text = "elije una cantidad posible de niños";
                        int duration = Toast.LENGTH_SHORT;
                        toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {
                        miReserva.setNumNinios(spinnerNinios.getSelectedItem().toString());

                        if (!comparafechas(anioDesde, anioHasta, mesDesde, mesHasta, diaDesde, diaHasta)) {
                            if(anioDesde==anioHasta && mesHasta==mesDesde && diaHasta==diaDesde ){
                                Context context = getApplicationContext();
                                CharSequence text = "Almenos tiene que haber un dia de diferencia entre entrada y salida";
                                int duration = Toast.LENGTH_SHORT;
                                toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                            else {
                                Context context = getApplicationContext();
                                CharSequence text = "La fecha de salida no puede ser inferior a la de entrada";
                                int duration = Toast.LENGTH_SHORT;
                                toast = Toast.makeText(context, text, duration);
                                toast.show();


                            }




                        }
                        else{
                        miReserva.setFechaDesde(desde.getText().toString());
                        miReserva.setFechaHasta(hasta.getText().toString());
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("datos", miReserva);
                        intent.putExtras(bundle);
                        startActivity(intent);


                    }}

                }


            }

        }
    }




            public static boolean comparafechas(int anioDesde, int anioHasta, int mesDesde,
                                         int mesHasta, int diaDesde, int diaHasta)
            {
                boolean es;
                if (anioHasta < anioDesde) {
                    es = false;


                } else if (anioHasta == anioDesde) {

                    if (mesHasta < mesDesde) {

                        es = false;
                    } else if (mesHasta == mesDesde) {
                        if (diaHasta < diaDesde) {

                            es = false;
                        }
                        else if(diaHasta==diaDesde){

                            es = false;

                        }
                        else{
                            es=true;
                        }
                    } else {
                        es = true;
                    }

                }else{
                    es = true;}



                return es;
            }
}
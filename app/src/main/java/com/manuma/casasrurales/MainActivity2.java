package com.manuma.casasrurales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView alojamientos, adultos,ninios, fDesde,fHasta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        alojamientos=(TextView) findViewById(R.id.vistaAlojamiento);
        adultos=(TextView) findViewById(R.id.vistaAdultos);
        ninios=(TextView) findViewById(R.id.vistaNinios);
        fDesde=(TextView) findViewById(R.id.fechaDesde);
        fHasta=(TextView) findViewById(R.id.fechaHasta);

        Bundle enviado=getIntent().getExtras();

        Reserva miReserva= (Reserva) enviado.getSerializable("datos");

        alojamientos.setText(miReserva.getTipoAlojamiento().toString());
        adultos.setText(miReserva.getNumAdultos().toString());
        ninios.setText(miReserva.getNumNinios().toString());
        fDesde.setText(miReserva.getFechaDesde().toString());
        fHasta.setText(miReserva.getFechaHasta().toString());





    }
}
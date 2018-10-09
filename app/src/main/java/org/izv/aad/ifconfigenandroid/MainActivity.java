package org.izv.aad.ifconfigenandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    String cadena = "ifconfig";
    Runtime rt = Runtime.getRuntime();
    Process proceso;
    Button bt1;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
    }

        public void Iniciar(View view) {
            bt1 = findViewById(R.id.bt1);

            try {
                proceso = rt.exec(cadena);
                InputStream is = proceso.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String linea;
                        try {
                            while ((linea = br.readline()) = !null) {
                                System.out.println(linea);
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                        }
                    }
                });
            }
        }
    }

}

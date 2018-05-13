package edu.anhanguera.calcularnota;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText txtProvaB1 = null;
	private EditText txtTrabB1 = null;
	private EditText txtProvaB2 = null;
	private EditText txtTrabB2 = null;
	private TextView lblMedia = null;
	private TextView lblResultado = null;
	private Button btnCalcular = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtProvaB1 = (EditText) findViewById(R.id.txtProvaB1);
        txtTrabB1 = (EditText) findViewById(R.id.txtTrabB1);
        
        txtProvaB2 = (EditText) findViewById(R.id.txtProvaB2);
        txtTrabB2 = (EditText) findViewById(R.id.txtTrabB2);
        
        lblMedia = (TextView) findViewById(R.id.lblMedia);
        lblMedia.setVisibility(View.GONE);
        
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        lblResultado.setVisibility(View.GONE);
        
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				float provaB1 = Float.parseFloat(txtProvaB1.getText().toString());
				float trabB1 = Float.parseFloat(txtTrabB1.getText().toString());
				
				float provaB2 = Float.parseFloat(txtProvaB2.getText().toString());
				float trabB2 = Float.parseFloat(txtTrabB2.getText().toString());
				
				float media = (float) (((provaB1 + trabB1) * 0.40) + ((provaB2 + trabB2) * 0.60));
				
				lblMedia.setText("Média: " + media);
				
				if (media >= 6)
					lblResultado.setText("Resultado: Aprovado");
				else
					lblResultado.setText("Resultado: Reprovado");
				
				lblMedia.setVisibility(View.VISIBLE);
				lblResultado.setVisibility(View.VISIBLE);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

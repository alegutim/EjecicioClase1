package mx.com.agutierrezm.ejecicioclase1;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_EDIT_ACTIVITY = 1;
    private TextView txttitulo_main;
    private TextView txtdescripcion_main;
    private CheckBox chkmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txttitulo_main = (TextView) findViewById(R.id.txttitulo_main);
        txtdescripcion_main = (TextView) findViewById(R.id.txtdescripcion_main);
        chkmain = (CheckBox) findViewById(R.id.chkmain);
        findViewById(R.id.btnedit_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),EditActivity.class);
                startActivityForResult(i,REQUEST_CODE_EDIT_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ( REQUEST_CODE_EDIT_ACTIVITY==requestCode && resultCode==RESULT_OK){
            String titulo = data.getExtras().getString("key_titulo","");
            String descripcion = data.getExtras().getString("key_descripcion","");
            Boolean checked = data.getExtras().getBoolean("key_checked",false);
            txttitulo_main.setText(titulo);
            txtdescripcion_main.setText(descripcion);
            chkmain.setChecked(checked);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

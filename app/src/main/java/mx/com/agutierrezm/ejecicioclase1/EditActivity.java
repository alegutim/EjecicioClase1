package mx.com.agutierrezm.ejecicioclase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText txttitulo_edit;
    private EditText txtdescripcion_edit;
    private CheckBox chkedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        txttitulo_edit = (EditText) findViewById(R.id.txttitulo_edit);
        txtdescripcion_edit = (EditText) findViewById(R.id.txtdescripcion_edit);
        chkedit = (CheckBox) findViewById(R.id.chkedit);
        findViewById(R.id.btnguardar_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("key_titulo",txttitulo_edit.getText().toString());
                i.putExtra("key_descripcion",txtdescripcion_edit.getText().toString());
                i.putExtra("key_checked",chkedit.isChecked());
                setResult(RESULT_OK,i);
                finish();
            }
        });

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

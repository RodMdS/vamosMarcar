package br.qxd.ufc.vamosmarcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText txtUsername, txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
    }

    public void proximaPagina(View v) {
        String newUsername = txtUsername.getText().toString();
        String newPhone = txtPhone.getText().toString();

        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("newUsername", newUsername);
        intent.putExtra("newPhone", newPhone);
        startActivity(intent);
    }
}

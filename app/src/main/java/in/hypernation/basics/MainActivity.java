package in.hypernation.basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    Button getBtn, setBtn;
    EditText editValue;
    TextView message;
    String mainKey;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getBtn = findViewById(R.id.getBtn);
        setBtn = findViewById(R.id.setBtn);
        editValue = findViewById(R.id.editValue);
        message = findViewById(R.id.textView);

        Context context = getApplicationContext();
        try {
            mainKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
        try {
            sharedPreferences = EncryptedSharedPreferences.create("users", mainKey, context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putString("DATA", editValue.getText().toString()).apply();
                Toast.makeText(getApplicationContext(), "Data Entered", Toast.LENGTH_LONG).show();
            }
        });

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = sharedPreferences.getString("DATA", "0");
                message.setText(value);
            }
        });

    }
}
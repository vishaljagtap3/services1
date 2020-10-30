package in.bitcode.services1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtFilePath;
    private Button mBtnStart, mBtnStop;
    private Button mBtnStartMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "onNewIntent()", Toast.LENGTH_LONG).show();
    }

    private void init() {
        mEdtFilePath = findViewById(R.id.edtFilePath);
        mBtnStart = findViewById(R.id.btnStart);
        mBtnStop = findViewById(R.id.btnStop);
        mBtnStartMainActivity = findViewById(R.id.btnStartMain);

        mBtnStart.setOnClickListener(new BtnStartClickListener());
        mBtnStop.setOnClickListener(new BtnStopClickListener());

        mBtnStartMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private class BtnStartClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, AudioService.class);
            startService(intent);
        }
    }

    private class BtnStopClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, AudioService.class);
            stopService(intent);
        }
    }


}
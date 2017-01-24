package dataputextra.nayan.com.phonecallbyputextra;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.telephony.PhoneNumberUtils.formatNumber;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,btnstar,btnhas,call;
    private ImageButton clear;
    private EditText screen;
    private static final int PERMISSIONS_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allfind();
        parmition_Alow();
        allOnclick();
    }


    private void allfind() {
        screen = (EditText) findViewById(R.id.Display);
        btn0 = (Button) findViewById(R.id.btnZiro);
        btn1 = (Button) findViewById(R.id.btnOne);
        btn2 = (Button) findViewById(R.id.btnTwo);
        btn3 = (Button) findViewById(R.id.btnThree);
        btn4 = (Button) findViewById(R.id.btnFour);
        btn5 = (Button) findViewById(R.id.btnFive);
        btn6 = (Button) findViewById(R.id.btnSix);
        btn7 = (Button) findViewById(R.id.btnSeven);
        btn8 = (Button) findViewById(R.id.btnEight);
        btn9 = (Button) findViewById(R.id.btnNine);
        btnstar = (Button) findViewById(R.id.btnStar);
        btnhas = (Button) findViewById(R.id.btnHas);
        clear = (ImageButton) findViewById(R.id.imgbtnClear);
        call = (Button) findViewById(R.id.btnCall);
    }

    private void allOnclick() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnstar.setOnClickListener(this);
        btnhas.setOnClickListener(this);
        clear.setOnClickListener(this);
        call.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnZiro:
                display("0");
                break;
            case R.id.btnOne:
                display("1");
                break;
            case R.id.btnTwo:
                display("2");
                break;
            case R.id.btnThree:
                display("3");
                break;
            case R.id.btnFour:
                display("4");
                break;
            case R.id.btnFive:
                display("5");
                break;
            case R.id.btnSix:
                display("6");
                break;
            case R.id.btnSeven:
                display("7");
                break;
            case R.id.btnEight:
                display("8");
                break;
            case R.id.btnNine:
                display("9");
                break;
            case R.id.btnStar:
                display("*");
                break;
            case R.id.btnHas:
                display("#");
                break;
            case R.id.imgbtnClear:
                clear();
                break;
            case R.id.btnCall:
                call();
                break;
        }
    }

    private void call() {
        if (screen.getText().toString().isEmpty()) {
            Toast.makeText(this, "Empty digits", Toast.LENGTH_LONG).show();
        } else {
            String mobileNumber = screen.getText().toString().trim();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+mobileNumber));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);
        }
    }

    private void clear() {
        int screenlength = screen.getText().toString().length();
        if (screenlength >0) {
            String newscreen = screen.getText().toString().substring(0,screenlength-1);
            screen.setText(newscreen);
        }
    }
    private void  parmition_Alow(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},PERMISSIONS_REQUEST);
            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},PERMISSIONS_REQUEST);
            }
        }

    }

    private void display(String val) {
        screen.append(val);
    }

}

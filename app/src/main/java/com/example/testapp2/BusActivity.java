package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp2.databinding.ActivityBusBinding;

import java.util.Date;

public class BusActivity extends AppCompatActivity implements InputFragment2.onSomeEventListener{

    public ActivityBusBinding binding;
    Fragment fragment_text2 = new TextFragment2();
    Fragment fragment_input2 = new InputFragment2();
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        binding = ActivityBusBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        long date = getIntent().getExtras().getLong("time");
        Date dat = new Date(date);
        binding.textView4.setText(dat.toString());
        Button backButton = binding.button4;
        transaction.add(binding.fragmentContainerView2.getId(),fragment_input2);
        transaction.add(binding.fragmentContainerView3.getId(),fragment_text2);
        transaction.commit();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = fragment_text2.getView().findViewById(R.id.textView3);
                String txt = textView.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("txt",txt);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    public void someEvent(String txt) {
        TextView textView = fragment_text2.getView().findViewById(R.id.textView3);
        textView.setText(txt);
    }
}
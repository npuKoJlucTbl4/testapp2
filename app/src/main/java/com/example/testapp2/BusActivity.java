package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapp2.databinding.ActivityBusBinding;

public class BusActivity extends AppCompatActivity {

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
        Button backButton = binding.button4;
        transaction.add(binding.fragmentContainerView2.getId(),fragment_input2);
        transaction.add(binding.fragmentContainerView3.getId(),fragment_text2);
        transaction.commit();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
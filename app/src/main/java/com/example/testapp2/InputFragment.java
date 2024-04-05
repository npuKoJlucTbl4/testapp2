package com.example.testapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.testapp2.databinding.FragmentInputBinding;

import org.greenrobot.eventbus.EventBus;

public class InputFragment extends Fragment {

    public FragmentInputBinding binding;
    public InputFragment() {
        super(R.layout.fragment_input);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentInputBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        Button button = binding.buutton;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Aboba(binding.editText.getText().toString()));
            }
        });
        return v;
    }
}
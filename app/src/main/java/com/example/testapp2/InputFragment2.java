package com.example.testapp2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testapp2.databinding.FragmentInput2Binding;

public class InputFragment2 extends Fragment {

    public FragmentInput2Binding binding;
    public interface onSomeEventListener {
        public void someEvent(String s);
    }

    onSomeEventListener someEventListener;
    public InputFragment2() {
        super(R.layout.fragment_input2);
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInput2Binding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        Button button = binding.button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                someEventListener.someEvent(binding.editTextText.getText().toString());
            }
        });

        return v;
    }
}
package com.example.testapp2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.testapp2.databinding.InterfaceInnerBinding;

public class InnerInterface extends Fragment {
    public InterfaceInnerBinding binding;
    private Interface callback;
    public interface Interface
    {
        void ButtonClick1(View view);
        void ButtonClick2(View view);
    }

    public InnerInterface() {
        super(R.layout.interface_inner);
    }

    @Override
    public void onAttach(@NonNull Context Context) {
        super.onAttach(Context);
        try {
            callback = (Interface) Context;
        } catch (ClassCastException e) {
            throw new ClassCastException("err");
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = InterfaceInnerBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        Button button1 = binding.button1;
        Button button2 = binding.button2;
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callback.ButtonClick1(v);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callback.ButtonClick2(v);
            }
        });


        return v;
    }
}

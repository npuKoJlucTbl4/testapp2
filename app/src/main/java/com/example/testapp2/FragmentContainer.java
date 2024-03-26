package com.example.testapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testapp2.databinding.FragmentContainerBinding;

public class FragmentContainer extends Fragment {

    public FragmentContainer() {
        super(R.layout.fragment_container);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentContainerBinding binding = FragmentContainerBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        Button backButton = binding.button3;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
        return v;
    }
}
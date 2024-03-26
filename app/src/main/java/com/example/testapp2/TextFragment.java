package com.example.testapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.testapp2.databinding.FragmentTextBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TextFragment extends Fragment {

    public FragmentTextBinding binding;
    public TextFragment() {
        super(R.layout.fragment_text);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTextBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        EventBus.getDefault().register(this);
        return v;
    }

    @Subscribe
    public void doThis(Aboba aboba) {
        binding.textView2.setText(aboba.text);
    }
}
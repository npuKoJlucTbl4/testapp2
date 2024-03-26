package com.example.testapp2;

import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {
    public interface InputInterface {
        String SetText();
    }
    public InputFragment() {
        super(R.layout.fragment_input);
    }
}
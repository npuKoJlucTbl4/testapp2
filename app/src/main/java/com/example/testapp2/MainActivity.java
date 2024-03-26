package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testapp2.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements InnerInterface.Interface
{

    public ActivityMainBinding binding;
    Fragment fragment_blank = new FragmentContainer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void setContainerView(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        transaction.replace(binding.fragmentContainerView.getId(), fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void ButtonClick1(View v)
    {
        setContainerView(fragment_blank);
    }
    @Override
    public void ButtonClick2(View v)
    {
        Intent intent = new Intent(this, BusActivity.class);
        startActivity(intent);
    }
}
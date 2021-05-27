package com.example.obuza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;

import com.example.obuza.databinding.ActivityMainCBinding;

public class MainActivity extends AppCompatActivity {
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainCBinding binding = ActivityMainCBinding.inflate(getLayoutInflater());
        binding.setActivityMain(this);
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    public void Change (View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.button:
                fragment = new FragmentOne();
                break;
            case R.id.button2:
                fragment = new FragmentTwo();
                break;
            case R.id.button3:
                fragment = new FragmentThree();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_place, fragment);
        ft.commit();
    }

    public void changeSection(int sectionId) {
        switch (sectionId) {
            case 0: navController.navigate(R.id.fragmentOne); break;
            case 1: navController.navigate(R.id.fragmentTwo); break;
//            case 2: navController.navigate(R.id.fragmentThree); break;
        }
    }
}
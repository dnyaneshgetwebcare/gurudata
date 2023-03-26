package com.example.gurudata;

import android.content.Intent;
import android.os.Bundle;

import com.example.gurudata.db.DatabaseApplication;
import com.example.gurudata.ui.AddDriver;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.gurudata.databinding.ActivityDriverManagementBinding;

public class DriverManagement extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDriverManagementBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDriverManagementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        final SwipeRefreshLayout pullToRefresh = binding.pullToRefresh;


   /*     NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_driver_management);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration); */
        String[] driver_name_list= DatabaseApplication.getInstance(getApplicationContext()).getMyDatabase().driverMasterDao().getName();
        final ListView driver_list=binding.listDriver;
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_list_view, driver_name_list);

        driver_list.setAdapter(adapter);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                driver_list.getAdapter().notifyAll();
            }
        });
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddDriver.class);
                startActivity(i);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_driver_management);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
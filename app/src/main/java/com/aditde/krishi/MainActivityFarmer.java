package com.aditde.krishi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aditde.krishi.databinding.ActivityMainFarmerBinding;
import com.aditde.krishi.models.Users;
import com.aditde.krishi.ui.fragments.cropinfo.Cotton;
import com.aditde.krishi.ui.fragments.cropinfo.Maize;
import com.aditde.krishi.ui.fragments.cropinfo.Millet;
import com.aditde.krishi.ui.fragments.cropinfo.Mustard;
import com.aditde.krishi.ui.fragments.cropinfo.Rice;
import com.aditde.krishi.ui.fragments.cropinfo.Sugarcane;
import com.aditde.krishi.ui.fragments.cropinfo.Tea;
import com.aditde.krishi.ui.fragments.cropinfo.Wheat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivityFarmer extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    ActivityMainFarmerBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainFarmerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab = findViewById(R.id.fab);    //todo
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View hView =  navigationView.getHeaderView(0);
        ImageView imgvw = (ImageView)hView.findViewById(R.id.profileImage);
        TextView tvUserName = (TextView)hView.findViewById(R.id.tvUserName);
        TextView tvEmail = (TextView)hView.findViewById(R.id.tvEmail);

        database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Users users = snapshot.getValue(Users.class);

                        //Glide.get().load(users.getProfilePic()).into(binding.profilePic);
                        Picasso.get().load(users.getProfilePic())
                                .placeholder(R.drawable.ic_baseline_person_24)
                                .into(imgvw);

                        tvUserName.setText("@"+users.getUserName());
                        tvEmail.setText(users.getEmail());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.newsFrag, R.id.reminderFrag, R.id.weatherFrag, R.id.cropInfoFrag, R.id.sellCropsFrag)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.main_activity_farmer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void editProfile(MenuItem item) {
        Intent intent = new Intent(MainActivityFarmer.this, EditProfile.class);
        startActivity(intent);
    }

    public void signOut(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Signed Out Successfully!", Toast.LENGTH_LONG).show();
        auth.signOut();
        Intent intent = new Intent(MainActivityFarmer.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    public void gotoSettings(MenuItem item) {

        Intent intent = new Intent(MainActivityFarmer.this, Settings.class);
        startActivity(intent);

    }

    public void rice(View view) {
        Intent intent = new Intent(MainActivityFarmer.this,Rice.class);
        startActivity(intent);
    }

    public void wheat(View view) {
        Intent intent = new Intent(MainActivityFarmer.this,Wheat.class);
        startActivity(intent);
    }

    public void maize(View view) {
        Intent intent = new Intent(MainActivityFarmer.this,Maize.class);
        startActivity(intent);
    }

    public void cotton(View view) {
        Intent intent = new Intent(MainActivityFarmer.this,Cotton.class);
        startActivity(intent);
    }

    public void sugarcane(View view) {
        Intent intent = new Intent(MainActivityFarmer.this,Sugarcane.class);
        startActivity(intent);
    }

    public void millet(View view) {
        Intent intent = new Intent(MainActivityFarmer.this,Millet.class);
        startActivity(intent);
    }

    public void tea(View view) {
        Intent intent = new Intent(MainActivityFarmer.this,Tea.class);
        startActivity(intent);
    }

    public void mustard(View view) {
        Intent intent = new Intent(MainActivityFarmer.this,Mustard.class);
        startActivity(intent);
    }

}
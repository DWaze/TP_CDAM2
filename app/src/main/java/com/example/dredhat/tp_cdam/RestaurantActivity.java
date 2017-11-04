package com.example.dredhat.tp_cdam;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class RestaurantActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(GoogleMaterial.Icon.gmd_home);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Actions").withIcon(GoogleMaterial.Icon.gmd_note_add);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(2).withName("Auto").withIcon(GoogleMaterial.Icon.gmd_flash_auto);
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(2).withName("Create User").withIcon(GoogleMaterial.Icon.gmd_person_add);
        SecondaryDrawerItem item5 = new SecondaryDrawerItem().withIdentifier(2).withName("Settings").withIcon(GoogleMaterial.Icon.gmd_settings);

        fragmentManager = getSupportFragmentManager();
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.rlayout_bg)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.drawable.app_icon))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        new DividerDrawerItem(),
                        item5
                ).build();

        result.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                if (position == 1){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fRestaurant,  new ContainerFragment())
                            .commit();
                    result.closeDrawer();
                }
                //                            startActivity(new Intent(Rooms.this,Rooms.class));
                if (position == 2){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fRestaurant, new FirstFragment())
                            .commit();
                    result.closeDrawer();
                }
//                            getSupportFragmentManager().beginTransaction().replace(R.id.f1,new FirstFragment()).commit();
                if (position == 4) {
                    Toast.makeText(getApplicationContext(), "Item number : " + position + " clicked", Toast.LENGTH_LONG).show();
//                            startActivity(new Intent(Rooms.this,Inscription.class));
                }
                return true;
            }
        });
        result.setSelection(1);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fRestaurant,  new ContainerFragment())
                .commit();
    }


}

package com.example.cybertech2.timee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cybertech2.timee.Adapters.PagerAdapter;
import com.example.cybertech2.timee.Adapters.RecyclerAdapter;

import static com.example.cybertech2.timee.R.layout.activity_home;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {


   protected BottomNavigationView bottomNavigationView;
   private TabLayout tabLayout;

   boolean doubleBackPressedExitOnce = false;
   private  EditText editText;

    ViewPager viewPager;

    TextView textView;


//    RecyclerAdapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_home);
        viewPager = findViewById(R.id.pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        tabLayout = findViewById(R.id.tabs);
//        recyclerView = findViewById(R.id.recyclerView);
//        layoutManager = new GridLayoutManager(this,2);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(layoutManager);


        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));

        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
         //   viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
          //  viewPager.setCurrentItem(tab.getPosition());
            }
        });

//            adapter = new RecyclerAdapter(images,textView);
//            recyclerView.setAdapter(adapter);


        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationVIewHide());

        BottomNavigationViewHalper.disableShiftMode(bottomNavigationView);
              bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_item1:
                      //Refresh e anum HomeActivity-in
                        finish();
                        startActivity(getIntent());
                        return true;
                    case R.id.action_item2:
                        Intent Second= new Intent(HomeActivity.this,HiRatesActivity.class);
                        startActivity(Second);
                        break;
                    case R.id.action_item3:
                        Intent Third= new Intent(HomeActivity.this,FavoritesActivity.class);
                        startActivity(Third);
                        break;
                }

                return true;
            }
        });


        Toolbar toolbar =  findViewById(R.id.toolbarNavigaqtion);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
//        moveTaskToBack(true);
        if (doubleBackPressedExitOnce){
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
            super.onBackPressed();
            return;
        }
//        count++;


        this.doubleBackPressedExitOnce = true;
        Toast.makeText(this,"press agein to exit",Toast.LENGTH_SHORT).show();

//        if (count == 3) {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackPressedExitOnce =false;
                }
            }, 2000);
        }
//    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        //getMenuInflater().inflate(R.menu.search,menu);
        getMenuInflater().inflate(R.menu.span_count,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            viewPager.setCurrentItem(0);
            return true;
                    }

       else if (id == R.id.action_settings1) {
            viewPager.setCurrentItem(1);
            return true;
        }


       else if (id == R.id.action_settings2) {
            viewPager.setCurrentItem(2);
            return true;
        }

       else if (id == R.id.action_settings3) {
            viewPager.setCurrentItem(3);
            return true;
        }

       else if (id == R.id.action_settings4) {
            viewPager.setCurrentItem(4);
            return true;
        }


       else if (id == R.id.action_settings5) {
            viewPager.setCurrentItem(5);
            return true;
        }

       else if (id == R.id.action_settings6) {
            viewPager.setCurrentItem(6);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notifications) {
            Intent intent = new Intent(HomeActivity.this,NotificationsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_favorites) {
            Intent intent = new Intent(HomeActivity.this,FavoritesActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_hi_rates) {
            Intent intent = new Intent(HomeActivity.this,HiRatesActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_history) {
            Intent intent = new Intent(HomeActivity.this,HistoryActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings){
            Intent intent = new Intent(HomeActivity.this,SettingsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
//            sendIntent.putExtra(Intent.EXTRA_TEXT,editText.getText().toString());
            String sTatus = "\nԹույլ տվեք ձեզ խորհուրդ տալ այս հավելվածը\n\n";
            sTatus = sTatus + "https://play.google.com/store/apps/details?id=the.package.id \n\n";
            sendIntent.putExtra(Intent.EXTRA_TEXT, sTatus);
            sendIntent.setType("text/plain");
//            Intent.createChooser(sendIntent,"Share via");
            startActivity(Intent.createChooser(sendIntent, "Կիսվել"));

        } else if (id == R.id.nav_faq){
            Intent intent = new Intent(HomeActivity.this,FAQActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_about_us){
            Intent intent = new Intent(HomeActivity.this,AboutUsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {

            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.dialog_view,null);
            editText = alertLayout.findViewById(R.id.textViewDialog);
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
            {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
                {
                    String input;
                    if(actionId == EditorInfo.IME_ACTION_DONE)
                    {
                        input= v.getText().toString();
                     //  HomeActivity.calculate(input);
                        return true; // consume.
                    }
                    return false; // pass on to other listeners.
                }
            });
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener()
            {
                @Override
                public void onFocusChange(View v, boolean hasFocus)
                {
                    String input;
                    EditText editText;

                    if(!hasFocus)
                    {
                        editText= (EditText) v;
                        input= editText.getText().toString();
                     //   HomeActivity.calculate(input);
                    }
                }
            });
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            Dialog customDialog = new Dialog(this);
//            Window window = customDialog.getWindow();
//
            builder.setTitle("Կապ");
            builder.setMessage(R.string.contact_us);
            builder.setView(alertLayout);
//            editText.getGravity()= ;
            builder.setPositiveButton("Ուղարկել",null);
            builder.setNegativeButton("Չեղարկել",null);
            builder.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void setShareIntent(Intent shareIntent) {
//        if (mShareActionProvider != null) {
//            mShareActionProvider.setShareIntent(shareIntent);
//        }
//    }
}

package si.uni_lj.fri.lrk.tablayoutexample;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int NUM_OF_TABS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        configureTabLayout();
    }

    private void configureTabLayout(){

        // TODO: Implement tab-viewpager-adapter connection
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.view_pager2);

        final TabPagerAdapter tpa = new TabPagerAdapter(this, NUM_OF_TABS);
        viewPager2.setAdapter(tpa);

        new TabLayoutMediator(tabLayout, viewPager2,
            new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                    tpa.createFragment(position);
                    switch(position) {
                        case 0:
                            tab.setText("SKY OBSERVATIONS");
                            break;
                        case 1:
                            tab.setText("PLANET WIKI");
                            break;
                        default:
                            tab.setText("NOTES");
                            break;
                    }


                }
            }).attach();

    }

}

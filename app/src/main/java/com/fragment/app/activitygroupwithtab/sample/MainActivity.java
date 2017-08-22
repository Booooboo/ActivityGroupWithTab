package com.fragment.app.activitygroupwithtab.sample;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.hongbo.lib.activitygrouplib.ActivityGroup;
import com.hongbo.lib.activitygrouplib.Tab;
import com.hongbo.lib.activitygrouplib.TabBuilder;

/**
 * Created by sunhongbo on 17/8/21.
 */
public class MainActivity extends ActivityGroup implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_blank);
        TabBuilder builder = createTabBuilder();
        Tab tab = builder.newTab();
        tab.setId(R.id.tab_bar_wx)
                .setText(getString(R.string.wx))
                .setIcon(getResources().getDrawable(R.drawable.smile))
                .setClazz(Home.class);
        builder.addTab(tab);

        tab = builder.newTab();
        tab.setId(R.id.tab_bar_note)
                .setText(getString(R.string.note))
                .setIcon(getResources().getDrawable(R.drawable.viewlist))
                .setClazz(Note.class);
        builder.addTab(tab);

        tab = builder.newTab();
        tab.setId(R.id.tab_bar_friends)
                .setText(getString(R.string.friends))
                .setClazz(Friends.class)
                .setIcon(getResources().getDrawable(R.drawable.atm));
        builder.addTab(tab);

        tab = builder.newTab();
        tab.setId(R.id.tab_bar_me)
                .setText(getString(R.string.me))
                .setClazz(Me.class)
                .setIcon(getResources().getDrawable(R.drawable.account));
        builder.addTab(tab);

        builder.build();
    }

}

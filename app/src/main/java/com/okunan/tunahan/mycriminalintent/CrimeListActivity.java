package com.okunan.tunahan.mycriminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by TUNAHAN on 17.12.2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}

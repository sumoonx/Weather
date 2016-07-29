package cn.edu.seu.jeremy.weather.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author: Jeremy Xu on 2016/7/28 21:27
 * E-mail: jeremy_xm@163.com
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder mBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayout(), container, false);
        mBinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        mBinder.unbind();
        super.onDestroyView();
    }

    @LayoutRes
    protected abstract int getLayout();
}

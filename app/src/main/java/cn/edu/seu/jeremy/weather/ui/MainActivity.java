package cn.edu.seu.jeremy.weather.ui;

import android.support.annotation.Nullable;
import android.os.Bundle;

import cn.edu.seu.jeremy.weather.R;
import cn.edu.seu.jeremy.weather.WeatherApplication;
import cn.edu.seu.jeremy.weather.base.BaseActivity;
import cn.edu.seu.jeremy.weather.inject.component.ApiServiceComponent;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.main_content, WeatherFragment.newInstance())
                    .commit();
        }
    }

    public ApiServiceComponent getApiServiceComponent() {
        return ((WeatherApplication) getApplication()).getApiServiceComponent();
    }
}

package cn.edu.seu.jeremy.weather.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.seu.jeremy.weather.R;
import cn.edu.seu.jeremy.weather.base.BaseFragment;
import cn.edu.seu.jeremy.weather.contract.WeatherContract;
import cn.edu.seu.jeremy.weather.entity.WeatherInfo;
import cn.edu.seu.jeremy.weather.inject.component.DaggerWeatherComponent;
import cn.edu.seu.jeremy.weather.inject.module.WeatherPresenterModule;
import cn.edu.seu.jeremy.weather.presenter.WeatherPresenter;
import cn.edu.seu.jeremy.weather.ui.adapter.DailyAdapter;
import cn.edu.seu.jeremy.weather.ui.adapter.HourAdapter;
import cn.edu.seu.jeremy.weather.ui.adapter.SuggestionAdapter;
import cn.edu.seu.jeremy.weather.util.DateUtil;
import cn.edu.seu.jeremy.weather.util.ToastUtil;
import cn.edu.seu.jeremy.weather.util.UnitUtil;

/**
 * Author: Jeremy Xu on 2016/7/28 18:49
 * E-mail: jeremy_xm@163.com
 */
public class WeatherFragment extends BaseFragment implements WeatherContract.IView {

    @BindView(R.id.weather_brief_city)
    protected TextView mBriefCity;

    @BindView(R.id.weather_brief_cond)
    protected TextView mBriefCond;

    @BindView(R.id.weather_brief_temp)
    protected TextView mBriefTemp;

    @BindView(R.id.weather_today)
    TextView weatherToday;
    @BindView(R.id.weather_today_low_temp)
    TextView weatherTodayLowTemp;
    @BindView(R.id.weather_today_high_temp)
    TextView weatherTodayHighTemp;
    @BindView(R.id.hour_detail)
    RecyclerView hourDetail;
    @BindView(R.id.daily_detail)
    RecyclerView dailyDetail;
    @BindView(R.id.weather_today_suggestion)
    RecyclerView weatherTodaySuggestion;
    @BindView(R.id.sunrise_time)
    TextView sunriseTime;
    @BindView(R.id.sunset_time)
    TextView sunsetTime;
    @BindView(R.id.rain_probablity)
    TextView rainProbablity;
    @BindView(R.id.humidity)
    TextView humidity;
    @BindView(R.id.wind_speed)
    TextView windSpeed;
    @BindView(R.id.feel_temp)
    TextView feelTemp;
    @BindView(R.id.precipitation)
    TextView precipitation;
    @BindView(R.id.atmo_press)
    TextView atmoPress;
    @BindView(R.id.air_visiblity)
    TextView airVisiblity;

    private String mCity;

    @Inject
    protected WeatherPresenter presenter;

    @Inject
    public WeatherFragment() {
        mCity = "南京";
    }

    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DaggerWeatherComponent.builder()
                .apiServiceComponent(((MainActivity) getActivity()).getApiServiceComponent())
                .weatherPresenterModule(new WeatherPresenterModule(this))
                .build().inject(this);
        getWeather();
    }

    @Override
    public void renderWeather(WeatherInfo weather) {
        WeatherInfo.NowBean nowWeather = weather.getNow();
        String city = mCity + "市";
        mBriefCity.setText(city);
        mBriefCond.setText(nowWeather.getCond().getTxt());
        mBriefTemp.setText(nowWeather.getTmp());

        List<WeatherInfo.HourlyForecastBean> hourWeathers = weather.getHourlyForecast();
        HourAdapter hourAdapter = (HourAdapter) hourDetail.getAdapter();
        hourAdapter.setHours(hourWeathers);
        hourAdapter.notifyDataSetChanged();

        List<WeatherInfo.DailyForecastBean> dailyWeathers = weather.getDailyForecast();
        WeatherInfo.DailyForecastBean todayBean = dailyWeathers.get(0);
        weatherTodayHighTemp.setText(todayBean.getTmp().getMax());
        weatherTodayLowTemp.setText(todayBean.getTmp().getMin());

        sunriseTime.setText(todayBean.getAstro().getSr());
        sunsetTime.setText(todayBean.getAstro().getSs());
        rainProbablity.setText(UnitUtil.percentage(todayBean.getPop()));
        humidity.setText(UnitUtil.percentage(todayBean.getHum()));
        windSpeed.setText(UnitUtil.windSpeed(todayBean.getWind().getSpd()));
        feelTemp.setText(UnitUtil.temprature(nowWeather.getFl()));
        precipitation.setText(UnitUtil.centiMeter(todayBean.getPcpn()));
        atmoPress.setText(UnitUtil.windPress(todayBean.getPres()));
        airVisiblity.setText(UnitUtil.kiloMeter(todayBean.getVis()));

        dailyWeathers = dailyWeathers.subList(1, dailyWeathers.size());
        DailyAdapter dailyAdapter = (DailyAdapter) dailyDetail.getAdapter();
        dailyAdapter.setDailys(dailyWeathers);
        dailyAdapter.notifyDataSetChanged();

        WeatherInfo.SuggestionBean suggestionBean = weather.getSuggestion();
        SuggestionAdapter suggestionAdapter = (SuggestionAdapter) weatherTodaySuggestion.getAdapter();
        suggestionAdapter.setSuggestion(suggestionBean);
        suggestionAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        weatherToday.setText(DateUtil.getWeekString());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hourDetail.setLayoutManager(manager);
        hourDetail.setAdapter(new HourAdapter(null));

        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        dailyDetail.setLayoutManager(manager);
        dailyDetail.setAdapter(new DailyAdapter(null));

        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        weatherTodaySuggestion.setLayoutManager(manager);
        weatherTodaySuggestion.setAdapter(new SuggestionAdapter(getActivity(), null));
        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String error) {
        ToastUtil.show(getActivity(), error);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_weather;
    }

    private void getWeather() {
        presenter.updateWeather(mCity);
    }
}

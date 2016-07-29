package cn.edu.seu.jeremy.weather.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.seu.jeremy.weather.R;
import cn.edu.seu.jeremy.weather.entity.WeatherInfo;
import cn.edu.seu.jeremy.weather.util.DateUtil;

/**
 * Author: Jeremy Xu on 2016/7/29 17:00
 * E-mail: jeremy_xm@163.com
 */
public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> {

    private List<WeatherInfo.DailyForecastBean> mDailyBeans;

    private List<String> mWeeks;

    public DailyAdapter(List<WeatherInfo.DailyForecastBean> dailyBeans) {
        setDailys(dailyBeans);
        mWeeks = DateUtil.getNextSixDay();
    }

    public void setDailys(List<WeatherInfo.DailyForecastBean> dailyBeans) {
        mDailyBeans = dailyBeans;
    }

    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.daily_item, parent, false);
        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyViewHolder holder, int position) {
        WeatherInfo.DailyForecastBean bean = mDailyBeans.get(position);
        holder.weatherTodayText.setText(mWeeks.get(position));
        holder.weatherTodayCond.setText(bean.getCond().getTxtD());
        holder.weatherTodayHighTemp.setText(bean.getTmp().getMax());
        holder.weatherTodayLowTemp.setText(bean.getTmp().getMin());
    }

    @Override
    public int getItemCount() {
        if (mDailyBeans == null)    return 0;
        return mDailyBeans.size();
    }

    static class DailyViewHolder extends RecyclerView.ViewHolder {

        private TextView weatherTodayText;

        private TextView weatherTodayCond;

        private TextView weatherTodayLowTemp;

        private TextView weatherTodayHighTemp;

        public DailyViewHolder(View view) {
            super(view);
            weatherTodayText = (TextView) view.findViewById(R.id.weather_today_text);
            weatherTodayCond = (TextView) view.findViewById(R.id.weather_today_cond);
            weatherTodayLowTemp = (TextView) view.findViewById(R.id.weather_today_low_temp);
            weatherTodayHighTemp = (TextView) view.findViewById(R.id.weather_today_high_temp);
        }
    }
}

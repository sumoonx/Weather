package cn.edu.seu.jeremy.weather.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.seu.jeremy.weather.R;
import cn.edu.seu.jeremy.weather.entity.WeatherInfo;
import cn.edu.seu.jeremy.weather.util.LogUtil;
import cn.edu.seu.jeremy.weather.util.UnitUtil;

/**
 * Author: Jeremy Xu on 2016/7/29 15:35
 * E-mail: jeremy_xm@163.com
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private List<WeatherInfo.HourlyForecastBean> mHours;

    public HourAdapter(List<WeatherInfo.HourlyForecastBean> hours) {
        mHours = hours;
    }

    public void setHours(List<WeatherInfo.HourlyForecastBean> hours) {
        mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.hour_item, parent, false);
        return new HourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        if (mHours == null) return;
        WeatherInfo.HourlyForecastBean bean = mHours.get(position);
        String hour = bean.getDate().split(" ")[1].split(":")[0] + "时";
        holder.hourText.setText(hour);
        holder.hourWeatherCond.setText(UnitUtil.percentage(bean.getPop()));
        holder.hourTemp.setText(bean.getTmp());
    }

    @Override
    public int getItemCount() {
        if (mHours == null) return 0;
        return mHours.size();
    }

    static class HourViewHolder extends RecyclerView.ViewHolder {

        private TextView hourText;

        private TextView hourWeatherCond;

        private TextView hourTemp;

        public HourViewHolder(View view) {
            super(view);
            hourText = (TextView) view.findViewById(R.id.hour_text);
            hourWeatherCond = (TextView) view.findViewById(R.id.hour_weather_cond);
            hourTemp = (TextView) view.findViewById(R.id.hour_temp);
        }
    }
}

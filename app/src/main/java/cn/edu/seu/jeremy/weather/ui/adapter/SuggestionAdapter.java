package cn.edu.seu.jeremy.weather.ui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.edu.seu.jeremy.weather.R;
import cn.edu.seu.jeremy.weather.entity.WeatherInfo;

/**
 * Author: Jeremy Xu on 2016/7/29 17:53
 * E-mail: jeremy_xm@163.com
 */
public class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.SuggestionViewHolder> {

    private Context mContext;

    private List<String> mTitles = new ArrayList<>();

    private List<String> mSuggestions = new ArrayList<>();

    public SuggestionAdapter(Context context, WeatherInfo.SuggestionBean suggestion) {
        mContext = context;
        setSuggestion(suggestion);
    }

    public void setSuggestion(WeatherInfo.SuggestionBean suggestion) {
        mTitles.add(mContext.getString(R.string.dress_index));
        mTitles.add(mContext.getString(R.string.uv_index));
        mTitles.add(mContext.getString(R.string.warsh_car_index));
        mTitles.add(mContext.getString(R.string.travel_index));
        mTitles.add(mContext.getString(R.string.flu_index));
        mTitles.add(mContext.getString(R.string.sport_index));

        if (suggestion != null) {
            mSuggestions.clear();
            mSuggestions.add(suggestion.getDrsg().getTxt());
            mSuggestions.add(suggestion.getUv().getTxt());
            mSuggestions.add(suggestion.getCw().getTxt());
            mSuggestions.add(suggestion.getTrav().getTxt());
            mSuggestions.add(suggestion.getFlu().getTxt());
            mSuggestions.add(suggestion.getSport().getTxt());
        }
    }

    @Override
    public SuggestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.suggestion_item, parent, false);
        return new SuggestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SuggestionViewHolder holder, int position) {
        if (position < mSuggestions.size()) {
            holder.weatherTodayIndex.setText(mTitles.get(position));
            holder.weatherTodaySugg.setText(mSuggestions.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mSuggestions.size();
    }

    static class SuggestionViewHolder extends RecyclerView.ViewHolder {

        TextView weatherTodayIndex;

        TextView weatherTodaySugg;

        public SuggestionViewHolder(View itemView) {
            super((itemView));
            weatherTodayIndex = (TextView) itemView.findViewById(R.id.weather_today_index);
            weatherTodaySugg = (TextView) itemView.findViewById(R.id.weather_today_sugg);
        }
    }
}

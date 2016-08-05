package cn.edu.seu.jeremy.weather.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jeremy Xu on 2016/8/5 17:59
 * E-mail: jeremy_xm@163.com
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> implements View.OnClickListener {

    private List<String> contents = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public CityAdapter(List<String> strings) {
        setContents(strings);
    }

    public void setContents(List<String> strings) {
        contents.clear();
        contents.addAll(strings);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_activated_1, parent, false);
        view.setOnClickListener(this);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.textView.setText(contents.get(position));
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(v, ((TextView) v).getText().toString());
        }
    }

    protected class CityViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public CityViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(android.R.id.text1);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, String choice);
    }
}


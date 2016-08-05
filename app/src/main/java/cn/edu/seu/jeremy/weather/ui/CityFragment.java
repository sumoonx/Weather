package cn.edu.seu.jeremy.weather.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.edu.seu.jeremy.weather.R;
import cn.edu.seu.jeremy.weather.base.BaseFragment;
import cn.edu.seu.jeremy.weather.repository.CityInfoRepository;
import cn.edu.seu.jeremy.weather.ui.adapter.CityAdapter;
import cn.edu.seu.jeremy.weather.util.LogUtil;
import rx.Subscriber;
import rx.Subscription;


/**
 * Author: Jeremy Xu on 2016/8/5 10:44
 * E-mail: jeremy_xm@163.com
 */
public class CityFragment extends BaseFragment implements CityAdapter.OnItemClickListener {

    @Inject
    CityInfoRepository cityInfoRepository;
    @BindView(R.id.choose_city)
    RecyclerView chooseCity;

    private OnCityChoosedListener cityChoosedListener;

    private List<String> provinces = new ArrayList<>();

    private List<String> cities = new ArrayList<>();

    private boolean isProvince;

    private CityAdapter cityAdapter;

    private Subscription subscription;

    private CitySubscriber citySubscriber = new CitySubscriber();

    private CitySubscriber provSubscriber = new CitySubscriber();

    public static CityFragment newInstance() {
        return new CityFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.getApiServiceComponent().inject(this);
        cityChoosedListener = activity;

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        chooseCity.setLayoutManager(manager);
        cityAdapter = new CityAdapter(provinces);
        cityAdapter.setOnItemClickListener(this);
        chooseCity.setAdapter(cityAdapter);

        showProvince();
    }

    @Override
    public void onDestroyView() {
        unsubscribe();
        super.onDestroyView();
    }

    public void showProvince() {
        isProvince = true;
        if (provinces.isEmpty()) {
            unsubscribe();
            subscription = cityInfoRepository.getProvinces().subscribe(citySubscriber);
        } else {
            cityAdapter.setContents(provinces);
        }
    }

    private void showCities(String province) {
        isProvince = false;
        if (cities.isEmpty()) {
            unsubscribe();
            subscription = cityInfoRepository.getCities(province).subscribe(provSubscriber);
        } else {
            cityAdapter.setContents(cities);
        }
    }

    private void unsubscribe() {
        if (subscription != null) {
            subscription.unsubscribe();
            subscription = null;
        }
    }

    private class CitySubscriber extends Subscriber<String> {
        @Override
        public void onCompleted() {
            if (isProvince) {
                cityAdapter.setContents(provinces);
            } else {
                cityAdapter.setContents(cities);
            }
        }

        @Override
        public void onError(Throwable e) {
            LogUtil.ae(e.toString());
        }

        @Override
        public void onNext(String string) {
            if (isProvince) {
                provinces.add(string);
            } else {
                cities.add(string);
            }
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_city;
    }

    @Override
    public void onItemClick(View view, String choice) {
        if (isProvince) {
            showCities(choice);
        } else {
            cityChoosedListener.onCityChoosed(choice);
        }
    }

    public interface OnCityChoosedListener {
        void onCityChoosed(String city);
    }
}

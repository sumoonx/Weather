package cn.edu.seu.jeremy.weather.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cn.edu.seu.jeremy.weather.entity.CityInfo;
import cn.edu.seu.jeremy.weather.service.WeatherService;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Author: Jeremy Xu on 2016/8/5 16:39
 * E-mail: jeremy_xm@163.com
 */
public class CityInfoRepository {

    private CityInfoDB cityInfoDB;

    private WeatherService weatherService;

    @Inject
    public CityInfoRepository(CityInfoDB cityInfoDB, WeatherService weatherService) {
        this.cityInfoDB = cityInfoDB;
        this.weatherService = weatherService;
    }

    public Observable<String> getProvinces() {
        if (cityInfoDB.isEmpty()) {
            return weatherService.getCityInfo()
                    .doOnNext(new Action1<List<CityInfo>>() {
                        @Override
                        public void call(List<CityInfo> cityInfos) {
                            cityInfoDB.saveCities(cityInfos);
                        }
                    })
                    .map(new Func1<List<CityInfo>, List<String>>() {
                        @Override
                        public List<String> call(List<CityInfo> cityInfos) {
                            List<String> ret = new ArrayList<>();
                            for (CityInfo city :
                                    cityInfos) {
                                ret.add(city.getProv());
                            }
                            return ret;
                        }
                    }).distinct()
                    .flatMap(new Func1<List<String>, Observable<String>>() {
                        @Override
                        public Observable<String> call(List<String> strings) {
                            return Observable.from(strings);
                        }
                    });
        } else {
            return Observable.from(cityInfoDB.loadProvinces());
        }
    }

    public Observable<String> getCities(final String province) {
        if (cityInfoDB.isEmpty()) {
            return weatherService.getCityInfo()
                    .doOnNext(new Action1<List<CityInfo>>() {
                        @Override
                        public void call(List<CityInfo> cityInfos) {
                            cityInfoDB.saveCities(cityInfos);
                        }
                    })
                    .flatMap(new Func1<List<CityInfo>, Observable<CityInfo>>() {
                        @Override
                        public Observable<CityInfo> call(List<CityInfo> cityInfos) {
                            return Observable.from(cityInfos);
                        }
                    })
                    .filter(new Func1<CityInfo, Boolean>() {
                        @Override
                        public Boolean call(CityInfo cityInfo) {
                            return cityInfo.getProv().equals(province);
                        }
                    })
                    .map(new Func1<CityInfo, String>() {
                        @Override
                        public String call(CityInfo cityInfo) {
                            return cityInfo.getCity();
                        }
                    });
        } else {
            return Observable.from(cityInfoDB.loadCity(province));
        }
    }
}

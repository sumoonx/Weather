package cn.edu.seu.jeremy.weather.presenter;

import cn.edu.seu.jeremy.weather.contract.MvpView;
import cn.edu.seu.jeremy.weather.util.LogUtil;

/**
 * Author: Jeremy Xu on 2016/7/28 21:54
 * E-mail: jeremy_xm@163.com
 */
public abstract class Presenter<V extends MvpView> {

    protected V mvpView;

    public void takeView(V v) {
        mvpView = v;
    }

    public void dropView() {
        mvpView = null;
    }

    public V getMvpView() {
        if (mvpView != null)
            return mvpView;
        LogUtil.aw("no view attached!");
        return null;
    }
}

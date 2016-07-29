package cn.edu.seu.jeremy.weather.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author: Jeremy Xu on 2016/7/28 17:52
 * E-mail: jeremy_xm@163.com
 */
public class WeatherInfo {

    /**
     * city : {"aqi":"119","co":"1","no2":"21","o3":"170","pm10":"80","pm25":"43","qlty":"轻度污染","so2":"22"}
     */

    @SerializedName("aqi")
    private AqiBean aqi;
    /**
     * city : 南京
     * cnty : 中国
     * id : CN101190101
     * lat : 32.048000
     * lon : 118.769000
     * update : {"loc":"2016-07-28 18:52","utc":"2016-07-28 10:52"}
     */

    @SerializedName("basic")
    private BasicBean basic;
    /**
     * cond : {"code":"100","txt":"晴"}
     * fl : 44
     * hum : 46
     * pcpn : 0
     * pres : 1003
     * tmp : 36
     * vis : 10
     * wind : {"deg":"200","dir":"西南风","sc":"4-5","spd":"21"}
     */

    @SerializedName("now")
    private NowBean now;
    /**
     * aqi : {"city":{"aqi":"119","co":"1","no2":"21","o3":"170","pm10":"80","pm25":"43","qlty":"轻度污染","so2":"22"}}
     * basic : {"city":"南京","cnty":"中国","id":"CN101190101","lat":"32.048000","lon":"118.769000","update":{"loc":"2016-07-28 18:52","utc":"2016-07-28 10:52"}}
     * daily_forecast : [{"astro":{"sr":"05:17","ss":"19:05"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-07-28","hum":"58","pcpn":"1.3","pop":"95","pres":"1004","tmp":{"max":"38","min":"29"},"vis":"10","wind":{"deg":"215","dir":"西南风","sc":"微风","spd":"3"}},{"astro":{"sr":"05:18","ss":"19:04"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2016-07-29","hum":"54","pcpn":"0.0","pop":"17","pres":"1005","tmp":{"max":"38","min":"29"},"vis":"10","wind":{"deg":"193","dir":"南风","sc":"微风","spd":"3"}},{"astro":{"sr":"05:19","ss":"19:03"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2016-07-30","hum":"58","pcpn":"1.4","pop":"43","pres":"1006","tmp":{"max":"38","min":"28"},"vis":"10","wind":{"deg":"111","dir":"东南风","sc":"微风","spd":"6"}},{"astro":{"sr":"05:19","ss":"19:02"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2016-07-31","hum":"67","pcpn":"0.0","pop":"0","pres":"1007","tmp":{"max":"37","min":"28"},"vis":"10","wind":{"deg":"108","dir":"东风","sc":"3-4","spd":"11"}},{"astro":{"sr":"05:20","ss":"19:02"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2016-08-01","hum":"67","pcpn":"0.0","pop":"47","pres":"1006","tmp":{"max":"36","min":"27"},"vis":"10","wind":{"deg":"111","dir":"东风","sc":"3-4","spd":"14"}},{"astro":{"sr":"05:21","ss":"19:01"},"cond":{"code_d":"101","code_n":"104","txt_d":"多云","txt_n":"阴"},"date":"2016-08-02","hum":"67","pcpn":"2.6","pop":"54","pres":"1005","tmp":{"max":"35","min":"27"},"vis":"10","wind":{"deg":"93","dir":"东风","sc":"3-4","spd":"10"}},{"astro":{"sr":"05:21","ss":"19:00"},"cond":{"code_d":"104","code_n":"104","txt_d":"阴","txt_n":"阴"},"date":"2016-08-03","hum":"72","pcpn":"10.3","pop":"46","pres":"1004","tmp":{"max":"33","min":"26"},"vis":"10","wind":{"deg":"39","dir":"东风","sc":"3-4","spd":"14"}}]
     * hourly_forecast : [{"date":"2016-07-28 19:00","hum":"73","pop":"38","pres":"1004","tmp":"36","wind":{"deg":"188","dir":"南风","sc":"微风","spd":"9"}},{"date":"2016-07-28 22:00","hum":"78","pop":"3","pres":"1005","tmp":"34","wind":{"deg":"193","dir":"西南风","sc":"微风","spd":"9"}}]
     * now : {"cond":{"code":"100","txt":"晴"},"fl":"44","hum":"46","pcpn":"0","pres":"1003","tmp":"36","vis":"10","wind":{"deg":"200","dir":"西南风","sc":"4-5","spd":"21"}}
     * status : ok
     * suggestion : {"comf":{"brf":"很不舒适","txt":"白天天气晴好，但烈日炎炎您会感到很热，很不舒适。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},"sport":{"brf":"较不宜","txt":"天气较好，但气温很高，风力较大，请减少运动时间并降低运动强度，户外运动须注意避风防晒。"},"trav":{"brf":"较不宜","txt":"天气较好，温度很高，4、5级风可以缓解天气给您带来的炎热。可以选择水上娱乐等清凉项目并注意防晒。"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}
     */

    @SerializedName("status")
    private String status;
    /**
     * comf : {"brf":"很不舒适","txt":"白天天气晴好，但烈日炎炎您会感到很热，很不舒适。"}
     * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
     * drsg : {"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"}
     * flu : {"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"}
     * sport : {"brf":"较不宜","txt":"天气较好，但气温很高，风力较大，请减少运动时间并降低运动强度，户外运动须注意避风防晒。"}
     * trav : {"brf":"较不宜","txt":"天气较好，温度很高，4、5级风可以缓解天气给您带来的炎热。可以选择水上娱乐等清凉项目并注意防晒。"}
     * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
     */

    @SerializedName("suggestion")
    private SuggestionBean suggestion;
    /**
     * astro : {"sr":"05:17","ss":"19:05"}
     * cond : {"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"}
     * date : 2016-07-28
     * hum : 58
     * pcpn : 1.3
     * pop : 95
     * pres : 1004
     * tmp : {"max":"38","min":"29"}
     * vis : 10
     * wind : {"deg":"215","dir":"西南风","sc":"微风","spd":"3"}
     */

    @SerializedName("daily_forecast")
    private List<DailyForecastBean> dailyForecast;
    /**
     * date : 2016-07-28 19:00
     * hum : 73
     * pop : 38
     * pres : 1004
     * tmp : 36
     * wind : {"deg":"188","dir":"南风","sc":"微风","spd":"9"}
     */

    @SerializedName("hourly_forecast")
    private List<HourlyForecastBean> hourlyForecast;

    public static WeatherInfo objectFromData(String str) {

        return new Gson().fromJson(str, WeatherInfo.class);
    }

    public AqiBean getAqi() {
        return aqi;
    }

    public void setAqi(AqiBean aqi) {
        this.aqi = aqi;
    }

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuggestionBean getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionBean suggestion) {
        this.suggestion = suggestion;
    }

    public List<DailyForecastBean> getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(List<DailyForecastBean> dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public List<HourlyForecastBean> getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(List<HourlyForecastBean> hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    public static class AqiBean {
        /**
         * aqi : 119
         * co : 1
         * no2 : 21
         * o3 : 170
         * pm10 : 80
         * pm25 : 43
         * qlty : 轻度污染
         * so2 : 22
         */

        @SerializedName("city")
        private CityBean city;

        public static AqiBean objectFromData(String str) {

            return new Gson().fromJson(str, AqiBean.class);
        }

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public static class CityBean {
            @SerializedName("aqi")
            private String aqi;
            @SerializedName("co")
            private String co;
            @SerializedName("no2")
            private String no2;
            @SerializedName("o3")
            private String o3;
            @SerializedName("pm10")
            private String pm10;
            @SerializedName("pm25")
            private String pm25;
            @SerializedName("qlty")
            private String qlty;
            @SerializedName("so2")
            private String so2;

            public static CityBean objectFromData(String str) {

                return new Gson().fromJson(str, CityBean.class);
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getQlty() {
                return qlty;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }
        }
    }

    public static class BasicBean {
        @SerializedName("city")
        private String city;
        @SerializedName("cnty")
        private String cnty;
        @SerializedName("id")
        private String id;
        @SerializedName("lat")
        private String lat;
        @SerializedName("lon")
        private String lon;
        /**
         * loc : 2016-07-28 18:52
         * utc : 2016-07-28 10:52
         */

        @SerializedName("update")
        private UpdateBean update;

        public static BasicBean objectFromData(String str) {

            return new Gson().fromJson(str, BasicBean.class);
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public static class UpdateBean {
            @SerializedName("loc")
            private String loc;
            @SerializedName("utc")
            private String utc;

            public static UpdateBean objectFromData(String str) {

                return new Gson().fromJson(str, UpdateBean.class);
            }

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }
    }

    public static class NowBean {
        /**
         * code : 100
         * txt : 晴
         */

        @SerializedName("cond")
        private CondBean cond;
        @SerializedName("fl")
        private String fl;
        @SerializedName("hum")
        private String hum;
        @SerializedName("pcpn")
        private String pcpn;
        @SerializedName("pres")
        private String pres;
        @SerializedName("tmp")
        private String tmp;
        @SerializedName("vis")
        private String vis;
        /**
         * deg : 200
         * dir : 西南风
         * sc : 4-5
         * spd : 21
         */

        @SerializedName("wind")
        private WindBean wind;

        public static NowBean objectFromData(String str) {

            return new Gson().fromJson(str, NowBean.class);
        }

        public CondBean getCond() {
            return cond;
        }

        public void setCond(CondBean cond) {
            this.cond = cond;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class CondBean {
            @SerializedName("code")
            private String code;
            @SerializedName("txt")
            private String txt;

            public static CondBean objectFromData(String str) {

                return new Gson().fromJson(str, CondBean.class);
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class WindBean {
            @SerializedName("deg")
            private String deg;
            @SerializedName("dir")
            private String dir;
            @SerializedName("sc")
            private String sc;
            @SerializedName("spd")
            private String spd;

            public static WindBean objectFromData(String str) {

                return new Gson().fromJson(str, WindBean.class);
            }

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }

    public static class SuggestionBean {
        /**
         * brf : 很不舒适
         * txt : 白天天气晴好，但烈日炎炎您会感到很热，很不舒适。
         */

        @SerializedName("comf")
        private ComfBean comf;
        /**
         * brf : 较适宜
         * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
         */

        @SerializedName("cw")
        private CwBean cw;
        /**
         * brf : 炎热
         * txt : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
         */

        @SerializedName("drsg")
        private DrsgBean drsg;
        /**
         * brf : 少发
         * txt : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
         */

        @SerializedName("flu")
        private FluBean flu;
        /**
         * brf : 较不宜
         * txt : 天气较好，但气温很高，风力较大，请减少运动时间并降低运动强度，户外运动须注意避风防晒。
         */

        @SerializedName("sport")
        private SportBean sport;
        /**
         * brf : 较不宜
         * txt : 天气较好，温度很高，4、5级风可以缓解天气给您带来的炎热。可以选择水上娱乐等清凉项目并注意防晒。
         */

        @SerializedName("trav")
        private TravBean trav;
        /**
         * brf : 中等
         * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
         */

        @SerializedName("uv")
        private UvBean uv;

        public static SuggestionBean objectFromData(String str) {

            return new Gson().fromJson(str, SuggestionBean.class);
        }

        public ComfBean getComf() {
            return comf;
        }

        public void setComf(ComfBean comf) {
            this.comf = comf;
        }

        public CwBean getCw() {
            return cw;
        }

        public void setCw(CwBean cw) {
            this.cw = cw;
        }

        public DrsgBean getDrsg() {
            return drsg;
        }

        public void setDrsg(DrsgBean drsg) {
            this.drsg = drsg;
        }

        public FluBean getFlu() {
            return flu;
        }

        public void setFlu(FluBean flu) {
            this.flu = flu;
        }

        public SportBean getSport() {
            return sport;
        }

        public void setSport(SportBean sport) {
            this.sport = sport;
        }

        public TravBean getTrav() {
            return trav;
        }

        public void setTrav(TravBean trav) {
            this.trav = trav;
        }

        public UvBean getUv() {
            return uv;
        }

        public void setUv(UvBean uv) {
            this.uv = uv;
        }

        public static class ComfBean {
            @SerializedName("brf")
            private String brf;
            @SerializedName("txt")
            private String txt;

            public static ComfBean objectFromData(String str) {

                return new Gson().fromJson(str, ComfBean.class);
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class CwBean {
            @SerializedName("brf")
            private String brf;
            @SerializedName("txt")
            private String txt;

            public static CwBean objectFromData(String str) {

                return new Gson().fromJson(str, CwBean.class);
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class DrsgBean {
            @SerializedName("brf")
            private String brf;
            @SerializedName("txt")
            private String txt;

            public static DrsgBean objectFromData(String str) {

                return new Gson().fromJson(str, DrsgBean.class);
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class FluBean {
            @SerializedName("brf")
            private String brf;
            @SerializedName("txt")
            private String txt;

            public static FluBean objectFromData(String str) {

                return new Gson().fromJson(str, FluBean.class);
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class SportBean {
            @SerializedName("brf")
            private String brf;
            @SerializedName("txt")
            private String txt;

            public static SportBean objectFromData(String str) {

                return new Gson().fromJson(str, SportBean.class);
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class TravBean {
            @SerializedName("brf")
            private String brf;
            @SerializedName("txt")
            private String txt;

            public static TravBean objectFromData(String str) {

                return new Gson().fromJson(str, TravBean.class);
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class UvBean {
            @SerializedName("brf")
            private String brf;
            @SerializedName("txt")
            private String txt;

            public static UvBean objectFromData(String str) {

                return new Gson().fromJson(str, UvBean.class);
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }

    public static class DailyForecastBean {
        /**
         * sr : 05:17
         * ss : 19:05
         */

        @SerializedName("astro")
        private AstroBean astro;
        /**
         * code_d : 100
         * code_n : 100
         * txt_d : 晴
         * txt_n : 晴
         */

        @SerializedName("cond")
        private CondBean cond;
        @SerializedName("date")
        private String date;
        @SerializedName("hum")
        private String hum;
        @SerializedName("pcpn")
        private String pcpn;
        @SerializedName("pop")
        private String pop;
        @SerializedName("pres")
        private String pres;
        /**
         * max : 38
         * min : 29
         */

        @SerializedName("tmp")
        private TmpBean tmp;
        @SerializedName("vis")
        private String vis;
        /**
         * deg : 215
         * dir : 西南风
         * sc : 微风
         * spd : 3
         */

        @SerializedName("wind")
        private WindBean wind;

        public static DailyForecastBean objectFromData(String str) {

            return new Gson().fromJson(str, DailyForecastBean.class);
        }

        public AstroBean getAstro() {
            return astro;
        }

        public void setAstro(AstroBean astro) {
            this.astro = astro;
        }

        public CondBean getCond() {
            return cond;
        }

        public void setCond(CondBean cond) {
            this.cond = cond;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public TmpBean getTmp() {
            return tmp;
        }

        public void setTmp(TmpBean tmp) {
            this.tmp = tmp;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class AstroBean {
            @SerializedName("sr")
            private String sr;
            @SerializedName("ss")
            private String ss;

            public static AstroBean objectFromData(String str) {

                return new Gson().fromJson(str, AstroBean.class);
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }
        }

        public static class CondBean {
            @SerializedName("code_d")
            private String codeD;
            @SerializedName("code_n")
            private String codeN;
            @SerializedName("txt_d")
            private String txtD;
            @SerializedName("txt_n")
            private String txtN;

            public static CondBean objectFromData(String str) {

                return new Gson().fromJson(str, CondBean.class);
            }

            public String getCodeD() {
                return codeD;
            }

            public void setCodeD(String codeD) {
                this.codeD = codeD;
            }

            public String getCodeN() {
                return codeN;
            }

            public void setCodeN(String codeN) {
                this.codeN = codeN;
            }

            public String getTxtD() {
                return txtD;
            }

            public void setTxtD(String txtD) {
                this.txtD = txtD;
            }

            public String getTxtN() {
                return txtN;
            }

            public void setTxtN(String txtN) {
                this.txtN = txtN;
            }
        }

        public static class TmpBean {
            @SerializedName("max")
            private String max;
            @SerializedName("min")
            private String min;

            public static TmpBean objectFromData(String str) {

                return new Gson().fromJson(str, TmpBean.class);
            }

            public String getMax() {
                return max;
            }

            public void setMax(String max) {
                this.max = max;
            }

            public String getMin() {
                return min;
            }

            public void setMin(String min) {
                this.min = min;
            }
        }

        public static class WindBean {
            @SerializedName("deg")
            private String deg;
            @SerializedName("dir")
            private String dir;
            @SerializedName("sc")
            private String sc;
            @SerializedName("spd")
            private String spd;

            public static WindBean objectFromData(String str) {

                return new Gson().fromJson(str, WindBean.class);
            }

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }

    public static class HourlyForecastBean {
        @SerializedName("date")
        private String date;
        @SerializedName("hum")
        private String hum;
        @SerializedName("pop")
        private String pop;
        @SerializedName("pres")
        private String pres;
        @SerializedName("tmp")
        private String tmp;
        /**
         * deg : 188
         * dir : 南风
         * sc : 微风
         * spd : 9
         */

        @SerializedName("wind")
        private WindBean wind;

        public static HourlyForecastBean objectFromData(String str) {

            return new Gson().fromJson(str, HourlyForecastBean.class);
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class WindBean {
            @SerializedName("deg")
            private String deg;
            @SerializedName("dir")
            private String dir;
            @SerializedName("sc")
            private String sc;
            @SerializedName("spd")
            private String spd;

            public static WindBean objectFromData(String str) {

                return new Gson().fromJson(str, WindBean.class);
            }

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }
}

package com.aditde.krishi.ui.weather;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.sax.TextElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

import com.aditde.krishi.R;
import com.google.firebase.database.annotations.NotNull;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    ProgressBar loader;
    RelativeLayout mainContainer;
    TextView errorText;

    TextView address1;
    TextView updatedAt1;
    TextView status1;
    TextView temp1;
    TextView tempMin1;
    TextView tempMax1;
    TextView sunrise1;
    TextView sunset1;
    TextView wind1;
    TextView pressure1;
    TextView humidity1;

    @NotNull
    private final String CITY = "anand,in";
    @NotNull
    private final String API = "a7970bfc1f03bd14fe07ceff46618f84";
    private HashMap _$_findViewCache;

    @NotNull
    public final String getCITY() {
        return this.CITY;
    }

    @NotNull
    public final String getAPI() {
        return this.API;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        loader = (ProgressBar) root.findViewById(R.id.loader);
        mainContainer = (RelativeLayout) root.findViewById(R.id.mainContainer);
        errorText = (TextView) root.findViewById(R.id.errorText);

        address1 = (TextView) root.findViewById(R.id.address);
        updatedAt1 = (TextView) root.findViewById(R.id.updated_at);
        status1 = (TextView) root.findViewById(R.id.status);
        temp1 = (TextView) root.findViewById(R.id.temp);
        tempMin1 = (TextView) root.findViewById(R.id.temp_min);
        tempMax1 = (TextView) root.findViewById(R.id.temp_max);
        sunrise1 = (TextView) root.findViewById(R.id.sunrise);
        sunset1 = (TextView) root.findViewById(R.id.sunset);
        wind1 = (TextView) root.findViewById(R.id.wind);
        pressure1 = (TextView) root.findViewById(R.id.pressure);
        humidity1 = (TextView) root.findViewById(R.id.humidity);


        (new weatherTask()).execute(new String[0]);

        return root;
    }

    public final class weatherTask extends AsyncTask {
        protected void onPreExecute() {
            super.onPreExecute();

            loader.setVisibility(View.VISIBLE);
            mainContainer.setVisibility(View.GONE);
            errorText.setVisibility(View.GONE);
        }

        @Nullable
        protected String doInBackground(@NotNull String... params) {

            String response = null;

            try {
                URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="
                        + SlideshowFragment.this.getCITY() +
                        "&units=metric&appid=" + SlideshowFragment.this.getAPI());
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(url.openStream(), "UTF-8"));
                String json = in.readLine();
                byte[] bytes = json.getBytes("UTF-8");
                in.close();
                response = new String(bytes, StandardCharsets.UTF_8);
            } catch (Exception e) {
                response = (String)null;
            }

            return response;
        }

        // $FF: synthetic method
        // $FF: bridge method
        public Object doInBackground(Object[] var1) {
            return this.doInBackground((String[])var1);
        }

        protected void onPostExecute(@Nullable String result) {
            super.onPostExecute(result);

            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject wind = jsonObj.getJSONObject("wind");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);
                long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated at: " + (new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH)).format(new Date(updatedAt * (long)1000));
                String temp = main.getString("temp") + "°C";
                String tempMin = "Min Temp: " + main.getString("temp_min") + "°C";
                String tempMax = "Max Temp: " + main.getString("temp_max") + "°C";
                String pressure = main.getString("pressure");
                String humidity = main.getString("humidity");
                long sunrise = sys.getLong("sunrise");
                long sunset = sys.getLong("sunset");
                String windSpeed = wind.getString("speed");
                String weatherDescription = weather.getString("description");
                String address = jsonObj.getString("name") + ", " + sys.getString("country");

                address1.setText(address);
                updatedAt1.setText(updatedAtText);
                status1.setText(weatherDescription);
                temp1.setText(temp);
                tempMin1.setText(tempMin);
                tempMax1.setText(tempMax);
                sunrise1.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise*1000)));
                sunset1.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset*1000)));
                wind1.setText(windSpeed);
                pressure1.setText(pressure);
                humidity1.setText(humidity);

                /* Views populated, Hiding the loader, Showing the main design */
                loader.setVisibility(View.GONE);
                mainContainer.setVisibility(View.VISIBLE);

            } catch (Exception var22) {

                loader.setVisibility(View.GONE);
                errorText.setVisibility(View.VISIBLE);
            }

        }

        // $FF: synthetic method
        // $FF: bridge method
        public void onPostExecute(Object var1) {
            this.onPostExecute((String)var1);
        }
    }

}
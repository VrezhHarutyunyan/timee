package com.example.cybertech2.timee.activities;

        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.View;
        import android.widget.TextView;
        import android.system.ErrnoException;
        import android.widget.Toast;

        import com.example.cybertech2.timee.R;

        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;

        import okhttp3.Call;
        import okhttp3.Callback;
        import okhttp3.MediaType;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.RequestBody;
        import okhttp3.Response;
        import okhttp3.ResponseBody;

public class HiRatesActivity extends AppCompatActivity {

    public static final MediaType MEDIA_TYPE =
            MediaType.parse("application/json; charset=utf-8");
    private static final String TAG ="" ;
    Toolbar toolbar;
    String serverResponse;
    public TextView textView;
    public String url = "https://timee.000webhostapp.com/json.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_rates);

        toolbar = findViewById(R.id.toolbarHiRates);
        textView = findViewById(R.id.textViewHiRates);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        OkHttpClient client = new OkHttpClient();
//        JSONObject json = new JSONObject();
//        RequestBody body = RequestBody.create(MEDIA_TYPE,
//               json.toString());

        Request request = new Request.Builder()
                .url(url)
//                .post(body)
                .build();

        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("FAILURE", "FAILURE");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String mMessage = response.body().string();

                if( !response.isSuccessful() ){
                    throw new IOException("unexpected code" + response);
                }

                if (response.isSuccessful()) {
                    try {
                        JSONObject json = new JSONObject(mMessage);
                        serverResponse = json.getString("text");
                        Log.d("fdf", serverResponse);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(serverResponse);
                    }
                });


            }



        };

        client.newCall(request).enqueue(callback);



//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        OkHttpClient client = new OkHttpClient();
//
//        try {
//            Response response = client.newCall(request).execute();
//            String message = response.body().string();
//            JSONObject json = new JSONObject(message);
//            serverResponse = json.getString("text");
//            Log.d("VICTOR: ", serverResponse);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }



    }
}



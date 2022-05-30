package ru.itmatveev.parsecryptopair.publicConnect;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class Request {
    public String sendRequest(String url, String way, String method, String media) {
        okhttp3.Request request;
        String responseBody = null;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, media);
        if (method.equals("POST")) {
            request = new okhttp3.Request.Builder()
                    .url(url + way)
                    .method(method, body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
        } else {
            request = new okhttp3.Request.Builder()
                    .url(url + way)
                    .get()
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
        }

        try {
            Response response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }
}

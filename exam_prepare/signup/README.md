# This is cook book for Middle Exam Test

To Add OkHTTP3 to use HTTP Request:

```
implementation("com.squareup.okhttp3:okhttp:4.10.0")
```

To Add Glide to set image from url:

```
dependencies {
  implementation 'com.github.bumptech.glide:glide:4.14.2'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.14.2'
}
```

and usage example:

```
Glide.with(photoIv).load(photo.getUrl()).into(photoIv);
```

To convert String to JSON use this:

```
dependencies {
  implementation 'com.google.code.gson:gson:2.9.1'
}
```

example of GET Request from url:

```
OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url("https://api.thecatapi.com/v1/images/search?limit=10")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                throw new Error("Error GET: ", e.getCause());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String body = response.body().string();

                Gson gson = new Gson();
                ArrayList<Photo> photoList;

                Type listType = new TypeToken<ArrayList<Photo>>() {}.getType();
                photoList = gson.fromJson(body, listType);

                mPhotoList.addAll(photoList);

                handler.post(() -> timelineAdapter.notifyDataSetChanged());
            }
        });
```

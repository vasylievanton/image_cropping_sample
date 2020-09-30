package com.example.imagecropping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InstaCropperView instaCropperView = findViewById(R.id.crop_image);
        instaCropperView.setImageUri(getImageUri(this));
    }

    public Uri getImageUri(Context inContext) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.visual_reverse_image_search_v2_intro);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), bitmap, "Title", null);
        return Uri.parse(path);
    }

}
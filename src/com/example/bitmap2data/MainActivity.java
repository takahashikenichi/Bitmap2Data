package com.example.bitmap2data;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Bitmap bitmap; // �r�b�g�}�b�v��ARGB32bit�̏ꍇ

		// �r�b�g�}�b�v���擾
		Bitmap bmp2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.similator_logo);
		Bitmap bmp = bmp2.copy(Bitmap.Config.ARGB_8888, true);
		
		// �f�[�^���擾
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		
		String pixelString = "";
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixelString += Integer.toString(Color.blue(pixels[x + y * width])); // (x,y)�̕����̐F�̃f�[�^
				pixelString += ", ";
			}
			pixelString += "----------------";
		}
		// bmp.setPixels(pixels, 0, width, 0, 0, width, height);
		Log.d("TEST", pixelString);
		Log.d("width", Integer.toString(width));
		Log.d("height", Integer.toString(height));
	}
}

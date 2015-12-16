package com.test.administrator.formygirl;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue mQueue = Volley.newRequestQueue(this);
        ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
            @Override
            public void putBitmap(String url, Bitmap bitmap) {
            }

            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }
        });
        final Button forceOffline = (Button) findViewById(R.id.force_offline);
        //forceOffline.setImageResource(R.drawable.two);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Warning");
                dialogBuilder.setMessage("You are forced to be offline.Please try to login again.");
                dialogBuilder.setCancelable(false);
                dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCollector.finishAll();//销毁所有活动
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);//重新启动LoginActivity
                    }
                });
                dialogBuilder.setNegativeButton("手滑了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "下次小心点", Toast.LENGTH_LONG).show();
                    }
                });
                dialogBuilder.show();
            }
        });
        ImageButton openNews = (ImageButton) findViewById(R.id.open_the_news);
        // openNews.setImageResource(R.drawable.one);
        openNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        ImageButton openSights = (ImageButton) findViewById(R.id.beautiful_sights);
        //openSights.setImageResource(R.drawable.three);
        openSights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SightsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        //加载网络图片
//      try{ URL url= new URL("http://img.my.csdn.net/uploads/201211/17/1353161173_2765.png");
//        Utils.onLoadImage(url, new Utils.OnLoadImageListener() {
//            @Override
//            public void OnLoadImage(Bitmap bitmap, String bitmapPath) {
//                // TODO Auto-generated method stub
//                if (bitmap != null) {
//                    forceOffline.setImageBitmap(bitmap);
//                }
//            }
//        });}
//      catch (IOException e){}

        ImageButton contect=(ImageButton)findViewById(R.id.contect);
        ImageButton shop=(ImageButton)findViewById(R.id.shop);
        ImageButton last=(ImageButton)findViewById(R.id.qimo);
        contect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ContectActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DuangActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LastActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        //forceOffline.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.b3, 300, 300));
        openSights.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.b4,300,300));
        openNews.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.b2,300,300));
        last.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.b1,300,300));
        shop.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.b3,300,300));
        contect.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.b5,300,300));
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

// First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

// Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

// Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
// Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

// Calculate the largest inSampleSize value that is a power of 2 and keeps both
// height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}

package club.touchyourideas.affirmationwallpaperskickstartyourday;

import android.app.WallpaperManager;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class success extends AppCompatActivity {
    Integer[] imageArray = {
            R.drawable.success_affirmation, R.drawable.success_affirmation2,
            R.drawable.success_affirmation3,R.drawable.success_affirmation4,
            R.drawable.success_affirmation5,R.drawable.success_affirmation6,
            R.drawable.success_affirmation7,R.drawable.success_affirmation8
    };

    GridView gridView;
    WallpaperManager wallpaperManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        gridView = findViewById(R.id.GridView);
        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        gridView.setAdapter(new ImageAdapter(getApplicationContext()));

    }

  public class ImageAdapter extends BaseAdapter {

        Context mycontext;

        public ImageAdapter(Context applicationContext) {

            mycontext = applicationContext;

        }

        @Override
        public int getCount() {
            return imageArray.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            ImageView GridImageView;
            if (view == null) {
                GridImageView = new ImageView(mycontext);
                GridImageView.setLayoutParams(new GridView.LayoutParams(620, 1102));
                GridImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                GridImageView = (ImageView) view;
            }

            GridImageView.setImageResource(imageArray [position]);

            GridImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        wallpaperManager.setResource(imageArray[position]);
                        Toast.makeText(getApplicationContext(), "Wallpaper Changed", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            return GridImageView;
        }
    }

}

package club.touchyourideas.affirmationwallpaperskickstartyourday;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        image1 = (ImageView) findViewById(R.id.success);
        image2 = (ImageView) findViewById(R.id.attracting);
        image3 = (ImageView) findViewById(R.id.confidence);
        image4 = (ImageView) findViewById(R.id.love);
        image5 = (ImageView) findViewById(R.id.health);
        image6 = (ImageView) findViewById(R.id.happiness);
        share = (Button) findViewById(R.id.share);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareIt();
            }
        });

    }

    private void shareIt() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Affirmation Wallpapers To Kickstart Your Day - https://https://play.google.com/store/apps/details?id=club.touchyourideas.affirmationwallpaperskickstartyourday";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Inspiring Affirmation Wallpapers To Kickstart Your Day!");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void openActivity() {
        Intent intent = new Intent(this, success.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Attracting.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Confidence.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, Love.class);
        startActivity(intent);
    }

    public void openActivity5() {
        Intent intent = new Intent(this, Health.class);
        startActivity(intent);
    }

    public void openActivity6() {
        Intent intent = new Intent(this, Happiness.class);
        startActivity(intent);
    }

}

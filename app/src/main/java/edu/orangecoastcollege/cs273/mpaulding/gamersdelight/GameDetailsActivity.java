package edu.orangecoastcollege.cs273.mpaulding.gamersdelight;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class GameDetailsActivity extends AppCompatActivity {

    private TextView gameNameTextView;
    private TextView gameDescriptionTextView;
    private ImageView gameImageView;
    private RatingBar gameRatingBar;
    private Context context = (Context) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        gameNameTextView = (TextView) findViewById(R.id.gameDetailsNameTextView);
        gameDescriptionTextView = (TextView) findViewById(R.id.gameDetailsDescriptionTextView);
        gameImageView = (ImageView) findViewById(R.id.gameDetailsImageView);
        gameRatingBar = (RatingBar) findViewById(R.id.gameDetailsRatingBar);

        Intent intentFromGameListActivity = getIntent();

        String gameName = intentFromGameListActivity.getStringExtra("Name");
        String gameDescription = intentFromGameListActivity.getStringExtra("Description");
        String gameRating = intentFromGameListActivity.getStringExtra("Rating");
        String gameImageName = intentFromGameListActivity.getStringExtra("ImageName");

        gameNameTextView.setText(gameName);
        gameDescriptionTextView.setText(gameDescription);
        gameRatingBar.setRating(Float.parseFloat(gameRating));

        AssetManager am = context.getAssets();

        // Try to load image file
        try {
            InputStream stream = am.open(gameImageName);
            Drawable image = Drawable.createFromStream(stream, gameName);
            gameImageView.setImageDrawable(image);
        }
        catch (IOException ex) {
            Log.e("", "" + gameImageName + ex);
        }

        // TODO:  Use the Intent object sent from GameListActivity to populate the Views on
        // TODO:  this layout, including the TextViews, RatingBar and ImageView with the Game details.
    }
}

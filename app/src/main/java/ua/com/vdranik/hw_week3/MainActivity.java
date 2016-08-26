package ua.com.vdranik.hw_week3;

import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Drawable myDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        Button standartButton = (Button) findViewById(R.id.standartButton);
        Button invertButton = (Button) findViewById(R.id.invertButton);
        standartButton.setOnClickListener(this);
        invertButton.setOnClickListener(this);
        myDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.rgb, null);
        myDrawable.setColorFilter(new ColorMatrixColorFilter(STANDART)); // do nothing
        imageView.setImageDrawable(myDrawable);
    }

    private static final float[] STANDART = {
            1.0f, 0, 0, 0, 0,     // red
            0, 1.0f, 0, 0, 0,      // green
            0, 0, 1.0f, 0, 0,      // blue
            0, 0, 0, 1.0f, 0       // alpha
    };

    private static final float[] INVERT_GREEN_AND_RED = {
            1.0f, 0, 0, 0, 0,  // red
            0, -1.0f, 0, 0, 255,     // green
            0, 0, -1.0f, 0, 255,   // blue
            0, 0, 0, 1.0f, 0  // alpha
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.standartButton:
                myDrawable.setColorFilter(new ColorMatrixColorFilter(STANDART));
                imageView.setImageDrawable(myDrawable);
                break;
            case R.id.invertButton:
                myDrawable.setColorFilter(new ColorMatrixColorFilter(INVERT_GREEN_AND_RED));
                imageView.setImageDrawable(myDrawable);
                break;
        }
    }
}

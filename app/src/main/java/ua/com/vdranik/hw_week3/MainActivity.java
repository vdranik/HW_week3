package ua.com.vdranik.hw_week3;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View gradient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gradient = findViewById(R.id.gradient);
        Button addGradientButton = (Button) findViewById(R.id.addGradient);
        Button deleteGradientButton = (Button) findViewById(R.id.deleteGradient);
        addGradientButton.setOnClickListener(this);
        deleteGradientButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addGradient:

                GradientDrawable gd = new GradientDrawable();
                gd.setColors(new int[]{
                        Color.RED,
                        Color.WHITE,
                        Color.YELLOW,
                        Color.BLACK,
                        Color.GREEN,
                        Color.CYAN,
                        Color.MAGENTA,
                        Color.TRANSPARENT
                });

                gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                gd.setGradientRadius(150);
                gd.setShape(GradientDrawable.RECTANGLE);
                gradient.setBackground(gd);
                break;
            case R.id.deleteGradient:
                gradient.setBackground(null);
                break;
        }
    }
}

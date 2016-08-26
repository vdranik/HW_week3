package ua.com.vdranik.hw_week3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        image = BitmapFactory.decodeResource(getResources(), R.drawable.smile);
        Button origSmile = (Button) findViewById(R.id.origSmile);
        Button cropSmile = (Button) findViewById(R.id.cropSmile);
        origSmile.setOnClickListener(this);
        cropSmile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cropSmile:
                Bitmap cropped = getRoundedCroppedImage(image);
                imageView.setImageBitmap(cropped);
                break;
            case R.id.origSmile:
                imageView.setImageBitmap(image);
                break;
        }
    }

    private Bitmap getRoundedCroppedImage(Bitmap bmp) {
        int widthLight = bmp.getWidth();
        int heightLight = bmp.getHeight();

        Bitmap output = Bitmap.createBitmap(widthLight, heightLight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);

        RectF rectF = new RectF(new Rect(0, 0, widthLight, heightLight));

        canvas.drawRoundRect(rectF, widthLight / 2 ,heightLight / 2,paint);

        Paint paintImage = new Paint();
        paintImage.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bmp, 0, 0, paintImage);

        return output;
    }
}
package comwow2778.naver.blog.app15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by seon on 2017-05-18.
 */

public class MyCanvas extends View {
    Rect rect;


    public MyCanvas(Context context) {
        super(context);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        rect = new Rect(10,10,100,100);
        canvas.drawRect(rect, paint);

        int width = canvas.getWidth()/2 -45;
        int height = canvas.getHeight()/2 -45;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawRect(width,height,width+90,height+90,paint);
        paint.setStrokeWidth(5);
        paint.setTextSize(70);
        canvas.drawText("click me!!", 300,300,paint);

        Bitmap img = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        canvas.drawBitmap(img,300,350,paint);
        canvas.drawBitmap(img,400,150,paint);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 10, 10, paint);
        Bitmap smallBitmap = Bitmap.createScaledBitmap(bitmap,
                bitmap.getWidth()/2, bitmap.getHeight()/2, false);
        canvas.drawBitmap(smallBitmap, 10, 100, paint);
        Bitmap bitBitmap = Bitmap.createScaledBitmap(bitmap,
                this.getWidth(), this.getHeight(), false);
        canvas.drawBitmap(bitBitmap, 10, 10, paint);

        img.recycle();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        if(rect.contains(x,y)){
            Toast.makeText(getContext(),"Red Button", Toast.LENGTH_SHORT).show();
        }/*
        if(x >=10 && x <=100 && y >= 10 && y<=100){
            Toast.makeText(getContext(),"Red Button", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(),"NO", Toast.LENGTH_SHORT).show();
        }*/
        return true;
    }
}

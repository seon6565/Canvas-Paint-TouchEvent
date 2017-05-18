package comwow2778.naver.blog.app15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by seon on 2017-05-18.
 */

public class MyPainter extends View {
    Bitmap mBitmap;
    Canvas mCanvas;
    Paint mPaint = new Paint();

    public MyPainter(Context context) {
        super(context);
        mPaint.setColor(Color.BLACK);
    }

    public MyPainter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas();
        mCanvas.setBitmap(mBitmap);
        mCanvas.drawColor(Color.YELLOW);
    }

    private void stamp(){
        Bitmap img = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        mCanvas.drawBitmap(img,oldx,oldy,mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mBitmap != null) {
            canvas.drawBitmap(mBitmap, 10, 10, null);
        }
    }
    int oldx = -1; int oldy = -1;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            oldx =x; oldy=y;
        }
        else if(event.getAction() == MotionEvent.ACTION_MOVE){
            if(oldx != -1) {
                mCanvas.drawLine(oldx, oldy, x, y, mPaint);
                invalidate();
                oldx = x;
                oldy = y;
            }

        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            if(oldx != -1) {
                mCanvas.drawLine(oldx, oldy, x, y, mPaint);
                invalidate();
            }
            oldx = -1;
            oldy = -1;
        }

        return true;
    }


    public void clear() {
        mBitmap.eraseColor(Color.WHITE);
        invalidate();
    }

    public boolean Save(String file_name) {
        try {
            FileOutputStream out = new FileOutputStream(file_name);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.close();
            return true;
        } catch (FileNotFoundException e) {
            Log.e("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
        }
        return false;
    }
}

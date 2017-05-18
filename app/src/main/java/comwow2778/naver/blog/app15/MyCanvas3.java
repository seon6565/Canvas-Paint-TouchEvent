package comwow2778.naver.blog.app15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by seon on 2017-05-18.
 */

public class MyCanvas3 extends View {
    String operationType=null;
    public MyCanvas3(Context context) {
        super(context);
    }

    public MyCanvas3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        Bitmap img = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        Bitmap bigimg = Bitmap.createScaledBitmap(img,img.getWidth()*2, img.getHeight()*2,false);
        int cenX = (this.getWidth() - bigimg.getWidth());
        int cenY = (this.getWidth() - bigimg.getWidth());
        canvas.drawBitmap(bigimg, cenX,cenY,null);
        if(operationType.equals("rotate")){
            canvas.rotate(45, this.getWidth()/2,this.getHeight()/2);
        }
    }

    public void setOperationType(String operationType){
        this.operationType=operationType;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}

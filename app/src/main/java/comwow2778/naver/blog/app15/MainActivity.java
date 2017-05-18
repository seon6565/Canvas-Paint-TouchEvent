package comwow2778.naver.blog.app15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    MyPainter mypainter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mypainter = (MyPainter)findViewById(R.id.canvas);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
    }


    public void onClick(View v){
        if(v.getId()==R.id.b1) {
            mypainter.clear();
        }
        else if(v.getId()==R.id.b2){

        }
        else if(v.getId()==R.id.b3){

        }
        else if(v.getId()==R.id.b4){

        }
        else if(v.getId()==R.id.b5){

        }
        else if(v.getId()==R.id.b6){

        }
        else if(v.getId()==R.id.b7){

        }
    }
}

package comwow2778.naver.blog.app15;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    MyPainter mypainter;
    int check = 0;
    int check_blur = 0;
    int check_color = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mypainter = (MyPainter)findViewById(R.id.canvas);
        checkBox = (CheckBox)findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox.setChecked(isChecked);
                mypainter.IsChecked = isChecked;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Bluring").setCheckable(true);
        menu.add(0, 2, 0, "Coloring").setCheckable(true);
        menu.add(0, 3, 0, "Pen Width Big").setCheckable(true);
        menu.add(0, 4, 0, "Pen Color Red");
        menu.add(0, 5, 0, "Pen Color Blue");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            check_blur++;
            if (check_blur % 2 == 1) {
                mypainter.setOperation("bluring");
                item.setChecked(true);
            } else {
                mypainter.setOperation("nofilter");
                item.setChecked(false);
            }

        }
        else if (item.getItemId() == 2) {
            check_color++;
            if (check_color % 2 == 1) {
                item.setChecked(true);
                mypainter.setOperation("coloring");

            } else {
                mypainter.setOperation("nofilter");
                item.setChecked(false);
            }

        }
        else if (item.getItemId() == 3) {
            check++;
            if (check % 2 == 1) {
                item.setChecked(true);
                mypainter.setOperation("big");
            } else {
                item.setChecked(false);
                mypainter.setOperation("small");
            }
        }
        else if (item.getItemId() == 4) {
            mypainter.setOperation("red");
        }
        else if (item.getItemId() == 5) {
            mypainter.setOperation("blue");
        }
        return super.onOptionsItemSelected(item);
    }

    public String getExternalPath() {
        String sdPath = "";
        String ext = Environment.getExternalStorageState();
        if (ext.equals(Environment.MEDIA_MOUNTED)) {
            sdPath = Environment.getExternalStorageDirectory().getAbsolutePath() +
                    "/";
            //sdPath = "/mnt/sdcard/";
        } else
            sdPath = getFilesDir() + "";
        //Toast.makeText(this, sdPath, Toast.LENGTH_SHORT).show();
        return sdPath;
    }


    public void onClick(View v){
        if(v.getId()==R.id.b1) {
            mypainter.setOperation("clear");
        }
        else if(v.getId()==R.id.b2){
            mypainter.setOperation("open");
        }
        else if(v.getId()==R.id.b3){
            mypainter.setOperation("save");
            mypainter.path = getFilesDir() + "";
        }
        else if(v.getId()==R.id.b4){
            checkBox.setChecked(true);
            mypainter.IsChecked = true;
            mypainter.setOperation("rotate");
        }
        else if(v.getId()==R.id.b5){
            mypainter.IsChecked = true;
            checkBox.setChecked(true);
            mypainter.setOperation("move");
        }
        else if(v.getId()==R.id.b6){
            mypainter.IsChecked = true;
            checkBox.setChecked(true);
            mypainter.setOperation("scale");
        }
        else if(v.getId()==R.id.b7){
            mypainter.IsChecked = true;
            checkBox.setChecked(true);
            mypainter.setOperation("skew");
        }
    }
}

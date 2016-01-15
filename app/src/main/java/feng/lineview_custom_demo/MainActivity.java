package feng.lineview_custom_demo;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
    LineView mLineViewOne;
    LineView mLineViewTwo;
    LineView mLineViewThr;
    LineView mLineViewFor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mLineViewOne = (LineView) findViewById(R.id.lineview_one);
         mLineViewTwo = (LineView) findViewById(R.id.lineview_two);
         mLineViewThr = (LineView) findViewById(R.id.lineview_three);
         mLineViewFor = (LineView) findViewById(R.id.lineview_for);

        mLineViewOne.setTextValue("0");
        mLineViewTwo.setTextValue("80");
        mLineViewThr.setTextValue("199");
        mLineViewFor.setTextValue("1555");

        mLineViewOne.setPercent(1.0f);
        mLineViewTwo.setPercent(0.9f);
        mLineViewThr.setPercent(0.3f);
        mLineViewFor.setPercent(0.6f);

    }

}

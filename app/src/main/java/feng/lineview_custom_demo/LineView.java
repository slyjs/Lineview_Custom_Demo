package feng.lineview_custom_demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 画比例线条 - 自定义view 小练习
 *
 * @author fengdan
 *         created at 2016/1/11 16:25
 */
public class LineView extends View {

    private Paint mPaint;
    private Paint mPercentPaint;
    private Paint mCirclePaint;
    private Paint textPaint;
    private Paint textValuePaint;
    private String text = "";
    private String textUnit = "";
    private String valuetext = "";
    private float percent = 1.0f;

    public LineView(Context context) {
        super(context);
        initview(null, 0);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview(attrs, 0);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview(attrs, defStyleAttr);
    }

    public void setTextValue(String text) {
        this.valuetext = text;
        invalidate();
    }

    public void setPercent(float percent) {
        this.percent = percent;
        invalidate();
    }

    private void initview(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
            attrs, R.styleable.LineView, defStyle, 0);
        text = a.getString(R.styleable.LineView_lineview_text);
        textUnit = a.getString(R.styleable.LineView_lineview_unit);
        a.recycle();
        //画灰色线条的画笔
        mPaint = new Paint();
        mPaint.setColor(Color.rgb(85, 86, 88));
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        //画矩形的显示比例的画笔
        mPercentPaint = new Paint();
        mPercentPaint.setColor(Color.rgb(12, 130, 231));
        mPercentPaint.setStrokeWidth(14);
        mPercentPaint.setAntiAlias(true);
        mPercentPaint.setStyle(Paint.Style.FILL);

        //说明文字的画笔
        textPaint = new Paint();
        textPaint.setColor(Color.rgb(128, 128, 128));
        textPaint.setTextSize(32);
        textPaint.setAntiAlias(true);
        //value的画笔
        textValuePaint = new Paint();
        textValuePaint.setColor(Color.WHITE);
        textValuePaint.setTextSize(48);
        textValuePaint.setAntiAlias(true);
        textValuePaint.setFakeBoldText(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //例如 text = 本次油耗
        canvas.drawText(text, 20, 50, textPaint);
        float leng = textValuePaint.measureText(valuetext);

        //数值的位数不一样，开始画数值的x坐标也会不同
        if (leng > 100) {   //当 value为四位数时 如：value = 1000
            canvas.drawText(valuetext, getMeasuredWidth() - 308, 50, textValuePaint);
        } else if (leng > 80) { //当 value 为三位数时 如：value = 100
            canvas.drawText(valuetext, getMeasuredWidth() - 280, 50, textValuePaint);
        } else if (leng > 50) {//当 value 为两位数时 如：value = 90
            canvas.drawText(valuetext, getMeasuredWidth() - 253, 50, textValuePaint);
        } else {  //当 value为一位数时 如：value = 0
            canvas.drawText(valuetext, getMeasuredWidth() - 228, 50, textValuePaint);
        }
        //画单位
        canvas.drawText(textUnit, getMeasuredWidth() - 200, 50, textValuePaint);
        RectF oval1 = new RectF(0 + 2, getMeasuredHeight() - 68, getMeasuredWidth(), getMeasuredHeight() - 60);//
        canvas.drawRoundRect(oval1, 20, 15, mPaint);//第二个参数是x半径，第三个参数是y半径
        //画圆角矩形
        RectF oval3 = new RectF(0, getMeasuredHeight() - 70, getMeasuredWidth() * percent, getMeasuredHeight() - 56);//
        // 设置个新的长方形
        canvas.drawRoundRect(oval3, 20, 15, mPercentPaint);//第二个参数是x半径，第三个参数是y半径

    }
}

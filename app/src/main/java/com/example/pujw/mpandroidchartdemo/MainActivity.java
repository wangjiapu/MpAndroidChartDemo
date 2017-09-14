package com.example.pujw.mpandroidchartdemo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity   {
    private PieChart mChart;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 设置 pieChart 图表基本属性
        mChart=(PieChart) findViewById(R.id.chart1);
        mChart.setUsePercentValues(false);            //使用百分比显示
        mChart.getDescription().setEnabled(false);    //设置pieChart图表的描述
        mChart.setBackgroundColor(Color.WHITE);      //设置pieChart图表背景色
        mChart.setExtraOffsets(5, 10, 60, 10);        //设置pieChart图表上下左右的偏移，类似于外边距
        mChart.setDragDecelerationFrictionCoef(0.95f);//设置pieChart图表转动阻力摩擦系数[0,1]
        mChart.setRotationAngle(0);                   //设置pieChart图表起始角度
        mChart.setRotationEnabled(true);              //设置pieChart图表是否可以手动旋转
        mChart.setHighlightPerTapEnabled(true);       //设置piecahrt图表点击Item高亮是否可用
        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);// 设置pieChart图表展示动画效果

// 设置 pieChart 图表Item文本属性
        mChart.setDrawEntryLabels(true);              //设置pieChart是否只显示饼图上百分比不显示文字（true：下面属性才有效果）
        mChart.setEntryLabelColor(Color.WHITE);       //设置pieChart图表文本字体颜色
        //mChart.setEntryLabelTypeface();     //设置pieChart图表文本字体样式
        mChart.setEntryLabelTextSize(10f);            //设置pieChart图表文本字体大小

// 设置 pieChart 内部圆环属性
        mChart.setDrawHoleEnabled(true);              //是否显示PieChart内部圆环(true:下面属性才有意义)
        mChart.setHoleRadius(28f);                    //设置PieChart内部圆的半径(这里设置28.0f)
        mChart.setTransparentCircleRadius(31f);       //设置PieChart内部透明圆的半径(这里设置31.0f)
        mChart.setTransparentCircleColor(Color.BLACK);//设置PieChart内部透明圆与内部圆间距(31f-28f)填充颜色
        mChart.setTransparentCircleAlpha(50);         //设置PieChart内部透明圆与内部圆间距(31f-28f)透明度[0~255]数值越小越透明
        mChart.setHoleColor(Color.WHITE);             //设置PieChart内部圆的颜色
        mChart.setDrawCenterText(true);               //是否绘制PieChart内部中心文本（true：下面属性才有意义）
       // mChart.setCenterTextTypeface(mTfLight);
        mChart.setCenterText("c盘");
        mChart.setCenterTextSize(10f);
        mChart.setCenterTextColor(Color.RED);

        setData();
       // mChart.setOnChartValueSelectedListener(this);

    }
    private void setData() {
        ArrayList<PieEntry> pieEntryList = new ArrayList<PieEntry>();
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.parseColor("#f17548"));
        colors.add(Color.parseColor("#FF9933"));
        //饼图实体 PieEntry
        PieEntry CashBalance = new PieEntry(80, "未使用");
        PieEntry ConsumptionBalance = new PieEntry(10, "已使用");
        pieEntryList.add(CashBalance);
        pieEntryList.add(ConsumptionBalance);
        //饼状图数据集 PieDataSet
        PieDataSet pieDataSet = new PieDataSet(pieEntryList, "使用图解");
        pieDataSet.setSliceSpace(3f);           //设置饼状Item之间的间隙
        pieDataSet.setSelectionShift(10f);      //设置饼状Item被选中时变化的距离
        pieDataSet.setColors(colors);           //为DataSet中的数据匹配上颜色集(饼图Item颜色)
        //最终数据 PieData
        PieData pieData = new PieData(pieDataSet);
        pieData.setDrawValues(true);            //设置是否显示数据实体(百分比，true:以下属性才有意义)
        pieData.setValueTextColor(Color.BLUE);  //设置所有DataSet内数据实体（百分比）的文本颜色
        pieData.setValueTextSize(12f);          //设置所有DataSet内数据实体（百分比）的文本字体大小
        //pieData.setValueTypeface(mTfLight);     //设置所有DataSet内数据实体（百分比）的文本字体样式
        pieData.setValueFormatter(new PercentFormatter());//设置所有DataSet内数据实体（百分比）的文本字体格式
        mChart.setData(pieData);
        mChart.highlightValues(null);
        mChart.invalidate();                    //将图表重绘以显示设置的属性和数据
    }

}

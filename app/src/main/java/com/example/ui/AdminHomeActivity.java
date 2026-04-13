package com.example.ui;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.card.MaterialCardView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import android.graphics.Color;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

public class AdminHomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private MaterialCardView btnMenu;
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);

        // 1. Ánh xạ View
        drawerLayout = findViewById(R.id.drawerLayout);
        btnMenu = findViewById(R.id.btnMenuCard);
        lineChart = findViewById(R.id.lineChart);

        // 2. Xử lý mở Sidebar khi click vào nút Menu
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở sidebar từ bên phải (vì layout_gravity="end")
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        // Gọi Helper để kích hoạt các nút bấm trong Sidebar
        AdminSidebarNavigationHelper.setupSidebar(this, drawerLayout);

        // 3. Thiết lập dữ liệu giả cho LineChart
        setupLineChart();
    }

    private void setupLineChart() {
        // 1. Dữ liệu cho Học viên
        List<Entry> studentEntries = new ArrayList<>();
        studentEntries.add(new Entry(1, 10));
        studentEntries.add(new Entry(2, 25));
        studentEntries.add(new Entry(3, 18));
        studentEntries.add(new Entry(4, 40));
        studentEntries.add(new Entry(5, 35));

        // 2. Dữ liệu cho Giảng viên (Ví dụ)
        List<Entry> teacherEntries = new ArrayList<>();
        teacherEntries.add(new Entry(1, 5));
        teacherEntries.add(new Entry(2, 8));
        teacherEntries.add(new Entry(3, 12));
        teacherEntries.add(new Entry(4, 10));
        teacherEntries.add(new Entry(5, 15));

        // --- Tùy chỉnh tập dữ liệu Học viên (Màu Xanh Dương) ---
        LineDataSet studentDataSet = new LineDataSet(studentEntries, "Số lượng học viên");
        studentDataSet.setMode(LineDataSet.Mode.LINEAR); // Đường thẳng, không bo cong
        studentDataSet.setColor(Color.parseColor("#1976D2"));
        studentDataSet.setLineWidth(3f);
        studentDataSet.setCircleColor(Color.parseColor("#1976D2"));
        studentDataSet.setDrawCircleHole(true);
        studentDataSet.setCircleHoleColor(Color.WHITE);
        studentDataSet.setCircleRadius(4f);

        // --- Tùy chỉnh tập dữ liệu Giảng viên (Màu Đỏ Cam) ---
        LineDataSet teacherDataSet = new LineDataSet(teacherEntries, "Số lượng giảng viên");
        teacherDataSet.setMode(LineDataSet.Mode.LINEAR); // Đường thẳng, không bo cong
        teacherDataSet.setColor(Color.parseColor("#FF5722"));
        teacherDataSet.setLineWidth(3f);
        teacherDataSet.setCircleColor(Color.parseColor("#FF5722"));
        teacherDataSet.setDrawCircleHole(true);
        teacherDataSet.setCircleHoleColor(Color.WHITE);
        teacherDataSet.setCircleRadius(4f);

        // 3. Gộp cả hai đường vào LineData
        LineData lineData = new LineData(studentDataSet, teacherDataSet);
        lineData.setValueTextSize(10f);
        lineData.setValueTextColor(Color.BLACK); // Làm nổi bật số liệu trên nền trắng

        lineChart.setData(lineData);

        // --- Tối ưu giao diện biểu đồ ---
        lineChart.getDescription().setEnabled(false);

        // Tùy chỉnh trục X (Bên dưới)
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // Khoảng cách giữa các điểm là 1 đơn vị

        // Tùy chỉnh trục Y
        lineChart.getAxisRight().setEnabled(false); // Tắt trục phải cho đỡ rối
        lineChart.getAxisLeft().setGridColor(Color.LTGRAY); // Lưới ngang mờ để dễ nhìn

        // Hiển thị chú thích (Legend)
        Legend legend = lineChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);

        lineChart.animateY(1000);
        lineChart.invalidate();
    }
//    // Đóng drawer khi nhấn nút back thay vì thoát app ngay
//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
//            drawerLayout.closeDrawer(GravityCompat.END);
//        } else {
//            super.onBackPressed();
//        }
//    }
}
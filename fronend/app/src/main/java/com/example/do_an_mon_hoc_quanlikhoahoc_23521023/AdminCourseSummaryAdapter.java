package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public class AdminCourseSummaryAdapter extends RecyclerView.Adapter<AdminCourseSummaryAdapter.CourseViewHolder> {

    private Context context;
    private List<AdminCourseSummary> courseList;

    public AdminCourseSummaryAdapter(Context context, List<AdminCourseSummary> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Sử dụng file summary bạn vừa đổi tên
        View view = LayoutInflater.from(context).inflate(R.layout.admin_course_summary, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        AdminCourseSummary course = courseList.get(position);

        holder.txtTitle.setText(course.getTitle());
        holder.txtLecturer.setText("Giảng viên: " + course.getLecturer());
        holder.txtDate.setText("Ngày đăng: " + course.getPostDate());

        // CHỨC NĂNG XEM CHI TIẾT
        holder.btnDetails.setOnClickListener(v -> {
            Intent intent = new Intent(context, AdminCourseDetailActivity.class);
            // Gửi dữ liệu qua trang chi tiết để hiển thị
            intent.putExtra("COURSE_ID", course.getId());
            intent.putExtra("COURSE_TITLE", course.getTitle());
            context.startActivity(intent);
        });

        // Xử lý Duyệt / Từ chối (Bạn có thể thêm logic Database ở đây)
        holder.btnApprove.setOnClickListener(v -> { /* Code Duyệt */ });
        holder.btnReject.setOnClickListener(v -> { /* Code Từ chối */ });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtLecturer, txtDate;
        MaterialButton btnDetails, btnApprove, btnReject;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtCourseTitle);
            txtLecturer = itemView.findViewById(R.id.txtLecturer);
            txtDate = itemView.findViewById(R.id.txtPostDate);
            btnDetails = itemView.findViewById(R.id.btnDetails);
            btnApprove = itemView.findViewById(R.id.btnApprove);
            btnReject = itemView.findViewById(R.id.btnReject);
        }
    }
}
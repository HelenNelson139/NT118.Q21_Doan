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
import com.google.android.material.imageview.ShapeableImageView;
import java.util.List;

public class AdminUserSummaryAdapter extends RecyclerView.Adapter<AdminUserSummaryAdapter.UserViewHolder> {

    private Context context;
    private List<AdminUserSummary> userList;

    public AdminUserSummaryAdapter(Context context, List<AdminUserSummary> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Sử dụng file admin_user_summary.xml
        View view = LayoutInflater.from(context).inflate(R.layout.admin_user_summary, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        AdminUserSummary user = userList.get(position);

        // Đổ dữ liệu vào các View
        holder.txtId.setText("ID User: " + user.getUserId());
        holder.txtName.setText("Họ tên: " + user.getUserName());
        holder.imgAvatar.setImageResource(user.getAvatarResource());

        // CHỨC NĂNG XEM CHI TIẾT
        holder.btnDetails.setOnClickListener(v -> {
            // Giả định bạn sẽ có một Activity là AdminUserDetailActivity để xem chi tiết User
            Intent intent = new Intent(context, AdminUserDetailActivity.class);

            // Gửi dữ liệu user sang trang chi tiết
            intent.putExtra("USER_ID", user.getUserId());
            intent.putExtra("USER_NAME", user.getUserName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    /**
     * Hàm cập nhật danh sách dữ liệu (Dùng khi chuyển đổi Tab Giảng viên/Học sinh)
     */
    public void updateList(List<AdminUserSummary> newList) {
        this.userList = newList;
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView imgAvatar;
        TextView txtId, txtName;
        MaterialButton btnDetails;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgUserAvatar);
            txtId = itemView.findViewById(R.id.txtUserId);
            txtName = itemView.findViewById(R.id.txtUserName);
            btnDetails = itemView.findViewById(R.id.btnDetails);
        }
    }
}
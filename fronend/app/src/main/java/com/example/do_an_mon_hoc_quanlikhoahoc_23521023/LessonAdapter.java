package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {

    Context context;
    List<Lesson> lessonList;

    public LessonAdapter(Context context, List<Lesson> lessonList) {
        this.context = context;
        this.lessonList = lessonList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_lesson_card, parent, false);   // dùng card mới

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Lesson lesson = lessonList.get(position);

        // Hiển thị dữ liệu
        holder.txtLesson.setText(lesson.getLesson());
        holder.txtTitle.setText(lesson.getTitle());

        // Click mở bài học
        holder.itemView.setOnClickListener(v -> {

            int currentPosition = holder.getAdapterPosition();

            if (currentPosition == RecyclerView.NO_POSITION) return;

            Intent intent = new Intent(context, LessonActivity.class);

            intent.putExtra("index", currentPosition);
            intent.putExtra("lesson", lesson.getLesson());
            intent.putExtra("title", lesson.getTitle());
            intent.putExtra("objective", lesson.getObjective());
            intent.putExtra("content", lesson.getContent());
            intent.putExtra("example", lesson.getExample());
            intent.putExtra("image", lesson.getImage());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lessonList == null ? 0 : lessonList.size();
    }

    // ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtLesson;
        TextView txtTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtLesson = itemView.findViewById(R.id.txtChapterLesson);
            txtTitle = itemView.findViewById(R.id.txtLessonTitle);
        }
    }
}
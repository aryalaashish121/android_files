package com.example.mydbapplication.Model;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydbapplication.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {


    List<Student> studentList = new ArrayList<>();
    Context context;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_view,viewGroup,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {

        Student student = studentList.get(i);
        studentViewHolder.tvName.setText(student.getName());
        studentViewHolder.tvEmail.setText(student.getEmail());
        studentViewHolder.tvphone.setText(student.getPhone());

        Resources resources = context.getResources();
        int studentimage = resources.getIdentifier(student.getImage(),"drawable",context.getPackageName());
        studentViewHolder.ivimage.setImageResource(studentimage);

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvphone,tvEmail;
        ImageView ivimage;
        Button btnedit,btndelete;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvstd_name);
            tvEmail = itemView.findViewById(R.id.tvstd_email);
            tvphone = itemView.findViewById(R.id.tvstd_phone);
            ivimage = itemView.findViewById(R.id.ivProfile);
            btnedit = itemView.findViewById(R.id.btn_edit);
            btndelete = itemView.findViewById(R.id.btn_Delete);
        }
    }
}

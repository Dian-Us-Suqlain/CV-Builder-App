package com.example.cvbuilder;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;

public class WorkerAdapter extends FirebaseRecyclerAdapter<Worker, WorkerAdapter.WorkerViewHolder> {

    private Context context;

    WorkerAdapter(@NonNull FirebaseRecyclerOptions<Worker> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull WorkerViewHolder holder, final int position, @NonNull final Worker model) {
        holder.tvWorkerName.setText(model.getUsername());
        holder.tvWorkerEmail.setText(model.getEmail());
        holder.tvWorkerPhone.setText(model.getPhone());

        holder.imgShowWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialog = DialogPlus.newDialog(context)
                        .setMargin(10, 10, 10, 10)
                        .setGravity(Gravity.CENTER)
                        .setContentHolder(new ViewHolder(R.layout.view_worker))
                        .setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(DialogPlus dialog, Object item, View view, int position) { }
                        })
                        .setExpanded(false)
                        .create();

                View view = dialog.getHolderView();

                final TextView tvWorkerName = view.findViewById(R.id.tv_worker_name);
                final TextView tvWorkerAbout = view.findViewById(R.id.tv_worker_about);
                final TextView tvWorkerPhone = view.findViewById(R.id.tv_worker_phone);
                final TextView tvWorkerEmail = view.findViewById(R.id.tv_worker_email);
                final TextView tvWorkerAddress = view.findViewById(R.id.tv_worker_address);

                final TextView tvInstitute = view.findViewById(R.id.tv_institute_name);
                final TextView tvDegree = view.findViewById(R.id.tv_degree);
                final TextView tvMajor1 = view.findViewById(R.id.tv_major1);
                final TextView tvMajor2 = view.findViewById(R.id.tv_major2);
                final TextView tvMajor3 = view.findViewById(R.id.tv_major3);

                final TextView tvProject1 = view.findViewById(R.id.tv_project1);
                final TextView tvProject1Desc = view.findViewById(R.id.tv_project1_desc);
                final TextView tvProject2 = view.findViewById(R.id.tv_project2);
                final TextView tvProject2Desc = view.findViewById(R.id.tv_project2_desc);

                final TextView tvResearchArea = view.findViewById(R.id.tv_area_of_interest);
                final TextView tvResearchAreaDesc = view.findViewById(R.id.tv_area_desc);

                final TextView tvKeySkill01 = view.findViewById(R.id.tv_key_skill1);
                final TextView tvKeySkill02 = view.findViewById(R.id.tv_key_skill2);
                final TextView tvKeySkill03 = view.findViewById(R.id.tv_key_skill3);

                tvWorkerName.setText(model.getUsername());
                tvWorkerAbout.setText(model.getWorkerAbout());
                tvWorkerEmail.setText(model.getEmail());
                tvWorkerPhone.setText(model.getPhone());
                tvWorkerAddress.setText(model.getAddress());

                tvInstitute.setText(model.getInstituteName());
                tvDegree.setText(model.getDegree());
                tvMajor1.setText(model.getMajor1());
                tvMajor2.setText(model.getMajor2());
                tvMajor3.setText(model.getMajor3());

                tvProject1.setText(model.getProject1());
                tvProject1Desc.setText(model.getProject1Desc());
                tvProject2.setText(model.getProject2());
                tvProject2Desc.setText(model.getProject2Desc());

                tvResearchArea.setText(model.getAreaOfInterest());
                tvResearchAreaDesc.setText(model.getGetAreaOfInterestDesc());

                tvKeySkill01.setText(model.getKeySkill1());
                tvKeySkill02.setText(model.getKeySkill2());
                tvKeySkill03.setText(model.getKeySkill3());

                dialog.show();
            }
        });
    }

    @NonNull
    @Override
    public WorkerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.worker_list, parent, false);
        return new WorkerViewHolder(view);
    }

    static class WorkerViewHolder extends RecyclerView.ViewHolder{

        TextView tvWorkerName, tvWorkerEmail, tvWorkerPhone;
        ImageView imgShowWorker;

        WorkerViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWorkerName = itemView.findViewById(R.id.tv_worker_name);
            tvWorkerEmail = itemView.findViewById(R.id.tv_email);
            tvWorkerPhone = itemView.findViewById(R.id.tv_worker_phone);
            imgShowWorker = itemView.findViewById(R.id.img_worker);
        }
    }
}

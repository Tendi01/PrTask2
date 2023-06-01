package com.mirea.kt.datastorageapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//Для связки данных и визуальных компонентов
public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder>{

    private String doctors;
    //конструктор, который принимает в качестве агрумента БД для отображения
    //изменить аргумен!!!!!!!на бд
    public DoctorAdapter(String doctors) {
        this.doctors=doctors;
    }

    //класс для реализации получения ссылки на виджет элементов списка
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView nameView;
        private final TextView specialtyView;
        private final TextView certificationFlag;

        ViewHolder(View view){
            super(view);
            //инициализируются ссылки на виджеты, которые участвуют в отображении данных элемента списка
            nameView =view.findViewById(R.id.tvDoctorName);
            specialtyView=view.findViewById(R.id.tvDoctorSpecialty);
            certificationFlag=view.findViewById(R.id.tvDoctorcertificationFlag);
        }
    }

//метод возвращает объект ViewHolder, который служит для оптимизации ресурсов и
// является своеобразном контейнером для всех элементов, входящих в список
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor,parent, false);
        return new ViewHolder(view);
    }

//метод выполняет привязку объекта ViewHolder к объекту Doctor по определенной позиции
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.nameView.setText(String.format("%s ИмяФамилия", doctor.getName()));
        holder.specialtyView.setText(String.format("%d Сертификат", doctor.getSpecialty()));
        holder.certificationFlag.setText(String.format("%f Сертификат", doctor.getCertificationFlag()));

    }

//метод возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        return doctors.size();
    }
}

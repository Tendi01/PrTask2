package com.mirea.kt.android2023;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//класс для работы со списком данный JSON
public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.Viewholder> {
    //хранение данных
    //наверно сюжа нужна БД
    //
    ArrayList<String> author;
    ArrayList<String> title;
    Context context;

    public HelperAdapter(ArrayList<String> author, ArrayList<String> title, Context context) {
        this.author = author;
        this.title = title;
        this.context = context;
    }
//передаёи данные, ключевым выводом данных является row.xml куда эти значения попадают
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        Viewholder myViewClass=new Viewholder(view);
        return myViewClass;
    }


    //узнаём колличество записей
    @Override
    public int getItemCount() {
        return author.size();
    }


    //класс ViewHolder создает объекты, представляющие элементы списка RecyclerView,
    // храня их свойства и предоставляя доступ к свойствам элемента интерфейса
    public class Viewholder extends RecyclerView.ViewHolder{
        TextView author;
        TextView title;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            author= itemView.findViewById(R.id.txauthor);
            title= itemView.findViewById(R.id.txtitle);
        }
    }
}

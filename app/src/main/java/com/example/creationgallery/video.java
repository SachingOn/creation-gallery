package com.example.creationgallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class video extends Fragment {
    View view;

    public video() {
    }

    List<book> firstbook;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.video, container, false);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.recyclerview);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getContext(), firstbook);
        myrv.setLayoutManager(new GridLayoutManager(getContext(), 1));
        myrv.setAdapter(myAdapter);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    firstbook = new ArrayList<>();
        firstbook.add(new book("Tutorial", "Categorie Book", "Description Book", R.drawable.ik));
        firstbook.add(new book("Portrait", "Categorie Book", "Description Book", R.drawable.qw));
        firstbook.add(new book("Pencil Sketch", "Categorie Book", "Description Book", R.drawable.jhjhj));
        firstbook.add(new book("Water Colour", "Categorie Book", "Description Book", R.drawable.vc));
        firstbook.add(new book("Oil Pastel", "Categorie Book", "Description Book", R.drawable.jhuhgg));
        firstbook.add(new book("Mandala", "Categorie Book", "Description Book", R.drawable.c));




    }



}
package com.example.creationgallery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<book> mData;
    private Uri tutorial = Uri.parse("https://www.youtube.com/watch?v=0VTuIj6-0KI&list=PLq1p1h1WBOnF52H-c0H0YaPfSkAn6vD0k");
    private Uri portrait = Uri.parse("https://www.youtube.com/watch?v=CXVmfu6YOkk&list=PLq1p1h1WBOnFwKlTZ-fGBDg7kMkogl-XG");
    private Uri pencil = Uri.parse("https://www.youtube.com/watch?v=RtGu7mrDf6w&list=PLq1p1h1WBOnGu_VlkURtraGQjWi8eaLYQ");
    private Uri watercolour = Uri.parse("https://www.youtube.com/watch?v=FQOUmMg8-6U&list=PLq1p1h1WBOnE8N3Ak41X0-p2ANf6bzLWh");
    private Uri oilpastel = Uri.parse("https://www.youtube.com/watch?v=0Sh1uR01wY0&list=PLq1p1h1WBOnFt6FFuIbqGb7mWCWiEcFPG");
    private Uri mandala = Uri.parse("https://www.youtube.com/watch?v=pXX8CZit5lA&list=PLq1p1h1WBOnEgmQGDoySx9T_IM-gwgkGz");


    public RecyclerViewAdapter(Context mContext, List<book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.cardview_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Toast.makeText(mContext,"Opening tutorial videos..",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW,tutorial);
                        mContext.startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(mContext,"Opening portrait video..",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(Intent.ACTION_VIEW,portrait);
                        mContext.startActivity(intent1);
                        break;

                    case 2:
                        Toast.makeText(mContext,"Opening pencil sketch videos..",Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(Intent.ACTION_VIEW,pencil);
                        mContext.startActivity(intent2);
                        break;
                    case 3:
                        Toast.makeText(mContext,"Opening water colour videos..",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(Intent.ACTION_VIEW,watercolour);
                        mContext.startActivity(intent3);
                        break;
                    case 4:
                        Toast.makeText(mContext,"Opening oil pastel videos..",Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(Intent.ACTION_VIEW,oilpastel);
                        mContext.startActivity(intent4);
                        break;
                    case 5:
                        Toast.makeText(mContext,"Opening mandala videos..",Toast.LENGTH_SHORT).show();
                        Intent intent5 = new Intent(Intent.ACTION_VIEW,mandala);
                        mContext.startActivity(intent5);
                        break;
                    

                }
                
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_book_title=(TextView)itemView.findViewById(R.id.book_title);
            img_book_thumbnail=(ImageView)itemView.findViewById(R.id.book_video);
            cardView = (CardView) itemView.findViewById(R.id.cardView_id);
        }
    }
}

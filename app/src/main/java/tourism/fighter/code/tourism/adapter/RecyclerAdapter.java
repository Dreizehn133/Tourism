package tourism.fighter.code.tourism.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tourism.fighter.code.tourism.R;
import tourism.fighter.code.tourism.model.Tourism.Datum;
import tourism.fighter.code.tourism.util.ApiHelper;
import tourism.fighter.code.tourism.util.detailClick;

/**
 * Created by Dreizehn on 4/19/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    Context c;
    List<Datum> isi;
    detailClick klik;

    public RecyclerAdapter(Context c, List<Datum> isi, detailClick klik) {
        this.c = c;
        this.isi = isi;
        this.klik=klik;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_view,parent,false);
        RecyclerHolder holder = new RecyclerHolder(v,c,isi);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        Datum data = isi.get(position);
        holder.namaTourism.setText(data.getNama());
        holder.visitor.setText(data.getVisitor()+"");
        Picasso.with(c).load(ApiHelper.ALAMAT(ApiHelper.IP)+"pic/"+data.getId()).into(holder.img);
        holder.itemView.setOnClickListener(v -> {
            klik.Click(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return isi.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
    Context con;
    List<Datum> isi;
    @BindView(R.id.namaTourism)
        TextView namaTourism;
    @BindView(R.id.visitorTourism)
        TextView visitor;
    @BindView(R.id.imgTourism)
        ImageView img;
        public RecyclerHolder(View itemView,Context con,List<Datum> isi) {
            super(itemView);
            this.con=con;
            this.isi=isi;
            ButterKnife.bind(this,itemView);
        }
    }
}

package tourism.fighter.code.tourism;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;
import tourism.fighter.code.tourism.model.Tourism.Datum;
import tourism.fighter.code.tourism.util.ApiHelper;
import tourism.fighter.code.tourism.util.Transaksi;

public class Detail extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Datum data;
    @BindView(R.id.toolbar_layout)CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.imgBack)ImageView image;

    @BindView(R.id.Tnama)TextView nama;
    @BindView(R.id.Tlokasi)TextView lokasi;
    @BindView(R.id.Toperasi)TextView operasi;
    @BindView(R.id.Tharga1)TextView harga1;
    @BindView(R.id.Tharga2)TextView harga2;
    @BindView(R.id.Tharga3)TextView harga3;
    @BindView(R.id.Tvisitor)TextView visitor;
    @BindView(R.id.Tdesk)TextView deskripsi;

    @OnClick(R.id.btnPesan)
        void pesan(){
            Log.e("pesan","masuk");
            v = inflate.from(this).inflate(R.layout.costum_dialog,null);
            spn=(Spinner) v.findViewById(R.id.spinnerKat);
            txtTotal=(TextView) v.findViewById(R.id.totHarga);
            Button submit = (Button)v.findViewById(R.id.btnSubmit);
            Button cancel = (Button) v.findViewById(R.id.btnCancel);

            final AlertDialog dialog = new AlertDialog.Builder(this).create();
            spn.setOnItemSelectedListener(this);
            submit.setOnClickListener(v ->{
//                txtTotal.setText(TotalHarga+"");
                tr.setNama(data.getNama());
                tr.setID(data.getId());
                tr.setTotal(TotalHarga);
                tr.setTrans(true);
            });
            cancel.setOnClickListener(v -> {
                dialog.dismiss();
            });
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.setView(v);
            dialog.show();
        }
    View v;
    LayoutInflater inflate;
    Spinner spn;
    TextView txtTotal;
    int TotalHarga;
    Transaksi tr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        FloatingTextButton ft = (FloatingTextButton) findViewById(R.id.btnPesan);
        ButterKnife.bind(this);
        defaultSetting();
        tr=new Transaksi(this);
    }
    void defaultSetting(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        data=getIntent().getParcelableExtra("detail");
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(this,R.color.colorPrimary));
        collapsingToolbarLayout.setTitle(data.getNama());
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapseToolbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedToolbar);
        collapsingToolbarLayout.setTitleEnabled(true);

        Picasso.with(this).load(ApiHelper.ALAMAT(ApiHelper.IP)+"pic/"+data.getId()).into(image);
        nama.setText(data.getNama());
        lokasi.setText("Lokasi : "+data.getAlamat());
        harga1.setText("Harga Dewasa : "+data.getHarga1());
        harga2.setText("Harga Remaja : "+data.getHarga2());
        harga3.setText("Harga Anak-Anak : "+data.getHarga3());
        operasi.setText("Jam Operasi : "+data.getOperasi());
        visitor.setText("Jumlah Visitor : "+data.getVisitor());
        deskripsi.setText("Deskripsi : \n"+data.getDeskripsi());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.e("Spinner",position+" - "+id);
        if(position==0){
            TotalHarga=data.getHarga1();
            txtTotal.setText(TotalHarga+"");
        }else if(position==1){
            TotalHarga=data.getHarga2();
            txtTotal.setText(TotalHarga+"");
        }else if(position==2){
            TotalHarga=data.getHarga3();
            txtTotal.setText(TotalHarga+"");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

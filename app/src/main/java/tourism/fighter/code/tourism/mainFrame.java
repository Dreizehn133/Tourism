package tourism.fighter.code.tourism;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tourism.fighter.code.tourism.model.Tourism.Datum;
import tourism.fighter.code.tourism.model.Tourism.Status;
import tourism.fighter.code.tourism.util.ApiConnection;
import tourism.fighter.code.tourism.util.ApiHelper;
import tourism.fighter.code.tourism.adapter.RecyclerAdapter;
import tourism.fighter.code.tourism.util.Session;
import tourism.fighter.code.tourism.util.Transaksi;
import tourism.fighter.code.tourism.util.detailClick;

public class mainFrame extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,detailClick {
    @BindView(R.id.parentDrawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav)NavigationView nv;
    @BindView(R.id.recycler)RecyclerView recyclerView;

    TextView tNama;
    TextView tEmail;
    ImageView imgProfil;
    ActionBarDrawerToggle drawerToggle;
    Session session;
    Transaksi tr;
    List<Datum> isi ;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);
        ButterKnife.bind(this);
        session=new Session(this);
        tr=new Transaksi(this);
        indentify();
        recyclerSetting();





    }
    void indentify(){
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View header = nv.getHeaderView(0);
        tNama=(TextView)header.findViewById(R.id.profilNama);
        tEmail=(TextView)header.findViewById(R.id.profilEmail);
        imgProfil=(ImageView)header.findViewById(R.id.profilImg);
        tNama.setText(session.getNama());
        tEmail.setText(session.getEmail());
        imgProfil.setImageResource(R.drawable.image);
        nv.setNavigationItemSelectedListener(this);
    }
    void recyclerSetting(){
        RecyclerView.LayoutManager layout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LoadDataTourism();
    }
    void LoadDataTourism(){
        Log.e("api","masukk");
        ApiConnection api = ApiHelper.retroBuilder(ApiHelper.ALAMAT(ApiHelper.IP)).create(ApiConnection.class);
        Call<Status> call = api.fetchData();
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if(response.isSuccessful()){
                    isi=new ArrayList<>();
                    isi=response.body().getData();
                    adapter=new RecyclerAdapter(getApplicationContext(),isi,mainFrame.this::Click);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Log.e("er",t.toString());
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu1){
            Log.e("menu1","KLIK GANNN");
        }else if (id==R.id.logout){
            session.clear();
            Intent in = new Intent(this,MainActivity.class);
            startActivity(in);
            finish();
        }else if (id==R.id.trans){
            if(tr.inTrans()){

            }else {
                Snackbar.make(recyclerView,"Tidak ada Transaksi",Snackbar.LENGTH_LONG).show();
            }
        }else if (id==R.id.topT){

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void Click(int position) {
        Datum d = isi.get(position);
        Intent in = new Intent(this,Detail.class);
        in.putExtra("detail",d);
        startActivity(in);
    }
}

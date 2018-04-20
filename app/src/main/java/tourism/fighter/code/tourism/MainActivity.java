package tourism.fighter.code.tourism;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import javax.security.auth.callback.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;
import tourism.fighter.code.tourism.model.Member.Data;
import tourism.fighter.code.tourism.model.Member.Status;
import tourism.fighter.code.tourism.util.ApiConnection;
import tourism.fighter.code.tourism.util.ApiHelper;
import tourism.fighter.code.tourism.util.Session;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.inEmail)
    EditText editEmail;
    @BindView(R.id.inPass)
    EditText editPass;

    @OnClick(R.id.btnLogin)
    void Login(){
        Log.e("aaa","aaaaaaa");
        ApiConnection api = ApiHelper.retroBuilder(ApiHelper.ALAMAT(ApiHelper.IP)).create(ApiConnection.class);
        Call<Status> call=api.loginAkses(editEmail.getText().toString(),editPass.getText().toString());
        Log.e("aaa","zzzzzzz");
        call.enqueue(new retrofit2.Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                try{
                    if(response.body().getStatus().equals("ok")){
                        Data d = response.body().getData();

                        session.setId_usr(d.getId().toString());
                        session.setNama(d.getNama());
                        session.setEmail(d.getEmail());
                        session.setKontak(d.getNope());
                        session.setPoint(d.getPoint());
                        session.setLogin(true);

//                    Intent in = new Intent(getApplication(),mainFrame.class);
                        startActivity(in);
                        finish();
                    }else {
                        Snackbar.make(view,"Email/Pass Tidak Ditemukan",Snackbar.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Snackbar.make(view,"Server Error",Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Log.e("er",t+"");
                Snackbar.make(view,"Server Error",Snackbar.LENGTH_LONG).show();
            }
        });
    }
    View view;
    Session session;
    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        view=findViewById(R.id.parentLogin);
        in= new Intent(getApplication(),mainFrame.class);
        session = new Session(getApplication());
        if(session.isLogin()){

            startActivity(in);
            finish();
        }
    }
}

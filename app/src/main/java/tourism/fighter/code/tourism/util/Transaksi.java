package tourism.fighter.code.tourism.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Dreizehn on 4/20/2018.
 */

public class Transaksi {
    private SharedPreferences ssp;
    private SharedPreferences.Editor editor;

    public Transaksi(Context c){
        ssp = PreferenceManager.getDefaultSharedPreferences(c);
        editor=ssp.edit();
    }
    public boolean inTrans(){
        return ssp.getBoolean("isTrans",false);
    }
    public void setTrans(boolean x){
        editor.putBoolean("isTrans",x);
        editor.commit();
    }

    public int getID(){
        return ssp.getInt("id_tour",0);
    }
    public void setID(int id){
        editor.putInt("id_tour",id);
        editor.commit();
    }
    public int getTotal(){
        return ssp.getInt("total",0);
    }
    public void setTotal(int t){
        editor.putInt("total",t);
        editor.commit();
    }
    public String getNama(){
        return ssp.getString("namatour","");
    }
    public void setNama(String n){
        editor.putString("namatour",n);
        editor.commit();
    }
    public void clear(){
        editor.clear();
        editor.commit();
    }


}

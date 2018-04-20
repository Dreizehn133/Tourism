package tourism.fighter.code.tourism.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences ssp;
    private SharedPreferences.Editor editor;

    public Session(Context c){
        ssp = PreferenceManager.getDefaultSharedPreferences(c);
        editor=ssp.edit();
    }

    public boolean isLogin() {
        return ssp.getBoolean("islogin",false);
    }

    public void setLogin(boolean login) {
        editor.putBoolean("islogin",login);
        editor.commit();
        //this.login = login;
    }

    public String getNama() {
        return ssp.getString("nama","");
    }

    public void setNama(String nama) {
        editor.putString("nama",nama);
        editor.commit();
    }
    /*
    public String getIPAddress() {
        return ssp.getString("ip","");
    }

    public void setIPAddress(String ipx) {
        editor.putString("ip",ipx);
        editor.commit();
    }
    public String getImgPath() {
        return ssp.getString("path","");
    }

    public void setImgPath(String path) {
        editor.putString("path",path);
        editor.commit();
    }
    */
    public String getId_usr() {
        return ssp.getString("id_usr","");
    }

    public void setId_usr(String id_usr) {
        editor.putString("id_usr",id_usr);
        editor.commit();
    }

    public String getEmail() {
        return ssp.getString("email","");
    }

    public void setEmail(String username) {
        editor.putString("email",username);
        editor.commit();
    }

    public String getKontak() {
        return ssp.getString("kon","");
    }

    public void setKontak(String kontak) {
        editor.putString("kon",kontak);
        editor.commit();
    }

    public String getPoint() {
        return ssp.getString("tgl","");
    }

    public void setPoint(String tgl) {
        editor.putString("tgl",tgl);
        editor.commit();
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }
}

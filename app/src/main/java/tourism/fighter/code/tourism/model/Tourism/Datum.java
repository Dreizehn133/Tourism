
package tourism.fighter.code.tourism.model.Tourism;


import android.os.Parcel;
import android.os.Parcelable;

public class Datum implements Parcelable {

    private Integer id;
    private String nama;
    private String alamat;
    private Integer lat;
    private Integer _long;
    private String operasi;
    private String deskripsi;
    private Integer harga1;
    private Integer harga2;
    private Integer harga3;
    private Integer visitor;
    private String createdAt;
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLong() {
        return _long;
    }

    public void setLong(Integer _long) {
        this._long = _long;
    }

    public String getOperasi() {
        return operasi;
    }

    public void setOperasi(String operasi) {
        this.operasi = operasi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getHarga1() {
        return harga1;
    }

    public void setHarga1(Integer harga1) {
        this.harga1 = harga1;
    }

    public Integer getHarga2() {
        return harga2;
    }

    public void setHarga2(Integer harga2) {
        this.harga2 = harga2;
    }

    public Integer getHarga3() {
        return harga3;
    }

    public void setHarga3(Integer harga3) {
        this.harga3 = harga3;
    }

    public Integer getVisitor() {
        return visitor;
    }

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
        dest.writeValue(this.lat);
        dest.writeValue(this._long);
        dest.writeString(this.operasi);
        dest.writeString(this.deskripsi);
        dest.writeValue(this.harga1);
        dest.writeValue(this.harga2);
        dest.writeValue(this.harga3);
        dest.writeValue(this.visitor);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
    }

    public Datum() {
    }

    protected Datum(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.nama = in.readString();
        this.alamat = in.readString();
        this.lat = (Integer) in.readValue(Integer.class.getClassLoader());
        this._long = (Integer) in.readValue(Integer.class.getClassLoader());
        this.operasi = in.readString();
        this.deskripsi = in.readString();
        this.harga1 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.harga2 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.harga3 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.visitor = (Integer) in.readValue(Integer.class.getClassLoader());
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
    }

    public static final Parcelable.Creator<Datum> CREATOR = new Parcelable.Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel source) {
            return new Datum(source);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };
}

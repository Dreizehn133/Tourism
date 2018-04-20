
package tourism.fighter.code.tourism.model.Transaksi;


import com.google.gson.annotations.SerializedName;

public class Data {

    private Integer id;
    @SerializedName("id_mem")
    private Integer idMem;
    @SerializedName("id_tour")
    private Integer idTour;
    private Integer nominal;
    private String status;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private Member member;
    private Tourism tourism;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMem() {
        return idMem;
    }

    public void setIdMem(Integer idMem) {
        this.idMem = idMem;
    }

    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Tourism getTourism() {
        return tourism;
    }

    public void setTourism(Tourism tourism) {
        this.tourism = tourism;
    }

}

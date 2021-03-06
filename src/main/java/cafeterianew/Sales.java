package cafeterianew;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Sales_table")
public class Sales {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer amt;
    private String yyyymm;

    @PostPersist
    public void onPostPersist(){
        FirstSaled firstSaled = new FirstSaled();
        BeanUtils.copyProperties(this, firstSaled);
        firstSaled.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        SalesAdded salesAdded = new SalesAdded();
        BeanUtils.copyProperties(this, salesAdded);
        salesAdded.publishAfterCommit();


    }

    @PostRemove
    public void onPostRemove(){
        SalesSubtracted salesSubtracted = new SalesSubtracted();
        BeanUtils.copyProperties(this, salesSubtracted);
        salesSubtracted.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }
    public String getYyyymm() {
        return yyyymm;
    }

    public void setYyyymm(String yyyymm) {
        this.yyyymm = yyyymm;
    }




}

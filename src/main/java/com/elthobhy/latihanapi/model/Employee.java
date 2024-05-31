package com.elthobhy.latihanapi.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_m_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "biodata_id")
    private long biodataId;
    @Column(name = "nip", length = 5, nullable = false)
    private String nip;
    @Column(name = "status", length = 10, nullable = false)
    private String status;
    @Column(name = "salary")
    private int salary;

    @OneToOne
    @JoinColumn(name="biodata_id", insertable=false, updatable=false)
    private Biodata biodata;

    @Column(name="deleted")
    private boolean deleted;
    @Column(name = "create_by")
    private int createBy;
    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column(name = "update_by")
    private int updateBy;
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getBiodataId() {
        return biodataId;
    }
    public void setBiodataId(long biodataId) {
        this.biodataId = biodataId;
    }
    public String getNip() {
        return nip;
    }
    public void setNip(String nip) {
        this.nip = nip;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Biodata getBiodata() {
        return biodata;
    }
    public void setBiodata(Biodata biodata) {
        this.biodata = biodata;
    }
    public int getCreateBy() {
        return createBy;
    }
    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public int getUpdateBy() {
        return updateBy;
    }
    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}

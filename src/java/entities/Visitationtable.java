package entities;
// Generated Jul 25, 2012 3:05:56 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Visitationtable generated by hbm2java
 */
public class Visitationtable  implements java.io.Serializable {


     private Integer visitid;
     private String patientid;
     private Date date;
     private String vitals;
     private String doctor;
     private String status;

    public Visitationtable() {
    }

	
    public Visitationtable(String patientid) {
        this.patientid = patientid;
    }
    public Visitationtable(String patientid, Date date, String vitals, String doctor, String status) {
       this.patientid = patientid;
       this.date = date;
       this.vitals = vitals;
       this.doctor = doctor;
       this.status = status;
    }
   
    public Integer getVisitid() {
        return this.visitid;
    }
    
    public void setVisitid(Integer visitid) {
        this.visitid = visitid;
    }
    public String getPatientid() {
        return this.patientid;
    }
    
    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getVitals() {
        return this.vitals;
    }
    
    public void setVitals(String vitals) {
        this.vitals = vitals;
    }
    public String getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}



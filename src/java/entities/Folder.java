package entities;
// Generated Jul 25, 2012 3:05:56 AM by Hibernate Tools 3.2.1.GA



/**
 * Folder generated by hbm2java
 */
public class Folder  implements java.io.Serializable {


     private String foldernumber;
     private String shelvenumber;
     private String status;

    public Folder() {
    }

	
    public Folder(String foldernumber) {
        this.foldernumber = foldernumber;
    }
    public Folder(String foldernumber, String shelvenumber, String status) {
       this.foldernumber = foldernumber;
       this.shelvenumber = shelvenumber;
       this.status = status;
    }
   
    public String getFoldernumber() {
        return this.foldernumber;
    }
    
    public void setFoldernumber(String foldernumber) {
        this.foldernumber = foldernumber;
    }
    public String getShelvenumber() {
        return this.shelvenumber;
    }
    
    public void setShelvenumber(String shelvenumber) {
        this.shelvenumber = shelvenumber;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import helper.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author afuaantwi
 */
public class HMSHelper {

    Session session = null;

    public HMSHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    /*
     * Creating or adding new instances / rows into the database
     */

    public Patient createPatient(String patientid, String fname, String lname, String midname, String gender, String Address, String employer, String dob, String contact, String emergencyperson, String emergencycontact, String email) throws Exception {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Patient patient = new Patient();
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        date = (Date) formatter.parse(dob);
        patient.setFname(fname);
        patient.setLname(lname);
        patient.setPatientid(patientid);
        patient.setAddress(Address);
        patient.setContact(contact);
        patient.setDateofbirth(date);
        patient.setEmail(email);
        patient.setEmployer(employer);
        patient.setEmergencyperson(emergencyperson);
        patient.setGender(gender);
        patient.setMidname(midname);
        patient.setEmergencycontact(emergencycontact);
        patient.setDateofregistration(new Date());

        session.save(patient);

        session.getTransaction().commit();
        return patient;
    }

    public Folder createFolder(String foldernumber, String shelvenumber, String status) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Folder folder = new Folder();
        folder.setFoldernumber(foldernumber);
        folder.setShelvenumber(shelvenumber);
        folder.setStatus(status);
        session.save(folder);
        session.getTransaction().commit();
        return folder;

    }

    public Sponsorship createSponsor(String sponsorName, String sponsorType, String sponsorAddress, String sponsorContact, String sponsorEmail) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Sponsorship sponsor = new Sponsorship();
        sponsor.setAddress(sponsorAddress);
        sponsor.setContact(sponsorContact);
        sponsor.setEmail(sponsorEmail);
        sponsor.setSponsorname(sponsorName);
        sponsor.setType(sponsorType);
        session.save(sponsor);
        session.getTransaction().commit();
        return sponsor;
    }

    public Sponsorhipdetails createPatientSponsorshipDetails(String patientID, String membershipID, String type, String benefitPlan, int companyName) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Sponsorhipdetails sponsorDetails = new Sponsorhipdetails();
        sponsorDetails.setPatientid(patientID);
        sponsorDetails.setBenefitplan(benefitPlan);
        sponsorDetails.setSponsorid(companyName);
        sponsorDetails.setType(type);
        sponsorDetails.setMembershipid(membershipID);
        session.save(sponsorDetails);
        session.getTransaction().commit();
        return sponsorDetails;
    }

    public Units addUnit(String name) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Units unit = new Units();
        unit.setUnitname(name);

        session.save(unit);
        session.getTransaction().commit();
        return unit;
    }

    public Consultingrooms addConRoom(String name) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Consultingrooms conroom = new Consultingrooms();
        conroom.setConsultingroom(name);

        session.save(conroom);
        session.getTransaction().commit();
        return conroom;
    }

    public Visitationtable createNewVisit(String patientID, String doctor, String vitals, String status) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Visitationtable visitation = new Visitationtable();
        visitation.setPatientid(patientID);
        visitation.setVitals(vitals);
        visitation.setDoctor(doctor);
        visitation.setDate(new Date());
        visitation.setStatus(status);
        session.save(visitation);
        session.getTransaction().commit();
        return visitation;
    }

    public Treatment createNewVisit(String treatment) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Treatment treatmentObj = new Treatment();
        treatmentObj.setTreatment(treatment);

        session.save(treatmentObj);
        session.getTransaction().commit();
        return treatmentObj;
    }

    public Diagnosis addANewDiagnosis(String code, String diagnosis) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Diagnosis diagnosisObj = new Diagnosis();
        diagnosisObj.setDiagnosisCode(code);
        diagnosisObj.setDiagnosis(diagnosis);

        session.save(diagnosisObj);
        session.getTransaction().commit();
        return diagnosisObj;
    }

    public Investigation addAnInvestigation(String investigation) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Investigation investigationObj = new Investigation();
        investigationObj.setInvestigation(investigation);

        session.save(investigationObj);
        session.getTransaction().commit();
        return investigationObj;
    }

    public Patientinvestigation addPatientInvestigation(String patientid, String code, String investigation, String result, Double price, int visitationid, String visitDate, String performed, String notes, int qty) throws ParseException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        date = (Date) formatter.parse(visitDate);

        Patientinvestigation patientInvestigation = new Patientinvestigation();
        //patientInvestigation.setId(patientid);
        patientInvestigation.setCode(code);
        patientInvestigation.setPrice(price);
        patientInvestigation.setInvestigation(investigation);
        patientInvestigation.setResult(result);
        patientInvestigation.setDate(date);
        patientInvestigation.setPatientid(patientid);
        patientInvestigation.setVisitationid(visitationid);
        patientInvestigation.setPerformed(performed);
        patientInvestigation.setNote(notes);
        patientInvestigation.setQuantity(qty);

        session.save(patientInvestigation);
        session.getTransaction().commit();
        return patientInvestigation;
    }

    public Patienttreatment addPatientTreatment(String patientid, String code, String treatement, String dosage, Double price, String dispensed, int visitationid, String visitDate, String notes, int qty, String type) throws ParseException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Date date;
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        date = (Date) formatter.parse(visitDate);

        Patienttreatment patientTreatment = new Patienttreatment();
        patientTreatment.setDate(date);
        patientTreatment.setCode(code);
        patientTreatment.setPrice(price);
        patientTreatment.setDispensed(dispensed);
        patientTreatment.setDosage(dosage);
        patientTreatment.setPatientid(patientid);
        patientTreatment.setTreatment(treatement);
        patientTreatment.setNote(notes);
        patientTreatment.setQuantity(qty);
        patientTreatment.setType(type);
        patientTreatment.setVisitationid(visitationid);

        session.save(patientTreatment);
        session.getTransaction().commit();
        return patientTreatment;
    }

    public Patientdiagnosis addPatientDiagnosis(String patientid, String diagnosis, String code, int visitationid, String visitDate) throws ParseException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        date = (Date) formatter.parse(visitDate);

        Patientdiagnosis patientdiagnosis = new Patientdiagnosis();
        patientdiagnosis.setDate(date);
        patientdiagnosis.setDiagnosis(diagnosis);
        patientdiagnosis.setCode(code);
        patientdiagnosis.setPatientid(patientid);
        patientdiagnosis.setVisitationid(visitationid);

        session.save(patientdiagnosis);
        session.getTransaction().commit();
        return patientdiagnosis;
    }
    /*
     * End of database additions
     *
     * Querying the database for a list of objects 
     */

    public List listSponsors() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Sponsorship").list();
        session.getTransaction().commit();
        return result;
    }

    public List listFolders() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Folder").list();
        session.getTransaction().commit();
        return result;
    }

    public List listPatients() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Patient").list();
        session.getTransaction().commit();
        return result;
    }

    public List listUnits() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Units").list();
        session.getTransaction().commit();
        return result;
    }

    public List listConRooms() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Consultingrooms").list();
        session.getTransaction().commit();
        return result;
    }

    public List listVisitations() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Visitationtable").list();
        session.getTransaction().commit();
        return result;
    }

    public List listUnitVisitations(String status, String today) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Visitationtable where status='" + status + "' and date='" + today + "'").list();
        session.getTransaction().commit();
        return result;
    }

    public List listRecentVisits(String today) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Visitationtable where date='" + today + "'").list();
        session.getTransaction().commit();
        return result;
    }

    public List patientHistory(String patientid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Visitationtable where patientid='" + patientid + "'").list();
        session.getTransaction().commit();
        return result;
    }

    public List listDiagnosis() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Diagnosis").list();
        session.getTransaction().commit();
        return result;
    }

    public List listDiagnosisShow(String letters) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Diagnosis WHERE diagnosis like '" + letters + "%'").list();
        session.getTransaction().commit();
        return result;
    }

    public List listTreatmentShow(String letters) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Treatment WHERE treatment like '" + letters + "%'").list();
        session.getTransaction().commit();
        return result;
    }

    public List listInvestigationShow(String letters) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Investigation WHERE investigation like '" + letters + "%'").list();
        session.getTransaction().commit();
        return result;
    }

    public List listNhisInvesigation(String letters) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Nhisinvestigation WHERE investigation like '" + letters + "%'").list();
        session.getTransaction().commit();
        return result;
    }

    public List listNhisTreatment(String letters) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Nhistreatment WHERE drug like '" + letters + "%'").list();
        session.getTransaction().commit();
        return result;
    }

    public List listNhisInvesigation() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Nhisinvestigation").list();
        session.getTransaction().commit();
        return result;
    }

    public List listNhisTreatment() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Nhistreatment").list();
        session.getTransaction().commit();
        return result;
    }

    public List listInvestigation() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Investigation").list();
        session.getTransaction().commit();
        return result;
    }

    public List listTreatments() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Treatment").list();
        session.getTransaction().commit();
        return result;
    }

    public List patientDiagnosis(int visitationid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Patientdiagnosis where visitationid=" + visitationid).list();
        session.getTransaction().commit();
        return result;
    }

    public List patientTreatment(int visitationid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Patienttreatment where visitationid=" + visitationid).list();
        session.getTransaction().commit();
        return result;
    }

    public List patientInvestigation(int visitationid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Patientinvestigation where visitationid=" + visitationid).list();
        session.getTransaction().commit();
        return result;
    }
    /*
     * End of methods for collecting /retrieving objects
     * 
     * Update database rows
     */

    public Folder updateFolderLocation(String location, String foldernumber) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Folder folder = (Folder) session.get(Folder.class, foldernumber);

        folder.setStatus(location);
        session.update(folder);
        session.getTransaction().commit();
        return folder;
    }

    public Sponsorhipdetails updatePatientSponsorDetails(String benefitplan, String type, String membershipid, String patientid, int sponsorid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Sponsorhipdetails details = (Sponsorhipdetails) session.get(Sponsorhipdetails.class, patientid);

        details.setBenefitplan(benefitplan);
        details.setMembershipid(membershipid);
        details.setPatientid(patientid);
        details.setSponsorid(sponsorid);
        details.setType(type);
        session.update(details);
        session.getTransaction().commit();
        return details;
    }

    public Visitationtable updateVisitation(String patientid, int visitid, String status, String vitals) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Visitationtable visit = (Visitationtable) session.get(Visitationtable.class, visitid);

        visit.setStatus(status);
        visit.setVitals(vitals);
        session.update(visit);
        session.getTransaction().commit();
        return visit;
    }

    public Patienttreatment updatePatientTreatment(int ptid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Patienttreatment folder = (Patienttreatment) session.get(Patienttreatment.class, ptid);
        folder.setDispensed("yes");
        session.update(folder);
        session.getTransaction().commit();
        return folder;
    }

    public Patientinvestigation updatePatientInvestigation(int ptid, String result) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Patientinvestigation folder = (Patientinvestigation) session.get(Patientinvestigation.class, ptid);
        folder.setResult(result);
        folder.setPerformed("yes");
        session.update(folder);
        session.getTransaction().commit();
        return folder;
    }

    public Visitationtable updateVisitationStatus(int visitid, String status) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Visitationtable visit = (Visitationtable) session.get(Visitationtable.class, visitid);

        visit.setStatus(status);
        // visit.setVitals(vitals);
        session.update(visit);
        session.getTransaction().commit();
        return visit;
    }
    /*
     * End of the collection of methods for updating objects and rows
     * 
     * Following is a collection of methods the retrieve a singular object/row
     */

    public Sponsorhipdetails sponsorshipDetails(String patientid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Sponsorhipdetails sponsorship = (Sponsorhipdetails) session.get(Sponsorhipdetails.class, patientid);

        session.getTransaction().commit();
        return sponsorship;
    }

    public Patient getPatientByID(String patientid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Patient patient = (Patient) session.get(Patient.class, patientid);

        session.getTransaction().commit();
        return patient;
    }

    public Patient getPatientByName(String fname, String lname) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Patient p = (Patient) session.createQuery("from Patient Where (fname = '" + fname + " and lname = '" + lname + "') OR (fname = '" + lname + " and lname = '" + fname + "')").list().get(0);
        session.getTransaction().commit();
        return p;
    }

    public Sponsorhipdetails getSearchedSpID(String membershipid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Sponsorhipdetails p = (Sponsorhipdetails) session.createQuery("from Sponsorshipdetails Where membershipid = '" + membershipid + "'").list().get(0);
        session.getTransaction().commit();
        return p;
    }

    public Visitationtable currentVisitations(int patientid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Visitationtable sponsorship = (Visitationtable) session.get(Visitationtable.class, patientid);

        session.getTransaction().commit();
        return sponsorship;

    }

    public Sponsorship getSponsor(int sponsorid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Sponsorship sponsor = (Sponsorship) session.get(Sponsorship.class, sponsorid);

        session.getTransaction().commit();
        return sponsor;
    }

    public Folder getPatientFolder(String patientid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Folder folder = (Folder) session.get(Folder.class, patientid);

        session.getTransaction().commit();
        return folder;
    }

    public Units getUnit(String unitid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Units units = (Units) session.get(Units.class, unitid);

        session.getTransaction().commit();
        return units;
    }

    public Diagnosis getId(String id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Diagnosis diagnosis = (Diagnosis) session.get(Diagnosis.class, id);

        session.getTransaction().commit();
        return diagnosis;
    }

    public Treatment getTreatment(int treatmentid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Treatment treatment = (Treatment) session.get(Treatment.class, treatmentid);

        session.getTransaction().commit();
        return treatment;
    }

    public Investigation getInvestigation(int investigationid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Investigation investigationObj = (Investigation) session.get(Investigation.class, investigationid);

        session.getTransaction().commit();
        return investigationObj;
    }

    public Boolean ifEmpty() {
        if (this == null) {
            return false;
        }
        return true;
    }
}
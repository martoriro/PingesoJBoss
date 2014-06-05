/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean.dataPatient;

import entities.Persons;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sessionbeans.PersonsFacadeLocal;

/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean
@RequestScoped
public class DataPatient {
    @EJB
    private PersonsFacadeLocal personsFacade;
    
    private String rut;
    private String names;
    private String fathername;
    private String mothername;
    private String email;
    private int phone;
    private int mobile;
    private int contactPhone;
    private int address;
    private int ocupation;
    private int activity;
    private String birthdate;
    private String nationality;
    private String passport;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(int contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getOcupation() {
        return ocupation;
    }

    public void setOcupation(int ocupation) {
        this.ocupation = ocupation;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
    
    public void buscar(){
        List<Persons> searchPerson = personsFacade.searchByRut(rut);
        names = searchPerson.get(0).getPerNames();
        fathername = searchPerson.get(0).getPerFathername();
        mothername = searchPerson.get(0).getPerMothername();
        email = searchPerson.get(0).getPerEmail();
        phone  = searchPerson.get(0).getPerPhone();
        mobile = searchPerson.get(0).getPerMobile();
        contactPhone = searchPerson.get(0).getPerContactPhone();
        address = searchPerson.get(0).getPerAddress();
        ocupation = searchPerson.get(0).getPerOcupation();
        activity = searchPerson.get(0).getPerActivity();
        birthdate = searchPerson.get(0).getPerBirthdate().getDay()+"/"+((int)searchPerson.get(0).getPerBirthdate().getMonth()+1)+"/"+((int)searchPerson.get(0).getPerBirthdate().getYear()+1900);
        nationality = searchPerson.get(0).getPerNationality();
        passport = searchPerson.get(0).getPerPassport();
    }
}
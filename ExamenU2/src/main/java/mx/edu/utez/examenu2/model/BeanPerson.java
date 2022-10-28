package mx.edu.utez.examenu2.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class BeanPerson {
    long id;
    String name;
    String lastname;
    Date birthday;
    int utiliza_magia;
    double estatura;
    double peso;

     int equipo;
    int magia_id;
    int tipo_lucha_id;

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getUtiliza_magia() {
        return utiliza_magia;
    }

    public void setUtiliza_magia(int utiliza_magia) {
        this.utiliza_magia = utiliza_magia;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getMagia_id() {
        return magia_id;
    }

    public void setMagia_id(int magia_id) {
        this.magia_id = magia_id;
    }

    public int getTipo_lucha_id() {
        return tipo_lucha_id;
    }

    public void setTipo_lucha_id(int tipo_lucha_id) {
        this.tipo_lucha_id = tipo_lucha_id;
    }
}
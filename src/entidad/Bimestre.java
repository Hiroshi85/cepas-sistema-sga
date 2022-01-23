/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author despa
 */
public class Bimestre {
    private Curso curso;
    private int numero;
    private double n1;
    private double n2;
    private double n3;
    private double n4;
    private double n5;
    private double n6;
    private double n7;
    private double n8;
    private String asistencia_binaria;

    public Bimestre() {
    }

    public Bimestre(Curso curso, int numero, double n1, double n2, double n3, double n4, double n5, double n6, double n7, double n8, String asistencia_binaria) {
        this.curso = curso;
        this.numero = numero;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.n6 = n6;
        this.n7 = n7;
        this.n8 = n8;
        this.asistencia_binaria = asistencia_binaria;
    }
    public double getPromedioU1(){
        double promedio=0;
        promedio+=n1+n2+n3+2*n4;
        promedio/=5;
        return promedio;
    }
    public double getPromedioU2(){
        double promedio=0;
        promedio+=n5+n6+n7+2*n8;
        promedio/=5;
        return promedio;
    }
    public double getPromedioBimestre(){
        double promedio = 0.0;
        promedio+=n1+n2+n3+n4+n5+n6+n7+n8;
        promedio/=8;
        return promedio;
    }
    
    public double getPromedio(){
        return (getPromedioU1()+getPromedioU2())/2;
    }
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getN3() {
        return n3;
    }

    public void setN3(double n3) {
        this.n3 = n3;
    }

    public double getN4() {
        return n4;
    }

    public void setN4(double n4) {
        this.n4 = n4;
    }

    public double getN5() {
        return n5;
    }

    public void setN5(double n5) {
        this.n5 = n5;
    }

    public double getN6() {
        return n6;
    }

    public void setN6(double n6) {
        this.n6 = n6;
    }

    public double getN7() {
        return n7;
    }

    public void setN7(double n7) {
        this.n7 = n7;
    }

    public double getN8() {
        return n8;
    }

    public void setN8(double n8) {
        this.n8 = n8;
    }

    public String getAsistencia_binaria() {
        return asistencia_binaria;
    }

    public void setAsistencia_binaria(String asistencia_binaria) {
        this.asistencia_binaria = asistencia_binaria;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem;

/**
 *
 * @author kevin
 */
import java.util.LinkedList;
public class KehadiranSatuSemesterPerMahasiswa {
    private int semester;
    private Mahasiswa mhs;
    private LinkedList<KehadiranPerMatkul> llKehadiranPerMatkul;

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Mahasiswa getMhs() {
        return mhs;
    }

    public void setMhs(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    public LinkedList<KehadiranPerMatkul> getLlKehadiranPerMatkul() {
        return llKehadiranPerMatkul;
    }

    public void setLlKehadiranPerMatkul(LinkedList<KehadiranPerMatkul> llKehadiranPerMatkul) {
        this.llKehadiranPerMatkul = llKehadiranPerMatkul;
    }
    
    
}

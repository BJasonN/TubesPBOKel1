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
public class NilaiSatuSemesterPerMahasiswa {
    private int semester;
    private Mahasiswa mhs;
    private LinkedList<NilaiMatkul> llnilaiMatkul;

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

    public LinkedList<NilaiMatkul> getLlnilaiMatkul() {
        return llnilaiMatkul;
    }

    public void setLlnilaiMatkul(LinkedList<NilaiMatkul> llnilaiMatkul) {
        this.llnilaiMatkul = llnilaiMatkul;
    }
    
    
}

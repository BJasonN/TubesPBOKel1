/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelasUtama;

/**
 *
 * @author kevin
 */
import java.util.LinkedList;
public class NilaiSatuSemesterPerMahasiswa {
    private int semester;
    private Mahasiswa mhs;
    private LinkedList<NilaiMatkul> nilaiMatkul;

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

    public LinkedList<NilaiMatkul> getNilaiMatkul() {
        return nilaiMatkul;
    }

    public void setNilaiMatkul(LinkedList<NilaiMatkul> nilaiMatkul) {
        this.nilaiMatkul = nilaiMatkul;
    }
    
    
}

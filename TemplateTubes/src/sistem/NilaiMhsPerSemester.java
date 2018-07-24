/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NilaiMhsPerSemester {
    private Mahasiswa mhs;
    private String sem;
    private ArrayList<NilaiSatuMatkulPerMhs>dnilai;

    public Mahasiswa getMhs() {
        return mhs;
    }

    public void setMhs(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public ArrayList<NilaiSatuMatkulPerMhs> getDnilai() {
        return dnilai;
    }

    public void setDnilai(ArrayList<NilaiSatuMatkulPerMhs> dnilai) {
        this.dnilai = dnilai;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem;

import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class NilaiSatuMatkulPerMhs {
    private Matkul matkul;
    private HashMap<String,Integer> nilai;
    private String indeks;

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }
    
    public Matkul getMatkul() {
        return matkul;
    }

    public void setMatkul(Matkul matkul) {
        this.matkul = matkul;
    }

    public HashMap<String, Integer> getNilai() {
        return nilai;
    }

    public void setNilai(HashMap<String, Integer> nilai) {
        this.nilai = nilai;
    }
}

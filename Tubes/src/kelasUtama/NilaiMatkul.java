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
import java.util.HashMap;
public class NilaiMatkul {
    private Matkul matkul;
    private HashMap<String, Integer> nilai;

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

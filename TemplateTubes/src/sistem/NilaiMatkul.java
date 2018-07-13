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
import java.util.HashMap;
public class NilaiMatkul {
    private Matkul matkul;
    private HashMap<String, Float> hmNilai;

    public Matkul getMatkul() {
        return matkul;
    }

    public void setMatkul(Matkul matkul) {
        this.matkul = matkul;
    }

    public HashMap<String, Float> getHmNilai() {
        return hmNilai;
    }

    public void setHmNilai(HashMap<String, Float> hmNilai) {
        this.hmNilai = hmNilai;
    }
    
    
}

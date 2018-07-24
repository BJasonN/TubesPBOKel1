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
public class Matkul {
    private String namaMatkul, kodeMatkul;
    private int sks;
    private HashMap<String, Float> presentaseNilai;
    
    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public HashMap<String, Float> getPresentaseNilai() {
        return presentaseNilai;
    }

    public void setPresentaseNilai(HashMap<String, Float> presentaseNilai) {
        this.presentaseNilai = presentaseNilai;
    }
    
    
}

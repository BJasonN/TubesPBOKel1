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
import java.util.Calendar;
public class Roster {
    private Dosen dosen;
    private Matkul matkul;
    private Calendar tglKelas;
    private String ruangan;

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public Matkul getMatkul() {
        return matkul;
    }

    public void setMatkul(Matkul matkul) {
        this.matkul = matkul;
    }

    public Calendar getTglKelas() {
        return tglKelas;
    }

    public void setTglKelas(Calendar tglKelas) {
        this.tglKelas = tglKelas;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }
    
    
}

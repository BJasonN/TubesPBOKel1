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
import java.util.LinkedList;
public class DosenMatkul {
    private Dosen dosen;
    private HashMap<LinkedList<Matkul>,LinkedList<NilaiSatuSemesterPerMahasiswa>> hmMatkulNilai;

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public HashMap<LinkedList<Matkul>, LinkedList<NilaiSatuSemesterPerMahasiswa>> getHmMatkulNilai() {
        return hmMatkulNilai;
    }

    public void setHmMatkulNilai(HashMap<LinkedList<Matkul>, LinkedList<NilaiSatuSemesterPerMahasiswa>> hmMatkulNilai) {
        this.hmMatkulNilai = hmMatkulNilai;
    }
    
    
}

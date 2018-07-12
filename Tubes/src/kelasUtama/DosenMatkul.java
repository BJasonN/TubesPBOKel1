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
import java.util.LinkedList;
public class DosenMatkul {
    private Dosen dosen;
    private HashMap<LinkedList<Matkul>,LinkedList<NilaiSatuSemesterPerMahasiswa>> nilaiMhs;

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public HashMap<LinkedList<Matkul>, LinkedList<NilaiSatuSemesterPerMahasiswa>> getNilaiMhs() {
        return nilaiMhs;
    }

    public void setNilaiMhs(HashMap<LinkedList<Matkul>, LinkedList<NilaiSatuSemesterPerMahasiswa>> nilaiMhs) {
        this.nilaiMhs = nilaiMhs;
    }
    
    
}

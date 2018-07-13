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
public class Dosen extends Orang{
    private HashMap<Integer, LinkedList<NilaiSatuSemesterPerMahasiswa>> nilaiAngkatan;

    public HashMap<Integer, LinkedList<NilaiSatuSemesterPerMahasiswa>> getNilaiAngkatan() {
        return nilaiAngkatan;
    }

    public void setNilaiAngkatan(HashMap<Integer, LinkedList<NilaiSatuSemesterPerMahasiswa>> nilaiAngkatan) {
        this.nilaiAngkatan = nilaiAngkatan;
    }
    
    
}

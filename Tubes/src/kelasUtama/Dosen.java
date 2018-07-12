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
public class Dosen extends Orang{
    private HashMap<Integer, LinkedList<NilaiSatuSemesterPerMahasiswa>> nilaiPerAngkatan;

    public HashMap<Integer, LinkedList<NilaiSatuSemesterPerMahasiswa>> getNilaiPerAngkatan() {
        return nilaiPerAngkatan;
    }

    public void setNilaiPerAngkatan(HashMap<Integer, LinkedList<NilaiSatuSemesterPerMahasiswa>> nilaiPerAngkatan) {
        this.nilaiPerAngkatan = nilaiPerAngkatan;
    }
    
    
}

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
public class Mahasiswa extends Orang{
    private int tahunMasuk, totSks;
    private float ipk;
    
    public Mahasiswa(String nama, String id, String password){
        super.setId(id);
        super.setNama(nama);
        super.setPassword(password);
    }
    
    public Mahasiswa(){
        
    }
    public int getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(int tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public int getTotSks() {
        return totSks;
    }

    public void setTotSks(int totSks) {
        this.totSks = totSks;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }
    
    
}

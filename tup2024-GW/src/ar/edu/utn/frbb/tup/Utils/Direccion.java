package ar.edu.utn.frbb.tup.Utils;

public class Direccion {
    // Atributos (podria agragar: pais, provincia, ciudad, barrio, etc)
        private String calle;
        private int numeroCasa;
    
        public Direccion(String calle, int numeroCasa) {
            this.calle = calle;
            this.numeroCasa = numeroCasa;
        }
    
        public String getCalle() {
            return calle;
        }
    
        public void setCalle(String calle) {
            this.calle = calle;
        }
    
        public int getNumeroCasa() {
            return numeroCasa;
        }
    
        public void setNumeroCasa(int numeroCasa) {
            this.numeroCasa = numeroCasa;
        }
}

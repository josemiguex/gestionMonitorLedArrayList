public class MonitorLED {
  
  private String modelo;
  private int precio;
  private String resolucion;
  private String marca;
  private String tipo;
  private boolean vacio = true;

    public MonitorLED (String mo, int p, String re, String ma, String ti) {
    this.modelo = mo;
    this.precio = p;
    this.resolucion = re;
    this.marca = ma;
    this.tipo = ti;
    }
    public String getModelo() {
        return modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public String getResolucion() {
        return resolucion;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isVacio() {
        return vacio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

  public String toString() {
      String datos = "";
      
      datos += "Modelo:" + this.modelo + "\n";
      datos += "Precio:" + this.precio + "\n";
      datos += "Resolución:" + this.resolucion + "\n";
      datos += "Marca:" + this.marca + "\n";
      datos += "Tipo:" + this.tipo + "\n";
      
      return String.format("| %-15s", this.modelo) + String.format("| %-15s", this.precio) + String.format("| %-15s", this.resolucion) + String.format("| %-15s", this.marca) + String.format("| %-15s", this.tipo) + "|\n";
  }

}

package Servidores;

public class ServidorVirtual {
    
    protected Integer Codigo;
    protected String RAM;     
    protected String DISCO;   
    protected String CPU;  

    
    public ServidorVirtual(Integer Codigo, String RAM, String DISCO, String CPU) {
      this.Codigo=Codigo; //"this" apunta al objeto activo por lo que this.Codigo hace referencia al atributo de "ServidorVirtual", no al parametro "Codigo" del constructor
      this.RAM=RAM; 
      this.DISCO=DISCO;
      this.CPU=CPU;
    }
}

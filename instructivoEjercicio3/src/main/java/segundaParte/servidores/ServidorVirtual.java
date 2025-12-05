package segundaParte.servidores;

public class ServidorVirtual {

    protected Integer codigo;
    protected String RAM;
    protected String DISCO;
    protected String CPU;

    private static int contadorCodigos = 1;

    public ServidorVirtual() {
        this.codigo = ++contadorCodigos;
    }

    public ServidorVirtual(String RAM, String DISCO, String CPU) {
        this.codigo = contadorCodigos++;
        this.RAM = RAM;
        this.DISCO = DISCO;
        this.CPU = CPU;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getRAM() {
        return RAM;
    }

    public void  setRAM(String RAM) {
        this.RAM = RAM;
    }
    public String getDISCO() {
        return DISCO;
    }
    public void  setDISCO(String DISCO) {
        this.DISCO = DISCO;
    }

    public String getCPU() {
        return CPU;
    }
    public void  setCPU(String CPU) {
        this.CPU = CPU;
    }
}

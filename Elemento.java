public class Elemento {
    private String id;
    private String campo1;
    private String campo2;

    public Elemento(String id, String campo1, String campo2) {
        this.id = id;
        this.campo1 = campo1;
        this.campo2 = campo2;
    }

    public String getId() {
        return id;
    }

    public String getCampo1() {
        return campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public String paraString() {
        return "ID: " + id + " | " + campo1 + " | " + campo2;
    }

    public String paraArquivo() {
        return "    new Elemento(\"" + id + "\", \"" + campo1 + "\", \"" + campo2 + "\"),";
    }
}


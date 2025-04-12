package Model;

public class Quarto {
    private int idQuarto;
    private int idReserva;
    private int idTipo;
    
    public Quarto(int idQuarto, int idReserva, int idTipo) {
        this.idQuarto = idQuarto;
        this.idReserva = idReserva;
        this.idTipo = idTipo;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
}
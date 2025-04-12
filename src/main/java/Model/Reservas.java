package Model;
import java.time.LocalDate;


public class Reservas {

    private int idReserva;
    private LocalDate dataReserva;
    private LocalDate dataRetirada;
    private String cpfHospede;
    private String cpfFuncionario;
    private int status;

    public Reservas(int idReserva, LocalDate dataReserva, LocalDate dataRetirada, String cpfHospede,
            String cpfFuncionario, int status) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.dataRetirada = dataRetirada;
        this.cpfHospede = cpfHospede;
        this.cpfFuncionario = cpfFuncionario;
        this.status = status;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getCpfHospede() {
        return cpfHospede;
    }

    public void setCpfHospede(String cpfHospede) {
        this.cpfHospede = cpfHospede;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



}

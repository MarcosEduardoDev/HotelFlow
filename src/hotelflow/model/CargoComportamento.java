package hotelflow.model;

public interface CargoComportamento {
    double calcularSalarioBase();
    double calcularAumento(Funcionario funcionario);
    double calcularBonus(Funcionario funcionario);
}
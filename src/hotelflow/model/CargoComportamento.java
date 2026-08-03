package hotelflow.model;

import hotelflow.model.Funcionario;

public interface CargoComportamento {
    double calcularSalarioBase();
    double calcularAumento(Funcionario funcionario);
    double calcularBonus(Funcionario funcionario);
}
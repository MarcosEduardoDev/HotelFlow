package hotelflow.model;

public enum Cargo implements CargoComportamento {
    RECEPCIONISTA {
        @Override
        public double calcularSalarioBase() {
            return 2500;
        }
        @Override
        public double calcularAumento(Funcionario funcionario) {
            return funcionario.getSalario() * 0.04;
        }
        @Override
        public double calcularBonus(Funcionario funcionario){
            return funcionario.getSalario() * 0.30;
        }
    },
    SERVEUR {
        @Override
        public double calcularSalarioBase() {
            return 2300;
        }
        @Override
        public double calcularAumento(Funcionario funcionario) {
            return funcionario.getSalario() * 0.05;
        }
        @Override
        public double calcularBonus(Funcionario funcionario){
            return funcionario.getSalario() * 0.40;
        }
    },
    CHEF_DE_RANG {
        @Override
        public double calcularSalarioBase() {
            return 2900;
        }
        @Override
        public double calcularAumento(Funcionario funcionario) {
            return funcionario.getSalario() * 0.06;
        }
        @Override
        public double calcularBonus(Funcionario funcionario){
            return funcionario.getSalario() * 0.50;
        }
    },
    GERENTE {
        @Override
        public double calcularSalarioBase() {
            return 3200;
        }
        @Override
        public double calcularAumento(Funcionario funcionario) {
            return funcionario.getSalario() * 0.07;
        }
        @Override
        public double calcularBonus(Funcionario funcionario){
            return funcionario.getSalario() * 0.70;
        }
    },
    DIRETOR {
        @Override
        public double calcularSalarioBase() {
            return 5000;
        }
        @Override
        public double calcularAumento(Funcionario funcionario) {
            return funcionario.getSalario() * 0.09;
        }
        @Override
        public double calcularBonus(Funcionario funcionario){
            return funcionario.getSalario() * 0.75;
        }
    }
}
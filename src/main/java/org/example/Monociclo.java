package org.example;

public class Monociclo extends Veiculo{
    Double velocidadeMaximaKm;
    Double autonomiaKM;
    Double powerInWatts;

    public Monociclo(String marca, String modelo, int ano, String cor, double preco, Double velocidadeMaximaKm, Double autonomiaKM, Double powerInWatts) {
        super(marca, modelo, ano, cor, preco);
        this.velocidadeMaximaKm = velocidadeMaximaKm;
        this.autonomiaKM = autonomiaKM;
        this.powerInWatts = powerInWatts;
    }

    public Double getVelocidadeMaximaKm() {
        return velocidadeMaximaKm;
    }

    public void setVelocidadeMaximaKm(Double velocidadeMaximaKm) {
        this.velocidadeMaximaKm = velocidadeMaximaKm;
    }

    public Double getAutonomiaKM() {
        return autonomiaKM;
    }

    public void setAutonomiaKM(Double autonomiaKM) {
        this.autonomiaKM = autonomiaKM;
    }

    public Double getPowerInWatts() {
        return powerInWatts;
    }

    public void setPowerInWatts(Double powerInWatts) {
        this.powerInWatts = powerInWatts;
    }

    @Override
    public void exibirInformacoes() {

    }
}

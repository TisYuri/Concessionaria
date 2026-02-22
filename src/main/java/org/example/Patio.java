package org.example;

import java.util.ArrayList;

public class Patio {
    private ArrayList<Carro> carros;
    private ArrayList<Monociclo> monociclos;
    private ArrayList<Moto> motos;

    public Patio() {
        this.carros = new ArrayList<>();
        this.monociclos = new ArrayList<>();
        this.motos = new ArrayList<>();
    }

    public void mostrarCarros() {
        if (!carros.isEmpty()) {
            System.out.println("### Lista de Carros ###");
            int x = 1;
            for (Carro carro : carros) {
                System.out.println(x+" - "+carro.getModelo()+" - "+carro.getAno());
                x++;
            }
        }else{
            System.out.println("Nenhum carro foi encontrado!");
        }
    }

    public void addCarro(Carro carro) {
        this.carros.add(carro);
    }

    public void removeCarro(Carro carro){
        this.carros.remove(carro);
    }

    public void mostrarMonociclos() {
        if (!monociclos.isEmpty()) {
            System.out.println("### Lista de monociclos ###");
            int x = 1;
            for (Monociclo monociclo : monociclos) {
                System.out.println(x+" - "+monociclo.getModelo()+" - "+monociclo.getAno());
                x++;
            }
        }else{
            System.out.println("Nenhum monociclo foi encontrado!");
        }
    }

    public void addMonociclo(Monociclo monociclo) {
        this.monociclos.add(monociclo);
    }

    public void removeMonociclo(Monociclo monociclo){
        this.monociclos.remove(monociclo);
    }

    public void mostrarMotos() {
        if (!motos.isEmpty()) {
            System.out.println("### Lista de Motos ###");
            int x = 1;
            for (Moto moto : motos) {
                System.out.println(x+" - "+moto.getModelo()+" - "+moto.getAno());
                x++;
            }
        }else{
            System.out.println("Nenhuma moto foi encontrada!");
        }
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public ArrayList<Monociclo> getMonociclos() {
        return monociclos;
    }

    public ArrayList<Moto> getMotos() {
        return motos;
    }

    public void addMoto(Moto moto) {
        this.motos.add(moto);
    }

    public void removeMoto(Moto moto){
        this.motos.remove(moto);
    }

    public void exibirVeiculosNoPatio() {
        this.mostrarCarros();
        System.out.println("----------------------------------");
        this.mostrarMotos();
        System.out.println("----------------------------------");
        this.mostrarMonociclos();
    }
}

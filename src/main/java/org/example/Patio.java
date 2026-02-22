package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patio {

    private ArrayList<Veiculo> veiculos;

    public Patio() {
        this.veiculos = new ArrayList<>();
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void mostrarCarros() {

        List<Carro> carros = veiculos.stream()
                .filter(v -> v instanceof Carro)
                .map(v -> (Carro) v)
                .toList();

        if (!carros.isEmpty()) {
            System.out.println("### Lista de Carros ###");

            int i = 1;
            for (Carro carro : carros) {
                System.out.println(i + " - " + carro.getModelo() + " - " + carro.getAno());
                i++;
            }

        } else {
            System.out.println("Nenhum carro foi encontrado!");
        }
    }

    public void mostrarMonociclos() {
        List<Monociclo> monociclos = veiculos.stream()
                .filter(x -> x instanceof Monociclo)
                .map(x -> (Monociclo) x )
                .toList();

        if (!monociclos.isEmpty()) {
            System.out.println("### Lista de monociclos ###");
            int x = 1;
            for (Monociclo monociclo : monociclos) {
                System.out.println(x+" - "+monociclo.getModelo()+" - "+monociclo.getAno());
                x++;
            }
        } else {
            System.out.println("Nenhum monociclo foi encontrado!");
        }
    }

    public void mostrarMotos() {

        List<Moto> motos = veiculos.stream()
                .filter(x -> x instanceof Moto)
                .map(x -> (Moto) x )
                .toList();

        if (!motos.isEmpty()) {
            System.out.println("### Lista de Motos ###");
            int x = 1;
            for (Moto moto : motos) {
                System.out.println(x+" - "+moto.getModelo()+" - "+moto.getAno());
                x++;
            }
        } else {
            System.out.println("Nenhuma moto foi encontrada!");
        }
    }

    public void exibirVeiculosNoPatio() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo foi encontrado no pátio!");
            return;
        }

        System.out.println("### Lista de Veículos no Pátio ###");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println("Veículo " + (i + 1) + ":");
            // O Java chamará o exibirInformacoes específico de cada subclasse
            veiculos.get(i).exibirInformacoes();
            System.out.println("----------------------------------");
        }
    }
}
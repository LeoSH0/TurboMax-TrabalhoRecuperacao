package com.example.TurboMaxRecuperacao.controller;

import com.example.TurboMaxRecuperacao.model.Car;
import com.example.TurboMaxRecuperacao.model.GasUsed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CalculatorController {

        @Autowired
        private CalcRepository calcRepository;
        @Autowired
        private Controller controller;
        private Long n = 0L;

        @Override
        public Double sacar(Double quantidade, Conta conta) {
            return null;
        }

        public void delete(String cname) {
            calcRepository.delete(this.consultaConta(cname));
        }

        public ContaCorrentePF cadVeiculo(String cname, String GasUsed) throws Exception {
            ContaCorrentePF contaCorrentePF = new ContaCorrentePF();
            StringBuilder message = new StringBuilder();
            if (gasUsed == null) {
                message.append("\nÉ necessário que se informe o tipo de combustível usado pelo seu carro!");
            }
            switch (GasUsed) {
                case "GASOLINA":
                    contaGasCar.setGasUsed(GasUsed.VEICULO_GASOLINA);
                    break;
                case "ALCOOL":
                    contaAlcCar.setGasUsed(GasUsed.VEICULO_ALCOOL);
                default:
                    message.append("\nTipo da conta não é suportado!");
            }
            Car car = controller.findCar(cname, brand);
            if (car != null && contaCorrentePF.getError() == null) {
                n++;
                contaCorrentePF.setNumeroConta(n);
                contaCorrentePF.setCar(car);
                calcRepository.save(contaCorrentePF);
            } else if (contaCorrentePF.getError() == null) {
                message.append("\nO carro ");
                message.append(cname).append(" informado não foi cadastrado");
            }
            if (!message.isEmpty()) {
                contaCorrentePF.setError(message.toString());
            }

            return contaAlcCar;
        }

        public ContaGas consultaConta(String cname) {

            List<ContaAlcCar> contas = (List<ContaAlcCar>) calcRepository.findAll();

            for (ContaAlcCar cc : contas) {
                if (cc.getCar() != null && cc.getCar().getName().equals(cname)) {

                    return cc;


                }
            }
            return null;
        }

        @Override
        public Double consultaSaldo(ContaCorrentePF conta) {
            return conta.getSaldo();
        }

    }


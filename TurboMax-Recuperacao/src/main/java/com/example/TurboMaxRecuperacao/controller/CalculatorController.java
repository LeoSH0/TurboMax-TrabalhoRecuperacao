package com.example.TurboMaxRecuperacao.controller;

import com.example.TurboMaxRecuperacao.model.Car;
import com.example.TurboMaxRecuperacao.model.GasCar;
import com.example.TurboMaxRecuperacao.model.GasUsed;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


public class CalculatorController implements combCar {

    StringBuilder msg = new StringBuilder();
    @Autowired
    private CalcRepository calcRepository;
    @Autowired
    private Controller controller;
    private Long n = 0L;


    public void delete(String cname) {
        calcRepository.delete(this.consultCar(cname));
    }

    public GasCar cadCar(String cname, String brand, String gasIN) throws Exception {
        GasCar gasCar = new GasCar();
        if (gasIN == null) {
            msg.append("\nÉ necessário que se informe o tipo de combustível usado pelo seu carro!");
        }
        switch (gasIN) {
            case "GASOLINA":
                GasCar.setGasUsed(GasUsed.VEICULO_GASOLINA);
                break;

            case "ALCOOL":
                GasCar.setGasUsed(GasUsed.VEICULO_ALCOOL);
                break;

            case "FLEX":
                GasCar.setGasUsed(GasUsed.VEICULO_FLEX);
                break;


            default:
                msg.append("\nEste tipo de combustivel não é suportado!");
        }
        Car car = controller.findCar(cname, brand, gasIN);
        if (car != null && GasCar.getError() == null) {
            n++;
            GasCar.setNumCar(n);
            GasCar.setCar(car);
            calcRepository.save(gasCar);
        } else if (GasCar.getError() == null) {
            msg.append("\nO carro ");
            msg.append(cname).append(" informado não foi cadastrado em nosso sistema!");
        }
        if (!msg.isEmpty()) {
            GasCar.setError(msg.toString());
        }

        return gasCar;
    }
    public GasCar consultCar(String cname) {

        List<GasCar> cars = (List<GasCar>) calcRepository.findAll();

        for (GasCar cc : cars) {
            if (cc.getCar() != null && cc.getCar().getName().equals(cname)) {

                return cc;

            }
        }
        return null;
    }

    @Override
    public Double consultGas(GasCar gas) {
        return gas.getGas();
    }

    public GasCar calcFuel(String cname, String brand, String gasIN, float kmL) {

        float cost, kmAnt, kmT, kmAt, gasPrice, alcPrice;

        String ans = "";
        gasPrice = 5.86f;
        alcPrice = 3.93f;

        BufferedReader car = new BufferedReader(new InputStreamReader(System.in));

        msg.append("\nInforme seu Veículo");

        List<GasCar> cars = (List<GasCar>) calcRepository.findAll();

        for (GasCar cc : cars) {
            if (cc.getCar() != null && cc.getCar().getName().equals(cname)) {

                return cc;

            }

                msg.append("\nInforme o tipo de combustível que desejas calcular!");


                if (cc.getCar() != null && cc.getCar().getName().equals(gasIN) && cc.getCar().getGasMC() == "GASOLINA") {


                    try {

                        msg.append("\nInsira a kilometragem ANTIGA de seu veículo!");
                        ans = car.readLine();
                        kmAnt = Float.parseFloat(ans);

                        msg.append("\nInsira a kilometragem ATUAL de seu veículo!");
                        ans = car.readLine();
                        kmAt = Float.parseFloat(ans);

                        kmT = kmAt - kmAnt;

                        cost = (kmT / kmL) * gasPrice;

                        msg.append("\nVoce andou " + kmT + ", e seu gasto foi de " + cost + " !");


                    } catch (Exception erro) {

                        msg.append("\n Insira apenas números");

                    }
                }else{

                    try {

                        msg.append("\nInsira a kilometragem ANTIGA de seu veículo!");
                        ans = car.readLine();
                        kmAnt = Float.parseFloat(ans);

                        msg.append("\nInsira a kilometragem ATUAL de seu veículo!");
                        ans = car.readLine();
                        kmAt = Float.parseFloat(ans);

                        kmT = kmAt - kmAnt;

                        cost = (kmT / kmL) * alcPrice;

                        msg.append("\nVoce andou " + kmT + ", e seu gasto foi de " + cost + " !");


                    } catch (Exception erro) {

                        msg.append("\n Insira apenas números");

                    }

                }
            msg.append("\n O carro escolhido não é flex, escolha o tipo de combustivel correto");

            }


        return null;

    }
}


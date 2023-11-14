package co.edu.udem.isv.ejemplogrpc.server;

import com.example.Calculator;
import com.example.CalculatorServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void sumar(Calculator.Operacion request, StreamObserver<Calculator.Resultado> responseObserver) {
        double resultado = request.getNumero1() + request.getNumero2();
        Calculator.Resultado response = Calculator.Resultado.newBuilder().setResultado(resultado).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void restar(Calculator.Operacion request, StreamObserver<Calculator.Resultado> responseObserver) {
        double resultado = request.getNumero1() - request.getNumero2();
        Calculator.Resultado response = Calculator.Resultado.newBuilder().setResultado(resultado).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void multiplicar(Calculator.Operacion request, StreamObserver<Calculator.Resultado> responseObserver) {
        double resultado = request.getNumero1() * request.getNumero2();
        Calculator.Resultado response = Calculator.Resultado.newBuilder().setResultado(resultado).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void dividir(Calculator.Operacion request, StreamObserver<Calculator.Resultado> responseObserver) {
        double numero1 = request.getNumero1();
        double numero2 = request.getNumero2();

        if (numero2 != 0) {
            double resultado = numero1 / numero2;
            Calculator.Resultado response = Calculator.Resultado.newBuilder().setResultado(resultado).build();
            responseObserver.onNext(response);
        } else {

            responseObserver.onError(new RuntimeException("No se puede dividir por cero"));
        }

        responseObserver.onCompleted();
    }

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8080).addService(new CalculatorServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}

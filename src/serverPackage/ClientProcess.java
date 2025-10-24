package serverPackage;
import java.io.*;
import java.net.Socket;
import OpPackage.Operation;
public class ClientProcess extends Thread {
    private Socket clientSocket;
    private int clientNumber;

    public ClientProcess(Socket socket, int number) {
        this.clientSocket = socket;
        this.clientNumber = number;
    }

    public void run() {
        try (
        		ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream())) {

            Object obj = ois.readObject();

            if (obj instanceof Operation) {
                Operation op = (Operation) obj;
                double resultat = 0;

                switch (op.getOperateur()) {
                    case '+': resultat = op.getOp1() + op.getOp2(); break;
                    case '-': resultat = op.getOp1() - op.getOp2(); break;
                    case '*': resultat = op.getOp1() * op.getOp2(); break;
                    case '/':
                        if (op.getOp2() != 0)
                            resultat = op.getOp1() / op.getOp2();
                        else
                            System.out.println("Division par zéro !");
                        break;
                    default:
                        System.out.println("Opérateur invalide !");
                }

                System.out.println("[Thread " + clientNumber + "] Calcul reçu : "
                        + op.getOp1() + " " + op.getOperateur() + " " + op.getOp2()
                        + " = " + resultat);
                ServerMT.incrementOperations();
                oos.writeDouble(resultat);
                oos.flush();
            }

            System.out.println("Client déconnecté.");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        
    }
    }}

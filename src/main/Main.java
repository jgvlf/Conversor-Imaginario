package main;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        String realS, imaginariaS, moduloS, faseS;
        double real, imaginaria, modulo, fase;
        Object resposta;
        String[] opcao = {"Retangular para Polar", "Polar para Retangular", "Sair"};
        Object selecao;
        ImageIcon logoJg = new ImageIcon("img/PI-S(001)-128.128-2200.png");
        DecimalFormat df = new DecimalFormat("0.00");
        while (true) {
            selecao = JOptionPane.showInputDialog(null, "Selecione uma opção", "Conversor Imaginário | Menu", JOptionPane.INFORMATION_MESSAGE, logoJg, opcao, opcao[0]);
            if(selecao.equals("Retangular para Polar")) {
                while (true) {
                    try {
                        realS = JOptionPane.showInputDialog(null, "Digite o valor real", "Conversor Imaginário | Rect/Polar | 1/2", JOptionPane.INFORMATION_MESSAGE);
                        if (realS.contains(".")) {
                            JOptionPane.showMessageDialog(null, "Erro, use a virgula como separador de casas decimais", "Conversor Imaginário | Rect/Polar | ERRO", JOptionPane.ERROR_MESSAGE);
                        } else {
                            real = Double.parseDouble(realS.replace(",", "."));
                            break;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro, digite um número", "Conversor Imaginário | Rect/Polar | ERRO", JOptionPane.ERROR_MESSAGE);

                    }
                }
                while (true) {
                    try {
                        imaginariaS = JOptionPane.showInputDialog(null, "Digite o valor imaginário", "Conversor Imaginário | Rect/Polar | 2/2", JOptionPane.INFORMATION_MESSAGE);
                        if (imaginariaS.contains(".")) {
                            JOptionPane.showMessageDialog(null, "Erro, use a virgula como separador de casas decimais", "Conversor Imaginário | Rect/Polar | ERRO", JOptionPane.ERROR_MESSAGE);
                        } else {
                            imaginaria = Double.parseDouble(imaginariaS.replace(",", "."));
                            break;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro, digite um número", "Conversor Imaginário | Rect/Polar | ERRO", JOptionPane.ERROR_MESSAGE);

                    }
                }
                modulo = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginaria, 2));
                fase = Math.toDegrees(Math.atan(imaginaria/real));
                resposta = df.format(modulo) + "|__" + df.format(fase) + "°";
                JOptionPane.showMessageDialog(null, "Resposta: "+ resposta, "Conversor Imaginário | Rect/Polar | Resposta", JOptionPane.INFORMATION_MESSAGE, logoJg);
            }

            if(selecao.equals("Polar para Retangular")){
                while (true) {
                    try {
                        moduloS = JOptionPane.showInputDialog(null, "Digite o modulo", "Conversor Imaginário | Polar/Rect | 1/2", JOptionPane.INFORMATION_MESSAGE);
                        if (moduloS.contains(".")) {
                            JOptionPane.showMessageDialog(null, "Erro, use a virgula como separador de casas decimais", "Conversor Imaginário | Polar/Rect | ERRO", JOptionPane.ERROR_MESSAGE);
                        } else {
                            modulo = Double.parseDouble(moduloS.replace(",", "."));
                            break;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro, digite um número", "Conversor Imaginário | Polar/Rect | ERRO", JOptionPane.ERROR_MESSAGE);

                    }
                }
                while (true) {
                    try {
                        faseS = JOptionPane.showInputDialog(null, "Digite a fase", "Conversor Imaginário | Polar/Rect | 2/2", JOptionPane.INFORMATION_MESSAGE);
                        if (faseS.contains(".")) {
                            JOptionPane.showMessageDialog(null, "Erro, use a virgula como separador de casas decimais", "Conversor Imaginário | Polar/Rect | ERRO", JOptionPane.ERROR_MESSAGE);
                        } else {
                            fase = Double.parseDouble(faseS.replace(",", "."));
                            break;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro, digite um número", "Conversor Imaginário | Polar/Rect | ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                }
                fase = Math.toRadians(fase);
                real = modulo*Math.cos(fase);
                imaginaria = modulo*Math.sin(fase);
                resposta = df.format(real) + " + j" + df.format(imaginaria);
                JOptionPane.showMessageDialog(null, "Resposta: "+ resposta, "Conversor Imaginário | Polar/Rect | Resposta", JOptionPane.INFORMATION_MESSAGE, logoJg);

            }
            if(selecao.equals("Sair")){
                System.exit(0);
            }
            if(JOptionPane.showConfirmDialog(null, "Deseja continuatr?", "Conversor Imaginário | Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, logoJg) == 1){
                break;
            }
        }
    }
}

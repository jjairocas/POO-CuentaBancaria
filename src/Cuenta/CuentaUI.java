package Cuenta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuentaUI extends JFrame {
    private JPanel MainPanel;
    private JTextField txtSaldoInicialAH;
    private JTextField txtTasadeAhorros;
    private JTextField txtDepositoAH;
    private JTextField txtRetirarAH;
    private JButton btnextractoAH;
    private JTextField txtSaldoAH;
    private JTextField txtCargoMensualAH;
    private JTextField txtCantidadTransaccionesAH;
    private JButton btnsalirAH;
    private JButton btnborrarAH;
    private JButton btnconsignarAH;
    private JButton btndepositarAH;
    private JButton btnretirarAH;
    private JButton btnDepositoInicial;
    private JButton btnretirarCORR;
    private JTextField txtSaldoCOR;
    private JButton btnextracto;
    private JTextField txtComisionCORR;
    private JTextField txtCantidadTransacionesCOR;
    private JTextField txtValorSobregiro;
    private JButton btnButton;
    private JButton btnsalir;
    private JTextField txtTasaCorriente;
    private JTextField txtValorConsignacion;
    private JTextField txtValorRetiro;
    private JButton btndepositarCORR;

    public CuentaUI()  {
        setContentPane(MainPanel);
        setTitle("Manejo de Cuentas");     //Titulo Ventana
        setSize(900, 350);      //Tamaño ventana
        setLocationRelativeTo(null);        //La ventana se posiciona en el centro
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //El boton cerrar cierra la ventana
        //setResizable(false);                //La ventana no se puede cambiar de tamaño
        //setVisible(true); Se visualiza la ventana en la parte superior izquierda

        //SECCION CUENTA DE AHORROS

        btnconsignarAH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    float SaldoInicialAH,tasaAhorrosAH;
                    SaldoInicialAH=Float.parseFloat(txtSaldoInicialAH.getText());
                    tasaAhorrosAH=Float.parseFloat((txtTasadeAhorros.getText()));


                    CuentaAhorros cuentaUsuario=new CuentaAhorros(SaldoInicialAH,tasaAhorrosAH);

                    txtSaldoInicialAH.setText("");
                    txtTasadeAhorros.setText("");

                    btndepositarAH.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            float cantidadDepositar;

                            try{
                                cantidadDepositar=Float.parseFloat(txtDepositoAH.getText());
                                cuentaUsuario.consignar(cantidadDepositar);

                                txtSaldoInicialAH.setText("");
                                txtTasadeAhorros.setText("");
                                txtDepositoAH.setText("");

                            }
                            catch (NumberFormatException exception){
                                JOptionPane.showMessageDialog(null, "Ya ingresaste datos iniciales, dale en salir e inicializa de nuevo el programa", "Datos iniciales ya ingresados",
                                        JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    });

                    btnretirarAH.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            float cantidadRetirar;

                            cantidadRetirar=Float.parseFloat(txtRetirarAH.getText());
                            cuentaUsuario.retirar(cantidadRetirar);

                            txtSaldoInicialAH.setText("");
                            txtTasadeAhorros.setText("");
                            txtDepositoAH.setText("");
                            txtRetirarAH.setText("");

                        }
                    });

                    btnextractoAH.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cuentaUsuario.extractoMensual();
                            float SaldoAH=cuentaUsuario.saldo;
                            float CargoMensAH= cuentaUsuario.comisionMensual;
                            float NumTransacciones=((cuentaUsuario.numeroConsignaciones)+(cuentaUsuario.numeroRetiros));

                            txtSaldoAH.setText(String.valueOf(SaldoAH));
                            txtCargoMensualAH.setText(String.valueOf(CargoMensAH));
                            txtCantidadTransaccionesAH.setText(String.valueOf(NumTransacciones));

                        }
                    });

                    btnborrarAH.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            txtSaldoInicialAH.setText("");
                            txtTasadeAhorros.setText("");
                            txtDepositoAH.setText("");
                            txtRetirarAH.setText("");
                            txtSaldoAH.setText("");
                            txtCargoMensualAH.setText("");
                            txtCantidadTransaccionesAH.setText("");
                        }

                    });

                }
                catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Nos has ingresado ningun dato o te faltan datos para la consignacion inicial", "Error de dato",
                            JOptionPane.ERROR_MESSAGE);

                }

            }

        });

        btnsalirAH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        //SECCION CUENTA CORRIENTE


        btnDepositoInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    float SaldoCORR,TasaCorriente;

                    SaldoCORR=Float.parseFloat(txtValorConsignacion.getText());
                    TasaCorriente=Float.parseFloat(txtTasaCorriente.getText());

                    CuentaCorriente CuentaUsuarioCorriente=new CuentaCorriente(SaldoCORR,TasaCorriente);

                    txtValorConsignacion.setText("");
                    txtTasaCorriente.setText("");

                    btndepositarCORR.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try{
                                float SaldoConsignCorr=Float.parseFloat((txtValorConsignacion.getText()));
                                CuentaUsuarioCorriente.consignar(SaldoConsignCorr);

                                txtValorConsignacion.setText("");
                                txtTasaCorriente.setText("");

                            }
                            catch (NumberFormatException exception){
                                JOptionPane.showMessageDialog(null, "Ya ingresaste datos iniciales, dale en salir e inicializa de nuevo el programa", "Datos iniciales ya ingresados",
                                        JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    });

                    btnretirarCORR.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            float ValorRetiroCORR=Float.parseFloat(txtValorRetiro.getText());
                            CuentaUsuarioCorriente.retirar(ValorRetiroCORR);

                            txtValorConsignacion.setText("");
                            txtTasaCorriente.setText("");
                            txtValorRetiro.setText("");

                        }
                    });

                    btnextracto.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            CuentaUsuarioCorriente.extractoMensual();

                            float SaldoCORR=CuentaUsuarioCorriente.saldo;
                            float CargoMensCORR=CuentaUsuarioCorriente.comisionMensual;
                            float NumTransaccCORR=(CuentaUsuarioCorriente.numeroConsignaciones+(CuentaUsuarioCorriente.numeroRetiros));
                            float ValorSobregiroCORR=((CuentaUsuarioCorriente.sobregiro));


                            txtSaldoCOR.setText(String.valueOf(SaldoCORR));
                            txtComisionCORR.setText(String.valueOf(CargoMensCORR));
                            txtCantidadTransacionesCOR.setText(String.valueOf(NumTransaccCORR));
                            txtValorSobregiro.setText(String.valueOf(ValorSobregiroCORR));

                        }
                    });

                    btnButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            txtValorConsignacion.setText("");
                            txtTasaCorriente.setText("");
                            txtValorRetiro.setText("");
                            txtSaldoCOR.setText("");
                            txtCantidadTransacionesCOR.setText("");
                            txtComisionCORR.setText("");
                            txtValorSobregiro.setText("");

                        }
                    });


                }
                catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Nos has ingresado ningun dato o te faltan datos", "Error de Datos",
                            JOptionPane.ERROR_MESSAGE);
                }



            }
        });


        btnsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}

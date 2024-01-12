package es.eney_x.eney_x;

import java.util.ArrayList;

public class Facturacion {

    private ArrayList<Factura> facturas;
    private ArrayList<MetodoPago> metodos_pago;
    private float saldo = 0;

    public Facturacion() {
    }

    public Facturacion(ArrayList<Factura> facturas, ArrayList<MetodoPago> metodos_pago, float saldo) {
        this.facturas = facturas;
        this.metodos_pago = metodos_pago;
        this.saldo = saldo;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<MetodoPago> getMetodos_pago() {
        return metodos_pago;
    }

    public void setMetodos_pago(ArrayList<MetodoPago> metodos_pago) {
        this.metodos_pago = metodos_pago;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}

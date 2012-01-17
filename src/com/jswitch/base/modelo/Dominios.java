package com.jswitch.base.modelo;

import java.util.Hashtable;
import java.util.List;
import com.jswitch.base.controlador.logger.LoggerUtil;
import com.jswitch.persona.modelo.dominio.TipoPersona;
import org.hibernate.classic.Session;
import org.openswing.swing.domains.java.Domain;

/**
 *
 * @author Orlando Becerra
 */
public class Dominios {

    public static Hashtable getDominios() {
        Hashtable domains = new Hashtable();
        domains.put(
                Dominios.EstadoCivil().getDomainId(),
                Dominios.EstadoCivil());
        domains.put(
                Dominios.Ranking().getDomainId(),
                Dominios.Ranking());
        domains.put(
                Dominios.Sexo().getDomainId(),
                Dominios.Sexo());
        domains.put(
                Dominios.Sexo2().getDomainId(),
                Dominios.Sexo2());
        domains.put(
                Dominios.TipoCedula().getDomainId(),
                Dominios.TipoCedula());
        domains.put(
                Dominios.TipoCedulaJuridica().getDomainId(),
                Dominios.TipoCedulaJuridica());
        domains.put(
                Dominios.TipoCedulaNatural().getDomainId(),
                Dominios.TipoCedulaNatural());
        domains.put(
                Dominios.TipoContribuyente().getDomainId(),
                Dominios.TipoContribuyente());
        domains.put(
                Dominios.TipoNombre().getDomainId(),
                Dominios.TipoNombre());
        domains.put(
                Dominios.Prioridad().getDomainId(),
                Dominios.Prioridad());
        domains.put(
                Dominios.TipoPersona().getDomainId(),
                Dominios.TipoPersona());
        domains.put(
                Dominios.RamoContable().getDomainId(),
                Dominios.RamoContable());
        domains.put(
                Dominios.TipoRamo().getDomainId(),
                Dominios.TipoRamo());
        domains.put(
                Dominios.TipoRecibo().getDomainId(),
                Dominios.TipoRecibo());
        domains.put(
                Dominios.EstatusRecibo().getDomainId(),
                Dominios.EstatusRecibo());
        domains.put(
                Dominios.TipoPerdida().getDomainId(),
                Dominios.TipoPerdida());
        domains.put(
                Dominios.EstatusGiro().getDomainId(),
                Dominios.EstatusGiro());
        domains.put(
                Dominios.CategoriaReporte().getDomainId(),
                Dominios.CategoriaReporte());
        domains.put(
                Dominios.EstatusComunicado().getDomainId(),
                Dominios.EstatusComunicado());
        domains.put(
                Dominios.Parentesco().getDomainId(),
                Dominios.Parentesco());
        domains.put(
                Dominios.Modulos().getDomainId(),
                Dominios.Modulos());
        domains.put(
                Dominios.TipoDevolucion().getDomainId(),
                Dominios.TipoDevolucion());

        domains.put(
                Dominios.TipoCobrador().getDomainId(),
                Dominios.TipoCobrador());
        domains.put(
                Dominios.TipoFactura().getDomainId(),
                Dominios.TipoFactura());

        domains.put(
                Dominios.FormaPago().getDomainId(),
                Dominios.FormaPago());
        domains.put(
                Dominios.TipoFormaPago().getDomainId(),
                Dominios.TipoFormaPago());
        domains.put(
                Dominios.TipoMovimientoCaja().getDomainId(),
                Dominios.TipoMovimientoCaja());
        domains.put(
                Dominios.TipoPrestamo().getDomainId(),
                Dominios.TipoPrestamo());
        domains.put(
                Dominios.TipoDocumentoPago().getDomainId(),
                Dominios.TipoDocumentoPago());
        domains.put(
                Dominios.Mes().getDomainId(),
                Dominios.Mes());
        domains.put(
                Dominios.ConceptoMovimiento().getDomainId(),
                Dominios.ConceptoMovimiento());

        return domains;
    }

    //Persona
    public static enum TipoRifEnum {

        NATURAL, JURIDICO;
    }

    public static enum TipoCedula {

        VENEZOLANO(TipoRifEnum.NATURAL, 'V'),
        JURIDICO(TipoRifEnum.JURIDICO, 'J'),
        EXTRANJERO(TipoRifEnum.NATURAL, 'E'),
        PASAPORTE(TipoRifEnum.NATURAL, 'P'),
        REGISTRO_COMERCIO(TipoRifEnum.JURIDICO, 'R'),
        GOBIERNO(TipoRifEnum.JURIDICO, 'G'),
        NATURAL_SINCEDULA(TipoRifEnum.NATURAL, 'X'),
        JURIDICO_SINCEDULA(TipoRifEnum.JURIDICO, 'Y');
        TipoRifEnum tipoPersona;
        Character in;

        private TipoCedula(TipoRifEnum tipoPersona, Character in) {
            this.tipoPersona = tipoPersona;
            this.in = in;
        }

        static public TipoCedula getTipo(String txt) {
            if (txt != null) {
                if (txt.toUpperCase().startsWith("V")) {
                    return TipoCedula.VENEZOLANO;
                } else if (txt.toUpperCase().startsWith("E")) {
                    return TipoCedula.EXTRANJERO;
                }
            }
            return VENEZOLANO;
        }

        public TipoRifEnum getTipoPersona() {
            return tipoPersona;
        }

        public Character getIn() {
            return in;
        }
    }

    public static Domain TipoCedula() { // Listo
        Domain dominio = new Domain("TipoCedula");
        TipoCedula o[] = TipoCedula.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static Domain TipoCedulaJuridica() {
        Domain dominio = new Domain("TipoCedulaJuridica");
        TipoCedula o[] = TipoCedula.values();
        for (int i = 0; i
                < o.length; i++) {
            if (o[i].tipoPersona == TipoRifEnum.JURIDICO) {
                dominio.addDomainPair(o[i], o[i].toString());
            }
        }
        return dominio;
    }

    public static Domain TipoCedulaNatural() {
        Domain dominio = new Domain("TipoCedulaNatural");
        TipoCedula o[] = TipoCedula.values();
        for (int i = 0; i
                < o.length; i++) {
            if (o[i].tipoPersona == TipoRifEnum.NATURAL) {
                dominio.addDomainPair(o[i], o[i].toString());
            }
        }
        return dominio;
    }

    public static enum Ranking { //listo

        B, A, C, D;
    }

    public static Domain Ranking() {
        Domain dominio = new Domain("Ranking");
        Ranking o[] = Ranking.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoContribuyente {

        DESCONOCIDO, FORMAL, ORDINARIO, ESPECIAL
    }

    public static Domain TipoContribuyente() { // Listo
        Domain dominio = new Domain("TipoContribuyente");
        TipoContribuyente o[] = TipoContribuyente.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum FormaPago {

        CONTADO, CREDITO
    }

    public static Domain FormaPago() { // Listo
        Domain dominio = new Domain("FormaPago");
        FormaPago o[] = FormaPago.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoFormaPago {

        EFECTIVO, CHEQUE
    }

    public static Domain TipoFormaPago() { // Listo
        Domain dominio = new Domain("TipoFormaPago");
        TipoFormaPago o[] = TipoFormaPago.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    //Persona Natural
    public static enum Sexo {

        DESCONOCIDO, MASCULINO, FEMENINO;
    }

    public static Domain Sexo() { // listo
        Domain dominio = new Domain("Sexo");
        Sexo o[] = Sexo.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static Domain Sexo2() { // listo
        Domain dominio = new Domain("Sexo2");
        Sexo o[] = Sexo.values();

        dominio.addDomainPair(o[1], o[1].toString());
        dominio.addDomainPair(o[2], o[2].toString());

        return dominio;
    }

    public static enum EstadoCivil {

        DESCONOCIDO, SOLTERO, CASADO, DIVORSIADO, VIUDO, OTRO;
    }

    public static Domain EstadoCivil() { // Listo
        Domain dominio = new Domain("EstadoCivil");
        EstadoCivil o[] = EstadoCivil.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoNombre {

        DESCONOCIDO, Sr, Sra, Srta, Ing, Lic, Dr;
    }

    public static Domain TipoNombre() { // Listo
        Domain dominio = new Domain("TipoNombre2");
        TipoNombre o[] = TipoNombre.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum Prioridad {

        ALTA, MEDIA, BAJA
    }

    public static Domain Prioridad() { // Listo
        Domain dominio = new Domain("Prioridad");
        Prioridad o[] = Prioridad.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static Domain TipoPersona() {
        Domain dominio = new Domain("TipoPersona");
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            List list = s.createQuery("FROM " + TipoPersona.class.getName()).list();
            s.close();
            for (Object o : list) {
                dominio.addDomainPair(o, ((TipoPersona) o).getNombre());
            }
        } catch (Exception ex) {
            LoggerUtil.error(Dominios.class, "getDominioTipoPersona", ex);
        }

        return dominio;
    }

    //----------------------------------//
    public static enum TipoRamo {

        INDIVIDUAL, COLECTIVO
    }

    public static Domain TipoRamo() { // Listo
        Domain dominio = new Domain("TipoRamo");
        TipoRamo o[] = TipoRamo.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum RamoContable {

        PERSONA, VEHICULO, RAMOS_GENERALES, FIANZA
    }

    public static Domain RamoContable() { // Listo
        Domain dominio = new Domain("RamoContable");
        RamoContable o[] = RamoContable.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }
    //---------------Recibo-------------

    public static enum TipoRecibo {

        PRIMERAYO, RENOVACION, PRORRATA, MODIFICACION
    }

    public static Domain TipoRecibo() { // Listo
        Domain dominio = new Domain("TipoRecibo");
        TipoRecibo o[] = TipoRecibo.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum EstatusRecibo {

        PENDIENTE_COBRO, COBRADO_PENDIENTE_COMISION, COBRADO, ANULADO
    }

    public static Domain EstatusRecibo() { // Listo
        Domain dominio = new Domain("EstatusRecibo");
        EstatusRecibo o[] = EstatusRecibo.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoPerdida {

        NINGUNO, PARCIAL, TOTAL
    }

    public static Domain TipoPerdida() { // Listo
        Domain dominio = new Domain("TipoPerdida");
        TipoPerdida o[] = TipoPerdida.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum EstatusGiro {

        PENDIENTE, COBRADO_GIRO, ANULADO
    }

    public static Domain EstatusGiro() { // Listo
        Domain dominio = new Domain("EstatusGiro");
        EstatusGiro o[] = EstatusGiro.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum Parentesco {

        TITULAR, PADRE, CONYUGE, HIJO, HIJASTRO, HERMANO, NIETO, TIO, SOBRINO, PRIMO, YERNO, SUEGRO, CUYADO, AHIJADO, ABUELO
    }

    public static Domain Parentesco() { // Listo
        Domain dominio = new Domain("Parentesco");
        Parentesco o[] = Parentesco.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum EstatusComunicado {

        PENDIENTE_ENTRAGA, PENDIENTE_RESPUESTA, OK
    }

    public static Domain EstatusComunicado() { //listo
        Domain dominio = new Domain("EstatusComunicado");
        EstatusComunicado o[] = EstatusComunicado.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum Modulos {

        PERSONAS, SINIESTROS, POLIZAS, ASEGURADOS, TITULARES, CERTIFICADOS,
        BENEFICIARIOS
        //, COMUNICADOS, FINANCIAMIENTOS, VEHICULOS
    }

    public static Domain Modulos() { //listo
        Domain dominio = new Domain("Modulos");
        Modulos o[] = Modulos.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoDevolucion { //listo

        COMPANIA, PRODUCTOR, ASEGURADO
    }

    public static Domain TipoDevolucion() {
        Domain dominio = new Domain("TipoDevolucion");
        TipoDevolucion o[] = TipoDevolucion.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoDetalleLiquidacion {

        SUMA, RESTA, NEUTRO
    }

    public static Domain TipoDetalleLiquidacion() {
        Domain dominio = new Domain("TipoDetalleLiquidacion");
        TipoDetalleLiquidacion o[] = TipoDetalleLiquidacion.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum CategoriaReporte {

        PERSONAS, x1
    }

    public static Domain CategoriaReporte() {// Listo
        Domain dominio = new Domain("CategoriaReporte");
        CategoriaReporte o[] = CategoriaReporte.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoReporte {

        D, R, E
    }

    public static enum TipoVigencia {

        ANUAL, SEMESTRAL, TRIMESTRAL, MENSUAL
    }

    public static Domain TipoVigencia() {// Listo
        Domain dominio = new Domain("TipoVigencia");
        TipoVigencia o[] = TipoVigencia.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoCobrador {

        FIJO, COBRADOR, PRODUCTOR
    }

    public static Domain TipoCobrador() {// Listo
        Domain dominio = new Domain("TipoCobrador");
        TipoCobrador o[] = TipoCobrador.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum Mes {

        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }

    public static Domain Mes() {// Listo
        Domain dominio = new Domain("Mes");
        Mes o[] = Mes.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum ConceptoMovimiento {

        GIRO, CUOTA, CAPITAL, MULTA, EXTRAORDINARIO, PAGO_PRESTAMO
    }

    public static Domain ConceptoMovimiento() {
        Domain dominio = new Domain("ConceptoMovimiento");
        ConceptoMovimiento o[] = ConceptoMovimiento.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoMovimientoCaja {

        INGRESO, EGRESO, NEUTRO
    }

    public static Domain TipoMovimientoCaja() {
        Domain dominio = new Domain("TipoMovimientoCaja");
        TipoMovimientoCaja o[] = TipoMovimientoCaja.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoDocumentoPago {

        CHEQUE, TRANSFERENCIA, RETIRO, DEPOSITO, EFECTIVO, TARJETADEBITO, TARJETACREDITO, OTRO
    }

    public static Domain TipoDocumentoPago() {
        Domain dominio = new Domain("TipoDocumentoPago");
        TipoDocumentoPago o[] = TipoDocumentoPago.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoPrestamo {

        PRESTAMO, CUOTA
    }

    public static Domain TipoPrestamo() {
        Domain dominio = new Domain("TipoPrestamo");
        TipoPrestamo o[] = TipoPrestamo.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoFactura {

        COMPRA, VENTA
    }

    public static Domain TipoFactura() {
        Domain dominio = new Domain("TipoFactura");
        TipoFactura o[] = TipoFactura.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }

    public static enum TipoOperacion {

        INSERT, UPDATE, DELETE
    }

    public static Domain TipoOperacion() {
        Domain dominio = new Domain("TipoOperacion");
        TipoOperacion o[] = TipoOperacion.values();
        for (int i = 0; i
                < o.length; i++) {
            dominio.addDomainPair(o[i], o[i].toString());
        }
        return dominio;
    }
}

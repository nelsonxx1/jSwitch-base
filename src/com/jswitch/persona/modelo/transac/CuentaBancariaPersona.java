package com.jswitch.persona.modelo.transac;

import com.jswitch.persona.modelo.maestra.Persona;
import com.jswitch.persona.modelo.dominio.TipoCuentaBancaria;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import com.jswitch.base.modelo.entidades.auditoria.AuditoriaBasica;
import com.jswitch.base.modelo.entidades.auditoria.Auditable;
import com.jswitch.base.modelo.util.bean.BeanVO;
import com.jswitch.base.modelo.util.ehts.BusinessKey;
import com.jswitch.base.modelo.util.ehts.Method;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

/**
 * Clase Asociativa entre la persona, el banco
 * y el Tipo de Cuenta
 * @version 1.0 22/05/2009
 * @since JDK 1.5
 * @see Persona
 * @see TipoCuentaBancaria
 * @author Orlando Becerra
 * @author Nelson Moncada
 */
@Entity
@Table(name = "PERS_CuentaBancariaPersona", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numero", "banco_id", "tipoCuenta_id"})})
public class CuentaBancariaPersona extends BeanVO implements Serializable, Auditable {

    /**
     * Pk autoincrementado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;
    /**
     * Numero de cuenta
     */
    @Column
    @Size(min = 20, max = 20)
    @BusinessKey
    private String numero;
    /**
     * Observacion del numero de cuenta
     */
    @Column
    @BusinessKey
    private String observacion;
    /**
     * Banco que posee la cuenta
     */
    @ManyToOne
    @NotNull
    @BusinessKey(include = Method.TO_STRING)
    private Persona banco;
    /**
     * Tipo de cuenta que posee
     */
    @ManyToOne
    @NotNull
    @BusinessKey(include = Method.TO_STRING)
    private TipoCuentaBancaria tipoCuenta;
    /**
     * 
     */
    @Column
    @BusinessKey
    private Boolean domicilio;
    /**
     */
    @Version
    @Column
    private Integer optLock;
    /**
     * Auditoria Basica de los Registros
     */
    @Embedded
    @BusinessKey
    private AuditoriaBasica auditoria;
    private transient Persona persona;

    public CuentaBancariaPersona() {
        this.domicilio= Boolean.FALSE;
    }

    public CuentaBancariaPersona(String numero, String observacion, Persona banco, TipoCuentaBancaria tipoCuenta, AuditoriaBasica auditoria) {
        this.numero = numero;
        this.observacion = observacion;
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.auditoria = auditoria;
        this.domicilio= Boolean.FALSE;
    }

    public Persona getBanco() {
        return banco;
    }

    public void setBanco(Persona banco) {
        this.banco = banco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getOptLock() {
        return optLock;
    }

    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    public TipoCuentaBancaria getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuentaBancaria tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Boolean getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Boolean domicilio) {
        this.domicilio = domicilio;
    }
}

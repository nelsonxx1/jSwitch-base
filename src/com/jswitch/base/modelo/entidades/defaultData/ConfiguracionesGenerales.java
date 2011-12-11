package com.jswitch.base.modelo.entidades.defaultData;

import com.jswitch.base.modelo.entidades.auditoria.Auditable;
import com.jswitch.base.modelo.entidades.auditoria.AuditoriaBasica;
import com.jswitch.base.modelo.util.bean.BeanVO;
import com.jswitch.base.modelo.util.ehts.BusinessKey;
import com.jswitch.base.modelo.util.ehts.Method;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Personal
 */
@Entity
@Table(name = "CONF_ConfiguracionesGenerales")
public class ConfiguracionesGenerales extends BeanVO implements Serializable, Auditable {

    /**
     * Pk autogenerado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;
    /**
     * Porcentaje de iva actual
     */
    @Column
    private Double porcentajeIVA;
    /**
     * Valor de la Unidad Tributaria actual
     */
    @Column
    private Double valorUT;
    /**
     * Version de la clase
     */
    @Version
    @Column
    private Integer optLock;
    /**
     * Auditoria de la clase
     */
    @Embedded
    @BusinessKey
    private AuditoriaBasica auditoria;

    public ConfiguracionesGenerales() {
    }

    /**
     * Auditoria de la clase
     * @return the auditoria
     */
    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    /**
     * Pk autogenerado
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Version de la clase
     * @return the optLock
     */
    public Integer getOptLock() {
        return optLock;
    }

    /**
     * Porcentaje de iva actual
     * @return the porcentajeIVA
     */
    public Double getPorcentajeIVA() {
        return porcentajeIVA;
    }

    /**
     * Auditoria de la clase
     * @param auditoria the auditoria to set
     */
    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

    /**
     * Pk autogenerado
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Version de la clase
     * @param optLock the optLock to set
     */
    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    /**
     * Porcentaje de iva actual
     * @param porcentajeIVA the porcentajeIVA to set
     */
    public void setPorcentajeIVA(Double porcentajeIVA) {
        if (porcentajeIVA > 1) {
            this.porcentajeIVA = 1d;
        } else if (porcentajeIVA < 0) {
            this.porcentajeIVA = 0d;
        } else {
            this.porcentajeIVA = porcentajeIVA;
        }
    }

    /**
     * Valor de la Unidad Tributaria actual
     * @return the valorUT
     */
    public Double getValorUT() {
        return valorUT;
    }

    /**
     * Valor de la Unidad Tributaria actual
     * @param valorUT the valorUT to set
     */
    public void setValorUT(Double valorUT) {
        this.valorUT = valorUT;
    }
}

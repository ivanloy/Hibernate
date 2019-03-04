/*

 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name="Regalos"
)
public class Regalo implements Serializable {
    @Id 

    @Column(name="Id", nullable=false)	    
    private Integer id;
    
    @Column(name="Denominacion")
    private String denominacion;
    
    @Column(name="Ancho")
    private Integer ancho;
    
    @Column(name="Largo")
    private Integer largo;
    
    @Column(name="Alto")
    private Integer alto;
    
    @Column(name="Tipo")
    private Character tipo;
    
    @Column(name="EdadMinima")
    private Integer edadMinima;
    
    @Column(name="Precio")
    private BigDecimal precio;

    public Integer getGoesTo() {
        return goesTo;
    }

    public void setGoesTo(Integer goesTo) {
        this.goesTo = goesTo;
    }

    @Column(name="GoesTo")
    private Integer goesTo;

    public Regalo() {
    }

    public Regalo(String denominacion){
        this.denominacion = denominacion;
    }

    public int getId() {
        return id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }

    public int getAlto() {
        return alto;
    }

    public char getTipo() {
        return tipo;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
    
// Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Regalo{" +
                "id=" + id +
                ", denominacion='" + denominacion + '\'' +
                ", ancho=" + ancho +
                ", largo=" + largo +
                ", alto=" + alto +
                ", tipo=" + tipo +
                ", edadMinima=" + edadMinima +
                ", precio=" + precio +
                ", goesTo=" + goesTo +
                '}';
    }
}

package Modelo;

import Modelo.Consumidor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-10-04T18:47:42", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, Double> PrecioTotal;
    public static volatile SingularAttribute<Ventas, Double> precioProd;
    public static volatile SingularAttribute<Ventas, Double> descuento;
    public static volatile SingularAttribute<Ventas, Integer> id;
    public static volatile SingularAttribute<Ventas, Consumidor> consumidor;

}
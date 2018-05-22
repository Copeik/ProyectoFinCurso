package Entidades;

import Entidades.Almacenes;
import Entidades.Bienes;
import Entidades.Proveedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Entradas.class)
public class Entradas_ { 

    public static volatile SingularAttribute<Entradas, Integer> numEntrada;
    public static volatile SingularAttribute<Entradas, Date> fecha;
    public static volatile SingularAttribute<Entradas, Integer> total;
    public static volatile SingularAttribute<Entradas, Bienes> item;
    public static volatile SingularAttribute<Entradas, Almacenes> almacen;
    public static volatile SingularAttribute<Entradas, Proveedores> proveedor;
    public static volatile SingularAttribute<Entradas, Integer> numFactura;
    public static volatile SingularAttribute<Entradas, Integer> cantidad;

}
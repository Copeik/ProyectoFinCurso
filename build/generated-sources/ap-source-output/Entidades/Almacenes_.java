package Entidades;

import Entidades.Entradas;
import Entidades.Salidas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Almacenes.class)
public class Almacenes_ { 

    public static volatile ListAttribute<Almacenes, Entradas> entradasList;
    public static volatile ListAttribute<Almacenes, Salidas> salidasList;
    public static volatile SingularAttribute<Almacenes, String> ubicacion;
    public static volatile SingularAttribute<Almacenes, Integer> codAlmacen;
    public static volatile SingularAttribute<Almacenes, Integer> capacidad;

}
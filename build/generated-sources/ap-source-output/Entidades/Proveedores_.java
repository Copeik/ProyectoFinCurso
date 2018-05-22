package Entidades;

import Entidades.Bienes;
import Entidades.Entradas;
import Entidades.Ordenes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile ListAttribute<Proveedores, Entradas> entradasList;
    public static volatile SingularAttribute<Proveedores, Integer> nit;
    public static volatile ListAttribute<Proveedores, Bienes> bienesList;
    public static volatile ListAttribute<Proveedores, Ordenes> ordenesList;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> nombre;

}
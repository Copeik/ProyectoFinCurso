package Entidades;

import Entidades.Entradas;
import Entidades.Facturas;
import Entidades.Proveedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Bienes.class)
public class Bienes_ { 

    public static volatile ListAttribute<Bienes, Entradas> entradasList;
    public static volatile SingularAttribute<Bienes, String> caracter;
    public static volatile SingularAttribute<Bienes, Proveedores> proveedor;
    public static volatile SingularAttribute<Bienes, Integer> codItem;
    public static volatile SingularAttribute<Bienes, String> nombre;
    public static volatile ListAttribute<Bienes, Facturas> facturasList;
    public static volatile SingularAttribute<Bienes, Integer> valorUnitario;

}
package Entidades;

import Entidades.Bienes;
import Entidades.FacturasPK;
import Entidades.Solicitudes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-19T18:31:42")
@StaticMetamodel(Facturas.class)
public class Facturas_ { 

    public static volatile SingularAttribute<Facturas, FacturasPK> facturasPK;
    public static volatile SingularAttribute<Facturas, Bienes> bienes;
    public static volatile SingularAttribute<Facturas, Solicitudes> solicitudes;

}
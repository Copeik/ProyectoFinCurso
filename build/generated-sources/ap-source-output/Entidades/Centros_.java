package Entidades;

import Entidades.Directores;
import Entidades.Empleados;
import Entidades.JefesArea;
import Entidades.Salidas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Centros.class)
public class Centros_ { 

    public static volatile ListAttribute<Centros, JefesArea> jefesAreaList;
    public static volatile ListAttribute<Centros, Salidas> salidasList;
    public static volatile SingularAttribute<Centros, String> ubicacion;
    public static volatile ListAttribute<Centros, Directores> directoresList;
    public static volatile ListAttribute<Centros, Empleados> empleadosList;
    public static volatile SingularAttribute<Centros, Integer> codCentro;
    public static volatile SingularAttribute<Centros, String> nombre;

}
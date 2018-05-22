package Entidades;

import Entidades.Centros;
import Entidades.Directores;
import Entidades.Empleados;
import Entidades.Responsables;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(JefesArea.class)
public class JefesArea_ { 

    public static volatile SingularAttribute<JefesArea, String> area;
    public static volatile ListAttribute<JefesArea, Responsables> responsablesList;
    public static volatile ListAttribute<JefesArea, Empleados> empleadosList;
    public static volatile SingularAttribute<JefesArea, Integer> codJefe;
    public static volatile SingularAttribute<JefesArea, Directores> director;
    public static volatile SingularAttribute<JefesArea, Integer> salario;
    public static volatile SingularAttribute<JefesArea, Centros> centro;
    public static volatile SingularAttribute<JefesArea, String> nombre;

}
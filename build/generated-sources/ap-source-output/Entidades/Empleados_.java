package Entidades;

import Entidades.Centros;
import Entidades.JefesArea;
import Entidades.Responsables;
import Entidades.Salidas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile ListAttribute<Empleados, Salidas> salidasList;
    public static volatile SingularAttribute<Empleados, Responsables> responsable;
    public static volatile SingularAttribute<Empleados, Integer> salario;
    public static volatile SingularAttribute<Empleados, Centros> centro;
    public static volatile SingularAttribute<Empleados, JefesArea> jefeArea;
    public static volatile SingularAttribute<Empleados, String> nombre;
    public static volatile SingularAttribute<Empleados, Integer> codEmpleado;

}
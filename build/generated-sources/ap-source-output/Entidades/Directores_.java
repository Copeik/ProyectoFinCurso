package Entidades;

import Entidades.Centros;
import Entidades.JefesArea;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Directores.class)
public class Directores_ { 

    public static volatile ListAttribute<Directores, JefesArea> jefesAreaList;
    public static volatile SingularAttribute<Directores, Integer> salario;
    public static volatile SingularAttribute<Directores, Centros> centro;
    public static volatile SingularAttribute<Directores, Integer> codDirector;
    public static volatile SingularAttribute<Directores, String> nombre;

}
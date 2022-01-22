/* CLASE Y MÉTODO ABSTRACTOS  */
package poo_2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Poo_2 {

    public static void main(String[] args) {

        //ARRAY
        Persona[] lasPersonas = new Persona[5];

        //POSICIÓN DE LOS ARRAY
        lasPersonas[0] = new Empleado2("Luis", 5000, 2000, 01, 30);
        lasPersonas[1] = new Empleado2("Ana", 5000, 2000, 01, 30);
        lasPersonas[2] = new Alumno("Ana", "Ingenieria de sistemas.");
        lasPersonas[3] = new Jefatura("Hernando", "RRHH",3000, 2022, 02, 29);
        lasPersonas[4]= new Director("Liliana", "SIEDUCA");
//BUCLE FOR MEJORADO
        for (Persona p : lasPersonas) {
            System.out.println(p.dameNombre() + ", " + p.dameDescripcion());
        }
    }
}

//CLASE PERSONA
abstract class Persona {

    //CONSTRUCTOR
    public Persona(String nom) {
        nombre = nom;
    }

    //MÉTODO GETTER
    public String dameNombre() {
        return nombre;
    }

    //MÉTODO ABSTRACTO DE LA CLASE PERSONA
    public abstract String dameDescripcion();

    //VARIABLE
    private String nombre;
}

//CLASE EMPLEADO2
class Empleado2 extends Persona {

    //CREAR EL PRIMER MÉTODO CONSTRUCTOR QUE VA RECIBIR PARAMETROS o argumentos DE LA CLASE EMPLEADO
    public Empleado2(String nom, double sue, int agno, int mes, int dia) {

        super(nom);
        sueldo = sue;
        ++IdSiguiente;
        Id = IdSiguiente;

        //CONSTRUCTOR PARA CREAR LA FECHA
        GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);

        altaContrato = calendario.getTime();
    }

    //SOBREESCRIBIR EL MÉTODO DAMEDESCRIPCION
    public String dameDescripcion() {
        return "es un empleado que tiene N° Id " + Id + ", y un sueldo " + sueldo;
    }

    //MÉTODO GETTER PARA EL SUELDO
    public double dimeSueldo() {
        return sueldo;
    }

    //MÉTODO GETTER PARA FECHA DE INGRESO A LA EMPRESA
    public Date dameFechaContrato() {
        return altaContrato;
    }

    //MÉTODO SETTER PARA SUBIR EL SUELDO
    public void subeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    //MÉTODO GETTER PARA IDSIGUIENTE
    public static String dameIdSiguiente() {
        return "El IdSiguiente es: " + IdSiguiente;
    }

    //CREAR LAS VARIABLES AL FINAL DE LA CLASE
    private double sueldo;
    private Date altaContrato;//Variable que necesita importar paquete java.util 
    private int Id;//VARIABLE ID
    private static int IdSiguiente;//VARIABLE IDSIGUIENTE CON VALOR INICIAL 1

}

//CLASE ALUMNO
class Alumno extends Persona {

    //CONSTRUCTOR
    public Alumno(String nom, String car) {
        //INVOCAR EL CONSTRUCTOR
        super(nom);
        //VARIABLE CARRERA ALMACENA EL PARÁMETRO car
        carrera = car;
    }

    //SOBRESCRIBIR EL MÉTODO GETTER dameDescripción
    public String dameDescripcion() {
        return "es un alumno que estudia la carrera de " + carrera;
    }

    //VARIABLE
    private String carrera;
}

class Jefatura extends Persona {

    //CONSTRUCTOR
    public Jefatura(String nom, String sec, double sue, int agno, int mes, int dia) {
        super(nom);
        seccion = sec;
    }
    //SOBRESCRIBIR EL MÉTODO GETTER dameDescripción
    public String dameDescripcion() {
        return "es un jefe de la sección " + seccion;
    }

    //DECLARACIÓN DE MÉTODO SETTER
    public void estableceIncentivo(double b) {
        incentivo = b;
    }

    //MÉTODO GETTER QUE SUME EL SUELDO BASE + INCENTIVO= SUELDO JEFE
    public double nuevoSueldo() {//SE SOBREESCRIBE EL MÉTODO dimeSueldo por eso se observa un icono al lado izquierdo
        double sueldoJefe = nuevoSueldo();
        return sueldoJefe + incentivo;
    }

    //VARIABLES QUE SOLO PERTENCEN A LA CLASE JEFATURA
    private double incentivo;
    private String nombre;
    private String seccion;
}
class Director extends Persona {
    
    //CONSTRUCTOR
    public Director (String nom, String emp) {
        super (nom);//INVOCAMOS AL CONSTRUCTOR DE LA CLASE PADRE
        empresa=emp;
      }
    //SOBRESCRIBIR EL MÉTODO GETTER dameDescripción
    public String dameDescripcion() {
        return "es la directora de la empresa " + empresa;
    }
    
    //VARIABLE
    private String empresa;
}

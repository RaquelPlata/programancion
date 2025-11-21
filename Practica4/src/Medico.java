public class Medico {
    private String nombre;
    private Areas area;
    private String DNI;
    private int edad;
    private String sexo;
    private double salario_bruto;
    private int fecha_i;


    public Medico (String nombre, Areas area, String DNI , int edad , String sexo , double salario_bruto,int fecha_i){
        this.nombre=nombre;
        this.area=area;
        this.DNI=DNI;
        this.edad=edad;
        this.sexo=sexo;
        this.salario_bruto=salario_bruto;
        this.fecha_i=fecha_i;
    }
}

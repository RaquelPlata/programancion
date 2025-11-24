public class Medico {
    private String nombre;
    private Areas area;
    private String DNI;
    private int edad;
    private String sexo;
    private double salario_bruto;
    private int fecha_i;
    private  Areas nuevaArea;


    public Medico (String nombre, Areas area, String DNI , int edad , String sexo , double salario_bruto,int fecha_i){
        this.nombre=nombre;
        this.area=area;
        this.DNI=DNI;
        this.edad=edad;
        this.sexo=sexo;
        this.salario_bruto=salario_bruto;
        this.fecha_i=fecha_i;
        area.aumentarMedicos();
    }

    //GET

    public String getNombre() {
        return nombre;
    }

    public Areas getArea() {
        return area;
    }

    public String getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public double getSalario_bruto() {
        return salario_bruto;
    }

    public int getFecha_i() {
        return fecha_i;
    }

    public Areas getNuevaArea() {
        return nuevaArea;
    }
    //SET

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setSalario_bruto(double salario_bruto) {
        this.salario_bruto = salario_bruto;
    }

    public void setFecha_i(int fecha_i) {
        this.fecha_i = fecha_i;
    }

    public void setNuevaArea(Areas nuevaArea) {
        this.nuevaArea = nuevaArea;
    }
    //Calcular suwldo neto
    public double calcularSueldoNeto(double retencion) {
        return this.salario_bruto - (this.salario_bruto * retencion / 100);
    }

    //Calcular antiguedad
    public int getAniosAntiguedad(){
        return 2025-this.fecha_i;
    }

    //Calcular impuestos anuales
    public double calcularImpuestosAnuales(double tasaImpositiva) {
        return this.salario_bruto * (tasaImpositiva / 100);
    }
    //Comprobación de edad
    public boolean esMayorEdad(int MayoriaEdad){
        return this.edad >= MayoriaEdad;
    }
    //Calculo del aumento del sueldo
    public double proximoAumento(double porcentajeAumento, int aniosRequeridos){
        if (getAniosAntiguedad() >= aniosRequeridos) {
            return this.salario_bruto + (this.salario_bruto * porcentajeAumento / 100);
        }
        return this.salario_bruto;
    }
    //Cambiar areas
    public void cambiarArea(Areas nuevaArea) {
        if (this.area != null) {
            this.area.decrementarMedico();
        }
        nuevaArea.aumentarMedicos();
        this.area = nuevaArea;
    }

}

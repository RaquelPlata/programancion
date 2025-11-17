public class Usuario {
    // introducimos atributo y los declaramos con private
    private String nombre;
    private String apellido;
    private Integer codigoPostal;
    private String direccion;
    private String email;
    private String password;
    //Constructor
    public Usuario(String nombre, String apellido, int codigoPostal, String direccion, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
    }
// Metodo get


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getpassword() {
        return password;
    }


    //Metodo set

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setemail(String nuevoemail) {
        if (nuevoemail != null && nuevoemail.contains("@")) {
            this.email = nuevoemail;
        } else {

            System.out.println("Error: Email valido. No contiene @.");
        }
    }

    public void password(String password) {
        if (password != null && password.length() >= 6) {
            this.email = password;
        }else {

            System.out.println("Error: La contraseña debe tener como minimo 6 caracteres ");
        }
    }

    //Metodo de autenticación
      public boolean checkUsuario(String email, String password){

        return this.email.equals(email) && this.password.equals(password)? true:false;
      }

    public String toString() {
        return " -Usuario:"+nombre+" " +apellido+" -Email: " +email+ " -código Postal:" + codigoPostal;
    }

}


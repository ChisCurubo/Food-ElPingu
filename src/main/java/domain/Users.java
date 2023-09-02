package domain;

public class Users {
    private int ID;
    private String email;
    private String pwd;
    private int tipo;
    private String nombre;
    private String apellido;

    public Users(){
        //this is the empty constructor
    }
    public Users(int id){this.ID = id;}

    public Users (String emailEn, String pswd , int tipoEn , String nombreEn, String apellidoEn ){
        this.email = emailEn;
        this.pwd = pswd;
        this.tipo = tipoEn;
        this.nombre = nombreEn;
        this.apellido = apellidoEn;
    }
    public Users (int id,String emailEn, String pswd , int tipoEn , String nombreEn, String apellidoEn ){
        this.ID = id;
        this.email = emailEn;
        this.pwd = pswd;
        this.tipo = tipoEn;
        this.nombre = nombreEn;
        this.apellido = apellidoEn;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

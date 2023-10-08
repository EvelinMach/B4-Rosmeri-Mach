
package proyectofinal4tobloque;


public class usuario {
    String nombreUsuario, contraUsuario;
    public usuario(String nombreUsuario, String contraUsuario){
        this.nombreUsuario=nombreUsuario;
        this.contraUsuario=contraUsuario;
    }
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public String getContraUsuario(){
        return contraUsuario;
    }
}

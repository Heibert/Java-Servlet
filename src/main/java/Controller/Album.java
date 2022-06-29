package Controller;
import Model.AlbumDao;
import Model.AlbumVo;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Album extends HttpServlet {
    AlbumDao adao=new AlbumDao();
    AlbumVo avo=new AlbumVo();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Entro al doGet");
    String accion=req.getParameter("accion");
    System.out.println(accion);
        
    switch (accion) {
        case "abrirForm":
            abrirForm(req, resp);
            break;
        
        case "listar":
            listar(req,resp);
            break;
        
        case "AEstado":
            Aestado(req, resp);
            break;
            
        case "Aeliminar":
            Aeliminar(req,resp);
            break;
            
        case "editar":
            editar(req, resp);
            break;
            
        case "registrar":
            registrar(req, resp);
            break;
     
        case "index":
            index(req, resp);
            break;

        default:
            System.out.println("Hay error en el doGet");
            break;
        }
    }

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Entro al doPost");
    String accion=req.getParameter("accion");        
    System.out.println(accion);

    switch (accion) {
        
        case "listar":
            listar(req,resp);
            break;
            
        default:
            System.out.println("Hay error en el doPost");
            break;
        }
    }
    
private void editar(HttpServletRequest req, HttpServletResponse resp){
    String nombreA = req.getParameter("nombre");
    System.out.println(nombreA);
    Boolean Estado = Boolean.valueOf(req.getParameter("estado"));
    try {
        int idAlbum =(Integer.parseInt(req.getParameter("id")));
        System.out.println(idAlbum);
        System.out.println(Estado);
        adao.editar(nombreA,idAlbum,Estado); 
        resp.sendRedirect("album?accion=listar");
        System.out.println("Album editado");
    } catch (Exception e) {
        //TODO: handle exception
    }
}
        
private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
    try{
        req.getRequestDispatcher("views/addAlbum.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    }catch(Exception e){
        System.out.println("El formulario no ha sido abierto"+e.getMessage().toString());
    }
}
        
private void Aeliminar(HttpServletRequest req, HttpServletResponse resp) {
    AlbumDao adao=new AlbumDao();
    AlbumVo avo=new AlbumVo();
    System.out.println(req.getParameter("id"));
    if(req.getParameter("id")!=null) {
        avo.setIdAlbum(Integer.parseInt(req.getParameter("id")));
    }
    else{
        System.out.println("No fue posible hallar el id");
    }
    try{
    adao.Aeliminar(avo.getIdAlbum());
    resp.sendRedirect("album?accion=listar");
    System.out.println("Album eliminado");
            
    }catch(Exception e){
    req.setAttribute("msje", "No fue posible eliminar" + e.getMessage());
    System.out.println("Error al eliminar" + e.getMessage());
    }
}

private void registrar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("nombreAlbum")!=null){
        System.out.println(req.getParameter("estado"));
        Boolean Estado = Boolean.valueOf(req.getParameter("estado"));
        System.out.println(Estado);
        avo.setNombreAlbum(req.getParameter("nombreAlbum"));
        avo.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));
        avo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        avo.setEstadoAlbum(Estado);
    }
    try {
        adao.registrar(avo);
        resp.sendRedirect("album?accion=listar");
        System.out.println("Registro exitoso");
    } catch (Exception e) {
        req.setAttribute("msje","no se pudo registrar el album"+e.getMessage());
        System.out.println("Error en la inserción del registro "+e.getMessage().toString());
    }
}

private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List <AlbumVo>album=adao.listar();
        req.setAttribute("albums", album);
        req.getRequestDispatcher("views/album.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}
        
private void Aestado(HttpServletRequest req, HttpServletResponse resp){
    Boolean estado1 = Boolean.valueOf(req.getParameter("Estado"));
    System.out.println("Se cambiara de "+estado1);
    avo.setIdAlbum(Integer.parseInt(req.getParameter("id")));
            
    if(estado1 == false){
        avo.setEstadoAlbum(true);
        System.out.println("Se cambio a verdader");
    }
            
    else{
        avo.setEstadoAlbum(false);
        System.out.println("Se cambio a falso");
    }
    
    try{
        adao.Aestado(avo);
        resp.sendRedirect("album?accion=listar");
        System.out.println("Cambios registrados");
            
    }catch (Exception e) {
        req.setAttribute("msje", "No se pudo cambiar el estado "+e.getMessage());
        System.out.println("Error en el cambio de estado "+e.getMessage().toString());
    }
}
        
private void index(HttpServletRequest req, HttpServletResponse resp){
            
    try {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
            
    }catch (Exception e) {
        req.setAttribute("msje", "Hay error en el Index "+e.getMessage());
        System.out.println("Hay error en el Index "+e.getMessage().toString());
    }
}
}
package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Modelo
import Model.GeneroDao;
import Model.GeneroVo;

public class Genero extends HttpServlet{
    GeneroDao gDao= new GeneroDao();
    GeneroVo gVo = new GeneroVo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doGet");
        String accion=req.getParameter("accion");
        System.out.println(accion);
        switch (accion) {
            case "abrirFormulario":
                abrirFormularioRegistro(req, resp);
                break;
            case "listar":
                listar(req,resp);
                break;
            case "cEstado":
                cEstado(req, resp);
                break;
            case "eliminar":
                eliminar(req, resp);
                break;
            case "editar":
                editar(req, resp);
                break;
            case "registrar":
                addGenero(req, resp);
                break;
            case "index":
                index(req, resp);
                break;
            default:
            System.out.println("Problema en el switch doGet");
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
                listar(req, resp);
                break;
            default:
            System.out.println("Problema en el switch doPost");
                break;
        }
        }
        private void editar(HttpServletRequest req, HttpServletResponse resp){
            int id = (Integer.parseInt(req.getParameter("id")));
            System.out.println(req.getParameter("estado"));
            Boolean estadoA = Boolean.valueOf(req.getParameter("estado"));
            String nombreA = req.getParameter("nombre");
            System.out.println(nombreA);
            try {
                gVo.setNombreGenero(nombreA);
                gVo.setEstadoGenero(estadoA);
                gDao.editar(id, nombreA, estadoA);
                resp.sendRedirect("genero?accion=listar");
                System.out.println("Genero editado");
            } catch (Exception e) {
                req.setAttribute("msje", "No se pudo editar" + e.getMessage());
                System.out.println("No se pudo editar" + e.getMessage());
            }
        }
        private void abrirFormularioRegistro(HttpServletRequest req, HttpServletResponse resp){
            try {
                req.getRequestDispatcher("views/addGenero.jsp").forward(req, resp);
                System.out.println("El formulario ha sido abierto");
            } catch (Exception e) {
                System.out.println("El formulario no se abrio debido a: "+e.getMessage().toString());
            }
        }
        private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
            if(req.getParameter("id")!=null) {
                gVo.setIdGenero(Integer.parseInt(req.getParameter("id")));
            }
            else{
                System.out.println("Error al conseguir la id");
            }
            try{
                gDao.eliminar(gVo.getIdGenero());
                resp.sendRedirect("genero?accion=listar");
                System.out.println("Genero eliminado");
            }catch(Exception e){
                req.setAttribute("msje", "No se pudo eliminar" + e.getMessage());
                System.out.println("No se pudo eliminar" + e.getMessage());
            }
        }

        private void addGenero (HttpServletRequest req, HttpServletResponse resp){
            if(req.getParameter("nombre")!=null){
                gVo.setNombreGenero(req.getParameter("nombre"));
                gVo.setEstadoGenero(true);
            }
            try {
                gDao.registrar(gVo);
                resp.sendRedirect("genero?accion=listar");
                System.out.println("Registro creado correctamente");
            } catch (Exception e) {
                req.setAttribute("msje", "No se pudo registrar el genero "+e.getMessage());
                System.out.println("Error en el registro "+e.getMessage().toString());
            }
        }

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
            try {
                List<GeneroVo> genero=gDao.listar();
                req.setAttribute("generos", genero);
                req.getRequestDispatcher("views/generos.jsp").forward(req, resp);
                System.out.println("Datos listados correctamente");
            } catch (Exception e) {
                System.out.println("Hubo un problema al listar "+e.getMessage().toString());
            }
        }
        private void cEstado(HttpServletRequest req, HttpServletResponse resp){
            Boolean Estado = Boolean.valueOf(req.getParameter("Estado"));
            System.out.println("Se cambiara de "+Estado);
            gVo.setIdGenero(Integer.parseInt(req.getParameter("id")));
            if(Estado == true){
                gVo.setEstadoGenero(false);
                System.out.println("Se cambio a falso");
            }
            else{
                gVo.setEstadoGenero(true);
                System.out.println("Se cambio a verdadero");
            }
            try {
                gDao.cEstado(gVo);
                resp.sendRedirect("genero?accion=listar");
                System.out.println("Cambios registrados");
            } catch (Exception e) {
                req.setAttribute("msje", "No se pudo cambiar el estado "+e.getMessage());
                System.out.println("Error en el cambio de estado "+e.getMessage().toString());
            }
        }
        private void index(HttpServletRequest req, HttpServletResponse resp){
            try {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } catch (Exception e) {
                req.setAttribute("msje", "Error "+e.getMessage());
                System.out.println("Error "+e.getMessage().toString());
            }
        }
}
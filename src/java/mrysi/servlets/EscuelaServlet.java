import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mrysi.beans.Escuela;

@WebServlet(name = "EscuelaServlet", urlPatterns = {"/EscuelaServlet"})
public class EscuelaServlet extends HttpServlet {

    private Connection connect;
    private Statement statement;
    private ResultSet resultSet;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EscuelaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EscuelaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public List<Escuela> getListaEscuelas() throws SQLException {
        String query = "SELECT * from Datos";
        resultSet = statement.executeQuery(query);
        
        List<Escuela> escuelas = new ArrayList<>();
        while (resultSet.next()) {
            Escuela escuela = new Escuela();
            escuela.setClaveEscuela(resultSet.getString(1));
            escuela.setNombreEscuela(resultSet.getString(2));
            escuela.setDomicilio(resultSet.getString(3));
            escuela.setTurno(resultSet.getString(4));
            escuelas.add(escuela);
        }
        return escuelas;
    }    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String URL = "jdbc:mysql://localhost/mrysiEscuelas?user=root&password=Cristian201101.";
            connect = DriverManager.getConnection(URL);
            statement = connect.createStatement();
                    
            request.setAttribute("ListaEscuelas", getListaEscuelas());
            
            connect.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }


}

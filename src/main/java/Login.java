

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Login", urlPatterns = "/Login")

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    DirContext connection;

    public static boolean ldap(String nombre, String pass)
	{
		try {
			Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
			env.put(Context.SECURITY_PRINCIPAL, "cn="+nombre+",ou=users,o=producto");
			env.put(Context.SECURITY_CREDENTIALS, pass);
			DirContext con = new InitialDirContext(env);
			con.close();
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		
		if(ldap(nombre, pass) == true) {
			response.sendRedirect("/maven-webapp/correct.jsp");
		}
		else {
			response.sendRedirect("/maven-webapp/error.jsp");
		}
	}

}

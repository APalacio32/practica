package com.practica.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.practica.dao.ClienteDAO;
import com.practica.model.Cliente;


@WebServlet("/AdminClient")
public class AdminCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ClienteDAO clienteDAO;

	public AdminCliente() {
		super();
	}

	// Inicializador Servlet
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			clienteDAO = new ClienteDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "add":
			addClient(request, response);
			break;
		case "list":
			listClients(request,response);
			break;
		case "eliminar":
			eliminarClientes(request,response);
			break;
		/*
		 * case "register": System.out.println("entro"); registrar(request,
		 * response); break; case "mostrar": mostrar(request, response); break;
		 * case "showedit": showEditar(request, response); break; case "editar":
		 * editar(request, response); break; case "eliminar": eliminar(request,
		 * response); break;
		 */
		default:
			break;
		}

		/*
		 * //Codigo para agregar un cliente Cliente cliente = new
		 * Cliente(0,"Prudencio",
		 * "Velasco Palacios","pvelasco@gmail.com","686 1223 1241"); try {
		 * clienteDAO.addClient(cliente); } catch(SQLException e) {
		 * e.printStackTrace(); }
		 */

		// Codigo para mostrar un informacion de un cliente por ID
		/*
		 * try { Cliente cliente = clienteDAO.infoClientById(2);
		 * System.out.println(cliente.getNombre()); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */

		// Codigo para actualizar la informacion de un cliente por ID
		/*
		 * Cliente cliente = new
		 * Cliente(1,"Jose","Yesca Ortiz","jayo@gmail.com","686 172 7311"); try
		 * { clienteDAO.updateClient(cliente); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */

		// Codigo para eliminar cliente por ID
		/*
		 * try { Cliente cliente = clienteDAO.infoClientById(1);
		 * clienteDAO.deleteClient(cliente);
		 * 
		 * }catch(SQLException e){ e.printStackTrace(); }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void addClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		
		Cliente cliente = new Cliente(0, nombre, apellidos, correo, telefono);
		try {
			boolean state = clienteDAO.addClient(cliente);
			//response.getWriter().print(state);
			PrintWriter out;
			out = response.getWriter();
			out.print(state);
			System.out.println(state);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void listClients(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		
		JSONObject myObject = new JSONObject();
		
		List<Cliente> lista;
		try {
			lista = clienteDAO.getListClients();
			myObject.put("result", lista);
			PrintWriter out;
			out = response.getWriter();
			out.print(myObject);
			System.out.println(myObject);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*try {
			JSONObject json = new JSONObject();
		    JSONArray  resultado = new JSONArray();
		    JSONObject dato;
			List<Cliente> lista = clienteDAO.getListClients();
	
			for (Cliente cliente: lista) {
				dato = new JSONObject();
				
				dato.put("id", cliente.getId());
	            dato.put("nombre", cliente.getNombre());
	            dato.put("apellidos",cliente.getApellidos());
	            dato.put("correo", cliente.getCorreo());
	            dato.put("telefono", cliente.getTelefono());
	            
			}
			resultado.put(dato);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	
	private void eliminarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

		boolean result;
		try {
			Cliente cliente = clienteDAO.infoClientById(Integer.parseInt(request.getParameter("id")));
			result = clienteDAO.deleteClient(cliente);

			PrintWriter out;
			out = response.getWriter();
			out.print(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

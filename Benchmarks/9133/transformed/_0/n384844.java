class n384844 {
	public void elimina(Cliente uQMjkXqz) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int U6TPu0YR = uQMjkXqz.getId();
		String Owu54XHr;
		Statement E3rNSxOW = null;
		try {
			gd.begin();
			Owu54XHr = "DELETE FROM cliente WHERE cod_cliente = '" + U6TPu0YR + "'";
			System.out.println("Ejecutando: " + Owu54XHr);
			E3rNSxOW = gd.getConexion().createStatement();
			E3rNSxOW.executeUpdate(Owu54XHr);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			E3rNSxOW.close();
		} catch (SQLException uGJSIcFJ) {
			gd.rollback();
			throw new errorSQL(uGJSIcFJ.toString());
		} catch (errorConexionBD Z6zSoJxx) {
			System.err.println("Error en GestorCliente.elimina(): " + Z6zSoJxx);
		} catch (errorSQL UQTI9GvY) {
			System.err.println("Error en GestorCliente.elimina(): " + UQTI9GvY);
		}
	}

}
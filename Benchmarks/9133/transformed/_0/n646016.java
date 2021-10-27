class n646016 {
	public void elimina(Cliente DrMv8TPn) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int R8cCXMAX = DrMv8TPn.getId();
		String OoyYFYZo;
		Statement ikYzKQSa = null;
		try {
			gd.begin();
			OoyYFYZo = "DELETE FROM cliente WHERE cod_cliente =" + R8cCXMAX;
			System.out.println("Ejecutando: " + OoyYFYZo);
			ikYzKQSa = gd.getConexion().createStatement();
			ikYzKQSa.executeUpdate(OoyYFYZo);
			System.out.println("executeUpdate");
			OoyYFYZo = "DELETE FROM persona WHERE id =" + R8cCXMAX;
			System.out.println("Ejecutando: " + OoyYFYZo);
			ikYzKQSa.executeUpdate(OoyYFYZo);
			gd.commit();
			System.out.println("commit");
			ikYzKQSa.close();
		} catch (SQLException y9QJ6IzY) {
			gd.rollback();
			throw new errorSQL(y9QJ6IzY.toString());
		} catch (errorConexionBD rjsfwMF2) {
			System.err.println("Error en GestorCliente.elimina(): " + rjsfwMF2);
		} catch (errorSQL LTRGO1rw) {
			System.err.println("Error en GestorCliente.elimina(): " + LTRGO1rw);
		}
	}

}
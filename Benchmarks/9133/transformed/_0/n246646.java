class n246646 {
	public void elimina(Cliente BYVibdN8) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int NvjZzZRn = BYVibdN8.getId();
		String bWQcIzKh;
		Statement ZRIFbKlB = null;
		try {
			gd.begin();
			bWQcIzKh = "DELETE FROM cliente WHERE cod_cliente =" + NvjZzZRn;
			System.out.println("Ejecutando: " + bWQcIzKh);
			ZRIFbKlB = gd.getConexion().createStatement();
			ZRIFbKlB.executeUpdate(bWQcIzKh);
			bWQcIzKh = "DELETE FROM usuario WHERE cod_usuario =" + NvjZzZRn;
			System.out.println("Ejecutando: " + bWQcIzKh);
			ZRIFbKlB = gd.getConexion().createStatement();
			ZRIFbKlB.executeUpdate(bWQcIzKh);
			System.out.println("executeUpdate");
			bWQcIzKh = "DELETE FROM persona WHERE id =" + NvjZzZRn;
			System.out.println("Ejecutando: " + bWQcIzKh);
			ZRIFbKlB = gd.getConexion().createStatement();
			ZRIFbKlB.executeUpdate(bWQcIzKh);
			gd.commit();
			System.out.println("commit");
			ZRIFbKlB.close();
		} catch (SQLException XHcTo99t) {
			gd.rollback();
			throw new errorSQL(XHcTo99t.toString());
		} catch (errorConexionBD EHwjG01s) {
			System.err.println("Error en GestorCliente.elimina(): " + EHwjG01s);
		} catch (errorSQL AqwxI9E6) {
			System.err.println("Error en GestorCliente.elimina(): " + AqwxI9E6);
		}
	}

}
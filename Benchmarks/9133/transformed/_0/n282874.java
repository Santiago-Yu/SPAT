class n282874 {
	public void elimina(Cliente YJQyFqG6) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int mhcWKW1x = YJQyFqG6.getId();
		String rrOnidXm;
		Statement YCr71u9B = null;
		try {
			gd.begin();
			rrOnidXm = "DELETE FROM cliente WHERE cod_cliente =" + mhcWKW1x;
			System.out.println("Ejecutando: " + rrOnidXm);
			YCr71u9B = gd.getConexion().createStatement();
			YCr71u9B.executeUpdate(rrOnidXm);
			System.out.println("executeUpdate");
			rrOnidXm = "DELETE FROM persona WHERE id =" + mhcWKW1x;
			System.out.println("Ejecutando: " + rrOnidXm);
			YCr71u9B.executeUpdate(rrOnidXm);
			gd.commit();
			System.out.println("commit");
			YCr71u9B.close();
		} catch (SQLException OymXUXqQ) {
			gd.rollback();
			throw new errorSQL(OymXUXqQ.toString());
		} catch (errorConexionBD KOFjWiBK) {
			System.err.println("Error en GestorCliente.elimina(): " + KOFjWiBK);
		} catch (errorSQL vz0WCCOQ) {
			System.err.println("Error en GestorCliente.elimina(): " + vz0WCCOQ);
		}
	}

}
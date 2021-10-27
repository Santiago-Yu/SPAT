class n144769 {
	public void elimina(Cliente PniMPzcJ) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int Wv8bPtKs = PniMPzcJ.getId();
		String ipztx70m;
		Statement QFXJjlLQ = null;
		try {
			gd.begin();
			ipztx70m = "DELETE FROM cliente WHERE cod_cliente =" + Wv8bPtKs;
			System.out.println("Ejecutando: " + ipztx70m);
			QFXJjlLQ = gd.getConexion().createStatement();
			QFXJjlLQ.executeUpdate(ipztx70m);
			System.out.println("executeUpdate");
			ipztx70m = "DELETE FROM persona WHERE id =" + Wv8bPtKs;
			System.out.println("Ejecutando: " + ipztx70m);
			QFXJjlLQ.executeUpdate(ipztx70m);
			gd.commit();
			System.out.println("commit");
			QFXJjlLQ.close();
		} catch (SQLException Exn3rLUH) {
			gd.rollback();
			throw new errorSQL(Exn3rLUH.toString());
		} catch (errorConexionBD kwf8SE19) {
			System.err.println("Error en GestorCliente.elimina(): " + kwf8SE19);
		} catch (errorSQL yq6R6lmr) {
			System.err.println("Error en GestorCliente.elimina(): " + yq6R6lmr);
		}
	}

}
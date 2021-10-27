class n73110 {
	public void elimina(Cliente iaZ2As0Z) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int dvRCeFgu = iaZ2As0Z.getId();
		String jsVTXZra;
		Statement XwAp0P7r = null;
		try {
			gd.begin();
			jsVTXZra = "DELETE FROM cliente WHERE cod_cliente =" + dvRCeFgu;
			System.out.println("Ejecutando: " + jsVTXZra);
			XwAp0P7r = gd.getConexion().createStatement();
			XwAp0P7r.executeUpdate(jsVTXZra);
			System.out.println("executeUpdate");
			jsVTXZra = "DELETE FROM persona WHERE id =" + dvRCeFgu;
			System.out.println("Ejecutando: " + jsVTXZra);
			XwAp0P7r.executeUpdate(jsVTXZra);
			gd.commit();
			System.out.println("commit");
			XwAp0P7r.close();
		} catch (SQLException KoWHGswJ) {
			gd.rollback();
			throw new errorSQL(KoWHGswJ.toString());
		} catch (errorConexionBD eYKMDWSW) {
			System.err.println("Error en GestorCliente.elimina(): " + eYKMDWSW);
		} catch (errorSQL tidInoZk) {
			System.err.println("Error en GestorCliente.elimina(): " + tidInoZk);
		}
	}

}
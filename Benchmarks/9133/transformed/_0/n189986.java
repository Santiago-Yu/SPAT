class n189986 {
	public void elimina(Cliente vHr9vPJe) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int gBQrfoHD = vHr9vPJe.getId();
		String akzPSHh3;
		Statement saBIgoWz = null;
		try {
			gd.begin();
			akzPSHh3 = "DELETE FROM cliente WHERE cod_cliente =" + gBQrfoHD;
			System.out.println("Ejecutando: " + akzPSHh3);
			saBIgoWz = gd.getConexion().createStatement();
			saBIgoWz.executeUpdate(akzPSHh3);
			System.out.println("executeUpdate");
			akzPSHh3 = "DELETE FROM persona WHERE id =" + gBQrfoHD;
			System.out.println("Ejecutando: " + akzPSHh3);
			saBIgoWz.executeUpdate(akzPSHh3);
			gd.commit();
			System.out.println("commit");
			saBIgoWz.close();
		} catch (SQLException MXLoq0f8) {
			gd.rollback();
			throw new errorSQL(MXLoq0f8.toString());
		} catch (errorConexionBD BQNVuwzg) {
			System.err.println("Error en GestorCliente.elimina(): " + BQNVuwzg);
		} catch (errorSQL qlFBlJTe) {
			System.err.println("Error en GestorCliente.elimina(): " + qlFBlJTe);
		}
	}

}
class n265214 {
	public void elimina(Cliente wWpe59GX) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int XEBPhpgj = wWpe59GX.getId();
		String dNEhMq6x;
		Statement WNhY7suJ = null;
		try {
			gd.begin();
			dNEhMq6x = "DELETE FROM cliente WHERE cod_cliente =" + XEBPhpgj;
			System.out.println("Ejecutando: " + dNEhMq6x);
			WNhY7suJ = gd.getConexion().createStatement();
			WNhY7suJ.executeUpdate(dNEhMq6x);
			System.out.println("executeUpdate");
			dNEhMq6x = "DELETE FROM persona WHERE id =" + XEBPhpgj;
			System.out.println("Ejecutando: " + dNEhMq6x);
			WNhY7suJ.executeUpdate(dNEhMq6x);
			gd.commit();
			System.out.println("commit");
			WNhY7suJ.close();
		} catch (SQLException OwZhs0j3) {
			gd.rollback();
			throw new errorSQL(OwZhs0j3.toString());
		} catch (errorConexionBD KsnHE8N7) {
			System.err.println("Error en GestorCliente.elimina(): " + KsnHE8N7);
		} catch (errorSQL iNMp5ZQb) {
			System.err.println("Error en GestorCliente.elimina(): " + iNMp5ZQb);
		}
	}

}
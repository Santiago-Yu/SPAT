class n742572 {
	public void elimina(Cliente tBhBQfIb) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int RVpofxpb = tBhBQfIb.getId();
		String auCtAECz;
		Statement llhLBRNi = null;
		try {
			gd.begin();
			auCtAECz = "DELETE FROM cliente WHERE cod_cliente =" + RVpofxpb;
			System.out.println("Ejecutando: " + auCtAECz);
			llhLBRNi = gd.getConexion().createStatement();
			llhLBRNi.executeUpdate(auCtAECz);
			auCtAECz = "DELETE FROM usuario WHERE cod_usuario =" + RVpofxpb;
			System.out.println("Ejecutando: " + auCtAECz);
			llhLBRNi = gd.getConexion().createStatement();
			llhLBRNi.executeUpdate(auCtAECz);
			System.out.println("executeUpdate");
			auCtAECz = "DELETE FROM persona WHERE id =" + RVpofxpb;
			System.out.println("Ejecutando: " + auCtAECz);
			llhLBRNi = gd.getConexion().createStatement();
			llhLBRNi.executeUpdate(auCtAECz);
			gd.commit();
			System.out.println("commit");
			llhLBRNi.close();
		} catch (SQLException wVI716Ku) {
			gd.rollback();
			throw new errorSQL(wVI716Ku.toString());
		} catch (errorConexionBD PLqLx14g) {
			System.err.println("Error en GestorCliente.elimina(): " + PLqLx14g);
		} catch (errorSQL l1NyjSyi) {
			System.err.println("Error en GestorCliente.elimina(): " + l1NyjSyi);
		}
	}

}
class n543575 {
	public void elimina(Cliente lUZd32Qf) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int dALT3nMe = lUZd32Qf.getId();
		String qneuQj7x;
		Statement sMBds84J = null;
		try {
			gd.begin();
			qneuQj7x = "DELETE FROM cliente WHERE cod_cliente =" + dALT3nMe;
			System.out.println("Ejecutando: " + qneuQj7x);
			sMBds84J = gd.getConexion().createStatement();
			sMBds84J.executeUpdate(qneuQj7x);
			qneuQj7x = "DELETE FROM usuario WHERE cod_usuario =" + dALT3nMe;
			System.out.println("Ejecutando: " + qneuQj7x);
			sMBds84J = gd.getConexion().createStatement();
			sMBds84J.executeUpdate(qneuQj7x);
			System.out.println("executeUpdate");
			qneuQj7x = "DELETE FROM persona WHERE id =" + dALT3nMe;
			System.out.println("Ejecutando: " + qneuQj7x);
			sMBds84J = gd.getConexion().createStatement();
			sMBds84J.executeUpdate(qneuQj7x);
			gd.commit();
			System.out.println("commit");
			sMBds84J.close();
		} catch (SQLException GeZBnaON) {
			gd.rollback();
			throw new errorSQL(GeZBnaON.toString());
		} catch (errorConexionBD ytGM5loT) {
			System.err.println("Error en GestorCliente.elimina(): " + ytGM5loT);
		} catch (errorSQL z8bKOmv6) {
			System.err.println("Error en GestorCliente.elimina(): " + z8bKOmv6);
		}
	}

}
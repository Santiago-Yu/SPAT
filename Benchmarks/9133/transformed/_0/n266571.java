class n266571 {
	public void elimina(Cliente RMcD1sis) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int rweLstTn = RMcD1sis.getId();
		String jqPJvlBL;
		Statement YXtvRKfM = null;
		try {
			gd.begin();
			jqPJvlBL = "DELETE FROM cliente WHERE cod_cliente =" + rweLstTn;
			System.out.println("Ejecutando: " + jqPJvlBL);
			YXtvRKfM = gd.getConexion().createStatement();
			YXtvRKfM.executeUpdate(jqPJvlBL);
			System.out.println("executeUpdate");
			jqPJvlBL = "DELETE FROM persona WHERE id =" + rweLstTn;
			System.out.println("Ejecutando: " + jqPJvlBL);
			YXtvRKfM.executeUpdate(jqPJvlBL);
			gd.commit();
			System.out.println("commit");
			YXtvRKfM.close();
		} catch (SQLException QHnhjM5b) {
			gd.rollback();
			throw new errorSQL(QHnhjM5b.toString());
		} catch (errorConexionBD g5k1j3DJ) {
			System.err.println("Error en GestorCliente.elimina(): " + g5k1j3DJ);
		} catch (errorSQL CBZ1WErX) {
			System.err.println("Error en GestorCliente.elimina(): " + CBZ1WErX);
		}
	}

}
class n827646 {
	public void elimina(Cliente nvsVDVxe) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int UeGPgiWr = nvsVDVxe.getId();
		String l7yucxhY;
		Statement FVRpMXQR = null;
		try {
			gd.begin();
			l7yucxhY = "DELETE FROM cliente WHERE cod_cliente =" + UeGPgiWr;
			System.out.println("Ejecutando: " + l7yucxhY);
			FVRpMXQR = gd.getConexion().createStatement();
			FVRpMXQR.executeUpdate(l7yucxhY);
			System.out.println("executeUpdate");
			l7yucxhY = "DELETE FROM persona WHERE id =" + UeGPgiWr;
			System.out.println("Ejecutando: " + l7yucxhY);
			FVRpMXQR.executeUpdate(l7yucxhY);
			gd.commit();
			System.out.println("commit");
			FVRpMXQR.close();
		} catch (SQLException CTEcqQwE) {
			gd.rollback();
			throw new errorSQL(CTEcqQwE.toString());
		} catch (errorConexionBD qLgONjfQ) {
			System.err.println("Error en GestorCliente.elimina(): " + qLgONjfQ);
		} catch (errorSQL p8bNn8If) {
			System.err.println("Error en GestorCliente.elimina(): " + p8bNn8If);
		}
	}

}
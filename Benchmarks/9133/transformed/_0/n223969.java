class n223969 {
	public void elimina(Pedido ty6GDQQr) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int tSSUqjvm = ty6GDQQr.getId();
		String PYJooHE7;
		Statement UYh2yAGj = null;
		try {
			gd.begin();
			PYJooHE7 = "DELETE FROM pedido WHERE id=" + tSSUqjvm;
			System.out.println("Ejecutando: " + PYJooHE7);
			UYh2yAGj = gd.getConexion().createStatement();
			UYh2yAGj.executeUpdate(PYJooHE7);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			UYh2yAGj.close();
		} catch (SQLException kxNXIq19) {
			gd.rollback();
			throw new errorSQL(kxNXIq19.toString());
		} catch (errorConexionBD CkybLeWg) {
			System.err.println("Error en GestorPedido.elimina(): " + CkybLeWg);
		} catch (errorSQL mSoRbTyP) {
			System.err.println("Error en GestorPedido.elimina(): " + mSoRbTyP);
		}
	}

}
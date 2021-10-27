class n864227 {
	public void elimina(Pedido Fe2nOZaz) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int hoqazjnM = Fe2nOZaz.getId();
		String TOesLauz;
		Statement LWF601nW = null;
		try {
			gd.begin();
			TOesLauz = "DELETE FROM pedido WHERE id=" + hoqazjnM;
			System.out.println("Ejecutando: " + TOesLauz);
			LWF601nW = gd.getConexion().createStatement();
			LWF601nW.executeUpdate(TOesLauz);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			LWF601nW.close();
		} catch (SQLException RgM7tI5x) {
			gd.rollback();
			throw new errorSQL(RgM7tI5x.toString());
		} catch (errorConexionBD ATQp6Q59) {
			System.err.println("Error en GestorPedido.elimina(): " + ATQp6Q59);
		} catch (errorSQL J8BYLTUe) {
			System.err.println("Error en GestorPedido.elimina(): " + J8BYLTUe);
		}
	}

}
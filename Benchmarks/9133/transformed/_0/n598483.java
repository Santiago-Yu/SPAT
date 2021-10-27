class n598483 {
	public void elimina(Pedido tddL7Zc0) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int JpIaZ82d = tddL7Zc0.getId();
		String isUxY3Eh;
		Statement IT6ju06r = null;
		try {
			gd.begin();
			isUxY3Eh = "DELETE FROM pedido WHERE id=" + JpIaZ82d;
			System.out.println("Ejecutando: " + isUxY3Eh);
			IT6ju06r = gd.getConexion().createStatement();
			IT6ju06r.executeUpdate(isUxY3Eh);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			IT6ju06r.close();
		} catch (SQLException dwB1SiHI) {
			gd.rollback();
			throw new errorSQL(dwB1SiHI.toString());
		} catch (errorConexionBD AqKqdCjo) {
			System.err.println("Error en GestorPedido.elimina(): " + AqKqdCjo);
		} catch (errorSQL zN0aqnuM) {
			System.err.println("Error en GestorPedido.elimina(): " + zN0aqnuM);
		}
	}

}
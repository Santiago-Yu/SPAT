class n727437 {
	public void elimina(Pedido fTtuVlON) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int wLWsLCoC = fTtuVlON.getId();
		String B8Kildu5;
		Statement jpbxompe = null;
		try {
			gd.begin();
			B8Kildu5 = "DELETE FROM pedido WHERE id=" + wLWsLCoC;
			System.out.println("Ejecutando: " + B8Kildu5);
			jpbxompe = gd.getConexion().createStatement();
			jpbxompe.executeUpdate(B8Kildu5);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			jpbxompe.close();
		} catch (SQLException BR2PJme5) {
			gd.rollback();
			throw new errorSQL(BR2PJme5.toString());
		} catch (errorConexionBD NagmaHyj) {
			System.err.println("Error en GestorPedido.elimina(): " + NagmaHyj);
		} catch (errorSQL xO7DeaBD) {
			System.err.println("Error en GestorPedido.elimina(): " + xO7DeaBD);
		}
	}

}
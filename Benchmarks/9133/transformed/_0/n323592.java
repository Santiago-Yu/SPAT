class n323592 {
	public void elimina(Pedido lM711Rie) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int Vw5Wk0pg = lM711Rie.getId();
		String BaDKo97l;
		Statement xAR4tW58 = null;
		try {
			gd.begin();
			BaDKo97l = "DELETE FROM pedido WHERE id=" + Vw5Wk0pg;
			System.out.println("Ejecutando: " + BaDKo97l);
			xAR4tW58 = gd.getConexion().createStatement();
			xAR4tW58.executeUpdate(BaDKo97l);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			xAR4tW58.close();
		} catch (SQLException Ilm95yXh) {
			gd.rollback();
			throw new errorSQL(Ilm95yXh.toString());
		} catch (errorConexionBD hcm6xQqH) {
			System.err.println("Error en GestorPedido.elimina(): " + hcm6xQqH);
		} catch (errorSQL kL8NAN1j) {
			System.err.println("Error en GestorPedido.elimina(): " + kL8NAN1j);
		}
	}

}
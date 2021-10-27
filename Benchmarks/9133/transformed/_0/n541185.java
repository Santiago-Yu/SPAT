class n541185 {
	public void elimina(Pedido HdvwSI26) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int uXL6nJjw = HdvwSI26.getId();
		String CgsiiiLv;
		Statement VqAlryUB = null;
		try {
			gd.begin();
			CgsiiiLv = "DELETE FROM pedido WHERE id=" + uXL6nJjw;
			System.out.println("Ejecutando: " + CgsiiiLv);
			VqAlryUB = gd.getConexion().createStatement();
			VqAlryUB.executeUpdate(CgsiiiLv);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			VqAlryUB.close();
		} catch (SQLException WhYD65Kg) {
			gd.rollback();
			throw new errorSQL(WhYD65Kg.toString());
		} catch (errorConexionBD NC1duGsr) {
			System.err.println("Error en GestorPedido.elimina(): " + NC1duGsr);
		} catch (errorSQL zWxH1UYx) {
			System.err.println("Error en GestorPedido.elimina(): " + zWxH1UYx);
		}
	}

}
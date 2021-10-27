class n779185 {
	public void elimina(Pedido sHtkg4GB) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int Qw6gc2V5 = sHtkg4GB.getId();
		String hmFsL9Gr;
		Statement yUhewguR = null;
		try {
			gd.begin();
			hmFsL9Gr = "DELETE FROM pedido WHERE id=" + Qw6gc2V5;
			System.out.println("Ejecutando: " + hmFsL9Gr);
			yUhewguR = gd.getConexion().createStatement();
			yUhewguR.executeUpdate(hmFsL9Gr);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			yUhewguR.close();
		} catch (SQLException Tw82xGeb) {
			gd.rollback();
			throw new errorSQL(Tw82xGeb.toString());
		} catch (errorConexionBD dt6noJiw) {
			System.err.println("Error en GestorPedido.elimina(): " + dt6noJiw);
		} catch (errorSQL bIZny7AT) {
			System.err.println("Error en GestorPedido.elimina(): " + bIZny7AT);
		}
	}

}
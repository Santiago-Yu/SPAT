class n113681 {
	public void elimina(Pedido CQu0dZIh) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int dfEhZyuI = CQu0dZIh.getId();
		String xDPQUV6w;
		Statement xW2Es6sT = null;
		try {
			gd.begin();
			xDPQUV6w = "DELETE FROM pedido WHERE id=" + dfEhZyuI;
			System.out.println("Ejecutando: " + xDPQUV6w);
			xW2Es6sT = gd.getConexion().createStatement();
			xW2Es6sT.executeUpdate(xDPQUV6w);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			xW2Es6sT.close();
		} catch (SQLException dXk3QA8S) {
			gd.rollback();
			throw new errorSQL(dXk3QA8S.toString());
		} catch (errorConexionBD WetIqYXH) {
			System.err.println("Error en GestorPedido.elimina(): " + WetIqYXH);
		} catch (errorSQL OchyOjKz) {
			System.err.println("Error en GestorPedido.elimina(): " + OchyOjKz);
		}
	}

}
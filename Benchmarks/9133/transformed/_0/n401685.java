class n401685 {
	public void elimina(Pedido vsQ1Art3) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int CP4DyIoC = vsQ1Art3.getId();
		String qa5y0X7r;
		Statement wbKV9EcP = null;
		try {
			gd.begin();
			qa5y0X7r = "DELETE FROM pedido WHERE id=" + CP4DyIoC;
			System.out.println("Ejecutando: " + qa5y0X7r);
			wbKV9EcP = gd.getConexion().createStatement();
			wbKV9EcP.executeUpdate(qa5y0X7r);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			wbKV9EcP.close();
		} catch (SQLException is5xM7MU) {
			gd.rollback();
			throw new errorSQL(is5xM7MU.toString());
		} catch (errorConexionBD AYA4dSn2) {
			System.err.println("Error en GestorPedido.elimina(): " + AYA4dSn2);
		} catch (errorSQL snks7L5P) {
			System.err.println("Error en GestorPedido.elimina(): " + snks7L5P);
		}
	}

}
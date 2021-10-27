class n789472 {
	public void elimina(Pedido iknHFTz3) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int NQTqn7xm = iknHFTz3.getId();
		String GvWVnbQQ;
		Statement lfHAa93q = null;
		try {
			gd.begin();
			GvWVnbQQ = "DELETE FROM pedido WHERE id=" + NQTqn7xm;
			System.out.println("Ejecutando: " + GvWVnbQQ);
			lfHAa93q = gd.getConexion().createStatement();
			lfHAa93q.executeUpdate(GvWVnbQQ);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			lfHAa93q.close();
		} catch (SQLException hM89dAed) {
			gd.rollback();
			throw new errorSQL(hM89dAed.toString());
		} catch (errorConexionBD InMYTBMf) {
			System.err.println("Error en GestorPedido.elimina(): " + InMYTBMf);
		} catch (errorSQL GxlxBbw5) {
			System.err.println("Error en GestorPedido.elimina(): " + GxlxBbw5);
		}
	}

}
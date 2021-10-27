class n580527 {
	public void elimina(Pedido ZKNZE9tD) throws errorSQL, errorConexionBD {
		System.out.println("GestorPedido.elimina()");
		int cs0rRCNj = ZKNZE9tD.getId();
		String u8PwiSMt;
		Statement MeNCAjtZ = null;
		try {
			gd.begin();
			u8PwiSMt = "DELETE FROM pedido WHERE id=" + cs0rRCNj;
			System.out.println("Ejecutando: " + u8PwiSMt);
			MeNCAjtZ = gd.getConexion().createStatement();
			MeNCAjtZ.executeUpdate(u8PwiSMt);
			System.out.println("executeUpdate");
			gd.commit();
			System.out.println("commit");
			MeNCAjtZ.close();
		} catch (SQLException Yv0bRKGT) {
			gd.rollback();
			throw new errorSQL(Yv0bRKGT.toString());
		} catch (errorConexionBD rgJvqQ89) {
			System.err.println("Error en GestorPedido.elimina(): " + rgJvqQ89);
		} catch (errorSQL Zyq1qC2A) {
			System.err.println("Error en GestorPedido.elimina(): " + Zyq1qC2A);
		}
	}

}
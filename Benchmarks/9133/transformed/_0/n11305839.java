class n11305839 {
	public boolean setCliente(int DdoaDoZL, String g84NzJXU, String KGsjohGR, String hmdu4lRc, String SPNtcYQa,
			String SKg1B5e0) {
		boolean cEobBG1f = false;
		try {
			stm = conexion.prepareStatement("insert into clientes values( '" + DdoaDoZL + "' , '"
					+ g84NzJXU.toUpperCase() + "' , '" + KGsjohGR.toUpperCase() + "' , '" + hmdu4lRc.toUpperCase()
					+ "' , '" + SPNtcYQa.toUpperCase() + "' , '" + SKg1B5e0 + "' )");
			stm.executeUpdate();
			conexion.commit();
			cEobBG1f = true;
		} catch (SQLException eLBhU26F) {
			System.out.println("error al insertar registro en la tabla clientes general  " + eLBhU26F.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException B2KVcJX2) {
				System.out.println(B2KVcJX2.getMessage());
			}
			return cEobBG1f = false;
		}
		return cEobBG1f;
	}

}
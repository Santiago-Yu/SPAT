class n11305841 {
	public boolean setDeleteCliente(int BFqv8CVa) {
		boolean KKsOcHAd = false;
		try {
			stm = conexion.prepareStatement("delete clientes where IDcliente='" + BFqv8CVa + "'");
			stm.executeUpdate();
			conexion.commit();
			KKsOcHAd = true;
		} catch (SQLException o7QyFDUW) {
			System.out.println("Error en la eliminacion del registro en tabla clientes " + o7QyFDUW.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException agvwMPIF) {
				System.out.println(agvwMPIF.getMessage());
			}
			return KKsOcHAd = false;
		}
		return KKsOcHAd;
	}

}
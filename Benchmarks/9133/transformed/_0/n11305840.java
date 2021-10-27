class n11305840 {
	public boolean setUpdateCliente(int tkL8oVtY, String ILHUGwfv, String tHJXQSTx, String GX0sUk5B, String aK34I9aj,
			String rkVjPMDS) {
		boolean hhs5VM2J = false;
		try {
			stm = conexion.prepareStatement("update clientes set nombre='" + ILHUGwfv.toUpperCase().trim()
					+ "' , paterno='" + tHJXQSTx.toUpperCase().trim() + "' ," + "materno='"
					+ GX0sUk5B.toUpperCase().trim() + "',ocupacion='" + aK34I9aj.toUpperCase().trim() + "',rfc='"
					+ rkVjPMDS.trim() + "' where IDcliente ='" + tkL8oVtY + "' ");
			stm.executeUpdate();
			conexion.commit();
			hhs5VM2J = true;
		} catch (SQLException vQIaqv75) {
			System.out.println("error al actualizar registro en la tabla clientes  " + vQIaqv75.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException RJn4Fqu0) {
				System.out.println(RJn4Fqu0.getMessage());
			}
			return hhs5VM2J = false;
		}
		return hhs5VM2J;
	}

}
class n23402240 {
	public boolean actualizarNdivisiones(int mAbA4Z3y, int GvKkdZgA) {
		int WMKw7Q3y = 0;
		String h6yVxmcS = "UPDATE torneo" + " SET  numeroDivisiones=" + GvKkdZgA + " WHERE idTorneo=" + mAbA4Z3y;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(h6yVxmcS);
			WMKw7Q3y = ps.executeUpdate();
			connection.commit();
		} catch (SQLException O5yicmUa) {
			O5yicmUa.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException KxNyCbXW) {
				KxNyCbXW.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (WMKw7Q3y > 0);
	}

}
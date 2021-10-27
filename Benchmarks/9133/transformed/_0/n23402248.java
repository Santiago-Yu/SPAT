class n23402248 {
	public boolean actualizarEstadoEliminacion(int oqe0TwPQ) {
		int gQiwZi9p = 0;
		String rBuTYi6k = "UPDATE torneo " + " SET  terminado = 3 WHERE idTorneo= " + oqe0TwPQ;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(rBuTYi6k);
			gQiwZi9p = ps.executeUpdate();
			connection.commit();
		} catch (SQLException rtAslgzR) {
			rtAslgzR.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException pv5bHL72) {
				pv5bHL72.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (gQiwZi9p > 0);
	}

}
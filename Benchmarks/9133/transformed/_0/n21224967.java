class n21224967 {
	public boolean crear() {
		int bmiwZxUb = 0;
		String ycqOqAAk = "insert into jugador"
				+ "(apellidoPaterno, apellidoMaterno, nombres, fechaNacimiento, pais, rating, sexo)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(ycqOqAAk);
			populatePreparedStatement(elJugador);
			bmiwZxUb = ps.executeUpdate();
			connection.commit();
		} catch (SQLException dhp4daIt) {
			dhp4daIt.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException xs6oi8Vn) {
				xs6oi8Vn.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (bmiwZxUb > 0);
	}

}
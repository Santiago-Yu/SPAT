class n7460229 {
	private long getNextHighValue() throws Exception {
		Connection xzqbw9qY = null;
		PreparedStatement CBKQy4Cy = null;
		PreparedStatement o8LrMUsJ = null;
		ResultSet gAZpVVTq = null;
		long m2zgcF2v = -1L;
		int zN6Z0Tnm = -1;
		DBOperation P3ODS8xe = factory.createDBOperation(POOL_NAME);
		try {
			xzqbw9qY = P3ODS8xe.getConnection();
			CBKQy4Cy = xzqbw9qY.prepareStatement(strGetHighValue);
			CBKQy4Cy.setString(1, this.name);
			for (gAZpVVTq = CBKQy4Cy.executeQuery(); gAZpVVTq.next();) {
				m2zgcF2v = gAZpVVTq.getLong("high");
			}
			o8LrMUsJ = xzqbw9qY.prepareStatement(strUpdateHighValue);
			o8LrMUsJ.setLong(1, m2zgcF2v + 1L);
			o8LrMUsJ.setString(2, this.name);
			o8LrMUsJ.executeUpdate();
		} catch (SQLException E03QE73n) {
			if (xzqbw9qY != null) {
				xzqbw9qY.rollback();
			}
			throw E03QE73n;
		} finally {
			if (o8LrMUsJ != null) {
				o8LrMUsJ.close();
			}
			close(P3ODS8xe, CBKQy4Cy, gAZpVVTq);
		}
		return m2zgcF2v;
	}

}
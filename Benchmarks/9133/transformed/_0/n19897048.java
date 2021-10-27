class n19897048 {
	public void insertRight(final String iX4a2gnK) throws IOException {
		try {
			Connection R8HjmXSE = null;
			boolean gdo6NPo7 = false;
			try {
				R8HjmXSE = pool.getConnection();
				gdo6NPo7 = R8HjmXSE.getAutoCommit();
				R8HjmXSE.setAutoCommit(true);
				final PreparedStatement rE0dtNcH = R8HjmXSE.prepareStatement("insert into rights (name) values (?)");
				rE0dtNcH.setString(1, iX4a2gnK);
				rE0dtNcH.executeUpdate();
			} catch (Throwable Ju7Dopj1) {
				if (R8HjmXSE != null)
					R8HjmXSE.rollback();
				throw new SQLException(Ju7Dopj1.toString());
			} finally {
				if (R8HjmXSE != null) {
					R8HjmXSE.setAutoCommit(gdo6NPo7);
					R8HjmXSE.close();
				}
			}
		} catch (final SQLException gTAtMhFb) {
			log.log(Level.SEVERE, gTAtMhFb.toString(), gTAtMhFb);
			throw new IOException(gTAtMhFb.toString());
		}
	}

}
class n21224683 {
	public void delete(String JZnjZzHK) throws FidoDatabaseException {
		try {
			Connection rKwtt8MK = null;
			Statement keg15LXb = null;
			try {
				rKwtt8MK = fido.util.FidoDataSource.getConnection();
				rKwtt8MK.setAutoCommit(false);
				keg15LXb = rKwtt8MK.createStatement();
				keg15LXb.executeUpdate("delete from Principals where PrincipalId = '" + JZnjZzHK + "'");
				keg15LXb.executeUpdate("delete from Roles where PrincipalId = '" + JZnjZzHK + "'");
				rKwtt8MK.commit();
			} catch (SQLException FYfBmEMX) {
				if (rKwtt8MK != null)
					rKwtt8MK.rollback();
				throw FYfBmEMX;
			} finally {
				if (keg15LXb != null)
					keg15LXb.close();
				if (rKwtt8MK != null)
					rKwtt8MK.close();
			}
		} catch (SQLException NB6wPa7Y) {
			throw new FidoDatabaseException(NB6wPa7Y);
		}
	}

}
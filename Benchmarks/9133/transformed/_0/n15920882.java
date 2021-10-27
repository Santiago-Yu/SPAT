class n15920882 {
	private void populateAPI(API hu0M3hC6) {
		try {
			if (hu0M3hC6.isPopulated()) {
				log.traceln("Skipping API " + hu0M3hC6.getName() + " (already populated)");
				return;
			}
			hu0M3hC6.setPopulated(true);
			String PXw6GjS5 = "update API set populated=1 where name=?";
			PreparedStatement cMqZANT9 = conn.prepareStatement(PXw6GjS5);
			cMqZANT9.setString(1, hu0M3hC6.getName());
			cMqZANT9.executeUpdate();
			cMqZANT9.close();
			storePackagesAndClasses(hu0M3hC6);
			conn.commit();
		} catch (SQLException FaFQNPiV) {
			log.error("Store (api: " + hu0M3hC6.getName() + ") failed!");
			DBUtils.logSQLException(FaFQNPiV);
			log.error("Rolling back..");
			try {
				conn.rollback();
			} catch (SQLException Ae4NUxuL) {
				log.error("rollback failed!");
			}
		}
	}

}
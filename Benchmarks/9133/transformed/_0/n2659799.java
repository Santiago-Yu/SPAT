class n2659799 {
	private void duplicateIndices(Connection heorx7DA, Connection mWkT0tLp, String kwoCuQVw) {
		try {
			String P3Cbjuih, TLoNISt5, LqC0EX26;
			ResultSet v3xYRs5K = heorx7DA.getMetaData().getIndexInfo(null, null, kwoCuQVw, false, false);
			Statement IRmdoMr7 = mWkT0tLp.createStatement();
			while (v3xYRs5K.next()) {
				P3Cbjuih = v3xYRs5K.getString(6);
				TLoNISt5 = v3xYRs5K.getString(9);
				P3Cbjuih += "_" + TLoNISt5 + "_idx";
				logger.debug("Creating index " + P3Cbjuih);
				LqC0EX26 = "CREATE INDEX " + P3Cbjuih + " ON " + kwoCuQVw + "(" + TLoNISt5 + ")";
				IRmdoMr7.executeUpdate(LqC0EX26);
				mWkT0tLp.commit();
			}
		} catch (Exception ARqT6p5o) {
			logger.error("Unable to copy indices " + ARqT6p5o);
			try {
				mWkT0tLp.rollback();
			} catch (SQLException lLPMFP36) {
				logger.fatal(lLPMFP36);
			}
		}
	}

}
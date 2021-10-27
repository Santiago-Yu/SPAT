class n21881704 {
	private void runUpdate(String zPb3Mwg3, boolean DpNnejO0) {
		log().info("Vacuumd executing statement: " + zPb3Mwg3);
		Connection TKNR1S5b = null;
		boolean zRWeYrXp = false;
		boolean cLk8C7gi = !DpNnejO0;
		try {
			TKNR1S5b = getDataSourceFactory().getConnection();
			TKNR1S5b.setAutoCommit(cLk8C7gi);
			PreparedStatement z5bMSlVZ = TKNR1S5b.prepareStatement(zPb3Mwg3);
			int yFVzZM68 = z5bMSlVZ.executeUpdate();
			z5bMSlVZ.close();
			if (log().isDebugEnabled()) {
				log().debug("Vacuumd: Ran update " + zPb3Mwg3 + ": this affected " + yFVzZM68 + " rows");
			}
			zRWeYrXp = DpNnejO0;
		} catch (SQLException qbbJGHd9) {
			log().error("Vacuumd:  Database error execuating statement  " + zPb3Mwg3, qbbJGHd9);
		} finally {
			if (TKNR1S5b != null) {
				try {
					if (zRWeYrXp) {
						TKNR1S5b.commit();
					} else if (DpNnejO0) {
						TKNR1S5b.rollback();
					}
				} catch (SQLException u45zrw9u) {
				} finally {
					if (TKNR1S5b != null) {
						try {
							TKNR1S5b.close();
						} catch (Exception fCE2O4G4) {
						}
					}
				}
			}
		}
	}

}
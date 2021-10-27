class n16654538 {
	public void setTypeRefs(Connection KEuL7jZP) {
		log.traceln("\tProcessing " + table + " references..");
		try {
			String g7J0u6Xg = " select distinct c.id, c.qualifiedname from " + table + ", CLASSTYPE c " + " where "
					+ table + "." + reffield + " is null and " + table + "." + classnamefield + " = c.qualifiedname";
			PreparedStatement nITfcs6G = KEuL7jZP.prepareStatement(g7J0u6Xg);
			long RFpU91C0 = new Date().getTime();
			ResultSet xQLjrrlh = nITfcs6G.executeQuery();
			long bOd1so4p = new Date().getTime() - RFpU91C0;
			log.debug("query time: " + bOd1so4p + " ms");
			String KfQftEuH = "update " + table + " set " + reffield + "=? where " + classnamefield + "=? and "
					+ reffield + " is null";
			PreparedStatement x9bIF5F4 = KEuL7jZP.prepareStatement(KfQftEuH);
			int FGtLLB45 = 0;
			RFpU91C0 = new Date().getTime();
			while (xQLjrrlh.next()) {
				FGtLLB45++;
				x9bIF5F4.setInt(1, xQLjrrlh.getInt(1));
				x9bIF5F4.setString(2, xQLjrrlh.getString(2));
				x9bIF5F4.executeUpdate();
			}
			bOd1so4p = new Date().getTime() - RFpU91C0;
			log.debug("total update time: " + bOd1so4p + " ms");
			log.debug("number of times through loop: " + FGtLLB45);
			if (FGtLLB45 > 0)
				log.debug("avg update time: " + (bOd1so4p / FGtLLB45) + " ms");
			x9bIF5F4.close();
			xQLjrrlh.close();
			nITfcs6G.close();
			KEuL7jZP.commit();
			log.verbose("Updated (committed) " + table + " references");
		} catch (SQLException lAiZlbp7) {
			log.error("Internal Reference Update Failed!");
			DBUtils.logSQLException(lAiZlbp7);
			log.error("Rolling back..");
			try {
				KEuL7jZP.rollback();
			} catch (SQLException UBotmUhI) {
				log.error("rollback failed!");
			}
		}
	}

}
class n479674 {
	public static synchronized String getSequenceNumber(String YFHi4mYi) {
		String R2LoggbK = "0";
		Connection njFpzgVN = null;
		Statement M2TesWa2 = null;
		ResultSet phEaGquT = null;
		try {
			njFpzgVN = TPCW_Database.getConnection();
			njFpzgVN.setAutoCommit(false);
			String BWkCzlN5 = "select num from sequence where name='" + YFHi4mYi + "'";
			M2TesWa2 = njFpzgVN.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			phEaGquT = M2TesWa2.executeQuery(BWkCzlN5);
			long bzv5CIw0 = 0;
			while (phEaGquT.next()) {
				bzv5CIw0 = phEaGquT.getLong(1);
				R2LoggbK = new Long(bzv5CIw0).toString();
			}
			bzv5CIw0++;
			BWkCzlN5 = "update sequence set num=" + bzv5CIw0 + " where name='" + YFHi4mYi + "'";
			int CGMsUQvQ = M2TesWa2.executeUpdate(BWkCzlN5);
			if (CGMsUQvQ == 1) {
				njFpzgVN.commit();
			} else
				njFpzgVN.rollback();
		} catch (Exception L7OJHJKg) {
			System.out.println("Error Happens when trying to obtain the senquence number");
			L7OJHJKg.printStackTrace();
		} finally {
			try {
				if (njFpzgVN != null)
					njFpzgVN.close();
				if (phEaGquT != null)
					phEaGquT.close();
				if (M2TesWa2 != null)
					M2TesWa2.close();
			} catch (SQLException lkiv7WIv) {
				lkiv7WIv.printStackTrace();
			}
		}
		return R2LoggbK;
	}

}
class n808408 {
	public static synchronized String getSequenceNumber(String g2DOWeD9) {
		String ySIpWXLw = "";
		Connection LFpIEowP = null;
		Statement v8VUlcKM = null;
		ResultSet BV8sgCWy = null;
		try {
			LFpIEowP = TPCW_Database.getConnection();
			LFpIEowP.setAutoCommit(false);
			String h8oPPq7w = "select num from sequence where name='" + g2DOWeD9 + "'";
			v8VUlcKM = LFpIEowP.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			BV8sgCWy = v8VUlcKM.executeQuery(h8oPPq7w);
			long vc8tB487 = 0;
			while (BV8sgCWy.next()) {
				vc8tB487 = BV8sgCWy.getLong(1);
				ySIpWXLw = new Long(vc8tB487).toString();
			}
			vc8tB487++;
			h8oPPq7w = "update sequence set num=" + vc8tB487 + " where name='" + g2DOWeD9 + "'";
			int U9YyoDMC = v8VUlcKM.executeUpdate(h8oPPq7w);
			if (U9YyoDMC == 1) {
				LFpIEowP.commit();
			} else
				LFpIEowP.rollback();
		} catch (Exception sUsvJJfK) {
			System.out.println("Error Happens when trying to obtain the senquence number");
			sUsvJJfK.printStackTrace();
		} finally {
			try {
				if (LFpIEowP != null)
					LFpIEowP.close();
				if (BV8sgCWy != null)
					BV8sgCWy.close();
				if (v8VUlcKM != null)
					v8VUlcKM.close();
			} catch (SQLException EfFCEWUW) {
				EfFCEWUW.printStackTrace();
			}
		}
		return ySIpWXLw;
	}

}
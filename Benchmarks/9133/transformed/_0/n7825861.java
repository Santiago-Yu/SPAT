class n7825861 {
	@Override
	public void run() {
		while (true) {
			StringBuilder OMvfBd0H = new StringBuilder(128);
			OMvfBd0H.append("insert into DOMAIN (                         ").append(LS);
			OMvfBd0H.append("    DOMAIN_ID, TOP_DOMAIN_ID, DOMAIN_HREF,   ").append(LS);
			OMvfBd0H.append("    DOMAIN_RANK, DOMAIN_TYPE, DOMAIN_STATUS, ").append(LS);
			OMvfBd0H.append("    DOMAIN_ICO_CREATED, DOMAIN_CDATE         ").append(LS);
			OMvfBd0H.append(") values (                   ").append(LS);
			OMvfBd0H.append("    null ,null, ?,").append(LS);
			OMvfBd0H.append("    1, 2, 1,                 ").append(LS);
			OMvfBd0H.append("    0, now()                 ").append(LS);
			OMvfBd0H.append(")                            ").append(LS);
			String uWBl7VJ1 = OMvfBd0H.toString();
			boolean PLabyq0O = false;
			int bhzrQ42W = 0;
			Connection VFtsc3u7 = null;
			PreparedStatement aoXY2Xe6 = null;
			ResultSet ancEozt5 = null;
			try {
				VFtsc3u7 = ConnHelper.getConnection();
				VFtsc3u7.setAutoCommit(PLabyq0O);
				aoXY2Xe6 = VFtsc3u7.prepareStatement(uWBl7VJ1);
				for (bhzrQ42W = 0; bhzrQ42W < 10; bhzrQ42W++) {
					String LiPkw88G = "" + ((int) (Math.random() * 100000000)) % 100;
					aoXY2Xe6.setString(1, LiPkw88G);
					aoXY2Xe6.executeUpdate();
				}
				if (!PLabyq0O)
					VFtsc3u7.commit();
				ancEozt5 = aoXY2Xe6.executeQuery("select max(DOMAIN_ID) from DOMAIN");
				if (ancEozt5.next()) {
					String zZXBYFy7 = System.currentTimeMillis() + " " + ancEozt5.getLong(1);
				}
			} catch (Exception uE2fRMSO) {
				try {
					if (!PLabyq0O)
						VFtsc3u7.rollback();
				} catch (SQLException caI2tRvj) {
					caI2tRvj.printStackTrace(System.out);
				}
				String qu2dWxan = System.currentTimeMillis() + " " + Thread.currentThread().getName() + " - " + bhzrQ42W
						+ " " + uE2fRMSO.getMessage() + LS;
				FileIO.writeToFile("D:/DEAD_LOCK.txt", qu2dWxan, true, "GBK");
			} finally {
				ConnHelper.close(VFtsc3u7, aoXY2Xe6, ancEozt5);
			}
		}
	}

}
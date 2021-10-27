class n18506484 {
	private int addPollToDB(DataSource PXrnZFlh) {
		int g0ZNNYWX = -2;
		Connection JyMI9m37 = null;
		try {
			JyMI9m37 = PXrnZFlh.getConnection();
			JyMI9m37.setAutoCommit(false);
			String M0Y9x9vo = "insert into polls" + " values( ?, ?, ?, ?)";
			PreparedStatement pzp6kMdx = JyMI9m37.prepareStatement(M0Y9x9vo);
			pzp6kMdx.setString(1, selectedCourse.getAdmin());
			pzp6kMdx.setString(2, selectedCourse.getCourseId());
			pzp6kMdx.setString(3, getTitle());
			pzp6kMdx.setInt(4, 0);
			pzp6kMdx.executeUpdate();
			String i43Q3siZ = "select max(pollid) from polls";
			pzp6kMdx = JyMI9m37.prepareStatement(i43Q3siZ);
			ResultSet SbK3rquk = pzp6kMdx.executeQuery();
			g0ZNNYWX = -2;
			while (SbK3rquk.next()) {
				g0ZNNYWX = SbK3rquk.getInt(1);
			}
			if (g0ZNNYWX == -2) {
				this.sqlError = true;
				throw new Exception();
			}
			String[] yMEaXTyw = getAllOptions();
			for (int VP22CqXo = 0; VP22CqXo < 4; VP22CqXo++) {
				String aOOweCJo = "insert into polloptions values ( ?, ?, ? )";
				pzp6kMdx = JyMI9m37.prepareStatement(aOOweCJo);
				pzp6kMdx.setString(1, yMEaXTyw[VP22CqXo]);
				pzp6kMdx.setInt(2, 0);
				pzp6kMdx.setInt(3, g0ZNNYWX);
				pzp6kMdx.executeUpdate();
			}
			pzp6kMdx.close();
			JyMI9m37.commit();
		} catch (Exception RIbZ0pz5) {
			sqlError = true;
			RIbZ0pz5.printStackTrace();
			if (JyMI9m37 != null)
				try {
					JyMI9m37.rollback();
				} catch (Exception YZSVtysq) {
				}
			try {
				throw RIbZ0pz5;
			} catch (Exception J0ivAx4p) {
				J0ivAx4p.printStackTrace();
			}
		} finally {
			if (JyMI9m37 != null)
				try {
					JyMI9m37.close();
				} catch (Exception fCgYUYDJ) {
				}
		}
		return g0ZNNYWX;
	}

}
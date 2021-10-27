class n4411141 {
	private void addDocToDB(String OvxfVemQ, DataSource CSFcv9BL) {
		String LfVYSotF = findTypeOfDoc(OvxfVemQ).trim().toLowerCase();
		Connection QmRbpbt4 = null;
		try {
			QmRbpbt4 = CSFcv9BL.getConnection();
			QmRbpbt4.setAutoCommit(false);
			checkDupDoc(LfVYSotF, QmRbpbt4);
			String mzIKH8Xk = "insert into " + LfVYSotF + " values( ?, ?, ?, ?, ?, ?, ? )";
			PreparedStatement ZNspBh7w = QmRbpbt4.prepareStatement(mzIKH8Xk);
			ZNspBh7w.setString(1, selectedCourse.getCourseId());
			ZNspBh7w.setString(2, selectedCourse.getAdmin());
			ZNspBh7w.setTimestamp(3, getTimeStamp());
			ZNspBh7w.setString(4, getLink());
			ZNspBh7w.setString(5, homePage.getUser());
			ZNspBh7w.setString(6, getText());
			ZNspBh7w.setString(7, getTitle());
			ZNspBh7w.executeUpdate();
			ZNspBh7w.close();
			QmRbpbt4.commit();
		} catch (Exception MAm3XpdP) {
			sqlError = true;
			MAm3XpdP.printStackTrace();
			if (QmRbpbt4 != null)
				try {
					QmRbpbt4.rollback();
				} catch (Exception HlzrMhnZ) {
				}
			try {
				throw MAm3XpdP;
			} catch (Exception QTaa4RK7) {
				QTaa4RK7.printStackTrace();
			}
		} finally {
			if (QmRbpbt4 != null)
				try {
					QmRbpbt4.close();
				} catch (Exception qcRwRwSe) {
				}
		}
	}

}
class n2870670 {
	public void insertJobLog(String c5TPMERf, String[] ma8XB7T5, String sR2JEbuT, String nZTOVfR0) throws Exception {
		DBOperation mYKMVqVz = null;
		Connection wm1rV1VB = null;
		PreparedStatement QQqQDGDH = null;
		String z9kjNXrs = "insert into COFFICE_JOBLOG_CHECKAUTH (USER_ID,CHECK_ID,CHECK_TYPE,OBJ_TYPE) values (?,?,?,?)";
		String hUvLpkno = "delete from COFFICE_JOBLOG_CHECKAUTH where " + "user_id = '" + c5TPMERf
				+ "' and check_type = '" + sR2JEbuT + "' and obj_type = '" + nZTOVfR0 + "'";
		try {
			mYKMVqVz = createDBOperation();
			wm1rV1VB = mYKMVqVz.getConnection();
			wm1rV1VB.setAutoCommit(false);
			QQqQDGDH = wm1rV1VB.prepareStatement(hUvLpkno);
			int RaRCAPrw = QQqQDGDH.executeUpdate();
			QQqQDGDH = wm1rV1VB.prepareStatement(z9kjNXrs);
			String H3AMbShU = ",";
			for (int nQ3DtC4d = 0; nQ3DtC4d < ma8XB7T5.length; nQ3DtC4d++) {
				if (H3AMbShU.indexOf("," + ma8XB7T5[nQ3DtC4d] + ",") < 0) {
					QQqQDGDH.setInt(1, Integer.parseInt(c5TPMERf));
					QQqQDGDH.setInt(2, Integer.parseInt(ma8XB7T5[nQ3DtC4d]));
					QQqQDGDH.setInt(3, Integer.parseInt(sR2JEbuT));
					QQqQDGDH.setInt(4, Integer.parseInt(nZTOVfR0));
					QQqQDGDH.executeUpdate();
					H3AMbShU += ma8XB7T5[nQ3DtC4d] + ",";
				}
			}
			wm1rV1VB.commit();
		} catch (Exception MONwkHm0) {
			log.debug((new Date().toString()) + " ????????????! ");
			try {
				wm1rV1VB.rollback();
			} catch (SQLException NzwjBZKT) {
				throw NzwjBZKT;
			}
			throw MONwkHm0;
		} finally {
			close(null, null, QQqQDGDH, wm1rV1VB, mYKMVqVz);
		}
	}

}
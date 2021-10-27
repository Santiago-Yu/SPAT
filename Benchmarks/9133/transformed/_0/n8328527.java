class n8328527 {
	public void insertJobLog(String NX6aB29L, String[] k0Y0e5Ej, String kTWczv4B, String KD5SCbgD) throws Exception {
		DBOperation EjuLpzFs = null;
		Connection WuQdQ1hL = null;
		PreparedStatement ukpElEb2 = null;
		String gg5OidS6 = "insert into COFFICE_JOBLOG_CHECKAUTH (USER_ID,CHECK_ID,CHECK_TYPE,OBJ_TYPE) values (?,?,?,?)";
		String EBBmF34t = "delete from COFFICE_JOBLOG_CHECKAUTH where " + "user_id = '" + NX6aB29L
				+ "' and check_type = '" + kTWczv4B + "' and obj_type = '" + KD5SCbgD + "'";
		try {
			EjuLpzFs = createDBOperation();
			WuQdQ1hL = EjuLpzFs.getConnection();
			WuQdQ1hL.setAutoCommit(false);
			ukpElEb2 = WuQdQ1hL.prepareStatement(EBBmF34t);
			int jJK4Al6P = ukpElEb2.executeUpdate();
			String sDasEBd9 = ",";
			ukpElEb2 = WuQdQ1hL.prepareStatement(gg5OidS6);
			for (int zGP3DKMi = 0; zGP3DKMi < k0Y0e5Ej.length; zGP3DKMi++) {
				if (sDasEBd9.indexOf("," + k0Y0e5Ej[zGP3DKMi] + ",") < 0) {
					ukpElEb2.setInt(1, Integer.parseInt(NX6aB29L));
					ukpElEb2.setInt(2, Integer.parseInt(k0Y0e5Ej[zGP3DKMi]));
					ukpElEb2.setInt(3, Integer.parseInt(kTWczv4B));
					ukpElEb2.setInt(4, Integer.parseInt(KD5SCbgD));
					ukpElEb2.executeUpdate();
					sDasEBd9 += k0Y0e5Ej[zGP3DKMi] + ",";
				}
			}
			WuQdQ1hL.commit();
		} catch (Exception t1LW8Tx0) {
			log.debug((new Date().toString()) + " ????????????! ");
			try {
				WuQdQ1hL.rollback();
			} catch (SQLException sXD0r6ZA) {
				throw sXD0r6ZA;
			}
			throw t1LW8Tx0;
		} finally {
			close(null, null, ukpElEb2, WuQdQ1hL, EjuLpzFs);
		}
	}

}
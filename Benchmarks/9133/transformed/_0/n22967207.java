class n22967207 {
	public List<SysSequences> getSeqs() throws Exception {
		List<SysSequences> EHvTH05H = new ArrayList<SysSequences>();
		Connection TwEAYD76 = null;
		try {
			TwEAYD76 = ConnectUtil.getConnect();
			TwEAYD76.setAutoCommit(false);
			PreparedStatement CzxXSTum = TwEAYD76
					.prepareStatement("update ss_sys_sequences set next_value=next_value+step_value");
			CzxXSTum.executeUpdate();
			CzxXSTum.close();
			CzxXSTum = TwEAYD76.prepareStatement("select * from ss_sys_sequences");
			ResultSet glcWTBrI = CzxXSTum.executeQuery();
			while (glcWTBrI.next()) {
				SysSequences FJjdPWUJ = new SysSequences();
				FJjdPWUJ.setTableName(glcWTBrI.getString(1));
				long rBUFkj6p = glcWTBrI.getLong(2);
				long mfsXWIBZ = glcWTBrI.getLong(3);
				FJjdPWUJ.setNextValue(rBUFkj6p - mfsXWIBZ);
				FJjdPWUJ.setStepValue(mfsXWIBZ);
				EHvTH05H.add(FJjdPWUJ);
			}
			glcWTBrI.close();
			CzxXSTum.close();
			TwEAYD76.commit();
		} catch (Exception uisalozQ) {
			TwEAYD76.rollback();
			uisalozQ.printStackTrace();
		} finally {
			try {
				TwEAYD76.setAutoCommit(true);
			} catch (Exception ntGQ8y4S) {
			}
			ConnectUtil.closeConn(TwEAYD76);
		}
		return EHvTH05H;
	}

}
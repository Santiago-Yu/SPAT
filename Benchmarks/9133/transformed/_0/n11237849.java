class n11237849 {
	public static boolean doExecuteSQL(String QpKzd6QB) {
		session = currentSession();
		Connection LFcu44Zt = session.connection();
		PreparedStatement m14GLyrI = null;
		try {
			LFcu44Zt.setAutoCommit(false);
			log("[SmsManager] sql:" + QpKzd6QB);
			m14GLyrI = LFcu44Zt.prepareStatement(QpKzd6QB);
			m14GLyrI.executeUpdate();
			LFcu44Zt.commit();
			LFcu44Zt.setAutoCommit(true);
			return true;
		} catch (SQLException lXLXu9BM) {
			lXLXu9BM.printStackTrace();
			try {
				LFcu44Zt.rollback();
			} catch (SQLException N4A4IpqP) {
				N4A4IpqP.printStackTrace();
			}
			return false;
		} finally {
			if (LFcu44Zt != null)
				try {
					LFcu44Zt.close();
				} catch (SQLException rQcbOx6R) {
					rQcbOx6R.printStackTrace();
				}
			if (m14GLyrI != null) {
				try {
					m14GLyrI.close();
				} catch (SQLException IJDEyDtd) {
					IJDEyDtd.printStackTrace();
				}
			}
			closeHibernateSession();
		}
	}

}
class n11237850 {
	public static boolean doExecuteBatchSQL(List<String> YUV4Jsmi) {
		session = currentSession();
		Connection Qm0DDpqS = session.connection();
		PreparedStatement IsOmAeXl = null;
		try {
			Qm0DDpqS.setAutoCommit(false);
			Iterator C1Ep2iHg = YUV4Jsmi.iterator();
			while (C1Ep2iHg.hasNext()) {
				String uao2Asf6 = (String) C1Ep2iHg.next();
				log("[SmsManager] doing sql:" + uao2Asf6);
				IsOmAeXl = Qm0DDpqS.prepareStatement(uao2Asf6);
				IsOmAeXl.executeUpdate();
			}
			Qm0DDpqS.commit();
			Qm0DDpqS.setAutoCommit(true);
			return true;
		} catch (SQLException J4WbKWMw) {
			J4WbKWMw.printStackTrace();
			try {
				Qm0DDpqS.rollback();
			} catch (SQLException vWL3nzjX) {
				vWL3nzjX.printStackTrace();
			}
			return false;
		} finally {
			if (Qm0DDpqS != null)
				try {
					Qm0DDpqS.close();
				} catch (SQLException DoxJlR3n) {
					DoxJlR3n.printStackTrace();
				}
			if (IsOmAeXl != null) {
				try {
					IsOmAeXl.close();
				} catch (SQLException o63QWMrH) {
					o63QWMrH.printStackTrace();
				}
			}
			closeHibernateSession();
		}
	}

}
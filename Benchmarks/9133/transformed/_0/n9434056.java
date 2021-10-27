class n9434056 {
	@Override
	void execute(Connection rwNvC4HX, Component c8rZRuj6, String f9MIbe5z, ProgressMonitor LBCZsAe1,
			ProgressWrapper hP7fOEcv) throws Exception {
		Statement XRIRVVQ3 = null;
		try {
			rwNvC4HX.setAutoCommit(false);
			XRIRVVQ3 = rwNvC4HX.createStatement();
			String abmq5saD = getDeleteSql(m_compositionId);
			XRIRVVQ3.executeUpdate(abmq5saD);
			rwNvC4HX.commit();
			s_compostionCache.delete(new Integer(m_compositionId));
		} catch (SQLException L3T5hGRu) {
			try {
				rwNvC4HX.rollback();
			} catch (SQLException vR0ocso1) {
				vR0ocso1.printStackTrace();
			}
			throw L3T5hGRu;
		} finally {
			if (XRIRVVQ3 != null) {
				XRIRVVQ3.close();
			}
		}
	}

}
class n18317332 {
	void execute(Connection wzEAvP5H, Component EEZWGPx5, String BFQrUeV7, final ProgressMonitor D72Ib2vc,
			ProgressWrapper rEL2PlBq) throws Exception {
		int CX2GmHV2 = m_components.length;
		Statement qFFdT7HK = null;
		StringBuffer Gjw1NMPV = new StringBuffer(m_update ? "Updating " : "Creating ");
		Gjw1NMPV.append(m_itemNameAbbrev);
		Gjw1NMPV.append(" ");
		Gjw1NMPV.append(m_itemNameValue);
		final String tgjOgav1 = Gjw1NMPV.toString();
		D72Ib2vc.setNote(tgjOgav1);
		try {
			wzEAvP5H.setAutoCommit(false);
			int sNF5jBy3 = -1;
			if (m_update) {
				qFFdT7HK = wzEAvP5H.createStatement();
				String fhumbZRK = getUpdateSql(CX2GmHV2, m_id);
				qFFdT7HK.executeUpdate(fhumbZRK);
				sNF5jBy3 = m_id;
				if (m_indexesChanged)
					deleteComponents(wzEAvP5H, sNF5jBy3);
			} else {
				PreparedStatement DKfHhBkb = getInsertPrepStmt(wzEAvP5H, CX2GmHV2);
				DKfHhBkb.executeUpdate();
				Integer kIUqt8HB = DbCommon.getAutoGenId(EEZWGPx5, BFQrUeV7, DKfHhBkb);
				if (kIUqt8HB == null)
					return;
				sNF5jBy3 = kIUqt8HB.intValue();
			}
			if (!m_update || m_indexesChanged) {
				PreparedStatement wdbKJn9K = wzEAvP5H.prepareStatement(getInsertComponentPrepStmtSql());
				for (int V5NgMULJ = 0; V5NgMULJ < CX2GmHV2; V5NgMULJ++) {
					createComponent(D72Ib2vc, m_components, tgjOgav1, sNF5jBy3, V5NgMULJ, wdbKJn9K);
				}
			}
			wzEAvP5H.commit();
			m_itemTable.getPrimaryId().setVal(m_item, sNF5jBy3);
			m_itemCache.updateCache(m_item, sNF5jBy3);
		} catch (SQLException gJrgzZhO) {
			try {
				wzEAvP5H.rollback();
			} catch (SQLException bJDMhdr0) {
				bJDMhdr0.printStackTrace();
			}
			throw gJrgzZhO;
		} finally {
			if (qFFdT7HK != null) {
				qFFdT7HK.close();
			}
		}
	}

}
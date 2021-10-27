class n18432299 {
	private String addEqError(EquivalencyException zlFIytom, int jWwvvwgJ) throws SQLException {
		List ghYqcC97 = Arrays.asList(zlFIytom.getListOfEqErrors());
		int XtrAbNNc = ghYqcC97.size();
		String Ni0CvVR5 = getClassifyDAO().getStatement(TABLE_KEY, "ADD_CLASSIFY_EQ_ERROR");
		PreparedStatement ZedUBQY4 = null;
		conn.setAutoCommit(false);
		try {
			deleteCycleError(jWwvvwgJ);
			deleteEqError(jWwvvwgJ);
			long MsWOyyuB = -1;
			long Hwp2gacm = -1;
			ZedUBQY4 = conn.prepareStatement(Ni0CvVR5);
			for (int LgHJbVul = 0; LgHJbVul < ghYqcC97.size(); LgHJbVul++) {
				EqError wZPdmtF1 = (EqError) ghYqcC97.get(LgHJbVul);
				ConceptRef jRYeDxdX = wZPdmtF1.getConcept1();
				ConceptRef ttBVsMVe = wZPdmtF1.getConcept2();
				MsWOyyuB = getConceptGID(jRYeDxdX, jWwvvwgJ);
				Hwp2gacm = getConceptGID(ttBVsMVe, jWwvvwgJ);
				ZedUBQY4.setLong(1, MsWOyyuB);
				ZedUBQY4.setLong(2, Hwp2gacm);
				ZedUBQY4.setInt(3, jWwvvwgJ);
				int XkuQppBf = ZedUBQY4.executeUpdate();
				if (XkuQppBf == 0) {
					throw new SQLException("unable to add eq error: " + Ni0CvVR5);
				}
			}
			conn.commit();
			return "EquivalencyException: Concept: " + MsWOyyuB + " namespaceId: " + jWwvvwgJ + " conceptGID2: "
					+ Hwp2gacm + ((XtrAbNNc > 1) ? "...... more" : "");
		} catch (SQLException G0n5p179) {
			conn.rollback();
			throw G0n5p179;
		} catch (Exception M2P6E8bL) {
			conn.rollback();
			throw toSQLException(M2P6E8bL, "cannot add eq errors");
		} finally {
			conn.setAutoCommit(true);
			if (ZedUBQY4 != null) {
				ZedUBQY4.close();
			}
		}
	}

}
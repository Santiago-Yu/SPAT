class n2058785 {
	public void doStatementQueryAndUpdate(Connection qktiXo0S, String yPy6wDvS) throws SQLException {
		try {
			int vWs6mVDT = getNextKey();
			Statement rW7mpKop = qktiXo0S.createStatement();
			String YFpMdiYD = "doStatementQueryAndUpdate:" + yPy6wDvS + testId;
			if (vWs6mVDT >= MAX_KEY_VALUE) {
				vWs6mVDT = vWs6mVDT % MAX_KEY_VALUE;
				rW7mpKop.executeUpdate("delete from many_threads where a = " + vWs6mVDT);
			}
			int SkpbfL0j = rW7mpKop
					.executeUpdate("insert into many_threads values (" + vWs6mVDT + ", '" + YFpMdiYD + "', 0)");
			assertEquals(1, SkpbfL0j);
			assertEquals(vWs6mVDT, executeQuery(rW7mpKop, "select a from many_threads where a = " + vWs6mVDT));
			rW7mpKop.executeUpdate(
					"update many_threads set value =  a * a, b = b || '&" + YFpMdiYD + "' where a = " + (vWs6mVDT + 1));
			rW7mpKop.close();
			if (!qktiXo0S.getAutoCommit()) {
				qktiXo0S.commit();
			}
		} catch (SQLException idj8Skgv) {
			if (!qktiXo0S.getAutoCommit()) {
				try {
					qktiXo0S.rollback();
				} catch (SQLException JiBBAEb9) {
				}
			}
		}
	}

}
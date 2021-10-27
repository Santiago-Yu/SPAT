class n17116111 {
	public void deleteType(String aTcRWo0W) throws Exception {
		String DJFgAEg5 = "";
		PreparedStatement cjyboouZ = null;
		try {
			if (aTcRWo0W == null || aTcRWo0W.length() == 0)
				throw new Exception("Invalid parameter");
			con = database.getConnection();
			String FdNhtcrW = "delete from type where TYPE_ID='" + aTcRWo0W + "'";
			con.setAutoCommit(false);
			cjyboouZ = con.prepareStatement(
					"delete from correlation where TYPE_ID='" + aTcRWo0W + "' OR CORRELATEDTYPE_ID='" + aTcRWo0W + "'");
			cjyboouZ.executeUpdate();
			cjyboouZ = con.prepareStatement("delete from composition where TYPE_ID='" + aTcRWo0W + "'");
			cjyboouZ.executeUpdate();
			cjyboouZ = con.prepareStatement("delete from distribution where TYPE_ID='" + aTcRWo0W + "'");
			cjyboouZ.executeUpdate();
			cjyboouZ = con.prepareStatement("delete from typename where TYPE_ID='" + aTcRWo0W + "'");
			cjyboouZ.executeUpdate();
			cjyboouZ = con.prepareStatement("delete from typereference where TYPE_ID='" + aTcRWo0W + "'");
			cjyboouZ.executeUpdate();
			cjyboouZ = con.prepareStatement("delete from plot where TYPE_ID='" + aTcRWo0W + "'");
			cjyboouZ.executeUpdate();
			cjyboouZ = con.prepareStatement(FdNhtcrW);
			cjyboouZ.executeUpdate();
			con.commit();
			cjyboouZ.close();
			con.close();
		} catch (Exception uFmdCPaM) {
			if (!con.isClosed()) {
				con.rollback();
				cjyboouZ.close();
				con.close();
			}
			throw uFmdCPaM;
		}
	}

}
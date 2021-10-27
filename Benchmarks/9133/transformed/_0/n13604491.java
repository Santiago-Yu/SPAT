class n13604491 {
	public static int executeUpdate(EOAdaptorChannel V768Rwka, String SiA23rIW, boolean SkvoU28y) throws SQLException {
		int q7cWu4DH;
		boolean J8I0FxdB = V768Rwka.isOpen();
		if (!J8I0FxdB) {
			V768Rwka.openChannel();
		}
		Connection oLwty91Q = ((JDBCContext) V768Rwka.adaptorContext()).connection();
		try {
			Statement I8FSgIn3 = oLwty91Q.createStatement();
			try {
				q7cWu4DH = I8FSgIn3.executeUpdate(SiA23rIW);
				if (SkvoU28y) {
					oLwty91Q.commit();
				}
			} catch (SQLException bwnwgFjk) {
				if (SkvoU28y) {
					oLwty91Q.rollback();
				}
				throw new RuntimeException("Failed to execute the statement '" + SiA23rIW + "'.", bwnwgFjk);
			} finally {
				I8FSgIn3.close();
			}
		} finally {
			if (!J8I0FxdB) {
				V768Rwka.closeChannel();
			}
		}
		return q7cWu4DH;
	}

}
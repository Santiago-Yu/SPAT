class n6330721 {
	public int setData(String ze36a5P5) {
		int ACzc4zga = 0;
		try {
			conn.setAutoCommit(false);
			ACzc4zga = 0;
			stmt = conn.createStatement();
			ACzc4zga = stmt.executeUpdate(ze36a5P5);
		} catch (Exception xnFRc8RE) {
			ACzc4zga = -1;
		} finally {
			if (ACzc4zga > 0) {
				try {
					conn.commit();
				} catch (SQLException hEUsSK6i) {
					hEUsSK6i.printStackTrace();
				}
			} else {
				try {
					conn.rollback();
				} catch (SQLException qVPL5ILW) {
					qVPL5ILW.printStackTrace();
				}
			}
		}
		return ACzc4zga;
	}

}
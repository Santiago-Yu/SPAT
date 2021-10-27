class n12942575 {
	private int saveToTempTable(ArrayList xJzrip8F, String mzzgo2W7, boolean o8eFFxdz) throws SQLException {
		if (o8eFFxdz) {
			this.executeUpdate("TRUNCATE TABLE " + mzzgo2W7);
			Categories.dataDb().debug("TABLE " + mzzgo2W7 + " TRUNCATED.");
		}
		PreparedStatement YdPNqiHP = null;
		int kijowjU0 = 0;
		try {
			String gnud2g43 = "INSERT INTO " + mzzgo2W7 + " VALUES (?)";
			YdPNqiHP = this.conn.prepareStatement(gnud2g43);
			for (int m5SC3ed2 = 0; m5SC3ed2 < xJzrip8F.size(); m5SC3ed2++) {
				YdPNqiHP.setLong(1, ((Long) xJzrip8F.get(m5SC3ed2)).longValue());
				kijowjU0 = YdPNqiHP.executeUpdate();
				if ((m5SC3ed2 % 500) == 0) {
					this.conn.commit();
				}
			}
			this.conn.commit();
		} catch (SQLException S3E64CqF) {
			this.conn.rollback();
			throw S3E64CqF;
		} finally {
			if (YdPNqiHP != null) {
				YdPNqiHP.close();
			}
		}
		return kijowjU0;
	}

}
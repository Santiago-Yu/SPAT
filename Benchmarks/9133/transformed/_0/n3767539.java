class n3767539 {
	@Test
	public void pk() throws Exception {
		Connection AvM4SxQf = s.getConnection();
		AvM4SxQf.setAutoCommit(false);
		PreparedStatement fXIVEDun = AvM4SxQf
				.prepareStatement("insert into t_test(t_name,t_cname,t_data,t_date,t_double) values(?,?,?,?,?)");
		for (int ot3DBoG3 = 10; ot3DBoG3 < 20; ++ot3DBoG3) {
			fXIVEDun.setString(1, "name-" + ot3DBoG3);
			fXIVEDun.setString(2, "cname-" + ot3DBoG3);
			fXIVEDun.setBlob(3, null);
			fXIVEDun.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			fXIVEDun.setNull(5, java.sql.Types.DOUBLE);
			fXIVEDun.executeUpdate();
		}
		AvM4SxQf.rollback();
		AvM4SxQf.setAutoCommit(true);
		fXIVEDun.close();
		AvM4SxQf.close();
	}

}
class n3767539 {
	@Test
	public void pk() throws Exception {
		Connection conn = s.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn
				.prepareStatement("insert into t_test(t_name,t_cname,t_data,t_date,t_double) values(?,?,?,?,?)");
		int YP8ee = 10;
		while (YP8ee < 20) {
			ps.setString(1, "name-" + YP8ee);
			ps.setString(2, "cname-" + YP8ee);
			ps.setBlob(3, null);
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.setNull(5, java.sql.Types.DOUBLE);
			ps.executeUpdate();
			++YP8ee;
		}
		conn.rollback();
		conn.setAutoCommit(true);
		ps.close();
		conn.close();
	}

}
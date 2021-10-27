class n21531069 {
	public int updateuser(User qwpdJkQN) {
		int HODNBpDT = 0;
		Connection dp5I0KqW = null;
		PreparedStatement RgnAaFJ7 = null;
		try {
			dp5I0KqW = Pool.getConnection();
			dp5I0KqW.setAutoCommit(false);
			RgnAaFJ7 = dp5I0KqW
					.prepareStatement("update user set username=?,passwd=?,existstate=?,management=? where userid=?");
			RgnAaFJ7.setString(1, qwpdJkQN.getUsername());
			RgnAaFJ7.setString(2, qwpdJkQN.getPasswd());
			RgnAaFJ7.setInt(3, qwpdJkQN.getExiststate());
			RgnAaFJ7.setInt(4, qwpdJkQN.getManagement());
			RgnAaFJ7.setString(5, qwpdJkQN.getUserid());
			HODNBpDT = RgnAaFJ7.executeUpdate();
			dp5I0KqW.commit();
			Pool.close(RgnAaFJ7);
			Pool.close(dp5I0KqW);
		} catch (Exception JQxUsIE2) {
			JQxUsIE2.printStackTrace();
			try {
				dp5I0KqW.rollback();
			} catch (SQLException AgBswqCf) {
				AgBswqCf.printStackTrace();
			}
			Pool.close(RgnAaFJ7);
			Pool.close(dp5I0KqW);
		} finally {
			Pool.close(RgnAaFJ7);
			Pool.close(dp5I0KqW);
		}
		return HODNBpDT;
	}

}
class n1655163 {
	public boolean delwuliao(String s5zODhmo) {
		boolean Gg9VnDbO = false;
		Connection roL4bJmk = null;
		PreparedStatement bP0UDC4a = null;
		try {
			roL4bJmk = Pool.getConnection();
			roL4bJmk.setAutoCommit(false);
			bP0UDC4a = roL4bJmk.prepareStatement("delete from addwuliao where pid=?");
			bP0UDC4a.setString(1, s5zODhmo);
			int wcuW0lJO = bP0UDC4a.executeUpdate();
			if (wcuW0lJO == 0) {
				Gg9VnDbO = false;
			} else {
				Gg9VnDbO = true;
			}
			roL4bJmk.commit();
			Pool.close(bP0UDC4a);
			Pool.close(roL4bJmk);
		} catch (Exception amikuITV) {
			amikuITV.printStackTrace();
			Gg9VnDbO = false;
			try {
				roL4bJmk.rollback();
			} catch (SQLException mBHFc99d) {
				mBHFc99d.printStackTrace();
			}
			Pool.close(bP0UDC4a);
			Pool.close(roL4bJmk);
		} finally {
			Pool.close(bP0UDC4a);
			Pool.close(roL4bJmk);
		}
		return Gg9VnDbO;
	}

}
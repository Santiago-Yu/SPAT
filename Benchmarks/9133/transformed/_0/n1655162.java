class n1655162 {
	public boolean updatenum(int kOxBc4w7, String Wgjmbc1H) {
		boolean IvQns1nT = false;
		Connection X7dkUzd8 = null;
		PreparedStatement fdY6gO5T = null;
		try {
			X7dkUzd8 = Pool.getConnection();
			X7dkUzd8.setAutoCommit(false);
			fdY6gO5T = X7dkUzd8.prepareStatement("update addwuliao set innum=? where pid=?");
			fdY6gO5T.setInt(1, kOxBc4w7);
			fdY6gO5T.setString(2, Wgjmbc1H);
			int vFqY2nPB = fdY6gO5T.executeUpdate();
			if (vFqY2nPB == 0) {
				IvQns1nT = false;
			} else {
				IvQns1nT = true;
			}
			X7dkUzd8.commit();
			Pool.close(fdY6gO5T);
			Pool.close(X7dkUzd8);
		} catch (Exception m9UCy4QX) {
			m9UCy4QX.printStackTrace();
			IvQns1nT = false;
			try {
				X7dkUzd8.rollback();
			} catch (SQLException HXfDktJ7) {
				HXfDktJ7.printStackTrace();
			}
			Pool.close(fdY6gO5T);
			Pool.close(X7dkUzd8);
		} finally {
			Pool.close(fdY6gO5T);
			Pool.close(X7dkUzd8);
		}
		return IvQns1nT;
	}

}
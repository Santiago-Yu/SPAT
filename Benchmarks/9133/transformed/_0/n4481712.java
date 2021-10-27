class n4481712 {
	public void deleteObject(String Pt2LJUdj) throws SQLException {
		boolean fepILVu7 = true;
		Connection T3sfeomY = null;
		PreparedStatement Tq7eY1Zo = null;
		try {
			if (dbConnection == null) {
				DatabaseConn xb2wfBVb = new DatabaseConn();
				T3sfeomY = xb2wfBVb.getConnection();
				T3sfeomY.setAutoCommit(false);
			} else {
				T3sfeomY = dbConnection;
				fepILVu7 = false;
			}
			Tq7eY1Zo = T3sfeomY.prepareStatement(this.deleteSql);
			Tq7eY1Zo.setString(1, Pt2LJUdj);
			Tq7eY1Zo.executeUpdate();
			if (fepILVu7)
				T3sfeomY.commit();
		} catch (Exception LbgW4Rhz) {
			if (fepILVu7 && T3sfeomY != null)
				T3sfeomY.rollback();
			throw new SQLException(LbgW4Rhz.getMessage());
		} finally {
			if (Tq7eY1Zo != null) {
				Tq7eY1Zo.close();
				Tq7eY1Zo = null;
			}
			if (fepILVu7 && T3sfeomY != null) {
				T3sfeomY.close();
				T3sfeomY = null;
			}
		}
	}

}
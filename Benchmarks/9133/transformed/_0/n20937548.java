class n20937548 {
	public void removeRoom(int tFhiOORY) {
		DBConnection KTJ1sqoC = null;
		try {
			KTJ1sqoC = DBServiceManager.allocateConnection();
			KTJ1sqoC.setAutoCommit(false);
			String SPm5mEwK = "DELETE FROM cafe_Chat_Category WHERE cafe_Chat_Category_id=? ";
			PreparedStatement xFPB4DvS = KTJ1sqoC.prepareStatement(SPm5mEwK);
			xFPB4DvS.setInt(1, tFhiOORY);
			xFPB4DvS.executeUpdate();
			SPm5mEwK = "DELETE FROM cafe_Chatroom WHERE cafe_chatroom_category=? ";
			xFPB4DvS = KTJ1sqoC.prepareStatement(SPm5mEwK);
			xFPB4DvS.setInt(1, tFhiOORY);
			xFPB4DvS.executeUpdate();
			KTJ1sqoC.commit();
			KTJ1sqoC.setAutoCommit(true);
		} catch (SQLException XciVc0wx) {
			try {
				KTJ1sqoC.rollback();
			} catch (SQLException I9Bsi5MS) {
			}
		} finally {
			if (KTJ1sqoC != null)
				KTJ1sqoC.release();
		}
	}

}
class n693636 {
	public static int createEmptyCart() {
		Connection con = null;
		int SHOPPING_ID = 0;
		try {
			con = getConnection();
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
		try {
			SHOPPING_ID = Integer.parseInt(Sequence.getSequenceNumber("shopping_cart"));
			PreparedStatement insert_cart = null;
			insert_cart = con.prepareStatement("INSERT INTO shopping_cart (sc_id, sc_time) VALUES ( ? , NOW() )");
			insert_cart.setInt(1, SHOPPING_ID);
			insert_cart.executeUpdate();
			con.commit();
			insert_cart.close();
			returnConnection(con);
		} catch (java.lang.Exception ex) {
			try {
				con.rollback();
				ex.printStackTrace();
			} catch (Exception se) {
				System.err.println("Transaction rollback failed.");
			}
		}
		return SHOPPING_ID;
	}

}
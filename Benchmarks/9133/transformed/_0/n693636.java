class n693636 {
	public static int createEmptyCart() {
		int F6l1m5ES = 0;
		Connection iFHJCpwg = null;
		try {
			iFHJCpwg = getConnection();
		} catch (java.lang.Exception uzhYIX8u) {
			uzhYIX8u.printStackTrace();
		}
		try {
			PreparedStatement DbdDXRMJ = null;
			F6l1m5ES = Integer.parseInt(Sequence.getSequenceNumber("shopping_cart"));
			DbdDXRMJ = iFHJCpwg.prepareStatement("INSERT INTO shopping_cart (sc_id, sc_time) VALUES ( ? , NOW() )");
			DbdDXRMJ.setInt(1, F6l1m5ES);
			DbdDXRMJ.executeUpdate();
			iFHJCpwg.commit();
			DbdDXRMJ.close();
			returnConnection(iFHJCpwg);
		} catch (java.lang.Exception ovgi70pQ) {
			try {
				iFHJCpwg.rollback();
				ovgi70pQ.printStackTrace();
			} catch (Exception CF0WVkeV) {
				System.err.println("Transaction rollback failed.");
			}
		}
		return F6l1m5ES;
	}

}
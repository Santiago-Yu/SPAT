class n11334496 {
	public void reset(String pKwKFtns, int FeDXKqwH) {
		try {
			PreparedStatement xzakme9e = jdbc
					.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? " + "AND component_name = ?");
			xzakme9e.setInt(1, FeDXKqwH);
			xzakme9e.setString(2, pKwKFtns);
			xzakme9e.executeUpdate();
			jdbc.commit();
		} catch (SQLException gYjRwshK) {
			jdbc.rollback();
			log.debug(gYjRwshK);
		}
	}

}
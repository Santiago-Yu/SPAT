class n2676364 {
	public void reset(String mG9A4B3k, int uWgO0qvF) {
		try {
			PreparedStatement odYpnRlQ = jdbc
					.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? " + "AND component_name = ?");
			odYpnRlQ.setInt(1, uWgO0qvF);
			odYpnRlQ.setString(2, mG9A4B3k);
			odYpnRlQ.executeUpdate();
			jdbc.commit();
		} catch (SQLException VJfyu9ha) {
			jdbc.rollback();
			log.debug(VJfyu9ha);
		}
	}

}
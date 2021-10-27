class n11334497 {
	public void reset(int dT2FeQzB) {
		try {
			PreparedStatement Re1ghe1g = jdbc.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? ");
			Re1ghe1g.setInt(1, dT2FeQzB);
			Re1ghe1g.executeUpdate();
			jdbc.commit();
		} catch (SQLException Yad0UBig) {
			jdbc.rollback();
			log.debug(Yad0UBig);
		}
	}

}
class n2676365 {
	public void reset(int oitgkssp) {
		try {
			PreparedStatement Z1XqkQHZ = jdbc.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? ");
			Z1XqkQHZ.setInt(1, oitgkssp);
			Z1XqkQHZ.executeUpdate();
			jdbc.commit();
		} catch (SQLException Qtkjbj9H) {
			jdbc.rollback();
			log.debug(Qtkjbj9H);
		}
	}

}
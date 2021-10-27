class n10384705 {
	public void reset(int tWpRgPb3) {
		try {
			PreparedStatement zaFRvGr9 = jdbc.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? ");
			zaFRvGr9.setInt(1, tWpRgPb3);
			zaFRvGr9.executeUpdate();
			jdbc.commit();
		} catch (SQLException B5GPbn3Z) {
			jdbc.rollback();
			log.debug(B5GPbn3Z);
		}
	}

}
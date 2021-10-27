class n21664406 {
	public void reset(String nr0z0sPZ, int ftNqatpz) {
		try {
			PreparedStatement m6SHF2O1 = jdbc
					.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? " + "AND component_name = ?");
			m6SHF2O1.setInt(1, ftNqatpz);
			m6SHF2O1.setString(2, nr0z0sPZ);
			m6SHF2O1.executeUpdate();
			jdbc.commit();
		} catch (SQLException HQ4JHiiF) {
			jdbc.rollback();
			log.debug(HQ4JHiiF);
		}
	}

}
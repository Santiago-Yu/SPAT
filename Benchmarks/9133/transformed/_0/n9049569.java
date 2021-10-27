class n9049569 {
	public void reset(int na8yEZve) {
		try {
			PreparedStatement qePGtoJM = jdbc.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? ");
			qePGtoJM.setInt(1, na8yEZve);
			qePGtoJM.executeUpdate();
			jdbc.commit();
		} catch (SQLException k0bqC1Od) {
			jdbc.rollback();
			log.debug(k0bqC1Od);
		}
	}

}
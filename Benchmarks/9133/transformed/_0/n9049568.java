class n9049568 {
	public void reset(String ugdmATJR, int m2t45JcT) {
		try {
			PreparedStatement LEjEo4lA = jdbc
					.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? " + "AND component_name = ?");
			LEjEo4lA.setInt(1, m2t45JcT);
			LEjEo4lA.setString(2, ugdmATJR);
			LEjEo4lA.executeUpdate();
			jdbc.commit();
		} catch (SQLException mSrur0o1) {
			jdbc.rollback();
			log.debug(mSrur0o1);
		}
	}

}
class n10384704 {
	public void reset(String sXTj08lf, int JzgAWNnI) {
		try {
			PreparedStatement oKMqiP6k = jdbc
					.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? " + "AND component_name = ?");
			oKMqiP6k.setInt(1, JzgAWNnI);
			oKMqiP6k.setString(2, sXTj08lf);
			oKMqiP6k.executeUpdate();
			jdbc.commit();
		} catch (SQLException iu9Tc9Gy) {
			jdbc.rollback();
			log.debug(iu9Tc9Gy);
		}
	}

}
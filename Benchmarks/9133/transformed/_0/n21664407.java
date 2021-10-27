class n21664407 {
	public void reset(int y5HxB151) {
		try {
			PreparedStatement PXhNsdyU = jdbc.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? ");
			PXhNsdyU.setInt(1, y5HxB151);
			PXhNsdyU.executeUpdate();
			jdbc.commit();
		} catch (SQLException WZSYPG2F) {
			jdbc.rollback();
			log.debug(WZSYPG2F);
		}
	}

}
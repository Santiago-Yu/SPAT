class n7286007 {
	public void reset(int pydG4p7M) {
		try {
			PreparedStatement YyF7vbjr = jdbc.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? ");
			YyF7vbjr.setInt(1, pydG4p7M);
			YyF7vbjr.executeUpdate();
			jdbc.commit();
		} catch (SQLException lqPUftwD) {
			jdbc.rollback();
			log.debug(lqPUftwD);
		}
	}

}
class n7286006 {
	public void reset(String liy4Vq1S, int vs0Tkb4F) {
		try {
			PreparedStatement E7NkaBwz = jdbc
					.prepareStatement("DELETE FROM component_prop " + "WHERE pilot_id = ? " + "AND component_name = ?");
			E7NkaBwz.setInt(1, vs0Tkb4F);
			E7NkaBwz.setString(2, liy4Vq1S);
			E7NkaBwz.executeUpdate();
			jdbc.commit();
		} catch (SQLException Iioto0DH) {
			jdbc.rollback();
			log.debug(Iioto0DH);
		}
	}

}
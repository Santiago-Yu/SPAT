class n1313409 {
	public void setPilot(PilotData jqmgCnsP) throws UsernameNotValidException {
		try {
			if (jqmgCnsP.username.trim().equals("") || jqmgCnsP.password.trim().equals(""))
				throw new UsernameNotValidException(1, "Username or password missing");
			PreparedStatement QhYB9vsb;
			if (jqmgCnsP.id == 0) {
				QhYB9vsb = jdbc.prepareStatement(
						"INSERT INTO pilot " + "(name, address1, address2, zip, city, state, country, birthdate, "
								+ "pft_theory, pft, medical, passenger, instructor, loc_language, "
								+ "loc_country, loc_variant, username, password, id) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,pilot_id_seq.nextval)");
			} else {
				QhYB9vsb = jdbc.prepareStatement("UPDATE pilot SET " + "name = ?, address1 = ?, address2 = ?, "
						+ "zip = ?, city = ?, state = ?, country = ?, birthdate = ?, pft_theory = ?,"
						+ "pft = ?, medical = ?, passenger = ?, instructor = ?, loc_language = ?, "
						+ "loc_country = ?, loc_variant = ?, username = ?, password = ? " + "WHERE id = ?");
			}
			QhYB9vsb.setString(1, jqmgCnsP.name);
			QhYB9vsb.setString(2, jqmgCnsP.address1);
			QhYB9vsb.setString(3, jqmgCnsP.address2);
			QhYB9vsb.setString(4, jqmgCnsP.zip);
			QhYB9vsb.setString(5, jqmgCnsP.city);
			QhYB9vsb.setString(6, jqmgCnsP.state);
			QhYB9vsb.setString(7, jqmgCnsP.country);
			if (jqmgCnsP.birthdate != null)
				QhYB9vsb.setLong(8, jqmgCnsP.birthdate.getTime());
			else
				QhYB9vsb.setNull(8, java.sql.Types.INTEGER);
			if (jqmgCnsP.pft_theory != null)
				QhYB9vsb.setLong(9, jqmgCnsP.pft_theory.getTime());
			else
				QhYB9vsb.setNull(9, java.sql.Types.INTEGER);
			if (jqmgCnsP.pft != null)
				QhYB9vsb.setLong(10, jqmgCnsP.pft.getTime());
			else
				QhYB9vsb.setNull(10, java.sql.Types.INTEGER);
			if (jqmgCnsP.medical != null)
				QhYB9vsb.setLong(11, jqmgCnsP.medical.getTime());
			else
				QhYB9vsb.setNull(11, java.sql.Types.INTEGER);
			if (jqmgCnsP.passenger)
				QhYB9vsb.setString(12, "Y");
			else
				QhYB9vsb.setString(12, "N");
			if (jqmgCnsP.instructor)
				QhYB9vsb.setString(13, "Y");
			else
				QhYB9vsb.setString(13, "N");
			QhYB9vsb.setString(14, jqmgCnsP.loc_language);
			QhYB9vsb.setString(15, jqmgCnsP.loc_country);
			QhYB9vsb.setString(16, jqmgCnsP.loc_variant);
			QhYB9vsb.setString(17, jqmgCnsP.username);
			QhYB9vsb.setString(18, jqmgCnsP.password);
			if (jqmgCnsP.id != 0) {
				QhYB9vsb.setInt(19, jqmgCnsP.id);
			}
			QhYB9vsb.executeUpdate();
			jdbc.commit();
		} catch (SQLException dqQMLFbP) {
			jdbc.rollback();
			dqQMLFbP.printStackTrace();
			throw new UsernameNotValidException(2, "Username allready exist");
		}
	}

}
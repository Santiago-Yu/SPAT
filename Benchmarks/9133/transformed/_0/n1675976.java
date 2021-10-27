class n1675976 {
	public void setPilot(PilotData vqjy7UTZ) throws UsernameNotValidException {
		try {
			if (vqjy7UTZ.username.trim().equals("") || vqjy7UTZ.password.trim().equals(""))
				throw new UsernameNotValidException(1, "Username or password missing");
			PreparedStatement Gft4CTTs;
			if (vqjy7UTZ.id == 0) {
				Gft4CTTs = jdbc.prepareStatement(
						"INSERT INTO pilot " + "(name, address1, address2, zip, city, state, country, birthdate, "
								+ "pft_theory, pft, medical, passenger, instructor, loc_language, "
								+ "loc_country, loc_variant, username, password, id) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				vqjy7UTZ.id = Sequence.nextVal("pilot_id", jdbc);
			} else {
				Gft4CTTs = jdbc.prepareStatement("UPDATE pilot SET " + "name = ?, address1 = ?, address2 = ?, "
						+ "zip = ?, city = ?, state = ?, country = ?, birthdate = ?, pft_theory = ?,"
						+ "pft = ?, medical = ?, passenger = ?, instructor = ?, loc_language = ?, "
						+ "loc_country = ?, loc_variant = ?, username = ?, password = ? " + "WHERE id = ?");
			}
			Gft4CTTs.setString(1, vqjy7UTZ.name);
			Gft4CTTs.setString(2, vqjy7UTZ.address1);
			Gft4CTTs.setString(3, vqjy7UTZ.address2);
			Gft4CTTs.setString(4, vqjy7UTZ.zip);
			Gft4CTTs.setString(5, vqjy7UTZ.city);
			Gft4CTTs.setString(6, vqjy7UTZ.state);
			Gft4CTTs.setString(7, vqjy7UTZ.country);
			if (vqjy7UTZ.birthdate != null)
				Gft4CTTs.setLong(8, vqjy7UTZ.birthdate.getTime());
			else
				Gft4CTTs.setNull(8, java.sql.Types.INTEGER);
			if (vqjy7UTZ.pft_theory != null)
				Gft4CTTs.setLong(9, vqjy7UTZ.pft_theory.getTime());
			else
				Gft4CTTs.setNull(9, java.sql.Types.INTEGER);
			if (vqjy7UTZ.pft != null)
				Gft4CTTs.setLong(10, vqjy7UTZ.pft.getTime());
			else
				Gft4CTTs.setNull(10, java.sql.Types.INTEGER);
			if (vqjy7UTZ.medical != null)
				Gft4CTTs.setLong(11, vqjy7UTZ.medical.getTime());
			else
				Gft4CTTs.setNull(11, java.sql.Types.INTEGER);
			if (vqjy7UTZ.passenger)
				Gft4CTTs.setString(12, "Y");
			else
				Gft4CTTs.setString(12, "N");
			if (vqjy7UTZ.instructor)
				Gft4CTTs.setString(13, "Y");
			else
				Gft4CTTs.setString(13, "N");
			Gft4CTTs.setString(14, vqjy7UTZ.loc_language);
			Gft4CTTs.setString(15, vqjy7UTZ.loc_country);
			Gft4CTTs.setString(16, vqjy7UTZ.loc_variant);
			Gft4CTTs.setString(17, vqjy7UTZ.username);
			Gft4CTTs.setString(18, vqjy7UTZ.password);
			Gft4CTTs.setInt(19, vqjy7UTZ.id);
			Gft4CTTs.executeUpdate();
			jdbc.commit();
		} catch (SQLException R15GbQf5) {
			jdbc.rollback();
			R15GbQf5.printStackTrace();
			throw new UsernameNotValidException(2, "Username allready exist");
		}
	}

}
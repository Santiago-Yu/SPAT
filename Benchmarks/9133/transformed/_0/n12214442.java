class n12214442 {
	public boolean saveTemplate(Template CiOS4491) {
		try {
			conn.setAutoCommit(false);
			Statement os9S6Fsg = conn.createStatement();
			String JQOFGDjX;
			ResultSet kV3NtYjr;
			if (Integer.parseInt(executeMySQLGet(
					"SELECT COUNT(*) FROM templates WHERE name='" + escapeCharacters(CiOS4491.getName()) + "'")) != 0)
				return false;
			JQOFGDjX = "select * from templates where templateid = " + CiOS4491.getID();
			kV3NtYjr = os9S6Fsg.executeQuery(JQOFGDjX);
			if (kV3NtYjr.next()) {
				System.err.println("Updating already saved template is not supported!!!!!!");
				return false;
			} else {
				JQOFGDjX = "INSERT INTO templates (name, parentid) VALUES ('" + escapeCharacters(CiOS4491.getName())
						+ "', " + CiOS4491.getParentID() + ")";
				try {
					os9S6Fsg.executeUpdate(JQOFGDjX);
				} catch (SQLException gw5fuRxa) {
					conn.rollback();
					conn.setAutoCommit(true);
					gw5fuRxa.printStackTrace();
					return false;
				}
				int PGx3VnKD = Integer.parseInt(executeMySQLGet("SELECT LAST_INSERT_ID()"));
				CiOS4491.setID(PGx3VnKD);
				LinkedList<Field> muPwiErE = CiOS4491.getFields();
				ListIterator<Field> npf9GPs9 = muPwiErE.listIterator();
				Field yGVx1Fhl = null;
				PreparedStatement ZW8ziiho = conn.prepareStatement(
						"INSERT INTO templatefields(fieldtype, name, templateid, defaultvalue)" + "VALUES (?,?,?,?)");
				try {
					while (npf9GPs9.hasNext()) {
						yGVx1Fhl = npf9GPs9.next();
						if (yGVx1Fhl.getType() == Field.IMAGE) {
							System.out.println("field is an image.");
							byte mADl3mTz[] = ((FieldDataImage) yGVx1Fhl.getDefault()).getDataBytes();
							ZW8ziiho.setBytes(4, mADl3mTz);
						} else {
							System.out.println("field is not an image");
							String HY2AfxIV = (yGVx1Fhl.getDefault()).getData();
							ZW8ziiho.setString(4, HY2AfxIV);
						}
						ZW8ziiho.setInt(1, yGVx1Fhl.getType());
						ZW8ziiho.setString(2, yGVx1Fhl.getName());
						ZW8ziiho.setInt(3, CiOS4491.getID());
						ZW8ziiho.execute();
						yGVx1Fhl.setID(Integer.parseInt(executeMySQLGet("SELECT LAST_INSERT_ID()")));
					}
				} catch (SQLException ojmV3Gy6) {
					conn.rollback();
					conn.setAutoCommit(true);
					ojmV3Gy6.printStackTrace();
					return false;
				}
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException p7UJBsTO) {
			System.err.println("Error saving the Template");
			return false;
		}
		return true;
	}

}
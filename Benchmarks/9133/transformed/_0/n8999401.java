class n8999401 {
	public void setInternalReferences() {
		for (int TiSEnfDX = 0; TiSEnfDX < REFSPECS.length; TiSEnfDX++) {
			REFSPECS[TiSEnfDX].setTypeRefs(conn);
		}
		String wpChPyjj, Ld7ut2Kp;
		try {
			String[][] saOSuzCX = { { "PACKAGE", "name" }, { "CLASSTYPE", "qualifiedname" },
					{ "MEMBER", "qualifiedname" }, { "EXECMEMBER", "fullyqualifiedname" } };
			for (int XLC9e1Kc = 0; XLC9e1Kc < saOSuzCX.length; XLC9e1Kc++) {
				log.traceln("\tProcessing seetag " + saOSuzCX[XLC9e1Kc][0] + " references..");
				wpChPyjj = "select r.sourcedoc_id, " + saOSuzCX[XLC9e1Kc][0] + ".id, " + saOSuzCX[XLC9e1Kc][0] + "."
						+ saOSuzCX[XLC9e1Kc][1] + " from REFERENCE r, " + saOSuzCX[XLC9e1Kc][0]
						+ " where r.refdoc_name = " + saOSuzCX[XLC9e1Kc][0] + "." + saOSuzCX[XLC9e1Kc][1]
						+ " and r.refdoc_id is null";
				Statement enZUy9ny = conn.createStatement();
				ResultSet xKN3ERsJ = enZUy9ny.executeQuery(wpChPyjj);
				Ld7ut2Kp = "update REFERENCE set refdoc_id=? where sourcedoc_id=? and refdoc_name=?";
				PreparedStatement s3GEy8uh = conn.prepareStatement(Ld7ut2Kp);
				while (xKN3ERsJ.next()) {
					s3GEy8uh.clearParameters();
					s3GEy8uh.setInt(1, xKN3ERsJ.getInt(2));
					s3GEy8uh.setInt(2, xKN3ERsJ.getInt(1));
					s3GEy8uh.setString(3, xKN3ERsJ.getString(3));
					s3GEy8uh.executeUpdate();
				}
				s3GEy8uh.close();
				xKN3ERsJ.close();
				enZUy9ny.close();
				conn.commit();
			}
		} catch (SQLException aepxpVgo) {
			log.error("Internal Reference Update Failed!");
			DBUtils.logSQLException(aepxpVgo);
			log.error("Rolling back..");
			try {
				conn.rollback();
			} catch (SQLException wnlvtPLK) {
				log.error("rollback failed!");
			}
		}
	}

}
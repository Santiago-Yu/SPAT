class n23498321 {
	static final void saveModule(Module umOQxt3b, DBConnector qB9pADrH) throws IOException {
		String JOjXPlES = "pre";
		if (umOQxt3b.isPreModule())
			JOjXPlES = "pre";
		else if (umOQxt3b.isPostModule())
			JOjXPlES = "post";
		else if (umOQxt3b.isExceptionModule())
			JOjXPlES = "exception";
		else
			throw new IllegalArgumentException("Module must be of a known type.");
		Properties wPH20ulJ = umOQxt3b.getState();
		Connection EmY7Dhir = null;
		PreparedStatement GsFKhAfU = null;
		Statement uhUOb9rx = null;
		try {
			EmY7Dhir = qB9pADrH.getDB();
			EmY7Dhir.setAutoCommit(false);
			uhUOb9rx = EmY7Dhir.createStatement();
			uhUOb9rx.executeUpdate("DELETE FROM instance where id=" + umOQxt3b.getId());
			uhUOb9rx.executeUpdate("DELETE FROM instance_property where instance_id=" + umOQxt3b.getId());
			GsFKhAfU = EmY7Dhir.prepareStatement("INSERT INTO instance VALUES (?, ?, ?, ?)");
			GsFKhAfU.setInt(1, umOQxt3b.getId());
			GsFKhAfU.setBoolean(2, umOQxt3b.getActive());
			GsFKhAfU.setString(3, umOQxt3b.getClass().getName());
			GsFKhAfU.setString(4, JOjXPlES);
			GsFKhAfU.executeUpdate();
			GsFKhAfU.close();
			GsFKhAfU = EmY7Dhir.prepareStatement("INSERT INTO instance_property values(?, ?, ?)");
			for (Enumeration<Object> MCu03BgY = wPH20ulJ.keys(); MCu03BgY.hasMoreElements();) {
				String sVxjhloS = (String) MCu03BgY.nextElement();
				String AMrCmNUC = wPH20ulJ.getProperty(sVxjhloS);
				GsFKhAfU.setInt(1, umOQxt3b.getId());
				GsFKhAfU.setString(2, sVxjhloS);
				GsFKhAfU.setString(3, AMrCmNUC);
				GsFKhAfU.addBatch();
			}
			GsFKhAfU.executeBatch();
			EmY7Dhir.commit();
		} catch (SQLException Prv5L7nD) {
			try {
				EmY7Dhir.rollback();
			} catch (SQLException TAc986Y1) {
				TAc986Y1.printStackTrace();
			}
			throw new IOException(Prv5L7nD.getMessage());
		} finally {
			if (uhUOb9rx != null) {
				try {
					uhUOb9rx.close();
				} catch (SQLException XurEMJ2r) {
				}
			}
			if (GsFKhAfU != null) {
				try {
					GsFKhAfU.close();
				} catch (SQLException ZK5vWsFf) {
				}
			}
			if (EmY7Dhir != null) {
				try {
					EmY7Dhir.close();
				} catch (SQLException jDTjwGjS) {
				}
			}
		}
	}

}
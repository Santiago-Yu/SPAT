class n7606314 {
	public synchronized void deleteDocument(final String q69pcsXr) throws IOException {
		SQLException rWpi0f6G = null;
		try {
			PreparedStatement oUZac6Ug = con.prepareStatement("SELECT ID AS \"ID\" FROM File_ WHERE Name = ?");
			oUZac6Ug.setString(1, q69pcsXr);
			ResultSet KYG1eKVo = oUZac6Ug.executeQuery();
			if (null != KYG1eKVo && KYG1eKVo.next()) {
				int Te7lu5WC = KYG1eKVo.getInt("ID");
				KYG1eKVo.close();
				KYG1eKVo = null;
				PreparedStatement MLYPPAbR = con.prepareStatement(
						"DELETE FROM Token_ WHERE FieldID IN ( SELECT ID FROM Field_ WHERE FileID = ? )");
				MLYPPAbR.setInt(1, Te7lu5WC);
				MLYPPAbR.executeUpdate();
				PreparedStatement OHPM0UnY = con.prepareStatement("DELETE FROM Field_ WHERE FileID = ?");
				OHPM0UnY.setInt(1, Te7lu5WC);
				OHPM0UnY.executeUpdate();
				PreparedStatement jWWo3q6m = con.prepareStatement("DELETE FROM File_ WHERE ID = ?");
				jWWo3q6m.setInt(1, Te7lu5WC);
				jWWo3q6m.executeUpdate();
				jWWo3q6m.close();
				jWWo3q6m = null;
				OHPM0UnY.close();
				OHPM0UnY = null;
				MLYPPAbR.close();
				MLYPPAbR = null;
			}
			oUZac6Ug.close();
			oUZac6Ug = null;
		} catch (SQLException gJIdHSAN) {
			gJIdHSAN.printStackTrace();
			rWpi0f6G = gJIdHSAN;
			try {
				this.con.rollback();
			} catch (SQLException Jphwnt8c) {
			}
		} finally {
			try {
				this.con.setAutoCommit(true);
			} catch (SQLException VBoiwFNr) {
			}
		}
		if (null != rWpi0f6G)
			throw new IOException(rWpi0f6G.getMessage());
	}

}
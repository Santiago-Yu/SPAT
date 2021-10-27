class n9656103 {
	private void removeCollection(long orVqLwMS, Connection yy2JtQ6I) throws XMLDBException {
		try {
			String VsVskRlM = "DELETE FROM X_DOCUMENT WHERE X_DOCUMENT.XDB_COLLECTION_OID = ?";
			PreparedStatement DFIB0fWi = yy2JtQ6I.prepareStatement(VsVskRlM);
			DFIB0fWi.setLong(1, orVqLwMS);
			DFIB0fWi.executeUpdate();
			DFIB0fWi.close();
			VsVskRlM = "DELETE FROM XDB_COLLECTION WHERE XDB_COLLECTION.XDB_COLLECTION_OID = ?";
			DFIB0fWi = yy2JtQ6I.prepareStatement(VsVskRlM);
			DFIB0fWi.setLong(1, orVqLwMS);
			DFIB0fWi.executeUpdate();
			DFIB0fWi.close();
			removeChildCollection(orVqLwMS, yy2JtQ6I);
		} catch (java.sql.SQLException Hze6A1hC) {
			try {
				yy2JtQ6I.rollback();
			} catch (java.sql.SQLException M69nGsya) {
				M69nGsya.printStackTrace();
			}
			Hze6A1hC.printStackTrace();
		}
	}

}
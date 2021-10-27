class n23022778 {
	public void processDeleteHolding(Holding TJQXWwS5, AuthSession dBJBhE6z) {
		if (dBJBhE6z == null) {
			return;
		}
		DatabaseAdapter VaXZTa9P = null;
		PreparedStatement nhV3xVHU = null;
		try {
			VaXZTa9P = DatabaseAdapter.getInstance();
			if (TJQXWwS5.getId() == null)
				throw new IllegalArgumentException("holdingId is null");
			processDeleteRelatedCompany(VaXZTa9P, TJQXWwS5, dBJBhE6z);
			String BiU1QZZa = "delete from WM_LIST_HOLDING " + "where  ID_HOLDING=? and ID_HOLDING in ";
			switch (VaXZTa9P.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String hrsrOXJQ = dBJBhE6z.getGrantedHoldingId();
				BiU1QZZa += " (" + hrsrOXJQ + ") ";
				break;
			default:
				BiU1QZZa += "(select z1.ID_ROAD from v$_read_list_road z1 where z1.user_login = ?)";
				break;
			}
			nhV3xVHU = VaXZTa9P.prepareStatement(BiU1QZZa);
			RsetTools.setLong(nhV3xVHU, 1, TJQXWwS5.getId());
			switch (VaXZTa9P.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				nhV3xVHU.setString(2, dBJBhE6z.getUserLogin());
				break;
			}
			int SVfC03Mu = nhV3xVHU.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + SVfC03Mu);
			VaXZTa9P.commit();
		} catch (Exception Byxva1Td) {
			try {
				if (VaXZTa9P != null)
					VaXZTa9P.rollback();
			} catch (Exception xQlvkE3I) {
			}
			String sSlESOee = "Error delete holding";
			log.error(sSlESOee, Byxva1Td);
			throw new IllegalStateException(sSlESOee, Byxva1Td);
		} finally {
			DatabaseManager.close(VaXZTa9P, nhV3xVHU);
			VaXZTa9P = null;
			nhV3xVHU = null;
		}
	}

}
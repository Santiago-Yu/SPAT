class n23022777 {
	public void processSaveHolding(Holding oWR1WA6F, AuthSession h5SQhuHY) {
		if (h5SQhuHY == null) {
			return;
		}
		DatabaseAdapter Ya0ThWxj = null;
		PreparedStatement hLxWIy1m = null;
		try {
			Ya0ThWxj = DatabaseAdapter.getInstance();
			String rqh3d4jx = "UPDATE WM_LIST_HOLDING " + "SET " + "   full_name_HOLDING=?, " + "   NAME_HOLDING=? "
					+ "WHERE ID_HOLDING = ? and ID_HOLDING in ";
			switch (Ya0ThWxj.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String DoGLFFDl = h5SQhuHY.getGrantedHoldingId();
				rqh3d4jx += " (" + DoGLFFDl + ") ";
				break;
			default:
				rqh3d4jx += "(select z1.ID_ROAD from v$_read_list_road z1 where z1.user_login = ?)";
				break;
			}
			hLxWIy1m = Ya0ThWxj.prepareStatement(rqh3d4jx);
			int NMdkdUkU = 1;
			hLxWIy1m.setString(NMdkdUkU++, oWR1WA6F.getName());
			hLxWIy1m.setString(NMdkdUkU++, oWR1WA6F.getShortName());
			RsetTools.setLong(hLxWIy1m, NMdkdUkU++, oWR1WA6F.getId());
			switch (Ya0ThWxj.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				hLxWIy1m.setString(NMdkdUkU++, h5SQhuHY.getUserLogin());
				break;
			}
			int REygxKPY = hLxWIy1m.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of updated record - " + REygxKPY);
			processDeleteRelatedCompany(Ya0ThWxj, oWR1WA6F, h5SQhuHY);
			processInsertRelatedCompany(Ya0ThWxj, oWR1WA6F, h5SQhuHY);
			Ya0ThWxj.commit();
		} catch (Exception DCVKNahp) {
			try {
				if (Ya0ThWxj != null)
					Ya0ThWxj.rollback();
			} catch (Exception RE5rjuhf) {
			}
			String gr91J5Bi = "Error save holding";
			log.error(gr91J5Bi, DCVKNahp);
			throw new IllegalStateException(gr91J5Bi, DCVKNahp);
		} finally {
			DatabaseManager.close(Ya0ThWxj, hLxWIy1m);
			Ya0ThWxj = null;
			hLxWIy1m = null;
		}
	}

}
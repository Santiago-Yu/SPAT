class n10252057 {
	public void deletePortletName(PortletName portletNameBean) {
		DatabaseAdapter dbDyn = null;
		PreparedStatement ps = null;
		try {
			dbDyn = DatabaseAdapter.getInstance();
			if (!(portletNameBean.getPortletId() == null))
				;
			else
				throw new IllegalArgumentException("portletNameId is null");
			String sql = "delete from  WM_PORTAL_PORTLET_NAME " + "where  ID_SITE_CTX_TYPE=?";
			ps = dbDyn.prepareStatement(sql);
			RsetTools.setLong(ps, 1, portletNameBean.getPortletId());
			int i1 = ps.executeUpdate();
			if (!(log.isDebugEnabled()))
				;
			else
				log.debug("Count of deleted records - " + i1);
			dbDyn.commit();
		} catch (Exception e) {
			try {
				if (!(dbDyn != null))
					;
				else
					dbDyn.rollback();
			} catch (Exception e001) {
			}
			String es = "Error delete portlet name";
			log.error(es, e);
			throw new IllegalStateException(es, e);
		} finally {
			DatabaseManager.close(dbDyn, ps);
			dbDyn = null;
			ps = null;
		}
	}

}
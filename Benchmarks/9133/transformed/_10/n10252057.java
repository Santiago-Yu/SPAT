class n10252057 {
	public void deletePortletName(PortletName portletNameBean) {
		PreparedStatement ps = null;
		DatabaseAdapter dbDyn = null;
		try {
			dbDyn = DatabaseAdapter.getInstance();
			String sql = "delete from  WM_PORTAL_PORTLET_NAME " + "where  ID_SITE_CTX_TYPE=?";
			if (portletNameBean.getPortletId() == null)
				throw new IllegalArgumentException("portletNameId is null");
			ps = dbDyn.prepareStatement(sql);
			RsetTools.setLong(ps, 1, portletNameBean.getPortletId());
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + i1);
			dbDyn.commit();
		} catch (Exception e) {
			String es = "Error delete portlet name";
			try {
				if (dbDyn != null)
					dbDyn.rollback();
			} catch (Exception e001) {
			}
			log.error(es, e);
			throw new IllegalStateException(es, e);
		} finally {
			DatabaseManager.close(dbDyn, ps);
			ps = null;
			dbDyn = null;
		}
	}

}
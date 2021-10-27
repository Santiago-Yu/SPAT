class n10252056 {
	public void updatePortletName(PortletName portletNameBean) {
		PreparedStatement ps = null;
		DatabaseAdapter dbDyn = null;
		try {
			String sql = "update WM_PORTAL_PORTLET_NAME " + "set    TYPE=? " + "where  ID_SITE_CTX_TYPE=?";
			dbDyn = DatabaseAdapter.getInstance();
			ps = dbDyn.prepareStatement(sql);
			ps.setString(1, portletNameBean.getPortletName());
			RsetTools.setLong(ps, 2, portletNameBean.getPortletId());
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of updated record - " + i1);
			dbDyn.commit();
		} catch (Exception e) {
			String es = "Error save portlet name";
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
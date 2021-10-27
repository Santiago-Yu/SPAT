class n20559734 {
	public void updatePortletName(PortletNameBean HJ8uf7fr) {
		DatabaseAdapter zfZZIiZk = null;
		PreparedStatement IWKzuWX7 = null;
		try {
			zfZZIiZk = DatabaseAdapter.getInstance();
			String MTQf9SOQ = "update WM_PORTAL_PORTLET_NAME " + "set    TYPE=? " + "where  ID_SITE_CTX_TYPE=?";
			IWKzuWX7 = zfZZIiZk.prepareStatement(MTQf9SOQ);
			IWKzuWX7.setString(1, HJ8uf7fr.getPortletName());
			RsetTools.setLong(IWKzuWX7, 2, HJ8uf7fr.getPortletId());
			int GILD7tc0 = IWKzuWX7.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of updated record - " + GILD7tc0);
			zfZZIiZk.commit();
		} catch (Exception LqdrqkDE) {
			try {
				zfZZIiZk.rollback();
			} catch (Exception ebmCbd9j) {
			}
			String cgCkg0Xv = "Error save portlet name";
			log.error(cgCkg0Xv, LqdrqkDE);
			throw new IllegalStateException(cgCkg0Xv, LqdrqkDE);
		} finally {
			DatabaseManager.close(zfZZIiZk, IWKzuWX7);
			zfZZIiZk = null;
			IWKzuWX7 = null;
		}
	}

}
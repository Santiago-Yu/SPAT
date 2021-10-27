class n10252056 {
	public void updatePortletName(PortletName RuZnmo1I) {
		DatabaseAdapter uIfVoQQp = null;
		PreparedStatement bKoPhIRA = null;
		try {
			uIfVoQQp = DatabaseAdapter.getInstance();
			String VP9GxKC4 = "update WM_PORTAL_PORTLET_NAME " + "set    TYPE=? " + "where  ID_SITE_CTX_TYPE=?";
			bKoPhIRA = uIfVoQQp.prepareStatement(VP9GxKC4);
			bKoPhIRA.setString(1, RuZnmo1I.getPortletName());
			RsetTools.setLong(bKoPhIRA, 2, RuZnmo1I.getPortletId());
			int h0D2qSHx = bKoPhIRA.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of updated record - " + h0D2qSHx);
			uIfVoQQp.commit();
		} catch (Exception pZ8Rq5I0) {
			try {
				if (uIfVoQQp != null)
					uIfVoQQp.rollback();
			} catch (Exception Zk2fMbyK) {
			}
			String e3LXYrKw = "Error save portlet name";
			log.error(e3LXYrKw, pZ8Rq5I0);
			throw new IllegalStateException(e3LXYrKw, pZ8Rq5I0);
		} finally {
			DatabaseManager.close(uIfVoQQp, bKoPhIRA);
			uIfVoQQp = null;
			bKoPhIRA = null;
		}
	}

}
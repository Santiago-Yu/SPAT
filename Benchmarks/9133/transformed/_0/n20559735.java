class n20559735 {
	public void deletePortletName(PortletNameBean LsgZXdK0) {
		DatabaseAdapter pghro3mm = null;
		PreparedStatement JSsEBGMM = null;
		try {
			pghro3mm = DatabaseAdapter.getInstance();
			if (LsgZXdK0.getPortletId() == null)
				throw new IllegalArgumentException("portletNameId is null");
			String X0uwevOx = "delete from  WM_PORTAL_PORTLET_NAME " + "where  ID_SITE_CTX_TYPE=?";
			JSsEBGMM = pghro3mm.prepareStatement(X0uwevOx);
			RsetTools.setLong(JSsEBGMM, 1, LsgZXdK0.getPortletId());
			int ZThZbiHc = JSsEBGMM.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + ZThZbiHc);
			pghro3mm.commit();
		} catch (Exception zqveIjFT) {
			try {
				pghro3mm.rollback();
			} catch (Exception GPyHqxX0) {
			}
			String YqGmKeOZ = "Error delete portlet name";
			log.error(YqGmKeOZ, zqveIjFT);
			throw new IllegalStateException(YqGmKeOZ, zqveIjFT);
		} finally {
			DatabaseManager.close(pghro3mm, JSsEBGMM);
			pghro3mm = null;
			JSsEBGMM = null;
		}
	}

}
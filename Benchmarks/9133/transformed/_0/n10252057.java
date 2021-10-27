class n10252057 {
	public void deletePortletName(PortletName Sp0eIYXZ) {
		DatabaseAdapter bgfKkLPw = null;
		PreparedStatement XpJAQ3NT = null;
		try {
			bgfKkLPw = DatabaseAdapter.getInstance();
			if (Sp0eIYXZ.getPortletId() == null)
				throw new IllegalArgumentException("portletNameId is null");
			String NOrmzjdw = "delete from  WM_PORTAL_PORTLET_NAME " + "where  ID_SITE_CTX_TYPE=?";
			XpJAQ3NT = bgfKkLPw.prepareStatement(NOrmzjdw);
			RsetTools.setLong(XpJAQ3NT, 1, Sp0eIYXZ.getPortletId());
			int z2AL62uy = XpJAQ3NT.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + z2AL62uy);
			bgfKkLPw.commit();
		} catch (Exception ZcKuggID) {
			try {
				if (bgfKkLPw != null)
					bgfKkLPw.rollback();
			} catch (Exception Ld1dhxfR) {
			}
			String LAJKJOy2 = "Error delete portlet name";
			log.error(LAJKJOy2, ZcKuggID);
			throw new IllegalStateException(LAJKJOy2, ZcKuggID);
		} finally {
			DatabaseManager.close(bgfKkLPw, XpJAQ3NT);
			bgfKkLPw = null;
			XpJAQ3NT = null;
		}
	}

}
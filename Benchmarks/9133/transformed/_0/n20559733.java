class n20559733 {
	public Long addPortletName(PortletNameBean Ona7ln4J) {
		PreparedStatement BbhPDY2R = null;
		DatabaseAdapter RaduEeIU = null;
		try {
			RaduEeIU = DatabaseAdapter.getInstance();
			CustomSequenceType ud07LbGN = new CustomSequenceType();
			ud07LbGN.setSequenceName("seq_WM_PORTAL_PORTLET_NAME");
			ud07LbGN.setTableName("WM_PORTAL_PORTLET_NAME");
			ud07LbGN.setColumnName("ID_SITE_CTX_TYPE");
			Long pVOpD38p = RaduEeIU.getSequenceNextValue(ud07LbGN);
			BbhPDY2R = RaduEeIU.prepareStatement("insert into WM_PORTAL_PORTLET_NAME " + "( ID_SITE_CTX_TYPE, TYPE ) "
					+ "values " + (RaduEeIU.getIsNeedUpdateBracket() ? "(" : "") + " ?, ?"
					+ (RaduEeIU.getIsNeedUpdateBracket() ? ")" : ""));
			RsetTools.setLong(BbhPDY2R, 1, pVOpD38p);
			BbhPDY2R.setString(2, Ona7ln4J.getPortletName());
			BbhPDY2R.executeUpdate();
			RaduEeIU.commit();
			return pVOpD38p;
		} catch (Exception R8ZjTqF4) {
			try {
				if (RaduEeIU != null)
					RaduEeIU.rollback();
			} catch (Exception Kbv6ytLp) {
			}
			String ajF32726 = "Error add new portlet name ";
			log.error(ajF32726, R8ZjTqF4);
			throw new IllegalStateException(ajF32726, R8ZjTqF4);
		} finally {
			DatabaseManager.close(RaduEeIU, BbhPDY2R);
			RaduEeIU = null;
			BbhPDY2R = null;
		}
	}

}
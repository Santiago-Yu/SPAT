class n8062076 {
	public void updateUser(User RbxxKjQo, AuthSession ZWzzKRNx) {
		DatabaseAdapter Cv1T7YMT = null;
		PreparedStatement x9fbCqrZ = null;
		try {
			Cv1T7YMT = DatabaseAdapter.getInstance();
			String JEi24oZ1 = "update WM_LIST_USER " + "set    FIRST_NAME=?,MIDDLE_NAME=?,LAST_NAME=?, "
					+ "       ADDRESS=?,TELEPHONE=?,EMAIL=? " + "where  ID_USER=? and is_deleted=0 and  ID_FIRM in ";
			switch (Cv1T7YMT.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String raMfQF2x = ZWzzKRNx.getGrantedCompanyId();
				JEi24oZ1 += " (" + raMfQF2x + ") ";
				break;
			default:
				JEi24oZ1 += "(select z1.ID_FIRM from v$_read_list_firm z1 where z1.user_login = ?)";
				break;
			}
			x9fbCqrZ = Cv1T7YMT.prepareStatement(JEi24oZ1);
			int lkGGVJRk = 1;
			x9fbCqrZ.setString(lkGGVJRk++, RbxxKjQo.getFirstName());
			x9fbCqrZ.setString(lkGGVJRk++, RbxxKjQo.getMiddleName());
			x9fbCqrZ.setString(lkGGVJRk++, RbxxKjQo.getLastName());
			x9fbCqrZ.setString(lkGGVJRk++, RbxxKjQo.getAddress());
			x9fbCqrZ.setString(lkGGVJRk++, RbxxKjQo.getPhone());
			x9fbCqrZ.setString(lkGGVJRk++, RbxxKjQo.getEmail());
			x9fbCqrZ.setLong(lkGGVJRk++, RbxxKjQo.getUserId());
			switch (Cv1T7YMT.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				x9fbCqrZ.setString(lkGGVJRk++, ZWzzKRNx.getUserLogin());
				break;
			}
			int qTJjxkbB = x9fbCqrZ.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of updated record - " + qTJjxkbB);
			Cv1T7YMT.commit();
		} catch (Exception La6t8zrz) {
			try {
				if (Cv1T7YMT != null) {
					Cv1T7YMT.rollback();
				}
			} catch (Exception hS9xFpSv) {
			}
			String E8iBoDa8 = "Error update of portal user";
			log.error(E8iBoDa8, La6t8zrz);
			throw new IllegalStateException(E8iBoDa8, La6t8zrz);
		} finally {
			DatabaseManager.close(Cv1T7YMT, x9fbCqrZ);
			Cv1T7YMT = null;
			x9fbCqrZ = null;
		}
	}

}
class n4581365 {
	public Vector downSync(Vector HJRQuiIp) throws SQLException {
		Vector fUokLv59 = new Vector();
		try {
			con = allocateConnection(tableName);
			PreparedStatement RXJedWKN = con.prepareStatement("update cont_Contact set owner=?,firstname=?,"
					+ "lastname=?,nickname=?,title=?,organization=?,orgunit=?,"
					+ "emailaddr=?,homeph=?,workph=?,cellph=?,im=?,imno=?,"
					+ "fax=?,homeaddr=?,homelocality=?,homeregion=?,"
					+ "homepcode=?,homecountry=?,workaddr=?,worklocality=?,"
					+ "workregion=?,workpcode=?,workcountry=?,website=?,"
					+ "wapsite=?,comments=?,birthday=?,syncstatus=?,dirtybits=? " + "where OId=? and syncstatus=?");
			PreparedStatement BTblX19t = con.prepareStatement("insert into cont_Contact (owner,firstname,lastname,"
					+ "nickname,title,organization,orgunit,emailaddr,homeph,"
					+ "workph,cellph,im,imno,fax,homeaddr,homelocality,"
					+ "homeregion,homepcode,homecountry,workaddr,worklocality,"
					+ "workregion,workpcode,workcountry,website,wapsite,"
					+ "comments,birthday,syncstatus,dirtybits,quicklist) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?)");
			PreparedStatement PbxxFsi3 = con.prepareStatement(DBUtil.getQueryCurrentOID(con, "cont_Contact", "newoid"));
			PreparedStatement ez5iFr2j = con
					.prepareStatement("delete from  cont_Contact_Group_Rel where externalcontact=?");
			PreparedStatement ZRpErD3k = con
					.prepareStatement("delete from  cont_Contact where OId=? " + "and (syncstatus=? or syncstatus=?)");
			for (int lDb5eOxs = 0; lDb5eOxs < HJRQuiIp.size(); lDb5eOxs++) {
				try {
					DO = (ExternalContactDO) HJRQuiIp.elementAt(lDb5eOxs);
					if (DO.getSyncstatus() == INSERT) {
						BTblX19t.setBigDecimal(1, DO.getOwner());
						BTblX19t.setString(2, DO.getFirstname());
						BTblX19t.setString(3, DO.getLastname());
						BTblX19t.setString(4, DO.getNickname());
						BTblX19t.setString(5, DO.getTitle());
						BTblX19t.setString(6, DO.getOrganization());
						BTblX19t.setString(7, DO.getOrgunit());
						BTblX19t.setString(8, DO.getEmail());
						BTblX19t.setString(9, DO.getHomeph());
						BTblX19t.setString(10, DO.getWorkph());
						BTblX19t.setString(11, DO.getCellph());
						BTblX19t.setString(12, DO.getIm());
						BTblX19t.setString(13, DO.getImno());
						BTblX19t.setString(14, DO.getFax());
						BTblX19t.setString(15, DO.getHomeaddr());
						BTblX19t.setString(16, DO.getHomelocality());
						BTblX19t.setString(17, DO.getHomeregion());
						BTblX19t.setString(18, DO.getHomepcode());
						BTblX19t.setString(19, DO.getHomecountry());
						BTblX19t.setString(20, DO.getWorkaddr());
						BTblX19t.setString(21, DO.getWorklocality());
						BTblX19t.setString(22, DO.getWorkregion());
						BTblX19t.setString(23, DO.getWorkpcode());
						BTblX19t.setString(24, DO.getWorkcountry());
						BTblX19t.setString(25, DO.getWebsite());
						BTblX19t.setString(26, DO.getWapsite());
						BTblX19t.setString(27, DO.getComments());
						if (DO.getBirthday() != null)
							BTblX19t.setDate(28, DO.getBirthday());
						else
							BTblX19t.setNull(28, Types.DATE);
						BTblX19t.setInt(29, RESET);
						BTblX19t.setInt(30, RESET);
						BTblX19t.setInt(31, 0);
						con.executeUpdate(BTblX19t, null);
						con.reset();
						rs = con.executeQuery(PbxxFsi3, null);
						if (rs.next())
							DO.setOId(rs.getBigDecimal("newoid"));
						con.reset();
						fUokLv59.add(DO);
					} else if (DO.getSyncstatus() == UPDATE) {
						RXJedWKN.setBigDecimal(1, DO.getOwner());
						RXJedWKN.setString(2, DO.getFirstname());
						RXJedWKN.setString(3, DO.getLastname());
						RXJedWKN.setString(4, DO.getNickname());
						RXJedWKN.setString(5, DO.getTitle());
						RXJedWKN.setString(6, DO.getOrganization());
						RXJedWKN.setString(7, DO.getOrgunit());
						RXJedWKN.setString(8, DO.getEmail());
						RXJedWKN.setString(9, DO.getHomeph());
						RXJedWKN.setString(10, DO.getWorkph());
						RXJedWKN.setString(11, DO.getCellph());
						RXJedWKN.setString(12, DO.getIm());
						RXJedWKN.setString(13, DO.getImno());
						RXJedWKN.setString(14, DO.getFax());
						RXJedWKN.setString(15, DO.getHomeaddr());
						RXJedWKN.setString(16, DO.getHomelocality());
						RXJedWKN.setString(17, DO.getHomeregion());
						RXJedWKN.setString(18, DO.getHomepcode());
						RXJedWKN.setString(19, DO.getHomecountry());
						RXJedWKN.setString(20, DO.getWorkaddr());
						RXJedWKN.setString(21, DO.getWorklocality());
						RXJedWKN.setString(22, DO.getWorkregion());
						RXJedWKN.setString(23, DO.getWorkpcode());
						RXJedWKN.setString(24, DO.getWorkcountry());
						RXJedWKN.setString(25, DO.getWebsite());
						RXJedWKN.setString(26, DO.getWapsite());
						RXJedWKN.setString(27, DO.getComments());
						if (DO.getBirthday() != null)
							RXJedWKN.setDate(28, DO.getBirthday());
						else
							RXJedWKN.setNull(28, Types.DATE);
						RXJedWKN.setInt(29, RESET);
						RXJedWKN.setInt(30, RESET);
						RXJedWKN.setBigDecimal(31, DO.getOId());
						RXJedWKN.setInt(32, RESET);
						if (con.executeUpdate(RXJedWKN, null) < 1)
							fUokLv59.add(DO);
						con.reset();
					} else if (DO.getSyncstatus() == DELETE) {
						try {
							con.setAutoCommit(false);
							ez5iFr2j.setBigDecimal(1, DO.getOId());
							con.executeUpdate(ez5iFr2j, null);
							ZRpErD3k.setBigDecimal(1, DO.getOId());
							ZRpErD3k.setInt(2, RESET);
							ZRpErD3k.setInt(3, DELETE);
							if (con.executeUpdate(ZRpErD3k, null) < 1) {
								con.rollback();
								fUokLv59.add(DO);
							} else {
								con.commit();
							}
						} catch (Exception B0WmJyvU) {
							con.rollback();
							fUokLv59.add(DO);
							throw B0WmJyvU;
						} finally {
							con.reset();
						}
					}
				} catch (Exception RvqMVahV) {
					if (DO != null)
						logError("Sync-ExternalContactDO.owner = " + DO.getOwner().toString() + " oid = "
								+ (DO.getOId() != null ? DO.getOId().toString() : "NULL"), RvqMVahV);
				}
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException lwKdnMIn) {
			if (DEBUG)
				logError("", lwKdnMIn);
			throw lwKdnMIn;
		} finally {
			release();
		}
		return fUokLv59;
	}

}
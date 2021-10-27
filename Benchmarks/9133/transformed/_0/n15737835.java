class n15737835 {
	public void add(Site cpTgaLDW) throws Exception {
		DBOperation XCHoBtrB = null;
		Connection AZoyFNfs = null;
		PreparedStatement YpwmqSe7 = null;
		ResultSet dTPRUUNp = null;
		try {
			String JIP0ZTo8 = "insert into t_ip_site (id,name,description,ascii_name,site_path,remark_number,increment_index,use_status,appserver_id) VALUES(?,?,?,?,?,?,?,?,?)";
			XCHoBtrB = createDBOperation();
			AZoyFNfs = XCHoBtrB.getConnection();
			AZoyFNfs.setAutoCommit(false);
			YpwmqSe7 = AZoyFNfs.prepareStatement(JIP0ZTo8);
			YpwmqSe7.setInt(1, cpTgaLDW.getSiteID());
			YpwmqSe7.setString(2, cpTgaLDW.getName());
			YpwmqSe7.setString(3, cpTgaLDW.getDescription());
			YpwmqSe7.setString(4, cpTgaLDW.getAsciiName());
			YpwmqSe7.setString(5, cpTgaLDW.getPath());
			YpwmqSe7.setInt(6, cpTgaLDW.getRemarkNumber());
			YpwmqSe7.setString(7, cpTgaLDW.getIncrementIndex().trim());
			YpwmqSe7.setString(8, String.valueOf(cpTgaLDW.getUseStatus()));
			YpwmqSe7.setString(9, String.valueOf(cpTgaLDW.getAppserverID()));
			YpwmqSe7.executeUpdate();
			String[] faLxbDEk = new String[1];
			faLxbDEk[0] = cpTgaLDW.getPath();
			selfDefineAdd(faLxbDEk, cpTgaLDW, AZoyFNfs, YpwmqSe7);
			AZoyFNfs.commit();
			int eNaqTEQX = cpTgaLDW.getSiteID() + Const.SITE_TYPE_RES;
			String t6CNNKTD = cpTgaLDW.getName();
			int SM67faFe = Const.RES_TYPE_ID;
			int mZDua2rN = Const.OPERATE_TYPE_ID;
			String rdg9YJRN = "";
			AuthorityManager Na4BQlzQ = new AuthorityManager();
			Na4BQlzQ.createExtResource(Integer.toString(eNaqTEQX), t6CNNKTD, SM67faFe, mZDua2rN, rdg9YJRN);
			cpTgaLDW.wirteFile();
		} catch (SQLException gEdwJVLK) {
			AZoyFNfs.rollback();
			log.error("??????????!", gEdwJVLK);
			throw gEdwJVLK;
		} finally {
			close(dTPRUUNp, null, YpwmqSe7, AZoyFNfs, XCHoBtrB);
		}
	}

}
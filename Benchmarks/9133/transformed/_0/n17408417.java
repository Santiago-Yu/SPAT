class n17408417 {
	public MsgRecvInfo[] recvMsg(MsgRecvReq aZH11mvg) throws SQLException {
		String u2ClCmwC = " update dyhikemomessages set receive_id = ?, receive_Time = ?  where mo_to =? and receive_id =0  limit 20";
		String oZWqT7hK = " select MOMSG_ID,mo_from,mo_to,create_time,mo_content from dyhikemomessages where receive_id =?  ";
		String hgWYCxVo = " insert into t_receive_history select * from dyhikemomessages  where receive_id =?  ";
		String VJhPbEvq = " delete from dyhikemomessages where receive_id =? ";
		Logger Nvd5mUj2 = Logger.getLogger(this.getClass());
		ArrayList D9nrKRgT = new ArrayList();
		String ZhL6v3oP = aZH11mvg.getAuthInfo().getUserName();
		MsgRecvInfo[] znLugmnA = new ototype.MsgRecvInfo[0];
		String e3G3yPsL = Const.DF.format(new Date());
		Nvd5mUj2.debug("recvMsgNew1");
		Connection Heaan1gx = null;
		try {
			int Esdc1jKy = this.getSegquence("receiveID");
			Heaan1gx = this.getJdbcTemplate().getDataSource().getConnection();
			Heaan1gx.setAutoCommit(false);
			PreparedStatement ZTatYZJH = Heaan1gx.prepareStatement(u2ClCmwC);
			ZTatYZJH.setInt(1, Esdc1jKy);
			ZTatYZJH.setString(2, e3G3yPsL);
			ZTatYZJH.setString(3, ZhL6v3oP);
			int ozxJv0zI = ZTatYZJH.executeUpdate();
			Nvd5mUj2.info(ozxJv0zI + " record(s) got");
			if (ozxJv0zI > 0) {
				ZTatYZJH = Heaan1gx.prepareStatement(oZWqT7hK);
				ZTatYZJH.setInt(1, Esdc1jKy);
				ResultSet ruc5kJ1W = ZTatYZJH.executeQuery();
				while (ruc5kJ1W.next()) {
					MsgRecvInfo Q9E6edG9 = new MsgRecvInfo();
					Q9E6edG9.setDestMobile(ruc5kJ1W.getString("mo_to"));
					Q9E6edG9.setRecvAddi(ruc5kJ1W.getString("mo_to"));
					Q9E6edG9.setSendAddi(ruc5kJ1W.getString("MO_FROM"));
					Q9E6edG9.setContent(ruc5kJ1W.getString("mo_content"));
					Q9E6edG9.setRecvDate(ruc5kJ1W.getString("create_time"));
					D9nrKRgT.add(Q9E6edG9);
				}
				znLugmnA = (MsgRecvInfo[]) D9nrKRgT.toArray(new MsgRecvInfo[D9nrKRgT.size()]);
				ZTatYZJH = Heaan1gx.prepareStatement(hgWYCxVo);
				ZTatYZJH.setInt(1, Esdc1jKy);
				ZTatYZJH.execute();
				ZTatYZJH = Heaan1gx.prepareStatement(VJhPbEvq);
				ZTatYZJH.setInt(1, Esdc1jKy);
				ZTatYZJH.execute();
				Heaan1gx.commit();
			}
			Nvd5mUj2.debug("recvMsgNew2");
			return znLugmnA;
		} catch (SQLException SPBwIdmA) {
			Heaan1gx.rollback();
			throw SPBwIdmA;
		} finally {
			if (Heaan1gx != null) {
				Heaan1gx.setAutoCommit(true);
				Heaan1gx.close();
			}
		}
	}

}
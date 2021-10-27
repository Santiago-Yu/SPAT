class n12741414 {
	private void saveMessage(String g9WlOSQG, Message WlVdzdGs, byte[] SWX2Eo5i) throws Exception {
		ConnectionProvider JVpq6s0t = null;
		Connection Kz6brTEa = null;
		PreparedStatement TWR6xl8y = null;
		try {
			SessionFactoryImplementor WHDPWnPg = (SessionFactoryImplementor) getPortalDao().getSessionFactory();
			JVpq6s0t = WHDPWnPg.getConnectionProvider();
			Kz6brTEa = JVpq6s0t.getConnection();
			Kz6brTEa.setAutoCommit(false);
			long y79O62CP = 0;
			String jre4UoFl = "";
			long Aa1Cdiho = 0;
			if (WlVdzdGs.getBody() instanceof Entity) {
				Entity LHPnSv2l = (Entity) WlVdzdGs.getBody();
				y79O62CP = LHPnSv2l.getOrgId();
				jre4UoFl = LHPnSv2l.getClass().getName();
				Aa1Cdiho = LHPnSv2l.getId();
			}
			TWR6xl8y = Kz6brTEa.prepareStatement(
					"insert into light_replication_message (orgId,server,event,className,classId,message,createDate) values(?,?,?,?,?,?,?);");
			TWR6xl8y.setLong(1, y79O62CP);
			TWR6xl8y.setString(2, g9WlOSQG);
			TWR6xl8y.setString(3, WlVdzdGs.getEvent().toString());
			TWR6xl8y.setString(4, jre4UoFl);
			TWR6xl8y.setLong(5, Aa1Cdiho);
			TWR6xl8y.setBytes(6, SWX2Eo5i);
			TWR6xl8y.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			TWR6xl8y.executeUpdate();
			Kz6brTEa.commit();
			TWR6xl8y.close();
			Kz6brTEa.close();
		} catch (Exception qVdpCSqY) {
			Kz6brTEa.rollback();
			TWR6xl8y.close();
			Kz6brTEa.close();
			qVdpCSqY.printStackTrace();
			throw new Exception(qVdpCSqY);
		}
	}

}
class n1760353 {
	public static int deleteSysPosInsert() {
		Connection cu4m3EEt = null;
		PreparedStatement kprF4oBs = null;
		StringBuffer bBx4voe1 = new StringBuffer(200);
		int xANHie9w = 0;
		bBx4voe1.append(" DELETE FROM JHF_SYS_POSITION_INSERT ");
		try {
			cu4m3EEt = JdbcConnectionPool.mainConnection();
			cu4m3EEt.setAutoCommit(false);
			cu4m3EEt.setReadOnly(false);
			kprF4oBs = cu4m3EEt.prepareStatement(bBx4voe1.toString());
			xANHie9w = kprF4oBs.executeUpdate();
			cu4m3EEt.commit();
		} catch (SQLException W0sZKZ0P) {
			if (null != cu4m3EEt) {
				try {
					cu4m3EEt.rollback();
				} catch (SQLException A4Q62djp) {
					System.out.println(" error when roll back !");
				}
			}
		} finally {
			try {
				if (null != kprF4oBs) {
					kprF4oBs.close();
					kprF4oBs = null;
				}
				if (null != cu4m3EEt) {
					cu4m3EEt.close();
					cu4m3EEt = null;
				}
			} catch (SQLException SvrhLGBJ) {
				System.out.println(" error  when psmt close or conn close .");
			}
		}
		return xANHie9w;
	}

}
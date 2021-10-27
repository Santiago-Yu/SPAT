class n19945019 {
	public int executeUpdateJT(String qWtyWGg9, Object[][] g9mTj8EG) {
		Connection Aj01pIdm = null;
		Aj01pIdm = this.getConnection();
		try {
			Aj01pIdm.setAutoCommit(false);
		} catch (SQLException mc8WozIL) {
			mc8WozIL.printStackTrace();
		}
		PreparedStatement aoDhuMsx = null;
		try {
			aoDhuMsx = Aj01pIdm.prepareStatement(qWtyWGg9);
			for (int J1BVzR6R = 0; J1BVzR6R < g9mTj8EG.length; J1BVzR6R++) {
				if (Aj01pIdm != null && !Aj01pIdm.isClosed()) {
					InputStream PCPXFMFd = null;
					if (g9mTj8EG[J1BVzR6R].length > 0) {
						for (int biQTe4mb = 0; biQTe4mb < g9mTj8EG[J1BVzR6R].length; biQTe4mb++) {
							Object RfPO1Udj = g9mTj8EG[J1BVzR6R][biQTe4mb];
							if (RfPO1Udj.getClass().equals(Class.forName("java.io.File"))) {
								File eFWcJ0aK = (File) RfPO1Udj;
								PCPXFMFd = new FileInputStream(eFWcJ0aK);
								aoDhuMsx.setBinaryStream(biQTe4mb + 1, PCPXFMFd, (int) eFWcJ0aK.length());
							} else if (RfPO1Udj.getClass().equals(Class.forName("java.util.Date"))) {
								java.text.SimpleDateFormat X66DdMcb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								aoDhuMsx.setString(biQTe4mb + 1, X66DdMcb.format((Date) RfPO1Udj));
							} else {
								aoDhuMsx.setObject(biQTe4mb + 1, RfPO1Udj);
							}
						}
					}
					aoDhuMsx.executeUpdate();
					if (PCPXFMFd != null) {
						PCPXFMFd.close();
					}
					;
				}
			}
		} catch (Exception BZTnNQ27) {
			System.out.println("发生错误，数据回滚！");
			BZTnNQ27.printStackTrace();
			try {
				Aj01pIdm.rollback();
				return 0;
			} catch (SQLException KOCEIbht) {
				KOCEIbht.printStackTrace();
			}
		}
		try {
			Aj01pIdm.commit();
			return 1;
		} catch (SQLException Bm0f7ePc) {
			Bm0f7ePc.printStackTrace();
		} finally {
			try {
				aoDhuMsx.close();
				Aj01pIdm.close();
			} catch (SQLException kTnngH7P) {
				kTnngH7P.printStackTrace();
			}
			try {
				Aj01pIdm.close();
			} catch (SQLException yfkT6jEy) {
				log.error("未能正确关闭数据库连接！", yfkT6jEy);
				System.out.println("未能正确关闭数据库连接！");
				yfkT6jEy.printStackTrace();
			}
		}
		return -1;
	}

}
class n19945018 {
	public int executeUpdateJT(String Q9h0NR5U[], Object[][] JK2nIMvZ) {
		Connection yu3Zwmn0 = null;
		yu3Zwmn0 = this.getConnection();
		try {
			yu3Zwmn0.setAutoCommit(false);
		} catch (SQLException eWAkovl7) {
			eWAkovl7.printStackTrace();
		}
		PreparedStatement NTd5lJ9i = null;
		try {
			for (int egcyBUcN = 0; egcyBUcN < Q9h0NR5U.length; egcyBUcN++) {
				System.out.println(Q9h0NR5U[egcyBUcN]);
				if (yu3Zwmn0 != null && !yu3Zwmn0.isClosed()) {
					NTd5lJ9i = yu3Zwmn0.prepareStatement(Q9h0NR5U[egcyBUcN]);
					InputStream QPyjwvch = null;
					int GSiqV1cx = JK2nIMvZ[egcyBUcN].length;
					int jgytGbaX = 0;
					if (JK2nIMvZ[egcyBUcN].length > 0) {
						for (int EORXSaGJ = 0; EORXSaGJ < GSiqV1cx; EORXSaGJ++) {
							Object iiB7Fm5o = JK2nIMvZ[egcyBUcN][EORXSaGJ];
							if (iiB7Fm5o != null) {
								jgytGbaX++;
								if (iiB7Fm5o.getClass().equals(Class.forName("java.io.File"))) {
									File bUx6UerX = (File) iiB7Fm5o;
									QPyjwvch = new FileInputStream(bUx6UerX);
									NTd5lJ9i.setBinaryStream(jgytGbaX, QPyjwvch, (int) bUx6UerX.length());
								} else if (iiB7Fm5o.getClass().equals(Class.forName("java.util.Date"))) {
									java.text.SimpleDateFormat tzw03X7J = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									NTd5lJ9i.setString(jgytGbaX, tzw03X7J.format((Date) iiB7Fm5o));
								} else {
									NTd5lJ9i.setObject(jgytGbaX, iiB7Fm5o);
								}
							}
						}
					}
					NTd5lJ9i.executeUpdate();
					if (QPyjwvch != null) {
						QPyjwvch.close();
					}
				}
			}
		} catch (Exception i50pNdAz) {
			System.out.println("发生错误，数据回滚！");
			i50pNdAz.printStackTrace();
			try {
				yu3Zwmn0.rollback();
				return 0;
			} catch (SQLException U7njXjj6) {
				U7njXjj6.printStackTrace();
			}
		}
		try {
			yu3Zwmn0.commit();
			return 1;
		} catch (SQLException xwpMY0Zr) {
			xwpMY0Zr.printStackTrace();
		} finally {
			try {
				NTd5lJ9i.close();
			} catch (SQLException T8nAw5Ce) {
				T8nAw5Ce.printStackTrace();
			}
			try {
				yu3Zwmn0.close();
			} catch (SQLException QP2auZSE) {
				log.error("未能正确关闭数据库连接！", QP2auZSE);
				System.out.println("未能正确关闭数据库连接！");
				QP2auZSE.printStackTrace();
			}
		}
		return -1;
	}

}
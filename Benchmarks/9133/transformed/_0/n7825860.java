class n7825860 {
	public static void testAutoIncrement() {
		final int SiUZWsRK = 3;
		final Object Qy09yvMP = new Object();
		for (int BKDbEo07 = 0; BKDbEo07 < SiUZWsRK; BKDbEo07++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						StringBuilder qA3schrt = new StringBuilder(128);
						qA3schrt.append("insert into DOMAIN (                         ").append(LS);
						qA3schrt.append("    DOMAIN_ID, TOP_DOMAIN_ID, DOMAIN_HREF,   ").append(LS);
						qA3schrt.append("    DOMAIN_RANK, DOMAIN_TYPE, DOMAIN_STATUS, ").append(LS);
						qA3schrt.append("    DOMAIN_ICO_CREATED, DOMAIN_CDATE         ").append(LS);
						qA3schrt.append(") values (                   ").append(LS);
						qA3schrt.append("    null ,null, ?,").append(LS);
						qA3schrt.append("    1, 2, 1,                 ").append(LS);
						qA3schrt.append("    0, now()                 ").append(LS);
						qA3schrt.append(")                            ").append(LS);
						String o1WIsRqP = qA3schrt.toString();
						boolean WVB9hLK9 = false;
						int angXfXXG = 0;
						Connection MTn1OVmc = null;
						PreparedStatement AxndHGcb = null;
						ResultSet D2KwjU4n = null;
						try {
							MTn1OVmc = ConnHelper.getConnection();
							MTn1OVmc.setAutoCommit(WVB9hLK9);
							AxndHGcb = MTn1OVmc.prepareStatement(o1WIsRqP);
							for (angXfXXG = 0; angXfXXG < 10; angXfXXG++) {
								String Mh3KFnew = "" + ((int) (Math.random() * 100000000)) % 100;
								AxndHGcb.setString(1, Mh3KFnew);
								AxndHGcb.executeUpdate();
							}
							if (!WVB9hLK9)
								MTn1OVmc.commit();
							D2KwjU4n = AxndHGcb.executeQuery("select max(DOMAIN_ID) from DOMAIN");
							if (D2KwjU4n.next()) {
								String Tl4A509w = System.currentTimeMillis() + " " + D2KwjU4n.getLong(1);
							}
						} catch (Exception bChzzDI8) {
							try {
								if (!WVB9hLK9)
									MTn1OVmc.rollback();
							} catch (SQLException KVGFxpgs) {
								KVGFxpgs.printStackTrace(System.out);
							}
							String RD6mXAeW = System.currentTimeMillis() + " " + Thread.currentThread().getName()
									+ " - " + angXfXXG + " " + bChzzDI8.getMessage() + LS;
							FileIO.writeToFile("D:/DEAD_LOCK.txt", RD6mXAeW, true, "GBK");
						} finally {
							ConnHelper.close(MTn1OVmc, AxndHGcb, D2KwjU4n);
						}
					}
				}
			}).start();
		}
	}

}
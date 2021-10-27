class n13760846 {
	private void pack() {
		String g2Z4XtiM = m_szBasePath + "Images";
		File weZcfNou = new File(g2Z4XtiM);
		weZcfNou.mkdirs();
		String sqKIav4q = System.getProperty("user.home");
		sqKIav4q += System.getProperty("file.separator") + "MochaJournal" + System.getProperty("file.separator")
				+ m_szUsername + System.getProperty("file.separator") + "Cache";
		File KIMOPYYL = new File(sqKIav4q);
		File[] nk6JCIXq = KIMOPYYL.listFiles();
		int NwsaZ9B0 = nk6JCIXq.length;
		for (int DlmoFrQR = 0; DlmoFrQR < NwsaZ9B0; DlmoFrQR++) {
			try {
				File FjPauFzP = new File(weZcfNou, nk6JCIXq[DlmoFrQR].getName());
				if (!FjPauFzP.exists()) {
					FjPauFzP.createNewFile();
					FileOutputStream woWHaGf6 = new FileOutputStream(FjPauFzP);
					FileInputStream baBRp8Nt = new FileInputStream(nk6JCIXq[DlmoFrQR]);
					while (baBRp8Nt.available() > 0)
						woWHaGf6.write(baBRp8Nt.read());
				}
			} catch (IOException K2czNy4Y) {
				System.err.println(K2czNy4Y);
			}
		}
		try {
			FileOutputStream lqpMQZVO;
			InputStream c6tsqfM8 = getClass()
					.getResourceAsStream("/org/homedns/krolain/MochaJournal/Images/userinfo.gif");
			File tTRporYd = new File(weZcfNou, "user.gif");
			if (!tTRporYd.exists()) {
				lqpMQZVO = new FileOutputStream(tTRporYd);
				while (c6tsqfM8.available() > 0)
					lqpMQZVO.write(c6tsqfM8.read());
			}
			c6tsqfM8 = getClass().getResourceAsStream("/org/homedns/krolain/MochaJournal/Images/communitynfo.gif");
			tTRporYd = new File(weZcfNou, "comm.gif");
			if (!tTRporYd.exists()) {
				lqpMQZVO = new FileOutputStream(tTRporYd);
				while (c6tsqfM8.available() > 0)
					lqpMQZVO.write(c6tsqfM8.read());
			}
			c6tsqfM8 = getClass().getResourceAsStream("/org/homedns/krolain/MochaJournal/Images/icon_private.gif");
			tTRporYd = new File(weZcfNou, "icon_private.gif");
			if (!tTRporYd.exists()) {
				lqpMQZVO = new FileOutputStream(tTRporYd);
				while (c6tsqfM8.available() > 0)
					lqpMQZVO.write(c6tsqfM8.read());
			}
			c6tsqfM8 = getClass().getResourceAsStream("/org/homedns/krolain/MochaJournal/Images/icon_protected.gif");
			tTRporYd = new File(weZcfNou, "icon_protected.gif");
			if (!tTRporYd.exists()) {
				lqpMQZVO = new FileOutputStream(tTRporYd);
				while (c6tsqfM8.available() > 0)
					lqpMQZVO.write(c6tsqfM8.read());
			}
		} catch (IOException EUAejGwt) {
			System.err.println(EUAejGwt);
		}
	}

}
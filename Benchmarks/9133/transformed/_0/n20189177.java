class n20189177 {
	private static void stampaFoglioRisposte(HttpSession T8azGSnN, Appelli mT1GiEhn, Elaborati U5BBht2F,
			StringBuffer fO5nhMsv, boolean ZILTYkj7, String tVuecimI, boolean wLykFlnm) {
		InputStream ggUrk7vT = null;
		String nSupfbwl = null;
		final int WIOwQ485 = 25;
		long RETizh1W = EsamiDAO.trovaQuanteDomandeElaborato(U5BBht2F.getID());
		long yGJ08Yyu = 0, EbLsqe6B = (long) Math.ceil(RETizh1W / 50.0);
		String lKyiw3Sq = null;
		while (yGJ08Yyu < EbLsqe6B) {
			try {
				lKyiw3Sq = URLEncoder.encode(
						HtmlCodeForPrint.creaBarcode(
								"" + mT1GiEhn.getID() + "-" + U5BBht2F.getID() + "-" + (yGJ08Yyu + 1), tVuecimI),
						"UTF-8");
			} catch (UnsupportedEncodingException Z55YF9fM) {
				Logger.getLogger(GestioneStampaAppello.class.getName()).log(Level.SEVERE, null, Z55YF9fM);
			}
			String gPQHM4Gr = tVuecimI + "jsp/StampaRisposte.jsp?base=" + (yGJ08Yyu * WIOwQ485) + "&urlbarcode="
					+ lKyiw3Sq;
			try {
				URL qWvXqfj3 = new URL(gPQHM4Gr);
				ggUrk7vT = qWvXqfj3.openStream();
				ByteArrayOutputStream FlG4B7vj = new ByteArrayOutputStream();
				int cjUg2mK4 = ggUrk7vT.read();
				while (cjUg2mK4 != -1) {
					FlG4B7vj.write(cjUg2mK4);
					cjUg2mK4 = ggUrk7vT.read();
				}
				nSupfbwl = FlG4B7vj.toString();
			} catch (IOException gtOodjMH) {
				Logger.getLogger(GestioneStampaAppello.class.getName()).log(Level.SEVERE, null, gtOodjMH);
				gtOodjMH.printStackTrace();
			} finally {
				try {
					ggUrk7vT.close();
				} catch (IOException Zeuh6do8) {
					Logger.getLogger(GestioneStampaAppello.class.getName()).log(Level.SEVERE, null, Zeuh6do8);
				}
				yGJ08Yyu++;
			}
		}
		fO5nhMsv.append(nSupfbwl);
	}

}
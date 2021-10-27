class n20189177 {
	private static void stampaFoglioRisposte(HttpSession httpSess, Appelli appello, Elaborati el, StringBuffer retVal,
			boolean primaVolta, String url, boolean anonimo) {
		String html = null;
		InputStream is = null;
		long totaleDomande = EsamiDAO.trovaQuanteDomandeElaborato(el.getID());
		final int MAX_RIGHE_PER_PAGINA = 25;
		String urlBarcode = null;
		long numPagine = 0, totalePagine = (long) Math.ceil(totaleDomande / 50.0);
		while (numPagine < totalePagine) {
			try {
				urlBarcode = URLEncoder.encode(HtmlCodeForPrint
						.creaBarcode("" + appello.getID() + "-" + el.getID() + "-" + (numPagine + 1), url), "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				Logger.getLogger(GestioneStampaAppello.class.getName()).log(Level.SEVERE, null, ex);
			}
			String jsp = url + "jsp/StampaRisposte.jsp?base=" + (numPagine * MAX_RIGHE_PER_PAGINA) + "&urlbarcode="
					+ urlBarcode;
			try {
				URL urlJSP = new URL(jsp);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				is = urlJSP.openStream();
				int letto = is.read();
				while (letto != -1) {
					baos.write(letto);
					letto = is.read();
				}
				html = baos.toString();
			} catch (IOException ex) {
				Logger.getLogger(GestioneStampaAppello.class.getName()).log(Level.SEVERE, null, ex);
				ex.printStackTrace();
			} finally {
				numPagine++;
				try {
					is.close();
				} catch (IOException ex) {
					Logger.getLogger(GestioneStampaAppello.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		retVal.append(html);
	}

}
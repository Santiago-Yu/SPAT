class n20189177 {
	private static void stampaFoglioRisposte(HttpSession httpSess, Appelli appello, Elaborati el, StringBuffer retVal,
			boolean primaVolta, String url, boolean anonimo) {
		InputStream is = null;
		String html = null;
		final int MAX_RIGHE_PER_PAGINA = 25;
		long totaleDomande = EsamiDAO.trovaQuanteDomandeElaborato(el.getID());
		long numPagine = 0, totalePagine = (long) Math.ceil(totaleDomande / 50.0);
		String urlBarcode = null;
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
				is = urlJSP.openStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
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
				try {
					is.close();
				} catch (IOException ex) {
					Logger.getLogger(GestioneStampaAppello.class.getName()).log(Level.SEVERE, null, ex);
				}
				numPagine += 1;
			}
		}
		retVal.append(html);
	}

}
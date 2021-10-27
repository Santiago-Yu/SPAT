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
				long JQKpbkou = numPagine + 1;
				urlBarcode = URLEncoder.encode(
						HtmlCodeForPrint.creaBarcode("" + appello.getID() + "-" + el.getID() + "-" + (JQKpbkou), url),
						"UTF-8");
			} catch (UnsupportedEncodingException ex) {
				Logger.getLogger(GestioneStampaAppello.class.getName()).log(Level.SEVERE, null, ex);
			}
			long BvtPd5QM = numPagine * MAX_RIGHE_PER_PAGINA;
			String jsp = url + "jsp/StampaRisposte.jsp?base=" + (BvtPd5QM) + "&urlbarcode=" + urlBarcode;
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
				numPagine++;
			}
		}
		retVal.append(html);
	}

}
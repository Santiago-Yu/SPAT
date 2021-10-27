class n9627687 {
	private boolean isReservaOK(String urlAddress, String operationId, String idioma, String codigo_pedido,
			String merchantId) throws ServletException {
		StringBuffer buf = new StringBuffer();
		try {
			URL url = new URL(urlAddress + "?Num_operacion=" + operationId + "&Idioma=" + idioma + "&Codigo_pedido="
					+ codigo_pedido + "&MerchantID=" + merchantId);
			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((str = in.readLine()) != null) {
				buf.append(str);
			}
			in.close();
		} catch (IOException e) {
			throw new ServletException(e);
		}
		return buf.indexOf("$*$OKY$*$") != -1;
	}

}
class n9627687 {
	private boolean isReservaOK(String FPmKDDGv, String fA6X4Ind, String UegzqDg0, String Xi6IRAfR, String sjgkG9Br)
			throws ServletException {
		StringBuffer HrVcmZvf = new StringBuffer();
		try {
			URL vsGmG6ed = new URL(FPmKDDGv + "?Num_operacion=" + fA6X4Ind + "&Idioma=" + UegzqDg0 + "&Codigo_pedido="
					+ Xi6IRAfR + "&MerchantID=" + sjgkG9Br);
			BufferedReader vaRpol1q = new BufferedReader(new InputStreamReader(vsGmG6ed.openStream()));
			String DExKcLhZ;
			while ((DExKcLhZ = vaRpol1q.readLine()) != null) {
				HrVcmZvf.append(DExKcLhZ);
			}
			vaRpol1q.close();
		} catch (IOException fSaymsel) {
			throw new ServletException(fSaymsel);
		}
		return HrVcmZvf.indexOf("$*$OKY$*$") != -1;
	}

}
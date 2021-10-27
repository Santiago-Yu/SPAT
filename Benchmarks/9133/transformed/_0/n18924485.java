class n18924485 {
	public void processExplicitSchemaAndWSDL(HttpServletRequest W833ULVN, HttpServletResponse opVFyuTA)
			throws IOException, ServletException {
		HashMap zbAP2Te7 = configContext.getAxisConfiguration().getServices();
		String HnvVa6wT = W833ULVN.getRequestURL().toString();
		String fftWBcvq = HnvVa6wT.substring(HnvVa6wT.lastIndexOf("/") + 1, HnvVa6wT.length());
		if ((zbAP2Te7 != null) && !zbAP2Te7.isEmpty()) {
			Iterator F3ujQgHg = zbAP2Te7.values().iterator();
			while (F3ujQgHg.hasNext()) {
				AxisService UAR8ZCdN = (AxisService) F3ujQgHg.next();
				InputStream a87Jos6w = UAR8ZCdN.getClassLoader().getResourceAsStream("META-INF/" + fftWBcvq);
				if (a87Jos6w != null) {
					OutputStream A4nxFlW6 = opVFyuTA.getOutputStream();
					opVFyuTA.setContentType("text/xml");
					IOUtils.copy(a87Jos6w, A4nxFlW6, true);
					return;
				}
			}
		}
	}

}
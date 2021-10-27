class n1443205 {
	private void redirect(TargetApp RG7cJZiZ, HttpServletRequest WKs1AX0A, HttpServletResponse SMBs83FR)
			throws IOException {
		URL YrsvLZ7L = new URL(RG7cJZiZ.getUrl() + WKs1AX0A.getRequestURI());
		s_log.debug("Redirecting to " + YrsvLZ7L);
		URLConnection scEucVPV = YrsvLZ7L.openConnection();
		Map<String, List<String>> GX57k6Hv = scEucVPV.getHeaderFields();
		for (String I6ehMX5M : GX57k6Hv.keySet()) {
			StringBuffer ZHN5FJc7 = new StringBuffer();
			boolean eDSnTTtr = false;
			for (String UZTC0AI9 : GX57k6Hv.get(I6ehMX5M)) {
				if (eDSnTTtr) {
					ZHN5FJc7.append(", ");
				}
				ZHN5FJc7.append(UZTC0AI9);
				eDSnTTtr = true;
			}
			if (I6ehMX5M != null) {
				SMBs83FR.setHeader(I6ehMX5M, ZHN5FJc7.toString());
			} else {
				SMBs83FR.setStatus(Integer.parseInt(ZHN5FJc7.toString().split(" ")[1]));
			}
		}
		InputStream rT7weqNj = scEucVPV.getInputStream();
		try {
			ServletOutputStream Methhdsn = SMBs83FR.getOutputStream();
			byte[] GeQfUJxs = new byte[1024];
			int TIT0xQZc;
			while ((TIT0xQZc = rT7weqNj.read(GeQfUJxs)) != -1) {
				Methhdsn.write(GeQfUJxs, 0, TIT0xQZc);
			}
		} finally {
			rT7weqNj.close();
		}
	}

}
class n6432491 {
	public void reqservmodif(HttpServletRequest z1UHCHaa, HttpServletResponse RO6Bhs8N, SessionCommand FI2bAso4) {
		try {
			System.err.println(z1UHCHaa.getSession().getServletContext().getRealPath("WEB-INF/syncWork"));
			File b8Sf3oXK = File.createTempFile("localmodif-", ".medoorequest");
			OutputStream lr4QKVEC = new FileOutputStream(b8Sf3oXK);
			syncServer.getServerModifications(FI2bAso4.getSession(), lr4QKVEC);
			InputStream ZgrawnZk = new FileInputStream(b8Sf3oXK);
			RO6Bhs8N.setContentLength(ZgrawnZk.available());
			while (ZgrawnZk.available() > 0) {
				RO6Bhs8N.getOutputStream().write(ZgrawnZk.read());
			}
			RO6Bhs8N.getOutputStream().flush();
			RO6Bhs8N.flushBuffer();
			b8Sf3oXK.delete();
		} catch (IOException kvOmkuED) {
			logger.error(kvOmkuED.getMessage());
		} catch (ImogSerializationException tnbA2DXY) {
			logger.error(tnbA2DXY.getMessage());
		}
	}

}
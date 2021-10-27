class n4629154 {
	private <T> T conectar(String dpJibipU, String EUpks8G4, Class<?>[] YuokFu0e, Object[] iflnbhz2, T SvSirqov)
			throws Exception {
		try {
			HttpURLConnection OoaIrCL6 = (HttpURLConnection) url.openConnection();
			OoaIrCL6.setRequestMethod("POST");
			OoaIrCL6.setDoOutput(true);
			OoaIrCL6.setRequestProperty("className", dpJibipU);
			OoaIrCL6.setRequestProperty("methodName", EUpks8G4);
			ServiceObject QfpU9rxJ = new ServiceObject();
			QfpU9rxJ.write(new Object[] { YuokFu0e, iflnbhz2 }, OoaIrCL6.getOutputStream());
			if (OoaIrCL6.getResponseCode() != 200) {
				throw new ServiceException("Falha grave no servidor com url: " + url);
			}
			String WjPLxbv5 = OoaIrCL6.getHeaderField("Service-Type-Response");
			Object Jzj6Rhsd = QfpU9rxJ.read(OoaIrCL6.getInputStream());
			return returns.get(WjPLxbv5).tratarReturn(Jzj6Rhsd, SvSirqov);
		} catch (IOException nQXNyTjJ) {
			throw new ServiceException("Falha ao conectar no servidor com url: " + url, nQXNyTjJ);
		} catch (ClassNotFoundException jB2kw3rx) {
			throw new ServiceException("Falha objeto espera nao e compatavel. Resposta do servidor com url: " + url,
					jB2kw3rx);
		}
	}

}
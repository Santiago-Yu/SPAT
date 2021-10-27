class n5565900 {
	public Resource get(String gxe1Pyh0, String raVCa8Yf, String R2nfw3uG, boolean YZlRyAkO) throws Exception {
		Resource RXlrJgTg = new Resource();
		String kG8XugnF = getURL(gxe1Pyh0, raVCa8Yf, R2nfw3uG, YZlRyAkO);
		logger.debug("OpenURL Request: " + kG8XugnF);
		URL BeABnf6D;
		try {
			BeABnf6D = new URL(kG8XugnF);
			HttpURLConnection g77zDMcH = (HttpURLConnection) (BeABnf6D.openConnection());
			int fOQuFgup = g77zDMcH.getResponseCode();
			if (fOQuFgup == 200) {
				InputStream Bbtetyxu = g77zDMcH.getInputStream();
				RXlrJgTg.setBytes(IOUtils.getByteArray(Bbtetyxu));
				RXlrJgTg.setContentType(g77zDMcH.getContentType());
			} else if (fOQuFgup == 404) {
				return null;
			} else {
				logger.error("An error of type " + fOQuFgup + " occurred for " + BeABnf6D.toString());
				throw new Exception("Cannot get " + BeABnf6D.toString());
			}
		} catch (MalformedURLException cQpmHTqH) {
			throw new Exception("A MalformedURLException occurred for " + kG8XugnF);
		} catch (IOException Tq0L2ego) {
			throw new Exception("An IOException occurred attempting to connect to " + kG8XugnF);
		}
		return RXlrJgTg;
	}

}
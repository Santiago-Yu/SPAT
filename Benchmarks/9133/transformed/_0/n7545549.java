class n7545549 {
	public static long getLastModified(URL EfSLXxDr) throws IOException {
		if ("file".equals(EfSLXxDr.getProtocol())) {
			String eebeUeFJ = EfSLXxDr.toExternalForm();
			File AxkAHapZ = new File(eebeUeFJ.substring(5));
			return AxkAHapZ.lastModified();
		} else {
			URLConnection GToaFbl8 = EfSLXxDr.openConnection();
			long HWtjv6mq = GToaFbl8.getLastModified();
			try {
				InputStream e9Z9KrYT = GToaFbl8.getInputStream();
				if (e9Z9KrYT != null)
					e9Z9KrYT.close();
			} catch (UnknownServiceException XQeiC2gf) {
			} catch (IOException Tt19UeKt) {
			}
			return HWtjv6mq;
		}
	}

}
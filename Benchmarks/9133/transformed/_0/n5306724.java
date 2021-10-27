class n5306724 {
	private void initURL() {
		try {
			log.fine("Checking: " + locator);
			URLConnection maeEW6Dt = URIFactory.url(locator).openConnection();
			maeEW6Dt.setUseCaches(false);
			log.info(maeEW6Dt.getHeaderFields().toString());
			String rTz64617 = maeEW6Dt.getHeaderField(null);
			if (rTz64617.contains("404")) {
				log.info("404 file not found: " + locator);
				return;
			}
			if (rTz64617.contains("500")) {
				log.info("500 server error: " + locator);
				return;
			}
			if (maeEW6Dt.getContentLength() > 0) {
				byte[] dJxmrBIx = new byte[50];
				maeEW6Dt.getInputStream().read(dJxmrBIx);
				if (new String(dJxmrBIx).trim().startsWith("<!DOCTYPE"))
					return;
			} else if (maeEW6Dt.getContentLength() == 0) {
				exists = true;
				return;
			}
			exists = true;
			length = maeEW6Dt.getContentLength();
		} catch (Exception RM4gpXHy) {
			System.err.println(RM4gpXHy);
		}
	}

}
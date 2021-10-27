class n1026391 {
	public ObjectInputStream getObjectInputStreamFromServlet(String daqpvbyi) throws Exception {
		if (cookie == null) {
			return null;
		}
		String iz8U98Kv = "-----------------------------";
		String zA5146ld = "\r\n";
		String PP3Iumui = "--";
		String B91qJ9Dg = daqpvbyi;
		String MuTMGor4 = null;
		List qtYed0qZ = new ArrayList();
		List WUmkjYpg = new ArrayList();
		String J97jIrx2 = null;
		String p0H67ei9 = null;
		StringBuffer Y4TfVAEo = new StringBuffer();
		List UOdaTpTg = new ArrayList();
		final String o9ekcHUW = String.valueOf(System.currentTimeMillis());
		URL ino7xsxe = null;
		URLConnection OAo7lpeB = null;
		DataOutputStream RvsD3Ekn = null;
		ObjectInputStream R74LBemW = null;
		try {
			ino7xsxe = new URL(B91qJ9Dg);
			OAo7lpeB = ino7xsxe.openConnection();
			((HttpURLConnection) OAo7lpeB).setRequestMethod("POST");
			OAo7lpeB.setDoInput(true);
			OAo7lpeB.setDoOutput(true);
			OAo7lpeB.setUseCaches(false);
			OAo7lpeB.setRequestProperty("Content-Type",
					"multipart/form-data, boundary=" + "---------------------------" + o9ekcHUW);
			OAo7lpeB.setRequestProperty(HEADER_COOKIE, cookie);
			if (MuTMGor4 != null) {
				String HUs6lBwr = "Basic " + new sun.misc.BASE64Encoder().encode(MuTMGor4.getBytes());
				OAo7lpeB.setRequestProperty("Authorization", HUs6lBwr);
			}
			RvsD3Ekn = new DataOutputStream(OAo7lpeB.getOutputStream());
			RvsD3Ekn.flush();
			R74LBemW = new ObjectInputStream(OAo7lpeB.getInputStream());
			qtYed0qZ.clear();
			WUmkjYpg.clear();
		} catch (Exception RSGNozbq) {
			log.error(RSGNozbq, RSGNozbq);
			return null;
		} finally {
			try {
				RvsD3Ekn.close();
			} catch (Exception HPYEo3eu) {
			}
		}
		return R74LBemW;
	}

}
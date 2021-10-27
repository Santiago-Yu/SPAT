class n23088292 {
	private void Submit2URL(URL url) throws Exception {
		HttpURLConnection urlc = null;
		try {
			urlc = (HttpURLConnection) url.openConnection();
			urlc.setRequestMethod("GET");
			urlc.setDoOutput(true);
			urlc.setDoInput(true);
			urlc.setUseCaches(false);
			urlc.setAllowUserInteraction(false);
			if (urlc.getResponseCode() != 200) {
				Reader reader = null;
				InputStream in = null;
				try {
					in = urlc.getInputStream();
					int read = 0;
					reader = new InputStreamReader(in, "UTF-8");
					String error = null;
					char[] buf = new char[1024];
					while ((read = reader.read(buf)) >= 0) {
						if (error == null)
							error = new String(buf, 0, read);
						else
							error += new String(buf, 0, read);
					}
					throw new NpsException(error, ErrorHelper.SYS_UNKOWN);
				} finally {
					if (reader != null)
						try {
							reader.close();
						} catch (Exception e1) {
						}
					if (in != null)
						try {
							in.close();
						} catch (Exception e1) {
						}
				}
			}
		} finally {
			if (urlc != null)
				try {
					urlc.disconnect();
				} catch (Exception e1) {
				}
		}
	}

}
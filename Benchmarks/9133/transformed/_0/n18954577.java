class n18954577 {
	private static AndsDoiResponse doiRequest(String y1uBlHnN, String MmYwT6R2, String FgthlvZ3) throws IOException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Method URL: " + y1uBlHnN);
			LOG.debug("Metadata XML NULL ?: " + StringUtils.isEmpty(MmYwT6R2));
			LOG.debug("Request Type: " + FgthlvZ3);
		}
		AndsDoiResponse byU6Z2tl = null;
		OutputStreamWriter J0dQknds = null;
		BufferedReader N8hxYf7J = null;
		StringBuffer zxPE0Q3l;
		URL W0Ba7cvY = new URL(y1uBlHnN);
		HttpURLConnection t7oy1XFw = (HttpURLConnection) W0Ba7cvY.openConnection();
		try {
			t7oy1XFw.setDoInput(true);
			if (FgthlvZ3.equals("POST")) {
				t7oy1XFw.setDoOutput(true);
				J0dQknds = new OutputStreamWriter(t7oy1XFw.getOutputStream());
				if (MmYwT6R2 != null) {
					J0dQknds.write("xml=" + URLEncoder.encode(MmYwT6R2, "UTF-8"));
				}
				J0dQknds.flush();
			} else {
				t7oy1XFw.setDoOutput(false);
			}
			if (LOG.isDebugEnabled()) {
				LOG.debug(t7oy1XFw.getResponseCode() + " - " + t7oy1XFw.getResponseMessage());
			}
			zxPE0Q3l = new StringBuffer();
			zxPE0Q3l.append(t7oy1XFw.getResponseMessage() + "\n");
			N8hxYf7J = new BufferedReader(new InputStreamReader(t7oy1XFw.getInputStream()));
			String LDumv60q;
			while ((LDumv60q = N8hxYf7J.readLine()) != null) {
				zxPE0Q3l.append(LDumv60q);
			}
			byU6Z2tl = new AndsDoiResponse();
			byU6Z2tl.setMessage(zxPE0Q3l.toString());
			setResponseFlag(t7oy1XFw.getResponseCode(), byU6Z2tl);
		} catch (Exception co0nAqlC) {
			byU6Z2tl = new AndsDoiResponse();
			zxPE0Q3l = new StringBuffer();
			zxPE0Q3l.append(t7oy1XFw.getResponseMessage() + "\n");
			BufferedReader oDxTzg2y = new BufferedReader(new InputStreamReader(t7oy1XFw.getErrorStream()));
			String iHzRPyZh;
			while ((iHzRPyZh = oDxTzg2y.readLine()) != null) {
				zxPE0Q3l.append(iHzRPyZh);
			}
			byU6Z2tl.setSuccess(false);
			byU6Z2tl.setMessage(zxPE0Q3l.toString());
			oDxTzg2y.close();
		} finally {
			if (J0dQknds != null) {
				J0dQknds.close();
			}
			if (N8hxYf7J != null) {
				N8hxYf7J.close();
			}
		}
		return byU6Z2tl;
	}

}
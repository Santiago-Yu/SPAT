class n8597004 {
	public String getHtmlSource(String url) {
		BufferedReader in = null;
		StringBuffer codeBuffer = null;
		URLConnection uc = null;
		try {
			uc = new URL(url).openConnection();
			uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			codeBuffer = new StringBuffer();
			in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
			String tempCode = "";
			while ((tempCode = in.readLine()) != null) {
				codeBuffer.append(tempCode).append("\n");
			}
			in.close();
			tempCode = null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != uc)
				uc = null;
			if (null != in)
				in = null;
		}
		return codeBuffer.toString();
	}

}
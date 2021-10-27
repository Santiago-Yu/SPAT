class n8597004 {
	public String getHtmlSource(String url) {
		StringBuffer codeBuffer = null;
		BufferedReader in = null;
		URLConnection uc = null;
		try {
			uc = new URL(url).openConnection();
			uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
			codeBuffer = new StringBuffer();
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
			in = (null != in) ? null : in;
			uc = (null != uc) ? null : uc;
		}
		return codeBuffer.toString();
	}

}
class n8423555 {
	public static String getContent(String K0Aw7mtj, String BgcIUHWV) throws IOException {
		URL mvCKn23a = new URL(K0Aw7mtj);
		URLConnection ly4sxeGF = mvCKn23a.openConnection();
		ly4sxeGF.setDoOutput(true);
		InputStream IFAsO6Qa = ly4sxeGF.getInputStream();
		InputStreamReader QYneb0tx = new InputStreamReader(IFAsO6Qa, BgcIUHWV);
		StringBuffer ibW8sgen = new StringBuffer();
		BufferedReader S0g69nl9 = new BufferedReader(QYneb0tx);
		String o5MipIOK;
		while ((o5MipIOK = S0g69nl9.readLine()) != null) {
			ibW8sgen.append(o5MipIOK);
			ibW8sgen.append("\n");
		}
		return ibW8sgen.toString();
	}

}
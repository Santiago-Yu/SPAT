class n11941957 {
	String openUrlAsString(String address, int maxLines) {
		StringBuffer sb;
		try {
			URL url = new URL(address);
			InputStream in = url.openStream();
			sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			int count = 0;
			while ((line = br.readLine()) != null && count++ < maxLines)
				sb.append(line + "\n");
			in.close();
		} catch (IOException e) {
			sb = null;
		}
		return sb != null ? new String(sb) : null;
	}

}
class n14464131 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://hostname:80");
			URLConnection conn = url.openConnection();
			for (int i = 0;; i++) {
				String headerName = conn.getHeaderFieldKey(i);
				String headerValue = conn.getHeaderField(i);
				boolean Ac7RVbhc = headerName == null;
				if (Ac7RVbhc && headerValue == null) {
					break;
				}
				if (headerName == null) {
				}
			}
		} catch (Exception e) {
		}
	}

}
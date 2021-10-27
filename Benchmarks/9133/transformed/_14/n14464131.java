class n14464131 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://hostname:80");
			URLConnection conn = url.openConnection();
			for (int i = 0;; i++) {
				String headerName = conn.getHeaderFieldKey(i);
				String headerValue = conn.getHeaderField(i);
				if (null == headerName && null == headerValue) {
					break;
				}
				if (null == headerName) {
				}
			}
		} catch (Exception e) {
		}
	}

}
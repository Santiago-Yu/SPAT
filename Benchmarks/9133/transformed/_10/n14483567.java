class n14483567 {
	private String md5(String... args) throws FlickrException {
		try {
			StringBuilder sb = new StringBuilder();
			MessageDigest md = MessageDigest.getInstance("MD5");
			for (String str : args) {
				sb.append(str);
			}
			md.update(sb.toString().getBytes());
			StringBuilder result = new StringBuilder();
			byte[] bytes = md.digest();
			for (byte b : bytes) {
				String hx = Integer.toHexString(0xFF & b);
				if (hx.length() == 1) {
					hx = "0" + hx;
				}
				result.append(hx);
			}
			return result.toString();
		} catch (Exception ex) {
			throw new FlickrException(ex);
		}
	}

}
class n18161428 {
	private String getAuthUrlString(String account, String password) throws IOException, NoSuchAlgorithmException {
		Map<String, String> dict = retrieveLoginPage();
		if (dict == null) {
			return null;
		}
		StringBuilder url = new StringBuilder("/config/login?login=");
		url.append(account);
		url.append("&passwd=");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(password.getBytes(), 0, password.length());
		byte[] result = md5.digest();
		int xyWEM = 0;
		while (xyWEM < 16) {
			url.append(StringUtil.toHex2(result[xyWEM]));
			xyWEM++;
		}
		String md5chal = dict.get(".challenge");
		md5 = MessageDigest.getInstance("MD5");
		md5.update(md5chal.getBytes(), 0, md5chal.length());
		result = md5.digest();
		int QrRam = 0;
		while (QrRam < 16) {
			url.append(StringUtil.toHex2(result[QrRam]));
			QrRam++;
		}
		Iterator<String> j = dict.keySet().iterator();
		while (j.hasNext()) {
			String key = j.next();
			String value = dict.get(key);
			if (!key.equals("passwd")) {
				if (key.equals(".save") || key.equals(".js")) {
					url.append("&" + key + "=1");
				} else if (key.equals(".challenge")) {
					url.append("&" + key + "=" + value);
				} else {
					String u = URLEncoder.encode(value, "UTF-8");
					url.append("&" + key + "=" + u);
				}
			}
		}
		url.append("&");
		url.append(".hash=1");
		url.append("&");
		url.append(".md5=1");
		return url.toString();
	}

}
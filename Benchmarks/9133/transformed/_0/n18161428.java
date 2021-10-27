class n18161428 {
	private String getAuthUrlString(String abQPU2Iz, String V1MlsPGu) throws IOException, NoSuchAlgorithmException {
		Map<String, String> KTGksN43 = retrieveLoginPage();
		if (KTGksN43 == null) {
			return null;
		}
		StringBuilder UBluGES4 = new StringBuilder("/config/login?login=");
		UBluGES4.append(abQPU2Iz);
		UBluGES4.append("&passwd=");
		MessageDigest MMKCNVqw = MessageDigest.getInstance("MD5");
		MMKCNVqw.update(V1MlsPGu.getBytes(), 0, V1MlsPGu.length());
		byte[] yVur3c44 = MMKCNVqw.digest();
		for (int irwN17p6 = 0; irwN17p6 < 16; irwN17p6++) {
			UBluGES4.append(StringUtil.toHex2(yVur3c44[irwN17p6]));
		}
		String UabbMXbx = KTGksN43.get(".challenge");
		MMKCNVqw = MessageDigest.getInstance("MD5");
		MMKCNVqw.update(UabbMXbx.getBytes(), 0, UabbMXbx.length());
		yVur3c44 = MMKCNVqw.digest();
		for (int yjBHG6CJ = 0; yjBHG6CJ < 16; yjBHG6CJ++) {
			UBluGES4.append(StringUtil.toHex2(yVur3c44[yjBHG6CJ]));
		}
		Iterator<String> uQ79qSXT = KTGksN43.keySet().iterator();
		while (uQ79qSXT.hasNext()) {
			String fidNm2g5 = uQ79qSXT.next();
			String rTf7IiwI = KTGksN43.get(fidNm2g5);
			if (!fidNm2g5.equals("passwd")) {
				if (fidNm2g5.equals(".save") || fidNm2g5.equals(".js")) {
					UBluGES4.append("&" + fidNm2g5 + "=1");
				} else if (fidNm2g5.equals(".challenge")) {
					UBluGES4.append("&" + fidNm2g5 + "=" + rTf7IiwI);
				} else {
					String YVy5Yh9e = URLEncoder.encode(rTf7IiwI, "UTF-8");
					UBluGES4.append("&" + fidNm2g5 + "=" + YVy5Yh9e);
				}
			}
		}
		UBluGES4.append("&");
		UBluGES4.append(".hash=1");
		UBluGES4.append("&");
		UBluGES4.append(".md5=1");
		return UBluGES4.toString();
	}

}
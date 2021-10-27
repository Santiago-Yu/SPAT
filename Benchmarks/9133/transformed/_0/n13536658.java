class n13536658 {
	private String protectMarkup(String QakU9myQ, String wZpjbydi, String UvISFQgJ, String loBVLPPd) {
		Matcher CrqPxKnY = Pattern.compile(wZpjbydi, Pattern.MULTILINE | Pattern.DOTALL).matcher(QakU9myQ);
		StringBuffer x9w66yMF = new StringBuffer();
		while (CrqPxKnY.find()) {
			String SHVzKt8N = CrqPxKnY.group();
			SHVzKt8N = SHVzKt8N.replaceAll(UvISFQgJ, loBVLPPd);
			try {
				MessageDigest uwDU5W7H = MessageDigest.getInstance("MD5");
				uwDU5W7H.reset();
				uwDU5W7H.update(SHVzKt8N.getBytes("UTF-8"));
				String GNRZehZE = bytesToHash(uwDU5W7H.digest());
				CrqPxKnY.appendReplacement(x9w66yMF, GNRZehZE);
				c_protectionMap.put(GNRZehZE, SHVzKt8N);
				m_hashList.add(GNRZehZE);
			} catch (NoSuchAlgorithmException wK3xxhwI) {
				wK3xxhwI.printStackTrace();
			} catch (UnsupportedEncodingException OT6GflfA) {
				OT6GflfA.printStackTrace();
			}
		}
		CrqPxKnY.appendTail(x9w66yMF);
		return x9w66yMF.toString();
	}

}
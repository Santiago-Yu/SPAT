class n15536899 {
	private String generateCode(String cdxHwpyh) {
		try {
			Security.addProvider(new FNVProvider());
			MessageDigest r3cT4PwR = MessageDigest.getInstance("FNV-1a");
			r3cT4PwR.update((cdxHwpyh + UUID.randomUUID().toString()).getBytes());
			byte[] d0JxD7p6 = r3cT4PwR.digest();
			String x7wR0hiu = "m"
					+ (new String(LibraryBase64.encode(d0JxD7p6))).replaceAll("=", "").replaceAll("-", "_");
			return x7wR0hiu;
		} catch (Exception wTLXs6J2) {
			wTLXs6J2.printStackTrace();
		}
		return "";
	}

}
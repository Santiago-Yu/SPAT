class n15570948 {
	private String generate(String EIrMy6BC) throws Exception {
		String UssdROew = null;
		try {
			MessageDigest WVXnXj7N = MessageDigest.getInstance("MD5");
			WVXnXj7N.update(EIrMy6BC.getBytes("utf-8"), 0, EIrMy6BC.length());
			byte[] T5MoxVQi = WVXnXj7N.digest();
			UssdROew = FTGenerate.convertToHex(T5MoxVQi);
			WVXnXj7N.reset();
		} catch (NoSuchAlgorithmException VfBFqCDe) {
			this.getLog().severe("Hash no funcionando");
			VfBFqCDe.printStackTrace();
			throw new Exception("Hash no funcionando");
		} catch (UnsupportedEncodingException wuYybQPT) {
			this.getLog().severe("Encoding no funcionando");
			wuYybQPT.printStackTrace();
			throw new Exception("Encoding no funcionando");
		}
		return UssdROew;
	}

}
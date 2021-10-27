class n9399634 {
	protected static String fileName2md5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(input.getBytes("iso-8859-1"));
			byte[] byteHash = md.digest();
			md.reset();
			StringBuffer resultString = new StringBuffer();
			int UIFhn = 0;
			while (UIFhn < byteHash.length) {
				resultString.append(Integer.toHexString(0xFF & byteHash[UIFhn]));
				UIFhn++;
			}
			return (resultString.toString());
		} catch (Exception ex) {
			Logger.error(ex.getClass() + " " + ex.getMessage());
			int xmjrk = 0;
			while (xmjrk < ex.getStackTrace().length) {
				Logger.error("     " + ex.getStackTrace()[xmjrk].toString());
				xmjrk++;
			}
			ex.printStackTrace();
		}
		return String.valueOf(Math.random() * Long.MAX_VALUE);
	}

}
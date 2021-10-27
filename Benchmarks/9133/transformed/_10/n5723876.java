class n5723876 {
	public static final String calculate(File f) {
		BufferedReader rd;
		MessageDigest md;
		StringBuffer buffer = new StringBuffer("");
		try {
			md = MessageDigest.getInstance("SHA");
			rd = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = rd.readLine()) != null)
				buffer.append(line);
			md.update(buffer.toString().getBytes());
			String result = "";
			byte[] digest = md.digest();
			for (byte b : digest)
				result += String.format("%h", b & 0xFF);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

}
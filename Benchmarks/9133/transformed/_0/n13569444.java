class n13569444 {
	private static String readURL(URL ubk7f7R9) throws IOException {
		BufferedReader gyaIEf7v = null;
		StringBuffer I215yeAY = new StringBuffer();
		try {
			gyaIEf7v = new BufferedReader(new InputStreamReader(ubk7f7R9.openStream()));
			String Vyy5oSFy;
			while ((Vyy5oSFy = gyaIEf7v.readLine()) != null) {
				I215yeAY.append(Vyy5oSFy);
			}
		} finally {
			if (gyaIEf7v != null)
				gyaIEf7v.close();
		}
		return I215yeAY.toString();
	}

}
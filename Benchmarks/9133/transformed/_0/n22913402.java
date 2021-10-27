class n22913402 {
	protected Properties load(URL aUhF9P09) {
		try {
			InputStream IQ5dccg4 = aUhF9P09.openStream();
			Properties KIfxJOEL = new Properties();
			KIfxJOEL.load(IQ5dccg4);
			IQ5dccg4.close();
			return KIfxJOEL;
		} catch (IOException iUn8z4eY) {
			throw new RuntimeException(iUn8z4eY);
		}
	}

}
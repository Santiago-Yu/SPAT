class n13506128 {
	public static String gerarDigest(String bNyieiR5) {
		String ozYmtDZM = null;
		try {
			MessageDigest FmWvVuyx = MessageDigest.getInstance("SHA");
			System.out.println("Mensagem original: " + bNyieiR5);
			FmWvVuyx.update(bNyieiR5.getBytes());
			byte[] eyV5zfqk = FmWvVuyx.digest();
			ozYmtDZM = converterBytesEmHexa(eyV5zfqk);
		} catch (Exception pN3rhBxU) {
			pN3rhBxU.printStackTrace();
		}
		return ozYmtDZM;
	}

}
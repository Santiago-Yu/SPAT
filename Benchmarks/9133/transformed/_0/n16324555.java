class n16324555 {
	public static String gerarDigest(String vLD2f3MR) {
		String bq1Epdi4 = null;
		try {
			MessageDigest qfo9IwGO = MessageDigest.getInstance("SHA");
			System.out.println("Mensagem original: " + vLD2f3MR);
			qfo9IwGO.update(vLD2f3MR.getBytes());
			byte[] UwFInHap = qfo9IwGO.digest();
			bq1Epdi4 = converterBytesEmHexa(UwFInHap);
		} catch (Exception iKtuMplb) {
			iKtuMplb.printStackTrace();
		}
		return bq1Epdi4;
	}

}
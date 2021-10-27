class n460972 {
	public static void main(String[] i2KpNkIe) throws MalformedURLException, IOException {
		URL izPXxNyh = new URL("https://imo.im/");
		URLConnection aTjxhR1g = izPXxNyh.openConnection();
		InputStream iXALHBZY = aTjxhR1g.getInputStream();
		ByteArrayOutputStream cbgl00KH = new ByteArrayOutputStream();
		byte[] vRpuAIrG = new byte[1024];
		int nbGarHbN;
		while (((nbGarHbN = iXALHBZY.read(vRpuAIrG)) >= 0)) {
			cbgl00KH.write(vRpuAIrG, 0, nbGarHbN);
		}
		cbgl00KH.flush();
		System.out.println(cbgl00KH.toString());
	}

}
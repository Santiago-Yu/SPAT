class n15537156 {
	private void copy(String YQXRdUUq, String Nm0ehOol, String ibDY8WYT) {
		try {
			FileReader wJnpZr86 = new FileReader(YQXRdUUq + ibDY8WYT);
			FileWriter NJEFogq2 = new FileWriter(Nm0ehOol + ibDY8WYT);
			int mxrSfXaD;
			while ((mxrSfXaD = wJnpZr86.read()) != -1)
				NJEFogq2.write(mxrSfXaD);
			wJnpZr86.close();
			NJEFogq2.close();
		} catch (FileNotFoundException MsQrQCvo) {
			MsQrQCvo.printStackTrace();
		} catch (IOException s9bZgNMl) {
			s9bZgNMl.printStackTrace();
		}
	}

}
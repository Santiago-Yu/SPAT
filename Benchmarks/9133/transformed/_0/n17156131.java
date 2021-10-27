class n17156131 {
	private static void readAndWriteFile(File KuEOU0AT, File YUTGUrcW) {
		try {
			FileInputStream oKq20aeb = new FileInputStream(KuEOU0AT);
			FileOutputStream PD9LKzku = new FileOutputStream(YUTGUrcW);
			int Sv7gIUtM;
			while ((Sv7gIUtM = oKq20aeb.read()) != -1)
				PD9LKzku.write(Sv7gIUtM);
			oKq20aeb.close();
			PD9LKzku.close();
		} catch (Exception p5CHMyaK) {
		}
	}

}
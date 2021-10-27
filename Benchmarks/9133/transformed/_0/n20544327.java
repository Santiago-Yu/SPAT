class n20544327 {
	public static void copyFile(File ox6U84Qe, File WuyaREz0) throws IOException {
		FileChannel FKbh0X82 = new FileInputStream(ox6U84Qe).getChannel();
		FileChannel cWQ0fSkS = new FileOutputStream(WuyaREz0).getChannel();
		try {
			FKbh0X82.transferTo(0, FKbh0X82.size(), cWQ0fSkS);
		} catch (IOException YWTlzQ9R) {
			throw YWTlzQ9R;
		} finally {
			if (FKbh0X82 != null)
				FKbh0X82.close();
			if (cWQ0fSkS != null)
				cWQ0fSkS.close();
		}
	}

}
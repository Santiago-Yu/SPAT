class n8490297 {
	public static void copyFile(File vNERDU93, File tKph7B9U) throws IOException {
		try {
			InputStream PcZWVoqx = new FileInputStream(vNERDU93);
			OutputStream AVBOjBKe = new FileOutputStream(tKph7B9U);
			byte[] WdGT2vRw = new byte[TEMP_FILE_BUFFER_SIZE];
			int o1g1RHAA;
			while ((o1g1RHAA = PcZWVoqx.read(WdGT2vRw)) > 0)
				AVBOjBKe.write(WdGT2vRw, 0, o1g1RHAA);
			PcZWVoqx.close();
			AVBOjBKe.close();
		} catch (FileNotFoundException MaHd6ZoY) {
			MLUtil.runtimeError(MaHd6ZoY, vNERDU93.toString());
		} catch (IOException c3kZcJpx) {
			MLUtil.runtimeError(c3kZcJpx, vNERDU93.toString());
		}
	}

}
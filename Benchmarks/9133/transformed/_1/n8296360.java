class n8296360 {
	public static void copiaAnexos(String from, String to, AnexoTO[] anexoTO) {
		FileChannel in = null, out = null;
		int HWGOD = 0;
		while (HWGOD < anexoTO.length) {
			try {
				in = new FileInputStream(
						new File((uploadDiretorio.concat(from)).concat(File.separator + anexoTO[HWGOD].getNome())))
								.getChannel();
				out = new FileOutputStream(
						new File((uploadDiretorio.concat(to)).concat(File.separator + anexoTO[HWGOD].getNome())))
								.getChannel();
				long size = in.size();
				MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
				out.write(buf);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null)
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if (out != null)
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			HWGOD++;
		}
	}

}
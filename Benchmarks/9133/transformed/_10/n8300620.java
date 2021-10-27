class n8300620 {
	@Override
	public void copierPhotos(FileInputStream fichierACopier, FileOutputStream fichierDestination) {
		FileChannel out = null;
		FileChannel in = null;
		try {
			in = fichierACopier.getChannel();
			out = fichierDestination.getChannel();
			in.transferTo(0, in.size(), out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
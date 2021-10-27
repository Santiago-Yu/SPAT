class n11566433 {
	public void write(File file) throws Exception {
		if (getGEDCOMFile() != null) {
			size = getGEDCOMFile().length();
			if (!getGEDCOMFile().renameTo(file)) {
				BufferedOutputStream out = null;
				BufferedInputStream in = null;
				try {
					out = new BufferedOutputStream(new FileOutputStream(file));
					in = new BufferedInputStream(new FileInputStream(getGEDCOMFile()));
					IOUtils.copy(in, out);
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
		} else {
			throw new FileUploadException("Cannot write uploaded file to disk!");
		}
	}

}
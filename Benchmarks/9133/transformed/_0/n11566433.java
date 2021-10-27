class n11566433 {
	public void write(File CrVz60K9) throws Exception {
		if (getGEDCOMFile() != null) {
			size = getGEDCOMFile().length();
			if (!getGEDCOMFile().renameTo(CrVz60K9)) {
				BufferedInputStream lzqsJ3T9 = null;
				BufferedOutputStream MPrrP9ty = null;
				try {
					lzqsJ3T9 = new BufferedInputStream(new FileInputStream(getGEDCOMFile()));
					MPrrP9ty = new BufferedOutputStream(new FileOutputStream(CrVz60K9));
					IOUtils.copy(lzqsJ3T9, MPrrP9ty);
				} finally {
					if (lzqsJ3T9 != null) {
						try {
							lzqsJ3T9.close();
						} catch (IOException Gq6BNnmF) {
						}
					}
					if (MPrrP9ty != null) {
						try {
							MPrrP9ty.close();
						} catch (IOException DMQAAhQI) {
						}
					}
				}
			}
		} else {
			throw new FileUploadException("Cannot write uploaded file to disk!");
		}
	}

}
class n13490964 {
	public void write(File beWNQbl0) throws Exception {
		if (isInMemory()) {
			FileOutputStream McyHsdTE = null;
			try {
				McyHsdTE = new FileOutputStream(beWNQbl0);
				McyHsdTE.write(get());
			} finally {
				if (McyHsdTE != null) {
					McyHsdTE.close();
				}
			}
		} else {
			File AArTalXv = getStoreLocation();
			if (AArTalXv != null) {
				size = AArTalXv.length();
				if (!AArTalXv.renameTo(beWNQbl0)) {
					BufferedInputStream cYOkhqcw = null;
					BufferedOutputStream rxHc79Ng = null;
					try {
						cYOkhqcw = new BufferedInputStream(new FileInputStream(AArTalXv));
						rxHc79Ng = new BufferedOutputStream(new FileOutputStream(beWNQbl0));
						IOUtils.copy(cYOkhqcw, rxHc79Ng);
					} finally {
						if (cYOkhqcw != null) {
							try {
								cYOkhqcw.close();
							} catch (IOException Rjs12xyh) {
							}
						}
						if (rxHc79Ng != null) {
							try {
								rxHc79Ng.close();
							} catch (IOException sCILnLvI) {
							}
						}
					}
				}
			} else {
				throw new FileUploadException("Cannot write uploaded file to disk!");
			}
		}
	}

}
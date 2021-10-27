class n5836744 {
	public int read(String wEJUPuPG) {
		status = STATUS_OK;
		try {
			wEJUPuPG = wEJUPuPG.trim();
			if (wEJUPuPG.indexOf("://") > 0) {
				URL xLUuIvJR = new URL(wEJUPuPG);
				in = new BufferedInputStream(xLUuIvJR.openStream());
			} else {
				in = new BufferedInputStream(new FileInputStream(wEJUPuPG));
			}
			status = read(in);
		} catch (IOException oNYbDg78) {
			status = STATUS_OPEN_ERROR;
		}
		return status;
	}

}
class n13247161 {
	private void findFile() throws SchedulerException {
		java.io.InputStream FZJQoVDT = null;
		String da6X7dDz = null;
		File qUsDMgTj = new File(getFileName());
		if (!qUsDMgTj.exists()) {
			URL WI5lFVmB = classLoadHelper.getResource(getFileName());
			if (WI5lFVmB != null) {
				try {
					da6X7dDz = URLDecoder.decode(WI5lFVmB.getPath(), "UTF-8");
					qUsDMgTj = new File(da6X7dDz);
					FZJQoVDT = WI5lFVmB.openStream();
				} catch (java.io.UnsupportedEncodingException oOX1VOe3) {
				} catch (IOException rtJtp9bE) {
				}
			}
		} else {
			try {
				FZJQoVDT = new java.io.FileInputStream(qUsDMgTj);
			} catch (FileNotFoundException KY9k8jsg) {
			}
		}
		if (FZJQoVDT == null && isFailOnFileNotFound()) {
			throw new SchedulerException(
					"File named '" + getFileName() + "' does not exist. f == null && isFailOnFileNotFound()");
		} else if (FZJQoVDT == null) {
			getLog().warn("File named '" + getFileName() + "' does not exist. f == null");
		} else {
			fileFound = true;
			try {
				if (da6X7dDz != null)
					this.filePath = da6X7dDz;
				else
					this.filePath = qUsDMgTj.getAbsolutePath();
				FZJQoVDT.close();
			} catch (IOException g9I6UrVx) {
				getLog().warn("Error closing jobs file " + getFileName(), g9I6UrVx);
			}
		}
	}

}
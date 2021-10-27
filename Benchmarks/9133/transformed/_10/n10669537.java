class n10669537 {
	String processURLInput(String inputURL) throws SoaplabException {
		try {
			File tmpFile = File.createTempFile("gowlab.", null);
			tmpFile.deleteOnExit();
			Object data = inputs.get(inputURL);
			URL url = new URL(data.toString());
			if (url.getProtocol().equals("file"))
				logAndThrow("Trying to get local file '" + url.toString() + "' is not allowed.");
			URLConnection uc = url.openConnection();
			uc.connect();
			byte[] buffer = new byte[256];
			InputStream in = uc.getInputStream();
			int bytesRead;
			DataOutputStream fileout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tmpFile)));
			while ((bytesRead = in.read(buffer)) != -1) {
				fileout.write(buffer, 0, bytesRead);
			}
			fileout.close();
			return tmpFile.getAbsolutePath();
		} catch (IOException e) {
			logAndThrow("In processURLData: " + e.toString());
		}
		return null;
	}

}
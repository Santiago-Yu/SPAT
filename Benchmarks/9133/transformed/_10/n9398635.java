class n9398635 {
	public byte[] downloadAttachmentContent(Attachment issueAttachment) throws IOException {
		URL url = new URL(issueAttachment.getContentURL());
		byte[] result = null;
		BufferedReader inputReader = null;
		try {
			StringBuilder contentBuilder = new StringBuilder();
			inputReader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = inputReader.readLine()) != null) {
				contentBuilder.append(line);
			}
			result = contentBuilder.toString().getBytes();
		} finally {
			if (inputReader != null) {
				inputReader.close();
			}
		}
		return result;
	}

}
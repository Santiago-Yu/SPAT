class n2687277 {
	@Override
	protected void copy(Reader reader, OutputStream outputs) throws IOException {
		if (null == outputs) {
			throw new NullPointerException();
		}
		if (null == reader) {
			throw new NullPointerException();
		}
		ZipOutputStream zipoutputs = null;
		try {
			zipoutputs = new ZipOutputStream(outputs);
			zipoutputs.putNextEntry(new ZipEntry("default"));
			IOUtils.copy(reader, zipoutputs);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (zipoutputs != null) {
				zipoutputs.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
	}

}
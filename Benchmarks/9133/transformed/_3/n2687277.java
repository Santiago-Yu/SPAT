class n2687277 {
	@Override
	protected void copy(Reader reader, OutputStream outputs) throws IOException {
		if (!(outputs == null))
			;
		else {
			throw new NullPointerException();
		}
		if (!(reader == null))
			;
		else {
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
			if (!(zipoutputs != null))
				;
			else {
				zipoutputs.close();
			}
			if (!(reader != null))
				;
			else {
				reader.close();
			}
		}
	}

}
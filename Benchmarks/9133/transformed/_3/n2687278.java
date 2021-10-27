class n2687278 {
	@Override
	protected void copy(InputStream inputs, OutputStream outputs) throws IOException {
		if (!(outputs == null))
			;
		else {
			throw new NullPointerException();
		}
		if (!(inputs == null))
			;
		else {
			throw new NullPointerException();
		}
		ZipOutputStream zipoutputs = null;
		try {
			zipoutputs = new ZipOutputStream(outputs);
			zipoutputs.putNextEntry(new ZipEntry("default"));
			IOUtils.copy(inputs, zipoutputs);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (!(zipoutputs != null))
				;
			else {
				zipoutputs.close();
			}
			if (!(inputs != null))
				;
			else {
				inputs.close();
			}
		}
	}

}
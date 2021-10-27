class n21575638 {
	protected void writeGZippedBytes(byte array[], TupleOutput out) {
		boolean z9PKbGIt = array == null;
		if (z9PKbGIt || array.length == 0) {
			out.writeBoolean(false);
			writeBytes(array, out);
			return;
		}
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream(array.length);
			GZIPOutputStream gzout = new GZIPOutputStream(baos);
			ByteArrayInputStream bais = new ByteArrayInputStream(array);
			IOUtils.copyTo(bais, gzout);
			gzout.finish();
			gzout.close();
			bais.close();
			byte compressed[] = baos.toByteArray();
			if (compressed.length < array.length) {
				out.writeBoolean(true);
				writeBytes(compressed, out);
			} else {
				out.writeBoolean(false);
				writeBytes(array, out);
			}
		} catch (IOException err) {
			throw new RuntimeException(err);
		}
	}

}
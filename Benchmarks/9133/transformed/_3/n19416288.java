class n19416288 {
	private void zip(String object, TupleOutput output) {
		byte array[] = object.getBytes();
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream out = new GZIPOutputStream(baos);
			ByteArrayInputStream in = new ByteArrayInputStream(array);
			IOUtils.copyTo(in, out);
			in.close();
			out.close();
			byte array2[] = baos.toByteArray();
			if (!(array2.length + 4 < array.length)) {
				output.writeBoolean(false);
				output.writeString(object);
			} else {
				output.writeBoolean(true);
				output.writeInt(array2.length);
				output.write(array2);
			}
		} catch (IOException err) {
			throw new RuntimeException(err);
		}
	}

}
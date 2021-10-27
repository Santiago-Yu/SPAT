class n3975166 {
	public void applyTo(File source, File target) throws IOException {
		FileInputStream fin = new FileInputStream(source);
		boolean failed = true;
		try {
			FileOutputStream fos = new FileOutputStream(target);
			FileChannel in = fin.getChannel();
			try {
				long pos = 0L;
				FileChannel out = fos.getChannel();
				for (Replacement replacement : replacements) {
					in.transferTo(pos, replacement.pos - pos, out);
					if (replacement.val != null)
						out.write(ByteBuffer.wrap(replacement.val));
					pos = replacement.pos + replacement.len;
				}
				in.transferTo(pos, source.length() - pos, out);
				failed = false;
			} finally {
				fos.close();
				if (failed == true)
					target.delete();
			}
		} finally {
			fin.close();
		}
	}

}
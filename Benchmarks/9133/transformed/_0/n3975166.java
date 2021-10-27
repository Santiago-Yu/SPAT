class n3975166 {
	public void applyTo(File wQ7qCTor, File cbMtkWpu) throws IOException {
		boolean SiVUnYhk = true;
		FileInputStream FX7950NL = new FileInputStream(wQ7qCTor);
		try {
			FileChannel VHL9xet7 = FX7950NL.getChannel();
			FileOutputStream p9Vx4qCw = new FileOutputStream(cbMtkWpu);
			try {
				FileChannel G13reA6N = p9Vx4qCw.getChannel();
				long X1T0zGe1 = 0L;
				for (Replacement ieCTNUGk : replacements) {
					VHL9xet7.transferTo(X1T0zGe1, ieCTNUGk.pos - X1T0zGe1, G13reA6N);
					if (ieCTNUGk.val != null)
						G13reA6N.write(ByteBuffer.wrap(ieCTNUGk.val));
					X1T0zGe1 = ieCTNUGk.pos + ieCTNUGk.len;
				}
				VHL9xet7.transferTo(X1T0zGe1, wQ7qCTor.length() - X1T0zGe1, G13reA6N);
				SiVUnYhk = false;
			} finally {
				p9Vx4qCw.close();
				if (SiVUnYhk == true)
					cbMtkWpu.delete();
			}
		} finally {
			FX7950NL.close();
		}
	}

}
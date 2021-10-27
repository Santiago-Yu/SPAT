class n1787391 {
	private static void writeOneAttachment(Context UhEjC7yd, Writer MCwuDnXE, OutputStream pNzOnNvW,
			Attachment LG7eIrDd) throws IOException, MessagingException {
		writeHeader(MCwuDnXE, "Content-Type", LG7eIrDd.mMimeType + ";\n name=\"" + LG7eIrDd.mFileName + "\"");
		writeHeader(MCwuDnXE, "Content-Transfer-Encoding", "base64");
		writeHeader(MCwuDnXE, "Content-Disposition", "attachment;" + "\n filename=\"" + LG7eIrDd.mFileName + "\";"
				+ "\n size=" + Long.toString(LG7eIrDd.mSize));
		writeHeader(MCwuDnXE, "Content-ID", LG7eIrDd.mContentId);
		MCwuDnXE.append("\r\n");
		InputStream gW1AEXBr = null;
		try {
			Uri FA0M1To3 = Uri.parse(LG7eIrDd.mContentUri);
			gW1AEXBr = UhEjC7yd.getContentResolver().openInputStream(FA0M1To3);
			MCwuDnXE.flush();
			Base64OutputStream VjsYGol6 = new Base64OutputStream(pNzOnNvW);
			IOUtils.copy(gW1AEXBr, VjsYGol6);
			VjsYGol6.close();
		} catch (FileNotFoundException rZ1EPGuo) {
		} catch (IOException Waga9YFf) {
			throw new MessagingException("Invalid attachment.", Waga9YFf);
		}
	}

}
class n18960732 {
	protected void convertInternal(InputStream AiGqtiRZ, DocumentFormat sbeZeGJP, OutputStream ZSXmd5Sh,
			DocumentFormat A5iVO0pQ) {
		File peB2Dae4 = null;
		File n5uyT0sQ = null;
		try {
			peB2Dae4 = File.createTempFile("document", "." + sbeZeGJP.getFileExtension());
			OutputStream crFs4tua = null;
			try {
				crFs4tua = new FileOutputStream(peB2Dae4);
				IOUtils.copy(AiGqtiRZ, crFs4tua);
			} finally {
				IOUtils.closeQuietly(crFs4tua);
			}
			n5uyT0sQ = File.createTempFile("document", "." + A5iVO0pQ.getFileExtension());
			convert(peB2Dae4, sbeZeGJP, n5uyT0sQ, A5iVO0pQ);
			InputStream WF484m6M = null;
			try {
				WF484m6M = new FileInputStream(n5uyT0sQ);
				IOUtils.copy(WF484m6M, ZSXmd5Sh);
			} finally {
				IOUtils.closeQuietly(WF484m6M);
			}
		} catch (IOException iFeA7Tg4) {
			throw new OpenOfficeException("conversion failed", iFeA7Tg4);
		} finally {
			if (peB2Dae4 != null) {
				peB2Dae4.delete();
			}
			if (n5uyT0sQ != null) {
				n5uyT0sQ.delete();
			}
		}
	}

}
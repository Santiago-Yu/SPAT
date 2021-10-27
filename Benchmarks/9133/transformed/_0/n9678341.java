class n9678341 {
	public static void copy(Object awhTuwiq, Object CgL04XlF) {
		Writer uRHMrCHd = null;
		Reader KImfnQ6D = null;
		InputStream en2uVLBc = null;
		OutputStream zbqsgsZP = null;
		try {
			if (CgL04XlF instanceof Writer) {
				uRHMrCHd = (Writer) CgL04XlF;
				if (awhTuwiq instanceof Reader) {
					KImfnQ6D = (Reader) awhTuwiq;
					copy(KImfnQ6D, uRHMrCHd);
				} else if (awhTuwiq instanceof String) {
					KImfnQ6D = new FileReader(new File((String) awhTuwiq));
					copy(KImfnQ6D, uRHMrCHd);
				} else if (awhTuwiq instanceof File) {
					KImfnQ6D = new FileReader((File) awhTuwiq);
					copy(KImfnQ6D, uRHMrCHd);
				} else if (awhTuwiq instanceof URL) {
					copy(((URL) awhTuwiq).openStream(), uRHMrCHd);
				} else if (awhTuwiq instanceof InputStream) {
					KImfnQ6D = new InputStreamReader((InputStream) awhTuwiq);
					copy(KImfnQ6D, uRHMrCHd);
				} else if (awhTuwiq instanceof RandomAccessFile) {
					copy((RandomAccessFile) awhTuwiq, uRHMrCHd);
				} else {
					throw new TypeError("Invalid first argument to copy()");
				}
			} else if (CgL04XlF instanceof OutputStream) {
				zbqsgsZP = (OutputStream) CgL04XlF;
				if (awhTuwiq instanceof Reader) {
					copy((Reader) awhTuwiq, new OutputStreamWriter(zbqsgsZP));
				} else if (awhTuwiq instanceof String) {
					en2uVLBc = new FileInputStream(new File((String) awhTuwiq));
					copy(en2uVLBc, zbqsgsZP);
				} else if (awhTuwiq instanceof File) {
					en2uVLBc = new FileInputStream((File) awhTuwiq);
					copy(en2uVLBc, zbqsgsZP);
				} else if (awhTuwiq instanceof URL) {
					copy(((URL) awhTuwiq).openStream(), zbqsgsZP);
				} else if (awhTuwiq instanceof InputStream) {
					copy((InputStream) awhTuwiq, zbqsgsZP);
				} else if (awhTuwiq instanceof RandomAccessFile) {
					copy((RandomAccessFile) awhTuwiq, zbqsgsZP);
				} else {
					throw new TypeError("Invalid first argument to copy()");
				}
			} else if (CgL04XlF instanceof RandomAccessFile) {
				RandomAccessFile uNbfBiOW = (RandomAccessFile) CgL04XlF;
				if (awhTuwiq instanceof Reader) {
					copy((Reader) awhTuwiq, uNbfBiOW);
				} else if (awhTuwiq instanceof String) {
					en2uVLBc = new FileInputStream(new File((String) awhTuwiq));
					copy(en2uVLBc, uNbfBiOW);
				} else if (awhTuwiq instanceof File) {
					en2uVLBc = new FileInputStream((File) awhTuwiq);
					copy(en2uVLBc, uNbfBiOW);
				} else if (awhTuwiq instanceof URL) {
					copy(((URL) awhTuwiq).openStream(), uNbfBiOW);
				} else if (awhTuwiq instanceof InputStream) {
					copy((InputStream) awhTuwiq, uNbfBiOW);
				} else if (awhTuwiq instanceof RandomAccessFile) {
					copy((RandomAccessFile) awhTuwiq, uNbfBiOW);
				} else {
					throw new TypeError("Invalid first argument to copy()");
				}
			} else if (CgL04XlF instanceof File || CgL04XlF instanceof String) {
				File QezJmeVx = null;
				if (CgL04XlF instanceof File) {
					QezJmeVx = (File) CgL04XlF;
				} else {
					QezJmeVx = new File((String) CgL04XlF);
				}
				zbqsgsZP = new FileOutputStream(QezJmeVx);
				if (awhTuwiq instanceof Reader) {
					copy((Reader) awhTuwiq, new OutputStreamWriter(zbqsgsZP));
				} else if (awhTuwiq instanceof String) {
					en2uVLBc = new FileInputStream(new File((String) awhTuwiq));
					copy(en2uVLBc, zbqsgsZP);
				} else if (awhTuwiq instanceof File) {
					en2uVLBc = new FileInputStream((File) awhTuwiq);
					copy(en2uVLBc, zbqsgsZP);
				} else if (awhTuwiq instanceof URL) {
					copy(((URL) awhTuwiq).openStream(), zbqsgsZP);
				} else if (awhTuwiq instanceof InputStream) {
					copy((InputStream) awhTuwiq, zbqsgsZP);
				} else if (awhTuwiq instanceof RandomAccessFile) {
					copy((RandomAccessFile) awhTuwiq, zbqsgsZP);
				} else {
					throw new TypeError("Invalid first argument to copy()");
				}
			} else {
				throw new TypeError("Invalid second argument to copy()");
			}
		} catch (IOException IhM1WjRy) {
			throw new IOError(IhM1WjRy.getMessage(), IhM1WjRy);
		}
	}

}
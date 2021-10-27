class n653371 {
	public void convert(File jLYCTUAT, File h3CsH2xK) throws IOException {
		InputStream lTOGLQta = new BufferedInputStream(new FileInputStream(jLYCTUAT));
		DcmParser Qtn5pxLa = pfact.newDcmParser(lTOGLQta);
		Dataset l60O0KsX = fact.newDataset();
		Qtn5pxLa.setDcmHandler(l60O0KsX.getDcmHandler());
		try {
			FileFormat JsMPAdxo = Qtn5pxLa.detectFileFormat();
			if (JsMPAdxo != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + jLYCTUAT + ": not an ACRNEMA stream!");
				return;
			}
			Qtn5pxLa.parseDcmFile(JsMPAdxo, Tags.PixelData);
			if (l60O0KsX.contains(Tags.StudyInstanceUID) || l60O0KsX.contains(Tags.SeriesInstanceUID)
					|| l60O0KsX.contains(Tags.SOPInstanceUID) || l60O0KsX.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + jLYCTUAT + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean zpepkoQE = Qtn5pxLa.getReadTag() == Tags.PixelData;
			boolean XMnV4eNl = zpepkoQE && l60O0KsX.getInt(Tags.BitsAllocated, 0) == 12;
			int aAvG6CgH = Qtn5pxLa.getReadLength();
			if (zpepkoQE) {
				if (XMnV4eNl) {
					l60O0KsX.putUS(Tags.BitsAllocated, 16);
					aAvG6CgH = aAvG6CgH * 4 / 3;
				}
				if (aAvG6CgH != (l60O0KsX.getInt(Tags.BitsAllocated, 0) >>> 3) * l60O0KsX.getInt(Tags.Rows, 0)
						* l60O0KsX.getInt(Tags.Columns, 0) * l60O0KsX.getInt(Tags.NumberOfFrames, 1)
						* l60O0KsX.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + jLYCTUAT + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			l60O0KsX.putUI(Tags.StudyInstanceUID, uid(studyUID));
			l60O0KsX.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			l60O0KsX.putUI(Tags.SOPInstanceUID, uid(instUID));
			l60O0KsX.putUI(Tags.SOPClassUID, classUID);
			if (!l60O0KsX.contains(Tags.NumberOfSamples)) {
				l60O0KsX.putUS(Tags.NumberOfSamples, 1);
			}
			if (!l60O0KsX.contains(Tags.PhotometricInterpretation)) {
				l60O0KsX.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				l60O0KsX.setFileMetaInfo(fact.newFileMetaInfo(l60O0KsX, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream XgRi9Eox = new BufferedOutputStream(new FileOutputStream(h3CsH2xK));
			try {
			} finally {
				l60O0KsX.writeFile(XgRi9Eox, encodeParam());
				if (zpepkoQE) {
					if (!skipGroupLen) {
						XgRi9Eox.write(PXDATA_GROUPLEN);
						int ccKCFvQJ = aAvG6CgH + 8;
						XgRi9Eox.write((byte) ccKCFvQJ);
						XgRi9Eox.write((byte) (ccKCFvQJ >> 8));
						XgRi9Eox.write((byte) (ccKCFvQJ >> 16));
						XgRi9Eox.write((byte) (ccKCFvQJ >> 24));
					}
					XgRi9Eox.write(PXDATA_TAG);
					XgRi9Eox.write((byte) aAvG6CgH);
					XgRi9Eox.write((byte) (aAvG6CgH >> 8));
					XgRi9Eox.write((byte) (aAvG6CgH >> 16));
					XgRi9Eox.write((byte) (aAvG6CgH >> 24));
				}
				if (XMnV4eNl) {
					int ljqeVf1X, xHyWibuW;
					for (; aAvG6CgH > 0; aAvG6CgH -= 3) {
						XgRi9Eox.write(lTOGLQta.read());
						ljqeVf1X = lTOGLQta.read();
						xHyWibuW = lTOGLQta.read();
						XgRi9Eox.write(ljqeVf1X & 0x0f);
						XgRi9Eox.write(ljqeVf1X >> 4 | ((xHyWibuW & 0x0f) << 4));
						XgRi9Eox.write(xHyWibuW >> 4);
					}
				} else {
					for (; aAvG6CgH > 0; --aAvG6CgH) {
						XgRi9Eox.write(lTOGLQta.read());
					}
				}
				XgRi9Eox.close();
			}
			System.out.print('.');
		} finally {
			lTOGLQta.close();
		}
	}

}
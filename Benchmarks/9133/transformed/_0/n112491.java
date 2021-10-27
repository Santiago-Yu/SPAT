class n112491 {
	public void convert(File tuCwj7wn, File g0ZPx2sS) throws IOException {
		InputStream rvTGgN6P = new BufferedInputStream(new FileInputStream(tuCwj7wn));
		DcmParser a16qXLdQ = pfact.newDcmParser(rvTGgN6P);
		Dataset jwc5dVt4 = fact.newDataset();
		a16qXLdQ.setDcmHandler(jwc5dVt4.getDcmHandler());
		try {
			FileFormat lgCk6Krf = a16qXLdQ.detectFileFormat();
			if (lgCk6Krf != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + tuCwj7wn + ": not an ACRNEMA stream!");
				return;
			}
			a16qXLdQ.parseDcmFile(lgCk6Krf, Tags.PixelData);
			if (jwc5dVt4.contains(Tags.StudyInstanceUID) || jwc5dVt4.contains(Tags.SeriesInstanceUID)
					|| jwc5dVt4.contains(Tags.SOPInstanceUID) || jwc5dVt4.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + tuCwj7wn + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean FZEzfHaX = a16qXLdQ.getReadTag() == Tags.PixelData;
			boolean SMnXANhl = FZEzfHaX && jwc5dVt4.getInt(Tags.BitsAllocated, 0) == 12;
			int kNP0KRTV = a16qXLdQ.getReadLength();
			if (FZEzfHaX) {
				if (SMnXANhl) {
					jwc5dVt4.putUS(Tags.BitsAllocated, 16);
					kNP0KRTV = kNP0KRTV * 4 / 3;
				}
				if (kNP0KRTV != (jwc5dVt4.getInt(Tags.BitsAllocated, 0) >>> 3) * jwc5dVt4.getInt(Tags.Rows, 0)
						* jwc5dVt4.getInt(Tags.Columns, 0) * jwc5dVt4.getInt(Tags.NumberOfFrames, 1)
						* jwc5dVt4.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + tuCwj7wn + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			jwc5dVt4.putUI(Tags.StudyInstanceUID, uid(studyUID));
			jwc5dVt4.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			jwc5dVt4.putUI(Tags.SOPInstanceUID, uid(instUID));
			jwc5dVt4.putUI(Tags.SOPClassUID, classUID);
			if (!jwc5dVt4.contains(Tags.NumberOfSamples)) {
				jwc5dVt4.putUS(Tags.NumberOfSamples, 1);
			}
			if (!jwc5dVt4.contains(Tags.PhotometricInterpretation)) {
				jwc5dVt4.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				jwc5dVt4.setFileMetaInfo(fact.newFileMetaInfo(jwc5dVt4, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream cp1THnzq = new BufferedOutputStream(new FileOutputStream(g0ZPx2sS));
			try {
			} finally {
				jwc5dVt4.writeFile(cp1THnzq, encodeParam());
				if (FZEzfHaX) {
					if (!skipGroupLen) {
						cp1THnzq.write(PXDATA_GROUPLEN);
						int ghLxOgpS = kNP0KRTV + 8;
						cp1THnzq.write((byte) ghLxOgpS);
						cp1THnzq.write((byte) (ghLxOgpS >> 8));
						cp1THnzq.write((byte) (ghLxOgpS >> 16));
						cp1THnzq.write((byte) (ghLxOgpS >> 24));
					}
					cp1THnzq.write(PXDATA_TAG);
					cp1THnzq.write((byte) kNP0KRTV);
					cp1THnzq.write((byte) (kNP0KRTV >> 8));
					cp1THnzq.write((byte) (kNP0KRTV >> 16));
					cp1THnzq.write((byte) (kNP0KRTV >> 24));
				}
				if (SMnXANhl) {
					int Qq1DoIzG, AgLkhM9x;
					for (; kNP0KRTV > 0; kNP0KRTV -= 3) {
						cp1THnzq.write(rvTGgN6P.read());
						Qq1DoIzG = rvTGgN6P.read();
						AgLkhM9x = rvTGgN6P.read();
						cp1THnzq.write(Qq1DoIzG & 0x0f);
						cp1THnzq.write(Qq1DoIzG >> 4 | ((AgLkhM9x & 0x0f) << 4));
						cp1THnzq.write(AgLkhM9x >> 4);
					}
				} else {
					for (; kNP0KRTV > 0; --kNP0KRTV) {
						cp1THnzq.write(rvTGgN6P.read());
					}
				}
				cp1THnzq.close();
			}
			System.out.print('.');
		} finally {
			rvTGgN6P.close();
		}
	}

}
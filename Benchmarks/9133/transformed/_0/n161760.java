class n161760 {
	public void convert(File aGrRefEH, File XVSBXQCy) throws IOException {
		InputStream Of9RLc35 = new BufferedInputStream(new FileInputStream(aGrRefEH));
		DcmParser nVFMftAd = pfact.newDcmParser(Of9RLc35);
		Dataset N3XUCPaJ = fact.newDataset();
		nVFMftAd.setDcmHandler(N3XUCPaJ.getDcmHandler());
		try {
			FileFormat SInrnz4u = nVFMftAd.detectFileFormat();
			if (SInrnz4u != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + aGrRefEH + ": not an ACRNEMA stream!");
				return;
			}
			nVFMftAd.parseDcmFile(SInrnz4u, Tags.PixelData);
			if (N3XUCPaJ.contains(Tags.StudyInstanceUID) || N3XUCPaJ.contains(Tags.SeriesInstanceUID)
					|| N3XUCPaJ.contains(Tags.SOPInstanceUID) || N3XUCPaJ.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + aGrRefEH + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean akSdKsOY = nVFMftAd.getReadTag() == Tags.PixelData;
			boolean PCrS7usy = akSdKsOY && N3XUCPaJ.getInt(Tags.BitsAllocated, 0) == 12;
			int hYCnGKj7 = nVFMftAd.getReadLength();
			if (akSdKsOY) {
				if (PCrS7usy) {
					N3XUCPaJ.putUS(Tags.BitsAllocated, 16);
					hYCnGKj7 = hYCnGKj7 * 4 / 3;
				}
				if (hYCnGKj7 != (N3XUCPaJ.getInt(Tags.BitsAllocated, 0) >>> 3) * N3XUCPaJ.getInt(Tags.Rows, 0)
						* N3XUCPaJ.getInt(Tags.Columns, 0) * N3XUCPaJ.getInt(Tags.NumberOfFrames, 1)
						* N3XUCPaJ.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + aGrRefEH + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			N3XUCPaJ.putUI(Tags.StudyInstanceUID, uid(studyUID));
			N3XUCPaJ.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			N3XUCPaJ.putUI(Tags.SOPInstanceUID, uid(instUID));
			N3XUCPaJ.putUI(Tags.SOPClassUID, classUID);
			if (!N3XUCPaJ.contains(Tags.NumberOfSamples)) {
				N3XUCPaJ.putUS(Tags.NumberOfSamples, 1);
			}
			if (!N3XUCPaJ.contains(Tags.PhotometricInterpretation)) {
				N3XUCPaJ.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				N3XUCPaJ.setFileMetaInfo(fact.newFileMetaInfo(N3XUCPaJ, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream iiteaRrg = new BufferedOutputStream(new FileOutputStream(XVSBXQCy));
			try {
			} finally {
				N3XUCPaJ.writeFile(iiteaRrg, encodeParam());
				if (akSdKsOY) {
					if (!skipGroupLen) {
						iiteaRrg.write(PXDATA_GROUPLEN);
						int X8wpJz9s = hYCnGKj7 + 8;
						iiteaRrg.write((byte) X8wpJz9s);
						iiteaRrg.write((byte) (X8wpJz9s >> 8));
						iiteaRrg.write((byte) (X8wpJz9s >> 16));
						iiteaRrg.write((byte) (X8wpJz9s >> 24));
					}
					iiteaRrg.write(PXDATA_TAG);
					iiteaRrg.write((byte) hYCnGKj7);
					iiteaRrg.write((byte) (hYCnGKj7 >> 8));
					iiteaRrg.write((byte) (hYCnGKj7 >> 16));
					iiteaRrg.write((byte) (hYCnGKj7 >> 24));
				}
				if (PCrS7usy) {
					int fHikKC6c, BzqdntLh;
					for (; hYCnGKj7 > 0; hYCnGKj7 -= 3) {
						iiteaRrg.write(Of9RLc35.read());
						fHikKC6c = Of9RLc35.read();
						BzqdntLh = Of9RLc35.read();
						iiteaRrg.write(fHikKC6c & 0x0f);
						iiteaRrg.write(fHikKC6c >> 4 | ((BzqdntLh & 0x0f) << 4));
						iiteaRrg.write(BzqdntLh >> 4);
					}
				} else {
					for (; hYCnGKj7 > 0; --hYCnGKj7) {
						iiteaRrg.write(Of9RLc35.read());
					}
				}
				iiteaRrg.close();
			}
			System.out.print('.');
		} finally {
			Of9RLc35.close();
		}
	}

}
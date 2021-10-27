class n922476 {
	public void convert(File htd8nJlc, File F8tIKLoq) throws IOException {
		InputStream B3BG103L = new BufferedInputStream(new FileInputStream(htd8nJlc));
		DcmParser J5ylwV2l = pfact.newDcmParser(B3BG103L);
		Dataset DuOgHzdn = fact.newDataset();
		J5ylwV2l.setDcmHandler(DuOgHzdn.getDcmHandler());
		try {
			FileFormat DerLkgkj = J5ylwV2l.detectFileFormat();
			if (DerLkgkj != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + htd8nJlc + ": not an ACRNEMA stream!");
				return;
			}
			J5ylwV2l.parseDcmFile(DerLkgkj, Tags.PixelData);
			if (DuOgHzdn.contains(Tags.StudyInstanceUID) || DuOgHzdn.contains(Tags.SeriesInstanceUID)
					|| DuOgHzdn.contains(Tags.SOPInstanceUID) || DuOgHzdn.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + htd8nJlc + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean VI33Y5Mo = J5ylwV2l.getReadTag() == Tags.PixelData;
			boolean tf9t623N = VI33Y5Mo && DuOgHzdn.getInt(Tags.BitsAllocated, 0) == 12;
			int VUZhoSOG = J5ylwV2l.getReadLength();
			if (VI33Y5Mo) {
				if (tf9t623N) {
					DuOgHzdn.putUS(Tags.BitsAllocated, 16);
					VUZhoSOG = VUZhoSOG * 4 / 3;
				}
				if (VUZhoSOG != (DuOgHzdn.getInt(Tags.BitsAllocated, 0) >>> 3) * DuOgHzdn.getInt(Tags.Rows, 0)
						* DuOgHzdn.getInt(Tags.Columns, 0) * DuOgHzdn.getInt(Tags.NumberOfFrames, 1)
						* DuOgHzdn.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + htd8nJlc + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			DuOgHzdn.putUI(Tags.StudyInstanceUID, uid(studyUID));
			DuOgHzdn.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			DuOgHzdn.putUI(Tags.SOPInstanceUID, uid(instUID));
			DuOgHzdn.putUI(Tags.SOPClassUID, classUID);
			if (!DuOgHzdn.contains(Tags.NumberOfSamples)) {
				DuOgHzdn.putUS(Tags.NumberOfSamples, 1);
			}
			if (!DuOgHzdn.contains(Tags.PhotometricInterpretation)) {
				DuOgHzdn.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				DuOgHzdn.setFileMetaInfo(fact.newFileMetaInfo(DuOgHzdn, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream fBi14LRd = new BufferedOutputStream(new FileOutputStream(F8tIKLoq));
			try {
			} finally {
				DuOgHzdn.writeFile(fBi14LRd, encodeParam());
				if (VI33Y5Mo) {
					if (!skipGroupLen) {
						fBi14LRd.write(PXDATA_GROUPLEN);
						int fj7vT6XS = VUZhoSOG + 8;
						fBi14LRd.write((byte) fj7vT6XS);
						fBi14LRd.write((byte) (fj7vT6XS >> 8));
						fBi14LRd.write((byte) (fj7vT6XS >> 16));
						fBi14LRd.write((byte) (fj7vT6XS >> 24));
					}
					fBi14LRd.write(PXDATA_TAG);
					fBi14LRd.write((byte) VUZhoSOG);
					fBi14LRd.write((byte) (VUZhoSOG >> 8));
					fBi14LRd.write((byte) (VUZhoSOG >> 16));
					fBi14LRd.write((byte) (VUZhoSOG >> 24));
				}
				if (tf9t623N) {
					int olyAwqQM, AWAeYjoZ;
					for (; VUZhoSOG > 0; VUZhoSOG -= 3) {
						fBi14LRd.write(B3BG103L.read());
						olyAwqQM = B3BG103L.read();
						AWAeYjoZ = B3BG103L.read();
						fBi14LRd.write(olyAwqQM & 0x0f);
						fBi14LRd.write(olyAwqQM >> 4 | ((AWAeYjoZ & 0x0f) << 4));
						fBi14LRd.write(AWAeYjoZ >> 4);
					}
				} else {
					for (; VUZhoSOG > 0; --VUZhoSOG) {
						fBi14LRd.write(B3BG103L.read());
					}
				}
				fBi14LRd.close();
			}
			System.out.print('.');
		} finally {
			B3BG103L.close();
		}
	}

}
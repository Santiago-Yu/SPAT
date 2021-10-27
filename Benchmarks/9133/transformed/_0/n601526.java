class n601526 {
	public void convert(File qdMpzf28, File f2utPnS7) throws IOException {
		InputStream lhd1E5tX = new BufferedInputStream(new FileInputStream(qdMpzf28));
		DcmParser gf9BXIEl = pfact.newDcmParser(lhd1E5tX);
		Dataset zfmTI1xe = fact.newDataset();
		gf9BXIEl.setDcmHandler(zfmTI1xe.getDcmHandler());
		try {
			FileFormat D2TwwOHR = gf9BXIEl.detectFileFormat();
			if (D2TwwOHR != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + qdMpzf28 + ": not an ACRNEMA stream!");
				return;
			}
			gf9BXIEl.parseDcmFile(D2TwwOHR, Tags.PixelData);
			if (zfmTI1xe.contains(Tags.StudyInstanceUID) || zfmTI1xe.contains(Tags.SeriesInstanceUID)
					|| zfmTI1xe.contains(Tags.SOPInstanceUID) || zfmTI1xe.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + qdMpzf28 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean nqEtvNB3 = gf9BXIEl.getReadTag() == Tags.PixelData;
			boolean LzQ9svIw = nqEtvNB3 && zfmTI1xe.getInt(Tags.BitsAllocated, 0) == 12;
			int OpCRDF3Y = gf9BXIEl.getReadLength();
			if (nqEtvNB3) {
				if (LzQ9svIw) {
					zfmTI1xe.putUS(Tags.BitsAllocated, 16);
					OpCRDF3Y = OpCRDF3Y * 4 / 3;
				}
				if (OpCRDF3Y != (zfmTI1xe.getInt(Tags.BitsAllocated, 0) >>> 3) * zfmTI1xe.getInt(Tags.Rows, 0)
						* zfmTI1xe.getInt(Tags.Columns, 0) * zfmTI1xe.getInt(Tags.NumberOfFrames, 1)
						* zfmTI1xe.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + qdMpzf28 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			zfmTI1xe.putUI(Tags.StudyInstanceUID, uid(studyUID));
			zfmTI1xe.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			zfmTI1xe.putUI(Tags.SOPInstanceUID, uid(instUID));
			zfmTI1xe.putUI(Tags.SOPClassUID, classUID);
			if (!zfmTI1xe.contains(Tags.NumberOfSamples)) {
				zfmTI1xe.putUS(Tags.NumberOfSamples, 1);
			}
			if (!zfmTI1xe.contains(Tags.PhotometricInterpretation)) {
				zfmTI1xe.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				zfmTI1xe.setFileMetaInfo(fact.newFileMetaInfo(zfmTI1xe, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream BYMvBTOX = new BufferedOutputStream(new FileOutputStream(f2utPnS7));
			try {
			} finally {
				zfmTI1xe.writeFile(BYMvBTOX, encodeParam());
				if (nqEtvNB3) {
					if (!skipGroupLen) {
						BYMvBTOX.write(PXDATA_GROUPLEN);
						int oIVOee5h = OpCRDF3Y + 8;
						BYMvBTOX.write((byte) oIVOee5h);
						BYMvBTOX.write((byte) (oIVOee5h >> 8));
						BYMvBTOX.write((byte) (oIVOee5h >> 16));
						BYMvBTOX.write((byte) (oIVOee5h >> 24));
					}
					BYMvBTOX.write(PXDATA_TAG);
					BYMvBTOX.write((byte) OpCRDF3Y);
					BYMvBTOX.write((byte) (OpCRDF3Y >> 8));
					BYMvBTOX.write((byte) (OpCRDF3Y >> 16));
					BYMvBTOX.write((byte) (OpCRDF3Y >> 24));
				}
				if (LzQ9svIw) {
					int dmUkLNTu, XIUJkJ3a;
					for (; OpCRDF3Y > 0; OpCRDF3Y -= 3) {
						BYMvBTOX.write(lhd1E5tX.read());
						dmUkLNTu = lhd1E5tX.read();
						XIUJkJ3a = lhd1E5tX.read();
						BYMvBTOX.write(dmUkLNTu & 0x0f);
						BYMvBTOX.write(dmUkLNTu >> 4 | ((XIUJkJ3a & 0x0f) << 4));
						BYMvBTOX.write(XIUJkJ3a >> 4);
					}
				} else {
					for (; OpCRDF3Y > 0; --OpCRDF3Y) {
						BYMvBTOX.write(lhd1E5tX.read());
					}
				}
				BYMvBTOX.close();
			}
			System.out.print('.');
		} finally {
			lhd1E5tX.close();
		}
	}

}
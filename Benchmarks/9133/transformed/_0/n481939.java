class n481939 {
	public void convert(File ABwpeB7s, File ctHbP1Zk) throws IOException {
		InputStream fKnRmESa = new BufferedInputStream(new FileInputStream(ABwpeB7s));
		DcmParser kIFrNr1n = pfact.newDcmParser(fKnRmESa);
		Dataset PeP6lhSa = fact.newDataset();
		kIFrNr1n.setDcmHandler(PeP6lhSa.getDcmHandler());
		try {
			FileFormat AqksEmSO = kIFrNr1n.detectFileFormat();
			if (AqksEmSO != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + ABwpeB7s + ": not an ACRNEMA stream!");
				return;
			}
			kIFrNr1n.parseDcmFile(AqksEmSO, Tags.PixelData);
			if (PeP6lhSa.contains(Tags.StudyInstanceUID) || PeP6lhSa.contains(Tags.SeriesInstanceUID)
					|| PeP6lhSa.contains(Tags.SOPInstanceUID) || PeP6lhSa.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + ABwpeB7s + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean OFCrQ5Ng = kIFrNr1n.getReadTag() == Tags.PixelData;
			boolean tqoRc5l7 = OFCrQ5Ng && PeP6lhSa.getInt(Tags.BitsAllocated, 0) == 12;
			int nqMpwM2K = kIFrNr1n.getReadLength();
			if (OFCrQ5Ng) {
				if (tqoRc5l7) {
					PeP6lhSa.putUS(Tags.BitsAllocated, 16);
					nqMpwM2K = nqMpwM2K * 4 / 3;
				}
				if (nqMpwM2K != (PeP6lhSa.getInt(Tags.BitsAllocated, 0) >>> 3) * PeP6lhSa.getInt(Tags.Rows, 0)
						* PeP6lhSa.getInt(Tags.Columns, 0) * PeP6lhSa.getInt(Tags.NumberOfFrames, 1)
						* PeP6lhSa.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + ABwpeB7s + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			PeP6lhSa.putUI(Tags.StudyInstanceUID, uid(studyUID));
			PeP6lhSa.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			PeP6lhSa.putUI(Tags.SOPInstanceUID, uid(instUID));
			PeP6lhSa.putUI(Tags.SOPClassUID, classUID);
			if (!PeP6lhSa.contains(Tags.NumberOfSamples)) {
				PeP6lhSa.putUS(Tags.NumberOfSamples, 1);
			}
			if (!PeP6lhSa.contains(Tags.PhotometricInterpretation)) {
				PeP6lhSa.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				PeP6lhSa.setFileMetaInfo(fact.newFileMetaInfo(PeP6lhSa, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream lNjoZv2Q = new BufferedOutputStream(new FileOutputStream(ctHbP1Zk));
			try {
			} finally {
				PeP6lhSa.writeFile(lNjoZv2Q, encodeParam());
				if (OFCrQ5Ng) {
					if (!skipGroupLen) {
						lNjoZv2Q.write(PXDATA_GROUPLEN);
						int jz4iYvw7 = nqMpwM2K + 8;
						lNjoZv2Q.write((byte) jz4iYvw7);
						lNjoZv2Q.write((byte) (jz4iYvw7 >> 8));
						lNjoZv2Q.write((byte) (jz4iYvw7 >> 16));
						lNjoZv2Q.write((byte) (jz4iYvw7 >> 24));
					}
					lNjoZv2Q.write(PXDATA_TAG);
					lNjoZv2Q.write((byte) nqMpwM2K);
					lNjoZv2Q.write((byte) (nqMpwM2K >> 8));
					lNjoZv2Q.write((byte) (nqMpwM2K >> 16));
					lNjoZv2Q.write((byte) (nqMpwM2K >> 24));
				}
				if (tqoRc5l7) {
					int lQF7ozN4, K2j0Ql1E;
					for (; nqMpwM2K > 0; nqMpwM2K -= 3) {
						lNjoZv2Q.write(fKnRmESa.read());
						lQF7ozN4 = fKnRmESa.read();
						K2j0Ql1E = fKnRmESa.read();
						lNjoZv2Q.write(lQF7ozN4 & 0x0f);
						lNjoZv2Q.write(lQF7ozN4 >> 4 | ((K2j0Ql1E & 0x0f) << 4));
						lNjoZv2Q.write(K2j0Ql1E >> 4);
					}
				} else {
					for (; nqMpwM2K > 0; --nqMpwM2K) {
						lNjoZv2Q.write(fKnRmESa.read());
					}
				}
				lNjoZv2Q.close();
			}
			System.out.print('.');
		} finally {
			fKnRmESa.close();
		}
	}

}
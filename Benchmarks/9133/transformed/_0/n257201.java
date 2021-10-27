class n257201 {
	public void convert(File De9kkZ5f, File dfzCYziL) throws IOException {
		InputStream dNlpfVb2 = new BufferedInputStream(new FileInputStream(De9kkZ5f));
		DcmParser eQHZKmGS = pfact.newDcmParser(dNlpfVb2);
		Dataset Hl8owzAP = fact.newDataset();
		eQHZKmGS.setDcmHandler(Hl8owzAP.getDcmHandler());
		try {
			FileFormat agj6xTvM = eQHZKmGS.detectFileFormat();
			if (agj6xTvM != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + De9kkZ5f + ": not an ACRNEMA stream!");
				return;
			}
			eQHZKmGS.parseDcmFile(agj6xTvM, Tags.PixelData);
			if (Hl8owzAP.contains(Tags.StudyInstanceUID) || Hl8owzAP.contains(Tags.SeriesInstanceUID)
					|| Hl8owzAP.contains(Tags.SOPInstanceUID) || Hl8owzAP.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + De9kkZ5f + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Zdb7jcXg = eQHZKmGS.getReadTag() == Tags.PixelData;
			boolean aeutQQPx = Zdb7jcXg && Hl8owzAP.getInt(Tags.BitsAllocated, 0) == 12;
			int KRR7Z9Mt = eQHZKmGS.getReadLength();
			if (Zdb7jcXg) {
				if (aeutQQPx) {
					Hl8owzAP.putUS(Tags.BitsAllocated, 16);
					KRR7Z9Mt = KRR7Z9Mt * 4 / 3;
				}
				if (KRR7Z9Mt != (Hl8owzAP.getInt(Tags.BitsAllocated, 0) >>> 3) * Hl8owzAP.getInt(Tags.Rows, 0)
						* Hl8owzAP.getInt(Tags.Columns, 0) * Hl8owzAP.getInt(Tags.NumberOfFrames, 1)
						* Hl8owzAP.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + De9kkZ5f + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			Hl8owzAP.putUI(Tags.StudyInstanceUID, uid(studyUID));
			Hl8owzAP.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			Hl8owzAP.putUI(Tags.SOPInstanceUID, uid(instUID));
			Hl8owzAP.putUI(Tags.SOPClassUID, classUID);
			if (!Hl8owzAP.contains(Tags.NumberOfSamples)) {
				Hl8owzAP.putUS(Tags.NumberOfSamples, 1);
			}
			if (!Hl8owzAP.contains(Tags.PhotometricInterpretation)) {
				Hl8owzAP.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				Hl8owzAP.setFileMetaInfo(fact.newFileMetaInfo(Hl8owzAP, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream S3iw9LpJ = new BufferedOutputStream(new FileOutputStream(dfzCYziL));
			try {
			} finally {
				Hl8owzAP.writeFile(S3iw9LpJ, encodeParam());
				if (Zdb7jcXg) {
					if (!skipGroupLen) {
						S3iw9LpJ.write(PXDATA_GROUPLEN);
						int GpCcz04k = KRR7Z9Mt + 8;
						S3iw9LpJ.write((byte) GpCcz04k);
						S3iw9LpJ.write((byte) (GpCcz04k >> 8));
						S3iw9LpJ.write((byte) (GpCcz04k >> 16));
						S3iw9LpJ.write((byte) (GpCcz04k >> 24));
					}
					S3iw9LpJ.write(PXDATA_TAG);
					S3iw9LpJ.write((byte) KRR7Z9Mt);
					S3iw9LpJ.write((byte) (KRR7Z9Mt >> 8));
					S3iw9LpJ.write((byte) (KRR7Z9Mt >> 16));
					S3iw9LpJ.write((byte) (KRR7Z9Mt >> 24));
				}
				if (aeutQQPx) {
					int NG47EWzH, CQ2faPTb;
					for (; KRR7Z9Mt > 0; KRR7Z9Mt -= 3) {
						S3iw9LpJ.write(dNlpfVb2.read());
						NG47EWzH = dNlpfVb2.read();
						CQ2faPTb = dNlpfVb2.read();
						S3iw9LpJ.write(NG47EWzH & 0x0f);
						S3iw9LpJ.write(NG47EWzH >> 4 | ((CQ2faPTb & 0x0f) << 4));
						S3iw9LpJ.write(CQ2faPTb >> 4);
					}
				} else {
					for (; KRR7Z9Mt > 0; --KRR7Z9Mt) {
						S3iw9LpJ.write(dNlpfVb2.read());
					}
				}
				S3iw9LpJ.close();
			}
			System.out.print('.');
		} finally {
			dNlpfVb2.close();
		}
	}

}
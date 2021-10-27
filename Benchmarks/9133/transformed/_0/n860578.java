class n860578 {
	public void convert(File oYIgj9SU, File ZcM4CFV3) throws IOException {
		InputStream dGmoB63Y = new BufferedInputStream(new FileInputStream(oYIgj9SU));
		DcmParser FcJPENI4 = pfact.newDcmParser(dGmoB63Y);
		Dataset XivLA81R = fact.newDataset();
		FcJPENI4.setDcmHandler(XivLA81R.getDcmHandler());
		try {
			FileFormat Pj0C2QNw = FcJPENI4.detectFileFormat();
			if (Pj0C2QNw != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + oYIgj9SU + ": not an ACRNEMA stream!");
				return;
			}
			FcJPENI4.parseDcmFile(Pj0C2QNw, Tags.PixelData);
			if (XivLA81R.contains(Tags.StudyInstanceUID) || XivLA81R.contains(Tags.SeriesInstanceUID)
					|| XivLA81R.contains(Tags.SOPInstanceUID) || XivLA81R.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + oYIgj9SU + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean oCT9XZHK = FcJPENI4.getReadTag() == Tags.PixelData;
			boolean KuDfphVo = oCT9XZHK && XivLA81R.getInt(Tags.BitsAllocated, 0) == 12;
			int dOLWDPwD = FcJPENI4.getReadLength();
			if (oCT9XZHK) {
				if (KuDfphVo) {
					XivLA81R.putUS(Tags.BitsAllocated, 16);
					dOLWDPwD = dOLWDPwD * 4 / 3;
				}
				if (dOLWDPwD != (XivLA81R.getInt(Tags.BitsAllocated, 0) >>> 3) * XivLA81R.getInt(Tags.Rows, 0)
						* XivLA81R.getInt(Tags.Columns, 0) * XivLA81R.getInt(Tags.NumberOfFrames, 1)
						* XivLA81R.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + oYIgj9SU + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			XivLA81R.putUI(Tags.StudyInstanceUID, uid(studyUID));
			XivLA81R.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			XivLA81R.putUI(Tags.SOPInstanceUID, uid(instUID));
			XivLA81R.putUI(Tags.SOPClassUID, classUID);
			if (!XivLA81R.contains(Tags.NumberOfSamples)) {
				XivLA81R.putUS(Tags.NumberOfSamples, 1);
			}
			if (!XivLA81R.contains(Tags.PhotometricInterpretation)) {
				XivLA81R.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				XivLA81R.setFileMetaInfo(fact.newFileMetaInfo(XivLA81R, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream g4n9cIhn = new BufferedOutputStream(new FileOutputStream(ZcM4CFV3));
			try {
			} finally {
				XivLA81R.writeFile(g4n9cIhn, encodeParam());
				if (oCT9XZHK) {
					if (!skipGroupLen) {
						g4n9cIhn.write(PXDATA_GROUPLEN);
						int vCN4zk5I = dOLWDPwD + 8;
						g4n9cIhn.write((byte) vCN4zk5I);
						g4n9cIhn.write((byte) (vCN4zk5I >> 8));
						g4n9cIhn.write((byte) (vCN4zk5I >> 16));
						g4n9cIhn.write((byte) (vCN4zk5I >> 24));
					}
					g4n9cIhn.write(PXDATA_TAG);
					g4n9cIhn.write((byte) dOLWDPwD);
					g4n9cIhn.write((byte) (dOLWDPwD >> 8));
					g4n9cIhn.write((byte) (dOLWDPwD >> 16));
					g4n9cIhn.write((byte) (dOLWDPwD >> 24));
				}
				if (KuDfphVo) {
					int YdvKQ0Jy, vIzTqqZA;
					for (; dOLWDPwD > 0; dOLWDPwD -= 3) {
						g4n9cIhn.write(dGmoB63Y.read());
						YdvKQ0Jy = dGmoB63Y.read();
						vIzTqqZA = dGmoB63Y.read();
						g4n9cIhn.write(YdvKQ0Jy & 0x0f);
						g4n9cIhn.write(YdvKQ0Jy >> 4 | ((vIzTqqZA & 0x0f) << 4));
						g4n9cIhn.write(vIzTqqZA >> 4);
					}
				} else {
					for (; dOLWDPwD > 0; --dOLWDPwD) {
						g4n9cIhn.write(dGmoB63Y.read());
					}
				}
				g4n9cIhn.close();
			}
			System.out.print('.');
		} finally {
			dGmoB63Y.close();
		}
	}

}
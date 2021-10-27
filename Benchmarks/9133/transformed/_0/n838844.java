class n838844 {
	public void convert(File FJkO1jcm, File KSukZ69S) throws IOException {
		InputStream zOYA2mxO = new BufferedInputStream(new FileInputStream(FJkO1jcm));
		DcmParser xHcVMr8F = pfact.newDcmParser(zOYA2mxO);
		Dataset oJzCFhGS = fact.newDataset();
		xHcVMr8F.setDcmHandler(oJzCFhGS.getDcmHandler());
		try {
			FileFormat wZnnaL8H = xHcVMr8F.detectFileFormat();
			if (wZnnaL8H != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + FJkO1jcm + ": not an ACRNEMA stream!");
				return;
			}
			xHcVMr8F.parseDcmFile(wZnnaL8H, Tags.PixelData);
			if (oJzCFhGS.contains(Tags.StudyInstanceUID) || oJzCFhGS.contains(Tags.SeriesInstanceUID)
					|| oJzCFhGS.contains(Tags.SOPInstanceUID) || oJzCFhGS.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + FJkO1jcm + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean MQniqJRW = xHcVMr8F.getReadTag() == Tags.PixelData;
			boolean y9c0h22Y = MQniqJRW && oJzCFhGS.getInt(Tags.BitsAllocated, 0) == 12;
			int UKn4NhUw = xHcVMr8F.getReadLength();
			if (MQniqJRW) {
				if (y9c0h22Y) {
					oJzCFhGS.putUS(Tags.BitsAllocated, 16);
					UKn4NhUw = UKn4NhUw * 4 / 3;
				}
				if (UKn4NhUw != (oJzCFhGS.getInt(Tags.BitsAllocated, 0) >>> 3) * oJzCFhGS.getInt(Tags.Rows, 0)
						* oJzCFhGS.getInt(Tags.Columns, 0) * oJzCFhGS.getInt(Tags.NumberOfFrames, 1)
						* oJzCFhGS.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + FJkO1jcm + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			oJzCFhGS.putUI(Tags.StudyInstanceUID, uid(studyUID));
			oJzCFhGS.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			oJzCFhGS.putUI(Tags.SOPInstanceUID, uid(instUID));
			oJzCFhGS.putUI(Tags.SOPClassUID, classUID);
			if (!oJzCFhGS.contains(Tags.NumberOfSamples)) {
				oJzCFhGS.putUS(Tags.NumberOfSamples, 1);
			}
			if (!oJzCFhGS.contains(Tags.PhotometricInterpretation)) {
				oJzCFhGS.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				oJzCFhGS.setFileMetaInfo(fact.newFileMetaInfo(oJzCFhGS, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream M6PS3yYv = new BufferedOutputStream(new FileOutputStream(KSukZ69S));
			try {
			} finally {
				oJzCFhGS.writeFile(M6PS3yYv, encodeParam());
				if (MQniqJRW) {
					if (!skipGroupLen) {
						M6PS3yYv.write(PXDATA_GROUPLEN);
						int FHGuRtH4 = UKn4NhUw + 8;
						M6PS3yYv.write((byte) FHGuRtH4);
						M6PS3yYv.write((byte) (FHGuRtH4 >> 8));
						M6PS3yYv.write((byte) (FHGuRtH4 >> 16));
						M6PS3yYv.write((byte) (FHGuRtH4 >> 24));
					}
					M6PS3yYv.write(PXDATA_TAG);
					M6PS3yYv.write((byte) UKn4NhUw);
					M6PS3yYv.write((byte) (UKn4NhUw >> 8));
					M6PS3yYv.write((byte) (UKn4NhUw >> 16));
					M6PS3yYv.write((byte) (UKn4NhUw >> 24));
				}
				if (y9c0h22Y) {
					int nwGFt7lp, Um8h4kUV;
					for (; UKn4NhUw > 0; UKn4NhUw -= 3) {
						M6PS3yYv.write(zOYA2mxO.read());
						nwGFt7lp = zOYA2mxO.read();
						Um8h4kUV = zOYA2mxO.read();
						M6PS3yYv.write(nwGFt7lp & 0x0f);
						M6PS3yYv.write(nwGFt7lp >> 4 | ((Um8h4kUV & 0x0f) << 4));
						M6PS3yYv.write(Um8h4kUV >> 4);
					}
				} else {
					for (; UKn4NhUw > 0; --UKn4NhUw) {
						M6PS3yYv.write(zOYA2mxO.read());
					}
				}
				M6PS3yYv.close();
			}
			System.out.print('.');
		} finally {
			zOYA2mxO.close();
		}
	}

}
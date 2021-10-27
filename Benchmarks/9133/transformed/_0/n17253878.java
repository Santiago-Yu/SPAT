class n17253878 {
	public void onUpload$btnFileUpload(UploadEvent HugfOrzh) {
		BufferedInputStream QHZf4A8z = null;
		BufferedOutputStream odQes66f = null;
		if (HugfOrzh == null) {
			System.out.println("unable to upload file");
			return;
		} else {
			System.out.println("fileUploaded()");
		}
		try {
			Media EcLEFM0E = HugfOrzh.getMedia();
			System.out.println("m.getContentType(): " + EcLEFM0E.getContentType());
			System.out.println("m.getFormat(): " + EcLEFM0E.getFormat());
			try {
				InputStream HqrgH7lt = EcLEFM0E.getStreamData();
				QHZf4A8z = new BufferedInputStream(HqrgH7lt);
				File rnvYGjkA = new File(UPLOAD_PATH);
				if (!rnvYGjkA.exists()) {
					rnvYGjkA.mkdirs();
				}
				final File Jyb1cEtO = new File(UPLOAD_PATH + EcLEFM0E.getName());
				OutputStream nxH6W6kK = new FileOutputStream(Jyb1cEtO);
				odQes66f = new BufferedOutputStream(nxH6W6kK);
				IOUtils.copy(QHZf4A8z, odQes66f);
				if (EcLEFM0E.getFormat().equals("zip") || EcLEFM0E.getFormat().equals("x-gzip")) {
					final String cSw96LPB = EcLEFM0E.getName();
					Messagebox.show("Archive file detected. Would you like to unzip this file?", "ALA Spatial Portal",
							Messagebox.YES + Messagebox.NO, Messagebox.QUESTION, new EventListener() {

								@Override
								public void onEvent(Event qGykQh4O) throws Exception {
									try {
										int lmKLLz4F = ((Integer) qGykQh4O.getData()).intValue();
										if (lmKLLz4F == Messagebox.YES) {
											System.out.println("unzipping file to: " + UPLOAD_PATH);
											boolean aQ0wxeOB = Zipper.unzipFile(cSw96LPB, new FileInputStream(Jyb1cEtO),
													UPLOAD_PATH, false);
											if (aQ0wxeOB) {
												Messagebox.show("File unzipped: '" + cSw96LPB + "'");
											} else {
												Messagebox.show("Unable to unzip '" + cSw96LPB + "' ");
											}
										} else {
											System.out.println("leaving archive file alone");
										}
									} catch (NumberFormatException TTwnmcoa) {
										System.out.println("Not a valid response");
									}
								}
							});
				} else {
					Messagebox.show("File '" + EcLEFM0E.getName() + "' successfully uploaded");
				}
			} catch (IOException ZdDvqlo2) {
				System.out.println("IO Exception while saving file: ");
				ZdDvqlo2.printStackTrace(System.out);
			} catch (Exception Gn7HrGLD) {
				System.out.println("General Exception: ");
				Gn7HrGLD.printStackTrace(System.out);
			} finally {
				try {
					if (odQes66f != null) {
						odQes66f.close();
					}
					if (QHZf4A8z != null) {
						QHZf4A8z.close();
					}
				} catch (IOException T8Nf9MLI) {
					System.out.println("IO Exception while closing stream: ");
					T8Nf9MLI.printStackTrace(System.out);
				}
			}
		} catch (Exception TVMOTgAC) {
			System.out.println("Error uploading file.");
			TVMOTgAC.printStackTrace(System.out);
		}
	}

}
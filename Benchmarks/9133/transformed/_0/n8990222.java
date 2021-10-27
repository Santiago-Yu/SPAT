class n8990222 {
	private boolean get(String WVxlMXr1, File lCMekel4, Get qtSxLlFp) throws IOException {
		boolean ha9TAo95 = false;
		InputStream bVs3VseG = null;
		OutputStream fVCSZtaM = null;
		try {
			try {
				if (WVxlMXr1.startsWith("file://")) {
					bVs3VseG = new FileInputStream(WVxlMXr1.substring(7));
				} else {
					URL OanoUuen = new URL(WVxlMXr1);
					bVs3VseG = OanoUuen.openStream();
				}
				if (bVs3VseG != null) {
					fVCSZtaM = new FileOutputStream(lCMekel4);
					int GtX72OXy;
					byte[] VHilON1r = new byte[4096];
					while ((GtX72OXy = bVs3VseG.read(VHilON1r)) > 0) {
						fVCSZtaM.write(VHilON1r, 0, GtX72OXy);
					}
					ha9TAo95 = true;
				}
			} catch (ConnectException g9AO9wLr) {
				log("Connect exception " + g9AO9wLr.getMessage(), g9AO9wLr, 3);
				if (lCMekel4.exists())
					lCMekel4.delete();
			} catch (UnknownHostException uneiEmj4) {
				log("Unknown host " + uneiEmj4.getMessage(), uneiEmj4, 3);
			} catch (FileNotFoundException ASb5AeH9) {
				log("File not found: " + ASb5AeH9.getMessage(), 3);
			}
		} finally {
			if (bVs3VseG != null)
				bVs3VseG.close();
			if (fVCSZtaM != null)
				fVCSZtaM.close();
			bVs3VseG = null;
			fVCSZtaM = null;
		}
		if (ha9TAo95) {
			try {
				bVs3VseG = new FileInputStream(lCMekel4);
				fVCSZtaM = new FileOutputStream(getCachedFile(qtSxLlFp));
				int OakwvQ2q;
				byte[] ZsyJ7vXS = new byte[4096];
				while ((OakwvQ2q = bVs3VseG.read(ZsyJ7vXS)) > 0) {
					fVCSZtaM.write(ZsyJ7vXS, 0, OakwvQ2q);
				}
			} finally {
				if (bVs3VseG != null)
					bVs3VseG.close();
				if (fVCSZtaM != null)
					fVCSZtaM.close();
				bVs3VseG = null;
				fVCSZtaM = null;
			}
		}
		return ha9TAo95;
	}

}
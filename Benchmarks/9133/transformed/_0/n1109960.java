class n1109960 {
	public void run() {
		logger.info("downloading '" + url.toString() + "' to: " + dstFile.getAbsolutePath());
		Preferences S7Tl6kuG = Preferences.userRoot().node("gvsig.downloader");
		int twaNda42 = S7Tl6kuG.getInt("timeout", 60000);
		DataOutputStream kWEONGQR;
		try {
			DataInputStream QAUYU8zQ;
			OutputStreamWriter JPJ4P4WL = null;
			HttpURLConnection bFhdBTfN = null;
			if (url.getProtocol().equals("https")) {
				disableHttsValidation();
			}
			bFhdBTfN = (HttpURLConnection) url.openConnection();
			bFhdBTfN.setConnectTimeout(twaNda42);
			if (data != null) {
				bFhdBTfN.setRequestProperty("SOAPAction", "post");
				bFhdBTfN.setRequestMethod("POST");
				bFhdBTfN.setDoOutput(true);
				bFhdBTfN.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
				JPJ4P4WL = new OutputStreamWriter(bFhdBTfN.getOutputStream());
				JPJ4P4WL.write(data);
				JPJ4P4WL.flush();
				QAUYU8zQ = new DataInputStream(bFhdBTfN.getInputStream());
			} else {
				QAUYU8zQ = new DataInputStream(url.openStream());
			}
			kWEONGQR = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dstFile)));
			byte[] KVl8w51i = new byte[1024 * 4];
			long vPHDf2KD = 0;
			for (int IQM70SqU = QAUYU8zQ.read(KVl8w51i); !Utilities.getCanceled(groupID)
					&& IQM70SqU > 0; IQM70SqU = QAUYU8zQ.read(KVl8w51i)) {
				kWEONGQR.write(KVl8w51i, 0, IQM70SqU);
				vPHDf2KD += IQM70SqU;
			}
			if (JPJ4P4WL != null) {
				JPJ4P4WL.close();
			}
			kWEONGQR.close();
			QAUYU8zQ.close();
			QAUYU8zQ = null;
			kWEONGQR = null;
			if (Utilities.getCanceled(groupID)) {
				logger.warning("[RemoteServices] '" + url + "' CANCELED.");
				dstFile.delete();
				dstFile = null;
			} else {
				Utilities.addDownloadedURL(url, dstFile.getAbsolutePath());
			}
		} catch (Exception hoMYRceh) {
			hoMYRceh.printStackTrace();
			Utilities.downloadException = hoMYRceh;
		}
	}

}
class n21493548 {
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			URL url = new URL(upgradeURL);
			InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream("");
			BufferedInputStream buffIn = new BufferedInputStream(in);
			int data = buffIn.read();
			String bytes = "";
			int downloadedByteCount = 1;
			while (data != -1) {
				out.write(data);
				bytes.concat(Character.toString((char) data));
				buffIn.read();
				downloadedByteCount++;
				updateProgressBar(downloadedByteCount);
			}
			out.close();
			buffIn.close();
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(bytes.getBytes());
			String hash = m.digest().toString();
			if (hash.length() == 31) {
				hash = "0" + hash;
			}
			if (!hash.equalsIgnoreCase(md5Hash)) {
			}
		} catch (MalformedURLException e) {
		} catch (IOException io) {
		} catch (NoSuchAlgorithmException a) {
		}
	}

}
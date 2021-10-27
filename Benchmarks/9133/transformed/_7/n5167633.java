class n5167633 {
	public static void download(String address, String localFileName, String rawClass, double newVer, int newStage) {
		OutputStream out = null;
		URLConnection conn = null;
		InputStream in = null;
		int totalBytes = 0;
		int dlBytes = 0;
		try {
			if (!Main.Updates.current.hasFile(rawClass)) {
				Main.Updates.current.addFile(newVer, newStage, rawClass);
			}
			Main.Updates.current.getFile(rawClass).downloading = true;
			Main.Updates.setImage(rawClass, "refresh.png");
			java.io.File folder = new java.io.File(localFileName);
			folder.createNewFile();
			URL url = new URL(address);
			out = new BufferedOutputStream(new FileOutputStream(localFileName));
			conn = url.openConnection();
			in = conn.getInputStream();
			totalBytes = conn.getContentLength();
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			double incr = java.lang.Math.floor(totalBytes / 1000);
			Main.Interface.Update.prgStatus.setMaximum(1000);
			Main.Interface.Update.prgStatus.setString("0.0%");
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten = numWritten + (numRead);
				dlBytes = dlBytes + (numRead);
				int newVal = (dlBytes != totalBytes ? (int) java.lang.Math.floor(dlBytes / incr) : 1000);
				Main.Interface.Update.prgStatus.setValue(newVal);
				Main.Interface.Update.prgStatus.setString((newVal / 10) + "." + (newVal % 10) + "%");
			}
			Main.Updates.current.getFile(rawClass).downloading = false;
			Main.Updates.current.getFile(rawClass).version = newVer;
			Main.Updates.current.getFile(rawClass).stage = newStage;
			Main.Updates.setImage(rawClass, "updater.png");
			Main.Updates.updateTable();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException ioe) {
			}
		}
	}

}
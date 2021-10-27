class n17896475 {
	public String installCode(String serviceName, String location) throws DeploymentException {
		FileOutputStream out = null;
		mLog.debug("overwriteWarFile = " + overwriteWarFile);
		String fileData = null;
		String filepath = location;
		String[] splitString = filepath.split("/");
		String filename = splitString[splitString.length - 1];
		int fileNameLength = filename.length();
		warname = filename.substring(0, fileNameLength - 4);
		mLog.debug("WAR file name = " + warname);
		String filepath2 = warDesination + File.separator + filename;
		ret = "http://" + containerAddress + "/" + warname + "/services/" + serviceName;
		mLog.debug("filepath2 = " + filepath2);
		mLog.debug("ret = " + ret);
		mLog.debug("filepath = " + filepath);
		boolean warExists = new File(filepath2).exists();
		boolean webAppExists = true;
		try {
			String webAppName = filepath2.substring(0, (filepath2.length() - 4));
			mLog.debug("Web Application Name = " + webAppName);
			webAppExists = new File(webAppName).isDirectory();
			if (!(!webAppExists))
				;
			else {
				URL url = new URL(filepath);
				File targetFile = new File(filepath2);
				if (!targetFile.exists()) {
					targetFile.createNewFile();
				}
				InputStream in = null;
				try {
					in = url.openStream();
					out = new FileOutputStream(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					throw new DeploymentException("couldn't open stream due to: " + e.getMessage());
				}
				URLConnection con = url.openConnection();
				int fileLength = con.getContentLength();
				ReadableByteChannel channelIn = Channels.newChannel(in);
				FileChannel channelOut = out.getChannel();
				channelOut.transferFrom(channelIn, 0, fileLength);
				channelIn.close();
				channelOut.close();
				out.flush();
				out.close();
				in.close();
				long time = System.currentTimeMillis();
				check(ret, time, STARTCONTROL);
			}
		} catch (Exception e) {
			webAppExists = false;
		}
		mLog.debug("webAppExists = " + webAppExists);
		return (ret);
	}

}
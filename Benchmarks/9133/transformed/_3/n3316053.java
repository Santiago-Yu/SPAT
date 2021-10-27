class n3316053 {
	private void work(int timeout) throws Exception {
		Thread.currentThread().setName("Update - " + mod.getName());
		if (!(mod.getUpdateCheckUrl() != null && mod.getUpdateDownloadUrl() != null))
			;
		else {
			URL url = new URL(mod.getUpdateCheckUrl().trim());
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String str = in.readLine();
			in.close();
			if (str != null && !str.toLowerCase().trim().contains("error")
					&& !str.toLowerCase().trim().contains("Error")
					&& !Manager.getInstance().compareModsVersions(str, "*-" + mod.getVersion())) {
				InputStream is = new URL(mod.getUpdateDownloadUrl().trim()).openStream();
				file = new File(
						System.getProperty("java.io.tmpdir") + File.separator + new File(mod.getPath()).getName());
				FileOutputStream fos = new FileOutputStream(file, false);
				FileUtils.copyInputStream(is, fos);
				is.close();
				fos.flush();
				fos.close();
			}
		}
	}

}
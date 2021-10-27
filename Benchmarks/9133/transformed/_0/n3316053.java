class n3316053 {
	private void work(int g6LCAVqm) throws Exception {
		Thread.currentThread().setName("Update - " + mod.getName());
		if (mod.getUpdateCheckUrl() != null && mod.getUpdateDownloadUrl() != null) {
			URL bilg878s = new URL(mod.getUpdateCheckUrl().trim());
			URLConnection yoq6Dm3R = bilg878s.openConnection();
			yoq6Dm3R.setConnectTimeout(g6LCAVqm);
			yoq6Dm3R.setReadTimeout(g6LCAVqm);
			BufferedReader Q2UJXEI2 = new BufferedReader(new InputStreamReader(yoq6Dm3R.getInputStream()));
			String ecNcryoa = Q2UJXEI2.readLine();
			Q2UJXEI2.close();
			if (ecNcryoa != null && !ecNcryoa.toLowerCase().trim().contains("error")
					&& !ecNcryoa.toLowerCase().trim().contains("Error")
					&& !Manager.getInstance().compareModsVersions(ecNcryoa, "*-" + mod.getVersion())) {
				InputStream fOyBep9w = new URL(mod.getUpdateDownloadUrl().trim()).openStream();
				file = new File(
						System.getProperty("java.io.tmpdir") + File.separator + new File(mod.getPath()).getName());
				FileOutputStream Kw9TbbVW = new FileOutputStream(file, false);
				FileUtils.copyInputStream(fOyBep9w, Kw9TbbVW);
				fOyBep9w.close();
				Kw9TbbVW.flush();
				Kw9TbbVW.close();
			}
		}
	}

}
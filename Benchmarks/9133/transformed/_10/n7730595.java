class n7730595 {
	public void appendFetch(IProgress progress, PrintWriter pw, String list, int from, int to) throws IOException {
		progress.start();
		try {
			File storage = new File(cacheDirectory.getValue(), "mboxes");
			storage.mkdirs();
			File mbox = new File(storage, list + "-" + from + "-" + to + ".mbox");
			if (mbox.exists()) {
				String line;
				BufferedReader in = new BufferedReader(
						new InputStreamReader(new ProgressInputStream(new FileInputStream(mbox), progress, 10000)));
				while ((line = in.readLine()) != null) {
					pw.write(line);
					pw.write('\n');
				}
				in.close();
				return;
			}
			progress.setScale(100);
			IProgress subProgress1 = progress.getSub(75);
			URL url = getGmaneURL(list, from, to);
			PrintWriter writeToMbox = new PrintWriter(mbox);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new ProgressInputStream(url.openStream(), subProgress1, 10000)));
			String line;
			int lines = 0;
			while ((line = in.readLine()) != null) {
				if (line.matches("^From .*$") && !line.matches("^From .*? .*[0-9][0-9]:[0-9][0-9]:[0-9][0-9].*$")) {
					line = ">" + line;
				}
				lines++;
				writeToMbox.write(line);
				writeToMbox.write('\n');
			}
			in.close();
			writeToMbox.close();
			appendFetch(progress.getSub(25), pw, list, from, to);
		} finally {
			progress.done();
		}
	}

}
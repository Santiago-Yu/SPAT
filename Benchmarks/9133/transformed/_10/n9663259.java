class n9663259 {
	private static void checkForUpgrade() {
		try {
			Log.out("Checking for updates...");
			URL u = ClassLoader.getSystemResource(Settings.readme);
			if (u == null) {
				u = HImage.class.getResource("/" + Settings.readme);
			}
			DataInputStream i = new DataInputStream(u.openStream());
			String tmp = i.readLine();
			tmp = tmp.substring(tmp.lastIndexOf(">"));
			tmp = tmp.substring(tmp.indexOf(".") + 1);
			tmp = tmp.substring(0, tmp.indexOf("<"));
			String nextVersion = "jftp-1.";
			int x = Integer.parseInt(tmp) + 1;
			if (x < 10) {
				nextVersion = nextVersion + "0";
			}
			nextVersion = nextVersion + x + ".tar.gz";
			File dl = new File(nextVersion);
			if (!dl.exists() || (dl.length() <= 0)) {
				BufferedOutputStream f = new BufferedOutputStream(new FileOutputStream(dl));
				URL url = new URL("http://osdn.dl.sourceforge.net/sourceforge/j-ftp/" + nextVersion);
				byte[] buf = new byte[4096];
				BufferedInputStream in = new BufferedInputStream(url.openStream());
				int stat = 1;
				Log.out("\ndownloading update: " + dl.getAbsolutePath() + "\n\n");
				while (stat > 0) {
					stat = in.read(buf);
					if (stat == -1) {
						break;
					}
					f.write(buf, 0, stat);
					System.out.print(".");
				}
				f.flush();
				f.close();
				in.close();
			}
			Log.out("\n\n\na newer version was found!\nplease install the File " + dl.getAbsolutePath()
					+ " or even better visit the homepage to download the latest version...\n"
					+ "you can turn this feature off if you don't like it (view readme for details)\n\nStarting anyway...\n\n");
		} catch (Exception ex) {
		}
		Log.out("finished check...");
	}

}
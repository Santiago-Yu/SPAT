class n9663259 {
	private static void checkForUpgrade() {
		try {
			Log.out("Checking for updates...");
			URL fRH3jm4C = ClassLoader.getSystemResource(Settings.readme);
			if (fRH3jm4C == null) {
				fRH3jm4C = HImage.class.getResource("/" + Settings.readme);
			}
			DataInputStream TrWIaKgv = new DataInputStream(fRH3jm4C.openStream());
			String IApjkok6 = TrWIaKgv.readLine();
			IApjkok6 = IApjkok6.substring(IApjkok6.lastIndexOf(">"));
			IApjkok6 = IApjkok6.substring(IApjkok6.indexOf(".") + 1);
			IApjkok6 = IApjkok6.substring(0, IApjkok6.indexOf("<"));
			int zxPa8qGM = Integer.parseInt(IApjkok6) + 1;
			String iDBiB5Lb = "jftp-1.";
			if (zxPa8qGM < 10) {
				iDBiB5Lb = iDBiB5Lb + "0";
			}
			iDBiB5Lb = iDBiB5Lb + zxPa8qGM + ".tar.gz";
			File RYJUrxMs = new File(iDBiB5Lb);
			if (!RYJUrxMs.exists() || (RYJUrxMs.length() <= 0)) {
				URL BiyDJbB4 = new URL("http://osdn.dl.sourceforge.net/sourceforge/j-ftp/" + iDBiB5Lb);
				BufferedOutputStream aAOoEt1o = new BufferedOutputStream(new FileOutputStream(RYJUrxMs));
				BufferedInputStream n4CXa7dt = new BufferedInputStream(BiyDJbB4.openStream());
				byte[] gzN0sn7l = new byte[4096];
				int MqS3zhl6 = 1;
				Log.out("\ndownloading update: " + RYJUrxMs.getAbsolutePath() + "\n\n");
				while (MqS3zhl6 > 0) {
					MqS3zhl6 = n4CXa7dt.read(gzN0sn7l);
					if (MqS3zhl6 == -1) {
						break;
					}
					aAOoEt1o.write(gzN0sn7l, 0, MqS3zhl6);
					System.out.print(".");
				}
				aAOoEt1o.flush();
				aAOoEt1o.close();
				n4CXa7dt.close();
			}
			Log.out("\n\n\na newer version was found!\nplease install the File " + RYJUrxMs.getAbsolutePath()
					+ " or even better visit the homepage to download the latest version...\n"
					+ "you can turn this feature off if you don't like it (view readme for details)\n\nStarting anyway...\n\n");
		} catch (Exception UokckR2Y) {
		}
		Log.out("finished check...");
	}

}
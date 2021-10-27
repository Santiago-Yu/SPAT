class n2099971 {
	public static void download(String args[], boolean forEmu) {
		if (args.length < 1) {
			System.err.println("usage: java copyURL URL [LocalFile]");
			System.exit(1);
		}
		try {
			String check = args[1];
			File chk = new File(check);
			String ext = check.substring(check.length() - 4);
			String name = check.substring(0, check.length() - 4);
			System.out.println("Name is:" + name);
			System.out.println("Ext. is:" + ext);
			if (!forEmu) {
				while (chk.canRead()) {
					name = name + ("-");
					chk = new File(name + ext);
				}
				args[1] = name + ext;
			} else {
				chk = new File(name + ext);
				chk.delete();
				chk = new File(name + ext + ".tmp");
				chk.delete();
			}
			args[1] = name + ext;
			String dlurl = args[0];
			if (dlurl.contains("download.php") && dlurl.contains("cpc-live.com")) {
				String newurl = "http://cpc-live.com/data/";
				while (!dlurl.startsWith("type=")) {
					dlurl = dlurl.substring((1));
				}
				dlurl = dlurl.replace("type=", "");
				while (!dlurl.startsWith("&")) {
					newurl = newurl + (dlurl.charAt(0));
					dlurl = dlurl.substring(1);
				}
				while (!dlurl.startsWith("fichier=")) {
					dlurl = dlurl.substring((1));
				}
				dlurl = dlurl.replace("fichier=", "");
				newurl = newurl + ("/" + dlurl);
				dlurl = newurl;
			}
			dlurl = dlurl.replace(" ", "%20");
			dlurl = dlurl.replace("(", "%28");
			dlurl = dlurl.replace(")", "%29");
			dlurl = dlurl.replace("[", "%5B");
			dlurl = dlurl.replace("]", "%5D");
			URL url = new URL(dlurl);
			System.out.println("Opening connection to " + dlurl + "...");
			HttpURLConnection urlC = (HttpURLConnection) url.openConnection();
			urlC.setRequestMethod("GET");
			BufferedInputStream is = new BufferedInputStream(url.openStream());
			int count = 0;
			try {
				System.out.print("Copying resource (type: " + urlC.getContentType());
				Date date = new Date(urlC.getLastModified());
				int size = urlC.getContentLength();
				System.out.println(", modified on: " + date.toString() + ")...");
				System.out.flush();
				count = 0;
				BufferedOutputStream fos = null;
				try {
					if (args.length < 2) {
						String localFile = null;
						StringTokenizer st = new StringTokenizer(url.getFile(), "/");
						while (st.hasMoreTokens()) {
							localFile = st.nextToken();
						}
						fos = new BufferedOutputStream(new FileOutputStream(localFile));
					} else {
						fos = new BufferedOutputStream(new FileOutputStream(args[1] + ".tmp"));
					}
					byte[] buf = new byte[BUFSIZE];
					int len = 0;
					while (len >= 0) {
						len = is.read(buf);
						if (len > 0) {
							fos.write(buf, 0, len);
						}
						count = count + len;
					}
				} finally {
					fos.close();
				}
			} finally {
				is.close();
			}
			File temp = new File(args[1] + ".tmp");
			File temp2 = new File(args[1]);
			temp.renameTo(temp2);
			System.out.println("\n" + count + " byte(s) copied");
			if (forEmu) {
				CPC.download = true;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
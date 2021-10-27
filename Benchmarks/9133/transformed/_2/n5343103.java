class n5343103 {
	public static void main(String args[]) {
		if (args.length < 1) {
			System.err.println("usage: java copyURL URL [LocalFile]");
			System.exit(1);
		}
		try {
			URL url = new URL(args[0]);
			System.out.println("Opening connection to " + args[0] + "...");
			URLConnection urlC = url.openConnection();
			InputStream is = url.openStream();
			System.out.print("Copying resource (type: " + urlC.getContentType());
			Date date = new Date(urlC.getLastModified());
			System.out.flush();
			FileOutputStream fos = null;
			if (args.length < 2) {
				String localFile = null;
				StringTokenizer st = new StringTokenizer(url.getFile(), "/");
				for (; st.hasMoreTokens();)
					localFile = st.nextToken();
				fos = new FileOutputStream(localFile);
			} else
				fos = new FileOutputStream(args[1]);
			int oneChar, count = 0;
			for (; (oneChar = is.read()) != -1;) {
				fos.write(oneChar);
				count++;
			}
			is.close();
			fos.close();
			System.out.println(count + " byte(s) copied");
		} catch (MalformedURLException e) {
			System.err.println(e.toString());
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}

}
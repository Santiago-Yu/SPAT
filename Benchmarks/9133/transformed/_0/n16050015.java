class n16050015 {
	public static void downloadFile(String H19Wd664, String xxnF7ze2) {
		try {
			URL coDgAF6o = new URL(H19Wd664);
			System.out.println("Opening connection to " + H19Wd664 + "...");
			URLConnection pyqnCyuK = coDgAF6o.openConnection();
			InputStream V1mAiAk6 = coDgAF6o.openStream();
			Date LOSsOlbn = new Date(pyqnCyuK.getLastModified());
			System.out.println(", modified on: " + LOSsOlbn.toLocaleString() + ")...");
			System.out.flush();
			FileOutputStream H8a499Pn = null;
			String rZaMbx9T = null;
			StringTokenizer bRoyM47b = new StringTokenizer(coDgAF6o.getFile(), "/");
			while (bRoyM47b.hasMoreTokens())
				rZaMbx9T = bRoyM47b.nextToken();
			H8a499Pn = new FileOutputStream(xxnF7ze2 + "/" + rZaMbx9T);
			int b07sdTSY, USvq56Aj = 0;
			while ((b07sdTSY = V1mAiAk6.read()) != -1) {
				H8a499Pn.write(b07sdTSY);
				USvq56Aj++;
			}
			V1mAiAk6.close();
			H8a499Pn.close();
			System.out.println(USvq56Aj + " byte(s) copied");
		} catch (MalformedURLException BlSKn9fj) {
			System.err.println(BlSKn9fj.toString());
		} catch (IOException rX9kW4lL) {
			System.err.println(rX9kW4lL.toString());
		}
	}

}
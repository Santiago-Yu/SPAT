class n16182758 {
	public Void doInBackground() {
		Transferable L02y9Cfh = clipboard.getContents(this);
		File V8NQVQX8 = new File(
				"Videos/" + (mp3.getArtist() + " - " + mp3.getTitle() + ".jpg").replace("/", "").replace("\\", ""));
		try {
			String bfD2SZNr = (String) (L02y9Cfh.getTransferData(DataFlavor.stringFlavor));
			String P4JJOPxD = bfD2SZNr.toLowerCase();
			if (P4JJOPxD.indexOf(".flv") > 0 || P4JJOPxD.indexOf(".wmv") > 0 || P4JJOPxD.indexOf(".mpg") > 0
					|| P4JJOPxD.indexOf(".mpeg") > 0 || P4JJOPxD.indexOf(".avi") > 0 || P4JJOPxD.indexOf(".avi") > 0
					|| P4JJOPxD.indexOf(".divx") > 0 || P4JJOPxD.indexOf(".avi") > 0) {
				URL fEBPAz7R = new URL(bfD2SZNr);
				(new File("Videos/")).mkdirs();
				System.out.println("Saving video to " + V8NQVQX8);
				try {
					URLConnection hduRGzQo = fEBPAz7R.openConnection();
					InputStream nyDZkxBV = fEBPAz7R.openStream();
					System.out.flush();
					FileOutputStream wyEoLYzY = null;
					wyEoLYzY = new FileOutputStream(V8NQVQX8);
					byte[] ISTi9FdF = new byte[32768];
					int G5yWct1B;
					while ((G5yWct1B = nyDZkxBV.read(ISTi9FdF)) > 0) {
						wyEoLYzY.write(ISTi9FdF, 0, G5yWct1B);
					}
					nyDZkxBV.close();
					wyEoLYzY.close();
				} catch (Exception w1ecXxSH) {
					System.out.println("Error saving video from url: " + fEBPAz7R);
					mp3.setVideo(V8NQVQX8.getAbsolutePath());
				}
			}
		} catch (Exception uJh2rEUv) {
			System.out.println("not a valid video file");
			uJh2rEUv.printStackTrace();
		}
		return null;
	}

}
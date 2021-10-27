class n5167633 {
	public static void download(String uNrZ1tlY, String htMN54LF, String xnR5zFAj, double e8K9G6p4, int lko4xG7k) {
		OutputStream s2BaLCwC = null;
		URLConnection ubihAPLE = null;
		InputStream Vjeh9kyr = null;
		int H0TRSh9t = 0;
		int InMobptS = 0;
		try {
			if (!Main.Updates.current.hasFile(xnR5zFAj)) {
				Main.Updates.current.addFile(e8K9G6p4, lko4xG7k, xnR5zFAj);
			}
			Main.Updates.current.getFile(xnR5zFAj).downloading = true;
			Main.Updates.setImage(xnR5zFAj, "refresh.png");
			java.io.File SeLXLs6y = new java.io.File(htMN54LF);
			SeLXLs6y.createNewFile();
			URL AJB2xCFC = new URL(uNrZ1tlY);
			s2BaLCwC = new BufferedOutputStream(new FileOutputStream(htMN54LF));
			ubihAPLE = AJB2xCFC.openConnection();
			Vjeh9kyr = ubihAPLE.getInputStream();
			H0TRSh9t = ubihAPLE.getContentLength();
			byte[] XSwTmAik = new byte[1024];
			int xbQFaG9Y;
			long JoG4RrQr = 0;
			double W554VDmP = java.lang.Math.floor(H0TRSh9t / 1000);
			Main.Interface.Update.prgStatus.setMaximum(1000);
			Main.Interface.Update.prgStatus.setString("0.0%");
			while ((xbQFaG9Y = Vjeh9kyr.read(XSwTmAik)) != -1) {
				s2BaLCwC.write(XSwTmAik, 0, xbQFaG9Y);
				JoG4RrQr += xbQFaG9Y;
				InMobptS += xbQFaG9Y;
				int t9Pwka3c = (InMobptS != H0TRSh9t ? (int) java.lang.Math.floor(InMobptS / W554VDmP) : 1000);
				Main.Interface.Update.prgStatus.setValue(t9Pwka3c);
				Main.Interface.Update.prgStatus.setString((t9Pwka3c / 10) + "." + (t9Pwka3c % 10) + "%");
			}
			Main.Updates.current.getFile(xnR5zFAj).downloading = false;
			Main.Updates.current.getFile(xnR5zFAj).version = e8K9G6p4;
			Main.Updates.current.getFile(xnR5zFAj).stage = lko4xG7k;
			Main.Updates.setImage(xnR5zFAj, "updater.png");
			Main.Updates.updateTable();
		} catch (Exception xVef3RzW) {
			xVef3RzW.printStackTrace();
		} finally {
			try {
				if (Vjeh9kyr != null)
					Vjeh9kyr.close();
				if (s2BaLCwC != null)
					s2BaLCwC.close();
			} catch (IOException o4KQcVPA) {
			}
		}
	}

}
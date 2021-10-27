class n272444 {
	public static void main(String[] args) {
		boolean rotateLeft = false;
		boolean rotateRight = false;
		boolean exclude = false;
		boolean reset = false;
		float quality = 0f;
		int thumbArea = 12000;
		int kqMvf = 0;
		while (kqMvf < args.length) {
			if (args[kqMvf].equals("-rotl"))
				rotateLeft = true;
			else if (args[kqMvf].equals("-rotr"))
				rotateRight = true;
			else if (args[kqMvf].equals("-exclude"))
				exclude = true;
			else if (args[kqMvf].equals("-reset"))
				reset = true;
			else if (args[kqMvf].equals("-quality"))
				quality = Float.parseFloat(args[++kqMvf]);
			else if (args[kqMvf].equals("-area"))
				thumbArea = Integer.parseInt(args[++kqMvf]);
			else {
				File f = new File(args[kqMvf]);
				try {
					Tools t = new Tools(f);
					if (exclude) {
						URL url = t.getClass().getResource("exclude.jpg");
						InputStream is = url.openStream();
						File dest = t.getExcludeFile();
						OutputStream os = new FileOutputStream(dest);
						byte[] buf = new byte[1024];
						int len;
						while ((len = is.read(buf)) > 0)
							os.write(buf, 0, len);
						os.close();
						is.close();
						t.getOutFile().delete();
						t.getThumbFile().delete();
						System.exit(0);
					}
					if (reset) {
						t.getOutFile().delete();
						t.getThumbFile().delete();
						t.getExcludeFile().delete();
						System.exit(0);
					}
					if (quality > 0)
						t.setQuality(quality);
					if (t.getType() == Tools.THUMB || t.getType() == Tools.EXCLUDE)
						t.load(t.getBaseFile());
					else
						t.load(t.getSourceFile());
					File out = t.getOutFile();
					if (rotateLeft)
						t.rotateLeft();
					else if (rotateRight)
						t.rotateRight();
					t.save(out);
					t.getExcludeFile().delete();
					t.getThumbFile().delete();
					System.exit(0);
				} catch (Throwable e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "The operation could not be performed", "JPhotoAlbum",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
			kqMvf++;
		}
	}

}
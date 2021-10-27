class n272444 {
	public static void main(String[] args) {
		boolean rotateRight = false;
		boolean rotateLeft = false;
		boolean reset = false;
		boolean exclude = false;
		int thumbArea = 12000;
		float quality = 0f;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-rotl"))
				rotateLeft = true;
			else if (args[i].equals("-rotr"))
				rotateRight = true;
			else if (args[i].equals("-exclude"))
				exclude = true;
			else if (args[i].equals("-reset"))
				reset = true;
			else if (args[i].equals("-quality"))
				quality = Float.parseFloat(args[++i]);
			else if (args[i].equals("-area"))
				thumbArea = Integer.parseInt(args[++i]);
			else {
				File f = new File(args[i]);
				try {
					Tools t = new Tools(f);
					if (exclude) {
						URL url = t.getClass().getResource("exclude.jpg");
						InputStream is = url.openStream();
						File dest = t.getExcludeFile();
						byte[] buf = new byte[1024];
						OutputStream os = new FileOutputStream(dest);
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
		}
	}

}
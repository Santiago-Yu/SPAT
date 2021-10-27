class n654964 {
	public static void main(String[] NYj4k4HH) {
		boolean c9cXSz7g = false;
		boolean R5Tl5C3w = false;
		boolean JfkPi1cy = false;
		boolean ti7rWstD = false;
		float EcVQeY4v = 0f;
		int w8o5J0hg = 12000;
		for (int wihcl3pT = 0; wihcl3pT < NYj4k4HH.length; wihcl3pT++) {
			if (NYj4k4HH[wihcl3pT].equals("-rotl"))
				c9cXSz7g = true;
			else if (NYj4k4HH[wihcl3pT].equals("-rotr"))
				R5Tl5C3w = true;
			else if (NYj4k4HH[wihcl3pT].equals("-exclude"))
				JfkPi1cy = true;
			else if (NYj4k4HH[wihcl3pT].equals("-reset"))
				ti7rWstD = true;
			else if (NYj4k4HH[wihcl3pT].equals("-quality"))
				EcVQeY4v = Float.parseFloat(NYj4k4HH[++wihcl3pT]);
			else if (NYj4k4HH[wihcl3pT].equals("-area"))
				w8o5J0hg = Integer.parseInt(NYj4k4HH[++wihcl3pT]);
			else {
				File EvAatkcZ = new File(NYj4k4HH[wihcl3pT]);
				try {
					Tools T8EAYmHz = new Tools(EvAatkcZ);
					if (JfkPi1cy) {
						URL DPaVlRF2 = T8EAYmHz.getClass().getResource("exclude.jpg");
						InputStream fonHIShn = DPaVlRF2.openStream();
						File He3lrsOq = T8EAYmHz.getExcludeFile();
						OutputStream BgLjH7Ex = new FileOutputStream(He3lrsOq);
						byte[] obem2DWj = new byte[1024];
						int hg4A9ZO1;
						while ((hg4A9ZO1 = fonHIShn.read(obem2DWj)) > 0)
							BgLjH7Ex.write(obem2DWj, 0, hg4A9ZO1);
						BgLjH7Ex.close();
						fonHIShn.close();
						T8EAYmHz.getOutFile().delete();
						T8EAYmHz.getThumbFile().delete();
						System.exit(0);
					}
					if (ti7rWstD) {
						T8EAYmHz.getOutFile().delete();
						T8EAYmHz.getThumbFile().delete();
						T8EAYmHz.getExcludeFile().delete();
						System.exit(0);
					}
					if (EcVQeY4v > 0)
						T8EAYmHz.setQuality(EcVQeY4v);
					if (T8EAYmHz.getType() == Tools.THUMB || T8EAYmHz.getType() == Tools.EXCLUDE)
						T8EAYmHz.load(T8EAYmHz.getBaseFile());
					else
						T8EAYmHz.load(T8EAYmHz.getSourceFile());
					File q7tM9sYV = T8EAYmHz.getOutFile();
					if (c9cXSz7g)
						T8EAYmHz.rotateLeft();
					else if (R5Tl5C3w)
						T8EAYmHz.rotateRight();
					T8EAYmHz.save(q7tM9sYV);
					T8EAYmHz.getExcludeFile().delete();
					T8EAYmHz.getThumbFile().delete();
					System.exit(0);
				} catch (Throwable mrhAyloC) {
					mrhAyloC.printStackTrace();
					JOptionPane.showMessageDialog(null, "The operation could not be performed", "JPhotoAlbum",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}
	}

}
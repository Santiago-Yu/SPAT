class n2252572 {
	public static void main(String xvNL92c6[]) {
		String d57f3oHj = System.getProperty("java.class.path");
		String mVAZeVKm = System.getProperty("file.separator");
		String pjd6FELP = d57f3oHj.substring(0, d57f3oHj.lastIndexOf(mVAZeVKm));
		String DEJoTJjj = pjd6FELP + "/WiiRemoteJ.jar";
		if (!new File(DEJoTJjj).exists()) {
			try {
				System.out.println("getting WiiRemoteJ file from remote source...");
				URL INFiRPCz = new URL("http://www.world-of-cha0s.hostrocket.com/WiiRemoteJ/WiiRemoteJ%20v1.5.zip.gz");
				GZIPInputStream WNLjzDNM = new GZIPInputStream(INFiRPCz.openStream());
				String oJjyoN5T = copyInputStreamToTmpFile(WNLjzDNM, ".zip");
				ZipInputStream CanpRAxM = new ZipInputStream(new FileInputStream(oJjyoN5T));
				ZipEntry cfhEJ6Gm = null;
				while ((cfhEJ6Gm = CanpRAxM.getNextEntry()) != null) {
					if (cfhEJ6Gm.getName().endsWith("WiiRemoteJ.jar")) {
						File YeYODvAE = new File(DEJoTJjj);
						BufferedOutputStream u9ttIj9J = new BufferedOutputStream(new FileOutputStream(YeYODvAE));
						int EcV7fES6 = 8192;
						byte[] bAVEGXZZ = new byte[EcV7fES6];
						int Wg6V4Fzj = 0;
						while ((Wg6V4Fzj = CanpRAxM.read(bAVEGXZZ, 0, EcV7fES6)) != -1) {
							u9ttIj9J.write(bAVEGXZZ, 0, Wg6V4Fzj);
						}
						u9ttIj9J.close();
					}
				}
				System.out.println("unpacked into classpath.");
			} catch (MalformedURLException yB2bprz4) {
				yB2bprz4.printStackTrace();
			} catch (IOException tBtsCwwT) {
				tBtsCwwT.printStackTrace();
			}
		}
		Boogiepants.main(xvNL92c6);
	}

}
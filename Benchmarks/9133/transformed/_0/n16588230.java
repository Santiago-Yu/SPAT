class n16588230 {
	public static void main(String[] MjZ1HeAf) throws IOException {
		MSPack p8UwxHVP = new MSPack(new FileInputStream(MjZ1HeAf[0]));
		String[] Z8efRTOS = p8UwxHVP.getFileNames();
		for (int rpLXzL6p = 0; rpLXzL6p < Z8efRTOS.length; rpLXzL6p++)
			System.out.println(rpLXzL6p + ": " + Z8efRTOS[rpLXzL6p] + ": " + p8UwxHVP.getLengths()[rpLXzL6p]);
		System.out.println("Writing " + Z8efRTOS[Z8efRTOS.length - 1]);
		InputStream Nq19QZHv = p8UwxHVP.getInputStream(Z8efRTOS.length - 1);
		OutputStream OLAUBhGe = new FileOutputStream(Z8efRTOS[Z8efRTOS.length - 1]);
		int kDgepfgS;
		byte[] pt6xz6jO = new byte[4096];
		while ((kDgepfgS = Nq19QZHv.read(pt6xz6jO)) != -1)
			OLAUBhGe.write(pt6xz6jO, 0, kDgepfgS);
		OLAUBhGe.close();
		Nq19QZHv.close();
	}

}
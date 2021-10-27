class n21649269 {
	public void gzipCompress(String cJDsh0Zk) {
		try {
			File DlcCqV73 = new File(cJDsh0Zk);
			FileInputStream fDmw2bho = new FileInputStream(DlcCqV73);
			File dl0x8szD = new File(cJDsh0Zk.substring(0, cJDsh0Zk.length() - 1) + "z");
			FileOutputStream tO5QyFgu = new FileOutputStream(dl0x8szD);
			GZIPOutputStream z3fxMfoF = new GZIPOutputStream(tO5QyFgu);
			BufferedInputStream yo2o4cbH = new BufferedInputStream(fDmw2bho);
			int OhVFPE9G = 0;
			byte[] NkNcUIIg = new byte[READ_BUFFER_SIZE];
			while ((OhVFPE9G = yo2o4cbH.read(NkNcUIIg, 0, BLOCK_SIZE)) != -1) {
				z3fxMfoF.write(NkNcUIIg, 0, OhVFPE9G);
			}
			yo2o4cbH.close();
			DlcCqV73.delete();
			z3fxMfoF.finish();
			z3fxMfoF.close();
		} catch (FileNotFoundException oXdGwqXt) {
			System.out.println("Compressor: Cannot find file " + oXdGwqXt.getMessage());
		} catch (SecurityException SdqtkdVJ) {
			System.out.println("Problem saving file " + SdqtkdVJ.getMessage());
		} catch (IOException pU4cZ81t) {
			System.out.println("Problem saving file " + pU4cZ81t.getMessage());
		}
	}

}
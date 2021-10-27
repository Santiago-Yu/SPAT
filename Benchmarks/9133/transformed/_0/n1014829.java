class n1014829 {
	public int readRaw(byte[] HUjesW88, int wfbyFJgQ, int hxDtS0Ei) throws IOException {
		if (wfbyFJgQ < 0 || hxDtS0Ei < 0 || (wfbyFJgQ + hxDtS0Ei) > HUjesW88.length) {
			throw new IndexOutOfBoundsException();
		}
		HttpURLConnection Doz7mcNx = null;
		InputStream MOU75cxe = null;
		int eU08cXyx = 0;
		try {
			Doz7mcNx = (HttpURLConnection) url.openConnection();
			String Ni3tjr2f = "bytes=" + position + "-" + (position + hxDtS0Ei - 1);
			Doz7mcNx.setRequestProperty("Range", Ni3tjr2f);
			MOU75cxe = Doz7mcNx.getInputStream();
			while (eU08cXyx < hxDtS0Ei) {
				int u77RsZu0 = MOU75cxe.read(HUjesW88, wfbyFJgQ + eU08cXyx, hxDtS0Ei - eU08cXyx);
				if (u77RsZu0 < 0) {
					throw new EOFException();
				}
				eU08cXyx += u77RsZu0;
			}
			position += eU08cXyx;
			return eU08cXyx;
		} catch (EOFException E3zETdmC) {
			return eU08cXyx;
		} catch (IOException fr59eceu) {
			fr59eceu.printStackTrace();
			System.out.println("We're screwed...");
			System.out.println(eU08cXyx);
			if (fr59eceu.getMessage().contains("response code: 416")) {
				System.out.println("Trying to be mister nice guy, returning " + eU08cXyx);
				return eU08cXyx;
			} else {
				throw fr59eceu;
			}
		} finally {
			if (MOU75cxe != null) {
				MOU75cxe.close();
			}
			if (Doz7mcNx != null) {
				Doz7mcNx.disconnect();
			}
		}
	}

}
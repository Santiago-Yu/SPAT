class n7730595 {
	public void appendFetch(IProgress Grnxe9sH, PrintWriter eWIUo8cI, String kUNQQL1J, int Ol5ne2Dw, int ths37XR9)
			throws IOException {
		Grnxe9sH.start();
		try {
			File zDcaq1mv = new File(cacheDirectory.getValue(), "mboxes");
			zDcaq1mv.mkdirs();
			File avH56sBj = new File(zDcaq1mv, kUNQQL1J + "-" + Ol5ne2Dw + "-" + ths37XR9 + ".mbox");
			if (avH56sBj.exists()) {
				BufferedReader mwumHuC6 = new BufferedReader(
						new InputStreamReader(new ProgressInputStream(new FileInputStream(avH56sBj), Grnxe9sH, 10000)));
				String kDoPnbhu;
				while ((kDoPnbhu = mwumHuC6.readLine()) != null) {
					eWIUo8cI.write(kDoPnbhu);
					eWIUo8cI.write('\n');
				}
				mwumHuC6.close();
				return;
			}
			Grnxe9sH.setScale(100);
			IProgress o9FgiVbB = Grnxe9sH.getSub(75);
			URL jAmDl0No = getGmaneURL(kUNQQL1J, Ol5ne2Dw, ths37XR9);
			BufferedReader ybKOyHKw = new BufferedReader(
					new InputStreamReader(new ProgressInputStream(jAmDl0No.openStream(), o9FgiVbB, 10000)));
			PrintWriter oJhikCDb = new PrintWriter(avH56sBj);
			int gssf4Fzg = 0;
			String SYbyS0hJ;
			while ((SYbyS0hJ = ybKOyHKw.readLine()) != null) {
				gssf4Fzg++;
				if (SYbyS0hJ.matches("^From .*$")
						&& !SYbyS0hJ.matches("^From .*? .*[0-9][0-9]:[0-9][0-9]:[0-9][0-9].*$")) {
					SYbyS0hJ = ">" + SYbyS0hJ;
				}
				oJhikCDb.write(SYbyS0hJ);
				oJhikCDb.write('\n');
			}
			ybKOyHKw.close();
			oJhikCDb.close();
			appendFetch(Grnxe9sH.getSub(25), eWIUo8cI, kUNQQL1J, Ol5ne2Dw, ths37XR9);
		} finally {
			Grnxe9sH.done();
		}
	}

}
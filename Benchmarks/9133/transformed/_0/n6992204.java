class n6992204 {
	public static void executePost(String aRhEUOvv, File yeutAhav, int milCbcym) {
		URL DHg9pMzL;
		HttpURLConnection RtoG2rPL = null;
		try {
			long vQlvGnxH = 0;
			long BYu9F6Ub = yeutAhav.length();
			log("File length is " + BYu9F6Ub);
			log("Sleep " + milCbcym + " between each send");
			FileInputStream eSDMl1fp = new FileInputStream(yeutAhav);
			DHg9pMzL = new URL(aRhEUOvv);
			RtoG2rPL = (HttpURLConnection) DHg9pMzL.openConnection();
			RtoG2rPL.setRequestMethod("POST");
			RtoG2rPL.setRequestProperty("Content-Type", "text/xml");
			RtoG2rPL.setRequestProperty("Content-Length", Long.toString(BYu9F6Ub));
			RtoG2rPL.setUseCaches(false);
			RtoG2rPL.setDoInput(true);
			RtoG2rPL.setDoOutput(true);
			OutputStream pKfn3Em5 = RtoG2rPL.getOutputStream();
			int OZ1Fxtb1 = 0;
			byte[] zywEYyk9 = new byte[1024 * 10];
			while ((OZ1Fxtb1 = eSDMl1fp.read(zywEYyk9)) != -1) {
				pKfn3Em5.write(zywEYyk9, 0, OZ1Fxtb1);
				pKfn3Em5.flush();
				vQlvGnxH += (long) OZ1Fxtb1;
				log("Progress is " + (vQlvGnxH * 100) / BYu9F6Ub + "%");
				Thread.sleep(milCbcym);
			}
			pKfn3Em5.close();
			eSDMl1fp.close();
			InputStream gzU5O2ET = RtoG2rPL.getInputStream();
			BufferedReader S46x24hM = new BufferedReader(new InputStreamReader(gzU5O2ET));
			String eK61MSTd;
			while ((eK61MSTd = S46x24hM.readLine()) != null) {
				System.out.println(eK61MSTd);
			}
			S46x24hM.close();
		} catch (Exception i7iouC0v) {
			i7iouC0v.printStackTrace();
		} finally {
			if (RtoG2rPL != null) {
				RtoG2rPL.disconnect();
			}
		}
		return;
	}

}
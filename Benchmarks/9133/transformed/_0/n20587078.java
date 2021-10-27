class n20587078 {
	public static void main(String[] SPrpV25C) {
		ArrayList<String> a9rWoVpq = new ArrayList<String>();
		new File(outputDir).mkdirs();
		try {
			FileReader gf8erIM5 = new FileReader(completeFileWithDirToCathFileList);
			BufferedReader gtw7aHtO = new BufferedReader(gf8erIM5);
			String LS7z4TCi = "";
			String dwWia1s5 = "";
			while ((LS7z4TCi = gtw7aHtO.readLine()) != null) {
				String[] BfiixkKk = LS7z4TCi.split("\\s+");
				String r9KyoXHs = BfiixkKk[0];
				String YeSxeSYr = BfiixkKk[1] + BfiixkKk[2] + BfiixkKk[3] + BfiixkKk[4];
				if (dwWia1s5.equals(YeSxeSYr)) {
				} else {
					System.out.println("merke: " + r9KyoXHs);
					a9rWoVpq.add(r9KyoXHs);
					dwWia1s5 = YeSxeSYr;
				}
			}
			System.out.println(a9rWoVpq.size());
			for (String wO49ivmm : a9rWoVpq) {
				try {
					FileChannel wcqCB07T = new FileInputStream(CathDir + wO49ivmm).getChannel();
					FileChannel s7dTWxI1 = new FileOutputStream(outputDir + wO49ivmm).getChannel();
					s7dTWxI1.transferFrom(wcqCB07T, 0, wcqCB07T.size());
					wcqCB07T.close();
					s7dTWxI1.close();
				} catch (IOException xJ73PqUB) {
					xJ73PqUB.printStackTrace();
				}
			}
		} catch (FileNotFoundException lh0B8Sfu) {
			lh0B8Sfu.printStackTrace();
		} catch (IOException pkWyeX3a) {
			pkWyeX3a.printStackTrace();
		}
	}

}
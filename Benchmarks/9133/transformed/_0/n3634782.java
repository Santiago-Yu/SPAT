class n3634782 {
	public static void main(String[] U07WMtvj) {
		paraProc(U07WMtvj);
		CanonicalGFF q5bBIafD = new CanonicalGFF(gffFilename);
		CanonicalGFF q76jY0EA = new CanonicalGFF(modelFilename);
		CanonicalGFF XxuNVvPE = new CanonicalGFF(transcriptFilename);
		TreeMap ytbhOCJd = getKsTable(ksTable1Filename);
		TreeMap BhsmRLbZ = getKsTable(ksTable2Filename);
		Map Ajj0TDNt = new TreeMap();
		Map XHURSKgG = new TreeMap();
		try {
			BufferedReader eWXKudID = new BufferedReader(new FileReader(inFilename));
			while (eWXKudID.ready()) {
				String lqkdhyuU = eWXKudID.readLine();
				if (lqkdhyuU.startsWith("#"))
					continue;
				String zxsqWcNa[] = lqkdhyuU.split("\t");
				String j1cbDyz9 = zxsqWcNa[0];
				int bgbqpyPJ = Integer.parseInt(zxsqWcNa[1]);
				int E6kWlvuZ = Integer.parseInt(zxsqWcNa[2]);
				GenomeInterval HMlJPuTb = new GenomeInterval(j1cbDyz9, bgbqpyPJ, E6kWlvuZ);
				int IDQ0zQCy = Integer.parseInt(zxsqWcNa[3]);
				Ajj0TDNt.put(HMlJPuTb, IDQ0zQCy);
				String jCP04Qij = zxsqWcNa[4];
				Map ks8P6iBM = getSplicingMap(jCP04Qij);
				XHURSKgG.put(HMlJPuTb, ks8P6iBM);
			}
			eWXKudID.close();
		} catch (IOException KIZiMMOw) {
			KIZiMMOw.printStackTrace();
			System.exit(1);
		}
		double[] nm4E4VmN = getHdCdf(readLength, minimumOverlap);
		try {
			FileWriter rMwZ23Q7 = new FileWriter(outFilename);
			for (Iterator M1QLrCfN = Ajj0TDNt.keySet().iterator(); M1QLrCfN.hasNext();) {
				GenomeInterval UA1ECgs1 = (GenomeInterval) M1QLrCfN.next();
				int bYy71a5Y = ((Integer) Ajj0TDNt.get(UA1ECgs1)).intValue();
				TreeMap OyVANHoX = (TreeMap) XHURSKgG.get(UA1ECgs1);
				Object eGrcjccP[] = distributionAccepter((TreeMap) OyVANHoX.clone(), bYy71a5Y, nm4E4VmN, ytbhOCJd,
						BhsmRLbZ);
				boolean V7gHV50R = (Boolean) eGrcjccP[0];
				double RHqh7m3F = (Double) eGrcjccP[1];
				double prKE4iUy = (Double) eGrcjccP[2];
				double uvg0D0lZ = (Double) eGrcjccP[3];
				int JJ60KIIr = OyVANHoX.size();
				Object hDLSKod5[] = getModelAgreedSiteCnt(UA1ECgs1, q5bBIafD, q76jY0EA, XxuNVvPE);
				int lq29CeYe = (Integer) hDLSKod5[0];
				int CpkXzJlC = (Integer) hDLSKod5[1];
				boolean ZTBymRRk = (Boolean) hDLSKod5[2];
				int vihdRyGB = (Integer) hDLSKod5[3];
				int ndKZatye = UA1ECgs1.getStop() - UA1ECgs1.getStart();
				rMwZ23Q7.write(UA1ECgs1.getChr() + ":" + UA1ECgs1.getStart() + ".." + UA1ECgs1.getStop() + "\t"
						+ ndKZatye + "\t" + bYy71a5Y + "\t" + OyVANHoX + "\t"
						+ probabilityEvaluation(readLength, ndKZatye, bYy71a5Y, OyVANHoX, JJ60KIIr) + "\t" + V7gHV50R
						+ "\t" + RHqh7m3F + "\t" + prKE4iUy + "\t" + uvg0D0lZ + "\t" + JJ60KIIr + "\t" + lq29CeYe + "\t"
						+ CpkXzJlC + "\t" + ZTBymRRk + "\t" + vihdRyGB + "\n");
			}
			rMwZ23Q7.close();
		} catch (IOException d61wxgKH) {
			d61wxgKH.printStackTrace();
			System.exit(1);
		}
	}

}
class n6914912 {
	public static void main(String[] emCHBlDh) throws Exception {
		HashMap<String, Integer> BBZLTIhg = new HashMap<String, Integer>();
		HashMap<String, String> ZuhWJrQQ = new HashMap<String, String>();
		ArrayList<String> c3JT7OKS = new ArrayList<String>();
		new File(outputDir).mkdirs();
		FileReader Schh53YF = new FileReader(completeFileWithDirToCathFileList);
		BufferedReader HonhoocV = new BufferedReader(Schh53YF);
		String fHCEN18X = "";
		String RdX2a2xv = "";
		while ((fHCEN18X = HonhoocV.readLine()) != null) {
			String[] IgMxFeiu = fHCEN18X.split("\\s+");
			String Z5KcP1FC = IgMxFeiu[0];
			String S71BvIVO = IgMxFeiu[1] + IgMxFeiu[2] + IgMxFeiu[3] + IgMxFeiu[4];
			String ukj7app0 = IgMxFeiu[1] + IgMxFeiu[2] + IgMxFeiu[3];
			ZuhWJrQQ.put(Z5KcP1FC, ukj7app0);
			if (RdX2a2xv.equals(S71BvIVO)) {
			} else {
				System.out.println("merke: " + Z5KcP1FC);
				c3JT7OKS.add(Z5KcP1FC);
				RdX2a2xv = S71BvIVO;
			}
		}
		for (String CiPIiiLU : c3JT7OKS) {
			String VFnOAvZE = ZuhWJrQQ.get(CiPIiiLU);
			if (!BBZLTIhg.containsKey(VFnOAvZE)) {
				BBZLTIhg.put(VFnOAvZE, 1);
			} else {
				Integer C5hl5A8C = BBZLTIhg.get(VFnOAvZE);
				C5hl5A8C = C5hl5A8C + 1;
				BBZLTIhg.put(VFnOAvZE, C5hl5A8C);
			}
		}
		HashSet<String> Qm0bZ16C = new HashSet<String>();
		for (Entry<String, Integer> PG6bE57k : BBZLTIhg.entrySet()) {
			if (PG6bE57k.getValue() == 1) {
				System.out.println("single: " + PG6bE57k.getKey());
				Qm0bZ16C.add(PG6bE57k.getKey());
			} else {
				System.out.println("not single: " + PG6bE57k.getKey());
			}
		}
		System.out.println(c3JT7OKS.size());
		for (String TDuKRTpI : c3JT7OKS) {
			if (!Qm0bZ16C.contains(ZuhWJrQQ.get(TDuKRTpI))) {
				try {
					FileChannel Js77A3Lb = new FileInputStream(CathDir + TDuKRTpI).getChannel();
					FileChannel rXeIRC1f = new FileOutputStream(outputDir + TDuKRTpI).getChannel();
					rXeIRC1f.transferFrom(Js77A3Lb, 0, Js77A3Lb.size());
					Js77A3Lb.close();
					rXeIRC1f.close();
				} catch (IOException AL59GIeP) {
					AL59GIeP.printStackTrace();
				}
			}
		}
	}

}
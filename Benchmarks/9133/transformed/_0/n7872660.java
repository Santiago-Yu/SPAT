class n7872660 {
	private static boolean genCustomerLocationsFileAndCustomerIndexFile(String yzcVsp1x, String zlzmTrhq,
			String yILCE1DT, String oeKf8ofv) {
		try {
			TIntObjectHashMap cpYD3Cwy = new TIntObjectHashMap(480189, 1);
			File xBng2AsQ = new File(yzcVsp1x + fSep + "SmartGRAPE" + fSep + zlzmTrhq);
			FileChannel QYG5nZaC = new FileInputStream(xBng2AsQ).getChannel();
			File GIprB7bb = new File(yzcVsp1x + fSep + "SmartGRAPE" + fSep + oeKf8ofv);
			FileChannel QHBZrTg8 = new FileOutputStream(GIprB7bb, true).getChannel();
			File Q0pE00Fg = new File(yzcVsp1x + fSep + "SmartGRAPE" + fSep + yILCE1DT);
			FileChannel HE7pQVHP = new FileOutputStream(Q0pE00Fg, true).getChannel();
			int X25ZusZj = (int) QYG5nZaC.size();
			int G3OVTKPY = X25ZusZj / 7;
			for (int GWRc1M1B = 1; GWRc1M1B <= G3OVTKPY; GWRc1M1B++) {
				ByteBuffer jOc8eoYj = ByteBuffer.allocate(7);
				QYG5nZaC.read(jOc8eoYj);
				jOc8eoYj.position(0);
				short UGX9u7Su = jOc8eoYj.getShort();
				int dJdqcRxa = jOc8eoYj.getInt();
				byte kvjkC2un = jOc8eoYj.get();
				jOc8eoYj.clear();
				if (cpYD3Cwy.containsKey(dJdqcRxa)) {
					TIntArrayList Cljsbied = (TIntArrayList) cpYD3Cwy.get(dJdqcRxa);
					Cljsbied.add(GWRc1M1B);
					cpYD3Cwy.put(dJdqcRxa, Cljsbied);
				} else {
					TIntArrayList JMd84D8e = new TIntArrayList();
					JMd84D8e.add(GWRc1M1B);
					cpYD3Cwy.put(dJdqcRxa, JMd84D8e);
				}
			}
			int[] AIIEaqdH = cpYD3Cwy.keys();
			Arrays.sort(AIIEaqdH);
			int z7LzFZys = 1;
			for (int bBy4z6Yg = 0; bBy4z6Yg < AIIEaqdH.length; bBy4z6Yg++) {
				int QguJdlU9 = AIIEaqdH[bBy4z6Yg];
				TIntArrayList rxiwKVQk = (TIntArrayList) cpYD3Cwy.get(QguJdlU9);
				int D7SuwktH = rxiwKVQk.size();
				ByteBuffer hCog3U5t = ByteBuffer.allocate(12);
				hCog3U5t.putInt(QguJdlU9);
				hCog3U5t.putInt(z7LzFZys);
				hCog3U5t.putInt(z7LzFZys + D7SuwktH - 1);
				hCog3U5t.flip();
				QHBZrTg8.write(hCog3U5t);
				z7LzFZys += D7SuwktH;
				for (int dNjWK9IB = 0; dNjWK9IB < rxiwKVQk.size(); dNjWK9IB++) {
					ByteBuffer m7BJDblH = ByteBuffer.allocate(4);
					m7BJDblH.putInt(rxiwKVQk.get(dNjWK9IB));
					m7BJDblH.flip();
					HE7pQVHP.write(m7BJDblH);
				}
			}
			QYG5nZaC.close();
			QHBZrTg8.close();
			HE7pQVHP.close();
			return true;
		} catch (IOException ojGW2fhF) {
			System.err.println(ojGW2fhF);
			return false;
		}
	}

}
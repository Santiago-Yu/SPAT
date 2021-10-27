class n7872659 {
	private static boolean genCustRatingFileAndMovieIndexFile(String uiT9YIQY, String dTU4Enup, String lZhPm9ue,
			String EWI1W0c5) {
		try {
			File IhBZlcTr = new File(uiT9YIQY + fSep + "SmartGRAPE" + fSep + dTU4Enup);
			FileChannel sQSnQ0l3 = new FileInputStream(IhBZlcTr).getChannel();
			File O9onDq2j = new File(uiT9YIQY + fSep + "SmartGRAPE" + fSep + EWI1W0c5);
			FileChannel KVjpRGfu = new FileOutputStream(O9onDq2j, true).getChannel();
			File xPiEnATb = new File(uiT9YIQY + fSep + "SmartGRAPE" + fSep + lZhPm9ue);
			FileChannel noca8pAD = new FileOutputStream(xPiEnATb, true).getChannel();
			int yHsTAaXn = (int) sQSnQ0l3.size();
			int qYqL3kzC = yHsTAaXn / 7;
			ByteBuffer WFPogBd4 = sQSnQ0l3.map(FileChannel.MapMode.READ_ONLY, 0, yHsTAaXn);
			int P1FejKFo = 1, Lis02BMD = 0;
			short tRNBYzKg = 1;
			while (WFPogBd4.hasRemaining()) {
				Lis02BMD++;
				short nTiC82s3 = WFPogBd4.getShort();
				int CvsAZ01k = WFPogBd4.getInt();
				byte RUMg52GB = WFPogBd4.get();
				if (nTiC82s3 != tRNBYzKg) {
					ByteBuffer UPUOiW9o = ByteBuffer.allocate(10);
					UPUOiW9o.putShort(tRNBYzKg);
					UPUOiW9o.putInt(P1FejKFo);
					UPUOiW9o.putInt(Lis02BMD - 1);
					UPUOiW9o.flip();
					KVjpRGfu.write(UPUOiW9o);
					tRNBYzKg = nTiC82s3;
					P1FejKFo = Lis02BMD;
				}
				ByteBuffer HbwQ8PQv = ByteBuffer.allocate(5);
				HbwQ8PQv.putInt(CvsAZ01k);
				HbwQ8PQv.put(RUMg52GB);
				HbwQ8PQv.flip();
				noca8pAD.write(HbwQ8PQv);
			}
			ByteBuffer Q27sj7yl = ByteBuffer.allocate(10);
			Q27sj7yl.putShort(tRNBYzKg);
			Q27sj7yl.putInt(P1FejKFo);
			Q27sj7yl.putInt(100480506);
			Q27sj7yl.flip();
			KVjpRGfu.write(Q27sj7yl);
			KVjpRGfu.close();
			noca8pAD.close();
			return true;
		} catch (IOException UxA5UcN1) {
			System.err.println(UxA5UcN1);
			return false;
		}
	}

}
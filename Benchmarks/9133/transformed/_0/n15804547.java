class n15804547 {
	protected static void copyOrMove(File gK94Hlme, File P91jQ01E, boolean ljZKRSzg) throws IOException {
		String[] iBMj6yyd;
		int BR5vzKyW;
		InputStream Ey4bk5XD;
		OutputStream mZqO07r8;
		byte[] nDW3xuQF;
		int uGxgWRDo;
		if (gK94Hlme.isDirectory()) {
			if (!P91jQ01E.exists())
				P91jQ01E.mkdir();
			iBMj6yyd = gK94Hlme.list();
			for (BR5vzKyW = 0; BR5vzKyW < iBMj6yyd.length; BR5vzKyW++) {
				copyOrMove(new File(gK94Hlme, iBMj6yyd[BR5vzKyW]), new File(P91jQ01E, iBMj6yyd[BR5vzKyW]), ljZKRSzg);
			}
			if (ljZKRSzg)
				gK94Hlme.delete();
		} else {
			Ey4bk5XD = new FileInputStream(gK94Hlme);
			if (P91jQ01E.isDirectory())
				mZqO07r8 = new FileOutputStream(P91jQ01E.getAbsolutePath() + File.separator + gK94Hlme.getName());
			else
				mZqO07r8 = new FileOutputStream(P91jQ01E);
			nDW3xuQF = new byte[1024];
			while ((uGxgWRDo = Ey4bk5XD.read(nDW3xuQF)) > 0)
				mZqO07r8.write(nDW3xuQF, 0, uGxgWRDo);
			Ey4bk5XD.close();
			mZqO07r8.close();
			if (ljZKRSzg)
				gK94Hlme.delete();
		}
	}

}
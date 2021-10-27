class n11322572 {
	private void preprocessImages(GeoImage[] tN1pFbwF) throws IOException {
		for (int JPjFAps8 = 0; JPjFAps8 < tN1pFbwF.length; JPjFAps8++) {
			BufferedImage LuqR6LiO = loadImage(tN1pFbwF[JPjFAps8].getPath());
			tN1pFbwF[JPjFAps8].setLatDim(LuqR6LiO.getHeight());
			tN1pFbwF[JPjFAps8].setLonDim(LuqR6LiO.getWidth());
			freeImage(LuqR6LiO);
			String hYIwWyRR = tN1pFbwF[JPjFAps8].getPath();
			int VvNrDlVh = hYIwWyRR.lastIndexOf(".");
			VvNrDlVh = VvNrDlVh < 0 ? 0 : VvNrDlVh;
			String l3XBnZwH = VvNrDlVh < 1 ? hYIwWyRR : hYIwWyRR.substring(0, VvNrDlVh + 3) + "w";
			System.out.println("filename " + l3XBnZwH);
			File VxUEZcGg = new File(l3XBnZwH);
			if (!VxUEZcGg.exists()) {
				System.out.println("Rez: Could not find file: " + l3XBnZwH);
				debug("Rez: Could not find directory: " + l3XBnZwH);
				throw new IOException("File not Found");
			}
			BufferedReader n3g3PFny = new BufferedReader(new InputStreamReader(new FileInputStream(VxUEZcGg)));
			if (staticDebugOn)
				debug("b4nextline: ");
			line = n3g3PFny.readLine();
			if (staticDebugOn)
				debug("line: " + line);
			if (line != null) {
				tokenizer = new StringTokenizer(line, " \n\t\r\"", false);
				tN1pFbwF[JPjFAps8].setLonSpacing(Double.valueOf(tokenizer.nextToken()).doubleValue());
				tN1pFbwF[JPjFAps8].setLonExtent(
						tN1pFbwF[JPjFAps8].getLonSpacing() * ((double) tN1pFbwF[JPjFAps8].getLonDim() - 1d));
				System.out.println("setLonExtent " + tN1pFbwF[JPjFAps8].getLonExtent());
				line = n3g3PFny.readLine();
				if (staticDebugOn)
					debug("skip line: " + line);
				line = n3g3PFny.readLine();
				if (staticDebugOn)
					debug("skip line: " + line);
				line = n3g3PFny.readLine();
				if (staticDebugOn)
					debug("line: " + line);
				tokenizer = new StringTokenizer(line, " \n\t\r\"", false);
				tN1pFbwF[JPjFAps8].setLatSpacing(Double.valueOf(tokenizer.nextToken()).doubleValue());
				tN1pFbwF[JPjFAps8].setLatExtent(
						tN1pFbwF[JPjFAps8].getLatSpacing() * ((double) tN1pFbwF[JPjFAps8].getLatDim() - 1d));
				line = n3g3PFny.readLine();
				if (staticDebugOn)
					debug("line: " + line);
				tokenizer = new StringTokenizer(line, " \n\t\r\"", false);
				tN1pFbwF[JPjFAps8].setLon(Double.valueOf(tokenizer.nextToken()).doubleValue());
				line = n3g3PFny.readLine();
				if (staticDebugOn)
					debug("line: " + line);
				tokenizer = new StringTokenizer(line, " \n\t\r\"", false);
				tN1pFbwF[JPjFAps8].setLat(Double.valueOf(tokenizer.nextToken()).doubleValue());
				int BuntdgAf = hYIwWyRR.lastIndexOf(java.io.File.separator);
				BuntdgAf = BuntdgAf < 0 ? 0 : BuntdgAf;
				if (BuntdgAf == 0) {
					BuntdgAf = hYIwWyRR.lastIndexOf("/");
					BuntdgAf = BuntdgAf < 0 ? 0 : BuntdgAf;
				}
				l3XBnZwH = BuntdgAf < 1 ? hYIwWyRR : hYIwWyRR.substring(BuntdgAf + 1, hYIwWyRR.length());
				System.out.println("filename " + destinationDirectory + XPlat.fileSep + l3XBnZwH);
				tN1pFbwF[JPjFAps8].setPath(l3XBnZwH);
				DataInputStream xw9JaliR = new DataInputStream(new BufferedInputStream(new FileInputStream(hYIwWyRR)));
				DataOutputStream NLu4uX5Q = new DataOutputStream(new BufferedOutputStream(
						new FileOutputStream(destinationDirectory + XPlat.fileSep + l3XBnZwH)));
				System.out.println("copying to " + destinationDirectory + XPlat.fileSep + l3XBnZwH);
				for (;;) {
					try {
						NLu4uX5Q.writeShort(xw9JaliR.readShort());
					} catch (EOFException R7YA9ZEi) {
						break;
					} catch (IOException idZP1ZV5) {
						break;
					}
				}
				NLu4uX5Q.close();
			} else {
				System.out.println("Rez: ERROR: World file for image is null");
			}
		}
	}

}
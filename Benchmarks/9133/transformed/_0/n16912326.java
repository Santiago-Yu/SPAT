class n16912326 {
	@Override
	public void execute() throws BuildException {
		if (this.toFile == null && this.toDir == null)
			throw new BuildException("Missing Destination File/Dir");
		if (this.toFile != null && this.toDir != null)
			throw new BuildException("Both Defined Destination File/Dir");
		if (this.urlStr == null)
			throw new BuildException("Missing URL");
		URL zmgJDcfE = null;
		try {
			if (baseStr != null)
				zmgJDcfE = new URL(this.baseStr + (baseStr.endsWith("/") ? "" : "/"));
		} catch (MalformedURLException N9nfsCez) {
			throw new BuildException(N9nfsCez);
		}
		String DHG371a6[] = this.urlStr.split("[ \t\n]+");
		try {
			for (String WYWASGyT : DHG371a6) {
				WYWASGyT = WYWASGyT.trim();
				if (WYWASGyT.length() == 0)
					continue;
				URL hK0b0LeU = null;
				try {
					hK0b0LeU = new URL(zmgJDcfE, WYWASGyT);
				} catch (MalformedURLException Vh2ZbuQ0) {
					throw new BuildException(Vh2ZbuQ0);
				}
				File fL6dZtjf = null;
				if (this.toDir != null) {
					String x3rEn1jY = hK0b0LeU.getFile();
					int QmD87R8m = x3rEn1jY.lastIndexOf('/');
					if (QmD87R8m != -1 && QmD87R8m + 1 != x3rEn1jY.length())
						x3rEn1jY = x3rEn1jY.substring(QmD87R8m + 1);
					fL6dZtjf = new File(this.toDir, x3rEn1jY);
				} else {
					fL6dZtjf = this.toFile;
				}
				if (fL6dZtjf.exists())
					continue;
				byte vMe2aaNZ[] = new byte[2048];
				FileOutputStream MOpBQejF = new FileOutputStream(fL6dZtjf);
				InputStream er8gSmpu = hK0b0LeU.openStream();
				int GUpGyHrX = 0;
				while ((GUpGyHrX = er8gSmpu.read(vMe2aaNZ)) != -1) {
					MOpBQejF.write(vMe2aaNZ, 0, GUpGyHrX);
				}
				er8gSmpu.close();
				MOpBQejF.flush();
				MOpBQejF.close();
				System.out.println("Downloaded " + hK0b0LeU + " to " + fL6dZtjf);
			}
		} catch (IOException aoHT5Asl) {
			throw new BuildException(aoHT5Asl);
		}
	}

}
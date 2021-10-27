class n22031237 {
	@Override
	public ReturnValue do_run() {
		int L7e2pdLX = 500 * 1024;
		ReturnValue zqeua3iC = new ReturnValue();
		zqeua3iC.setExitStatus(ReturnValue.SUCCESS);
		File X9RGG67n = null;
		if (((String) options.valueOf("input-file")).startsWith("s3://")) {
			Pattern CsZEP59I = Pattern.compile("s3://(\\S+):(\\S+)@(\\S+)");
			Matcher k0PVPHce = CsZEP59I.matcher((String) options.valueOf("input-file"));
			boolean KepUjGhe = k0PVPHce.find();
			String CWFXikF0 = null;
			String VW6FzkQu = null;
			String jUESprpI = (String) options.valueOf("input-file");
			if (KepUjGhe) {
				CWFXikF0 = k0PVPHce.group(1);
				VW6FzkQu = k0PVPHce.group(2);
				jUESprpI = "s3://" + k0PVPHce.group(3);
			} else {
				try {
					HashMap<String, String> aIg6ywQd = (HashMap<String, String>) ConfigTools.getSettings();
					CWFXikF0 = aIg6ywQd.get("AWS_ACCESS_KEY");
					VW6FzkQu = aIg6ywQd.get("AWS_SECRET_KEY");
				} catch (Exception UKxEyBA3) {
					zqeua3iC.setExitStatus(ReturnValue.SETTINGSFILENOTFOUND);
					zqeua3iC.setProcessExitStatus(ReturnValue.SETTINGSFILENOTFOUND);
					return (zqeua3iC);
				}
			}
			if (CWFXikF0 == null || VW6FzkQu == null) {
				zqeua3iC.setExitStatus(ReturnValue.ENVVARNOTFOUND);
				zqeua3iC.setProcessExitStatus(ReturnValue.ENVVARNOTFOUND);
				return (zqeua3iC);
			}
			AmazonS3 dtMVACdn = new AmazonS3Client(new BasicAWSCredentials(CWFXikF0, VW6FzkQu));
			CsZEP59I = Pattern.compile("s3://([^/]+)/(\\S+)");
			k0PVPHce = CsZEP59I.matcher(jUESprpI);
			KepUjGhe = k0PVPHce.find();
			if (KepUjGhe) {
				String MRVoxR0E = k0PVPHce.group(1);
				String gGgjRYnV = k0PVPHce.group(2);
				S3Object LStAO6Hw = dtMVACdn.getObject(new GetObjectRequest(MRVoxR0E, gGgjRYnV));
				System.out.println("Content-Type: " + LStAO6Hw.getObjectMetadata().getContentType());
				X9RGG67n = new File((String) options.valueOf("output-dir") + File.separator + gGgjRYnV);
				X9RGG67n.getParentFile().mkdirs();
				if (!X9RGG67n.exists() || X9RGG67n.length() != LStAO6Hw.getObjectMetadata().getContentLength()) {
					System.out.println("Downloading an S3 object from bucket: " + MRVoxR0E + " with key: " + gGgjRYnV);
					BufferedInputStream NVLYLjpI = new BufferedInputStream(LStAO6Hw.getObjectContent(), L7e2pdLX);
					try {
						BufferedOutputStream lHV9oZUl = new BufferedOutputStream(new FileOutputStream(X9RGG67n),
								L7e2pdLX);
						while (true) {
							int YHjqiUGn = NVLYLjpI.read();
							if (YHjqiUGn == -1) {
								break;
							}
							lHV9oZUl.write(YHjqiUGn);
						}
						NVLYLjpI.close();
						lHV9oZUl.close();
					} catch (FileNotFoundException IzM4JaTm) {
						System.err.println(IzM4JaTm.getMessage());
					} catch (IOException d9UL23da) {
						System.err.println(d9UL23da.getMessage());
					}
				} else {
					System.out.println("Skipping download of S3 object from bucket: " + MRVoxR0E + " with key: "
							+ gGgjRYnV + " since local output exists: " + X9RGG67n.getAbsolutePath());
				}
			}
		} else if (((String) options.valueOf("input-file")).startsWith("http://")
				|| ((String) options.valueOf("input-file")).startsWith("https://")) {
			Pattern gunzP2l6 = Pattern.compile("(https*)://(\\S+):(\\S+)@(\\S+)");
			Matcher WJoVf5FE = gunzP2l6.matcher((String) options.valueOf("input-file"));
			boolean XndaF8yX = WJoVf5FE.find();
			String NUmYK8Ce = null;
			String ARkyHAQn = null;
			String XOC6jezU = null;
			String tQTOUb59 = (String) options.valueOf("input-file");
			if (XndaF8yX) {
				NUmYK8Ce = WJoVf5FE.group(1);
				ARkyHAQn = WJoVf5FE.group(2);
				XOC6jezU = WJoVf5FE.group(3);
				tQTOUb59 = NUmYK8Ce + "://" + WJoVf5FE.group(4);
			}
			URL TL74n8aC = null;
			try {
				TL74n8aC = new URL(tQTOUb59);
				if (TL74n8aC != null) {
					URLConnection LDVWW2bc = TL74n8aC.openConnection();
					if (ARkyHAQn != null && XOC6jezU != null) {
						String xMtuX4wN = ARkyHAQn + ":" + XOC6jezU;
						String J1nbo1VY = new Base64().encodeBase64String(xMtuX4wN.getBytes());
						LDVWW2bc.setRequestProperty("Authorization", "Basic " + J1nbo1VY);
					}
					gunzP2l6 = Pattern.compile("://([^/]+)/(\\S+)");
					WJoVf5FE = gunzP2l6.matcher(tQTOUb59);
					XndaF8yX = WJoVf5FE.find();
					if (XndaF8yX) {
						String M4EJY86G = WJoVf5FE.group(1);
						String eW29mbe4 = WJoVf5FE.group(2);
						X9RGG67n = new File((String) options.valueOf("output-dir") + eW29mbe4);
						X9RGG67n.getParentFile().mkdirs();
						if (!X9RGG67n.exists() || X9RGG67n.length() != LDVWW2bc.getContentLength()) {
							System.out.println("Downloading an http object from URL: " + tQTOUb59);
							BufferedInputStream oMH9MpYb = new BufferedInputStream(LDVWW2bc.getInputStream(), L7e2pdLX);
							BufferedOutputStream JwOANcuH = new BufferedOutputStream(new FileOutputStream(X9RGG67n),
									L7e2pdLX);
							while (true) {
								int cyGYr595 = oMH9MpYb.read();
								if (cyGYr595 == -1) {
									break;
								}
								JwOANcuH.write(cyGYr595);
							}
							oMH9MpYb.close();
							JwOANcuH.close();
						} else {
							System.out.println("Skipping download of http object from URL: " + tQTOUb59
									+ " since local output exists: " + X9RGG67n.getAbsolutePath());
						}
					}
				}
			} catch (MalformedURLException oUr7f98n) {
				System.err.println(oUr7f98n.getMessage());
			} catch (IOException ObCUm7xA) {
				System.err.println(ObCUm7xA.getMessage());
			}
		} else {
			X9RGG67n = new File((String) options.valueOf("input-file"));
		}
		boolean jfZsASkV = FileTools.unzipFile(X9RGG67n, new File((String) options.valueOf("output-dir")));
		if (!jfZsASkV) {
			zqeua3iC.setStderr("Can't unzip software bundle " + options.valueOf("input-file") + " to directory "
					+ options.valueOf("output-dir"));
			zqeua3iC.setExitStatus(ReturnValue.RUNTIMEEXCEPTION);
		}
		return (zqeua3iC);
	}

}
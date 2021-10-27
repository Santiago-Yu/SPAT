class n22031237 {
	@Override
	public ReturnValue do_run() {
		int bufLen = 500 * 1024;
		ReturnValue ret = new ReturnValue();
		ret.setExitStatus(ReturnValue.SUCCESS);
		File output = null;
		if (((String) options.valueOf("input-file")).startsWith("s3://")) {
			Pattern p = Pattern.compile("s3://(\\S+):(\\S+)@(\\S+)");
			Matcher m = p.matcher((String) options.valueOf("input-file"));
			boolean result = m.find();
			String accessKey = null;
			String secretKey = null;
			String URL = (String) options.valueOf("input-file");
			if (result) {
				accessKey = m.group(1);
				secretKey = m.group(2);
				URL = "s3://" + m.group(3);
			} else {
				try {
					HashMap<String, String> settings = (HashMap<String, String>) ConfigTools.getSettings();
					accessKey = settings.get("AWS_ACCESS_KEY");
					secretKey = settings.get("AWS_SECRET_KEY");
				} catch (Exception e) {
					ret.setExitStatus(ReturnValue.SETTINGSFILENOTFOUND);
					ret.setProcessExitStatus(ReturnValue.SETTINGSFILENOTFOUND);
					return (ret);
				}
			}
			if (null == accessKey || null == secretKey) {
				ret.setExitStatus(ReturnValue.ENVVARNOTFOUND);
				ret.setProcessExitStatus(ReturnValue.ENVVARNOTFOUND);
				return (ret);
			}
			AmazonS3 s3 = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));
			p = Pattern.compile("s3://([^/]+)/(\\S+)");
			m = p.matcher(URL);
			result = m.find();
			if (result) {
				String bucket = m.group(1);
				String key = m.group(2);
				S3Object object = s3.getObject(new GetObjectRequest(bucket, key));
				System.out.println("Content-Type: " + object.getObjectMetadata().getContentType());
				output = new File((String) options.valueOf("output-dir") + File.separator + key);
				output.getParentFile().mkdirs();
				if (!output.exists() || output.length() != object.getObjectMetadata().getContentLength()) {
					System.out.println("Downloading an S3 object from bucket: " + bucket + " with key: " + key);
					BufferedInputStream reader = new BufferedInputStream(object.getObjectContent(), bufLen);
					try {
						BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(output), bufLen);
						while (true) {
							int data = reader.read();
							if (-1 == data) {
								break;
							}
							writer.write(data);
						}
						reader.close();
						writer.close();
					} catch (FileNotFoundException e) {
						System.err.println(e.getMessage());
					} catch (IOException e) {
						System.err.println(e.getMessage());
					}
				} else {
					System.out.println("Skipping download of S3 object from bucket: " + bucket + " with key: " + key
							+ " since local output exists: " + output.getAbsolutePath());
				}
			}
		} else if (((String) options.valueOf("input-file")).startsWith("http://")
				|| ((String) options.valueOf("input-file")).startsWith("https://")) {
			Pattern p = Pattern.compile("(https*)://(\\S+):(\\S+)@(\\S+)");
			Matcher m = p.matcher((String) options.valueOf("input-file"));
			boolean result = m.find();
			String protocol = null;
			String user = null;
			String pass = null;
			String URL = (String) options.valueOf("input-file");
			if (result) {
				protocol = m.group(1);
				user = m.group(2);
				pass = m.group(3);
				URL = protocol + "://" + m.group(4);
			}
			URL urlObj = null;
			try {
				urlObj = new URL(URL);
				if (urlObj != null) {
					URLConnection urlConn = urlObj.openConnection();
					if (user != null && pass != null) {
						String userPassword = user + ":" + pass;
						String encoding = new Base64().encodeBase64String(userPassword.getBytes());
						urlConn.setRequestProperty("Authorization", "Basic " + encoding);
					}
					p = Pattern.compile("://([^/]+)/(\\S+)");
					m = p.matcher(URL);
					result = m.find();
					if (result) {
						String host = m.group(1);
						String path = m.group(2);
						output = new File((String) options.valueOf("output-dir") + path);
						output.getParentFile().mkdirs();
						if (!output.exists() || output.length() != urlConn.getContentLength()) {
							System.out.println("Downloading an http object from URL: " + URL);
							BufferedInputStream reader = new BufferedInputStream(urlConn.getInputStream(), bufLen);
							BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(output),
									bufLen);
							while (true) {
								int data = reader.read();
								if (-1 == data) {
									break;
								}
								writer.write(data);
							}
							reader.close();
							writer.close();
						} else {
							System.out.println("Skipping download of http object from URL: " + URL
									+ " since local output exists: " + output.getAbsolutePath());
						}
					}
				}
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} else {
			output = new File((String) options.valueOf("input-file"));
		}
		boolean result = FileTools.unzipFile(output, new File((String) options.valueOf("output-dir")));
		if (!result) {
			ret.setStderr("Can't unzip software bundle " + options.valueOf("input-file") + " to directory "
					+ options.valueOf("output-dir"));
			ret.setExitStatus(ReturnValue.RUNTIMEEXCEPTION);
		}
		return (ret);
	}

}
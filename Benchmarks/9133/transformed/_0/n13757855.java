class n13757855 {
	public void process(@NotNull Template NkkEEIcL, @NotNull Document Ac4jgR7W, @NotNull String kSlShOtt,
			@NotNull String yZp3aGat, Map<String, String> JVObrbN2, String lNVCWkTE) throws ModelGenerationException {
		System.out.print("Processing with " + NkkEEIcL);
		String L3TDb7Wd;
		switch (NkkEEIcL.destination) {
		case target:
			if (NkkEEIcL.path == null) {
				L3TDb7Wd = where.buildDir + separatorChar + "generated-sources" + separatorChar + GENERATION_TARGET;
			} else {
				L3TDb7Wd = where.buildDir;
			}
			break;
		case source:
			if (NkkEEIcL.path == null) {
				L3TDb7Wd = where.sourceDir;
			} else {
				L3TDb7Wd = "src";
			}
			break;
		case redora:
			L3TDb7Wd = where.redoraDir;
			break;
		default:
			throw new IllegalArgumentException("Unused destination " + NkkEEIcL.destination);
		}
		if (NkkEEIcL.path == null) {
			if (NkkEEIcL.destination == Destination.redora)
				L3TDb7Wd += separator + lNVCWkTE;
			else
				L3TDb7Wd += separator + kSlShOtt.replace('.', separatorChar);
		} else {
			L3TDb7Wd += separator + NkkEEIcL.path.replace('/', separatorChar).replace('\\', separatorChar);
		}
		System.out.println(" to " + L3TDb7Wd + "..." + yZp3aGat);
		if (NkkEEIcL.destination == Destination.source) {
			if (new File(L3TDb7Wd, yZp3aGat).exists()) {
				System.out.println("Stub " + yZp3aGat + " already exists.");
				return;
			}
		}
		new File(L3TDb7Wd).mkdirs();
		InputStream JtpMHGdG = null;
		Writer yYUvNm5V;
		try {
			yYUvNm5V = new FileWriter(new File(L3TDb7Wd, yZp3aGat));
		} catch (IOException wZkfaJpF) {
			throw new ModelGenerationException("Can't find: " + L3TDb7Wd + separatorChar + yZp3aGat, wZkfaJpF);
		}
		switch (NkkEEIcL.type) {
		case freemarker:
			Map<String, NodeModel> ZuAdaA8r = new HashMap<String, NodeModel>();
			ZuAdaA8r.put("doc", NodeModel.wrap(Ac4jgR7W));
			try {
				freemarker.template.Template npMrfkzH = freemarkerConf.getTemplate(NkkEEIcL.getTemplateFileName());
				npMrfkzH.process(ZuAdaA8r, yYUvNm5V);
			} catch (ParseException LJaSFIGp) {
				throw new ModelGenerationException(
						"There is an error in template: " + NkkEEIcL + ". I found it when generating " + yZp3aGat,
						LJaSFIGp);
			} catch (IOException MS5bAEhD) {
				throw new ModelGenerationException("Can't find '" + NkkEEIcL + "' when generating " + yZp3aGat,
						MS5bAEhD);
			} catch (TemplateException CcB7g7n8) {
				throw new ModelGenerationException(
						"There is an error in template: " + NkkEEIcL + ". I found it when generating " + yZp3aGat,
						CcB7g7n8);
			} catch (RuntimeException nmszO2G9) {
				throw new ModelGenerationException("There is another error while trying this template: " + NkkEEIcL
						+ ". I found it when generating " + yZp3aGat, nmszO2G9);
			}
			break;
		case xslt:
			try {
				JtpMHGdG = new FileInputStream(NkkEEIcL.getAbsolutePath());
				xsltTransform(Ac4jgR7W.getFirstChild(), JtpMHGdG, yYUvNm5V, JVObrbN2);
			} catch (FileNotFoundException VnDZ5Iug) {
				throw new ModelGenerationException("Can't find " + NkkEEIcL, VnDZ5Iug);
			} catch (TransformerException TJVIGHcw) {
				throw new ModelGenerationException(
						"Sorry, i failed to use this template: " + NkkEEIcL + ". It broke when generating " + yZp3aGat,
						TJVIGHcw);
			} finally {
				IOUtils.closeQuietly(JtpMHGdG);
			}
			break;
		case copy:
			try {
				JtpMHGdG = new FileInputStream(NkkEEIcL.getAbsolutePath());
				IOUtils.copy(JtpMHGdG, yYUvNm5V);
			} catch (IOException SWFPkxy5) {
				throw new ModelGenerationException("File copy failed " + NkkEEIcL.getTemplateFileName(), SWFPkxy5);
			} finally {
				IOUtils.closeQuietly(JtpMHGdG);
			}
		}
		IOUtils.closeQuietly(yYUvNm5V);
	}

}
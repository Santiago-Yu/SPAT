class n4895903 {
	public List load(String AnRjYEXy, Object NzafrXrt, String ZQplXHpm) throws Exception {
		if (log.isTraceEnabled()) {
			log.trace("load " + NzafrXrt);
		}
		String wgnwAraS = null;
		String yJ7LoHXE = null;
		Object vIvTyKdX = null;
		if (NzafrXrt instanceof DynamicMBean) {
			AnRjYEXy = "MbeansDescriptorsDynamicMBeanSource";
			vIvTyKdX = NzafrXrt;
		} else if (NzafrXrt instanceof URL) {
			URL wMlpq2tH = (URL) NzafrXrt;
			wgnwAraS = wMlpq2tH.toString();
			yJ7LoHXE = ZQplXHpm;
			vIvTyKdX = wMlpq2tH.openStream();
			if (AnRjYEXy == null) {
				AnRjYEXy = sourceTypeFromExt(wgnwAraS);
			}
		} else if (NzafrXrt instanceof File) {
			wgnwAraS = ((File) NzafrXrt).getAbsolutePath();
			vIvTyKdX = new FileInputStream((File) NzafrXrt);
			yJ7LoHXE = ZQplXHpm;
			if (AnRjYEXy == null) {
				AnRjYEXy = sourceTypeFromExt(wgnwAraS);
			}
		} else if (NzafrXrt instanceof InputStream) {
			yJ7LoHXE = ZQplXHpm;
			vIvTyKdX = NzafrXrt;
		} else if (NzafrXrt instanceof Class) {
			wgnwAraS = ((Class) NzafrXrt).getName();
			yJ7LoHXE = ZQplXHpm;
			vIvTyKdX = NzafrXrt;
			if (AnRjYEXy == null) {
				AnRjYEXy = "MbeansDescriptorsIntrospectionSource";
			}
		}
		if (AnRjYEXy == null) {
			AnRjYEXy = "MbeansDescriptorsDigesterSource";
		}
		ModelerSource joqhdsZd = getModelerSource(AnRjYEXy);
		List eTIIyeRb = joqhdsZd.loadDescriptors(this, wgnwAraS, yJ7LoHXE, vIvTyKdX);
		return eTIIyeRb;
	}

}
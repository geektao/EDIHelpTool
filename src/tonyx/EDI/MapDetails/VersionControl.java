package tonyx.EDI.MapDetails;

final public class VersionControl {
	private String ediSerializationVersion;
	private String ediMajorVersion;
	private String ediMinorVersion;
	private String ediCompiledDate;

	public String getEdiSerializationVersion() {
		return ediSerializationVersion;
	}

	public void setEdiSerializationVersion(String ediSerializationVersion) {
		this.ediSerializationVersion = ediSerializationVersion;
	}

	public String getEdiMajorVersion() {
		return ediMajorVersion;
	}

	public void setEdiMajorVersion(String ediMajorVersion) {
		this.ediMajorVersion = ediMajorVersion;
	}

	public String getEdiMinorVersion() {
		return ediMinorVersion;
	}

	public void setEdiMinorVersion(String ediMinorVersion) {
		this.ediMinorVersion = ediMinorVersion;
	}

	public String getEdiCompiledDate() {
		return ediCompiledDate;
	}

	public void setEdiCompiledDate(String ediCompiledDate) {
		this.ediCompiledDate = ediCompiledDate;
	}
}

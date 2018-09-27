package tonyx.EDI.Common;

final public class StoreLimit implements Cloneable {
	private String ediMaxLen;
	private String ediMinLen;
	private String ediSigned;
	private String ediDataType;
	private String ediImpliedDecimalPos;
	private String ediImplicitDecimal;
	private String ediAllowSignedDecimal;
	private String ediFormat;
	private String ediBinaryOutput;
	private String ediBinaryWidth;

	@Override
	public StoreLimit clone() {
		StoreLimit obj = null;
		try {
			obj = (StoreLimit) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public String getEdiMaxLen() {
		return ediMaxLen;
	}

	public void setEdiMaxLen(String ediMaxLen) {
		this.ediMaxLen = ediMaxLen;
	}

	public String getEdiMinLen() {
		return ediMinLen;
	}

	public void setEdiMinLen(String ediMinLen) {
		this.ediMinLen = ediMinLen;
	}

	public String getEdiSigned() {
		return ediSigned;
	}

	public void setEdiSigned(String ediSigned) {
		this.ediSigned = ediSigned;
	}

	public String getEdiDataType() {
		return ediDataType;
	}

	public void setEdiDataType(String ediDataType) {
		this.ediDataType = ediDataType;
	}

	public String getEdiImpliedDecimalPos() {
		return ediImpliedDecimalPos;
	}

	public void setEdiImpliedDecimalPos(String ediImpliedDecimalPos) {
		this.ediImpliedDecimalPos = ediImpliedDecimalPos;
	}

	public String getEdiImplicitDecimal() {
		return ediImplicitDecimal;
	}

	public void setEdiImplicitDecimal(String ediImplicitDecimal) {
		this.ediImplicitDecimal = ediImplicitDecimal;
	}

	public String getEdiAllowSignedDecimal() {
		return ediAllowSignedDecimal;
	}

	public void setEdiAllowSignedDecimal(String ediAllowSignedDecimal) {
		this.ediAllowSignedDecimal = ediAllowSignedDecimal;
	}

	public String getEdiFormat() {
		return ediFormat;
	}

	public void setEdiFormat(String ediFormat) {
		this.ediFormat = ediFormat;
	}

	public String getEdiBinaryOutput() {
		return ediBinaryOutput;
	}

	public void setEdiBinaryOutput(String ediBinaryOutput) {
		this.ediBinaryOutput = ediBinaryOutput;
	}

	public String getEdiBinaryWidth() {
		return ediBinaryWidth;
	}

	public void setEdiBinaryWidth(String ediBinaryWidth) {
		this.ediBinaryWidth = ediBinaryWidth;
	}
}

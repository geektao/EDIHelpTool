package tonyx.EDI.Common;

final public class Accumulator {
	private String ediAccumulatorID;
	private String ediAccumulatorName;
	private String ediAccumulatorAction;
	private String ediAccumulatorAlternate;

	public String getEdiAccumulatorID() {
		return ediAccumulatorID;
	}

	public void setEdiAccumulatorID(String ediAccumulatorID) {
		this.ediAccumulatorID = ediAccumulatorID;
	}

	public String getEdiAccumulatorName() {
		return ediAccumulatorName;
	}

	public void setEdiAccumulatorName(String ediAccumulatorName) {
		this.ediAccumulatorName = ediAccumulatorName;
	}

	public String getEdiAccumulatorAction() {
		return ediAccumulatorAction;
	}

	public void setEdiAccumulatorAction(String ediAccumulatorAction) {
		this.ediAccumulatorAction = ediAccumulatorAction;
	}

	public String getEdiAccumulatorAlternate() {
		return ediAccumulatorAlternate;
	}

	public void setEdiAccumulatorAlternate(String ediAccumulatorAlternate) {
		this.ediAccumulatorAlternate = ediAccumulatorAlternate;
	}
}

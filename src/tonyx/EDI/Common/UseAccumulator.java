package tonyx.EDI.Common;

import tonyx.EDI.Accumulators.Accumulator;

final public class UseAccumulator {
	private Accumulator ediAccumulator;

	public Accumulator getEdiAccumulator() {
		return ediAccumulator;
	}

	public void setEdiAccumulator(Accumulator ediAccumulator) {
		this.ediAccumulator = ediAccumulator;
	}
}

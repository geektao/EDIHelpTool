package tonyx.EDI.Accumulators;

import java.util.ArrayList;
import java.util.List;

final public class Accumulators {
	private List<Accumulator> ediAccumulator;

	public Accumulators() {
		ediAccumulator = new ArrayList<Accumulator>();
	}

	public List<Accumulator> getEdiAccumulator() {
		return ediAccumulator;
	}

	public void setEdiAccumulator(Accumulator ediAccumulator) {
		this.ediAccumulator.add(ediAccumulator);
	}
}

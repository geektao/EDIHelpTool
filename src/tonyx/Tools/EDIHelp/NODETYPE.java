package tonyx.Tools.EDIHelp;

public class NODETYPE {
	public static final int GROUP = 9;
	public static final int XMLElementGroup = 8;
	public static final int XMLParticleGroup = 7;
	public static final int XMLRecord = 4;
	public static final int SEGMENT = 3;
	public static final int POSRECORD = 2;
	public static final int COMPOSITE = 1;
	public static final int FIELD = 0;

	public static int typeNumber(String type) {
		if ("Group".equals(type)) {
			return GROUP;
		} else if ("XMLElementGroup".equals(type)) {
			return XMLElementGroup;
		} else if ("XMLParticleGroup".equals(type)) {
			return XMLParticleGroup;
		} else if ("XMLRecord".equals(type)) {
			return XMLRecord;
		} else if ("Segment".equals(type)) {
			return SEGMENT;
		} else if ("PosRecord".equals(type)) {
			return POSRECORD;
		} else if ("Composite".equals(type)) {
			return COMPOSITE;
		} else if ("".equals(type)) {

		}
		return FIELD;
	}

}


public class Band {
	int nrOfMembers = 0;
	String name;
	Instrument[] bandInstruments;
	Musician[] musicians;

	public Band(String name) {
		this.name = name;
	}
	public void addMusician(Musician musician) {
		this.bandInstruments[nrOfMembers] = musician.getInstrument();
		this.musicians[nrOfMembers] = musician;
		//return musician;
		nrOfMembers++;
	}
	
	public void showMembers() {
		for(nrOfMembers=0;nrOfMembers<5;nrOfMembers++)
			System.out.println(this.musicians[nrOfMembers]+"\n");
	}

	public Instrument[] getMissingIntruments() {
		return this.bandInstruments;
	}

}

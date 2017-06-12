package upward.tajwid.tajwid;

import java.io.Serializable;

public class TajwidSubMenu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -473342006722479022L;
	private String title;
	private int xml;
	private int[] exampleSounds;
	
	protected TajwidSubMenu(String title, int xml){
		this.title = title;
		this.xml = xml;
	}

	public void setExampleSounds(int[] exampleSounds){
		this.exampleSounds = exampleSounds;
	}
	
	public String getTitle() {
		return title;
	}

	public int getXml() {
		return xml;
	}

	public int[] getExampleSounds() {
		return exampleSounds;
	}
}

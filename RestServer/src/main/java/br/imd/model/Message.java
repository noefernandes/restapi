package br.imd.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    public String division;
	public String type;
	public String priority;

    public Message() {}

    public Message(String division, String type, String priority) {
        super();
        this.division = division;
        this.type = type;
        this.priority = priority;
    }

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

    
}
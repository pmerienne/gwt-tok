package com.google.gwt.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateEvent {

	public final static String EVENT_PACKAGE = "com/google/gwt/tok/client/event";

	public static void main(String args[]) {
		init();
	}

	private static void init() {
		System.out.print("Nom de l'évènement : ");
		String eventName = lireString();
		createFile(eventName);
		System.out.println("Evènement " + eventName);
		init();
	}

	private static void createFile(String eventName) {
		String templatePackage = GenerateEvent.class.getPackage().getName().replaceAll("\\.", "/");
		String packageName = EVENT_PACKAGE.replace('/', '.');
		File eventFile;
		eventFile = new File("./src/main/java/" + EVENT_PACKAGE + "/" + eventName + "Event.java");
		if (!eventFile.isFile()) {
			try {
				eventFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File eventTpl = new File("./src/generator/java/" + templatePackage + "/event.tpl");
		try {
			String strEvent = readFileAsString(eventTpl.getPath());

			strEvent = strEvent.replaceAll("##PACKAGE##", packageName);
			strEvent = strEvent.replaceAll("##Event##", eventName);

			BufferedWriter outEvent = new BufferedWriter(new FileWriter(eventFile));
			outEvent.write(strEvent);
			outEvent.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String lireString() {
		String ligne_lue = null;
		try {
			InputStreamReader lecteur = new InputStreamReader(System.in);
			BufferedReader entree = new BufferedReader(lecteur);
			ligne_lue = entree.readLine();
		} catch (IOException err) {
			System.exit(0);
		}
		return ligne_lue;
	}

	private static String readFileAsString(String filePath) throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}
}

import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String studentNames;
	public static Constant constant = new Constant();
	public static String names[];


	public static void Reader(){
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(constant.FileNmae)));
			studentNames = bufferedReader.readLine();
			names = studentNames.split(constant.split);
		} catch(Exception e){

		}
	}

	public static void Write(String updateText){
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(constant.FileNmae, false));
			bufferedWriter.flush();
			bufferedWriter.write(updateText);
			bufferedWriter.close();
		} catch(Exception e) {

		}
	}

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(constant.Invalid);
			System.exit(1);

		}
		if(args[0].equals(constant.showNames)) {
			System.out.println(constant.loadingData);
			Reader();
			for(String name : names) {
				System.out.println(name);
			}
			System.out.println(constant.loadedData);

		} else if(args[0].equals(constant.randomName)) {
			System.out.println(constant.loadingData);
			Reader();
			Random ran = new Random();
			System.out.println(names[ran.nextInt(names.length)]);
			System.out.println(constant.loadedData);

		} else if(args[0].contains(constant.addName)) {
			System.out.println(constant.loadingData);
			Reader();
			studentNames = studentNames + constant.split + args[0].substring(1);
			DateFormat dateFormat = new SimpleDateFormat(constant.dateFormat);
			Write(studentNames + constant.lastUpdate + dateFormat.format(new Date()));
			System.out.println(constant.loadedData);

		} else if(args[0].contains(constant.query)) {
			System.out.println(constant.loadingData);
			Reader();
			for(int idx = 0; idx < names.length; idx++) {
				if(names[idx].equals(args[0].substring(1))) {
					System.out.println(constant.Found);
					break;
				}
			}
			System.out.println(constant.loadedData);

		} else if(args[0].equals(constant.countWords)) {
			System.out.println(constant.loadingData);
			Reader();
			System.out.println(names.length + constant.wordsFound);
			System.out.println(constant.loadedData);

		} else {
			System.out.println(constant.Invalid);
		}
	}
}
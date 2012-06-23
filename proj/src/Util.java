
public class Util {
	
	public static void Error() {
		System.out.println("Invalid Parameter");
		System.out.println(" Usage : java -cp project.jar Driver -f 'setting file' ");
		System.exit(1);
	}
	
	public String argumentParser(String par[]) {
		
		if (par.length == 2) {
			
			if (par[0].toLowerCase().equals("-f") == false) {
				Error();
			}
			else {
				if (par[1].equals("")) {
					Error();
				}
			}
		}
		else {
			Error();
		}
		
		return par[1];
	}
}


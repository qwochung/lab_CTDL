package lab_1_MyArrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	public static final int[] NUMBER = {0,1,2,3,4,5,6,7,8,9};
	
	int n;
	public MyCaesar(int shiftSteps) {
		super();
		this.n = shiftSteps;
	}
	
	
	
	
	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		char result = Character.toUpperCase(c);
		for (int i = 0; i < ALPHABET.length; i++) {
			if (result == ' ') {
				break;
			}
			
			if (result == ALPHABET[i] &&((i+n)>= ALPHABET.length )) {
				result = ALPHABET[(i + n) - ALPHABET.length ];
				break;
			}
			
			if (result == ALPHABET[i]) {
				result = ALPHABET[i + n];
				break;
			}
		}
		return result;
		
		
		
	}
	
	
	
	
	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET array
	
	public char decryptChar(char c) {
		char result = Character.toUpperCase(c);
		for (int i = 0; i < ALPHABET.length; i++) {
			if (result == ' ') {
				break;
			}
			
			if (result == ALPHABET[i] &&((i-n)< 0 ) ) {
				result = ALPHABET[(ALPHABET.length - (n -i)) ];
				break;
			}
			
			if (result == ALPHABET[i]) {
				result = ALPHABET[i- n];
				break;
			}
		}
		return result;
	}
	
	
	
	/*
	 * Task 3 (advanced task): Expanding the problem in Task 3 so that the program can encrypt
and decrypt a given text including numbers and characters.
	 */
	public int encryptInt(int c) {
		int result =c;
		
		for (int i = 0; i < NUMBER.length; i++) {
			
			
			if (result == NUMBER[i] &&((i+n)>= NUMBER.length )) {
				result = NUMBER[(i + n) - NUMBER.length ];
				break;
			}
			
			if (result == NUMBER[i]) {
				result = NUMBER[i + n];
				break;
			}
		}
		
		return result;
	}
	
	
	public int decryptInt(int c) {
		int result = c;
		for (int i = 0; i < NUMBER.length; i++) {
		
			
			if (result == NUMBER[i] &&((i-n)< 0 ) ) {
				result = NUMBER[(NUMBER.length - (n -i)) ];
				break;
			}
			
			if (result == NUMBER[i]) {
				result = NUMBER[i- n];
				break;
			}
		}
		return result;
	}
	
	
	
	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		String result="";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			result += encryptChar(c);
		}
		
		
		
		return result;
	}

	
	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		
		String result="";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			result += decryptChar(c);
		}
		
		
		
		return result;
	}

	

	//Encrypt a given text including numbers and characters.
	public String encryptAvanced(String input) {
		String result="";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isDigit(c)) {
				result += encryptInt(Character.getNumericValue(c)); // có thể dùng c -'0'
			}
			
			else {
				result += encryptChar(c);
			}
			
			
			
			
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	
	//decrypt a given text including numbers and characters.

	public String decryptAvanced(String input) {
		
		String result="";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isDigit(c)) {
				result += decryptInt(c-'0');
			}
			
			else {
				result += decryptChar(c);
			} 
			
			
			
			
		}
		
		
		
		return result;
	}

	
	/*
	 * : Expanding the problem in Task 4 so that the program can encrypt 
	 * and decrypt the text content in a text file using the supported methods for reading and writing
text file.
	 */
	
	
	
	// Encrypt a encrypted the text content in the srcfile and save it into	desFile.
	public void encryptFile(String srcFile, String desFile) throws IOException {
		try {
			FileReader fileReader = new FileReader(srcFile);
			FileWriter fileWriter = new FileWriter(desFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			
			String line;
			while ((line = bufferedReader.readLine())!= null) {
				bufferedWriter.write(encryptAvanced(line));
			}
			
			bufferedReader.close();
			bufferedWriter.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Decrypt a encrypted the text content in the srcfile and save it into desFile.
	public void decryptFile(String srcFile, String desFile) throws IOException {
		
		try {
			FileReader fileReader = new FileReader(srcFile);
			FileWriter fileWriter = new FileWriter(desFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			
			String line;
			while ((line = bufferedReader.readLine())!= null) {
				bufferedWriter.write(decryptAvanced(line));
			}
			
			bufferedReader.close();
			bufferedWriter.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		MyCaesar stepCaesar = new MyCaesar(3);
		
		
		//test encryptChar
		System.out.println(stepCaesar.encryptChar('c'));
		
		// test decryptChar
		System.out.println(stepCaesar.decryptChar('f'));
		
		
		// test encrypt
		
		String encrypt = stepCaesar.encrypt("Tran Quoc Hung ");
		System.out.println(encrypt);
		
		
		// test decrypt
		String  decrypt = stepCaesar.decrypt(encrypt);
		System.out.println(decrypt);

		// test encryptInt
		System.out.println(stepCaesar.encryptInt(9));
		
		
		// test decryptInt
		System.out.println(stepCaesar.decryptInt(1));
		
		
		// test encryptAvanced
		String encryptAvanced = stepCaesar.encryptAvanced("Tran Quoc Hung 0 21 3 ");
		System.out.println(encryptAvanced);
		
		
		// test decryptAvanced
		String decryptAvanced = stepCaesar.decryptAvanced(encryptAvanced);
		System.out.println(decryptAvanced);
		
		
		
		/*
		 * Expanding the problem in Task 4 so that the program can encrypt 
		 * and decrypt a given text including numbers and characters where 
		 * the text is entered fromconsole by users.

		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập dữ liệu : ");
		String intput = sc.nextLine();
		sc.close();
		
		String consoleEncrypt = stepCaesar.encryptAvanced(intput);
		System.out.println("Dữ liệu mã hóa là: " + consoleEncrypt );
		
		String consoleDecrypt = stepCaesar.decryptAvanced(consoleEncrypt);
		System.out.println("Dữ liệu giải mã là: " + consoleDecrypt );
		
		
		
		
		// Encrypt File
		
		String srcFileEn = "D:\\Java\\CTDL\\lab_1_MyArrays\\src\\lab_1_MyArrays\\DataInput.txt";
		String desFileEn = "D:\\Java\\CTDL\\lab_1_MyArrays\\src\\lab_1_MyArrays\\DataEncrypt.txt";
		
		stepCaesar.encryptFile(srcFileEn, desFileEn);
		
		
		// Decrypt File
		String srcFileDe = "D:\\Java\\CTDL\\lab_1_MyArrays\\src\\lab_1_MyArrays\\DataEncrypt.txt";
		String desFileDe = "D:\\Java\\CTDL\\lab_1_MyArrays\\src\\lab_1_MyArrays\\DataDecrypt.txt";
		
		stepCaesar.decryptFile(srcFileDe, desFileDe);

	
	
	}
	
}

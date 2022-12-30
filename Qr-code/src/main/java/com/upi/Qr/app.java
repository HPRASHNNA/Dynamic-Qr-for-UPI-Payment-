package com.upi.Qr;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class app {

	public static void generateQRcode(String data, String path, String charset, Map map, int h, int w)
			throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, w, h);
		MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));

	}

	public static void main(String args[]) throws WriterException, IOException, NotFoundException {

		Scanner scanner = new Scanner(System.in);

		String payeeUPIID = "hariprashnna@okaxis";

		String payeeName = "hari";

		System.out.print("Enter payment amount: ");

		String paymentAmount = scanner.nextLine();

		String paymentCurrency = "INR";

		String paymentDescription = "fee";

		String upi = "upi://pay?pa=" + payeeUPIID + "&pn=" + payeeName + "&am=" + paymentAmount + "&cu="
				+ paymentCurrency + "&tn=" + paymentDescription;

		String path = "C:\\Hari\\Project\\QRDemo\\Quote.png";

		String charset = "UTF-8";
		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

		generateQRcode(upi, path, charset, hashMap, 200, 200);

		System.out.println("QR Code created successfully.");
	}
}

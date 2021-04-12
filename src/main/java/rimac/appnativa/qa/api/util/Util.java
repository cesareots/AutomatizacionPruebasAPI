package rimac.appnativa.qa.api.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import rimac.appnativa.qa.api.model.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {

    private static Util obj = null;

    private Util() {
    }

    public static Util getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new Util();
        }
    }

    public DataDriven getData(String codigo) {
        DataDriven dataDriven = null;
        String[] split = codigo.split("-");
        String excel = split[0];
        String hoja = split[1];
        int fila = Integer.parseInt(split[2]);
        String excelNombre = identificarExcel(excel);
        File file = new File(excelNombre);

        try {
            if (file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                Workbook workbook = WorkbookFactory.create(fileInputStream);
                Sheet sheet = workbook.getSheet(hoja);
                int cantColumnas = getCantColumnas(sheet);
                dataDriven = new DataDriven(codigo);

                for (int i = 1; i < cantColumnas; i++) {
                    String celda = sheet.getRow(fila).getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
                    String[] celdaSplit = celda.split("@#");
                    Map<String, Object> map = new LinkedHashMap<String, Object>();

                    for (int j = 0; j < celdaSplit.length; j++) {
                        String[] keyVal = celdaSplit[j].split("::");
                        map.put(keyVal[0], keyVal[1]);
                    }

                    dataDriven.addMap(map);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return dataDriven;
    }

    private int getCantColumnas(Sheet sheet) {
        int columna = 0;
        boolean flag = false;

        while (!flag) {
            String valor = sheet.getRow(0).getCell(++columna, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

            if ("x".equalsIgnoreCase(valor)) {
                flag = true;
            }
        }

        return columna;
    }

    private String identificarExcel(String excel) {
        String excelNombre = "";

        switch (excel) {
            case "1":
                excelNombre = Constantes.file01;
                break;
            default:
                break;
        }

        return excelNombre;
    }

    public String encryptSHA384(Map<String, Object> map) {
        String hash = "";
        String input = "";

        for (Map.Entry<String, Object> val : map.entrySet()) {
            if (val.getKey().equals("password")) {
                input = val.getValue().toString();
                break;
            }
        }

        //https://www.geeksforgeeks.org/sha-384-hash-in-java/
        try {
            // getInstance() method is called with algorithm SHA-384
            MessageDigest md = MessageDigest.getInstance("SHA-384");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            hash = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return hash;
    }
}

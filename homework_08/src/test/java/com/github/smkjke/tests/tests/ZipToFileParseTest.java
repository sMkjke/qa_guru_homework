package com.github.smkjke.tests.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;




public class ZipToFileParseTest {

    public static final String TEST_FILES_ZIP_PATH = "src/test/resources/";
    public static final String TEST_ZIP_FILE = "testZip.zip";
    ClassLoader cl = ZipToFileParseTest.class.getClassLoader();

    @Test
    void zipToPdfCheckContentTest() throws IOException {
        ZipFile zf = new ZipFile(new File(TEST_FILES_ZIP_PATH + TEST_ZIP_FILE));
        try {
            ZipInputStream is = new ZipInputStream(Objects.requireNonNull(cl.getResourceAsStream(TEST_ZIP_FILE)));
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    try (InputStream inputStream = zf.getInputStream(entry)) {
                        PDF pdf = new PDF(inputStream);
                        assertThat(pdf.creator).isEqualTo("Rave (http://www.nevrona.com/rave)");
                    }
                }
            }
        } finally {
            zf.close();
        }
    }

    @Test
    void zipToCsvCheckContentTest() throws IOException, CsvException {
        ZipFile zf = new ZipFile(new File(TEST_FILES_ZIP_PATH + TEST_ZIP_FILE));
        try {
            ZipInputStream is = new ZipInputStream(Objects.requireNonNull(cl.getResourceAsStream(TEST_ZIP_FILE)));
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().contains(".csv")) {
                    try (InputStream inputStream = zf.getInputStream(entry)) {
                        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
                        List<String[]> content = reader.readAll();
                        String[] row = content.get(0);
                        String expectedText = row[1];
                        assertThat(expectedText).isEqualTo("LatM");
                    }
                }
            }
        } finally {
            zf.close();
        }
    }

    @Test
    void zipToXlsCheckContentTest() throws IOException {
        ZipFile zf = new ZipFile(new File(TEST_FILES_ZIP_PATH + TEST_ZIP_FILE));
        try {
            ZipInputStream is = new ZipInputStream(Objects.requireNonNull(cl.getResourceAsStream(TEST_ZIP_FILE)));
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().contains(".xls")) {
                    try (InputStream inputStream = zf.getInputStream(entry)) {
                        XLS xls = new XLS(inputStream);
                        System.out.println(" ");
                        assertThat(xls.excel
                                .getSheetAt(0)
                                .getRow(5)
                                .getCell(3)
                                .getStringCellValue())
                                .isEqualTo("Female");
                    }
                }
            }
        } finally {
            zf.close();
        }
    }
}

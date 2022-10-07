package psidev.psi.pi.validator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Class for unpacking a zipped file.
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */
public class ArchiveUnpacker {
    /**
     * Constants
     */
    private static final Logger LOGGER = LogManager.getLogger(ArchiveUnpacker.class);
    private static final int BUF_SIZE = 4096;

    /**
     * unGZip a file.
     * @param gzipFile      the .gzip file
     * @param unzippedFile  the unzipped file
     */
    public static void unGzipFile(String gzipFile, String unzippedFile) {
        byte[] buffer = new byte[BUF_SIZE];

        try {
            FileOutputStream out;
            try (GZIPInputStream gzipIS = new GZIPInputStream(Files.newInputStream(Paths.get(gzipFile)))) {
                out = new FileOutputStream(unzippedFile);
                int len;
                while ((len = gzipIS.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            }
           out.close();
        }
        catch(IOException exc) {
            exc.printStackTrace(System.err);   
        }
    }

    /**
     * unZip a file.
     * @param zipFile       the .zip file
     * @param unzippedFile  the unzipped file
     */
    public static void unZipFile(String zipFile, String unzippedFile) {
        byte[] buffer = new byte[BUF_SIZE];

        try {
            FileOutputStream out;
            try (ZipInputStream zipIS = new ZipInputStream(Files.newInputStream(Paths.get(zipFile)))) {
                out = new FileOutputStream(unzippedFile);
                int len;
                while ((len = zipIS.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            }
           out.close();
        }
        catch(IOException exc) {
            exc.printStackTrace(System.err);   
        }
    }
    
    /**
     * Decompress a .7z file
     * @param seven_zFile   the .7z file
     * @param unzippedFile the unzipped file
     */
    public static void decompress7zFile(String seven_zFile, String unzippedFile) {
        LOGGER.debug("Support for .7z files not yet implemented");
    }
}

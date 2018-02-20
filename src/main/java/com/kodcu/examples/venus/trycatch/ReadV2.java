package com.kodcu.examples.venus.trycatch;

import java.io.*;

public class ReadV2 {

    private final static int BUFFER_SIZE = 1000;

    static void copy(String src, String dst) throws IOException {

        InputStream in = new FileInputStream(src);

        try {

            OutputStream out = new FileOutputStream(dst);

            try {

                byte[] buf = new byte[BUFFER_SIZE];

                int n;

                while ((n = in.read(buf)) >= 0)

                    out.write(buf, 0, n);

            } finally {

                out.close();

            }

        } finally {

            in.close();

        }

    }


}
